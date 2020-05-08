package com.s3group.tmsapi.core.errors;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarrierPackageCodeCannotBeBlank extends Exception {
    private static final long serialVersionUID = 1L;

    public CarrierPackageCodeCannotBeBlank(String exception) {
        super(exception);
    }
}
