package com.s3group.tmsapi.search.service;

import com.s3group.tmsapi.parcel.entities.request.ParcelRequestHistory;
import com.s3group.tmsapi.parcel.repo.ParcelRequestHistoryRepository;
import com.s3group.tmsapi.search.entity.ParcelRequestHistorySearchCriteria;
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
public class ParcelRequestHistorySearchService {
    @Autowired
    private ParcelRequestHistoryRepository parcelRequestHistoryRepository;

    public Page<ParcelRequestHistory> search(ParcelRequestHistorySearchCriteria parcelRequestHistorySearchCriteria, Integer pageNo, Integer pageSize, String sortBy, String orderBy) {
        String transactionId = parcelRequestHistorySearchCriteria.getTransactionId();
        String postalCodeFrom = parcelRequestHistorySearchCriteria.getPostalCodeFrom();
        String postalCodeTo = parcelRequestHistorySearchCriteria.getPostalCodeTo();
        String serviceCode = parcelRequestHistorySearchCriteria.getServiceCode();
        String transactionDateFrom = parcelRequestHistorySearchCriteria.getTransactionDateFrom();
        String transactionDateTo = parcelRequestHistorySearchCriteria.getTransactionDateTo();

        // handle search fields which are null, blank (after trimming), and
        // wild cards - trim it in the process and use the trimmed value everywhere else

        if ((transactionId == null) || (transactionId = transactionId.trim()).equals("*") || transactionId.equals("")) {
            transactionId = "";
        }

        if ((postalCodeFrom == null) || (postalCodeFrom = postalCodeFrom.trim()).equals("*") || postalCodeFrom.equals("")) {
            postalCodeFrom = "";
        }

        if ((postalCodeTo == null) || (postalCodeTo = postalCodeTo.trim()).equals("*") || postalCodeTo.equals("")) {
            postalCodeTo = "";
        }

        if ((serviceCode == null) || (serviceCode = serviceCode.trim()).equals("*") || serviceCode.equals("")) {
            serviceCode = "";
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
        return parcelRequestHistoryRepository.historySearch(paging, transactionId, postalCodeFrom, postalCodeTo, serviceCode, ldtTransactionDateFrom, ldtTransactionDateTo);
    }
}