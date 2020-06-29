package com.s3group.tmsapi.common.controller;

import com.s3group.tmsapi.common.entities.ShipFrom;
import com.s3group.tmsapi.common.errors.ShipFromPhoneNumberNotFound;
import com.s3group.tmsapi.common.service.ShipFromService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Thamilarasi
 * @version : 1.0
 */
@RestController
public class ShipFromController {
  @Autowired
  private ShipFromService shipFromService;

  @GetMapping("/shipFrom/search/{shipFromPhoneNumber}")
  public ShipFrom get(@PathVariable String shipFromPhoneNumber) throws ShipFromPhoneNumberNotFound {
    return shipFromService.get(shipFromPhoneNumber);
  }
}