package com.s3group.tmsapi.service;

import com.s3group.tmsapi.entities.request.ParcelRequest;
import com.s3group.tmsapi.entities.response.ParcelResponse;
import com.s3group.tmsapi.repo.ParcelRequestRepository;
import com.s3group.tmsapi.repo.ParcelResponseRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParcelRequestService {
  @Value("${UPS_BASE_URL}")
  private String uPSBaseUrl;

  @Value("${UPS_CONTENT_TYPE}")
  private String uPSContentType;

  @Value("${UPS_USERNAME}")
  private String uPSUserName;

  @Value("${UPS_PASSWORD}")
  private String uPSPassword;

  @Value("${UPS_API_KEY}")
  private String uPSApiKey;

  @Value("${UPS_TRANSACTION_SOURCE}")
  private String uPSTransactionSource;

  @Value("${UPS_TRANSACTION_ID}")
  private String uPSTransactionId;

  @Value("${UPS_ACCEPT}")
  private String uPSAccept;

  @Autowired
  private WebClient.Builder webClientBuilder;

  @Autowired
  ParcelRequestRepository parcelRequestRepository;

  @Autowired
  ParcelResponseRepository parcelResponseRepository;

  public String ship(ParcelRequest parcelRequest) {
    parcelRequestRepository.save(parcelRequest);

    final RestTemplate restTemplate = new RestTemplate();
    final HttpHeaders headers = new HttpHeaders();
    final String baseUrl = "https://wwwcie.ups.com/ship/v1801/shipments";
    headers.set("Username", uPSUserName);
    headers.set("Password", uPSPassword);
    headers.set("AccessLicenseNumber", uPSApiKey);
    headers.set("transactionSrc", uPSTransactionSource);
    headers.set("transID", uPSTransactionId);
    final HttpEntity<ParcelRequest> request = new HttpEntity<>(parcelRequest,
        headers);

    try {
      ResponseEntity<ParcelResponse> parcelResponse =
          restTemplate.exchange(baseUrl,
              HttpMethod.POST, request, ParcelResponse.class);
      parcelResponseRepository.save(parcelResponse.getBody());
      return parcelResponse.getBody().toString();
    } catch (HttpClientErrorException httpClientErrorException ) {
      return httpClientErrorException.getResponseBodyAsString();
    }
  }

/*
    List<PackageResults> packageResults =
        tempParcelResponse.getShipmentResponse().getShipmentResults()
        .getPackageResults();

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
*/

 /* public static String getImageFormat(ParcelRequest request) {
    return request.getShipmentRequest().getLabelSpecification()
    .getLabelImageFormat().getCode().toUpperCase();
  }*/

  public static byte[] convertToImg(String base64) {
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

    try (OutputStream os = new FileOutputStream(file)) {
      os.write(htmlBytes);
    }
  }
}