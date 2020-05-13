package com.s3group.tmsapi.entities.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.master.entities.BasicLogger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@EqualsAndHashCode(callSuper=true)
@JsonIgnoreProperties({"createdUser", "createdDateTime", "lastUpdatedUser",
    "lastUpdatedDateTime"})
public class ParcelRequest extends BasicLogger<String> {
  @Id
  @GeneratedValue
  private long id;

  @JsonProperty("ShipmentRequest")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "shipment_request_id",
      referencedColumnName = "id")
  private ShipmentRequest shipmentRequest;
}
