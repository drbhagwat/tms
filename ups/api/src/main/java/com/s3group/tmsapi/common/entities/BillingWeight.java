package com.s3group.tmsapi.common.entities;

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
public class BillingWeight {
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
}
