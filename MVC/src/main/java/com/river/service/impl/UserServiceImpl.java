package com.river.service.impl;

import com.river.entity.User;
import com.river.mapper.UserMapper;
import com.river.service.UserService;
import com.river.util.DBUtil;

public class UserServiceImpl implements UserService {
    @Override
    public void pay() {

    }

    @Override
    public User login(String uname, String pwd) {
        UserMapper mapper = DBUtil.getSqlSession().getMapper(UserMapper.class);
        User user = mapper.selectOne(uname, pwd);
        DBUtil.closeAll();
        return user;
    }

    @Override
    public Integer register(User user) {
        UserMapper mapper = DBUtil.getSqlSession().getMapper(UserMapper.class);
        Integer insert = mapper.insert(user);
        DBUtil.closeAll();
        return insert;
    }
}
