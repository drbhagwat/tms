package com.s3group.tmsapi.core.repo;

import com.s3group.tmsapi.core.entities.CarrierServiceCode;
import com.s3group.tmsapi.core.entities.CarrierServiceCodeKey;
import com.s3group.tmsapi.core.entities.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This represents the repository for CarrierServiceCode entity.
 *
 * @author : Anghulakshmi B
 * @version : 1.0
 * @since : 2020-05-06
 */
@Repository
public interface CarrierServiceCodeRepository extends PagingAndSortingRepository<CarrierServiceCode, String> {
    Page<CarrierServiceCode> findAll(Pageable pageable);

    Optional<CarrierServiceCode> findById(CarrierServiceCodeKey carrierServiceCodeKey);
}