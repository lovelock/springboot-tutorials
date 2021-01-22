package fun.happyhacker.springbootdemo.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "AUTH_ROLE_EMPLOYEE")
@Data
public class RoleEmployee {
    @EmbeddedId
    private RoleEmployeeId roleEmployeeId;
}
