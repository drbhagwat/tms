package com.s3group.tmsapi.cancel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.common.entities.ResponseStatus;
import com.s3group.tmsapi.common.entities.TransactionReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShipmentCancelResponse {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("ResponseStatus")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "response_status_id",
      referencedColumnName = "id")
  private ResponseStatus responseStatus;

  @JsonProperty("TransactionReference")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "transaction_reference_id",
      referencedColumnName = "id")
  private TransactionReference transactionReference;

  @OneToOne(mappedBy = "shipmentCancelResponse")
  @JsonIgnore
  private VoidShipmentResponse voidShipmentResponse;
}