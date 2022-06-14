package com.donghu.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.donghu.mapper.DormitoryMapper;
import com.donghu.pojo.Dormitory;
import com.donghu.service.IDormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DormitoryServiceImpl
 * @Description: TODO
 * @Author donghu1z
 * @Date 2021/12/3
 * @Version V1.0
 **/
@Service
public class DormitoryServiceImpl implements IDormitoryService {
    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Override
    public List<Dormitory> FindAllBuild() {
        return dormitoryMapper.FindAllDormitory();
    }

    /**
     * 根据id删除宿舍
     *
     * @param id
     * @return
     */
    @Override
    public Integer deleteDormitory(Integer id) {
        return dormitoryMapper.deleteById(id);
    }

    /**
     * 根据宿舍名查询宿舍
     *
     * @param dname
     * @return
     */
    @Override
    public List<Dormitory> FindDormitoryByName(String dname) {
        List<Dormitory> dormitories = dormitoryMapper.FindDormitoryByName(dname);
        return dormitories;
    }

    /**
     * 添加宿舍
     *
     * @param id
     * @param dnum
     * @param bid
     * @return
     */
    @Override
    public Integer addDormitory(Integer id, String dnum, String bid) {
        return dormitoryMapper.addDormitory(id, dnum, bid);
    }

    /**
     * 修改
     *
     * @param dnum
     * @param bid
     * @return
     */
    @Override
    public Integer updateDormitory(Integer id, String dnum, Integer bid) {
        return dormitoryMapper.updateDormitory(id, dnum, bid);
    }
}
