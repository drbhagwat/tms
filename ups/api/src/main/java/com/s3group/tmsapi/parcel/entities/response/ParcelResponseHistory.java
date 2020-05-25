package com.s3group.tmsapi.parcel.entities.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.common.upserrors.UpsErrorResponse;
import com.s3group.tmsapi.master.entities.BasicLogger;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@EqualsAndHashCode(callSuper=true)
public class ParcelResponseHistory extends BasicLogger<String> {
  @Id
  private String transactionId;

  @JsonProperty("response")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ups_error_response_id", referencedColumnName = "id")
  private UpsErrorResponse upsErrorResponse;

  @JsonProperty("ShipmentResponse")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "shipment_response_id", referencedColumnName = "id")
  private ShipmentResponse shipmentResponse;
}
