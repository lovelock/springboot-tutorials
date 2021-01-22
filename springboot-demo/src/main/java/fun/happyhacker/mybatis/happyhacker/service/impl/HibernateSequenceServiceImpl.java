package fun.happyhacker.mybatis.happyhacker.service.impl;

import fun.happyhacker.mybatis.happyhacker.entity.HibernateSequence;
import fun.happyhacker.mybatis.happyhacker.mapper.HibernateSequenceMapper;
import fun.happyhacker.mybatis.happyhacker.service.IHibernateSequenceService;
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
public class HibernateSequenceServiceImpl extends ServiceImpl<HibernateSequenceMapper, HibernateSequence> implements IHibernateSequenceService {

}
