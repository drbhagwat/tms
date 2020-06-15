package com.s3group.tmsapi.rating.controller;

import com.s3group.tmsapi.errors.QueryRateRequestHistoryNotFound;
import com.s3group.tmsapi.rating.entity.QueryRateRequestHistory;
import com.s3group.tmsapi.rating.service.QueryRateRequestHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Read operations for the QueryRateRequestHistory entity.
 *
 * @author : Anghulakshmi B
 * @version : 1.0
 * @since : 2020-06-08
 */
@RestController
@RequestMapping()
public class QueryRateRequestHistoryController {
    @Autowired
    private QueryRateRequestHistoryService queryRateRequestHistoryService;

    /**
     * Retrieves the first page of queryraterequesthistory found in the db (when there is no queryraterequesthistory this will be empty).
     *
     * @param pageNo   - default is 0, can be overridden
     * @param pageSize - default is 10, can be overridden
     * @param sortBy   - default is descending, can be overridden
     * @param orderBy  - default is by last updated date time, can be overridden
     * @return - first page of the queryraterequesthistories found
     */
    @GetMapping("/queryraterequesthistory")
    public Page<QueryRateRequestHistory> getAllQueryRateRequestHistory(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                                                       @RequestParam(defaultValue = "lastUpdatedDateTime") String sortBy,
                                                                       @RequestParam(defaultValue = "D") String orderBy) {
        return queryRateRequestHistoryService.getAllQueryRateRequestHistory(pageNo, pageSize, sortBy, orderBy);
    }

    /**
     * This retrieves a single queryraterequesthistory based on a transactionId mentioned below
     *
     * @param transactionId - represents the value of queryraterequesthistory
     * @return - on success, returns the found queryraterequesthistory.
     * @throws QueryRateRequestHistoryNotFound - on failure, a global exception handler is called
     *                                         which displays an appropriate error message.
     */
    @GetMapping("/queryraterequesthistory/{transactionId}")
    public QueryRateRequestHistory getSpecificQueryRateRequestHistory(@PathVariable String transactionId) throws QueryRateRequestHistoryNotFound {
        return queryRateRequestHistoryService.getSpecificQueryRateRequestHistory(transactionId);
    }
}