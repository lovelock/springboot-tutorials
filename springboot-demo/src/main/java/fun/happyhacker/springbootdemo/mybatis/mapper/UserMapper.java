package fun.happyhacker.springbootdemo.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fun.happyhacker.springbootdemo.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
//    User xmlQueryAgeByName(@Param(value = "userName") String userName);
//
//    List<User> queryAllUsers();
//
//    boolean addUser(User user);

    List<User> queryByNameEquals(String userName);


//    @Select("SELECT age FROM user where name = #{userName, jdbcType=VARCHAR}")
//    Integer annotationQueryAgeByName(@Param(value = "userName") String userName);
//
//    @SelectProvider(type = UserInfoSql.class, method = "queryAgeByName")
//    Integer classQueryAgeByName(@Param(value = "userName") String userName);
}
