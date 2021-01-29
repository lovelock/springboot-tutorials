package fun.happyhacker.springbootdemo.mybatis.orders.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName(value = "t_order_config")
public class OrderConfig {
    private Integer id;
    private LocalDateTime pay_timeout;
}
