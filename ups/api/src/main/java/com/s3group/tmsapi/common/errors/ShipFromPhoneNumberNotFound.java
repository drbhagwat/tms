package com.s3group.tmsapi.common.errors;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ShipFromPhoneNumberNotFound extends Exception {
    private static final long serialVersionUID = 1L;

    public ShipFromPhoneNumberNotFound(String exception) {
        super(exception);
    }
}