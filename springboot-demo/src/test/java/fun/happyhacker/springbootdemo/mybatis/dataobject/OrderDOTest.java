package fun.happyhacker.springbootdemo.mybatis.dataobject;

import fun.happyhacker.springbootdemo.mybatis.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderDOTest {
    @Autowired
    private OrderMapper orderMapper;

    @Test
    void testSelectById() {
        OrderDO orderDO = orderMapper.selectById(1);
        System.out.println(orderDO);
    }

}