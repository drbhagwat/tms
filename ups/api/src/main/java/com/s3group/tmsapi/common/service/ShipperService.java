package com.s3group.tmsapi.common.service;

import com.s3group.tmsapi.common.entities.Shipper;
import com.s3group.tmsapi.common.errors.ShipperNumberNotFound;
import com.s3group.tmsapi.common.repo.ShipperRepository;
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
public class ShipperService {

  @Value("${SHIPPER_NUMBER_NOT_FOUND}")
  private String shipperNumberNotFound;

  @Autowired
  private ShipperRepository shipperRepository;

  public Shipper getShipper(String shipperNumber) throws ShipperNumberNotFound {
    Shipper shipper = shipperRepository.findFirstByShipperNumber(shipperNumber);

    if(shipper == null) {
      throw new ShipperNumberNotFound(shipperNumberNotFound);
    } else {
      return shipper;
    }
  }
}