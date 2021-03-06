package com.s3group.tmsapi.parcel.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.s3group.tmsapi.common.upserrors.UpsErrorResponse;
import com.s3group.tmsapi.parcel.entities.request.ParcelRequest;
import com.s3group.tmsapi.parcel.entities.request.ParcelRequestHistory;
import com.s3group.tmsapi.parcel.entities.response.ParcelResponse;
import com.s3group.tmsapi.parcel.entities.response.ParcelResponseHistory;

import com.s3group.tmsapi.parcel.repo.ParcelRequestHistoryRepository;
import com.s3group.tmsapi.parcel.repo.ParcelRequestRepository;
import com.s3group.tmsapi.parcel.repo.ParcelResponseHistoryRepository;
import com.s3group.tmsapi.parcel.repo.ParcelResponseRepository;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;

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

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParcelRequestService {
  @Value("${UPS_BASE_URL_SHIPMENTS}")
  private String uPSBaseUrlShipments;

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

  @Value("${UPS_ACCEPT}")
  private String uPSAccept;

  @Autowired
  private WebClient.Builder webClientBuilder;

  @Autowired
  ParcelRequestRepository parcelRequestRepository;

  @Autowired
  ParcelResponseRepository parcelResponseRepository;

  @Autowired
  private ParcelResponseHistoryRepository parcelResponseHistoryRepository;

  @Autowired
  private ParcelRequestHistoryRepository parcelRequestHistoryRepository;

  public ParcelResponseHistory ship(ParcelRequest parcelRequest,
                                    String transId) throws JsonProcessingException {
    ParcelResponseHistory parcelResponseHistory = parcelResponseHistoryRepository.findByTransactionId(transId);

    if (parcelResponseHistory != null) {
      return parcelResponseHistory;
    }

    parcelRequestRepository.save(parcelRequest);

    final RestTemplate restTemplate = new RestTemplate();
    final HttpHeaders headers = new HttpHeaders();
    headers.set("Username", uPSUserName);
    headers.set("Password", uPSPassword);
    headers.set("AccessLicenseNumber", uPSApiKey);
    headers.set("transactionSrc", uPSTransactionSource);
    headers.set("transId", transId);
    headers.set("Content-Type", uPSContentType);
    headers.set("Accept", uPSAccept);

    final HttpEntity<ParcelRequest> request =
        new HttpEntity<>(parcelRequest, headers);

    ParcelRequestHistory parcelRequestHistory = new ParcelRequestHistory(transId, parcelRequest.getShipmentRequest());
    parcelRequestHistoryRepository.save(parcelRequestHistory);

    try {
      ResponseEntity<ParcelResponse> parcelResponse =
          restTemplate.exchange(uPSBaseUrlShipments, HttpMethod.POST, request,
              ParcelResponse.class);
      ParcelResponse response = parcelResponse.getBody();
      parcelResponseRepository.save(response);
      return parcelResponseHistoryRepository.save(new ParcelResponseHistory(transId, null,
          response.getShipmentResponse()));
    } catch (HttpClientErrorException e) {
      ObjectMapper mapper =
          new ObjectMapper().configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
      UpsErrorResponse response = mapper.readValue(e.getResponseBodyAsString(), UpsErrorResponse.class);
      return parcelResponseHistoryRepository.save(new ParcelResponseHistory(transId, response, null));
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
                                          String htmlFileName) {
    File file = new File(htmlFileName);

    try (OutputStream os = new FileOutputStream(file)) {
      os.write(htmlBytes);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}