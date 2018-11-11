package com.posc.repository.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("person")
public class Person {

  @PrimaryKey
  private  PersonKey key;

  @Column("last_name")
  private String lastName;

  @Column
  private String gender;

  private Person() {
    key = null;
    lastName = null;
    gender = null;
  }

  public Person(final PersonKey key, final String lastName, final String gender) {
    this.key = key;
    this.lastName = lastName;
    this.gender = gender;
  }

    public Person setKey(PersonKey key) {
        this.key = key;
        return this;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Person setGender(String gender) {
        this.gender = gender;
        return this;
    }

    /**
   * Get key
   *
   * @return key
   */

  public PersonKey getKey() {
    return key;
  }

  /**
   * Get lastName
   *
   * @return lastName
   */

  public String getLastName() {
    return lastName;
  }

  /**
   * Get gender
   *
   * @return gender
   */

  public String getGender() {
    return gender;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Person))
      return false;
    Person person = (Person) o;
    return Objects.equal(key, person.key) && Objects.equal(lastName,
                                                           person.lastName) && Objects.equal(gender,
                                                                                             person.gender);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(key, lastName, gender);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
                      .add("key", key)
                      .add("lastName", lastName)
                      .add("gender", gender)
                      .toString();
  }
}

