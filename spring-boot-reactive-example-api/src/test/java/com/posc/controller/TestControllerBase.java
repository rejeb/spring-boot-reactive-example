package com.posc.controller;



import com.posc.service.PingService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;


@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
public abstract class TestControllerBase {


  @Autowired
  private TestController testController;

  @MockBean
  private PingService pingService;

  @Before
  public void setup() {
    RestAssuredMockMvc.standaloneSetup(testController);

    Mockito.when(pingService.ping())
           .thenReturn(Mono.just("Hello pong."));

  }

}
