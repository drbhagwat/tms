package com.s3group.tmsapi.service;

import model.request.ParcelRequest;
import model.response.ParcelResponse;
import reactor.core.publisher.Mono;

import java.io.IOException;

public interface TMSClientService {
  Mono<ParcelResponse> ship(ParcelRequest request) throws IOException;
}
