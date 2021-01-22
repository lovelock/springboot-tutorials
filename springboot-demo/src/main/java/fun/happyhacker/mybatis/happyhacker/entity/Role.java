package fun.happyhacker.mybatis.happyhacker.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author happyhacker
 * @since 2021-01-22
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;


}
