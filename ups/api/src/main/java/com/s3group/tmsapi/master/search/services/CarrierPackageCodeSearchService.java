package com.s3group.tmsapi.master.search.services;

import com.s3group.tmsapi.master.entities.CarrierPackageCode;
import com.s3group.tmsapi.master.repo.CarrierPackageCodeRepository;
import com.s3group.tmsapi.master.search.entity.CarrierPackageCodeSearchCriteria;
import com.s3group.tmsapi.parcel.entities.request.ParcelRequestHistory;
import com.s3group.tmsapi.parcel.repo.ParcelRequestHistoryRepository;
import com.s3group.tmsapi.search.entity.RequestHistorySearchCriteria;
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
 * @since : 2020-06-08
 */
@Service
public class CarrierPackageCodeSearchService {
  @Autowired
  private CarrierPackageCodeRepository carrierPackageCodeRepository;

  public Page<CarrierPackageCode> search(CarrierPackageCodeSearchCriteria carrierPackageCodeSearchCriteria, Integer pageNo, Integer pageSize, String sortBy, String orderBy) {
    String carrierCode = carrierPackageCodeSearchCriteria.getCarrierCode();
    String carrierPackageCode = carrierPackageCodeSearchCriteria.getCarrierPackageCode();
    String description = carrierPackageCodeSearchCriteria.getDescription();
    String createdDateFrom = carrierPackageCodeSearchCriteria.getCreatedDateFrom();
    String createdDateTo = carrierPackageCodeSearchCriteria.getCreatedDateTo();

    // handle search fields which are null, blank (after trimming), and
    // wild cards - trim it in the process and use the trimmed value everywhere else

    if ((carrierCode == null) || (carrierCode = carrierCode.trim()).equals("*") || carrierCode.equals("")) {
      carrierCode = "";
    }

    if ((carrierPackageCode == null) || (carrierPackageCode = carrierPackageCode.trim()).equals("*") || carrierPackageCode.equals("")) {
      carrierPackageCode = "";
    }

    if ((description == null) || (description = description.trim()).equals("*") || description.equals("")) {
      description = "";
    }

    LocalDateTime ldtCreatedDateFrom = null;
    LocalDateTime ldtCreatedDateTo = null;

    if ((createdDateFrom == null) || (createdDateFrom = createdDateFrom.trim()).equals("*") || createdDateFrom.equals("")) {
      ldtCreatedDateFrom = LocalDate.of(2020, 05, 01).atStartOfDay();
    } else {
      ldtCreatedDateFrom = LocalDate.parse(createdDateFrom).atStartOfDay();
    }

    if ((createdDateTo == null) || (createdDateTo = createdDateTo.trim()).equals("*") || createdDateTo.equals("")) {
      ldtCreatedDateTo = LocalDateTime.now().toLocalDate().atTime(LocalTime.MAX);
    } else {
      ldtCreatedDateTo = LocalDate.parse(createdDateTo).atTime(LocalTime.MAX);
    }

    Pageable paging = orderBy.equals("A") ? PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending())
        : PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
    return carrierPackageCodeRepository.search(paging, carrierCode, carrierPackageCode, description, ldtCreatedDateFrom, ldtCreatedDateTo);
  }
}