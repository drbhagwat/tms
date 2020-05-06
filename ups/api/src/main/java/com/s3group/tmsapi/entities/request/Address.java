package com.s3group.tmsapi.entities.request;

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

  private String addressLine;

  private String addressLine2;

  private String addressLine3;

  private String city;

  private String stateProvinceCode;

  private String postalCode;

  private String countryCode;
}
