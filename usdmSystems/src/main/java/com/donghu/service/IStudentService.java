package com.donghu.service;

import com.donghu.pojo.StudentInfo;

import java.util.List;

public interface IStudentService {
    /**
     * 查询学生信息
     * @param param
     * @return
     */
    List<StudentInfo> FindStuByParam(String param);
}
