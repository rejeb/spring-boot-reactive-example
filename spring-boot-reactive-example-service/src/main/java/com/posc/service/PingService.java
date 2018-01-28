package com.posc.service;

import reactor.core.publisher.Mono;

public interface PingService {

  Mono<String> ping();
}
