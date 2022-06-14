package com.donghu.controller;

import com.donghu.config.Result;
import com.donghu.pojo.StudentInfo;
import com.donghu.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName StudentController
 * @Description: TODO
 * @Author donghu1z
 * @Date 2021/12/14
 * @Version V1.0
 **/
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    /**
     * 带参数查询
     *
     * @param param
     * @return
     */
    @GetMapping("/search")
    public Result<?> FindStuByParam(@RequestParam String param) {
        List<StudentInfo> stus = studentService.FindStuByParam(param);
        return Result.success(stus);
    }

    @PostMapping ("/add")
    public Result<?> FindStuByParam(@RequestBody StudentInfo stu) {
        studentService.AddStudent(stu);
        return Result.success();
    }
}
