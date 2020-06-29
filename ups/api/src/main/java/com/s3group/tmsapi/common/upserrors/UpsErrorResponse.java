package com.s3group.tmsapi.common.upserrors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.s3group.tmsapi.cancel.entity.CancelResponseHistory;
import com.s3group.tmsapi.parcel.entities.response.ParcelResponseHistory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author : Sachin Kulkarni
 * @date : 08-05-2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonRootName("response")
public class UpsErrorResponse {
  @Id
  @GeneratedValue
  @JsonIgnore
  private Long id;

  @JsonProperty("errors")
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "ups_error_response_id")
  @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
  private List<com.s3group.tmsapi.common.upserrors.Error> errors;

  @OneToOne(mappedBy = "upsErrorResponse")
  @JsonIgnore
  private ParcelResponseHistory parcelResponseHistory;

  @OneToOne(mappedBy = "upsErrorResponse")
  @JsonIgnore
  private CancelResponseHistory cancelResponseHistory;
}
