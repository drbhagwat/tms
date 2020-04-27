package model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionReference {
  @JsonProperty("CustomerContext")
  private String customerContext;

  @JsonProperty("TransactionIdentifier")
  private String transactionIdentifier;
}
