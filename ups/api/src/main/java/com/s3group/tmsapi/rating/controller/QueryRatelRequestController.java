package com.s3group.tmsapi.rating.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.s3group.tmsapi.rating.entity.QueryRateRequest;
import com.s3group.tmsapi.rating.entity.QueryRateResponseHistory;
import com.s3group.tmsapi.rating.service.QueryRateRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping()
public class QueryRatelRequestController {
  @Autowired
  private QueryRateRequestService queryRateRequestService;

  @PostMapping(
      value = "/rating/shop", consumes = "application/json",
      produces = "application/json")
  public QueryRateResponseHistory shop(@RequestHeader("transId") String transId,
                                       @RequestBody @Valid QueryRateRequest queryRateRequest,
                                       @RequestParam String criteria) throws JsonProcessingException {

    QueryRateResponseHistory queryRateResponseHistory = queryRateRequestService.shop(queryRateRequest, transId, criteria);
    return queryRateResponseHistory;
  }
}
