package com.s3group.tmsapi.parcel.entities.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
public class LabelSpecification {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("LabelImageFormat")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "label_image_format_id",
      referencedColumnName = "id")
  private LabelImageFormat labelImageFormat;

  @JsonProperty("LabelStockSize")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "label_stock_size_id",
      referencedColumnName = "id")
  private LabelStockSize labelStockSize;

  @OneToOne(mappedBy = "labelSpecification")
  @JsonIgnore
  private ShipmentRequest shipmentRequest;
}
