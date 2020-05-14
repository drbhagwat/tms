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
public class ShippingInfo {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("Name")
  private String name;

  @JsonProperty("AttentionName")
  private String attentionName;

  @JsonProperty("Phone")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "phone_id",
      referencedColumnName = "id")
  private Phone phone;

  @JsonProperty("FaxNumber")
  private String faxNumber;

  @JsonProperty("TaxIdentificationNumber")
  private String taxIdentificationNumber;

  @JsonProperty("ShipperNumber")
  private String shipperNumber;

  @JsonProperty("Address")
  @Embedded
  private Address address;
}
