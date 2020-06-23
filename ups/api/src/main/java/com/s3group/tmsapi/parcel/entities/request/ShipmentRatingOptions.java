package com.s3group.tmsapi.parcel.entities.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
public class ShipmentRatingOptions {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("NegotiatedRatesIndicator")
  private String negotiatedRatesIndicator;

  @OneToOne(mappedBy = "shipmentRatingOptions")
  private Shipment shipment;
}
