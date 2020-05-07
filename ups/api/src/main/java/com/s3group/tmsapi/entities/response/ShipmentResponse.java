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
public class ShipmentResponse {
  @Id
  @GeneratedValue
  private long id;

  @JsonProperty("Response")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "response_id",
      referencedColumnName = "id")
  private Response response;

  @JsonProperty("ShipmentResults")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "shipment_results_id",
      referencedColumnName = "id")
  private ShipmentResults shipmentResults;
}
