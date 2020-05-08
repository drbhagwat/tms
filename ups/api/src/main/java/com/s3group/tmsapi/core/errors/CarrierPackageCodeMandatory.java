package com.s3group.tmsapi.core.errors;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarrierPackageCodeMandatory extends Exception {
    private static final long serialVersionUID = 1L;

    public CarrierPackageCodeMandatory(String exception) {
        super(exception);
    }
}
