package com.posc.config;

import com.datastax.driver.core.AuthProvider;
import com.datastax.driver.core.PlainTextAuthProvider;
import com.posc.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.core.convert.CassandraCustomConversions;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;
import org.springframework.data.convert.CustomConversions;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableReactiveCassandraRepositories(basePackageClasses = PersonRepository.class)
public class CassandraConfiguration extends AbstractReactiveCassandraConfiguration {

  @Value("${spring.data.cassandra.keyspace-name}")
  private String keyspaceName;

  @Value("${spring.data.cassandra.username}")
  private String username;


  @Value("${spring.data.cassandra.password}")
  private String password;

  @Override
  protected String getKeyspaceName() {
    return keyspaceName;
  }



  /**
   * Returns the {@link AuthProvider}.
   *
   * @return the {@link AuthProvider}, may be {@literal null}.
   */
  @Override
  protected AuthProvider getAuthProvider() {
    AuthProvider authProvider = new PlainTextAuthProvider(username, password);
    return authProvider;
  }
}

