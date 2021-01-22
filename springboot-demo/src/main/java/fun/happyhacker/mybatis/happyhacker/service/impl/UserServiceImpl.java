package fun.happyhacker.mybatis.happyhacker.service.impl;

import fun.happyhacker.mybatis.happyhacker.entity.User;
import fun.happyhacker.mybatis.happyhacker.mapper.UserMapper;
import fun.happyhacker.mybatis.happyhacker.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author happyhacker
 * @since 2021-01-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
