package model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentCharges {
  @JsonProperty("TransportationCharges")
  private TransportationCharges transportationCharges;

  @JsonProperty("ServiceOptionsCharges")
  private ServiceOptionsCharges serviceOptionsCharges;

  @JsonProperty("TotalCharges")
  private TotalCharges totalCharges;
}
