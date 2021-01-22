package fun.happyhacker.springbootdemo.jpa.idclass.repository;

import fun.happyhacker.springbootdemo.jpa.idclass.entity.RoleAccount;
import fun.happyhacker.springbootdemo.jpa.idclass.entity.RoleAccountId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleAccountRepository extends JpaRepository<RoleAccount, RoleAccountId> {
}
