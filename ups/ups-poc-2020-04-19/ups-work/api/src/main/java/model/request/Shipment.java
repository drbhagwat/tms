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
  private String description = "1206 PTR";

  @JsonProperty("Shipper")
  private Shipper shipper = new Shipper("ShipperName", "AttentionName",
      "TaxID", new Phone("1234567890"), "F47128", new Address("4124 " +
      "Chattahoochee Trace", "Duluth", "GA", "30097", "US"));

  @JsonProperty("ShipTo")
  private ShipTo shipTo;

  @JsonProperty("ShipFrom")
  private ShipFrom shipFrom = new ShipFrom("ShipperName", "AttentionName",
      new Phone("1234567890"), "1234567999", "456999", new Address("4124 " +
      "Chattahoochee Trace", "Duluth", "GA", "30097", "US"));
  ;

  @JsonProperty("PaymentInformation")
  private PaymentInformation paymentInformation =
      new PaymentInformation(new ShipmentCharge("01", new BillShipper("F47128"
      )));

  @JsonProperty("Service")
  private MyService service = new MyService("01", "Expedited");

  @JsonProperty("Package")
  private List<PackageElement> packageElements = new ArrayList<>();

  @JsonProperty("ItemizedChargesRequestedIndicator")
  private String itemizedChargesRequestedIndicator = "";

  @JsonProperty("RatingMethodRequestedIndicator")
  private String ratingMethodRequestedIndicator = "";

  @JsonProperty("TaxInformationIndicator")
  private String taxInformationIndicator = "";

  @JsonProperty("ShipmentRatingOptions")
  private ShipmentRatingOptions shipmentRatingOptions = new ShipmentRatingOptions("");
}
