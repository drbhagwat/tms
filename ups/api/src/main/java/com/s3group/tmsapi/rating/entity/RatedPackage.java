package com.s3group.tmsapi.rating.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.common.entities.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RatedPackage {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("TransportationCharges")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "transportation_charges_id",
      referencedColumnName = "id")
  private TransportationCharges transportationCharges;

  @JsonProperty("BaseServiceCharge")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "base_service__charge_id",
      referencedColumnName = "id")
  private BaseServiceCharge baseServiceCharge;

  @JsonProperty("ServiceOptionsCharges")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "service_options_charges_id",
      referencedColumnName = "id")
  private ServiceOptionsCharges serviceOptionsCharges;

  @JsonProperty("TotalCharges")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "total_charges_id",
      referencedColumnName = "id")
  private TotalCharges totalCharges;

  @JsonProperty("Weight")
  private String weight;

  @JsonProperty("BillingWeight")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "billing_weight_id",
      referencedColumnName = "id")
  private BillingWeight billingWeight;

  @JsonProperty("ItemizedCharges")
  @OneToMany(cascade =
      CascadeType.ALL,
      orphanRemoval = true)
  @JoinColumn(name = "rated_package_id")
  @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
  private List<RateItemizedCharges> itemizedCharges;
}
