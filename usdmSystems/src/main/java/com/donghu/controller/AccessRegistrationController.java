package com.donghu.controller;

import com.donghu.config.Result;
import com.donghu.pojo.Accessregistration;
import com.donghu.service.impl.InoutServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName InoutController
 * @Description: TODO
 * @Author donghu1z
 * @Date 2021/12/3
 * @Version V1.0
 **/
@RestController
@RequestMapping("/inout")
public class AccessRegistrationController {

    @Autowired
    private InoutServiceImpl inoutService;

    @GetMapping("/search")
    public Result<?> FindInoutByParam(@RequestParam String param) {
        List<Accessregistration> inouts = inoutService.FindInoutByParam(param);
        return Result.success(inouts);
    }

    @PostMapping("/add")
    public Result<?> addInout(@RequestBody Accessregistration accessregistration) {
        inoutService.AddInout(accessregistration);
        return Result.success();
    }
}
