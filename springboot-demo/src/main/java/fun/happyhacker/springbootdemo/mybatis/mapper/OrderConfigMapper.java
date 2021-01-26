package fun.happyhacker.springbootdemo.mybatis.mapper;

import fun.happyhacker.springbootdemo.mybatis.dataobject.OrderConfigDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderConfigMapper  {
    OrderConfigDO selectById(@Param("id") Integer id);
}
