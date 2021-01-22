package fun.happyhacker.springbootdemo.jpa.idclass.repository;

import fun.happyhacker.springbootdemo.jpa.idclass.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
