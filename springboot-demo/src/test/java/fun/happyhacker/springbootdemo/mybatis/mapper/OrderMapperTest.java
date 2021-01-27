package fun.happyhacker.springbootdemo.mybatis.mapper;

import fun.happyhacker.springbootdemo.mybatis.dataobject.OrderDO;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    void testSelectById() {
        for (int i = 0; i < 2; i++) {
            OrderDO orderDO = orderMapper.selectById(1);
            System.out.println(orderDO);
        }
    }


    @Test
    void testSelectById2() {
        try (HintManager hintManager = HintManager.getInstance()) {
            hintManager.setMasterRouteOnly();
            OrderDO order = orderMapper.selectById(1);
            System.out.println(order);
        }
    }

    @Test
    void testInsert() {
        OrderDO orderDO = new OrderDO();
        orderDO.setUserId(10);
        orderMapper.insert(orderDO);
    }
}