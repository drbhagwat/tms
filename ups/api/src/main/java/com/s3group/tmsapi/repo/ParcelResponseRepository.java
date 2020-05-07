package com.s3group.tmsapi.repo;

import com.s3group.tmsapi.entities.response.ParcelResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelResponseRepository extends PagingAndSortingRepository<ParcelResponse, Long> {
  Page<ParcelResponse> findAll(Pageable pageable);
}
