package model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageResultsElement {
  @JsonProperty("TrackingNumber")
  private String trackingNumber;

  @JsonProperty("ServiceOptionsCharges")
  private ServiceOptionsCharges serviceOptionsCharges;

  @JsonProperty("ShippingLabel")
  private ShippingLabel shippingLabel;
}
