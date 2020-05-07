import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentResponse {
  @JsonProperty("emsResponse")
  private EMSResponse emsResponse;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class EMSResponse {
    @JsonProperty("shipDate")
    private String shipDate;

    @JsonProperty("shipTime")
    private String shipTime;

    @JsonProperty("serviceLevel")
    private String serviceLevel;

    @JsonProperty("billType")
    private String billType;

    @JsonProperty("residentialIndicator")
    private String residentialIndicator;

    @JsonProperty("destinationCityName")
    private String destinationCityName;

    @JsonProperty("destinationCountryName")
    private String destinationCountryName;

    @JsonProperty("destinationCountryCode")
    private String destinationCountryCode;

    @JsonProperty("destinationPostalCode")
    private String destinationPostalCode;

    @JsonProperty("destinationStateProvince")
    private String destinationStateProvince;

    @JsonProperty("originCityName")
    private String originCityName;

    @JsonProperty("originCountryName")
    private String originCountryName;

    @JsonProperty("originCountryCode")
    private String originCountryCode;

    @JsonProperty("originPostalCode")
    private String originPostalCode;

    @JsonProperty("originStateProvince")
    private String originStateProvince;

    @JsonProperty("shipmentContentsCurrencyCode")
    private String shipmentContentsCurrencyCode;

    @JsonProperty("weightUnitOfMeasure")
    private String weightUnitOfMeasure;

    @JsonProperty("weight")
    private String weight;

    @JsonProperty("shipmentContentsValue")
    private String shipmentContentsValue;

    @JsonProperty("guaranteeSuspended")
    private boolean guaranteeSuspended;

    @JsonProperty("numberOfServices")
    private int numberOfServices;

    @JsonProperty("services")
    private List<ShipmentServiceDetail> services;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ShipmentServiceDetail {
      @JsonProperty("serviceLevel")
      private String serviceLevel;
      @JsonProperty("serviceLevelDescription")
      private String serviceLevelDescription;
      @JsonProperty("businessTransitDays")
      private int businessTransitDays;
      @JsonProperty("totalTransitDays")
      private int totalTransitDays;
      @JsonProperty("deliveryDate")
      private String deliveryDate;
      @JsonProperty("deliveryTime")
      private String deliveryTime;
      @JsonProperty("deliveryDayOfWeek")
      private String deliveryDayOfWeek;
      @JsonProperty("nextDayPickupIndicator")
      private String nextDayPickupIndicator;
      @JsonProperty("saturdayPickupIndicator")
      private String saturdayPickupIndicator;
      @JsonProperty("saturdayDeliveryIndicator")
      private String saturdayDeliveryIndicator;
      @JsonProperty("guaranteeIndicator")
      private String guaranteeIndicator;
      @JsonProperty("restDaysCount")
      private int restDaysCount;
      @JsonProperty("holidayCount")
      private int holidayCount;
      @JsonProperty("delayCount")
      private int delayCount;
      @JsonProperty("commitTime")
      private String commitTime;
      @JsonProperty("shipDate")
      private String shipDate;
      @JsonProperty("pickupTime")
      private String pickupTime;
      @JsonProperty("pickupDate")
      private String pickupDate;
      @JsonProperty("cstccutoffTime")
      private String cstccutoffTime;
      @JsonProperty("poddays")
      private int poddays;
    }
  }
}
