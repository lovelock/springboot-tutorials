package fun.happyhacker.springbootdemo.mybatis.mapper;

import fun.happyhacker.springbootdemo.mybatis.entity.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@MapperScan("fun.happyhacker.springbootdemo.mybatis.mapper")
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testSelect() {
        System.out.println("----------------------selectAll method test ------------------------");
        List<User> userList = userMapper.selectList(null);
        assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

}