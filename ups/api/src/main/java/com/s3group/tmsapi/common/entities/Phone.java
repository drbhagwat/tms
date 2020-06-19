package com.s3group.tmsapi.common.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.parcel.entities.request.Shipment;
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
public class Phone {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("Number")
  private String number;

  @OneToOne(mappedBy = "phone")
  private Shipper shipper;

  @OneToOne(mappedBy = "phone")
  private ShipTo shipTo;

  @OneToOne(mappedBy = "phone")
  @JsonIgnore
  private ShipFrom shipFrom;
}
