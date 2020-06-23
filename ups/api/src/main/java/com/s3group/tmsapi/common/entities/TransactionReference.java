package com.s3group.tmsapi.common.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.rating.entity.Request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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

  @OneToOne(mappedBy = "transactionReference")
  @JsonIgnore
  private Response response;

  @OneToOne(mappedBy = "transactionReference")
  @JsonIgnore
  private Request request;
}
