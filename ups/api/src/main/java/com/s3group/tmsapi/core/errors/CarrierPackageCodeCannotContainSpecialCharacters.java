package com.s3group.tmsapi.core.errors;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarrierPackageCodeCannotContainSpecialCharacters extends Exception {
    private static final long serialVersionUID = 1L;

    public CarrierPackageCodeCannotContainSpecialCharacters(String exception) {
        super(exception);
    }
}