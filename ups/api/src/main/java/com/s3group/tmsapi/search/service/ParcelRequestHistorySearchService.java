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
    Pageable paging = orderBy.equals("A") ? PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending())
        : PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
    return parcelRequestHistoryRepository.historySearch(paging, transactionId, postalCodeFrom, postalCodeTo, serviceCode);
  }
}
