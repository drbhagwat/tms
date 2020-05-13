package com.s3group.tmsapi.master.validation;


import com.s3group.tmsapi.master.errors.ParameterIsNull;

/**
 * Validates the input parameter.
 *
 * @author : Dinesh Bhagwat
 * @version : 1.0
 */
public interface NullValidator {
  /**
   * @param parameter - String
   * @return - true when the parameter is non-null
   * @throws Exception - when the parameter is null.
   */
  default boolean validate(String parameter) throws ParameterIsNull {
    if (parameter == null) throw new ParameterIsNull();
    return true;
  }
}
