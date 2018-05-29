package com.posc.controller;

import com.posc.model.Person;
import com.posc.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("${server.servlet.context-path}/persons")
public class PersonController {

  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping("/one")
  public Mono<ResponseEntity<Person>> addPerson(
    @RequestBody
      Mono<Person> person) {
    return personService.addPerson(person)
                        .map(ResponseEntity::ok)
                        .defaultIfEmpty(ResponseEntity.badRequest().build());
  }

  @PostMapping("")
  public ResponseEntity<Flux<Person>> addPerson(
    @RequestBody
      Flux<Person> persons) {
    return ResponseEntity.status(CREATED).body(personService.addPerson(persons));
  }

  @RequestMapping(value = "/{firstName}", method = RequestMethod.GET)
  public Flux<Person> findByFirstName(
    @PathVariable("firstName")
      String firstName) {
    return personService.findByFirstName(firstName);
  }

  @RequestMapping(value = "/{firstName}/one", method = RequestMethod.GET)
  public Mono<ResponseEntity<Person>> findFirst(
    @PathVariable("firstName")
      String firstName) {
    return personService.findOnePerson(firstName)
                        .map(ResponseEntity::ok)
                        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

}
