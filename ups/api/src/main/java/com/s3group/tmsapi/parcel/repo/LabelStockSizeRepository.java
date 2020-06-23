package com.s3group.tmsapi.parcel.repo;

import com.s3group.tmsapi.parcel.entities.request.LabelStockSize;
import com.s3group.tmsapi.parcel.entities.request.ShipmentCharge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface LabelStockSizeRepository extends PagingAndSortingRepository<LabelStockSize, String> {

    @Query("select DISTINCT height, width from LabelStockSize")
    public ArrayList<String> getAllHeightAndWidth();
}