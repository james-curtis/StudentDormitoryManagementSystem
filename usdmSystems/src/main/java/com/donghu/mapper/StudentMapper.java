package com.donghu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.donghu.pojo.StudentInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName StudentMapper
 * @Description: TODO
 * @Author donghu1z
 * @Date 2021/12/14
 * @Version V1.0
 **/
public interface StudentMapper extends BaseMapper<StudentInfo> {
    List<StudentInfo> FindStuByParam(@Param("param") String param);
}
