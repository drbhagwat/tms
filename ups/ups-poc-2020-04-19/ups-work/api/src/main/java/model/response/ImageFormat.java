package model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageFormat {
  @JsonProperty("Code")
  private String code;

  @JsonProperty("Description")
  private String description;
}
