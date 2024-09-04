package com.mybatisplus.javaweb.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User 类表示用户实体，对应数据库中的 user 表
 */
@TableName("user")
@Data // Lombok注解，自动生成Getter、Setter、ToString方法
@AllArgsConstructor // 自动生成包含所有字段的构造函数
@NoArgsConstructor // 自动生成无参构造函数
public class User {

    /**
     * 用户账号
     */
    private Integer account;

    /**
     * 用户密码
     */
    private Integer password;
}
