package fun.happyhacker.springbootdemo.mybatis.mapper;

import fun.happyhacker.springbootdemo.mybatis.dataobject.OrderDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderDO selectById(@Param("id") Integer id);

    List<OrderDO> selectListByUserId(@Param("userId") Integer userId);

    void insert(OrderDO orderDO);
}
