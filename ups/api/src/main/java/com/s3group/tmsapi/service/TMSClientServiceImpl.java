package com.s3group.tmsapi.service;


import model.request.ParcelRequest;
import model.response.ParcelResponse;
import model.response.PackageResults;
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

  private ParcelRequest globalRequest = new ParcelRequest();

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
  public Mono<ParcelResponse> ship(ParcelRequest request) throws IOException {
    Mono<ParcelResponse> globalResponse = webClient.post()
        .uri("/ship/v1801/shipments")
        .syncBody(globalRequest)
        .retrieve()
        .bodyToMono(ParcelResponse.class);

    ParcelResponse tempParcelResponse = globalResponse.block();

    List<PackageResults> packageResults =
        tempParcelResponse.getShipmentResponse().getShipmentResults().getPackageResults();

    int size = packageResults.size();

    for (int i = 0; i < size; i++) {
      String base64 =
          packageResults.get(i).getShippingLabel().getGraphicImage();
      byte[] base64Val = convertToImg(base64);

      String imageFormat = getImageFormat(request);
      String image = null;

      // according to the type of the image, init the right extension
      switch (imageFormat) {
        case "ZPL": {
          image = "image" + i + ".zpl";
          break;
        }
        default: {
          image = "image" + i + ".gif";
          break;
        }
      }
      writeBytesToImageFile(base64Val, image);

      base64 =
          packageResults.get(i).getShippingLabel().getHTMLImage();
      base64Val = convertToImg(base64);
      String text = "text" + i + ".html";
      writeBytesToHtmlFile(base64Val, text);
    }
    return globalResponse;
  }

  public static String getImageFormat(ParcelRequest request) {
    return request.getShipmentRequest().getLabelSpecification().getLabelImageFormat().getCode().toUpperCase();
  }

  public static byte[] convertToImg(String base64) throws IOException {
    return Base64.decodeBase64(base64);
  }

  public static void writeBytesToImageFile(byte[] imgBytes,
                                           String imgFileName) throws IOException {
    File imgFile = new File(imgFileName);
    BufferedImage img = ImageIO.read(new ByteArrayInputStream(imgBytes));
    String extension = imgFileName.substring(imgFileName.indexOf('.') + 1);
    ImageIO.write(img, extension, imgFile);
  }

  public static void writeBytesToHtmlFile(byte[] htmlBytes,
                                          String htmlFileName) throws IOException {
    File file = new File(htmlFileName);
    OutputStream os = new FileOutputStream(file);
    os.write(htmlBytes);
  }
}