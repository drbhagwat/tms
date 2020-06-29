package com.s3group.tmsapi.cancel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SummaryResult {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("Status")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "status_id",
      referencedColumnName = "id")
  private Status status;

  @OneToOne(mappedBy = "summaryResult")
  @JsonIgnore
  private VoidShipmentResponse voidShipmentResponse;
}
