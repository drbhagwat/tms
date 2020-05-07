package com.s3group.tmsapi.entities.response;

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
  private long id;

  @JsonProperty("ResponseStatus")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "response_status_id",
      referencedColumnName = "id")
  private ResponseStatus responseStatus;

  @JsonProperty("Alert")
  @OneToMany(cascade =
      CascadeType.ALL,
      orphanRemoval = true)
  @JoinColumn(name = "response_id")
  private List<Alert> alerts = new ArrayList<>();

  @JsonProperty("TransactionReference")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "transaction_reference_id",
      referencedColumnName = "id")
  private TransactionReference transactionReference;
}