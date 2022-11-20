package com.river.service.imp;

import com.river.entity.Employee;
import com.river.mapper.EmployeeMapper;
import com.river.service.EmployeeService;
import com.river.util.DBUtil;

import java.util.List;

public class EmployeeServiceImp implements EmployeeService {
    @Override
    public Employee login(String ename, String pwd) {

        EmployeeMapper mapper = DBUtil.getSqlSession().getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectOne(ename, pwd);

        DBUtil.closeAll();

        return employee;
    }

    @Override
    public int save(Employee employee) {
        EmployeeMapper mapper = DBUtil.getSqlSession().getMapper(EmployeeMapper.class);
        int insert = mapper.insert(employee);

        DBUtil.closeAll();

        return insert;
    }

    @Override
    public List<Employee> findAll() {
        EmployeeMapper mapper = DBUtil.getSqlSession().getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.selectAll();

        DBUtil.closeAll();

        return list;
    }

    @Override
    public Employee findOne(int eid) {
        EmployeeMapper mapper = DBUtil.getSqlSession().getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectOne2(eid);

        DBUtil.closeAll();

        return employee;
    }

    @Override
    public int change(Employee employee) {
        EmployeeMapper mapper = DBUtil.getSqlSession().getMapper(EmployeeMapper.class);
        int update = mapper.update(employee);

        DBUtil.closeAll();

        return update;
    }

    @Override
    public int remove(int eid) {
        EmployeeMapper mapper = DBUtil.getSqlSession().getMapper(EmployeeMapper.class);
        int delete = mapper.delete(eid);

        DBUtil.closeAll();

        return delete;
    }
}
