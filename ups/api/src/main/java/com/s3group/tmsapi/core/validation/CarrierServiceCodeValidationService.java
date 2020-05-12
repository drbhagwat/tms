package com.s3group.tmsapi.core.validation;

import com.s3group.tmsapi.core.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Provides CarrierServiceCode Validation Service
 *
 * @author : Anghulakshmi B
 * @version : 1.0
 * @since : 2020-05-06
 */
@Service
public class CarrierServiceCodeValidationService {
    @Value("${CARRIER_CODE_CANNOT_CONTAIN_SPECIAL_CHARACTERS")
    private String carrierCodeCannotContainSpecialCharacters;

    @Value("${CARRIER_CODE_MANDATORY}")
    private String carrierCodeMandatory;

    @Value("${CARRIER_CODE_CANNOT_BE_BLANK}")
    private String carrierCodeCannotBeBlank;

    @Autowired
    private CodeValidationService codeValidationService;

    /**
     * @param carrierCode - which is the PK
     * @return - the same carrierCode but, with trailing spaces removed.
     * @throws CarrierCodeCannotContainSpecialCharacters - throws this when the
     *                                                   carrierCode contains a
     *                                                   special character
     */
    public String validate(String carrierCode) throws CarrierCodeCannotContainSpecialCharacters, CarrierCodeMandatory, CarrierCodeCannotBeBlank {
        try {
            codeValidationService.validateAll(carrierCode);
            return carrierCode.stripTrailing();
        } catch (CodeCannotContainSpecialCharacters codeCannotContainSpecialCharactersException) {
            throw new CarrierCodeCannotContainSpecialCharacters(carrierCodeCannotContainSpecialCharacters);
        } catch (CodeMandatory codeMandatory) {
            throw new CarrierCodeMandatory(carrierCodeMandatory);
        } catch (CodeCannotBeBlank codeCannotBeBlank) {
            throw new CarrierCodeCannotBeBlank(carrierCodeCannotBeBlank);
        }
    }
}