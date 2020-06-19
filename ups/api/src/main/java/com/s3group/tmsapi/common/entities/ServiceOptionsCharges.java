package com.s3group.tmsapi.common.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.parcel.entities.response.PackageResults;
import com.s3group.tmsapi.parcel.entities.response.ShipmentCharges;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ServiceOptionsCharges {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("CurrencyCode")
  private String currencyCode;

  @JsonProperty("MonetaryValue")
  private String monetaryValue;

  @OneToOne(mappedBy = "serviceOptionsCharges")
  @JsonIgnore
  private ShipmentCharges shipmentCharges;

  @OneToOne(mappedBy = "serviceOptionsCharges")
  @JsonIgnore
  private PackageResults packageResults;
}
