package fun.happyhacker.springbootdemo.controller;

import fun.happyhacker.springbootdemo.hikari.ExtensionMethods;
import fun.happyhacker.springbootdemo.jpa.entity.Employee;
import fun.happyhacker.springbootdemo.jpa.repository.EmployeeRepository;
import lombok.experimental.ExtensionMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExtensionMethod({ExtensionMethods.class})
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/list")
    public String list() {
        Employee john = new Employee();
        john.setAge(20);
        john.setName("John");

        Employee lam = new Employee();
        lam.setName("lam");
        lam.setAge(30);

        employeeRepository.save(john);
        employeeRepository.save(lam);

        Employee first = employeeRepository.getOne(1L);
        first.setName("happyhacker");
        employeeRepository.save(first);

        employeeRepository.deleteById(2L);

        return employeeRepository.findAll().toString();
    }
}
