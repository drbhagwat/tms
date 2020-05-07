package com.s3group.tmsapi.core.repo;

import com.s3group.tmsapi.core.entities.Division;
import com.s3group.tmsapi.core.entities.DivisionKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * This represents repository for Division entity.
 *
 * @author : Thamilarasi
 * @version : 1.0
 * @since : 2020-05-05
 */
@Repository
public interface DivisionRepository extends PagingAndSortingRepository<Division, DivisionKey> {
  Page<Division> findAll(Pageable pageable);
}
