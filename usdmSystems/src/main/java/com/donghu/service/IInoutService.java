package com.donghu.service;

import com.donghu.pojo.Accessregistration;

import java.util.List;

public interface IInoutService {
    /**
     * 查询出入记录
     * @param param
     * @return
     */
    List<Accessregistration> FindInoutByParam(String param);

    /**
     * 增加
     * @return
     */
    Integer  AddInout(Accessregistration inout);
}
