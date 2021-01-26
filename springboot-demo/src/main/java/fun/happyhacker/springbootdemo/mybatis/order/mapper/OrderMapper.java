package fun.happyhacker.springbootdemo.mybatis.order.mapper;

import fun.happyhacker.springbootdemo.mybatis.order.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author happyhacker
 * @since 2021-01-26
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
