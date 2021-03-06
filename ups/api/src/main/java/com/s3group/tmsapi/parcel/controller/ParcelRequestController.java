package com.s3group.tmsapi.parcel.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.s3group.tmsapi.parcel.entities.request.ParcelRequest;
import com.s3group.tmsapi.parcel.entities.response.ParcelResponseHistory;
import com.s3group.tmsapi.parcel.service.ParcelRequestService;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class ParcelRequestController {
  @Autowired
  private ParcelRequestService parcelRequestService;

  @PostMapping(
      value = "/shipments", consumes = "application/json",
      produces = "application/json")
  public ParcelResponseHistory ship(@RequestHeader("transId") String transId,
                                    @RequestBody @Valid ParcelRequest parcelRequest) throws JsonProcessingException {
    return parcelRequestService.ship(parcelRequest, transId);
  }
}
