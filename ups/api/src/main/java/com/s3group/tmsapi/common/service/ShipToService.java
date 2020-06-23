package com.s3group.tmsapi.common.service;

import com.s3group.tmsapi.common.entities.Phone;
import com.s3group.tmsapi.common.entities.ShipTo;
import com.s3group.tmsapi.common.errors.ShipToPhoneNumberNotFound;
import com.s3group.tmsapi.common.repo.ShipToRepository;
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
public class ShipToService {

  @Value("${SHIP_TO_NUMBER_NOT_FOUND}")
  private String shipToPhoneNumberNotFound;

  @Autowired
  private ShipToRepository shipToRepository;

  public Optional<ShipTo> get(Phone phone) throws ShipToPhoneNumberNotFound {
    List<ShipTo> shipToList = shipToRepository.findByPhone_Number(phone.getNumber());

    if(shipToList.isEmpty()) {
      throw new ShipToPhoneNumberNotFound(shipToPhoneNumberNotFound);
    } else {
      return shipToList.stream().findFirst();
    }
  }
}