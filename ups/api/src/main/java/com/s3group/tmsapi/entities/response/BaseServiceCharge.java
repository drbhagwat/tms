package com.s3group.tmsapi.entities.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseServiceCharge {
  @JsonProperty("CurrencyCode")
  private String currencyCode;

  @JsonProperty("MonetaryValue")
  private String monetaryValue;
}
