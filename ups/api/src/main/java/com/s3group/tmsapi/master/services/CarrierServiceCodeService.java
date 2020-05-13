package com.s3group.tmsapi.master.services;

import com.s3group.tmsapi.master.entities.CarrierServiceCode;
import com.s3group.tmsapi.master.entities.CarrierServiceCodeKey;
import com.s3group.tmsapi.master.errors.*;
import com.s3group.tmsapi.master.repo.CarrierServiceCodeRepository;
import com.s3group.tmsapi.master.validation.CarrierServiceCodeValidationService;
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
    @Value("${CARRIER_SERVICE_CODE_NOT_FOUND}")
    private String carrierServiceCodeNotFound;

    @Value("${CARRIER_SERVICE_CODE_ALREADY_EXISTS}")
    private String carrierServiceCodeAlreadyExists;

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
    public CarrierServiceCode getCarrierServiceCode(CarrierServiceCodeKey carrierServiceCodeKey) throws CarrierServiceCodeNotFound {
        Optional<CarrierServiceCode> carrierServiceCode = carrierServiceCodeRepository.findById(carrierServiceCodeKey);

        if (carrierServiceCode.isEmpty()) throw new CarrierServiceCodeNotFound(carrierServiceCodeNotFound);

        return carrierServiceCode.get();
    }

    /**
     * Adds a new CarrierServiceCode.
     *
     * @param carrierServiceCode - the CarrierServiceCode which is to be added to the db
     * @return - on success, returns the appropriate message
     * @throws CarrierCodeAlreadyExists - The carrierServiceCode to be added already exists in the db
     */
    public CarrierServiceCode add(CarrierServiceCode carrierServiceCode) throws CarrierCodeCannotBeBlank, CarrierCodeCannotContainSpecialCharacters, CarrierCodeMandatory, CarrierServiceCodeAlreadyExists, CarrierShipmentServiceMandatory, CarrierShipmentServiceCannotContainSpecialCharacters, CarrierShipmentServiceCannotBeBlank {
        CarrierServiceCodeKey carrierServiceCodeKey = carrierServiceCode.getId();
        carrierServiceCodeKey = carrierServiceCodeValidationService.validateCode(carrierServiceCodeKey);

        Optional<CarrierServiceCode> optionalCarrierServiceCode = carrierServiceCodeRepository.findById(carrierServiceCodeKey);

        if (optionalCarrierServiceCode.isPresent()) {
            throw new CarrierServiceCodeAlreadyExists(carrierServiceCodeAlreadyExists);
        }
        carrierServiceCode.setId(carrierServiceCodeKey);
        carrierServiceCode.setDescription(carrierServiceCode.getDescription());
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
    public CarrierServiceCode update(CarrierServiceCodeKey carrierServiceCodeKey, CarrierServiceCode carrierServiceCode) throws CarrierServiceCodeNotFound {
        CarrierServiceCode existingCarrierServiceCode = getCarrierServiceCode(carrierServiceCodeKey);
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
    public boolean delete(CarrierServiceCodeKey carrierServiceCodeKey) throws CarrierServiceCodeNotFound {
        CarrierServiceCode carrierServiceCode = getCarrierServiceCode(carrierServiceCodeKey);
        carrierServiceCodeRepository.delete(carrierServiceCode);
        return true;
    }
}