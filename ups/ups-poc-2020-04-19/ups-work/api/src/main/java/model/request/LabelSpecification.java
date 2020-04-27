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
  private LabelImageFormat labelImageFormat = new LabelImageFormat("GIF");
}
