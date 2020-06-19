package com.s3group.tmsapi.common.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.parcel.entities.request.UPSPackage;
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
public class PackageWeight {
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

  @OneToOne(mappedBy = "packageWeight")
  private UPSPackage uPSPackage;
}
