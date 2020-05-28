package com.s3group.tmsapi.parcel.entities.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.common.entities.Service;
import com.s3group.tmsapi.common.entities.ShipFrom;
import com.s3group.tmsapi.common.entities.ShipTo;
import com.s3group.tmsapi.common.entities.Shipper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
public class Shipment {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("Description")
  private String description;

  @JsonProperty("Shipper")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "shipper_id",
      referencedColumnName = "id")
  private Shipper shipper;

  @JsonProperty("ShipTo")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ship_to_id",
      referencedColumnName = "id")
  private ShipTo shipTo;

  @JsonProperty("ShipFrom")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ship_from_id",
      referencedColumnName = "id")
  private ShipFrom shipFrom;

  @JsonProperty("PaymentInformation")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "payment_information_id",
      referencedColumnName = "id")
  private PaymentInformation paymentInformation;

  @JsonProperty("Service")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "service_id",
      referencedColumnName = "id")
  private Service service;

  @JsonProperty("Package")
  @OneToMany(cascade =
      CascadeType.ALL,
      orphanRemoval = true)
  @JoinColumn(name = "shipment_id")
  @JsonManagedReference
  private List<Package> packages = new ArrayList<>();

  @JsonProperty("ItemizedChargesRequestedIndicator")
  private String itemizedChargesRequestedIndicator;

  @JsonProperty("RatingMethodRequestedIndicator")
  private String ratingMethodRequestedIndicator;

  @JsonProperty("TaxInformationIndicator")
  private String taxInformationIndicator;

  @JsonProperty("ShipmentRatingOptions")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "shipment_rating_options_id",
      referencedColumnName = "id")
  private ShipmentRatingOptions shipmentRatingOptions;
}
