package com.s3group.tmsapi.common.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TransactionId {
  @JsonIgnore
  private String prefix;

  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @Transient
  private String transactionNumber;
}