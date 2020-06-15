package com.s3group.tmsapi.search.service;

import com.s3group.tmsapi.rating.entity.QueryRateResponseHistory;
import com.s3group.tmsapi.rating.repo.QueryRateResponseHistoryRepository;
import com.s3group.tmsapi.search.entity.QueryRateResponseHistorySearchCriteria;
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
public class QueryRateResponseHistorySearchService {
    @Autowired
    private QueryRateResponseHistoryRepository queryRateResponseHistoryRepository;

    public Page<QueryRateResponseHistory> search(QueryRateResponseHistorySearchCriteria queryRateResponseHistorySearchCriteria, Integer pageNo, Integer pageSize, String sortBy, String orderBy) throws DateTimeParseException {
        String transactionId = queryRateResponseHistorySearchCriteria.getTransactionId();
        String criteria = queryRateResponseHistorySearchCriteria.getCriteria();
        String serviceCode = queryRateResponseHistorySearchCriteria.getServiceCode();
        String currencyCode = queryRateResponseHistorySearchCriteria.getCurrencyCode();
        String monetaryValue = queryRateResponseHistorySearchCriteria.getMonetaryValue();
        String transitDuration = queryRateResponseHistorySearchCriteria.getTransitDuration();
        String transactionDateFrom = queryRateResponseHistorySearchCriteria.getTransactionDateFrom();
        String transactionDateTo = queryRateResponseHistorySearchCriteria.getTransactionDateTo();
        String responseStatus = queryRateResponseHistorySearchCriteria.getResponseStatus();

        // handle search fields which are null, blank (after trimming), and
        // wild cards - trim it in the process and use the trimmed value everywhere else

        if ((transactionId == null) || (transactionId = transactionId.trim()).equals("*") || transactionId.equals("")) {
            transactionId = "";
        }

        if ((criteria == null) || (criteria.equalsIgnoreCase("none")) || (criteria = criteria.trim()).equals("*") || criteria.equals("")) {
            criteria = "";
        }

        if ((responseStatus == null) || (responseStatus = responseStatus.trim()).equals("*") || responseStatus.equals("")) {
            responseStatus = "";
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
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid Date Format. The Date Format should be yyyy-mm-dd");
        }
        Pageable paging = orderBy.equals("A") ? PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending())
                : PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

        if (((serviceCode == null) || (serviceCode = serviceCode.trim()).equals("*") || serviceCode.equals("")) && ((currencyCode == null) || (currencyCode = currencyCode.trim()).equals("*") || currencyCode.equals("")) && ((monetaryValue == null) || (monetaryValue = monetaryValue.trim()).equals("*") || monetaryValue.equals("")) && ((transitDuration == null) || (transitDuration = transitDuration.trim()).equals("*") || transitDuration.equals(""))) {
            return queryRateResponseHistoryRepository.historySearch(paging, transactionId, criteria, ldtTransactionDateFrom, ldtTransactionDateTo, responseStatus);
        }

        if ((serviceCode == null) || (serviceCode = serviceCode.trim()).equals("*") || serviceCode.equals("")) {
            serviceCode = "";
        }

        if ((currencyCode == null) || (currencyCode = currencyCode.trim()).equals("*") || currencyCode.equals("")) {
            currencyCode = "";
        }

        if ((monetaryValue == null) || (monetaryValue = monetaryValue.trim()).equals("*") || monetaryValue.equals("")) {
            monetaryValue = "";
        }

        if ((transitDuration == null) || (transitDuration = transitDuration.trim()).equals("*") || transitDuration.equals("")) {
            transitDuration = "";
        }
        return queryRateResponseHistoryRepository.historySearch(paging, transactionId, criteria, serviceCode, currencyCode, monetaryValue, transitDuration, ldtTransactionDateFrom, ldtTransactionDateTo, responseStatus);
    }
}