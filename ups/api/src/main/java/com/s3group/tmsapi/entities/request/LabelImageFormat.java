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
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
public class LabelImageFormat {
  @Id
  @GeneratedValue
  private long id;

  @JsonProperty("Code")
  private String code;

  @JsonProperty("Description")
  private String description;
}
