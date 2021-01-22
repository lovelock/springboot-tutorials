package fun.happyhacker.mybatis.happyhacker.service.impl;

import fun.happyhacker.mybatis.happyhacker.entity.Role;
import fun.happyhacker.mybatis.happyhacker.mapper.RoleMapper;
import fun.happyhacker.mybatis.happyhacker.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
