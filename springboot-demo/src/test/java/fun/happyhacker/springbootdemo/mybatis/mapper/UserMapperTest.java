package fun.happyhacker.springbootdemo.mybatis.mapper;

import fun.happyhacker.SpringbootDemoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringbootDemoApplication.class)
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void queryAgeByName() {
        String userName = "Jone";

//        System.out.println(userMapper.annotationQueryAgeByName(userName));
//        System.out.println(userMapper.xmlQueryAgeByName(userName));
//        System.out.println(userMapper.classQueryAgeByName(userName));
    }

}