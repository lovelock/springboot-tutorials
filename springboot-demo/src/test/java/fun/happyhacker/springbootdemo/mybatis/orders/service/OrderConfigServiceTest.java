package fun.happyhacker.springbootdemo.mybatis.orders.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderConfigServiceTest {

    @Autowired
    private OrderConfigService orderConfigService;

    @Test
    void testSelectById() {
        int count = orderConfigService.count();
        assertEquals(0, count);

        orderConfigService.getById(1);
    }

}