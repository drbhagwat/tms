package com.s3group.tmsapi.service;

import com.s3group.tmsapi.entities.request.ParcelRequest;
import com.s3group.tmsapi.entities.response.ParcelResponse;
import reactor.core.publisher.Mono;

import java.io.IOException;

public interface TMSClientService {
  Mono<ParcelResponse> ship(ParcelRequest request) throws IOException;
}
