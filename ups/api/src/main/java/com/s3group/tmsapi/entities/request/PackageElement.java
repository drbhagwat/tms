package com.s3group.tmsapi.entities.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
public class PackageElement {
  @Id
  @GeneratedValue
  private long id;

  @JsonProperty("Description")
  private String description;

  @JsonProperty("Packaging")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "packaging_id", referencedColumnName = "id")
  private Packaging packaging;

  @JsonProperty("PackageWeight")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "package_weight_id", referencedColumnName = "id")
  private PackageWeight packageWeight;

  @JsonProperty("PackageServiceOptions")
  private String packageServiceOptions;

  @JoinColumn
  @ManyToOne
  private Shipment shipment;
}
