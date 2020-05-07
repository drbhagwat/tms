package com.s3group.tmsapi.entities.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentResults {
  @JsonProperty("Disclaimer")
  private Disclaimer disclaimer;

  @JsonProperty("ShipmentCharges")
  private ShipmentCharges shipmentCharges;

  @JsonProperty("RatingMethod")
  private String ratingMethod;

  @JsonProperty("BillableWeightCalculationMethod")
  private String billableWeightCalculationMethod;

  @JsonProperty("BillingWeight")
  private BillingWeight billingWeight;

  @JsonProperty("ShipmentIdentificationNumber")
  private String shipmentIdentificationNumber;

  @JsonProperty("PackageResults")
  @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
  private List<PackageResults> packageResults;
}
