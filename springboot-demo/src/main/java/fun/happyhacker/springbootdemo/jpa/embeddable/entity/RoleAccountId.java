package fun.happyhacker.springbootdemo.jpa.embeddable.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class RoleAccountId implements Serializable {
    private Integer roleId;
    private Integer accountId;
}
