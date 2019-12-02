package com.java.bootcamp.projects.spring.springjunit.repository;

import com.java.bootcamp.projects.spring.springjunit.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Employee findByName(String name);

}