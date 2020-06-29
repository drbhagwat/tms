package com.s3group.tmsapi.rating.service;

import com.s3group.tmsapi.errors.QueryRateRequestHistoryNotFound;
import com.s3group.tmsapi.rating.entity.QueryRateRequestHistory;
import com.s3group.tmsapi.rating.repo.QueryRateRequestHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Read services for QueryRateRequestHistory entity.
 *
 * @author : Anghulakshmi B
 * @version : 1.0
 * @since : 2020-06-08
 */
@Service
public class QueryRateRequestHistoryService {
    @Value("${QUERY_RATE_REQUEST_HISTORY_NOT_FOUND}")
    private String queryRateRequestHistoryNotFound;

    @Autowired
    private QueryRateRequestHistoryRepository queryRateRequestHistoryRepository;

    /**
     * Retrieves the first page of queryraterequesthistory found in the db (when there is no queryraterequesthistory this will be empty).
     *
     * @param pageNo   - default is 0, can be overridden
     * @param pageSize - default is 10, can be overridden
     * @param sortBy   - default is descending, can be overridden
     * @param orderBy  - default is by last updated date time, can be overridden
     * @return - first page of the queryraterequesthistories found
     */
    public Page<QueryRateRequestHistory> getAll(Integer pageNo, Integer pageSize, String sortBy, String orderBy) {
        Pageable pageable = orderBy.equals("A") ? PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending())
                : PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        return queryRateRequestHistoryRepository.findAll(pageable);
    }

    /**
     * This retrieves a single queryraterequesthistory based on a transactionId mentioned below
     *
     * @param transactionId - represents the value of queryraterequesthistory
     * @return - on success, returns the found queryraterequesthistory.
     * @throws QueryRateRequestHistoryNotFound - on failure, a global exception handler is called
     *                                         which displays an appropriate error message.
     */
    public QueryRateRequestHistory get(String transactionId) throws QueryRateRequestHistoryNotFound {
        Optional<QueryRateRequestHistory> queryRateRequestHistory = Optional.ofNullable(queryRateRequestHistoryRepository.findByTransactionId(transactionId));

        if (queryRateRequestHistory.isEmpty())
            throw new QueryRateRequestHistoryNotFound(queryRateRequestHistoryNotFound);
        return queryRateRequestHistory.get();
    }
}