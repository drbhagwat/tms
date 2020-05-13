package com.s3group.tmsapi.master.validation;

import com.s3group.tmsapi.master.entities.CarrierPackageCodeKey;
import com.s3group.tmsapi.master.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Provides CarrierPackageCode Validation Service.
 *
 * @author : Anghulakshmi B
 * @version : 1.0
 * @since : 2020-05-07
 */
@Service
@Transactional
public class CarrierPackageCodeValidationService {
    @Value("${CARRIER_PACKAGE_CODE_CANNOT_CONTAIN_SPECIAL_CHARACTERS")
    private String carrierPackageCodeCannotContainSpecialCharacters;

    @Value("${CARRIER_PACKAGE_CODE_MANDATORY}")
    private String carrierPackageCodeMandatory;

    @Value("${CARRIER_PACKAGE_CODE_CANNOT_BE_BLANK}")
    private String carrierPackageCodeCannotBeBlank;

    @Autowired
    private CarrierServiceCodeValidationService carrierServiceCodeValidationService;

    @Autowired
    private CodeValidationService codeValidationService;

    /**
     * Validates a carrierPackageCodeKey which consists of carrierCode and carrierPackageCode
     * - to check if either the carrierCode or the carrierPackageCode contains a special character
     *
     * @param carrierPackageCodeKey - the composite PK (carrierCode and carrierPackageCode)
     * @return - valid carrierPackageCodeKey with trailing spaces removed in both carrierCode and carrierPackageCode
     * @throws CarrierCodeCannotContainSpecialCharacters        - if the carrierCode contains a non-allowable character
     * @throws CarrierPackageCodeCannotContainSpecialCharacters - if the carrierPackageCode contains a non-allowable character
     */
    public CarrierPackageCodeKey validate(CarrierPackageCodeKey carrierPackageCodeKey) throws CarrierPackageCodeCannotContainSpecialCharacters, CarrierCodeCannotContainSpecialCharacters, CarrierCodeMandatory, CarrierCodeCannotBeBlank, CarrierPackageCodeMandatory, CarrierPackageCodeCannotBeBlank {
        String carrierCode = carrierServiceCodeValidationService.validate(carrierPackageCodeKey.getCarrierCode());
        try {
            String carrierPackageCode = carrierPackageCodeKey.getCarrierPackageCode();
            codeValidationService.validateAll(carrierPackageCode);
            carrierPackageCode = carrierPackageCode.stripTrailing();
            return new CarrierPackageCodeKey(carrierCode, carrierPackageCode);
        } catch (CodeCannotContainSpecialCharacters exception) {
            throw new CarrierPackageCodeCannotContainSpecialCharacters(carrierPackageCodeCannotContainSpecialCharacters);
        } catch (CodeMandatory codeMandatory) {
            throw new CarrierPackageCodeMandatory(carrierPackageCodeMandatory);
        } catch (CodeCannotBeBlank codeCannotBeBlank) {
            throw new CarrierPackageCodeCannotBeBlank(carrierPackageCodeCannotBeBlank);
        }
    }
}
