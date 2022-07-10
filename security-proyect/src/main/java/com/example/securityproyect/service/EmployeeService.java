package com.example.securityproyect.service;

import com.example.securityproyect.model.Employee;
import com.example.securityproyect.model.Role;
import com.example.securityproyect.repository.EmployeeRepository;
import com.example.securityproyect.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Service
public class EmployeeService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;

   @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, RoleRepository roleRepository) {
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
    }

    public List<Employee> getEmployee(){
       return employeeRepository.findAll();
    }


    public Role saveRole(Role role){
        log.info("saving role to the database");
        return roleRepository.save(role);
    }

    public void addRoleToEmployee(String fullName, String roleName){
        log.info("Adding {} role to user: {}", roleName, fullName);
        Employee employee = employeeRepository.findByFullName(fullName);
        Role role = roleRepository.findByName(roleName);
        employee.getRoles().add(role);
    }

    public Employee addEmployee(Employee employee){
       return employeeRepository.save(employee);
    }

    @Override
    public UserDetails loadUserByUsername(String fullname) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByFullName(fullname);
        if(employee == null){
            log.error("Employee not found");
            throw new UsernameNotFoundException("Employee not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        employee.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(employee.getFullName(), employee.getPassword(), authorities);
    }
}
