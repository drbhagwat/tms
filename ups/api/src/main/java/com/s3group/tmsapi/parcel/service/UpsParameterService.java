package com.s3group.tmsapi.parcel.service;

import com.s3group.tmsapi.parcel.entities.UpsParameter;
import com.s3group.tmsapi.parcel.repo.LabelImageFormatRepository;
import com.s3group.tmsapi.parcel.repo.LabelStockSizeRepository;
import com.s3group.tmsapi.parcel.repo.ShipmentChargeRepository;
import com.s3group.tmsapi.parcel.repo.UnitOfMeasurementRepository;
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
public class UpsParameterService {
  @Autowired
  private ShipmentChargeRepository shipmentChargeRepository;

  @Autowired
  private LabelImageFormatRepository labelImageFormatRepository;

  @Autowired
  private LabelStockSizeRepository labelStockSizeRepository;

  @Autowired
  private UnitOfMeasurementRepository unitOfMeasurementRepository;

  public UpsParameter getAllUpsParameters() {
    UpsParameter upsParameter = new UpsParameter();
    upsParameter.setShipmentChargeTypes(shipmentChargeRepository.getAllTypes());
    upsParameter.setImageFormats(labelImageFormatRepository.getAllImageFormatCode());
    upsParameter.setLabelStockHeightAndWidth(labelStockSizeRepository.getAllHeightAndWidth());
    upsParameter.setPackageDimensionCodes(unitOfMeasurementRepository.getAllDimensionCode());

    return upsParameter;
  }
}