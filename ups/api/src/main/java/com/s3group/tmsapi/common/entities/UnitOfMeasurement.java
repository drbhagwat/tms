package com.s3group.tmsapi.common.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.parcel.entities.response.ShipmentResults;
import com.s3group.tmsapi.rating.entity.ShipmentTotalWeight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
public class UnitOfMeasurement {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("Code")
  private String code;

  @JsonProperty("Description")
  private String description;

  @OneToOne(mappedBy = "unitOfMeasurement")
  @JsonIgnore
  private BillingWeight billingWeight;

  @OneToOne(mappedBy = "unitOfMeasurement")
  @JsonIgnore
  private ShipmentTotalWeight shipmentTotalWeight;

  @OneToOne(mappedBy = "unitOfMeasurement")
  @JsonIgnore
  private PackageWeight packageWeight;
}
