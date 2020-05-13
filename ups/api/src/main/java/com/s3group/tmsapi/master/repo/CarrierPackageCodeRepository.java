package com.s3group.tmsapi.master.repo;

import com.s3group.tmsapi.master.entities.CarrierPackageCode;
import com.s3group.tmsapi.master.entities.CarrierPackageCodeKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This represents the repository for CarrierPackageCode entity.
 *
 * @author : Anghulakshmi B
 * @version : 1.0
 * @since : 2020-05-07
 */
@Repository
public interface CarrierPackageCodeRepository extends PagingAndSortingRepository<CarrierPackageCode, String> {
    Page<CarrierPackageCode> findAll(Pageable pageable);

    Optional<CarrierPackageCode> findById(CarrierPackageCodeKey carrierPackageCodeKey);
}