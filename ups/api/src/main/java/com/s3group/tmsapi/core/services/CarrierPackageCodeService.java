package com.s3group.tmsapi.core.services;

import com.s3group.tmsapi.core.entities.CarrierPackageCode;
import com.s3group.tmsapi.core.entities.CarrierPackageCodeKey;
import com.s3group.tmsapi.core.entities.CarrierServiceCode;
import com.s3group.tmsapi.core.errors.*;
import com.s3group.tmsapi.core.repo.CarrierPackageCodeRepository;
import com.s3group.tmsapi.core.repo.CarrierServiceCodeRepository;
import com.s3group.tmsapi.core.validation.CarrierPackageCodeValidationService;
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
 * Create Read Update Delete (CRUD) services for CarrierPackageCode entity.
 *
 * @author : Anghulakshmi B
 * @version : 1.0
 * @since : 2020-05-07
 */
@Service
@Transactional
public class CarrierPackageCodeService {
    @Value("${CARRIER_PACKAGE_CODE_NOT_FOUND}")
    private String carrierPackageCodeNotFound;

    @Value("${CARRIER_PACKAGE_CODE_ALREADY_EXISTS}")
    private String carrierPackageCodeAlreadyExists;

    @Autowired
    private CarrierPackageCodeRepository carrierPackageCodeRepository;

    @Autowired
    private CarrierServiceCodeRepository carrierServiceCodeRepository;

    @Autowired
    private CarrierPackageCodeValidationService carrierPackageCodeValidationService;

    /**
     * Gets the first page of carrierPackageCodes found in the db (will be empty when there are no carrierPackageCodes present in the
     * db).
     *
     * @param pageNo   - page number
     * @param pageSize - page size
     * @param sortBy   - sort order (ascending/descending)
     * @param orderBy  - sort based on a key
     * @return - first page of the carrierPackageCodes found.
     */
    public Page<CarrierPackageCode> getAll(Integer pageNo, Integer pageSize, String sortBy, String orderBy) {
        Pageable pageable = orderBy.equals("A") ? PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending())
                : PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        return carrierPackageCodeRepository.findAll(pageable);
    }

    /**
     * Retrieves the carrierPackageCode whose PK matches the given carrierPackageCodeKey.
     *
     * @param carrierPackageCodeKey - PK of carrierPackageCode
     * @return - on success, returns the found carrierPackageCode
     * @throws CarrierPackageCodeNotFound - on failure, throws this exception
     */
    public CarrierPackageCode getCarrierPackageCode(CarrierPackageCodeKey carrierPackageCodeKey) throws CarrierPackageCodeNotFound {
        Optional<CarrierPackageCode> carrierPackageCode = carrierPackageCodeRepository.findById(carrierPackageCodeKey);

        if (carrierPackageCode.isEmpty()) throw new CarrierPackageCodeNotFound(carrierPackageCodeNotFound);

        return carrierPackageCode.get();
    }

    /**
     * Adds a new CarrierPackageCode
     *
     * @param carrierPackageCode - the carrierPackageCode to be added to the db
     * @return - on success, returns the division added into the db
     * @throws CarrierPackageCodeCannotContainSpecialCharacters - The carrierPackageCode contains a character which is not
     *                                                          allowed
     * @throws CarrierCodeCannotContainSpecialCharacters        - The carrierCode contains a character which is not
     *                                                          allowed
     * @throws CarrierPackageCodeAlreadyExists              - carrierPackageCode is not found in the db.
     */
    public CarrierPackageCode add(CarrierPackageCode carrierPackageCode) throws CarrierPackageCodeAlreadyExists, CarrierPackageCodeCannotContainSpecialCharacters, CarrierCodeCannotContainSpecialCharacters, CarrierPackageCodeCannotBeBlank, CarrierCodeMandatory, CarrierPackageCodeMandatory, CarrierCodeCannotBeBlank {
        CarrierPackageCodeKey carrierPackageCodeKey = carrierPackageCode.getId();
        carrierPackageCodeKey = carrierPackageCodeValidationService.validate(carrierPackageCodeKey);

        Optional<CarrierPackageCode> tempCarrierPackageCode = carrierPackageCodeRepository.findById(carrierPackageCodeKey);

        if (tempCarrierPackageCode.isPresent()) {
            throw new CarrierPackageCodeAlreadyExists(carrierPackageCodeAlreadyExists);
        }
        carrierPackageCode.setId(carrierPackageCodeKey);
        carrierPackageCode.setDescription(carrierPackageCode.getDescription());
        return carrierPackageCodeRepository.save(carrierPackageCode);
    }

    /**
     * Updates an existing carrierPackageCode in the db.
     *
     * @param carrierPackageCodeKey - PK of the carrierPackageCode
     * @param carrierPackageCode    - the carrierPackageCode to be updated
     * @return - on success, returns the updated carrierPackageCode
     * @throws CarrierPackageCodeNotFound - carrierPackageCode is not found with the match.
     */
    public CarrierPackageCode update(CarrierPackageCodeKey carrierPackageCodeKey, CarrierPackageCode carrierPackageCode) throws CarrierPackageCodeNotFound {
        CarrierPackageCode existingCarrierPackageCode = getCarrierPackageCode(carrierPackageCodeKey);
        existingCarrierPackageCode.setDescription(carrierPackageCode.getDescription());
        return carrierPackageCodeRepository.save(existingCarrierPackageCode);
    }

    /**
     * Deletes an existing carrierPackageCode from the database.
     *
     * @param carrierPackageCodeKey - PK of the carrierPackageCode to be deleted.
     * @throws CarrierPackageCodeNotFound - on failure, throws this exception.
     */
    public boolean delete(CarrierPackageCodeKey carrierPackageCodeKey) throws CarrierPackageCodeNotFound {
        carrierPackageCodeRepository.delete(getCarrierPackageCode(carrierPackageCodeKey));
        return true;
    }
}