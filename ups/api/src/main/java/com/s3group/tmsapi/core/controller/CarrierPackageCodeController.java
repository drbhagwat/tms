package com.s3group.tmsapi.core.controller;

import com.s3group.tmsapi.core.entities.CarrierPackageCode;
import com.s3group.tmsapi.core.entities.CarrierPackageCodeKey;
import com.s3group.tmsapi.core.errors.*;
import com.s3group.tmsapi.core.services.CarrierPackageCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Performs CRUD (Create Read Update Delete) operations for CarrierPackageCode entity.
 *
 * @author : Anghulakshmi B
 * @version : 1.0
 * @since : 2020-05-07
 */
@RestController
public class CarrierPackageCodeController {
    @Value("${CARRIER_PACKAGE_CODE_ADDED}")
    private String carrierPackageCodeAdded;

    @Value("${CARRIER_PACKAGE_CODE_UPDATED}")
    private String carrierPackageCodeUpdated;

    @Value("${CARRIER_PACKAGE_CODE_DELETED}")
    private String carrierPackageCodeDeleted;

    @Autowired
    private CarrierPackageCodeService carrierPackageCodeService;

    /**
     * Gets the first page of found carrierPackageCodes found (empty when there is no carrierPackageCode).
     *
     * @param pageNo   - default is 0, can be overridden.
     * @param pageSize - default is 10, can be overridden.
     * @param sortBy   - default is descending, can be overridden.
     * @param orderBy  - default is by last updated date time, can be overridden.
     * @return - first page of the carrierPackageCodes found.
     */
    @GetMapping("/carrierpackagecodes")
    public Page<CarrierPackageCode> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                           @RequestParam(defaultValue = "lastUpdatedDateTime") String sortBy,
                                           @RequestParam(defaultValue = "D") String orderBy) {
        return carrierPackageCodeService.getAll(pageNo, pageSize, sortBy, orderBy);
    }

    /**
     * This retrieves a single carrierPackageCode based on a composite primary key metioned below
     *
     * @param carrierCode - represents the key of carrierCode
     * @param packageCode - represents the key of carrierPackageCode
     * @return - on success, returns the found carrierPackageCode.
     * @throws CarrierPackageCodeNotFound - on failure, a global exception handler is called
     *                                    which displays an appropriate error message.
     */
    @GetMapping("/carrierpackagecodes/{carrierCode},{packageCode}")
    public CarrierPackageCode getCarrierPackageCode(@PathVariable String carrierCode, @PathVariable String packageCode) throws CarrierPackageCodeNotFound {
        return carrierPackageCodeService.getCarrierPackageCode(new CarrierPackageCodeKey(carrierCode, packageCode));
    }

    /**
     * Adds a carrierPackageCode.
     *
     * @param carrierPackageCode - the carrierPackageCode to be added.
     * @return - on success, returns the success message.
     * @throws Exception - on failure, a global exception handler is called
     *                   which displays an appropriate error message.
     */
    @PostMapping("/carrierpackagecodes")
    public ResponseEntity<String> add(@RequestBody CarrierPackageCode carrierPackageCode) throws CarrierCodeNotFound, CarrierPackageCodeCannotContainSpecialCharacters, CarrierPackageCodeCannotBeBlank, CarrierCodeMandatory, CarrierPackageCodeAlreadyExists, CarrierPackageCodeMandatory, CarrierCodeCannotContainSpecialCharacters, CarrierCodeCannotBeBlank {
        carrierPackageCodeService.add(carrierPackageCode);
        return ResponseEntity.ok(carrierPackageCodeAdded);
    }

    /**
     * Updates an existing carrierPackageCode.
     *
     * @param carrierCode        - represents the key of carrierCode
     * @param packageCode        - represents the key of carrierPackageCode
     * @param carrierPackageCode - the carrierPackageCode to be updated.
     * @return - on success, returns the success message.
     * @throws Exception - on failure, a global catch-all exception handler is called
     *                   which displays an appropriate error message.
     */
    @PutMapping("/carrierpackagecodes/{carrierCode},{packageCode}")
    public ResponseEntity<String> update(@PathVariable String carrierCode,
                                         @PathVariable String packageCode,
                                         @RequestBody CarrierPackageCode carrierPackageCode) throws CarrierPackageCodeNotFound {
        carrierPackageCodeService.update(new CarrierPackageCodeKey(carrierCode, packageCode), carrierPackageCode);
        return ResponseEntity.ok(carrierPackageCodeUpdated);
    }

    /**
     * Deletes an existing carrierPackageCode.
     *
     * @param carrierCode - represents the key of carrierCode
     * @param packageCode - represents the key of carrierPackageCode
     * @return - on success, returns the success message.
     * @throws Exception - on failure, a global exception handler is called
     *                   which displays an appropriate error message.
     */
    @DeleteMapping("/carrierpackagecodes/{carrierCode},{packageCode}")
    public ResponseEntity<String> delete(@PathVariable String carrierCode, @PathVariable String packageCode) throws CarrierPackageCodeNotFound {
        carrierPackageCodeService.delete(new CarrierPackageCodeKey(carrierCode, packageCode));
        return ResponseEntity.ok(carrierPackageCodeDeleted);
    }
}