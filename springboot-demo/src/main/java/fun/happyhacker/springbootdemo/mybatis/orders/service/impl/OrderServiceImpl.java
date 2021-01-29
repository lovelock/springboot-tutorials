package fun.happyhacker.springbootdemo.mybatis.orders.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.happyhacker.springbootdemo.mybatis.orders.entity.Order;
import fun.happyhacker.springbootdemo.mybatis.orders.mapper.OrderMapper;
import fun.happyhacker.springbootdemo.mybatis.orders.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Override
    public Order selectByUserId(Integer userId) {
        return baseMapper.selectByUserId(userId);
    }

    @Transactional
    @Override
    public Order selectAndUpdate(Integer userId) {
        Order aOrder = new Order();
        aOrder.setUserId(20);
        baseMapper.insert(aOrder);

        return baseMapper.selectByUserId(20);
    }
}
