package fun.happyhacker.springbootdemo.mybatis.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}