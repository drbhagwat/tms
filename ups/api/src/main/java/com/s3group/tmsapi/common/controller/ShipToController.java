package com.s3group.tmsapi.common.controller;

import com.s3group.tmsapi.common.entities.ShipTo;
import com.s3group.tmsapi.common.errors.ShipToPhoneNumberNotFound;
import com.s3group.tmsapi.common.service.ShipToService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Thamilarasi
 * @version : 1.0
 */
@RestController
public class ShipToController {
  @Autowired
  private ShipToService shipToService;

  @GetMapping("/shipTo/search/{shipToPhoneNumber}")
  public ShipTo get(@PathVariable String shipToPhoneNumber) throws ShipToPhoneNumberNotFound {
    return shipToService.get(shipToPhoneNumber);
  }
}