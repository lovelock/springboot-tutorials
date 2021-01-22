package fun.happyhacker.springbootdemo.jpa.embeddable.repository;

import fun.happyhacker.springbootdemo.jpa.embeddable.entity.RoleAccount;
import fun.happyhacker.springbootdemo.jpa.embeddable.entity.RoleAccountId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleAccountRepository extends JpaRepository<RoleAccount, RoleAccountId> {
}
