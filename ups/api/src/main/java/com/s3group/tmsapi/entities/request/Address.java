package com.s3group.tmsapi.entities.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Embeddable
public class Address {
  @JsonProperty("AddressLine")
  private String addressLine;

  @JsonProperty("AddressLine2")
  private String addressLine2;

  @JsonProperty("AddressLine3")
  private String addressLine3;

  @JsonProperty("City")
  private String city;

  @JsonProperty("StateProvinceCode")
  private String stateProvinceCode;

  @JsonProperty("PostalCode")
  private String postalCode;

  @JsonProperty("CountryCode")
  private String countryCode;
}
