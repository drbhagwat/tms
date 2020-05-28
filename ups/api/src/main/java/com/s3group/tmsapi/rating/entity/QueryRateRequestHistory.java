package com.s3group.tmsapi.rating.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class QueryRateRequestHistory extends BasicLogger<String> {
  @Id
  private String transactionId;

  @JsonProperty("RateRequest")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "rate_request_id", referencedColumnName = "id")
  private RateRequest rateRequest;
}
