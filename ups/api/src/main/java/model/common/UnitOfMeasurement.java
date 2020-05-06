package model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UnitOfMeasurement {
  @JsonProperty("Code")
  private String code;

  @JsonProperty("Description")
  private String description;
}