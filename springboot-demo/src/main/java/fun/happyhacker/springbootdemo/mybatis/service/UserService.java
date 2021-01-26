package fun.happyhacker.springbootdemo.mybatis.service;

import fun.happyhacker.springbootdemo.mybatis.entity.User;

import java.util.List;

public interface UserService {
    List<User> listAllUsers();

    int createUser(User user);
}
