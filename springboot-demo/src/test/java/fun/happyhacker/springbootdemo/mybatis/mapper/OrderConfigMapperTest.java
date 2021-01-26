package fun.happyhacker.springbootdemo.mybatis.mapper;

import fun.happyhacker.springbootdemo.mybatis.dataobject.OrderConfigDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderConfigMapperTest {

    @Autowired
    private OrderConfigMapper orderConfigMapper;

    @Test
    void testSelectById() {

        OrderConfigDO orderConfigDO = orderConfigMapper.selectById(1);
        System.out.println(orderConfigDO);
    }

}