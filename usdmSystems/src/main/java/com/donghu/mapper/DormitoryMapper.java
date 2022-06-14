package com.donghu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.donghu.pojo.Dormitory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DormitoryMapper extends BaseMapper<Dormitory> {
    /**
     * -- 查询所有宿舍以及对应楼
     */
    public List<Dormitory> FindAllDormitory();

    /**
     * 添加宿舍
     *
     * @param id
     * @param dnum
     * @param bid
     * @return
     */
    Integer addDormitory(@Param("id") Integer id, @Param("dum") String dnum, @Param("bid") String bid);


    /**
     * 修改宿舍
     * @param id
     * @param dnum
     * @param bid
     * @return
     */
    Integer updateDormitory(@Param("id")Integer id, @Param("dnum") String dnum, @Param("bid") Integer bid);

    List<Dormitory> FindDormitoryByName(@Param(("dnum")) String dname);
}
