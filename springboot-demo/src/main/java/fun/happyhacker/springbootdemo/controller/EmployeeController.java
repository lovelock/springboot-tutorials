package fun.happyhacker.springbootdemo.controller;

import fun.happyhacker.springbootdemo.hikari.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private DataSource ds;

    @GetMapping("/list")
    public String list() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement("select * from employee");
             ResultSet rs = ps.executeQuery();
        ) {
            Employee employee = new Employee();
            while (rs.next()) {
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setAge(rs.getInt("age"));
                employees.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employees.toString();
    }
}
