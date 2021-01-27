package fun.happyhacker.springbootdemo.mybatis.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.happyhacker.springbootdemo.mybatis.dataobject.OrderDO;
import fun.happyhacker.springbootdemo.mybatis.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService extends ServiceImpl<OrderMapper, OrderDO> {
    @Transactional
    public void add(OrderDO orderDO) {
        OrderDO exists = baseMapper.selectById(1);
        System.out.println(exists);

        baseMapper.insert(orderDO);

        exists = baseMapper.selectById(1);
        System.out.println(exists);
    }

    public OrderDO findById(Integer id) {
        return baseMapper.selectById(id);
    }
}
