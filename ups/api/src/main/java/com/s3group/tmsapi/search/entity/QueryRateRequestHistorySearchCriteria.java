package com.s3group.tmsapi.search.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents parcel request history search criteria fields.
 *
 * @author : Thamilarasi
 * @since : 2020-05-25
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryRateRequestHistorySearchCriteria {
  private String transactionId;

  private String criteria;

  private String postalCodeFrom;

  private String postalCodeTo;

  private String transactionDateFrom;

  private String transactionDateTo;
}