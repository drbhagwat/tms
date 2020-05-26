package com.s3group.tmsapi.rating.repo;

import com.s3group.tmsapi.rating.entity.QueryRateResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRateResponseRepository extends PagingAndSortingRepository<QueryRateResponse, Integer> {
  Page<QueryRateResponse> findAll(Pageable pageable);
}
