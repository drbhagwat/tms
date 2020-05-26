package com.s3group.tmsapi.search.service;

import com.s3group.tmsapi.parcel.entities.request.ParcelRequestHistory;

import com.s3group.tmsapi.parcel.repo.ParcelRequestHistoryRepository;
import com.s3group.tmsapi.search.entity.RequestHistorySearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author : Thamilarasi
 * @since : 2020-05-25
 */
@Service
public class ParcelRequestHistorySearchService {
  @Autowired
  private ParcelRequestHistoryRepository parcelRequestHistoryRepository;

  public Page<ParcelRequestHistory> search(RequestHistorySearchCriteria requestHistorySearchCriteria, Integer pageNo, Integer pageSize, String sortBy, String orderBy) {

    String transactionId = requestHistorySearchCriteria.getTransactionId();
    String postalCodeFrom = requestHistorySearchCriteria.getPostalCodeFrom();
    String postalCodeTo = requestHistorySearchCriteria.getPostalCodeTo();
    String serviceCode = requestHistorySearchCriteria.getServiceCode();

    // handles wild card, blank conditions and when the search parameter is not present in search
    // criteria

    if ((transactionId == null) || transactionId.equals("*") || transactionId.equals("")) {
      transactionId = "";
    } else {
      transactionId = transactionId.trim();
    }

    if ((postalCodeFrom == null) || postalCodeFrom.equals("*") || postalCodeFrom.equals("")) {
      postalCodeFrom = "";
    } else {
      postalCodeFrom = postalCodeFrom.trim();
    }

    if ((postalCodeTo == null) || postalCodeTo.equals("*") || postalCodeTo.equals("")) {
      postalCodeTo = "";
    } else {
      postalCodeTo = postalCodeTo.trim();
    }

    if ((serviceCode == null) || serviceCode.equals("*") || serviceCode.equals("")) {
      serviceCode = "";
    } else {
      serviceCode = serviceCode.trim();
    }

    Pageable paging = orderBy.equals("A") ? PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending())
        : PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

    return parcelRequestHistoryRepository.historySearch(paging, transactionId, postalCodeFrom, postalCodeTo, serviceCode);
  }
}
