import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipment {
  @JsonProperty("originCountryCode")
  private String originCountryCode;

  @JsonProperty("originStateProvince")
  private String originStateProvince;

  @JsonProperty("originCityName")
  private String originCityName;

  @JsonProperty("originTownName")
  private String originTownName;

  @JsonProperty("originPostalCode")
  private String originPostalCode;

  @JsonProperty("destinationCountryCode")
  private String destinationCountryCode;

  @JsonProperty("destinationStateProvince")
  private String destinationStateProvince;

  @JsonProperty("destinationCityName")
  private String destinationCityName;

  @JsonProperty("destinationTownName")
  private String destinationTownName;

  @JsonProperty("destinationPostalCode")
  private String destinationPostalCode;

  @JsonProperty("weight")
  private String weight;

  @JsonProperty("weightUnitOfMeasure")
  private String weightUnitOfMeasure;

  @JsonProperty("shipmentContentsValue")
  private String shipmentContentsValue;

  @JsonProperty("shipmentContentsCurrencyCode")
  private String shipmentContentsCurrencyCode;

  @JsonProperty("billType")
  private String billType;

  @JsonProperty("requestType")
  private String requestType;

  @JsonProperty("shipDate")
  private String shipDate;

  @JsonProperty("shipTime")
  private String shipTime;

  @JsonProperty("residentialIndicator")
  private String residentialIndicator;

  @JsonProperty("numberOfPackages")
  private String numberOfPackages;

  @JsonProperty("returnUnfilteredServices")
  private boolean returnUnfilteredServices;

  @JsonProperty("returnHeavyGoodsServices")
  private boolean returnHeavyGoodsServices;

  @JsonProperty("dropOffAtFacilityIndicator")
  private int dropOffAtFacilityIndicator;

  @JsonProperty("holdForPickupIndicator")
  private int holdForPickupIndicator;
}
