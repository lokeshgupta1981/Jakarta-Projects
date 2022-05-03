package com.howtodoinjava.demo.data.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "TBL_EMPLOYEE")
public class Employee implements Serializable {

  @Serial
  private static final long serialVersionUID = -1;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Integer employeeId;

  @Column
  private String email;

  @Column
  private String firstName;

  @Column
  private String lastName;

  public Integer getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Integer employeeId) {
    this.employeeId = employeeId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
