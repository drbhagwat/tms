package com.s3group.tmsapi.search.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents parcel response history search criteria fields.
 *
 * @author : Thamilarasi
 * @since : 2020-05-25
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryRateResponseHistorySearchCriteria {
  private String transactionId;

  private String serviceCode;

  private String currencyCode;

  private String monetaryValue;

  private String transitDuration;

  private String transactionDateFrom;

  private String transactionDateTo;

  private String responseStatus;
}