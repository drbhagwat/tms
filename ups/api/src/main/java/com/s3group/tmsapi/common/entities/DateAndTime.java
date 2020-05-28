package com.s3group.tmsapi.common.entities;

import com.s3group.tmsapi.rating.entity.GuaranteedDelivery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DateAndTime {
  Double daysInTransit = 0.0;
  String deliveryTime = null;
  String amOrPm = null;
  Double hours = 0.0;

  public DateAndTime(GuaranteedDelivery guaranteedDelivery) {
    deliveryTime = guaranteedDelivery.getDeliveryByTime();
    daysInTransit = Double.parseDouble(guaranteedDelivery.getBusinessDaysInTransit());

    if (deliveryTime != null) {
      amOrPm = deliveryTime.substring(deliveryTime.indexOf(" ") + 1);
      String temp = deliveryTime.substring(0, deliveryTime.indexOf(" "))
          .replace(':', '.');
      hours = Double.parseDouble(temp);
    }
  }

  public void init(String deliveryTime, Double daysInTransit) {
    this.daysInTransit = daysInTransit;
    this.deliveryTime = deliveryTime;

    if (deliveryTime != null) {
      this.amOrPm = deliveryTime.substring(deliveryTime.indexOf(" ") + 1);
      String temp = deliveryTime.substring(0, deliveryTime.indexOf(" "))
          .replace(':', '.');
      this.hours = Double.parseDouble(temp);
    } else {
      this.amOrPm = null;
      this.hours = 0.0;
    }
  }

  public void init(String deliveryTime) {
    this.deliveryTime = deliveryTime;

    if (deliveryTime != null) {
      this.amOrPm = deliveryTime.substring(deliveryTime.indexOf(" ") + 1);
      String temp = deliveryTime.substring(0, deliveryTime.indexOf(" "))
          .replace(':', '.');
      this.hours = Double.parseDouble(temp);
    } else {
      this.amOrPm = null;
      this.hours = 0.0;
    }
  }
}
