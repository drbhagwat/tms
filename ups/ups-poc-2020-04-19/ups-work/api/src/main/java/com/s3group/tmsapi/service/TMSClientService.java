package com.s3group.tmsapi.service;

import model.request.ShipTo;
import model.response.GlobalResponse;
import reactor.core.publisher.Mono;

import java.io.IOException;

public interface TMSClientService {
  Mono<GlobalResponse> ship(ShipTo shipTo) throws IOException;
}
