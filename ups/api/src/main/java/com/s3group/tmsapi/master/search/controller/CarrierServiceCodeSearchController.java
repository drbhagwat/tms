package com.s3group.tmsapi.master.search.controller;

import com.s3group.tmsapi.master.entities.CarrierPackageCode;
import com.s3group.tmsapi.master.entities.CarrierServiceCode;
import com.s3group.tmsapi.master.search.entity.CarrierPackageCodeSearchCriteria;
import com.s3group.tmsapi.master.search.entity.CarrierServiceCodeSearchCriteria;
import com.s3group.tmsapi.master.search.services.CarrierPackageCodeSearchService;
import com.s3group.tmsapi.master.search.services.CarrierServiceCodeSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Thamilarasi
 * @since : 2020-06-08
 */
@RestController
public class CarrierServiceCodeSearchController {
  @Autowired
  private CarrierServiceCodeSearchService carrierServiceCodeSearchService;

  @PostMapping("/carrierservicecodesearch")
  public Page<CarrierServiceCode> search(@RequestBody CarrierServiceCodeSearchCriteria carrierServiceCodeSearchCriteria, @RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "lastUpdatedDateTime") String sortBy, @RequestParam(defaultValue = "D") String orderBy) {
    return carrierServiceCodeSearchService.search(carrierServiceCodeSearchCriteria, pageNo, pageSize, sortBy, orderBy);
  }
}