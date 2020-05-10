package com.s3group.tmsapi.core.errors;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class FileNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
    public FileNotFoundException(String exception) {
      super(exception);
    }
}
