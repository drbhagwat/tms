package com.s3group.tmsapi.common.service;

import com.s3group.tmsapi.common.entities.Phone;
import com.s3group.tmsapi.common.entities.ShipFrom;
import com.s3group.tmsapi.common.errors.ShipFromPhoneNumberNotFound;
import com.s3group.tmsapi.common.repo.ShipFromRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

  public Optional<ShipFrom> get(Phone phone) throws ShipFromPhoneNumberNotFound {
    List<ShipFrom> shipFromList = shipFromRepository.findByPhone_Number(phone.getNumber());

    if(shipFromList.isEmpty()) {
      throw new ShipFromPhoneNumberNotFound(shipFromPhoneNumberNotFound);
    } else {
      return shipFromList.stream().findFirst();
    }
  }
}