package com.s3group.tmsapi.rating.service;

import com.s3group.tmsapi.errors.QueryRateResponseHistoryNotFound;
import com.s3group.tmsapi.rating.entity.QueryRateResponseHistory;
import com.s3group.tmsapi.rating.repo.QueryRateResponseHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Read services for QueryRateResponseHistory entity.
 *
 * @author : Anghulakshmi B
 * @version : 1.0
 * @since : 2020-06-08
 */
@Service
public class QueryRateResponseHistoryService {
    @Value("${QUERY_RATE_RESPONSE_HISTORY_NOT_FOUND}")
    private String queryRateResponseHistoryNotFound;

    @Autowired
    private QueryRateResponseHistoryRepository queryRateResponseHistoryRepository;

    /**
     * Retrieves the first page of queryrateresponsehistory found in the db (when there is no queryrateresponsehistory this will be empty).
     *
     * @param pageNo   - default is 0, can be overridden
     * @param pageSize - default is 10, can be overridden
     * @param sortBy   - default is descending, can be overridden
     * @param orderBy  - default is by last updated date time, can be overridden
     * @return - first page of the queryrateresponsehistories found
     */

    public Page<QueryRateResponseHistory> getAllQueryRateResponseHistory(Integer pageNo, Integer pageSize, String sortBy, String orderBy) {
        Pageable pageable = orderBy.equals("A") ? PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending())
                : PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        return queryRateResponseHistoryRepository.findAll(pageable);
    }

    /**
     * This retrieves a single queryrateresponsehistory based on a transactionId mentioned below
     *
     * @param transactionId - represents the value of queryrateresponsehistory
     * @return - on success, returns the found queryrateresponsehistory.
     * @throws QueryRateResponseHistoryNotFound - on failure, a global exception handler is called
     *                                          which displays an appropriate error message.
     */
    public QueryRateResponseHistory getSpecificQueryRateResponseHistory(String transactionId) throws QueryRateResponseHistoryNotFound {
        Optional<QueryRateResponseHistory> queryRateResponseHistory = Optional.ofNullable(queryRateResponseHistoryRepository.findByTransactionId(transactionId));

        if (queryRateResponseHistory.isEmpty())
            throw new QueryRateResponseHistoryNotFound(queryRateResponseHistoryNotFound);
        return queryRateResponseHistory.get();
    }
}