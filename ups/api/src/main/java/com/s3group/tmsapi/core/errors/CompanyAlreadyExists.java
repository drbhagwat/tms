package com.s3group.tmsapi.core.errors;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class CompanyAlreadyExists extends Exception {
	private static final long serialVersionUID = 1L;
	public CompanyAlreadyExists(String exception) {
    super(exception);
  }
}
