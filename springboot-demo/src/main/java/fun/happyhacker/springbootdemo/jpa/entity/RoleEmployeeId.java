package fun.happyhacker.springbootdemo.jpa.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class RoleEmployeeId implements Serializable {
    private Long roleId;
    private Long employeeId;
}
