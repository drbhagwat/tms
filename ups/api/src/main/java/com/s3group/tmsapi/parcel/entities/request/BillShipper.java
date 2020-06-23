package com.s3group.tmsapi.parcel.entities.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BillShipper {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("AccountNumber")
  private String accountNumber;

  @OneToOne(mappedBy = "billShipper")
  @JsonIgnore
  private ShipmentCharge shipmentCharge;
}
