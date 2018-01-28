package com.posc.repository;

import com.posc.repository.model.Person;
import com.posc.repository.model.PersonKey;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository extends ReactiveCassandraRepository<Person,PersonKey> {

  Flux<Person> findByKeyFirstName(String firstName);

  Mono<Person> findFirstByKeyFirstName(String firstName);
}
