package com.s3group.tmsapi.common.repo;

import com.s3group.tmsapi.common.entities.TransactionId;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * This represents the repository for shipper entity.
 *
 * @author : Thamilarasi
 * @version : 1.0
 * @since : 2020-06-26
 */
@Repository
public interface TransactionIdRepository extends PagingAndSortingRepository<TransactionId, String> {
   public TransactionId findTopByOrderByIdDesc();
}