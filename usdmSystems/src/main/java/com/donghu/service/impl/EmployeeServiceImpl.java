package com.donghu.service.impl;

import com.donghu.mapper.BuildMapper;
import com.donghu.mapper.EmployeeMapper;
import com.donghu.pojo.Employee;
import com.donghu.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName EmployeeServiceImpl
 * @Description: TODO
 * @Author donghu1z
 * @Date 2021/12/3
 * @Version V1.0
 **/
@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private BuildMapper buildMapper;


    /**
     * 根据名字查询员工id
     *
     * @return
     */
    @Override
    public Integer findEidByName(String name) {
        return employeeMapper.findEidByName(name);
    }

    /**
     * 查询员工信息
     *
     * @param param
     * @return
     */
    @Override
    public List<Employee> FindEmployeeWithParams(String param) {
        return employeeMapper.FindEmployeeWithParams(param);
    }

    /**
     * 删除员工
     *
     * @param id
     * @return
     */
    @Override
    public Integer DeleteEmployee(Integer id) {
        return employeeMapper.deleteById(id);
    }

    /**
     * 添加员工
     *
     * @param employee
     * @return
     */
    @Override
    public Integer AddEmployee(Employee employee) {
        /**
         * 查询楼id
         */
        Integer bid = buildMapper.FindBuildIdByName(employee.getEBname());
        /**
         * 插入员工
         */
        Integer i = employeeMapper.AddEmployee(employee.getEname(), employee.getEposition(), employee.getEtelephone(), bid);
        return i;
    }
}
