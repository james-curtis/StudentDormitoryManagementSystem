package com.donghu.service;

import com.donghu.pojo.Employee;

import java.util.List;

public interface IEmployeeService {


    Integer findEidByName(String name);


    /**
     * 带参数查询员工信息
     *
     * @param param
     * @return
     */
    List<Employee> FindEmployeeWithParams(String param);

    /**
     * 删除员工
     *
     * @param id
     * @return
     */
    Integer DeleteEmployee(Integer id);

    /**
     * 增加员工
     *
     * @param employee
     * @return
     */
    Integer AddEmployee(Employee employee);
}
