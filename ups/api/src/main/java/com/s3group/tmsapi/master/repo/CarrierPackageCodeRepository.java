package com.s3group.tmsapi.master.repo;

import com.s3group.tmsapi.master.entities.CarrierPackageCode;
import com.s3group.tmsapi.master.entities.CarrierPackageCodeKey;
import com.s3group.tmsapi.parcel.entities.request.ParcelRequestHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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

    @Query(value = "select c from CarrierPackageCode c where lower(c.id.carrierCode) like lower(concat('%', ?1,'%')) And lower(c.id.carrierPackageCode) like lower(concat('%', ?2,'%')) And lower(c.description) like lower(concat('%', ?3,'%')) And c.createdDateTime >= ?4 And c.createdDateTime <= ?5")
    Page<CarrierPackageCode> search(Pageable pageable, String carrierCode, String carrierPackageCode, String description, LocalDateTime createdDateFrom, LocalDateTime createdDateTo);

}