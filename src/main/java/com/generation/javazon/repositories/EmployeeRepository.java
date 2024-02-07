package com.generation.javazon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.javazon.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
