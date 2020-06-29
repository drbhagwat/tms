package com.s3group.tmsapi.common.controller;

import com.s3group.tmsapi.parcel.entities.UpsParameter;
import com.s3group.tmsapi.common.service.UpsParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Thamilarasi
 * @version : 1.0
 */
@RestController
public class UpsParameterController {

  @Autowired
  private UpsParameterService upsParameterService;

  @GetMapping("/getUPSParameters")
  public UpsParameter getAll() {

    return upsParameterService.getAllUpsParameters();
  }
}