package com.posc.service;

import com.posc.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {

  Mono<Person> findOnePerson(String firstName);

  Flux<Person> findByFirstName(String firstName);

  Mono<Person> addPerson(Mono<Person> person);

  Flux<Person> addPerson(Flux<Person> person);

    Flux<Person> findAll();
}
