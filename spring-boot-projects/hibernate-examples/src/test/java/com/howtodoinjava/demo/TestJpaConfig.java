package com.howtodoinjava.demo;

import jakarta.activation.DataSource;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestJpaConfig {
  @Bean
  DataSource createDataSource() {
    return null;
  }
}
