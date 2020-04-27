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
public class Shipper {
  @JsonProperty("Name")
  private String name;

  @JsonProperty("AttentionName")
  private String attentionName;

  @JsonProperty("TaxIdentificationNumber")
  private String taxIdentificationNumber;

  @JsonProperty("Phone")
  private Phone phone;

  @JsonProperty("ShipperNumber")
  private String shipperNumber;

  @JsonProperty("Address")
  private Address address;
}
