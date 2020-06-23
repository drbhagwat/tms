package com.s3group.tmsapi.parcel.entities.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.common.entities.ServiceOptionsCharges;
import com.s3group.tmsapi.common.entities.TotalCharges;
import com.s3group.tmsapi.common.entities.TransportationCharges;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShipmentCharges {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("TransportationCharges")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "transportation_charges_id",
      referencedColumnName = "id")
  private TransportationCharges transportationCharges;

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

  @OneToOne(mappedBy = "shipmentCharges")
  @JsonIgnore
  private ShipmentResults shipmentResults;
}
