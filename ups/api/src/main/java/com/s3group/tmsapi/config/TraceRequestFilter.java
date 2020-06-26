package com.s3group.tmsapi.config;

import org.springframework.boot.actuate.trace.http.HttpExchangeTracer;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.web.trace.servlet.HttpTraceFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class TraceRequestFilter extends HttpTraceFilter {
  private static final String RESPONSE_BODY = "resBody";
  private static final String REQUEST_BODY = "reqBody";

  public TraceRequestFilter(HttpTraceRepository repository, HttpExchangeTracer tracer) {
    super(repository, tracer);
  }

  @Override
  protected boolean shouldNotFilter(HttpServletRequest request) {
    return request.getServletPath().contains("actuator");
  }
}
