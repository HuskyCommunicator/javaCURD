package com.mybatisplus.javaweb.controller;

import com.mybatisplus.javaweb.model.User;
import com.mybatisplus.javaweb.service.UserService;
import com.mybatisplus.javaweb.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UserController 是一个处理用户相关请求的控制器类
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /**
     * 使用构造函数注入 UserService 依赖
     *
     * @param userService 用户服务对象
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 获取用户列表
     *
     * @return 包含用户列表的 ApiResponse 对象
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<List<User>> list() {
        // 调用 UserService 获取用户列表
        List<User> users = userService.getUserList();
        // 返回包含用户列表的 ApiResponse 对象
        return new ApiResponse<>("获取用户列表成功", users);
    }

    /**
     * 添加新用户
     *
     * @param user 要添加的用户对象
     * @return 包含操作结果的 ApiResponse 对象
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<User> add(@RequestBody User user) {
        // 将请求体的整个 user 对象交给 service 层处理，获取结果
        int result = userService.addUser(user);
        // 根据结果返回相应的 ApiResponse 对象
        if (result == 0) {
            return new ApiResponse<>("添加用户失败,用户已存在", null);
        }
        return new ApiResponse<>("添加用户成功", user);
    }

    /**
     * 根据账号搜索用户
     *
     * @param account 用户账号
     * @return 包含用户信息的 ApiResponse 对象
     */
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<User> search(@RequestParam("account") Integer account) {
        // 调用 UserService 根据账号搜索用户
        User users = userService.searchUser(account);
        // 返回包含用户信息的 ApiResponse 对象
        return new ApiResponse<>("搜索成功", users);
    }

    /**
     * 修改用户信息
     *
     * @param user 要修改的用户对象
     * @return 包含操作结果的 ApiResponse 对象
     */
    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<User> update(@RequestBody User user) {
        // 调用 UserService 更新用户信息
        int users = userService.updateUser(user);
        // 根据结果返回相应的 ApiResponse 对象
        if (users == 0) {
            return new ApiResponse<>("更新用户失败,用户不存在", null);
        }
        return new ApiResponse<>("更新成功", user);
    }

    /**
     * 删除用户
     *
     * @param account 用户账号
     * @return 包含操作结果的 ApiResponse 对象
     */
    @DeleteMapping()
    public ApiResponse<Integer> delete(@RequestParam("account") Integer account) {
        // 调用 UserService 删除用户
        int users = userService.deleteUser(account);
        // 根据结果返回相应的 ApiResponse 对象
        if (users == 0) {
            return new ApiResponse<>("删除用户失败,用户不存在", null);
        }
        return new ApiResponse<>("删除成功", account);
    }
}
