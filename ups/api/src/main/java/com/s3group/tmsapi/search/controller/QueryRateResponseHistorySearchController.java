package com.s3group.tmsapi.search.controller;

import com.s3group.tmsapi.rating.entity.QueryRateRequestHistory;
import com.s3group.tmsapi.rating.entity.QueryRateResponseHistory;
import com.s3group.tmsapi.rating.entity.RatedShipment;
import com.s3group.tmsapi.search.entity.QueryRateRequestHistorySearchCriteria;
import com.s3group.tmsapi.search.entity.QueryRateResponseHistorySearchCriteria;
import com.s3group.tmsapi.search.service.QueryRateRequestHistorySearchService;
import com.s3group.tmsapi.search.service.QueryRateResponseHistorySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Thamilarasi
 * @since : 2020-05-25
 */
@RestController
public class QueryRateResponseHistorySearchController {
  @Autowired
  private QueryRateResponseHistorySearchService queryRateResponseHistorySearchService;

  @PostMapping("/queryrateresponsehistorysearch")
  public Page<QueryRateResponseHistory> search(@RequestBody QueryRateResponseHistorySearchCriteria queryRateResponseHistorySearchCriteria, @RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "lastUpdatedDateTime") String sortBy, @RequestParam(defaultValue = "D") String orderBy)  {
    return queryRateResponseHistorySearchService.search(queryRateResponseHistorySearchCriteria, pageNo, pageSize, sortBy, orderBy);
  }
}