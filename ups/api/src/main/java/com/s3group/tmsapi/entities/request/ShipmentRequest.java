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
public class ShipmentRequest {
  @Id
  @GeneratedValue
  private long id;

  @JsonProperty("Shipment")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "shipment_id",
      referencedColumnName = "id")
  private Shipment shipment;

  @JsonProperty("LabelSpecification")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "label_specification_id",
      referencedColumnName = "id")
  private LabelSpecification labelSpecification;
}
