package com.s3group.tmsapi.entities.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BillShipper {
  @Id
  @GeneratedValue
  private long id;

  @JsonProperty("AccountNumber")
  private String accountNumber;
}
