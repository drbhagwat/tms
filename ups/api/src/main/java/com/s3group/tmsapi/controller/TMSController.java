package com.s3group.tmsapi.controller;


import com.s3group.tmsapi.service.TMSClientService;
import com.s3group.tmsapi.entities.request.ParcelRequest;
import com.s3group.tmsapi.entities.response.ParcelResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class TMSController {
  private static final Logger logger =
      LoggerFactory.getLogger(TMSController.class);

  @Autowired
  private TMSClientService tmsClientService;

  @PostMapping("/shipments")
  public Mono<ParcelResponse> getShipmentTypeInfo(@RequestBody @Valid ParcelRequest parcelRequest) throws IOException {
    return tmsClientService.ship(parcelRequest);
  }

  @ExceptionHandler(WebClientResponseException.class)
  public ResponseEntity<String> handleWebClientResponseException(WebClientResponseException ex) {
    logger.error("Error from WebClient - Status {}, Body {}",
        ex.getRawStatusCode(),
        ex.getResponseBodyAsString(), ex);
    return ResponseEntity.status(ex.getRawStatusCode()).body(ex.getResponseBodyAsString());
  }
}
