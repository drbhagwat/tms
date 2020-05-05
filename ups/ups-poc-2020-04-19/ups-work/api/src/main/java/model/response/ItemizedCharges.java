package model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemizedCharges {
  @JsonProperty("Code")
  private String code;

  @JsonProperty("CurrencyCode")
  private String currencyCode;

  @JsonProperty("MonetaryValue")
  private String monetaryValue;

  @JsonProperty("SubType")
  private String subType;
}
