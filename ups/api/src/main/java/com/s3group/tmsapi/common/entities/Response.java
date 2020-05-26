package com.s3group.tmsapi.common.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Response {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("ResponseStatus")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "response_status_id",
      referencedColumnName = "id")
  private ResponseStatus responseStatus;

  @JsonProperty("Alert")
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "response_id")
  @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
  private List<Alert> alerts = new ArrayList<>();

  @JsonProperty("TransactionReference")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "transaction_reference_id",
      referencedColumnName = "id")
  private TransactionReference transactionReference;
}