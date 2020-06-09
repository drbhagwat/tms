package com.s3group.tmsapi.errors;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QueryRateResponseHistoryNotFound extends Exception {
    private static final long serialVersionUID = 1L;

    public QueryRateResponseHistoryNotFound(String exception) {
        super(exception);
    }
}