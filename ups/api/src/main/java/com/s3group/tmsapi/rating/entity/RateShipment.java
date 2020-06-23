package com.s3group.tmsapi.rating.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.common.entities.ShipFrom;
import com.s3group.tmsapi.common.entities.ShipTo;
import com.s3group.tmsapi.common.entities.Shipper;
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
public class RateShipment {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("ShipmentRatingOptions")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "rate_shipment_rating_options_id",
      referencedColumnName = "id")
  private RateShipmentRatingOptions rateShipmentRatingOptions;

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

  @JsonProperty("ShipmentTotalWeight")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "shipment_total_weight_id",
      referencedColumnName = "id")
  private ShipmentTotalWeight shipmentTotalWeight;

  @JsonProperty("Package")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "rate_package_id",
      referencedColumnName = "id")
  private RatePackage ratePackage;

  @OneToOne(mappedBy = "rateShipment")
  @JsonIgnore
  private RateRequest rateRequest;
}
