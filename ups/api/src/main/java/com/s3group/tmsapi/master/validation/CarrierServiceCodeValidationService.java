package com.s3group.tmsapi.master.validation;

import com.s3group.tmsapi.master.entities.CarrierServiceCodeKey;
import com.s3group.tmsapi.master.errors.*;
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

    @Value("${CARRIER_SHIPMENT_SERVICE_CANNOT_CONTAIN_SPECIAL_CHARACTERS")
    private String carrierShipmentServiceCannotContainSpecialCharacters;

    @Value("${CARRIER_SHIPMENT_SERVICE_MANDATORY}")
    private String carrierShipmentServiceMandatory;

    @Value("${CARRIER_SHIPMENT_SERVICE_CANNOT_BE_BLANK}")
    private String carrierShipmentServiceCannotBeBlank;

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

    public CarrierServiceCodeKey validateCode(CarrierServiceCodeKey carrierServiceCodeKey) throws CarrierShipmentServiceCannotContainSpecialCharacters, CarrierShipmentServiceMandatory, CarrierShipmentServiceCannotBeBlank, CarrierCodeCannotBeBlank, CarrierCodeCannotContainSpecialCharacters, CarrierCodeMandatory {
        String carrierCode = validate(carrierServiceCodeKey.getCarrierCode());
        try {
            String carrierShipmentService = codeValidationService.validateAll(carrierServiceCodeKey.getCarrierShipmentService());
            carrierShipmentService = carrierShipmentService.stripTrailing();
            return new CarrierServiceCodeKey(carrierCode, carrierShipmentService);
        } catch (CodeCannotContainSpecialCharacters codeCannotContainSpecialCharactersException) {
            throw new CarrierShipmentServiceCannotContainSpecialCharacters(carrierShipmentServiceCannotContainSpecialCharacters);
        } catch (CodeMandatory codeMandatory) {
            throw new CarrierShipmentServiceMandatory(carrierShipmentServiceMandatory);
        } catch (CodeCannotBeBlank codeCannotBeBlank) {
            throw new CarrierShipmentServiceCannotBeBlank(carrierShipmentServiceCannotBeBlank);
        }
    }
}