package com.s3group.tmsapi.common.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.s3group.tmsapi.parcel.entities.response.ShipmentResponse;
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
public class ResponseStatus {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("Code")
  private String code;

  @JsonProperty("Description")
  private String description;

  @OneToOne(mappedBy = "responseStatus")
  @JsonIgnore
  private Response response;
}
