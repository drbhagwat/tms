package model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Instruction {
  @JsonProperty("Code")
  private String code;

  @JsonProperty("Description")
  private String description;
}
