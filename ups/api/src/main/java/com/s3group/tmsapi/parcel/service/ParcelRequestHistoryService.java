package com.s3group.tmsapi.parcel.service;

import com.s3group.tmsapi.errors.ParcelRequestHistoryNotFound;
import com.s3group.tmsapi.parcel.entities.request.ParcelRequestHistory;
import com.s3group.tmsapi.parcel.repo.ParcelRequestHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author : Sachin Kulkarni
 * @date : 11-05-2020
 */
@Service
public class ParcelRequestHistoryService {
    @Value("${PARCEL_REQUEST_HISTORY_NOT_FOUND}")
    private String parcelRequestHistoryNotFound;

    @Autowired
    private ParcelRequestHistoryRepository parcelRequestHistoryRepository;

    public Page<ParcelRequestHistory> getAll(Integer pageNo, Integer pageSize, String sortBy, String orderBy) {
        Pageable pageable = orderBy.equals("A") ? PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending())
                : PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        return parcelRequestHistoryRepository.findAll(pageable);
    }

    /**
     * This retrieves a single parcelrequesthistory based on a transactionId mentioned below
     *
     * @param transactionId - represents the value of parcelrequesthistory
     * @return - on success, returns the found parcelrequesthistory.
     * @throws ParcelRequestHistoryNotFound - on failure, a global exception handler is called
     *                                      which displays an appropriate error message.
     */
    public ParcelRequestHistory getRequestHistory(String transactionId) throws ParcelRequestHistoryNotFound {
        Optional<ParcelRequestHistory> parcelRequestHistory = parcelRequestHistoryRepository.findByTransactionId(transactionId);

        if (parcelRequestHistory.isEmpty())
            throw new ParcelRequestHistoryNotFound(parcelRequestHistoryNotFound);

        return parcelRequestHistory.get();
    }
}