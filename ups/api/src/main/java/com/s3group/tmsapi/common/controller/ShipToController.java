package com.s3group.tmsapi.common.controller;

import com.s3group.tmsapi.common.entities.Phone;
import com.s3group.tmsapi.common.entities.ShipTo;
import com.s3group.tmsapi.common.errors.ShipToPhoneNumberNotFound;
import com.s3group.tmsapi.common.service.ShipToService;
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
public class ShipToController {
  @Autowired
  private ShipToService shipToService;

  @PostMapping("/shipTo/get")
  public Optional<ShipTo> get(@RequestBody Phone phone) throws ShipToPhoneNumberNotFound {
    return shipToService.get(phone);
  }
}