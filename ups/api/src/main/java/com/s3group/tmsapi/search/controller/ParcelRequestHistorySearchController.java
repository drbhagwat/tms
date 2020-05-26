package com.s3group.tmsapi.search.controller;


import com.s3group.tmsapi.parcel.entities.request.ParcelRequestHistory;
import com.s3group.tmsapi.search.entity.RequestHistorySearchCriteria;
import com.s3group.tmsapi.search.service.ParcelRequestHistorySearchService;
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
public class ParcelRequestHistorySearchController {
  @Autowired
  private ParcelRequestHistorySearchService parcelRequestHistorySearchService;

  @PostMapping("/requesthistorysearch")
  public Page<ParcelRequestHistory> search(@RequestBody RequestHistorySearchCriteria requestHistorySearchCriteria, @RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "lastUpdatedDateTime") String sortBy,
                                           @RequestParam(defaultValue = "D") String orderBy) {

    return parcelRequestHistorySearchService.search(requestHistorySearchCriteria, pageNo, pageSize, sortBy, orderBy);
  }
}