package com.s3group.tmsapi.common.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.parcel.entities.request.Shipment;
import com.s3group.tmsapi.rating.entity.RateShipment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
public class ShipFrom {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("Name")
  private String name;

  @JsonProperty("AttentionName")
  private String attentionName;

  @JsonProperty("Phone")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "phone_id",
      referencedColumnName = "id")
  private Phone phone;

  @JsonProperty("FaxNumber")
  private String faxNumber;

  @JsonProperty("TaxIdentificationNumber")
  private String taxIdentificationNumber;

  @JsonProperty("Address")
  @Embedded
  private Address address;

  @OneToOne(mappedBy = "shipFrom")
  @JsonIgnore
  private Shipment shipment;

  @OneToOne(mappedBy = "shipFrom")
  @JsonIgnore
  private RateShipment rateShipment;
}
