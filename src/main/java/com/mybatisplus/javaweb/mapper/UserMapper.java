package com.mybatisplus.javaweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatisplus.javaweb.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * UserMapper 是一个 MyBatis 映射接口，用于操作用户数据
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据账号查找用户
     *
     * @param account 用户账号
     * @return 查找到的用户对象
     */
    @Select("SELECT * FROM user WHERE account=#{account}")
    User findByAccount(Integer account);

    /**
     * 根据账号更新用户信息
     *
     * @param user 要更新的用户对象
     * @return 更新的行数
     */
    @Update("UPDATE user SET password=#{password} WHERE account=#{account}")
    Integer updateByAccount(User user);

    /**
     * 根据账号删除用户
     *
     * @param account 用户账号
     * @return 删除的行数
     */
    @Delete("DELETE FROM user WHERE account=#{account}")
    int deleteByAccount(Integer account);
}
