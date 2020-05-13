package com.s3group.tmsapi.master.entities;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This class represents CarrierPackageCode entity
 *
 * @author : Anghulakshmi B
 * @version : 1.0
 * @since : 2020-05-07
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@EqualsAndHashCode(callSuper=true)
public class CarrierPackageCode extends BasicLogger<String> {
    @EmbeddedId
    @JsonUnwrapped
    CarrierPackageCodeKey id;

    @NotNull(message = "{DESCRIPTION_MANDATORY}")
    @NotBlank(message = "{DESCRIPTION_CANNOT_BE_BLANK}")
    private String description;
}