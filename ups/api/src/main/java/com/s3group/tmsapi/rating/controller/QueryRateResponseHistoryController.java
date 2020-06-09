package com.s3group.tmsapi.rating.controller;

import com.s3group.tmsapi.errors.QueryRateResponseHistoryNotFound;
import com.s3group.tmsapi.rating.entity.QueryRateResponseHistory;
import com.s3group.tmsapi.rating.service.QueryRateResponseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Read operations for the QueryRateResponseHistory entity.
 *
 * @author : Anghulakshmi B
 * @version : 1.0
 * @since : 2020-06-08
 */
@RestController
@RequestMapping()
class QueryRateResponseHistoryController {
    @Autowired
    private QueryRateResponseHistoryService queryRateResponseHistoryService;

    /**
     * Retrieves the first page of queryrateresponsehistory found in the db (when there is no queryrateresponsehistory this will be empty).
     *
     * @param pageNo   - default is 0, can be overridden
     * @param pageSize - default is 10, can be overridden
     * @param sortBy   - default is descending, can be overridden
     * @param orderBy  - default is by last updated date time, can be overridden
     * @return - first page of the queryrateresponsehistories found
     */

    @GetMapping("/queryrateresponsehistory")
    public Page<QueryRateResponseHistory> getAllQueryRateResponseHistory(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                         @RequestParam(defaultValue = "10") Integer pageSize,
                                                                         @RequestParam(defaultValue = "lastUpdatedDateTime") String sortBy,
                                                                         @RequestParam(defaultValue = "D") String orderBy) {
        return queryRateResponseHistoryService.getAllQueryRateResponseHistory(pageNo, pageSize, sortBy, orderBy);
    }

    /**
     * This retrieves a single queryrateresponsehistory based on a transactionId mentioned below
     *
     * @param transactionId - represents the value of queryrateresponsehistory
     * @return - on success, returns the found queryrateresponsehistory.
     * @throws QueryRateResponseHistoryNotFound - on failure, a global exception handler is called
     *                                          which displays an appropriate error message.
     */
    @GetMapping("/queryrateresponsehistory/{transactionId}")
    public QueryRateResponseHistory getSpecificQueryRateResponseHistory(@PathVariable String transactionId) throws QueryRateResponseHistoryNotFound {
        return queryRateResponseHistoryService.getSpecificQueryRateResponseHistory(transactionId);
    }
}
