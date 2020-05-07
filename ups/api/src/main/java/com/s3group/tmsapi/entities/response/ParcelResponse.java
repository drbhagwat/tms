package com.s3group.tmsapi.entities.response;

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
  private long id;

  @JsonProperty("ShipmentResponse")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "shipment_response_id",
      referencedColumnName = "id")
  private ShipmentResponse shipmentResponse;
}