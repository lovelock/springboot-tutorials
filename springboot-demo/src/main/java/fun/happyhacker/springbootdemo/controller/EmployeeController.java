package fun.happyhacker.springbootdemo.controller;

import fun.happyhacker.springbootdemo.hikari.ExtensionMethods;
import fun.happyhacker.springbootdemo.jpa.entity.Employee;
import fun.happyhacker.springbootdemo.jpa.entity.Role;
import fun.happyhacker.springbootdemo.jpa.entity.RoleEmployee;
import fun.happyhacker.springbootdemo.jpa.entity.RoleEmployeeId;
import fun.happyhacker.springbootdemo.jpa.repository.EmployeeRepository;
import fun.happyhacker.springbootdemo.jpa.repository.RoleEmployeeRepository;
import fun.happyhacker.springbootdemo.jpa.repository.RoleRepository;
import lombok.experimental.ExtensionMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ExtensionMethod({ExtensionMethods.class})
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleEmployeeRepository roleEmployeeRepository;

    @GetMapping("/list")
    public String list() {
        Employee john = new Employee();
        john.setAge(20);
        john.setId(1L);
        john.setName("John");

        Employee lam = new Employee();
        lam.setName("lam");
        lam.setAge(30);
        lam.setId(2L);

        Employee tam = new Employee();
        tam.setName("tam");
        tam.setAge(50);
        tam.setId(30L);

        employeeRepository.save(john);
        employeeRepository.save(lam);
        employeeRepository.save(tam);

        Role admin = new Role();
        admin.setName("admin");
        admin.setNote("rules all over the system");

        Role common = new Role();
        common.setNote("no privileges");
        common.setName("common");
        roleRepository.save(admin);
        roleRepository.save(common);

        RoleEmployeeId roleEmployeeId = new RoleEmployeeId();
        roleEmployeeId.setEmployeeId(1L);
        roleEmployeeId.setRoleId(1L);
        RoleEmployee adminLine = new RoleEmployee();
        adminLine.setRoleEmployeeId(roleEmployeeId);
        roleEmployeeRepository.save(adminLine);

        List<Employee> list = employeeRepository.findTwoName("lam", "tam");
//        List<Employee> list = employeeRepository.findAll();

        return list.toString();
    }
}
