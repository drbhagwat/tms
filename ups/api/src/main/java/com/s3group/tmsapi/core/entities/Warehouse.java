package com.s3group.tmsapi.core.entities;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.request.Address;
import org.springframework.stereotype.Component;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This class represents Warehouse entity
 *
 * @author : Thamilarasi
 * @version : 1.0
 * @since : 2020-05-06
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Warehouse extends BasicLogger<String> {
  @EmbeddedId
  @JsonUnwrapped
  @Valid
  WarehouseKey id;

  @NotNull(message = "{NAME_MANDATORY}")
  @NotBlank(message = "{NAME_CANNOT_BE_BLANK}")
  private String name;

  @NotNull(message = "{DESCRIPTION_MANDATORY}")
  @NotBlank(message = "{DESCRIPTION_CANNOT_BE_BLANK}")
  private String description;

  @NotNull(message = "{ADDRESS1_MANDATORY}")
  @NotBlank(message = "{ADDRESS1_CANNOT_BE_BLANK}")
  private String address1;

  private String address2;

  @NotNull(message = "{CITY_MANDATORY}")
  @NotBlank(message = "{CITY_CANNOT_BE_BLANK}")
  private String city;

  @NotNull(message = "{STATE_MANDATORY}")
  @NotBlank(message = "{STATE_CANNOT_BE_BLANK}")
  private String state;

  @NotNull(message = "{ZIP_MANDATORY}")
  @NotBlank(message = "{ZIP_CANNOT_BE_BLANK}")
  private String zip;

  @NotNull(message = "{COUNTRY_MANDATORY}")
  @NotBlank(message = "{COUNTRY_CANNOT_BE_BLANK}")
  private String country;

  @NotNull(message = "{CONTACT_NAME_MANDATORY}")
  @NotBlank(message = "{CONTACT_NAME_CANNOT_BE_BLANK}")
  private String contactName;

  @NotNull(message = "{CONTACT_NUMBER_MANDATORY}")
  @NotBlank(message = "{CONTACT_NUMBER_CANNOT_BE_BLANK}")
  private String contactNumber;

  private String alternateAddress1;

  private String alternateAddress2;

  private String alternateCity;

  private String alternateState;

  private String alternateZip;

  private String alternateCountry;
}