package com.s3group.tmsapi.common.controller;

import com.s3group.tmsapi.common.entities.Phone;
import com.s3group.tmsapi.common.entities.ShipFrom;
import com.s3group.tmsapi.common.errors.ShipFromPhoneNumberNotFound;
import com.s3group.tmsapi.common.service.ShipFromService;
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
public class ShipFromController {
  @Autowired
  private ShipFromService shipFromService;

  @PostMapping("/shipFrom/search")
  public Optional<ShipFrom> get(@RequestBody Phone phone) throws ShipFromPhoneNumberNotFound {
    return shipFromService.get(phone);
  }
}