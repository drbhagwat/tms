package com.s3group.tmsapi.entities.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.s3group.tmsapi.entities.common.UnitOfMeasurement;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingWeight {

/*
  @JsonProperty("UnitOfMeasurement")
  private UnitOfMeasurement unitOfMeasurement;
*/

  @JsonProperty("Weight")
  private String weight;
}
