package com.s3group.tmsapi.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * This class represents CarrierPackageCode's primary Key
 *
 * @author : Anghulakshmi B
 * @version : 1.0
 * @since : 2020-05-06
 */
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarrierPackageCodeKey implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String carrierCode;

    private String carrierPackageCode;
}