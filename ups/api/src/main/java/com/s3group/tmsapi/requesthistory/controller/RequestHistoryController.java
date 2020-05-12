package com.s3group.tmsapi.requesthistory.controller;

import com.s3group.tmsapi.entities.request.ParcelRequestHistory;
import com.s3group.tmsapi.requesthistory.service.RequestHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sachin Kulkarni
 * @date : 11-05-2020
 */
@RestController
@RequestMapping("/api/v1")
public class RequestHistoryController {
    @Autowired
    private RequestHistoryService requestHistoryService;

    @GetMapping("/getallrequesthistory")
    public Page<ParcelRequestHistory> getAllRequestHistory(@RequestParam(defaultValue = "0") Integer pageNo,
                                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                                           @RequestParam(defaultValue = "lastUpdatedDateTime") String sortBy,
                                                           @RequestParam(defaultValue = "D") String orderBy) {
        return requestHistoryService.getAll(pageNo, pageSize, sortBy, orderBy);
    }
}
