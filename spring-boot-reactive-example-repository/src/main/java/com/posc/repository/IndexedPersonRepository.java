package com.posc.repository;

import com.posc.repository.model.IndexedPerson;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import java.util.UUID;

public interface IndexedPersonRepository
  extends ElasticsearchCrudRepository<IndexedPerson, UUID> {
}
