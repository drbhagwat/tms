package com.s3group.tmsapi.entities.upserrors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Error {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  private String code;
  private String message;

  @JsonIgnore
  @JoinColumn
  @ManyToOne
  private UpsErrorResponse upsErrorResponse;
}
