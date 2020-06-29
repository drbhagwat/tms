package com.s3group.tmsapi.parcel.service;

import com.s3group.tmsapi.common.entities.TransactionId;
import com.s3group.tmsapi.common.service.TransactionIdService;
import com.s3group.tmsapi.parcel.entities.UpsParameter;
import com.s3group.tmsapi.parcel.repo.LabelImageFormatRepository;
import com.s3group.tmsapi.parcel.repo.LabelStockSizeRepository;
import com.s3group.tmsapi.parcel.repo.ShipmentChargeRepository;
import com.s3group.tmsapi.parcel.repo.UnitOfMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Thamilarasi
 * @version : 1.0
 * @since : 2020-06-23
 */
@Service
@Transactional
public class UpsParameterService {
    @Autowired
    TransactionIdService transactionIdService;

    public UpsParameter getAllUpsParameters() {
        ArrayList<String> shipmentChargeTypes = new ArrayList<>();
        shipmentChargeTypes.add("01");
        shipmentChargeTypes.add("02");
        shipmentChargeTypes.add("03");
        ArrayList<String> imageFormats = new ArrayList<>();
        imageFormats.add("GIF");
        imageFormats.add("ZPL");
        ArrayList<String> heightAndWeight = new ArrayList<>();
        heightAndWeight.add("6,4");
        heightAndWeight.add("8,4");
        ArrayList<String> dimensionCode = new ArrayList<>();
        dimensionCode.add("IN");
        dimensionCode.add("CM");

        UpsParameter upsParameter = new UpsParameter();
        upsParameter.setShipmentChargeTypes(shipmentChargeTypes);
        upsParameter.setImageFormats(imageFormats);
        upsParameter.setLabelStockHeightAndWidth(heightAndWeight);
        upsParameter.setPackageDimensionCodes(dimensionCode);

        TransactionId transactionId = transactionIdService.get();
        upsParameter.setTransactionNumber(transactionId.getTransactionNumber());
        return upsParameter;
    }
}