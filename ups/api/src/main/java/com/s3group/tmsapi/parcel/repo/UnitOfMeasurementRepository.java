package com.s3group.tmsapi.parcel.repo;

import com.s3group.tmsapi.common.entities.UnitOfMeasurement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitOfMeasurementRepository extends PagingAndSortingRepository<UnitOfMeasurement, String> {

    @Query("select DISTINCT code from UnitOfMeasurement")
    public List<String> getAllDimensionCode();
}