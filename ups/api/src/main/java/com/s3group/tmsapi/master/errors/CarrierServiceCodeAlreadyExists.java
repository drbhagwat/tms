package com.s3group.tmsapi.master.errors;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class CarrierServiceCodeAlreadyExists extends Exception {
    private static final long serialVersionUID = 1L;
    public CarrierServiceCodeAlreadyExists(String exception) {
        super(exception);
    }
}