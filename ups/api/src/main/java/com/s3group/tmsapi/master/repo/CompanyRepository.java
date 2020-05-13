package com.s3group.tmsapi.master.repo;

import com.s3group.tmsapi.master.entities.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * This represents the repository for Company entity.
 *
 * @author : Thamilarasi
 * @version : 1.0
 * @since : 2020-05-05
 */
@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, String> {
  Page<Company> findAll(Pageable pageable);
}
