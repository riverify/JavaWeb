package com.river.mapper;

import com.river.entity.Employee;

import java.util.List;

public interface EmployeeMapper {

    // 查询指定员工
    Employee selectOne(String ename, String pwd);


    // 添加员工
    int insert(Employee employee);

    // 查询所有员工
    List<Employee> selectAll(String ename, String phone);

    // 查询单个员工
    Employee selectOne2(int eid);

    // 修改操作
    int update(Employee employee);

    // 删除操作
    int delete(int eid);
}
