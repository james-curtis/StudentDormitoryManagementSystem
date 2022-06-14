package com.donghu.service.impl;

import com.donghu.mapper.AccessregistrationMapper;
import com.donghu.pojo.Accessregistration;
import com.donghu.service.IInoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName InoutServiceImpl
 * @Description: TODO
 * @Author donghu1z
 * @Date 2021/12/3
 * @Version V1.0
 **/
@Service
public class InoutServiceImpl implements IInoutService {
    @Autowired
    private AccessregistrationMapper inoutMapper;
    /**
     * 查询出入记录
     * @param param
     * @return
     */
    @Override
    public List<Accessregistration> FindInoutByParam(String param) {
//        inoutMapper.FindInoutByParam(param);
        return   inoutMapper.FindInoutByParam(param);
    }

    @Override
    public Integer AddInout(Accessregistration accessregistration) {
        return inoutMapper.insert(accessregistration);
    }
}
