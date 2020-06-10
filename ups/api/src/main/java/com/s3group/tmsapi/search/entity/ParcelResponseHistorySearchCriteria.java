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
public class ParcelResponseHistorySearchCriteria {
  private String transactionId;

  private String shipmentIdentificationNumber;

  private String transactionDateFrom;

  private String transactionDateTo;
}