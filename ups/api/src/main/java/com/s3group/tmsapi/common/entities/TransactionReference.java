package com.s3group.tmsapi.common.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TransactionReference {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("CustomerContext")
  private String customerContext;

  @JsonProperty("TransactionIdentifier")
  private String transactionIdentifier;
}
