package com.river.service;

import com.river.entity.User;

public interface UserService {
    // 定义想要实现的业务方法
    void pay();

    User login(String uname, String pwd);
}
