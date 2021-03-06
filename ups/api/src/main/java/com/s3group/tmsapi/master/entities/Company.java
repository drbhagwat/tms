package com.s3group.tmsapi.master.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * This class represents Company entity
 *
 * @author : Thamilarasi
 * @version : 1.0
 * @since : 2020-05-05
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@EqualsAndHashCode(callSuper=true)
public class Company  extends BasicLogger<String>  {
  @Id
  @NotNull(message = "{CODE_MANDATORY}")
  private String code;

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

  @JsonIgnore
  @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Division> divisions;
}