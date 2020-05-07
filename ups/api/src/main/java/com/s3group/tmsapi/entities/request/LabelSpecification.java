package com.s3group.tmsapi.entities.request;

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

  @JsonProperty("HTTPUserAgent")
  private String hTTPUserAgent = "Mozilla/4.5";

  @JsonProperty("Instruction")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "instruction_id",
      referencedColumnName = "id")
  private Instruction instruction;

  @JsonProperty("CharSet")
  private String charSet = "eng";
}
