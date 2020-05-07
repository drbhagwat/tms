package com.s3group.tmsapi.core.validation;

import com.s3group.tmsapi.core.errors.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Validation service (used in validating primary keys of company, division,
 * warehouse etc.,)
 *
 * @author : Dinesh Bhagwat
 * @version : 1.0
 */
@Service
public class CodeValidationService {
  @Value("${CODE_MANDATORY}")
  private String codeMandatory;

  @Value("${CODE_CANNOT_BE_BLANK}")
  private String codeCannotBeBlank;

  @Value("${CODE_CANNOT_CONTAIN_SPECIAL_CHARACTERS}")
  private String codeCannotContainSpecialCharacters;

  @Value("${CODE_INVALID_LENGTH}")
  private String codeInvalidLength;

  @Value("${KEY_FIELD_MANDATORY}")
  private String keyFieldMandatory;

  @Value("${KEY_FIELD_CANNOT_BE_BLANK}")
  private String keyFieldCannotBeBlank;

  @Value("${ALPHA_NUMERIC_AND_SPACE_REGEX}")
  private String alphaNumericAndSpaceRegEx;

  private NullValidator nullValidator = new NullValidator() {
    public boolean validate(String parameter) throws ParameterIsNull {
      if (parameter == null) throw new ParameterIsNull();
      return true;
    }
  };

  private BlankValidatorPostRightTrim blankValidatorPostRightTrim =
      new BlankValidatorPostRightTrim() {
        public boolean validate(String parameter) throws ParameterIsBlank {
          if (parameter.stripTrailing().isBlank()) throw new ParameterIsBlank();
          return true;
        }
      };

  private LengthValidator lengthValidator = new LengthValidator() {
    public boolean validate(int currentLength, int expectedLength)
        throws ParameterLengthExceedsExpectedLength {
      if (currentLength > expectedLength)
        throw new ParameterLengthExceedsExpectedLength();
      return true;
    }
  };

  /**
   * Validates code - checks if it contains a special character other than the
   * set of allowed ones - as configured in application.yml
   *
   * @param code - String
   * @throws CodeCannotContainSpecialCharacters - if code contains a special
   *                                            character
   */
  public boolean validate(String code) throws CodeCannotContainSpecialCharacters {
    if (!code.matches(alphaNumericAndSpaceRegEx))
      throw new CodeCannotContainSpecialCharacters(codeCannotContainSpecialCharacters);
    return true;
  }

  /**
   * Validates a code - checks if it is null - checks if it is blank (after
   * trimming trailing spaces) - checks if it contains a special character other
   * than the set of allowed ones - as configured in application.yml
   *
   * @param code - String
   * @return - valid String with trailing spaces removed.
   * @throws CodeMandatory                      - when code is null
   * @throws CodeCannotBeBlank                  - when code is blank after
   *                                            stripping the trailing spaces
   * @throws CodeCannotContainSpecialCharacters - when code contains a special
   *                                            character
   */
  public String validateAll(String code) throws CodeMandatory,
      CodeCannotBeBlank, CodeCannotContainSpecialCharacters {
    try {
      nullValidator.validate(code);
    } catch (ParameterIsNull parameterIsNull) {
      throw new CodeMandatory(codeMandatory);
    }

    try {
      blankValidatorPostRightTrim.validate(code);
    } catch (ParameterIsBlank parameterIsBlank) {
      throw new CodeCannotBeBlank(codeCannotBeBlank);
    }

    if (!code.matches(alphaNumericAndSpaceRegEx)) {
      throw new CodeCannotContainSpecialCharacters(codeCannotContainSpecialCharacters);
    }
    return code.stripTrailing();
  }

  /**
   * Validates a code - checks if it is null - checks if it is blank (after
   * trimming trailing spaces)
   *
   * @param code - String
   * @return - valid code with trailing spaces removed.
   * @throws KeyFieldMandatory     - when code is null
   * @throws KeyFieldCannotBeBlank - when code is blank (post right trim)
   */
  public String validateNullAndBlank(String code) throws KeyFieldMandatory,
      KeyFieldCannotBeBlank {
    try {
      nullValidator.validate(code);
    } catch (ParameterIsNull parameterIsNull) {
      throw new KeyFieldMandatory(keyFieldMandatory);
    }

    try {
      blankValidatorPostRightTrim.validate(code);
    } catch (ParameterIsBlank parameterIsBlank) {
      throw new KeyFieldCannotBeBlank(keyFieldCannotBeBlank);
    }
    return code.stripTrailing();
  }

  /**
   * Validates length
   *
   * @param currentLength  - int
   * @param expectedLength - int
   * @throws MaxLengthExceeded - when currentLength exceeds expectedLength.
   */
  public boolean validate(int currentLength, int expectedLength)
      throws MaxLengthExceeded {
    try {
      lengthValidator.validate(currentLength, expectedLength);
    } catch (ParameterLengthExceedsExpectedLength parameterLengthExceedsExpectedLength) {
      throw new MaxLengthExceeded(codeInvalidLength);
    }
    return true;
  }
}