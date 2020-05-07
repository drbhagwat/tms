package com.s3group.tmsapi.entities.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentResponse {
  @JsonProperty("Response")
  private ParcelResponse response;

  @JsonProperty("ShipmentResults")
  private ShipmentResults shipmentResults;
}
