package com.donghu.service.impl;

import com.donghu.mapper.StudentMapper;
import com.donghu.pojo.Accessregistration;
import com.donghu.pojo.StudentInfo;
import com.donghu.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName IStudentServiceImpl
 * @Description: TODO
 * @Author donghu1z
 * @Date 2021/12/14
 * @Version V1.0
 **/
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;
    /**
     * 查询学生信息
     * @param param
     * @return
     */
    @Override
    public List<StudentInfo> FindStuByParam(String param) {

        return studentMapper.FindStuByParam(param);
    }

    public Integer AddStudent(StudentInfo stu) {
        return studentMapper.insert(stu);
    }
}
