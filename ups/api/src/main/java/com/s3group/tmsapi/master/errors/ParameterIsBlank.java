package com.s3group.tmsapi.master.errors;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class ParameterIsBlank extends Exception {
	private static final long serialVersionUID = 1L;
	public ParameterIsBlank(String exception) {
    super(exception);
  }
}
