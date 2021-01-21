package fun.happyhacker.springbootdemo;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) {

        jdbcTest();
    }

    private static void jdbcTest() {
        Connection connection = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/happyhacker", "root", "12345678");
            stmt = connection.createStatement();
            String selectSql = "select * from employee";
            ResultSet rs = stmt.executeQuery(selectSql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.printf("id: %d,\t name: %s,\t age: %d\n", id, name, age);
            }

            String insertSql = "insert into employee (`name`, `age`) values ('John', 13)";
            long effectedRows1 = stmt.executeUpdate(insertSql, new String[]{"id"});
            if (effectedRows1 > 0) {
                System.out.println("insert ok");
            } else {
                System.out.println("insert failed");
            }

            String updateSql = "update employee set `name` = 'Tam' where id = 3";
            long effectedRows2 = stmt.executeUpdate(updateSql);
            if (effectedRows2 > 0) {
                System.out.println("update ok");
            } else {
                System.out.println("update failed");
            }

            String deleteSql = "delete from employee where id = 5";
            long effectedRows3 = stmt.executeUpdate(deleteSql);
            if (effectedRows3 > 0) {
                System.out.println("delete ok");
            } else {
                System.out.println("delete failed");
            }

            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }
}
