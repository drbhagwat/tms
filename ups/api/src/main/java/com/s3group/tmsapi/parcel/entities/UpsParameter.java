package com.s3group.tmsapi.parcel.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.parcel.entities.request.ShipmentCharge;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
}
