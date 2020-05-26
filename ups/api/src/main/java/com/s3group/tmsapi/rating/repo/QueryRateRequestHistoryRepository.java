package com.s3group.tmsapi.rating.repo;

import com.s3group.tmsapi.rating.entity.QueryRateRequestHistory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRateRequestHistoryRepository extends PagingAndSortingRepository<QueryRateRequestHistory, String> {
  QueryRateRequestHistory findByTransactionId(String transactionId);
}
