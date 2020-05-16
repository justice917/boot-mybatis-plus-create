package com.boot.create.mysql.template.entity;

import com.boot.create.mysql.template.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户测试
 * </p>
 *
 * @author taojin
 * @since 2020-05-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UserTest extends BaseEntity {

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

    private Integer actAge;


}
