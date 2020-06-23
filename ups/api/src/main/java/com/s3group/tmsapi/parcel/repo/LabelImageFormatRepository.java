package com.s3group.tmsapi.parcel.repo;

import com.s3group.tmsapi.parcel.entities.request.LabelImageFormat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelImageFormatRepository extends PagingAndSortingRepository<LabelImageFormat, String> {

    @Query("select DISTINCT code from LabelImageFormat")
    public List<String> getAllImageFormatCode();
}