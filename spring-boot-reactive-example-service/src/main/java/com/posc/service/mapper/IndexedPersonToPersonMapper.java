package com.posc.service.mapper;

import com.posc.model.Person;
import com.posc.repository.model.IndexedPerson;

import java.util.function.Function;

public class IndexedPersonToPersonMapper implements Function<IndexedPerson,Person> {


  @Override
  public Person apply(IndexedPerson person) {

    return Person.builder().firstName(person.getFirstName())
      .dateOfBirth(person.getDateOfBirth())
      .id(person.getId())
      .lastName(person.getLastName())
      .gender(person.getGender())
      .build();
  }
}
