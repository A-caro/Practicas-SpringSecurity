package com.example.securityproyect.controller;

import com.example.securityproyect.model.Employee;
import com.example.securityproyect.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @GetMapping
    public List<Employee> getEmployee(){
      return employeeService.getEmployee();
    }

}
