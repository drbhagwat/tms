package com.s3group.tmsapi.rating.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.common.entities.UnitOfMeasurement;
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
public class ShipmentTotalWeight {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("UnitOfMeasurement")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "unit_of_measurement_id",
      referencedColumnName = "id")
  private UnitOfMeasurement unitOfMeasurement;

  @JsonProperty("Weight")
  private String weight;

  @OneToOne(mappedBy = "shipmentTotalWeight")
  @JsonIgnore
  private RateShipment rateShipment;
}
