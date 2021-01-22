package fun.happyhacker.springbootdemo.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fun.happyhacker.springbootdemo.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface UserMapper extends BaseMapper<User> {
}
