package com.s3group.tmsapi.entities.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class ShipmentCharge {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("Type")
  private String type;

  @JsonProperty("BillShipper")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "bill_shipper_id", referencedColumnName = "id")
  private BillShipper billShipper;
}
