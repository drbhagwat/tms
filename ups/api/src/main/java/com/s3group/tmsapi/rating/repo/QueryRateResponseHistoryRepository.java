package com.s3group.tmsapi.rating.repo;


import com.s3group.tmsapi.rating.entity.QueryRateResponseHistory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRateResponseHistoryRepository extends PagingAndSortingRepository<QueryRateResponseHistory, String> {
  QueryRateResponseHistory findByTransactionId(String transactionId);
}

