package com.s3group.tmsapi.rating.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.common.entities.PackageWeight;
import com.s3group.tmsapi.common.entities.Dimensions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RatePackage {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("PackagingType")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "packaging_type_id", referencedColumnName = "id")
  private PackagingType packagingType;

  @JsonProperty("Dimensions")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "dimensions_id", referencedColumnName = "id")
  private Dimensions dimensions;

  @JsonProperty("PackageWeight")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "package_weight_id", referencedColumnName = "id")
  private PackageWeight packageWeight;
}
