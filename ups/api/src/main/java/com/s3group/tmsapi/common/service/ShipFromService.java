package com.s3group.tmsapi.common.service;

import com.s3group.tmsapi.common.entities.ShipFrom;
import com.s3group.tmsapi.common.errors.ShipFromPhoneNumberNotFound;
import com.s3group.tmsapi.common.repo.ShipFromRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author : Thamilarasi
 * @version : 1.0
 * @since : 2020-06-22
 */
@Service
@Transactional
public class ShipFromService {

  @Value("${SHIP_FROM_NUMBER_NOT_FOUND}")
  private String shipFromPhoneNumberNotFound;

  @Autowired
  private ShipFromRepository shipFromRepository;

  public ShipFrom get(String shipFromPhoneNumber) throws ShipFromPhoneNumberNotFound {
   ShipFrom shipFrom = shipFromRepository.findFirstByPhone_Number(shipFromPhoneNumber);

    if(shipFrom == null) {
      throw new ShipFromPhoneNumberNotFound(shipFromPhoneNumberNotFound);
    } else {
      return shipFrom;
    }
  }
}