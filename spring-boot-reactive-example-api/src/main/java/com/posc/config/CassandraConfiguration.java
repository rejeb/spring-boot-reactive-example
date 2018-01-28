package com.posc.config;

import com.posc.repository.PersonRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@Configuration
@EnableReactiveCassandraRepositories(basePackageClasses = PersonRepository.class)
public class CassandraConfiguration{

}
