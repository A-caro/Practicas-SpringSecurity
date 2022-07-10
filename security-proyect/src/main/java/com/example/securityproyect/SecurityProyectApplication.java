package com.example.securityproyect;

import com.example.securityproyect.model.Employee;
import com.example.securityproyect.model.Role;
import com.example.securityproyect.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecurityProyectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityProyectApplication.class, args);
    }

/*    @Bean
    CommandLineRunner run(EmployeeService employeeService){
        return args -> {
            employeeService.addEmployee(new Employee(null,"Ada",0, "123456",null));
            employeeService.addEmployee(new Employee(null,"Richard",0, "123456",null));
            employeeService.addEmployee(new Employee(null,"Steve",0, "123456",null));

            employeeService.saveRole(new Role(null, "ROLE_USER"));
            employeeService.saveRole(new Role(null, "ROLE_ADMINISTRATOR"));
            employeeService.saveRole(new Role(null, "ROLE_MANAGER"));

            employeeService.addRoleToEmployee("Richard", "ROLE_USER");
            employeeService.addRoleToEmployee("Richard", "ROLE_MANAGER");
            employeeService.addRoleToEmployee("Ada", "ROLE_ADMINISTRATOR");
        };
    }*/
}
