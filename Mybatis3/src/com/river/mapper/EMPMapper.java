package com.river.mapper;

import com.river.entity.Employee;

import java.util.List;

public interface EMPMapper {
    // 按照条件查询
    List<Employee> selectMore(String job, int deptno);

    List<Employee> selectMore2(String job, int deptno);

    List<Employee> selectMore3(String job, int deptno);

    // 修改操作 (job为null，则不改)
    int update(Employee employee);

    int update2(Employee employee);


}
