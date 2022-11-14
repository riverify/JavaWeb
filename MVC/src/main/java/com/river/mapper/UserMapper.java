package com.river.mapper;

import com.river.entity.User;

public interface UserMapper {
    /**
     * 查询操作
     * select * from user where uname = ? and pwd = ?;
     */
    User selectOne(String uname, String pwd);
}
