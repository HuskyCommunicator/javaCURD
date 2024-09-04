package com.mybatisplus.javaweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatisplus.javaweb.mapper.UserMapper;
import com.mybatisplus.javaweb.model.User;
import com.mybatisplus.javaweb.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImpl 是 UserService 的实现类，提供用户相关的服务
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;

    /**
     * 构造函数，注入 UserMapper
     *
     * @param userMapper 用户映射器
     */
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 获取用户列表
     *
     * @return 用户列表
     */
    @Override
    public List<User> getUserList() {
        // 调用 MyBatis Plus 提供的 list() 方法获取所有用户
        return this.list();
    }

    /**
     * 添加新用户
     *
     * @param user 要添加的用户对象
     * @return 操作结果，0 表示失败，1 表示成功
     */
    @Override
    public int addUser(User user) {
        // 根据账号查找用户，判断用户是否已存在
        User result = userMapper.findByAccount(user.getAccount());
        if (result != null) {
            return 0; // 用户已存在，返回失败
        }
        // 插入新用户
        return this.baseMapper.insert(user);
    }

    /**
     * 根据账号搜索用户
     *
     * @param account 用户账号
     * @return 查找到的用户对象，如果用户不存在则返回 null
     */
    @Override
    public User searchUser(Integer account) {
        // 根据账号查找用户
        return userMapper.findByAccount(account);
    }

    /**
     * 更新用户信息
     *
     * @param user 要更新的用户对象
     * @return 更新的行数，0 表示失败
     */
    @Override
    public int updateUser(User user) {
        // 根据账号查找用户，判断用户是否存在
        User result = userMapper.findByAccount(user.getAccount());
        if (result == null) {
            return 0; // 用户不存在，返回失败
        }
        // 更新用户信息
        return userMapper.updateByAccount(user);
    }

    /**
     * 删除用户
     *
     * @param account 用户账号
     * @return 删除的行数，0 表示失败
     */
    @Override
    public int deleteUser(Integer account) {
        // 根据账号查找用户，判断用户是否存在
        User result = userMapper.findByAccount(account);
        if (result == null) {
            return 0; // 用户不存在，返回失败
        }
        // 删除用户
        return userMapper.deleteByAccount(account);
    }
}
