package com.s3group.tmsapi.master.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * This class represents Warehouse's primary Key
 *
 * @author : Dinesh Bhagwat
 * @version : 1.0
 * @since : 2019-04-15
 */
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseKey implements Serializable {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  @NotNull(message = "{COMPANY_CODE_MANDATORY}")
  private String companyCode;

  @NotNull(message = "{DIVISION_CODE_MANDATORY}")
  @JsonProperty("divisionCode")
  private String divCode;

  @NotNull(message = "{CODE_MANDATORY}")
  @NotBlank(message = "{CODE_CANNOT_BE_BLANK}")
  @JsonProperty("code")
  private String code;
}
