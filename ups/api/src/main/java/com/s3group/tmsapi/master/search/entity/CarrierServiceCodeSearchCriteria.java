package com.s3group.tmsapi.master.search.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents carrier service code search criteria fields.
 *
 * @author : Thamilarasi
 * @since : 2020-06-08
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarrierServiceCodeSearchCriteria {
  private String carrierCode;

  private String carrierShipmentService;

  private String description;

  private String createdDateFrom;

  private String createdDateTo;
}