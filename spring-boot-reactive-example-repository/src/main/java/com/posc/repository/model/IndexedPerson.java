package com.posc.repository.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document(indexName = "person")
public class IndexedPerson {


  private final String firstName;

  private final LocalDateTime dateOfBirth;
  @Id
  private final UUID id;

  private final String lastName;

  private final String gender;

  private IndexedPerson() {
    firstName = null;
    dateOfBirth = null;
    id = null;
    lastName = null;
    gender = null;
  }

  private IndexedPerson(String firstName,
                        LocalDateTime dateOfBirth,
                        UUID id,
                        String lastName,
                        String gender) {
    this.firstName = firstName;
    this.dateOfBirth = dateOfBirth;
    this.id = id;
    this.lastName = lastName;
    this.gender = gender;
  }

  public static Builder builder(){
    return new Builder();
  }

  public String getFirstName() {
    return firstName;
  }

  public LocalDateTime getDateOfBirth() {
    return dateOfBirth;
  }

  public UUID getId() {
    return id;
  }

  public String getLastName() {
    return lastName;
  }

  public String getGender() {
    return gender;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof IndexedPerson))
      return false;
    IndexedPerson that = (IndexedPerson) o;
    return Objects.equal(firstName, that.firstName) && Objects.equal(dateOfBirth,
                                                                     that.dateOfBirth) && Objects.equal(
      id,
      that.id) && Objects.equal(lastName, that.lastName) && Objects.equal(gender, that.gender);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(firstName, dateOfBirth, id, lastName, gender);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
                      .add("firstName", firstName)
                      .add("dateOfBirth", dateOfBirth)
                      .add("id", id)
                      .add("lastName", lastName)
                      .add("gender", gender)
                      .toString();
  }

  public static class Builder {

    private String firstName;
    private LocalDateTime dateOfBirth;
    private UUID id;
    private String lastName;
    private String gender;

    public Builder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public Builder dateOfBirth(LocalDateTime dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
      return this;
    }

    public Builder id(UUID id) {
      this.id = id;
      return this;
    }

    public Builder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public Builder gender(String gender) {
      this.gender = gender;
      return this;
    }

    public IndexedPerson build() {
      return new IndexedPerson(firstName, dateOfBirth, id, lastName, gender);
    }
  }
}
