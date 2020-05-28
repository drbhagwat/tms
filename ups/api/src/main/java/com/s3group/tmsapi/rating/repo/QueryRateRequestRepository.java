package com.s3group.tmsapi.rating.repo;

import com.s3group.tmsapi.rating.entity.QueryRateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRateRequestRepository extends PagingAndSortingRepository<QueryRateRequest, Integer> {
  Page<QueryRateRequest> findAll(Pageable pageable);
}
