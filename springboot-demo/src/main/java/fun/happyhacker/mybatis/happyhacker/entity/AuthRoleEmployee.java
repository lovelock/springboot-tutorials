package fun.happyhacker.mybatis.happyhacker.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
    public class AuthRoleEmployee implements Serializable {

    private static final long serialVersionUID = 1L;

      private Long employeeId;

    private Long roleId;


}
