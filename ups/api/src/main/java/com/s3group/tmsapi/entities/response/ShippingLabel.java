package com.s3group.tmsapi.entities.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShippingLabel {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("ImageFormat")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "image_format_id",
      referencedColumnName = "id")
  private ImageFormat imageFormat;

  @JsonProperty("GraphicImage")
  @Column(length=10485760)
  private String graphicImage;

  @JsonProperty("HTMLImage")
  @Column(length=10485760)
  private String hTMLImage;
}
