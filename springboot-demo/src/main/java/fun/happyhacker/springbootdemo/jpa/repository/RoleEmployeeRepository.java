package fun.happyhacker.springbootdemo.jpa.repository;

import fun.happyhacker.springbootdemo.jpa.entity.RoleEmployee;
import fun.happyhacker.springbootdemo.jpa.entity.RoleEmployeeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleEmployeeRepository extends JpaRepository<RoleEmployee, RoleEmployeeId> {
}
