package fun.happyhacker.springbootdemo.jpa.idclass.repository;

import fun.happyhacker.springbootdemo.jpa.idclass.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
