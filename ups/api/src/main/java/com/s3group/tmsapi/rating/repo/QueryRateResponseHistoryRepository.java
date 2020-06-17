package com.s3group.tmsapi.rating.repo;

import com.s3group.tmsapi.rating.entity.QueryRateResponseHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface QueryRateResponseHistoryRepository extends PagingAndSortingRepository<QueryRateResponseHistory, String> {
  QueryRateResponseHistory findByTransactionId(String transactionId);

  @Query(value = "select q from QueryRateResponseHistory q where lower(q.transactionId) like lower(concat('%', ?1,'%')) And lower(q.criteria) like lower(concat('%', ?2,'%')) And q.createdDateTime >= ?3 And q.createdDateTime <= ?4 And lower(q.responseStatus) like lower(concat('%', ?5,'%'))")
  Page<QueryRateResponseHistory> historySearch(Pageable pageable, String transactionId, String criteria, LocalDateTime transactionDateFrom, LocalDateTime transactionDateTo, String responseStatus);

  @Query(value = "select q from QueryRateResponseHistory q where lower(q.transactionId) like lower(concat('%', ?1,'%')) And lower(q.criteria) like lower(concat('%', ?2,'%')) And q.createdDateTime >= ?3 And q.createdDateTime <= ?4 And lower(q.responseStatus) like lower(concat('%', ?5,'%'))")
  List<QueryRateResponseHistory> historySearchList(Pageable pageable, String transactionId, String criteria, LocalDateTime transactionDateFrom, LocalDateTime transactionDateTo, String responseStatus);
}