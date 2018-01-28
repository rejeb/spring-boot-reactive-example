package com.posc.controller;

import com.posc.service.PingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestController {

  private final PingService pingService;

  public TestController(PingService pingService) {
    this.pingService = pingService;
  }

  @GetMapping("/ping")
  public Mono<ResponseEntity<String>> ping() {
    return pingService.ping().map(r -> ResponseEntity.ok(r));
  }
}
