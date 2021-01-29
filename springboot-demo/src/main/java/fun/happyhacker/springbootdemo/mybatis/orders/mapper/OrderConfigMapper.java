package fun.happyhacker.springbootdemo.mybatis.orders.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fun.happyhacker.springbootdemo.mybatis.orders.entity.OrderConfig;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderConfigMapper extends BaseMapper<OrderConfig> {
}
