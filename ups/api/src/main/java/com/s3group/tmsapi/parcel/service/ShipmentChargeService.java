package com.s3group.tmsapi.parcel.service;

import com.s3group.tmsapi.parcel.repo.ShipmentChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author : Thamilarasi
 * @version : 1.0
 * @since : 2020-06-22
 */
@Service
@Transactional
public class ShipmentChargeService {
  @Autowired
  private ShipmentChargeRepository shipmentChargeRepository;

  public List<String> getAll() {
    return shipmentChargeRepository.getAllTypes();
  }
}