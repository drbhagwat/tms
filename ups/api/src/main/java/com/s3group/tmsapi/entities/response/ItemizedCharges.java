package com.s3group.tmsapi.entities.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.entities.request.Shipment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ItemizedCharges {
  @Id
  @GeneratedValue
  private long id;

  @JsonProperty("Code")
  private String code;

  @JsonProperty("CurrencyCode")
  private String currencyCode;

  @JsonProperty("MonetaryValue")
  private String monetaryValue;

  @JsonProperty("SubType")
  private String subType;

  @JoinColumn
  @ManyToOne
  private PackageResults packageResults;
}