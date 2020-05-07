package com.s3group.tmsapi.entities.request;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ParcelRequest {
  @Id
  @GeneratedValue
  private long id;

  @JsonProperty("ShipmentRequest")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "shipment_request_id",
      referencedColumnName = "id")
  private ShipmentRequest shipmentRequest;
}
