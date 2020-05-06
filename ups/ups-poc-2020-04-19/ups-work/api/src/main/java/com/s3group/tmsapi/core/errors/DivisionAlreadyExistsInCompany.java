package com.s3group.tmsapi.core.errors;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DivisionAlreadyExistsInCompany extends Exception {
	private static final long serialVersionUID = 1L;
	public DivisionAlreadyExistsInCompany(String exception) {
    super(exception);
  }
}
