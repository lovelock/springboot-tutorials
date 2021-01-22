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
    public class User implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 姓名
     */
      private String name;

      /**
     * 年龄
     */
      private Integer age;

      /**
     * 邮箱
     */
      private String email;


}
