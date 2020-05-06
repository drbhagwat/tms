package com.s3group.tmsapi.core.errors;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ParameterIsBlank extends Exception {
	private static final long serialVersionUID = 1L;
	public ParameterIsBlank(String exception) {
    super(exception);
  }
}
