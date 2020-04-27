package model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.common.UnitOfMeasurement;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingWeight {
  @JsonProperty("UnitOfMeasurement")
  private UnitOfMeasurement unitOfMeasurement;

  @JsonProperty("Weight")
  private String weight;
}
