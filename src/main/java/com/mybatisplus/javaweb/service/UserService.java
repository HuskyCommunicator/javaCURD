package com.mybatisplus.javaweb.service;

import com.mybatisplus.javaweb.model.User;

import java.util.List;

/**
 * UserService 接口定义了用户相关的服务方法
 */
public interface UserService {

    /**
     * 获取所有用户
     *
     * @return 用户列表
     */
    List<User> getUserList();

    /**
     * 增加用户
     *
     * @param user 要添加的用户对象
     * @return 操作结果，0 表示失败，1 表示成功
     */
    int addUser(User user);

    /**
     * 根据账户名查找用户
     *
     * @param account 用户账号
     * @return 查找到的用户对象，如果用户不存在则返回 null
     */
    User searchUser(Integer account);

    /**
     * 更新用户信息
     *
     * @param user 要更新的用户对象
     * @return 更新的行数，0 表示失败
     */
    int updateUser(User user);

    /**
     * 删除用户
     *
     * @param account 用户账号
     * @return 删除的行数，0 表示失败
     */
    int deleteUser(Integer account);
}
