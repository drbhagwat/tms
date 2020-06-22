package com.s3group.tmsapi.parcel.controller;

import com.s3group.tmsapi.parcel.service.ShipmentChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Thamilarasi
 * @version : 1.0
 */
@RestController
public class ShipmentChargeController {

  @Autowired
  private ShipmentChargeService shipmentChargeService;

  @GetMapping("/shipmentChargeTypes/getAll")
  public List<String> getAll() {
    return shipmentChargeService.getAll();
  }
}