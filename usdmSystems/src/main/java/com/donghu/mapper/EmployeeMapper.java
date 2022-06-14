package com.donghu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.donghu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper extends BaseMapper<Employee> {
//    /**
//     * 查询所有员工信息以及对应楼
//     */
//    public List<Employee> FindAllEmployee();


    Integer findEidByName(@Param("ename") String name);

    List<Employee> FindEmployeeWithParams(@Param("param") String param);

    Integer AddEmployee(@Param("ename") String ename,
                        @Param("eposition") String eposition,
                        @Param("etelephone") String etelephone, @Param("bid") Integer bid);
}
