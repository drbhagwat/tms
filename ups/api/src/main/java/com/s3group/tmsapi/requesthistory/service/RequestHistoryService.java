package com.s3group.tmsapi.requesthistory.service;

import com.s3group.tmsapi.entities.request.ParcelRequest;
import com.s3group.tmsapi.entities.request.ParcelRequestHistory;
import com.s3group.tmsapi.repo.ParcelRequestHistoryRepository;
import com.s3group.tmsapi.repo.ParcelRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author : Sachin Kulkarni
 * @date : 11-05-2020
 */
@Service
public class RequestHistoryService {
    @Autowired
    private ParcelRequestHistoryRepository parcelRequestHistoryRepository;

    public Page<ParcelRequestHistory> getAll(Integer pageNo, Integer pageSize, String sortBy, String orderBy) {
        Pageable pageable = orderBy.equals("A") ? PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending())
                : PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        return parcelRequestHistoryRepository.findAll(pageable);
    }
}
