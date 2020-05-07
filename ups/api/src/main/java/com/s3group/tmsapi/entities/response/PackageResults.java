package com.s3group.tmsapi.entities.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PackageResults {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("TrackingNumber")
  private String trackingNumber;

  @JsonProperty("BaseServiceCharge")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "base_service_charge_id",
      referencedColumnName = "id")
  private BaseServiceCharge baseServiceCharge;

  @JsonProperty("ServiceOptionsCharges")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "service_options_charges_id",
      referencedColumnName = "id")
  private ServiceOptionsCharges serviceOptionsCharges;

  @JsonProperty("ShippingLabel")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "shipping_label_id",
      referencedColumnName = "id")
  private ShippingLabel shippingLabel;

  @JsonProperty("ItemizedCharges")
  @OneToMany(cascade =
      CascadeType.ALL,
      orphanRemoval = true)
  @JoinColumn(name = "package_results_id")
//  @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
  private List<ItemizedCharges> itemizedCharges;
}
