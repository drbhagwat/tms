package com.s3group.tmsapi.entities.request;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class PaymentInformation {
  @Id
  @GeneratedValue
  private long id;

  @JsonProperty("ShipmentCharge")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "shipment_charge_id", referencedColumnName = "id")
  private ShipmentCharge shipmentCharge;
}