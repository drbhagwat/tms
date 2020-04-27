package model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class GlobalRequest {
  @JsonProperty("ShipmentRequest")
  private ShipmentRequest shipmentRequest =
      new ShipmentRequest(new Shipment(), new LabelSpecification());
}
