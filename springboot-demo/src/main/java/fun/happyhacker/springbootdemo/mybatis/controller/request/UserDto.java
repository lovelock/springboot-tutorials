package fun.happyhacker.springbootdemo.mybatis.controller.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserDto {
    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private Integer id;
    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private String name;
    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private Integer age;
    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private String email;
}
