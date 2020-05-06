package com.s3group.tmsapi.core.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Address1 implements Serializable {
  private static final long serialVersionUID = 1L;

  private String addressLine;

  private String addressLine2;

  private String addressLine3;

  private String city;

  private String stateProvinceCode;

  private String postalCode;

  private String countryCode;
}
