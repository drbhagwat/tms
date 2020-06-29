package com.s3group.tmsapi.parcel.controller;

import com.s3group.tmsapi.parcel.entities.response.ParcelResponseHistory;
import com.s3group.tmsapi.errors.ParcelResponseHistoryNotFound;
import com.s3group.tmsapi.parcel.service.ParcelResponseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Sachin Kulkarni
 * @date : 11-05-2020
 */
@RestController
@RequestMapping()
public class ParcelResponseHistoryController {
    @Autowired
    private ParcelResponseHistoryService responseHistoryService;

    @GetMapping("/getallresponsehistory")
    public Page<ParcelResponseHistory> getAllResponseHistory(@RequestParam(defaultValue = "0") Integer pageNo,
                                                             @RequestParam(defaultValue = "10") Integer pageSize,
                                                             @RequestParam(defaultValue = "lastUpdatedDateTime") String sortBy,
                                                             @RequestParam(defaultValue = "D") String orderBy) {
        return responseHistoryService.getAll(pageNo, pageSize, sortBy, orderBy);
    }

    /**
     * This retrieves a single parcelresponsehistory based on a transactionId mentioned below
     *
     * @param transactionId - represents the value of parcelresponsehistory
     * @return - on success, returns the found parcelresponsehistory.
     * @throws ParcelResponseHistoryNotFound - on failure, a global exception handler is called
     *                                       which displays an appropriate error message.
     */
    @GetMapping("/responsehistory/{transactionId}")
    public ParcelResponseHistory getResponseHistory(@PathVariable String transactionId) throws ParcelResponseHistoryNotFound {
        return responseHistoryService.get(transactionId);
    }
}
