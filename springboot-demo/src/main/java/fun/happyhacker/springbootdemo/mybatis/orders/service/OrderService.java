package fun.happyhacker.springbootdemo.mybatis.orders.service;

import com.baomidou.mybatisplus.extension.service.IService;
import fun.happyhacker.springbootdemo.mybatis.orders.entity.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderService extends IService<Order> {
    Order selectByUserId(@Param("userId") Integer userId);

    Order selectAndUpdate(@Param("userId") Integer userId);
}
