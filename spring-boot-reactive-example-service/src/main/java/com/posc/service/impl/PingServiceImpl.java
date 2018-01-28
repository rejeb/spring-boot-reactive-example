package com.posc.service.impl;

import com.posc.service.PingService;
import reactor.core.publisher.Mono;

public class PingServiceImpl implements PingService {


  public Mono<String> ping() {
    return Mono.just("pong");
  }
}
