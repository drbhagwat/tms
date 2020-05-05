package model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class LabelSpecification {
  @JsonProperty("LabelImageFormat")
  private LabelImageFormat labelImageFormat;

  @JsonProperty("LabelStockSize")
  private LabelStockSize labelStockSize;

  @JsonProperty("HTTPUserAgent")
  private String hTTPUserAgent = "Mozilla/4.5";

  @JsonProperty("Instruction")
  private Instruction instruction;

  @JsonProperty("CharSet")
  private String charSet = "eng";
}
