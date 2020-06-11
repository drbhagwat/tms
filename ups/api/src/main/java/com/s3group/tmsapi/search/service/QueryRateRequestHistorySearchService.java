package com.s3group.tmsapi.search.service;

import com.s3group.tmsapi.rating.entity.QueryRateRequestHistory;
import com.s3group.tmsapi.rating.repo.QueryRateRequestHistoryRepository;
import com.s3group.tmsapi.search.entity.QueryRateRequestHistorySearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author : Thamilarasi
 * @since : 2020-05-25
 */
@Service
public class QueryRateRequestHistorySearchService {
  @Autowired
  private QueryRateRequestHistoryRepository queryRateRequestHistoryRepository;

  public Page<QueryRateRequestHistory> search(QueryRateRequestHistorySearchCriteria queryRateRequestHistorySearchCriteria, Integer pageNo, Integer pageSize, String sortBy, String orderBy) {
    String transactionId = queryRateRequestHistorySearchCriteria.getTransactionId();
    String criteria = queryRateRequestHistorySearchCriteria.getCriteria();
    String postalCodeFrom = queryRateRequestHistorySearchCriteria.getPostalCodeFrom();
    String postalCodeTo = queryRateRequestHistorySearchCriteria.getPostalCodeTo();
    String transactionDateFrom = queryRateRequestHistorySearchCriteria.getTransactionDateFrom();
    String transactionDateTo = queryRateRequestHistorySearchCriteria.getTransactionDateTo();

    // handle search fields which are null, blank (after trimming), and
    // wild cards - trim it in the process and use the trimmed value everywhere else

    if ((transactionId == null) || (transactionId = transactionId.trim()).equals("*") || transactionId.equals("")) {
      transactionId = "";
    }

    if ((criteria == null) || (criteria.equalsIgnoreCase("none")) || (criteria = criteria.trim()).equals("*") || criteria.equals("")) {
      criteria = "";
    }

    if ((postalCodeFrom == null) || (postalCodeFrom = postalCodeFrom.trim()).equals("*") || postalCodeFrom.equals("")) {
      postalCodeFrom = "";
    }

    if ((postalCodeTo == null) || (postalCodeTo = postalCodeTo.trim()).equals("*") || postalCodeTo.equals("")) {
      postalCodeTo = "";
    }

    LocalDateTime ldtTransactionDateFrom = null;
    LocalDateTime ldtTransactionDateTo = null;

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

    Pageable paging = orderBy.equals("A") ? PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending())
        : PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
    return queryRateRequestHistoryRepository.historySearch(paging, transactionId, criteria, postalCodeFrom, postalCodeTo, ldtTransactionDateFrom, ldtTransactionDateTo);
  }
}