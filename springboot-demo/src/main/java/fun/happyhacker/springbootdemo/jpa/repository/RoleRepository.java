package fun.happyhacker.springbootdemo.jpa.repository;

import fun.happyhacker.springbootdemo.jpa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
