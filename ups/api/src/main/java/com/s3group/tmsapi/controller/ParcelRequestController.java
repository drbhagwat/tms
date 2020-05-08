package com.s3group.tmsapi.controller;


import com.s3group.tmsapi.entities.request.ParcelRequest;
import com.s3group.tmsapi.entities.response.ParcelResponse;
import com.s3group.tmsapi.service.ParcelRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class ParcelRequestController {
  @Autowired
  private ParcelRequestService parcelRequestService;

  @PostMapping("/shipments")
  public Mono<ParcelResponse> ship(@RequestBody @Valid ParcelRequest parcelRequest) throws IOException {
    Mono<ParcelResponse> junk = parcelRequestService.ship(parcelRequest);
    return junk;
  }

  @ExceptionHandler(WebClientException.class)
  public ResponseEntity<String> handleWebClientResponseException(WebClientResponseException ex) {
    int getRawStatus = ex.getRawStatusCode();
    String responseBody = ex.getResponseBodyAsString();
    ResponseEntity<String> junk = ResponseEntity.status(ex.getRawStatusCode()).body(ex.getResponseBodyAsString());
    return junk;
  }
}
