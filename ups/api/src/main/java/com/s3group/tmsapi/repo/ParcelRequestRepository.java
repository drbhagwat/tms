package com.s3group.tmsapi.repo;

import com.s3group.tmsapi.entities.request.ParcelRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelRequestRepository extends PagingAndSortingRepository<ParcelRequest, Long> {
  Page<ParcelRequest> findAll(Pageable pageable);
}
