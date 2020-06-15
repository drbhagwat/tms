package com.s3group.tmsapi.rating.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.common.entities.TransactionReference;
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
public class Request {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("Subversion")
  private String subversion;

  @JsonProperty("TransactionReference")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "transaction_reference_id",
      referencedColumnName = "id")
  private TransactionReference transactionReference;
}
