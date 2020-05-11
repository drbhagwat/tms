package com.s3group.tmsapi.responsehistory.service;

import com.s3group.tmsapi.entities.response.ParcelResponseHistory;
import com.s3group.tmsapi.repo.ParcelResponseHistoryRepository;
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
public class ResponseHistoryService {
    @Autowired
    private ParcelResponseHistoryRepository parcelResponseHistoryRepository;

    public Page<ParcelResponseHistory> getAll(Integer pageNo, Integer pageSize, String sortBy, String orderBy) {
        Pageable pageable = orderBy.equals("A") ? PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending())
                : PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        return parcelResponseHistoryRepository.findAll(pageable);
    }
}
