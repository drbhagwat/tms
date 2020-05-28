package com.s3group.tmsapi.parcel.repo;

import com.s3group.tmsapi.parcel.entities.request.ParcelRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelRequestRepository extends PagingAndSortingRepository<ParcelRequest, Integer> {
  Page<ParcelRequest> findAll(Pageable pageable);
}
