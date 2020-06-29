package com.s3group.tmsapi.common.service;

import com.s3group.tmsapi.common.entities.ShipTo;
import com.s3group.tmsapi.common.errors.ShipToPhoneNumberNotFound;
import com.s3group.tmsapi.common.repo.ShipToRepository;
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
public class ShipToService {

  @Value("${SHIP_TO_NUMBER_NOT_FOUND}")
  private String shipToPhoneNumberNotFound;

  @Autowired
  private ShipToRepository shipToRepository;

  public ShipTo get(String shipToPhoneNumber) throws ShipToPhoneNumberNotFound {
    ShipTo shipTo = shipToRepository.findFirstByPhone_Number(shipToPhoneNumber);

    if(shipTo == null) {
      throw new ShipToPhoneNumberNotFound(shipToPhoneNumberNotFound);
    } else {
      return shipTo;
    }
  }
}