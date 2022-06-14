package com.donghu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.donghu.pojo.Accessregistration;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccessregistrationMapper extends BaseMapper<Accessregistration> {
    List<Accessregistration> FindInoutByParam(@Param("param") String param);
}
