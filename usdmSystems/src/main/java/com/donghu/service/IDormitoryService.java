package com.donghu.service;

import com.donghu.config.Result;
import com.donghu.pojo.Dormitory;

import java.util.List;

public interface IDormitoryService {
    List<Dormitory> FindAllBuild();

    /**
     * 根据id删除宿舍
     *
     * @param id
     * @return
     */
    Integer deleteDormitory(Integer id);

    /**
     * 根据宿舍名查询宿舍
     *
     * @param dname
     * @return
     */
    List<Dormitory> FindDormitoryByName(String dname);

    /**
     * 添加宿舍
     *
     * @param id
     * @param dnum
     * @param bid
     * @return
     */
    Integer addDormitory(Integer id, String dnum, String bid);

    /**
     * 修改
     *
     * @param dnum
     * @param bid
     * @return
     */
    Integer updateDormitory(Integer id, String dnum, Integer bid);
}
