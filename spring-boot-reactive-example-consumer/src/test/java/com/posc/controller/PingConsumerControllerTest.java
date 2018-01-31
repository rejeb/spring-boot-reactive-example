package com.posc.controller;

import com.posc.Application;
import com.posc.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@ActiveProfiles("it")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
                classes = {Application.class})
@AutoConfigureStubRunner
public class PingConsumerControllerTest {
  @Autowired
  private TestRestTemplate testRestTemplate;



  @Test
  public void testPing() {
    String pong = testRestTemplate.getForObject("/ping", String.class);

    assertEquals("Hello pong.", pong);
  }


  @Test
  public void testPerson() {
    String pong = testRestTemplate.getForObject("/persons/jane/one", String.class);

    assertNotNull(pong);
  }

}
