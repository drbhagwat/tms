package com.s3group.tmsapi.parcel.repo;

import com.s3group.tmsapi.parcel.entities.response.ParcelResponseHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ParcelResponseHistoryRepository extends PagingAndSortingRepository<ParcelResponseHistory, String> {
    ParcelResponseHistory findByTransactionId(String uPSTransactionId);

    @Query(value = "select p from ParcelResponseHistory p where lower(p.transactionId) like lower(concat('%', ?1,'%')) And lower(p.shipmentResponse.shipmentResults.shipmentIdentificationNumber) like lower(concat('%', ?2,'%')) And p.createdDateTime >= ?3 And p.createdDateTime <= ?4")
    Page<ParcelResponseHistory> historySearch(Pageable pageable, String transactionId, String shipmentIdentificationNumber, LocalDateTime transactionDateFrom, LocalDateTime transactionDateTo);
}