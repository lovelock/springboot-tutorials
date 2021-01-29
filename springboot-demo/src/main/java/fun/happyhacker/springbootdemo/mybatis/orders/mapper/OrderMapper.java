package fun.happyhacker.springbootdemo.mybatis.orders.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fun.happyhacker.springbootdemo.mybatis.orders.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    Order selectByUserId(Integer userId);
}
