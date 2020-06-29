package com.s3group.tmsapi.cancel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VoidShipmentResponse {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("Response")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "shipment_cancel_response_id",
      referencedColumnName = "id")
  private ShipmentCancelResponse shipmentCancelResponse;

  @JsonProperty("SummaryResult")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "summary_result_id",
      referencedColumnName = "id")
  private SummaryResult summaryResult;

  @OneToOne(mappedBy = "voidShipmentResponse")
  @JsonIgnore
  private CancelResponseHistory cancelResponseHistory;
}
