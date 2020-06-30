package com.s3group.tmsapi.httptracing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConditionalOnProperty(prefix = "management.trace.http", name = "include")
public class CustomHttpTraceRepository implements HttpTraceRepository {
  private final List<ContentTrace> contents = new LinkedList<>();

  @Autowired
  private ContentTraceManager traceManager;

  @Override
  public void add(HttpTrace trace) {
    synchronized (this.contents) {
      ContentTrace contentTrace = traceManager.getTrace();
      contentTrace.setHttpTrace(trace);
      this.contents.add(0, contentTrace);
    }
  }

  @Override
  public List<HttpTrace> findAll() {
    synchronized (this.contents) {
      return contents.stream().map(ContentTrace::getHttpTrace)
          .collect(Collectors.toList());
    }
  }

  public List<ContentTrace> findAllWithContent() {
    synchronized (this.contents) {
      return Collections.unmodifiableList(new ArrayList<>(this.contents));
    }
  }
}