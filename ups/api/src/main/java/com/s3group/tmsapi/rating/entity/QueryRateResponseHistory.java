package com.s3group.tmsapi.rating.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.common.upserrors.UpsErrorResponse;
import com.s3group.tmsapi.master.entities.BasicLogger;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@EqualsAndHashCode(callSuper=true)
public class QueryRateResponseHistory extends BasicLogger<String> {
  @Id
  private String transactionId;

  private String criteria;

  @JsonProperty("response")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ups_error_response_id", referencedColumnName = "id")
  private UpsErrorResponse upsErrorResponse;

  @JsonProperty("RateResponse")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "rate_response_id", referencedColumnName = "id")
  private RateResponse rateResponse;
}
