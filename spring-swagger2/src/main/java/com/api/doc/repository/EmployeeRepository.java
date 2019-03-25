package com.api.doc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.doc.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
