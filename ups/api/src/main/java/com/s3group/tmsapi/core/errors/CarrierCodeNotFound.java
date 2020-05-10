package com.s3group.tmsapi.core.errors;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class CarrierCodeNotFound extends Exception {
    private static final long serialVersionUID = 1L;
    public CarrierCodeNotFound(String exception) {
        super(exception);
    }
}