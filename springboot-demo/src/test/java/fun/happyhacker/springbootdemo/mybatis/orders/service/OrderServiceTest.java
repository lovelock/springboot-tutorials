package fun.happyhacker.springbootdemo.mybatis.orders.service;

import fun.happyhacker.springbootdemo.mybatis.orders.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    void testSelect() {
//        Order order = orderService.selectByUserId(20);
//        assertEquals(20, order.getUserId());
    }

    @Test
    void testInsert() {
//        Order order = new Order();
//        order.setUserId(20);
//
//        orderService.save(order);
//        Order newOrder = orderService.selectByUserId(20);
//        assertEquals(newOrder.getUserId(), order.getUserId());
    }

    @Test
    void testTnx() {
        Order order = orderService.selectAndUpdate(20);
        assertEquals(10, order.getId());
    }

}