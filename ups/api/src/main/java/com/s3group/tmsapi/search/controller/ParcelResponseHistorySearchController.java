package com.s3group.tmsapi.search.controller;

import com.s3group.tmsapi.parcel.entities.response.ParcelResponseHistory;
import com.s3group.tmsapi.search.entity.ParcelResponseHistorySearchCriteria;
import com.s3group.tmsapi.search.service.ParcelResponseHistorySearchService;
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
public class ParcelResponseHistorySearchController {
    @Autowired
    private ParcelResponseHistorySearchService parcelResponseHistorySearchService;

    @PostMapping("/responsehistorysearch")
    public Page<ParcelResponseHistory> search(@RequestBody ParcelResponseHistorySearchCriteria parcelResponseHistorySearchCriteria, @RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "lastUpdatedDateTime") String sortBy,
                                              @RequestParam(defaultValue = "D") String orderBy) {
        return parcelResponseHistorySearchService.search(parcelResponseHistorySearchCriteria, pageNo, pageSize, sortBy, orderBy);
    }
}