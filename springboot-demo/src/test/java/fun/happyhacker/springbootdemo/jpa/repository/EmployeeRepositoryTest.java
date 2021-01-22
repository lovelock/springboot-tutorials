package fun.happyhacker.springbootdemo.jpa.repository;

import fun.happyhacker.springbootdemo.jpa.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void crud() {
        Employee john = new Employee();
        john.setAge(20);
        john.setName("John");

        Employee lam = new Employee();
        lam.setName("lam");
        lam.setAge(30);

        Employee johnWithId = employeeRepository.save(john);
        assertEquals(john.getName(), johnWithId.getName());
        Employee lamWithId = employeeRepository.save(lam);
        assertEquals(lam.getName(), lamWithId.getName());

        lamWithId.setAge(45);
        Employee oldLam = employeeRepository.save(lamWithId);
        assertEquals(45, oldLam.getAge());

        employeeRepository.delete(oldLam);
        Optional<Employee> employeeOptional = employeeRepository.findById(2L);
        assertFalse(employeeOptional.isPresent());

        List<Employee> list = employeeRepository.findAll();
        List<Employee> expected = new ArrayList<>();
        expected.add(johnWithId);
        assertEquals(expected, list);

    }
}