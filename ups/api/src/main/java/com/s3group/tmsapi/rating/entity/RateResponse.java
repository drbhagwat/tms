package com.s3group.tmsapi.rating.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.common.entities.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(value = { "Response" })
public class RateResponse {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("Response")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "response_id",
      referencedColumnName = "id")
  @JsonIgnore
  private Response response;

  @JsonProperty("RatedShipment")
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "rated_shipment_id")
  @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
  private List<RatedShipment> ratedShipments = new ArrayList<>();
}
