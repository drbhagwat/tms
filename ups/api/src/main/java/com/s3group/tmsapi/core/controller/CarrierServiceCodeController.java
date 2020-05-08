package com.s3group.tmsapi.core.controller;

import com.s3group.tmsapi.core.entities.CarrierServiceCode;
import com.s3group.tmsapi.core.errors.*;
import com.s3group.tmsapi.core.services.CarrierServiceCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
     * Retrieves the CarrierServiceCode whose PK matches the given carrierServiceCodeKey.
     *
     * @param carrierServiceCodeKey - carrierServiceCode - the PK of the CarrierServiceCode entity
     * @return - on success, returns the found company
     * @throws CarrierCodeNotFound - this exception is thrown when CarrierServiceCode is not found in the db
     */
    @GetMapping("/carrierservicecodes/{carrierServiceCodeKey}")
    public CarrierServiceCode get(@PathVariable String carrierServiceCodeKey) throws CarrierCodeNotFound {
        return carrierServiceCodeService.getCarrierCode(carrierServiceCodeKey);
    }

    /**
     * Adds a new CarrierServiceCode.
     *
     * @param carrierServiceCode - the CarrierServiceCode which is to be added to the db
     * @return - on success, returns the appropriate message
     * @throws CarrierCodeAlreadyExists - The carrierServiceCode to be added already exists in the db
     */
    @PostMapping("/carrierservicecodes")
    public ResponseEntity<String> add(@RequestBody CarrierServiceCode carrierServiceCode) throws CarrierCodeCannotBeBlank, CarrierCodeMandatory, CarrierCodeCannotContainSpecialCharacters, CarrierCodeAlreadyExists {
        carrierServiceCodeService.add(carrierServiceCode);
        return ResponseEntity.ok(carrierServiceCodeAdded);
    }

    /**
     * Updates an existing CarrierServiceCode.
     *
     * @param carrierServiceCodeKey - PK of the CarrierServiceCode to be updated
     * @param carrierServiceCode    - contains the to be modified details
     * @return - on success, returns the appropriate message
     * @throws CarrierCodeNotFound - throws this exception when the CarrierServiceCode to be updated is not found in the db
     */
    @PutMapping("/carrierservicecodes/{carrierServiceCodeKey}")
    public ResponseEntity<String> update(@PathVariable String carrierServiceCodeKey, @RequestBody CarrierServiceCode carrierServiceCode) throws CarrierCodeNotFound {
        carrierServiceCodeService.update(carrierServiceCodeKey, carrierServiceCode);
        return ResponseEntity.ok(carrierServiceCodeUpdated);
    }

    /**
     * Deletes an existing CarrierServiceCode.
     *
     * @param carrierServiceCodeKey - PK of the CarrierServiceCode to be deleted
     * @return - on success, returns the appropriate message
     * @throws CarrierCodeNotFound - throws this exception when the CarrierServiceCode is not found
     */
    @DeleteMapping("/carrierservicecodes/{carrierServiceCodeKey}")
    public ResponseEntity<String> delete(@PathVariable String carrierServiceCodeKey) throws CarrierCodeNotFound {
        carrierServiceCodeService.delete(carrierServiceCodeKey);
        return ResponseEntity.ok(carrierServiceCodeDeleted);
    }
}