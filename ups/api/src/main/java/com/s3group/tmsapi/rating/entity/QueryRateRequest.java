package com.s3group.tmsapi.rating.entity;

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
public class QueryRateRequest {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("RateRequest")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "rate_shipment_id",
      referencedColumnName = "id")
  private RateRequest rateRequest;
}
