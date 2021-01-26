package fun.happyhacker.springbootdemo.mybatis.controller;

import fun.happyhacker.springbootdemo.mybatis.controller.request.UserDto;
import fun.happyhacker.springbootdemo.mybatis.entity.User;
import fun.happyhacker.springbootdemo.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    @ResponseBody
    public String allUsers() {

        List<User> userList = userService.listAllUsers();

        return userList.toString();
    }

    @PostMapping("/create")
    @ResponseBody
    public int create(@RequestBody UserDto userDto) {

        User newUser = new User();
        newUser.setAge(userDto.getAge());
        newUser.setName(userDto.getName());
        newUser.setId(userDto.getId());
        newUser.setEmail(userDto.getEmail());

        return userService.createUser(newUser);
    }
}
