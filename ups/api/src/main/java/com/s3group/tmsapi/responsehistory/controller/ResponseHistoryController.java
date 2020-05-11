package com.s3group.tmsapi.responsehistory.controller;

import com.s3group.tmsapi.entities.response.ParcelResponseHistory;
import com.s3group.tmsapi.responsehistory.service.ResponseHistoryService;
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
public class ResponseHistoryController {
    @Autowired
    private ResponseHistoryService responseHistoryService;

    @GetMapping("/getallresponsehistory")
    public Page<ParcelResponseHistory> getAllResponseHistory(@RequestParam(defaultValue = "0") Integer pageNo,
                                                             @RequestParam(defaultValue = "10") Integer pageSize,
                                                             @RequestParam(defaultValue = "lastUpdatedDateTime") String sortBy,
                                                             @RequestParam(defaultValue = "D") String orderBy) {
        return responseHistoryService.getAll(pageNo, pageSize, sortBy, orderBy);
    }
}
