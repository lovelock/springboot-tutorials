package fun.happyhacker.springbootdemo.mybatis.order.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author happyhacker
 * @since 2021-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

    private LocalDateTime ctime;
}
