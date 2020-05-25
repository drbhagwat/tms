package com.s3group.tmsapi.parcel.repo;

import com.s3group.tmsapi.parcel.entities.request.ParcelRequestHistory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParcelRequestHistoryRepository extends PagingAndSortingRepository<ParcelRequestHistory, String> {
    Optional<ParcelRequestHistory> findByTransactionId(String transactionId);
}