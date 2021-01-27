package fun.happyhacker.springbootdemo.mybatis.service;

import fun.happyhacker.springbootdemo.mybatis.dataobject.OrderDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    void trx() {
        OrderDO orderDO = new OrderDO();
        orderDO.setUserId(200);
        orderService.add(orderDO);
    }

    @Test
    void find() {
        orderService.findById(2);
    }

}