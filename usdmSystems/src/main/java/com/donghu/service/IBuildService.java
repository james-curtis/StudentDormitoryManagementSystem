package com.donghu.service;

import com.donghu.pojo.Building;

import java.util.List;

public interface IBuildService {
    public List<Building> FindAllBuild();

    /**
     * 根据楼名查询宿舍楼
     */
    public  List<Building>  FindBuildByName(String bname);

    public Integer addBuild(Building build);


    public Integer addBuildAdmin(Integer id,Integer adminid);

    Integer DeleteBuild(Integer id);

    Integer DeleteBuildEmp(Integer id);

    Integer updateBuild(Building building);

    Integer updateBuildEmp(Integer id, Integer eid);
}
