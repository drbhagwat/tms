package model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransportationCharges {
  @JsonProperty("CurrencyCode")
  private String currencyCode;

  @JsonProperty("MonetaryValue")
  private String monetaryValue;
}
