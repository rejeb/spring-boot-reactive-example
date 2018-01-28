package com.posc.controller;

import com.posc.model.Person;
import com.posc.service.PersonService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PersonController {

  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping("/persons")
  public Mono<Person> addPerson(
    @RequestBody
      Mono<Person> person) {
    return personService.addPerson(person);
  }


  @RequestMapping(value = "/persons/{firstName}",method = RequestMethod.GET)
  public Flux<Person> findByFirstName(@PathVariable("firstName") String firstName){
    return personService.findByFirstName(firstName);
  }

  @RequestMapping(value = "/persons/{firstName}/one",method = RequestMethod.GET)
  public Mono<Person> findFirst(@PathVariable("firstName") String firstName){
    return personService.findOnePerson(firstName);
  }

}