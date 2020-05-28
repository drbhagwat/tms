package com.s3group.tmsapi.parcel.entities.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ParcelResponse {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("ShipmentResponse")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "shipment_response_id",
      referencedColumnName = "id")
  private ShipmentResponse shipmentResponse;
}
