package com.river.mapper;

import com.river.entity.Employee;

import java.util.List;

public interface EMPMapper2 {

    List<Employee> selectMore(List<Integer> list);

    List<Employee> selectMore2(String ename);
}
