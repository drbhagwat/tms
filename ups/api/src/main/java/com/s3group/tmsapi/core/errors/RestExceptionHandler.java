package com.s3group.tmsapi.core.errors;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@SuppressWarnings({"unchecked", "rawtypes"})
@Data
@NoArgsConstructor
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
  @Value("${TMS_EXCEPTION}")
  private String tmsException;

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<String> handleAllExceptions(Exception ex) {
    return new ResponseEntity(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
  }
}
