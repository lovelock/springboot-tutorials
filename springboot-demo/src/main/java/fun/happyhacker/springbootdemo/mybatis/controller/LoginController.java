package fun.happyhacker.springbootdemo.mybatis.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import fun.happyhacker.springbootdemo.mybatis.entity.User;
import fun.happyhacker.springbootdemo.mybatis.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/mybatis/login")
public class LoginController {
    @Resource
    private UserMapper userMapper;

    @GetMapping(value = "/test")
    public String query(@RequestParam("id") Integer id) {
        User user = userMapper.selectById(id);

        return user.toString();
    }


    @GetMapping(value = "/querybyname")
    public String query(@RequestParam("name") String name) {
        List<User> userList = userMapper.queryByNameEquals(name);

        return userList.toString();
    }

    @GetMapping(value = "/listall")
    public String queryAllUsers() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("id", 0);
        return userMapper.selectList(queryWrapper).toString();
    }

    @GetMapping(value = "/add")
    public String addUser(@RequestParam("name") String name, @RequestParam("age") Integer age) {

        User user = new User();
        user.setId(303);
        user.setAge(age);
        user.setName(name);

        int a = userMapper.insert(user);
        if (a > 0) {
            return "Created!";
        } else {
            return "Create failed!";
        }
    }
}
