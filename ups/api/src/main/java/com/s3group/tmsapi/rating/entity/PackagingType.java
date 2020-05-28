package com.s3group.tmsapi.rating.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class PackagingType {
  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @JsonProperty("Code")
  private String code;
}
