package com.s3group.tmsapi.common.controller;

import com.s3group.tmsapi.common.entities.Shipper;
import com.s3group.tmsapi.common.errors.ShipperNumberNotFound;
import com.s3group.tmsapi.common.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Thamilarasi
 * @version : 1.0
 */
@RestController
public class ShipperController {
  @Autowired
  private ShipperService shipperService;

  @GetMapping("/shipper/search/{shipperNumber}")
  public Shipper get(@PathVariable String shipperNumber) throws ShipperNumberNotFound {
    return shipperService.getShipper(shipperNumber);
  }
}