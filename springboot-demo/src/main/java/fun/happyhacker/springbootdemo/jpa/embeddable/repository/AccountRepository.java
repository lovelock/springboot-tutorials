package fun.happyhacker.springbootdemo.jpa.embeddable.repository;

import fun.happyhacker.springbootdemo.jpa.embeddable.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
