package com.s3group.tmsapi.common.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.parcel.entities.response.ShipmentCharges;
import com.s3group.tmsapi.rating.entity.RatedPackage;
import com.s3group.tmsapi.rating.entity.RatedShipment;
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
public class TotalCharges {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("CurrencyCode")
  private String currencyCode;

  @JsonProperty("MonetaryValue")
  private String monetaryValue;

  @OneToOne(mappedBy = "totalCharges")
  @JsonIgnore
  private ShipmentCharges shipmentCharges;

  @OneToOne(mappedBy = "totalCharges")
  @JsonIgnore
  private RatedShipment ratedShipment;

  @OneToOne(mappedBy = "totalCharges")
  @JsonIgnore
  private RatedPackage ratedPackage;
}
