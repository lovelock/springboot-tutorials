package fun.happyhacker.springbootdemo.mybatis.order.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import fun.happyhacker.springbootdemo.mybatis.order.entity.Order;
import fun.happyhacker.springbootdemo.mybatis.order.mapper.OrderMapper;
import fun.happyhacker.springbootdemo.mybatis.order.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author happyhacker
 * @since 2021-01-26
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @Override
    @DS("sharding")
    public List<Order> listAll() {
        return baseMapper.selectList(null);
    }

    @Override
    @DS("sharding")
    public int createOrder(Order order) {
        if (order == null) {
            return 0;
        }

        return baseMapper.insert(order);
    }
}
