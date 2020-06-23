package com.s3group.tmsapi.common.controller;

import com.s3group.tmsapi.common.entities.Shipper;
import com.s3group.tmsapi.common.errors.ShipperNumberNotFound;
import com.s3group.tmsapi.common.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author : Thamilarasi
 * @version : 1.0
 */
@RestController
public class ShipperController {
  @Autowired
  private ShipperService shipperService;

  @PostMapping("/shipper/search")
  public Optional<Shipper> get(@RequestBody Shipper shipper) throws ShipperNumberNotFound {
    return shipperService.getShipper(shipper);
  }
}