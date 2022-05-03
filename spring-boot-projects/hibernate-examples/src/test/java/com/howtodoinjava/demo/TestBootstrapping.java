package com.howtodoinjava.demo;

import com.howtodoinjava.demo.data.entity.Employee;
import com.howtodoinjava.demo.data.entity.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(TestJpaConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestBootstrapping {

  @Autowired
  TestEntityManager em;

  @Autowired
  private EmployeeRepository repository;

  @Test
  public void contextLoads() {
    Assertions.assertNotNull(em);
  }

  @Test
  @Transactional
  void verifyBootstrappingByPersistingAnEmployee() {
    Employee emp = new Employee();
    emp.setEmail("demo-user@email.com");
    emp.setFirstName("demo");
    emp.setLastName("user");

    Assertions.assertNull(emp.getEmployeeId());
    em.persist(emp);
    Assertions.assertNotNull(emp.getEmployeeId());
  }

  @Test
  @Transactional
  void verifyRepositoryByPersistingAnEmployee() {
    Employee emp = new Employee();
    emp.setEmail("demo-user@email.com");
    emp.setFirstName("demo");
    emp.setLastName("user");

    Assertions.assertNull(emp.getEmployeeId());
    repository.save(emp);
    Assertions.assertNotNull(emp.getEmployeeId());
  }
}
