package com.s3group.tmsapi.master.errors;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class FileStorageException extends Exception {
	private static final long serialVersionUID = 1L;
    public FileStorageException(String exception) {
      super(exception);
    }
}
