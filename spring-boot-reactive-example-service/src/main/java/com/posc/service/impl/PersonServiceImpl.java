package com.posc.service.impl;

import com.posc.model.Person;
import com.posc.repository.PersonRepository;
import com.posc.service.PersonService;
import com.posc.service.mapper.PersonRepositoryToPersonMapper;
import com.posc.service.mapper.PersonToRepositoryPersonMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PersonServiceImpl implements PersonService {

  private final PersonRepository personRepository;
  private final PersonToRepositoryPersonMapper personToRepositoryPersonMapper;
  private final PersonRepositoryToPersonMapper personRepositoryToPersonMapper;

  public PersonServiceImpl(PersonRepository personRepository,
                           PersonToRepositoryPersonMapper personToRepositoryPersonMapper,
                           PersonRepositoryToPersonMapper personRepositoryToPersonMapper) {
    this.personRepository = personRepository;
    this.personToRepositoryPersonMapper = personToRepositoryPersonMapper;
    this.personRepositoryToPersonMapper = personRepositoryToPersonMapper;
  }

  @Override
  public Mono<Person> findOnePerson(String firstName) {
    return personRepository.findFirstByKeyFirstName(firstName).map(personRepositoryToPersonMapper);
  }

  @Override
  public Flux<Person> addPerson(Flux<Person> person) {
    return person.map(personToRepositoryPersonMapper)
                        .flatMap(personRepository::save)
                        .map(personRepositoryToPersonMapper);
  }

  @Override
  public Flux<Person> findByFirstName(String firstName) {
    return personRepository.findByKeyFirstName(firstName).map(personRepositoryToPersonMapper);
  }

  @Override
  public Mono<Person> addPerson(Mono<Person> person) {
    return person.map(personToRepositoryPersonMapper)
                 .flatMap(personRepository::save)
                 .map(personRepositoryToPersonMapper);
  }
}
