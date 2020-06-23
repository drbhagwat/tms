package com.s3group.tmsapi.parcel.repo;

import com.s3group.tmsapi.parcel.entities.request.ShipmentCharge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentChargeRepository extends PagingAndSortingRepository<ShipmentCharge, String> {

    @Query("select DISTINCT type from ShipmentCharge")
    public List<String> getAllTypes();
}