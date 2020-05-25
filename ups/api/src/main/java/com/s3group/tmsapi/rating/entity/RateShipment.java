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

  @JsonProperty("Package")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "package_id",
      referencedColumnName = "id")
  private com.s3group.tmsapi.rating.entity.RatePackage ratePackage;
}
