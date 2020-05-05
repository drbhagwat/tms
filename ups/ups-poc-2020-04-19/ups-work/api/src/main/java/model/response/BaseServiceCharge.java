package model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseServiceCharge {
  @JsonProperty("CurrencyCode")
  private String currencyCode;

  @JsonProperty("MonetaryValue")
  private String monetaryValue;
}
