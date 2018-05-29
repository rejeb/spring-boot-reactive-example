package com.posc.service.mapper;



import com.posc.model.Person;
import com.posc.repository.model.IndexedPerson;

import java.util.function.Function;

public class PersonToIndexedPersonMapper implements Function<Person,IndexedPerson> {


  @Override
  public IndexedPerson apply(Person person) {
    return IndexedPerson.builder().firstName(person.getFirstName())
                 .dateOfBirth(person.getDateOfBirth())
                 .id(person.getId())
                 .lastName(person.getLastName())
                 .gender(person.getGender())
                 .build();
  }
}
