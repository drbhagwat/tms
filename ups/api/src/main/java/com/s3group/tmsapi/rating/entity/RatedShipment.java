package com.s3group.tmsapi.rating.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.common.entities.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(value = { "RatedShipmentAlert", "BillingWeight", "TransportationCharges", "BaseServiceCharge", "ServiceOptionsCharges", "TotalCharges" })
public class RatedShipment {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("Service")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "response_id",
      referencedColumnName = "id")
  private Service service;

  @JsonProperty("RatedShipmentAlert")
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "rated_shipment_alert_id")
  @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
  @JsonIgnore
  private List<RatedShipmentAlert> ratedShipmentAlerts = new ArrayList<>();

  @JsonProperty("BillingWeight")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "billing_weight_id",
      referencedColumnName = "id")
  @JsonIgnore
  private BillingWeight billingWeight;

  @JsonProperty("TransportationCharges")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "transportation_charges_id",
      referencedColumnName = "id")
  @JsonIgnore
  private TransportationCharges transportationCharges;

  @JsonProperty("BaseServiceCharge")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "base_service__charge_id",
      referencedColumnName = "id")
  @JsonIgnore
  private BaseServiceCharge baseServiceCharge;

  @JsonProperty("ServiceOptionsCharges")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "service_options_charges_id",
      referencedColumnName = "id")
  @JsonIgnore
  private ServiceOptionsCharges serviceOptionsCharges;

  @JsonProperty("TotalCharges")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "total_charges_id",
      referencedColumnName = "id")
  @JsonIgnore
  private TotalCharges totalCharges;

  @JsonProperty("GuaranteedDelivery")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "guaranteed_delivery_id",
      referencedColumnName = "id")
  private GuaranteedDelivery guaranteedDelivery;

  @JsonProperty("RatedPackage")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "rate_package_id",
      referencedColumnName = "id")
  private RatedPackage ratedPackage;

  @JsonIgnore
  @JoinColumn
  @ManyToOne
  private RateResponse rateResponse;
}
