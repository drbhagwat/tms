package com.s3group.tmsapi.common.service;

import com.s3group.tmsapi.common.entities.Shipper;
import com.s3group.tmsapi.common.errors.ShipperNumberNotFound;
import com.s3group.tmsapi.common.repo.ShipperRepository;
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
public class ShipperService {

  @Value("${SHIPPER_NUMBER_NOT_FOUND}")
  private String shipperNumberNotFound;

  @Autowired
  private ShipperRepository shipperRepository;

  public Optional<Shipper> getShipper(Shipper shipper) throws ShipperNumberNotFound {
    List<Shipper> shipperList = shipperRepository.findByShipperNumber(shipper.getShipperNumber());

    if(shipperList.isEmpty()) {
      throw new ShipperNumberNotFound(shipperNumberNotFound);
    } else {
      return shipperList.stream().findFirst();
    }
  }
}