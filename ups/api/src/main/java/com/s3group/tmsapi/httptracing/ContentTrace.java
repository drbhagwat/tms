package com.s3group.tmsapi.httptracing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentTrace {
  protected HttpTrace httpTrace;
  protected String requestBody;
  protected String responseBody;
  protected Authentication principal;
}