package com.posc.controller;


import com.posc.model.Person;
import com.posc.service.PersonService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@RunWith(SpringRunner.class)

@WebMvcTest(value = {PersonController.class})
public abstract class PersonsControllerBase {

  @Autowired
  private PersonController personController;

  @MockBean
  private PersonService personService;

  @Before
  public void setup() {
    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController)
                                     .build();

    RestAssuredMockMvc.mockMvc(mockMvc);
    Person person = Person.builder()
                          .firstName("jane")
                          .dateOfBirth(LocalDateTime.of(2015, 1, 1, 12, 15, 0))
                          .lastName("doe")
                          .id(UUID.fromString("1fd21073-b3ff-48b2-9682-fd03c3951770"))
                          .gender("F")
                          .build();
    Mockito.when(personService.findOnePerson("jane")).thenReturn(Mono.just(person));
  }

}
