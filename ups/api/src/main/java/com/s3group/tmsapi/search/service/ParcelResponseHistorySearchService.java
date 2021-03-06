package com.s3group.tmsapi.search.service;

import com.s3group.tmsapi.parcel.entities.response.ParcelResponseHistory;
import com.s3group.tmsapi.parcel.repo.ParcelResponseHistoryRepository;
import com.s3group.tmsapi.search.entity.ParcelResponseHistorySearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

/**
 * @author : Thamilarasi
 * @since : 2020-05-25
 */
@Service
public class ParcelResponseHistorySearchService {
    @Autowired
    private ParcelResponseHistoryRepository parcelResponseHistoryRepository;

    public Page<ParcelResponseHistory> search(ParcelResponseHistorySearchCriteria parcelResponseHistorySearchCriteria, Integer pageNo, Integer pageSize, String sortBy, String orderBy) {

        String transactionId = parcelResponseHistorySearchCriteria.getTransactionId();
        String shipmentIdentificationNumber = parcelResponseHistorySearchCriteria.getShipmentIdentificationNumber();
        String transactionDateFrom = parcelResponseHistorySearchCriteria.getTransactionDateFrom();
        String transactionDateTo = parcelResponseHistorySearchCriteria.getTransactionDateTo();

        // handles wild card, blank conditions and when the search parameter is not present in search
        // criteria

        if ((transactionId == null) || (transactionId = transactionId.trim()).equals("*") || transactionId.equals("")) {
            transactionId = "";
        }

        LocalDateTime ldtTransactionDateFrom = null;
        LocalDateTime ldtTransactionDateTo = null;

        try {
            if ((transactionDateFrom == null) || (transactionDateFrom = transactionDateFrom.trim()).equals("*") || transactionDateFrom.equals("")) {
                ldtTransactionDateFrom = LocalDate.of(2020, 05, 01).atStartOfDay();
            } else {
                ldtTransactionDateFrom = LocalDate.parse(transactionDateFrom).atStartOfDay();
            }

            if ((transactionDateTo == null) || (transactionDateTo = transactionDateTo.trim()).equals("*") || transactionDateTo.equals("")) {
                ldtTransactionDateTo = LocalDateTime.now().toLocalDate().atTime(LocalTime.MAX);
            } else {
                ldtTransactionDateTo = LocalDate.parse(transactionDateTo).atTime(LocalTime.MAX);
            }
        } catch (
                DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid Date Format. The Date Format should be yyyy-mm-dd");
        }

        Pageable paging = orderBy.equals("A") ? PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending())
                : PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

        if ((shipmentIdentificationNumber == null) || (shipmentIdentificationNumber = shipmentIdentificationNumber.trim()).equals("*") || shipmentIdentificationNumber.equals("")) {
            return parcelResponseHistoryRepository.historySearch(paging, transactionId, ldtTransactionDateFrom, ldtTransactionDateTo);
        }
        return parcelResponseHistoryRepository.historySearch(paging, transactionId, shipmentIdentificationNumber, ldtTransactionDateFrom, ldtTransactionDateTo);
    }
}