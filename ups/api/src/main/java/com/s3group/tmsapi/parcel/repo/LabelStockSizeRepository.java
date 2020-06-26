package com.s3group.tmsapi.parcel.repo;

import com.s3group.tmsapi.parcel.entities.request.LabelStockSize;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface LabelStockSizeRepository extends PagingAndSortingRepository<LabelStockSize, String> {

    @Query("select DISTINCT height, width from LabelStockSize")
    public ArrayList<String> getAllHeightAndWidth();
}