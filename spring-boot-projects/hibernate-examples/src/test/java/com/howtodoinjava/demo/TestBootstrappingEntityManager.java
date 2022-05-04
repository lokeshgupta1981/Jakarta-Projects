package com.howtodoinjava.demo;

import com.howtodoinjava.demo.data.EmployeeRepository;
import com.howtodoinjava.demo.data.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class TestBootstrappingEntityManager {

  @Autowired
  TestEntityManager em;

  @Autowired
  private EmployeeRepository repository;

  @Test
  public void contextLoads() {
    Assertions.assertNotNull(em);
  }

  @Test
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
