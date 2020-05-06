package com.s3group.tmsapi.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.request.Address;
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
 * @author : Dinesh Bhagwat
 * @version : 2.0
 * @since : 2020-03-05
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
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

  private Address address;

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