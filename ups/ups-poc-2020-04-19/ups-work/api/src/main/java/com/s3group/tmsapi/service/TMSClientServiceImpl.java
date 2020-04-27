package com.s3group.tmsapi.service;

import model.common.UnitOfMeasurement;
import model.request.*;
import model.response.GlobalResponse;
import model.response.PackageResultsElement;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

@Service
public class TMSClientServiceImpl implements TMSClientService {
  private static final String UPS_BASE_URL = "https://wwwcie.ups.com";
  private static final String UPS_CONTENT_TYPE = "application/json";
  private static final String UPS_USERNAME = "vboopathi";
  private static final String UPS_PASSWORD = "vb20UPS@s3";
  private static final String UPS_API_KEY = "CD7C3B41BB827C51";
  private static final String UPS_TRANSACTION_SOURCE = "S3GTest";
  private static final String UPS_TRANSACTION_ID = "s3gTrnx001";
  private static final String UPS_ACCEPT = "application/xml";

  private final WebClient webClient;

  private GlobalRequest globalRequest = new GlobalRequest();

  public TMSClientServiceImpl(WebClient.Builder webClientBuilder) {
    webClient = webClientBuilder.baseUrl(UPS_BASE_URL)
        .defaultHeaders(httpHeaders -> {
          httpHeaders.add("Content-Type", UPS_CONTENT_TYPE);
          httpHeaders.add("Username", UPS_USERNAME);
          httpHeaders.add("Password", UPS_PASSWORD);
          httpHeaders.add("AccessLicenseNumber", UPS_API_KEY);
          httpHeaders.add("transactionSrc", UPS_TRANSACTION_SOURCE);
          httpHeaders.add("transID", UPS_TRANSACTION_ID);
          httpHeaders.add("Accept", UPS_ACCEPT);
        })
        .build();
  }

  @Override
  public Mono<GlobalResponse> ship(ShipTo shipTo) throws IOException {
    globalRequest.getShipmentRequest().getShipment().setShipTo(shipTo);
    globalRequest.getShipmentRequest().getShipment().getPackageElements().add(new PackageElement("International Goods", new Packaging("02"), new PackageWeight(new UnitOfMeasurement("LBS"), "10"), ""));
    globalRequest.getShipmentRequest().getShipment().getPackageElements().add(new PackageElement("International Goods", new Packaging("02"), new PackageWeight(new UnitOfMeasurement("LBS"), "20"), ""));

    Mono<GlobalResponse> globalResponse = webClient.post()
        .uri("/ship/v1/shipments")
        .syncBody(globalRequest)
        .retrieve()
        .bodyToMono(GlobalResponse.class);

    GlobalResponse tempGlobalResponse = globalResponse.block();

    List<PackageResultsElement> packageResultsElement =
        tempGlobalResponse.getShipmentResponse().getShipmentResults().getPackageResultsElement();

    int size = packageResultsElement.size();

    for (int i = 0; i < size; i++) {
      String base64 =
          packageResultsElement.get(i).getShippingLabel().getGraphicImage();
      byte[] base64Val = convertToImg(base64);
      String image = "image" + i + ".png";
      writeByteToImageFile(base64Val, image);

      base64 =
          packageResultsElement.get(i).getShippingLabel().getHTMLImage();
      base64Val = convertToImg(base64);
      String text = "text" + i + ".html";
      writeByteToHtmlFile(base64Val, text);
    }
    return globalResponse;
  }

  public static byte[] convertToImg(String base64) throws IOException {
    return Base64.decodeBase64(base64);
  }

  public static void writeByteToImageFile(byte[] imgBytes,
                                          String imgFileName) throws IOException {
    File imgFile = new File(imgFileName);
    BufferedImage img = ImageIO.read(new ByteArrayInputStream(imgBytes));
    ImageIO.write(img, "png", imgFile);
  }

  public static void writeByteToHtmlFile(byte[] htmlBytes,
                                          String htmlFileName) throws IOException {
    File file = new File(htmlFileName);
    OutputStream  os = new FileOutputStream(file);
    // Starts writing the bytes in it
    os.write(htmlBytes);
  }
}