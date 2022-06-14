package com.donghu.controller;

import com.donghu.config.Result;
import com.donghu.pojo.Admin;
import com.donghu.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @ClassName AdminController
 * @Description: TODO
 * @Author donghu1z
 * @Date 2021/12/3
 * @Version V1.0
 **/
@RestController
@RequestMapping("/user")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;

    /**
     * 根据条件查询用户（用户名/姓名/全部）
     *
     * @param search
     * @return
     */
    @GetMapping("/search")
    public Result<?> SearchUserInfo(@RequestParam String search) {
        List<Admin> admins;
        admins = adminService.SearchUserInfo(search);
        return Result.success(admins);
    }

    /**
     * 添加用户
     *
     * @param admin
     * @return
     */
    @PostMapping("/save")
    public Result<?> saveUser(@RequestBody Admin admin) {
        System.out.println(admin.toString());
        // 将用户添加到用户表
        Integer integer = adminService.saveAdmin(admin);
        // 查询用户id
        int adminId = adminService.SearchUserId(admin.getName());
        System.out.println("用户id=>>" + adminId);
        //给用户添加权限
        Integer ar = adminService.AddAdminRole(adminId);
        if (ar != 1) {
            return Result.error("-1", "添加失败");
        } else {
            return Result.success();
        }
    }

    /**
     * 根虎id删除用户
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result<?> deleteById(@PathVariable int id) {
        System.out.println("删除id=>>" + id);
        // 删除用户
        adminService.deleteById(id);
        //删除用户对应的权限
        adminService.deleteAdminRole(id);
        return Result.success();
    }

    /**
     * 更新用户信息
     *
     * @param admin
     * @return
     */
    @PutMapping("/update")
    public Result<?> updateById(@RequestBody Admin admin) {
        adminService.updateUser(admin);
        return Result.success();
    }

}
