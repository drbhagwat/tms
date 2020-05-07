package com.s3group.tmsapi.core.validation;


import com.s3group.tmsapi.core.errors.ParameterIsNull;

/**
 * Validates the input parameter.
 *
 * @author : Dinesh Bhagwat
 * @version : 2.0
 * @since : 2020-04-15
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
