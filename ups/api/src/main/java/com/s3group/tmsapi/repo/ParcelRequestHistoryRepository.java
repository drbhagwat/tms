package com.s3group.tmsapi.repo;

import com.s3group.tmsapi.entities.request.ParcelRequestHistory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelRequestHistoryRepository extends PagingAndSortingRepository<ParcelRequestHistory, String> {
}
