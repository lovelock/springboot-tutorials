package fun.happyhacker.springbootdemo.jpa.embeddable.repository;

import fun.happyhacker.springbootdemo.jpa.embeddable.entity.Account;
import fun.happyhacker.springbootdemo.jpa.embeddable.entity.Role;
import fun.happyhacker.springbootdemo.jpa.embeddable.entity.RoleAccount;
import fun.happyhacker.springbootdemo.jpa.embeddable.entity.RoleAccountId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RoleAccountRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleAccountRepository roleAccountRepository;

    @Test
    void idClassTest() {
        Role admin = new Role();
        admin.setId(1);
        admin.setName("admin");

        Role role1 = new Role();
        role1.setId(2);
        role1.setName("role1");

        Role role2 = new Role();
        role2.setId(3);
        role2.setName("role2");

        roleRepository.save(admin);
        roleRepository.save(role1);
        roleRepository.save(role2);

        Account john = new Account();
        john.setAge(30);
        john.setName("john");
        john.setId(4);

        accountRepository.save(john);

        RoleAccount roleAccount = new RoleAccount();
        RoleAccountId roleAccountId = new RoleAccountId();
        roleAccountId.setRoleId(admin.getId());
        roleAccountId.setAccountId(john.getId());
        roleAccount.setRoleAccountId(roleAccountId);

        roleAccountRepository.save(roleAccount);
    }
}