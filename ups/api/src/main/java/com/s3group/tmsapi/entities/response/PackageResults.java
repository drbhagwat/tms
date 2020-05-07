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
public class PackageResults {
  @JsonProperty("TrackingNumber")
  private String trackingNumber;

  @JsonProperty("BaseServiceCharge")
  private BaseServiceCharge baseServiceCharge;

  @JsonProperty("ServiceOptionsCharges")
  private ServiceOptionsCharges serviceOptionsCharges;

  @JsonProperty("ShippingLabel")
  private ShippingLabel shippingLabel;

  @JsonProperty("ItemizedCharges")
  @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
  private List<ItemizedCharges> itemizedCharges;
}
