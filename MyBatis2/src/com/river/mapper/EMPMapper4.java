package com.river.mapper;

import com.river.entity.Employee;

import java.util.List;

public interface EMPMapper4 {

    // 查询所有
    List<Employee> selectAll();

    // 修改
    int insert(Employee employee);

    Employee selectOne(int empno, String ename);

    // 传递多个对象的冲突解决
    Employee selectOne2(Employee e1, Employee e2);
}
