package com.s3group.tmsapi.core.services;

import com.s3group.tmsapi.core.entities.CarrierServiceCode;
import com.s3group.tmsapi.core.errors.*;
import com.s3group.tmsapi.core.repo.CarrierServiceCodeRepository;
import com.s3group.tmsapi.core.validation.CarrierServiceCodeValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Create Read Update Delete (CRUD) services for CarrierServiceCode entity.
 *
 * @author : Anghulakshmi B
 * @version : 1.0
 * @since : 2020-05-06
 */
@Service
@Transactional
public class CarrierServiceCodeService {
    @Value("${CARRIER_CODE_NOT_FOUND}")
    private String carrierCodeNotFound;

    @Value("${CARRIER_CODE_ALREADY_EXISTS}")
    private String carrierCodeAlreadyExists;

    @Autowired
    private CarrierServiceCodeRepository carrierServiceCodeRepository;

    @Autowired
    private CarrierServiceCodeValidationService carrierServiceCodeValidationService;

    /**
     * Gets the first page of CarrierServiceCode found in the db (will be empty when there are no CarrierServiceCodes present in the db).
     *
     * @param pageNo   - page number
     * @param pageSize - page size
     * @param sortBy   - sort order (ascending/descending)
     * @param orderBy  - sort based on a key
     * @return - first page of the CarrierServiceCodes found.
     */
    public Page<CarrierServiceCode> getAll(Integer pageNo, Integer pageSize, String sortBy, String orderBy) {
        Pageable pageable = orderBy.equals("A") ? PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending())
                : PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        return carrierServiceCodeRepository.findAll(pageable);
    }

    /**
     * Retrieves the CarrierServiceCode whose PK matches the given carrierServiceCodeKey.
     *
     * @param carrierServiceCodeKey - PK of CarrierServiceCode
     * @return - on success, returns the found CarrierServiceCode
     * @throws CarrierCodeNotFound - on failure, throws this exception
     */
    public CarrierServiceCode getCarrierCode(String carrierServiceCodeKey) throws CarrierCodeNotFound {
        Optional<CarrierServiceCode> carrierServiceCode = carrierServiceCodeRepository.findById(carrierServiceCodeKey);

        if (carrierServiceCode.isEmpty()) throw new CarrierCodeNotFound(carrierCodeNotFound);

        return carrierServiceCode.get();
    }

    /**
     * Adds a new CarrierServiceCode.
     *
     * @param carrierServiceCode - the CarrierServiceCode which is to be added to the db
     * @return - on success, returns the appropriate message
     * @throws CarrierCodeAlreadyExists - The carrierServiceCode to be added already exists in the db
     */
    public CarrierServiceCode add(CarrierServiceCode carrierServiceCode) throws CarrierCodeCannotBeBlank, CarrierCodeCannotContainSpecialCharacters, CarrierCodeMandatory, CarrierCodeAlreadyExists {
        String carrierCode = carrierServiceCode.getCarrierCode();
        carrierServiceCodeValidationService.validate(carrierCode);
        Optional<CarrierServiceCode> tempCarrierServiceCode = carrierServiceCodeRepository.findById(carrierCode);

        if (tempCarrierServiceCode.isPresent()) {
            throw new CarrierCodeAlreadyExists(carrierCodeAlreadyExists);
        }
        carrierServiceCode.setCarrierCode(carrierCode);
        return carrierServiceCodeRepository.save(carrierServiceCode);
    }

    /**
     * Updates an existing CarrierServiceCode.
     *
     * @param carrierServiceCodeKey - PK of the CarrierServiceCode to be updated
     * @param carrierServiceCode    - contains the to be modified details
     * @return - on success, returns the appropriate message
     * @throws CarrierCodeNotFound - throws this exception when the CarrierServiceCode to be updated is not found in the db
     */
    public CarrierServiceCode update(String carrierServiceCodeKey, CarrierServiceCode carrierServiceCode) throws CarrierCodeNotFound {
        CarrierServiceCode existingCarrierServiceCode = getCarrierCode(carrierServiceCodeKey);
        existingCarrierServiceCode.setCarrierShipmentService(carrierServiceCode.getCarrierShipmentService());
        existingCarrierServiceCode.setDescription(carrierServiceCode.getDescription());
        return carrierServiceCodeRepository.save(existingCarrierServiceCode);
    }

    /**
     * Deletes an existing CarrierServiceCode.
     *
     * @param carrierServiceCodeKey - PK of the CarrierServiceCode to be deleted
     * @return - on success, returns the appropriate message
     * @throws CarrierCodeNotFound - throws this exception when the CarrierServiceCode is not found
     */
    public boolean delete(String carrierServiceCodeKey) throws CarrierCodeNotFound {
        CarrierServiceCode carrierServiceCode = getCarrierCode(carrierServiceCodeKey);
        carrierServiceCodeRepository.delete(carrierServiceCode);
        return true;
    }
}