package fun.happyhacker.springbootdemo.mybatis.orders.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_orders")
public class Order {
    private Integer id;
    private Integer userId;
}
