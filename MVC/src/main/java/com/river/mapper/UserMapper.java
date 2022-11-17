package com.river.mapper;

import com.river.entity.User;

public interface UserMapper {
    /**
     * 查询操作
     * select * from user where uname = ? and pwd = ?;
     *
     * @param uname name
     * @param pwd   password
     * @return 查询到的用户
     */
    User selectOne(String uname, String pwd);

    /**
     * 添加操作
     * insert into user values(?, ?, ?)
     *
     * @param user 用户对象
     * @return
     */
    Integer insert(User user);

}
