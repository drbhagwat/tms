package model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Shipment {
  @JsonProperty("Description")
  private String description;

  @JsonProperty("Shipper")
  private ShippingInfo shipper;

  @JsonProperty("ShipTo")
  private ShippingInfo shipTo;

  @JsonProperty("ShipFrom")
  private ShippingInfo shipFrom;

  @JsonProperty("PaymentInformation")
  private PaymentInformation paymentInformation;

  @JsonProperty("Service")
  private MyService service;

  @JsonProperty("Package")
  private List<PackageElement> packageElements;

  @JsonProperty("ItemizedChargesRequestedIndicator")
  private String itemizedChargesRequestedIndicator;

  @JsonProperty("RatingMethodRequestedIndicator")
  private String ratingMethodRequestedIndicator;

  @JsonProperty("TaxInformationIndicator")
  private String taxInformationIndicator;

  @JsonProperty("ShipmentRatingOptions")
  private ShipmentRatingOptions shipmentRatingOptions;
}
