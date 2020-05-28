package com.s3group.tmsapi.parcel.repo;

import com.s3group.tmsapi.parcel.entities.response.ParcelResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelResponseRepository extends PagingAndSortingRepository<ParcelResponse, Integer> {
  Page<ParcelResponse> findAll(Pageable pageable);
}
