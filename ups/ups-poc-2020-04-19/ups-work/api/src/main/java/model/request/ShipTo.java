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
public class ShipTo {
  @JsonProperty("Name")
  private String name;

  @JsonProperty("AttentionName")
  private String attentionName;

  @JsonProperty("Phone")
  private Phone phone;

  @JsonProperty("FaxNumber")
  private String faxNumber;

  @JsonProperty("TaxIdentificationNumber")
  private String taxIdentificationNumber;

  @JsonProperty("Address")
  private Address address;
}
