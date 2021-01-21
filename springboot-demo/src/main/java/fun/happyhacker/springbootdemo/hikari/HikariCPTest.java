package fun.happyhacker.springbootdemo.hikari;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HikariCPTest {
    public static void main(String[] args) throws SQLException {
        HikariConfig config = new HikariConfig("/database/happyhacker-master.properties");
        HikariDataSource ds = new HikariDataSource(config);
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
        }

        System.out.println(employees);
    }
}
