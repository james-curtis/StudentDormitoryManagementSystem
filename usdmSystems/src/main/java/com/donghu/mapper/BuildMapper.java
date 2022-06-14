package com.donghu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.donghu.pojo.Building;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BuildMapper extends BaseMapper<Building> {

    public List<Building> FindAllBuild();

    /**
     * 根据名字查询对应楼
     * @param bname
     * @return
     */
    public List<Building>  FindBuildByName(@Param("bname") String bname);

    /**
     * 根据id添加对应的楼与管理员
     * @param id
     * @param adminid
     * @return
     */
    Integer addBuildAdmin(@Param("bid")Integer id, @Param("adminid") Integer adminid);

    /**
     * 根据id删除对应的楼与管理员
     * @param id
     * @return
     */
    Integer DeleteBuildEmp(@Param("id") Integer id);

    /**
     * 添加楼与宿管对应表表
     * @param bid
     * @param eid
     * @return
     */
    Integer updateBuildEmp(@Param("bid")Integer bid, @Param("eid") Integer eid);

    /**
     * 根据楼名查询楼id
     * @param bname
     * @return
     */
    Integer FindBuildIdByName(@Param("bname") String bname);
}
