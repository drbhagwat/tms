package com.s3group.tmsapi.master.repo;

import com.s3group.tmsapi.master.entities.CarrierPackageCode;
import com.s3group.tmsapi.master.entities.CarrierServiceCode;
import com.s3group.tmsapi.master.entities.CarrierServiceCodeKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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

    @Query(value = "select c from CarrierServiceCode c where lower(c.id.carrierCode) like lower(concat('%', ?1,'%')) And lower(c.id.carrierShipmentService) like lower(concat('%', ?2,'%')) And lower(c.description) like lower(concat('%', ?3,'%')) And c.createdDateTime >= ?4 And c.createdDateTime <= ?5")
    Page<CarrierServiceCode> search(Pageable pageable, String carrierCode, String carrierShipmentService, String description, LocalDateTime createdDateFrom, LocalDateTime createdDateTo);

}