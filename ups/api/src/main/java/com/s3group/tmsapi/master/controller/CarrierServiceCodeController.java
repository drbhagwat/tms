package com.s3group.tmsapi.master.controller;

import com.s3group.tmsapi.master.entities.CarrierServiceCode;
import com.s3group.tmsapi.master.entities.CarrierServiceCodeKey;
import com.s3group.tmsapi.master.errors.*;
import com.s3group.tmsapi.master.services.CarrierServiceCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * CRUD (Create Read Update Delete) operations for the CarrierServiceCode entity.
 *
 * @author : Anghulakshmi B
 * @version : 1.0
 * @since : 2020-05-06
 */
@RestController
public class CarrierServiceCodeController {
    @Value("${CARRIER_SERVICE_CODE_ADDED}")
    private String carrierServiceCodeAdded;

    @Value("${CARRIER_SERVICE_CODE_UPDATED}")
    private String carrierServiceCodeUpdated;

    @Value("${CARRIER_SERVICE_CODE_DELETED}")
    private String carrierServiceCodeDeleted;

    @Autowired
    private CarrierServiceCodeService carrierServiceCodeService;

    /**
     * Retrieves the first page of CarrierServiceCodes found in the db (when there is no CarrierServiceCode this will be empty).
     *
     * @param pageNo   - default is 0, can be overridden
     * @param pageSize - default is 10, can be overridden
     * @param sortBy   - default is descending, can be overridden
     * @param orderBy  - default is by last updated date time, can be overridden
     * @return - first page of the CarrierServiceCodes found
     */
    @GetMapping("/carrierservicecodes")
    public Page<CarrierServiceCode> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                           @RequestParam(defaultValue = "lastUpdatedDateTime") String sortBy,
                                           @RequestParam(defaultValue = "D") String orderBy) {
        return carrierServiceCodeService.getAll(pageNo, pageSize, sortBy, orderBy);
    }

    /**
     * This retrieves a single carrierServiceCode based on a composite primary key metioned below
     *
     * @param carrierCode            - represents the key of carrierServiceCode
     * @param carrierShipmentService - represents the key of carrierServiceCode
     * @return - on success, returns the found carrierServiceCode.
     * @throws CarrierPackageCodeNotFound - on failure, a global exception handler is called
     *                                    which displays an appropriate error message.
     */
    @GetMapping("/carrierservicecodes/{carrierCode},{carrierShipmentService}")
    public CarrierServiceCode getCarrierServiceCode(@PathVariable String carrierCode, @PathVariable String carrierShipmentService) throws  CarrierServiceCodeNotFound {
        return carrierServiceCodeService.getCarrierServiceCode(new CarrierServiceCodeKey(carrierCode, carrierShipmentService));
    }

    /**
     * Adds a new CarrierServiceCode.
     *
     * @param carrierServiceCode - the CarrierServiceCode which is to be added to the db
     * @return - on success, returns the appropriate message
     * @throws CarrierCodeAlreadyExists - The carrierServiceCode to be added already exists in the db
     */
    @PostMapping("/carrierservicecodes")
    public ResponseEntity<String> add(@RequestBody @Valid CarrierServiceCode carrierServiceCode) throws CarrierCodeCannotBeBlank, CarrierCodeMandatory, CarrierCodeCannotContainSpecialCharacters, CarrierCodeAlreadyExists, CarrierCodeNotFound, CarrierServiceCodeAlreadyExists, CarrierShipmentServiceMandatory, CarrierShipmentServiceCannotContainSpecialCharacters, CarrierShipmentServiceCannotBeBlank {
        carrierServiceCodeService.add(carrierServiceCode);
        return ResponseEntity.ok(carrierServiceCodeAdded);
    }

    /**
     * Updates an existing carrierServiceCode.
     *
     * @param carrierCode            - represents the key of carrierServiceCode
     * @param carrierShipmentService - represents the key of carrierServiceCode
     * @param carrierServiceCode     - the carrierServiceCode to be updated.
     * @return - on success, returns the success message.
     * @throws Exception - on failure, a global catch-all exception handler is called
     *                   which displays an appropriate error message.
     */
    @PutMapping("/carrierservicecodes/{carrierCode},{carrierShipmentService}")
    public ResponseEntity<String> update(@PathVariable String carrierCode,
                                         @PathVariable String carrierShipmentService,
                                         @RequestBody @Valid CarrierServiceCode carrierServiceCode) throws CarrierServiceCodeNotFound {
        carrierServiceCodeService.update(new CarrierServiceCodeKey(carrierCode, carrierShipmentService), carrierServiceCode);
        return ResponseEntity.ok(carrierServiceCodeUpdated);
    }

    /**
     * Deletes an existing carrierServiceCode.
     *
     * @param carrierCode            - represents the key of carrierServiceCode
     * @param carrierShipmentService - represents the key of carrierServiceCode
     * @return - on success, returns the success message.
     * @throws Exception - on failure, a global exception handler is called
     *                   which displays an appropriate error message.
     */
    @DeleteMapping("/carrierservicecodes/{carrierCode},{carrierShipmentService}")
    public ResponseEntity<String> delete(@PathVariable String carrierCode, @PathVariable String carrierShipmentService) throws CarrierServiceCodeNotFound {
        carrierServiceCodeService.delete(new CarrierServiceCodeKey(carrierCode, carrierShipmentService));
        return ResponseEntity.ok(carrierServiceCodeDeleted);
    }
}