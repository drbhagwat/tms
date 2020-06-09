package com.s3group.tmsapi.rating.repo;


import com.s3group.tmsapi.parcel.entities.request.ParcelRequestHistory;
import com.s3group.tmsapi.rating.entity.QueryRateResponseHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface QueryRateResponseHistoryRepository extends PagingAndSortingRepository<QueryRateResponseHistory, String> {
  QueryRateResponseHistory findByTransactionId(String transactionId);

  @Query(value = "select DISTINCT q from QueryRateResponseHistory q join q.rateResponse.ratedShipments rs where lower(q.transactionId) like lower(concat('%', ?1,'%')) And lower(rs.service.code) like lower(concat('%', ?2,'%')) And lower(rs.totalCharges.currencyCode) like lower(concat('%', ?3,'%')) And lower(rs.totalCharges.monetaryValue) like lower(concat('%', ?4,'%')) And lower(rs.guaranteedDelivery.businessDaysInTransit) like lower(concat('%', ?5,'%')) And q.createdDateTime >= ?6 And q.createdDateTime <= ?7 And lower(q.rateResponse.response.responseStatus.description) like lower(concat('%', ?8,'%'))")
  Page<QueryRateResponseHistory> historySearch(Pageable pageable, String transactionId, String serviceCode, String currencyCode, String monetaryValue, String transitDuration, LocalDateTime transactionDateFrom, LocalDateTime transactionDateTo, String responseStatus);

  @Query(value = "select q from QueryRateResponseHistory q where lower(q.transactionId) like lower(concat('%', ?1,'%')) And q.createdDateTime >= ?2 And q.createdDateTime <= ?3")
  Page<QueryRateResponseHistory> historySearch(Pageable pageable, String transactionId, LocalDateTime transactionDateFrom, LocalDateTime transactionDateTo);


}

