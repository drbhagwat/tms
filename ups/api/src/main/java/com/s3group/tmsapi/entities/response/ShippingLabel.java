package com.s3group.tmsapi.entities.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingLabel {
  @JsonProperty("ImageFormat")
  private ImageFormat imageFormat;

  @JsonProperty("GraphicImage")
  private String graphicImage;

  @JsonProperty("HTMLImage")
  private String hTMLImage;
}
