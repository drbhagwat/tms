package com.s3group.tmsapi.core.validation;


import com.s3group.tmsapi.core.errors.ParameterLengthExceedsExpectedLength;

/**
 * Validates if input parameter's currentLength is more than its
 * expectedLength.
 *
 * @author : Dinesh Bhagwat
 * @version : 1.0
 */
interface LengthValidator {
  /**
   * @param currentLength  - int
   * @param expectedLength - int
   * @throws ParameterLengthExceedsExpectedLength - when currentLength exceeds
   *                                              expectedLength.
   */
  default boolean validate(int currentLength, int expectedLength)
      throws ParameterLengthExceedsExpectedLength {
    if (currentLength > expectedLength)
      throw new ParameterLengthExceedsExpectedLength();
    return true;
  }
}
