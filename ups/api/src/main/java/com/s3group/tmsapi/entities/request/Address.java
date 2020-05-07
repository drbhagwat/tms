package com.s3group.tmsapi.entities.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Embeddable
public class Address implements Serializable {
  private static final long serialVersionUID = 1L;

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

  @JsonProperty("postalCode")
  private String postalCode;

  @JsonProperty("CountryCode")
  private String countryCode;
}
