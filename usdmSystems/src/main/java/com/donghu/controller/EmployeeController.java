package com.donghu.controller;

import com.donghu.config.Result;
import com.donghu.mapper.EmployeeMapper;
import com.donghu.pojo.Employee;
import com.donghu.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName EmployeeController
 * @Description: TODO
 * @Author donghu1z
 * @Date 2021/12/3
 * @Version V1.0
 **/
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;


//    @GetMapping("/searchAll")
//    public Result<?> FindAllEmployee() {
//        List<Employee> employees = employeeService.FindAllEmployee();
//        return Result.success(employees);
//    }


    /**
     * 查询员工信息
     *
     * @param param
     * @return
     */
    @GetMapping("/searchWithParam")
    public Result<?> FindEmployeeWithParams(@RequestParam String param) {
//        List<Employee> employees = employeeService.FindAllEmployee();
        List<Employee> employees = employeeService.FindEmployeeWithParams(param);

        return Result.success(employees);
    }

    /**
     * 删除员工
     *
     * @param id
     * @return
     */
    @DeleteMapping("/deleteEmployee/{id}")
    public Result<?> DeleteEmployee(@PathVariable Integer id) {
        employeeService.DeleteEmployee(id);
        return Result.success();
    }

    /**
     * 增加员工
     * @param employee
     * @return
     */
    @PostMapping("/addEmployee")
    public Result<?> AddEmployee(@RequestBody Employee employee) {
        employeeService.AddEmployee(employee);
        return Result.success();
    }


}
