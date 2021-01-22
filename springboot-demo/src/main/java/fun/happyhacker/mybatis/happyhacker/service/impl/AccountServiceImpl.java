package fun.happyhacker.mybatis.happyhacker.service.impl;

import fun.happyhacker.mybatis.happyhacker.entity.Account;
import fun.happyhacker.mybatis.happyhacker.mapper.AccountMapper;
import fun.happyhacker.mybatis.happyhacker.service.IAccountService;
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
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

}
