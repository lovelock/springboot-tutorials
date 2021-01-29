package fun.happyhacker.springbootdemo.mybatis.orders.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.happyhacker.springbootdemo.mybatis.orders.entity.OrderConfig;
import fun.happyhacker.springbootdemo.mybatis.orders.mapper.OrderConfigMapper;
import fun.happyhacker.springbootdemo.mybatis.orders.service.OrderConfigService;
import org.springframework.stereotype.Service;

@Service
public class OrderConfigServiceImpl extends ServiceImpl<OrderConfigMapper, OrderConfig> implements OrderConfigService {
}
