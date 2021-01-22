package fun.happyhacker.springbootdemo.jpa.repository;

import fun.happyhacker.springbootdemo.jpa.entity.Employee;
import fun.happyhacker.springbootdemo.jpa.entity.RoleEmployeeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByName(String name);

    List<Employee> findAllByIdGreaterThan(Long id);

    @Query("SELECT o FROM Employee o WHERE o.name = :name1 or o.name = :name2 ") // PQL from 后面是实体类名，而不是表名
//    @Query(nativeQuery = true, value = "SELECT * from employee where name = :name1 or name = :name2") // SQL from后面是表名，而不是实体类名
    List<Employee> findTwoName(@Param("name1") String name1, @Param("name2") String name2);
}
