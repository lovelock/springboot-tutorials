package fun.happyhacker.springbootdemo.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 32)
    private String name;

    private Integer age;
}
