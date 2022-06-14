package com.donghu.controller;

import com.donghu.config.Result;
import com.donghu.mapper.BuildMapper;
import com.donghu.pojo.Dormitory;
import com.donghu.service.impl.BuildServiceImpl;
import com.donghu.service.impl.DormitoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName DormitoryController
 * @Description: TODO
 * @Author donghu1z
 * @Date 2021/12/3
 * @Version V1.0
 **/
@RestController
@RequestMapping("/Dormitory")
public class DormitoryController {
    @Autowired
    private DormitoryServiceImpl dormitoryService;

    @Autowired
    private BuildMapper buildMapper;

    /**
     * 查询所有的宿舍
     *
     * @return
     */
    @GetMapping("/searchAll")
    public Result<?> FindAllBuild() {
        List<Dormitory> dormitoryList = dormitoryService.FindAllBuild();
        return Result.success(dormitoryList);
    }

    /**
     * 根据宿舍名查询宿舍
     *
     * @param dname
     * @return
     */
    @GetMapping("/searchByName")
    public Result<?> FindDormitoryByName(@RequestParam String dname) {
        // dormitoryService.FindDormitoryByName(dname);
        return Result.success(dormitoryService.FindDormitoryByName(dname));
    }

    /**
     * 添加宿舍
     *
     * @param dormitory
     * @return
     */
    @PostMapping("/addDormitory")
    public Result<?> addDormitory(@RequestBody Dormitory dormitory) {

        // 查询对应的楼id
        Integer bid = buildMapper.FindBuildIdByName(dormitory.getDBname());
        // 添加宿舍
        dormitoryService.addDormitory(dormitory.getId(), dormitory.getDnum(), bid.toString());
        return Result.success();
    }

    /**
     * 修改宿舍楼
     *
     * @param dormitory
     * @return
     */
    @PutMapping("/updateDormitory")
    public Result<?> updateDormitory(@RequestBody Dormitory dormitory) {
        // 查询对应的楼id
        Integer bid = buildMapper.FindBuildIdByName(dormitory.getDBname());
        if (bid == null) {
            return Result.error("-1", "没有这栋楼");
        }
        // 修改
        dormitoryService.updateDormitory(dormitory.getId(), dormitory.getDnum(), bid);
        return Result.success();
    }

    @DeleteMapping("/deleteDormitory/{id}")
    public Result<?> deleteDormitory(@PathVariable Integer id) {
        dormitoryService.deleteDormitory(id);
        return Result.success();
    }
}
