package com.river.service;

import com.river.entity.Employee;

import java.util.List;

public interface EmployeeService {
    // 用户登陆
    Employee login(String ename, String pwd);

    // 用户添加
    int save(Employee employee);

    // 查询所有用户
    List<Employee> findAll();
}
