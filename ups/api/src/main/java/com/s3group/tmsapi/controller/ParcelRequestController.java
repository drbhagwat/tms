package com.s3group.tmsapi.controller;


import com.s3group.tmsapi.entities.request.ParcelRequest;
import com.s3group.tmsapi.entities.response.ParcelResponseHistory;
import com.s3group.tmsapi.service.ParcelRequestService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ParcelRequestController {
  @Autowired
  private ParcelRequestService parcelRequestService;

  @PostMapping(
      value = "/shipments", consumes = "application/json",
      produces = "application/json")
  public ParcelResponseHistory ship(@RequestBody @Valid ParcelRequest parcelRequest) {
    return parcelRequestService.ship(parcelRequest);
  }
}
