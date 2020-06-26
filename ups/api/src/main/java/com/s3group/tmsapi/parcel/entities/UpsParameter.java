package com.s3group.tmsapi.parcel.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class UpsParameter {
  private List<String> shipmentChargeTypes;
  private List<String> ImageFormats;
  private List<String> LabelStockHeightAndWidth;
  private List<String> PackageDimensionCodes;
  private String transactionNumber;
}
