package com.s3group.tmsapi.rating.repo;

import com.s3group.tmsapi.parcel.entities.request.ParcelRequestHistory;
import com.s3group.tmsapi.rating.entity.QueryRateRequestHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface QueryRateRequestHistoryRepository extends PagingAndSortingRepository<QueryRateRequestHistory, String> {
  QueryRateRequestHistory findByTransactionId(String transactionId);

  @Query(value = "select q from QueryRateRequestHistory q where lower(q.transactionId) like lower(concat('%', ?1,'%')) And lower(q.criteria) like lower(concat('%', ?2,'%')) And lower(q.rateRequest.rateShipment.shipFrom.address.postalCode) like lower(concat('%', ?3,'%')) And lower(q.rateRequest.rateShipment.shipTo.address.postalCode) like lower(concat('%', ?4,'%')) And q.createdDateTime >= ?5 And q.createdDateTime <= ?6")
  Page<QueryRateRequestHistory> historySearch(Pageable pageable, String transactionId, String criteria, String postalCodeFrom, String postalCodeTo, LocalDateTime transactionDateFrom, LocalDateTime transactionDateTo);
}
