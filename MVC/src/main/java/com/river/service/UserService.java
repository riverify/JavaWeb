package com.river.service;

import com.river.entity.User;

public interface UserService {
    // 定义想要实现的业务方法
    void pay();

    /**
     * 登陆
     */
    User login(String uname, String pwd);

    /**
     * 注册
     */
    Integer register(User user);

}
