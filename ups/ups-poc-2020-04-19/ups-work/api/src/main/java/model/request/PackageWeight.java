package model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.common.UnitOfMeasurement;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PackageWeight {
  @JsonProperty("UnitOfMeasurement")
  private UnitOfMeasurement unitOfMeasurement;

  @JsonProperty("Weight")
  private String weight;
}
