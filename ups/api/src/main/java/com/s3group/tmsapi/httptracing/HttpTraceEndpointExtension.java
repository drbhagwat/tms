package com.s3group.tmsapi.httptracing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.trace.http.HttpTraceEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@EndpointWebExtension(endpoint = HttpTraceEndpoint.class)
@ConditionalOnProperty(prefix = "management.trace.http", name = "include")
public class HttpTraceEndpointExtension {
  @Autowired
  private CustomHttpTraceRepository repository;

  @ReadOperation
  public ContentTraceDescriptor contents() {
    List<ContentTrace> traces = repository.findAllWithContent();
    return new ContentTraceDescriptor(traces);
  }
}