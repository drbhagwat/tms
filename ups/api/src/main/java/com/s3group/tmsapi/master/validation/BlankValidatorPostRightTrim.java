package com.s3group.tmsapi.master.validation;

import com.s3group.tmsapi.master.errors.ParameterIsBlank;

/**
 * Validates the input parameter only after trimming trailing spaces.
 *
 * @author : Dinesh Bhagwat
 * @version : 2.0
 * @since : 2020-04-15
 */
interface BlankValidatorPostRightTrim {
  /**
   * @param parameter - String
   * @throws ParameterIsBlank - when it is non-empty, after eliminating trailing
   *                          spaces.
   */
  default boolean validate(String parameter) throws ParameterIsBlank {
    if (parameter.stripTrailing().isBlank()) throw new ParameterIsBlank();
    return true;
  }
}
