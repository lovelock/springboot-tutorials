package fun.happyhacker.springbootdemo.mybatis.entity;

import com.google.gson.Gson;
import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String email;

    public String toJson() {
        return new Gson().toJson(this);
    }
}
