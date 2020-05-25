package com.s3group.tmsapi.parcel.entities.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.common.entities.BillingWeight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShipmentResults {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("Disclaimer")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "disclaimer_id",
      referencedColumnName = "id")
  private Disclaimer disclaimer;

  @JsonProperty("ShipmentCharges")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "shipment_charges_id",
      referencedColumnName = "id")
  private ShipmentCharges shipmentCharges;

  @JsonProperty("RatingMethod")
  private String ratingMethod;

  @JsonProperty("BillableWeightCalculationMethod")
  private String billableWeightCalculationMethod;

  @JsonProperty("BillingWeight")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "billing_weight_id",
      referencedColumnName = "id")
  private BillingWeight billingWeight;

  @JsonProperty("ShipmentIdentificationNumber")
  private String shipmentIdentificationNumber;

  @JsonProperty("PackageResults")
  @OneToMany(cascade =
      CascadeType.ALL,
      orphanRemoval = true)
  @JoinColumn(name = "shipment_results_id")
  @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
  private List<PackageResults> packageResults;
}