package fun.happyhacker.springbootdemo.jpa.idclass.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleAccountId implements Serializable {
    private Integer roleId;
    private Integer accountId;
}
