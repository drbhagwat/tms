package com.s3groupinc.gateway.api.entity.apidata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This class represents a json payload (post request) with two key value pairs - used for logging into UM.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonLogin {
    @NotNull(message = "{USER_NAME_MANDATORY}")
    @NotBlank(message = "{USER_NAME_CANNOT_BE_BLANK}")
    private String userName;

    @NotNull(message = "{PASSWORD_MANDATORY}")
    @NotBlank(message = "{PASSWORD_CANNOT_BE_BLANK}")
    private String password;

    @NotNull(message = "{TENANT_ID_MANDATORY}")
    @NotBlank(message = "{TENANT_ID_CANNOT_BE_BLANK}")
    private String tenantId;
}