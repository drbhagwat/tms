package com.s3group.tmsapi.entities.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Alert {
  @Id
  @GeneratedValue
  private long id;

  @JsonProperty("Code")
  private String code;

  @JsonProperty("Description")
  private String description;

  @JoinColumn
  @ManyToOne
  private Response response;
}
