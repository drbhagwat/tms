package com.s3group.tmsapi.search.controller;

import com.s3group.tmsapi.parcel.entities.request.ParcelRequestHistory;
import com.s3group.tmsapi.rating.entity.QueryRateRequestHistory;
import com.s3group.tmsapi.search.entity.ParcelRequestHistorySearchCriteria;
import com.s3group.tmsapi.search.entity.QueryRateRequestHistorySearchCriteria;
import com.s3group.tmsapi.search.service.ParcelRequestHistorySearchService;
import com.s3group.tmsapi.search.service.QueryRateRequestHistorySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Thamilarasi
 * @since : 2020-05-25
 */
@RestController
public class QueryRateRequestHistorySearchController {
  @Autowired
  private QueryRateRequestHistorySearchService queryRateRequestHistorySearchService;

  @PostMapping("/queryraterequesthistorysearch")
  public Page<QueryRateRequestHistory> search(@RequestBody QueryRateRequestHistorySearchCriteria queryRateRequestHistorySearchCriteria, @RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "lastUpdatedDateTime") String sortBy, @RequestParam(defaultValue = "D") String orderBy) {
    return queryRateRequestHistorySearchService.search(queryRateRequestHistorySearchCriteria, pageNo, pageSize, sortBy, orderBy);
  }
}