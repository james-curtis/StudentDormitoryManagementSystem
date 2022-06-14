package com.donghu.controller;

import com.donghu.config.Result;
import com.donghu.pojo.Admin;
import com.donghu.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @ClassName LoginController
 * @Description: TODO
 * @Author donghu1z
 * @Date 2021/12/5
 * @Version V1.0
 **/
@RestController
public class LoginController {

    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping("/Login")
    public Result<?> Login(@RequestBody Admin admin) {
        Admin loginUser = adminService.getLoginUser(admin);

        System.out.println(admin.toString());
//        System.out.println(loginUser.toString());
        if (loginUser == null) {
            return Result.error("-1", "用户名或密码错误");
        } else {
            return Result.success(loginUser);
        }
    }

}
