package com.s3group.tmsapi.rating.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.s3group.tmsapi.common.entities.DateAndTime;
import com.s3group.tmsapi.common.upserrors.UpsErrorResponse;
import com.s3group.tmsapi.rating.entity.*;
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

import java.util.ArrayList;
import java.util.List;

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
                                       String transId, String criteria) throws JsonProcessingException {
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
      // following is the ups response
      QueryRateResponse upsQueryRateResponse = queryRateResponse.getBody();
      RateResponse rateResponse = upsQueryRateResponse.getRateResponse();
      // process that response based on the criteria
      processQueryResponse(rateResponse, criteria);
      queryRateResponseRepository.save(upsQueryRateResponse);
      return queryRateResponseHistoryRepository.save(new QueryRateResponseHistory(transId, null,
          rateResponse));
    } catch (HttpClientErrorException e) {
      ObjectMapper mapper =
          new ObjectMapper().configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
      UpsErrorResponse response = mapper.readValue(e.getResponseBodyAsString(), UpsErrorResponse.class);
      return queryRateResponseHistoryRepository.save(new QueryRateResponseHistory(transId, response, null));
    }
  }

  private RateResponse processQueryResponse(final RateResponse rateResponse, String criteria) {
    // copy it as it is first and work on the copy
    RateResponse savedRateRespone = rateResponse;
    List<RatedShipment> savedRatedShipments = rateResponse.getRatedShipments();

    switch (criteria) {
      case "cost":
        savedRateRespone.setRatedShipments(processForLeastCost(savedRatedShipments));
        break;
      case "time":
        savedRateRespone.setRatedShipments(processForFastestDuration(savedRatedShipments));
        break;
      case "costandtime":
        break;
      default:
        break;
    }
    return savedRateRespone;
  }

  private List<RatedShipment> processForLeastCost(List<RatedShipment> ratedShipments) {
    List<RatedShipment> leastCostRatedShipment = new ArrayList<>();
    RatedShipment firstRatedShipment = ratedShipments.get(0);
    // assign first element of the list
    leastCostRatedShipment.add(firstRatedShipment);
    // assume it to be the least cost
    Double leastCost = Double.parseDouble(firstRatedShipment.getTotalCharges().getMonetaryValue());

    int size = ratedShipments.size();
    int j = 0;

    for (int i = 1; i < size; i++) {
      RatedShipment currentRatedShipment = ratedShipments.get(i);
      Double currentCost = Double.parseDouble(currentRatedShipment.getTotalCharges().getMonetaryValue());

      if (currentCost < leastCost) {
        leastCost = currentCost;
        leastCostRatedShipment.set(j, currentRatedShipment);
      } else {
        if (currentCost > leastCost) {
          ; // don't do anything
        } else { // the two are equal
          leastCostRatedShipment.add(++j, currentRatedShipment);
        }
      }
    }
    return leastCostRatedShipment;
  }

  private List<RatedShipment> processForFastestDuration(List<RatedShipment> ratedShipments) {
    List<RatedShipment> fastestDeliveryRatedShipment = new ArrayList<>();
    RatedShipment firstRatedShipment = ratedShipments.get(0);
    fastestDeliveryRatedShipment.add(firstRatedShipment);

    // initialize fastestDateAndTime with the first element of the List
    DateAndTime fastestDateAndTime = new DateAndTime(firstRatedShipment.getGuaranteedDelivery());

    int size = ratedShipments.size();
    int j = 0;

    for (int i = 1; i < size; i++) {
      RatedShipment currentRatedShipment = ratedShipments.get(i);
      Double currentDaysInTransit = Double.parseDouble(currentRatedShipment.getGuaranteedDelivery().getBusinessDaysInTransit());
      String currentDeliveryTime = currentRatedShipment.getGuaranteedDelivery().getDeliveryByTime();

      if (currentDaysInTransit < fastestDateAndTime.getDaysInTransit()) {
        fastestDateAndTime.init(currentRatedShipment.getGuaranteedDelivery());
        fastestDeliveryRatedShipment.set(j, currentRatedShipment);
      } else {
        if (currentDaysInTransit > fastestDateAndTime.getDaysInTransit()) {
          ;
        } else {
          // currentDaysInTransit and fastestDaysInTransit are the same.
          if (currentDeliveryTime == null) {

            if (fastestDateAndTime.getDeliveryTime() == null) {
              // transit days are same and times are same
              fastestDeliveryRatedShipment.add(++j, currentRatedShipment);
            } else {
              fastestDateAndTime.init(currentDeliveryTime);
              // transit days are same but currentDeliveryTime is quicker
              fastestDeliveryRatedShipment.set(j, currentRatedShipment);
            }
          } else {

            if (fastestDateAndTime.getDeliveryTime() == null) {
              ; // current is slower so nothing to do
            } else {
              String currentAmOrPm = currentDeliveryTime.substring(currentDeliveryTime.indexOf(" ") + 1);

              if (currentAmOrPm.compareTo(fastestDateAndTime.getAmOrPm()) < 0) {
                // current is A.M. and fastest is P.M.
                fastestDateAndTime.init(currentDeliveryTime);
                fastestDeliveryRatedShipment.set(j, currentRatedShipment);
              } else {
                if (currentAmOrPm.compareTo(fastestDateAndTime.getAmOrPm()) > 0) {
                  // current is P.M. and fastest is A.M.
                  ;
                } else {
                  // both current and fastest are same (either both are A.M. or both are P.M.)
                  String temp = currentDeliveryTime.substring(0, currentDeliveryTime.indexOf(" "))
                      .replace(':', '.');
                  Double currentHours = Double.parseDouble(temp);

                  if (currentHours < fastestDateAndTime.getHours()) {
                    fastestDateAndTime.init(currentDeliveryTime);
                    fastestDeliveryRatedShipment.set(j, currentRatedShipment);
                  } else {
                    if (currentHours > fastestDateAndTime.getHours()) {
                      ; // current is slower so nothing to do
                    } else {
                      fastestDateAndTime.init(currentDeliveryTime);
                      fastestDeliveryRatedShipment.set(j, currentRatedShipment);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return fastestDeliveryRatedShipment;
  }
}