package fun.happyhacker.springbootdemo.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.happyhacker.springbootdemo.mybatis.entity.User;
import fun.happyhacker.springbootdemo.mybatis.mapper.UserMapper;
import fun.happyhacker.springbootdemo.mybatis.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    @DS("account_slave")
    public List<User> listAllUsers() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("id", 0);
        return baseMapper.selectList(wrapper);
    }

    @Override
    @DS("account_master")
    public int createUser(User user) {
        if (Objects.isNull(user)) {
            return 0;
        }

        return baseMapper.insert(user);
    }
}
