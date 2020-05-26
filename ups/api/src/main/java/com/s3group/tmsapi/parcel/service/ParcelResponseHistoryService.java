package com.s3group.tmsapi.parcel.service;

import com.s3group.tmsapi.parcel.entities.response.ParcelResponseHistory;
import com.s3group.tmsapi.errors.ParcelResponseHistoryNotFound;
import com.s3group.tmsapi.parcel.repo.ParcelResponseHistoryRepository;
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
public class ParcelResponseHistoryService {
    @Value("${PARCEL_RESPONSE_HISTORY_NOT_FOUND}")
    private String parcelResponseHistoryNotFound;

    @Autowired
    private ParcelResponseHistoryRepository parcelResponseHistoryRepository;

    public Page<ParcelResponseHistory> getAll(Integer pageNo, Integer pageSize, String sortBy, String orderBy) {
        Pageable pageable = orderBy.equals("A") ? PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending())
                : PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        return parcelResponseHistoryRepository.findAll(pageable);
    }

    /**
     * This retrieves a single parcelresponsehistory based on a transactionId metioned below
     *
     * @param transactionId - represents the value of parcelresponsehistory
     * @return - on success, returns the found parcelresponsehistory.
     * @throws ParcelResponseHistoryNotFound - on failure, a global exception handler is called
     *                                       which displays an appropriate error message.
     */
    public ParcelResponseHistory getResponseHistory(String transactionId) throws ParcelResponseHistoryNotFound {
        Optional<ParcelResponseHistory> parcelResponseHistory = Optional.ofNullable(parcelResponseHistoryRepository.findByTransactionId(transactionId));

        if (parcelResponseHistory.isEmpty())
            throw new ParcelResponseHistoryNotFound(parcelResponseHistoryNotFound);

        return parcelResponseHistory.get();
    }
}
