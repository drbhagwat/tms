package com.s3group.tmsapi.entities.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
  @JsonProperty("ResponseStatus")
  private ResponseStatus responseStatus;

  @JsonProperty("Alert")
  private Alert alert;

  @JsonProperty("TransactionReference")
  private TransactionReference transactionReference;
}
