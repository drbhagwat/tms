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
public class Address {
  @JsonProperty("AddressLine")
  private String addressLine;

  @JsonProperty("City")
  private String city;

  @JsonProperty("StateProvinceCode")
  private String stateProvinceCode;

  @JsonProperty("PostalCode")
  private String postalCode;

  @JsonProperty("CountryCode")
  private String countryCode;
}
