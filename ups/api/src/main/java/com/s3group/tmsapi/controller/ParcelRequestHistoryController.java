package com.s3group.tmsapi.controller;

import com.s3group.tmsapi.entities.request.ParcelRequestHistory;
import com.s3group.tmsapi.errors.ParcelRequestHistoryNotFound;
import com.s3group.tmsapi.service.ParcelRequestHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Sachin Kulkarni
 * @date : 11-05-2020
 */
@RestController
@RequestMapping()
public class ParcelRequestHistoryController {
    @Autowired
    private ParcelRequestHistoryService requestHistoryService;

    @GetMapping("/getallrequesthistory")
    public Page<ParcelRequestHistory> getAllRequestHistory(@RequestParam(defaultValue = "0") Integer pageNo,
                                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                                           @RequestParam(defaultValue = "lastUpdatedDateTime") String sortBy,
                                                           @RequestParam(defaultValue = "D") String orderBy) {
        return requestHistoryService.getAll(pageNo, pageSize, sortBy, orderBy);
    }

    /**
     * This retrieves a single parcelrequesthistory based on a transactionId metioned below
     *
     * @param transactionId - represents the value of parcelrequesthistory
     * @return - on success, returns the found parcelrequesthistory.
     * @throws ParcelRequestHistoryNotFound - on failure, a global exception handler is called
     *                                      which displays an appropriate error message.
     */
    @GetMapping("/requesthistory/{transactionId}")
    public ParcelRequestHistory getRequestHistory(@PathVariable String transactionId) throws ParcelRequestHistoryNotFound {
        return requestHistoryService.getRequestHistory(transactionId);
    }
}