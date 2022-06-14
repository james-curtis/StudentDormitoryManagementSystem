package com.donghu.controller;

import com.donghu.config.Result;
import com.donghu.pojo.Building;
import com.donghu.service.impl.BuildServiceImpl;
import com.donghu.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName BuildController
 * @Description: TODO
 * @Author donghu1z
 * @Date 2021/12/3
 * @Version V1.0
 **/
@RestController
@RequestMapping("/building")
public class BuildController {
    @Autowired
    private BuildServiceImpl buildService;

    @Autowired
    private EmployeeServiceImpl employeeService;

    /**
     * 查询全部用户
     *
     * @return
     */
    @GetMapping("/search")
    public Result<?> FindAllBuild() {
        List<Building> buildList = buildService.FindAllBuild();
        return Result.success(buildList);
    }

    /**
     * 根据楼名查询公寓楼
     *
     * @param name
     * @return
     */
    @GetMapping("/findByName")
    public Result<?> FindBuildByName(@RequestParam String name) {
        return Result.success(buildService.FindBuildByName(name));
    }

    /**
     * 增加公寓楼
     *
     * @param building
     * @return
     */
    @PostMapping("/addBuild")
    public Result<?> addBuild(@RequestBody Building building) {
        System.out.println(building.getBEmpName());
        // 查询宿管id
        Integer eid = employeeService.findEidByName(building.getBEmpName());
        if (eid == null) {
            return Result.error("-1", "没有该员工");
        }
        // 添加楼
        buildService.addBuild(building);
        // 添加宿管
        buildService.addBuildAdmin(building.getId(), eid);

        return Result.success();
    }

    /**
     * 删除公寓楼
     *
     * @param id
     * @return
     */
    @DeleteMapping("/deteleBuild/{id}")
    public Result<?> DeleteBuild(@PathVariable Integer id) {
        // 删除楼
        buildService.DeleteBuild(id);
        // 删除楼与宿管表
        buildService.DeleteBuildEmp(id);
        return Result.success();
    }

    @PutMapping("/updateBuild")
    public Result<?> updateBuild(@RequestBody Building building) {
        // 查询宿管id
        Integer eid = employeeService.findEidByName(building.getBEmpName());
        if (eid == null) {
            return Result.error("-1", "没有该员工");
        }
        // 更改楼名
        buildService.updateBuild(building);



        // 更改楼管理员
        buildService.updateBuildEmp(building.getId(), eid);

        return Result.success();
    }


}
