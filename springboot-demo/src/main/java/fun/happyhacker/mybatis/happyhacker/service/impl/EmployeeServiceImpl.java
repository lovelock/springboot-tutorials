package fun.happyhacker.mybatis.happyhacker.service.impl;

import fun.happyhacker.mybatis.happyhacker.entity.Employee;
import fun.happyhacker.mybatis.happyhacker.mapper.EmployeeMapper;
import fun.happyhacker.mybatis.happyhacker.service.IEmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
