package com.example.securityproyect.repository;

import com.example.securityproyect.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
      Employee findByFullName(String fullName);

}
