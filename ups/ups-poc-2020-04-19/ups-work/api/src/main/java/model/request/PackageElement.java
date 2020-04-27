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
public class PackageElement {
  @JsonProperty("Description")
  private String description;

  @JsonProperty("Packaging")
  private Packaging packaging;

  @JsonProperty("PackageWeight")
  private PackageWeight packageWeight;

  @JsonProperty("PackageServiceOptions")
  private String packageServiceOptions;
}
