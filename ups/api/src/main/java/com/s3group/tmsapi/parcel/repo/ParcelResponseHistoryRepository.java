package com.s3group.tmsapi.parcel.repo;

import com.s3group.tmsapi.parcel.entities.response.ParcelResponseHistory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelResponseHistoryRepository extends PagingAndSortingRepository<ParcelResponseHistory, String> {
    ParcelResponseHistory findByTransactionId(String uPSTransactionId);
}