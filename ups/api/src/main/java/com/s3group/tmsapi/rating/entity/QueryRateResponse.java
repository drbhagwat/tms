package com.s3group.tmsapi.rating.entity;

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
public class QueryRateResponse {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("RateResponse")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "rate_response_id",
      referencedColumnName = "id")
  private RateResponse rateResponse;
}
