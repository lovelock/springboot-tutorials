package fun.happyhacker.springbootdemo.mybatis.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "orders")
public class OrderDO {
    private Long id;
    private Integer userId;
}
