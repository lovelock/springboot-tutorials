package fun.happyhacker.springbootdemo.jpa.idclass.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@Data
@IdClass(RoleAccountId.class)
public class RoleAccount {
    @Id
    private Integer roleId;
    @Id
    private Integer accountId;
}
