package com.s3group.tmsapi.rating.entity;

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
public class GuaranteedDelivery {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("BusinessDaysInTransit")
  private String businessDaysInTransit;

  @JsonProperty("DeliveryByTime")
  private String deliveryByTime;

  @OneToOne(mappedBy = "guaranteedDelivery")
  @JsonIgnore
  private RatedShipment ratedShipment;
}
