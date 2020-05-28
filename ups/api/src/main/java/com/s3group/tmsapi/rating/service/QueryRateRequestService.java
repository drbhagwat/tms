package com.s3group.tmsapi.rating.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.s3group.tmsapi.common.upserrors.UpsErrorResponse;
import com.s3group.tmsapi.rating.entity.QueryRateRequest;
import com.s3group.tmsapi.rating.entity.QueryRateRequestHistory;
import com.s3group.tmsapi.rating.entity.QueryRateResponse;
import com.s3group.tmsapi.rating.entity.QueryRateResponseHistory;
import com.s3group.tmsapi.rating.repo.QueryRateRequestHistoryRepository;
import com.s3group.tmsapi.rating.repo.QueryRateRequestRepository;
import com.s3group.tmsapi.rating.repo.QueryRateResponseHistoryRepository;
import com.s3group.tmsapi.rating.repo.QueryRateResponseRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public class QueryRateRequestService {
  @Value("${UPS_BASE_URL_RATING_SHOP_REQUEST}")
  private String uPSBaseUrlRatingShopRequest;

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
  QueryRateRequestRepository queryRateRequestRepository;

  @Autowired
  QueryRateResponseRepository queryRateResponseRepository;

  @Autowired
  QueryRateRequestHistoryRepository queryRateRequestHistoryRepository;

  @Autowired
  QueryRateResponseHistoryRepository queryRateResponseHistoryRepository;

  @Autowired
  private WebClient.Builder webClientBuilder;

  public QueryRateResponseHistory shop(QueryRateRequest queryRateRequest,
                                       String transId) throws JsonProcessingException {
    QueryRateResponseHistory queryRateResponseHistory = queryRateResponseHistoryRepository.findByTransactionId(transId);

    if (queryRateResponseHistory != null) {
      return queryRateResponseHistory;
    }

    queryRateRequestRepository.save(queryRateRequest);

    final RestTemplate restTemplate = new RestTemplate();
    final HttpHeaders headers = new HttpHeaders();
    headers.set("Username", uPSUserName);
    headers.set("Password", uPSPassword);
    headers.set("AccessLicenseNumber", uPSApiKey);
    headers.set("transactionSrc", uPSTransactionSource);
    headers.set("transId", transId);
    headers.set("Content-Type", uPSContentType);
    headers.set("Accept", uPSAccept);

    final HttpEntity<QueryRateRequest> httpRequest =
        new HttpEntity<>(queryRateRequest, headers);

    QueryRateRequestHistory queryRateRequestHistory = new QueryRateRequestHistory(transId, queryRateRequest.getRateRequest());
    queryRateRequestHistoryRepository.save(queryRateRequestHistory);

    try {
      ResponseEntity<QueryRateResponse> queryRateResponse =
          restTemplate.exchange(uPSBaseUrlRatingShopRequest, HttpMethod.POST, httpRequest,
              QueryRateResponse.class);
      QueryRateResponse response = queryRateResponse.getBody();
      queryRateResponseRepository.save(response);
      return queryRateResponseHistoryRepository.save(new QueryRateResponseHistory(transId, null,
          response.getRateResponse()));
    } catch (HttpClientErrorException e) {
      ObjectMapper mapper =
          new ObjectMapper().configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
      UpsErrorResponse response = mapper.readValue(e.getResponseBodyAsString(), UpsErrorResponse.class);
      return queryRateResponseHistoryRepository.save(new QueryRateResponseHistory(transId, response, null));
    }
  }
}