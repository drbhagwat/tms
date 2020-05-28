package com.s3group.tmsapi.rating.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class RateRequest extends BasicLogger<String> {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("Shipment")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "shipment_id",
      referencedColumnName = "id")
  private RateShipment shipment;
}
