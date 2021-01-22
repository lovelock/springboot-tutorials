package fun.happyhacker.springbootdemo.jpa.embeddable.repository;

import fun.happyhacker.springbootdemo.jpa.embeddable.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
