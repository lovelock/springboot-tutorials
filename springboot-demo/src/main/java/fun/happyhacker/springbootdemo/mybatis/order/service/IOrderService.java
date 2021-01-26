package fun.happyhacker.springbootdemo.mybatis.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import fun.happyhacker.springbootdemo.mybatis.order.entity.Order;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author happyhacker
 * @since 2021-01-26
 */
public interface IOrderService extends IService<Order> {

    List<Order> listAll();

    int createOrder(Order order);
}
