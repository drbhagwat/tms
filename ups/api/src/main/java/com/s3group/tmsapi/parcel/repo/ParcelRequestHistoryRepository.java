package com.s3group.tmsapi.parcel.repo;

import com.s3group.tmsapi.parcel.entities.request.ParcelRequestHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParcelRequestHistoryRepository extends PagingAndSortingRepository<ParcelRequestHistory, String> {
    Optional<ParcelRequestHistory> findByTransactionId(String transactionId);

    @Query(value = "select p from ParcelRequestHistory p where lower(p.transactionId) like lower(concat('%', ?1,'%')) And lower(p.shipmentRequest.shipment.shipFrom.address.postalCode) like lower(concat('%', ?2,'%')) And lower(p.shipmentRequest.shipment.shipTo.address.postalCode) like lower(concat('%', ?3,'%')) And lower(p.shipmentRequest.shipment.service.code) like lower(concat('%', ?4,'%'))")
    Page<ParcelRequestHistory> historySearch(Pageable pageable, String transactionId, String postalCodeTo, String postalCodeFrom, String serviceCode);
}