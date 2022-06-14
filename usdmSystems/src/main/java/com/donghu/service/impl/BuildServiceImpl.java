package com.donghu.service.impl;

import com.donghu.mapper.BuildMapper;
import com.donghu.pojo.Building;
import com.donghu.service.IBuildService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BuildServiceImpl
 * @Description: TODO
 * @Author donghu1z
 * @Date 2021/12/3
 * @Version V1.0
 **/
@Service
public class BuildServiceImpl implements IBuildService {
    @Autowired
    private BuildMapper buildMapper;

    /**
     * 查询宿舍楼以及对应的宿管
     */
    public List<Building> FindAllBuild() {
        return buildMapper.FindAllBuild();
    }

    /**
     * 根据楼名查询宿舍楼
     *
     * @param bname
     * @return
     */
    @Override
    public List<Building> FindBuildByName(String bname) {
        return buildMapper.FindBuildByName(bname);
    }

    /**
     * 添加楼宇
     *
     * @param build
     * @return
     */
    @Override
    public Integer addBuild(Building build) {
        return buildMapper.insert(build);
    }


    /**
     * 添加楼和管理员对应
     *
     * @param id
     * @return
     */
    @Override
    public Integer addBuildAdmin(Integer id, Integer adminid) {
        return buildMapper.addBuildAdmin(id,adminid);
    }

    @Override
    public Integer DeleteBuild(Integer id) {
        return buildMapper.deleteById(id);
    }

    @Override
    public Integer DeleteBuildEmp(Integer id) {
        return buildMapper.DeleteBuildEmp( id);
    }

    @Override
    public Integer updateBuild(Building building) {

        return buildMapper.updateById(building);
    }

    @Override
    public Integer updateBuildEmp(Integer id, Integer eid) {
        return buildMapper.updateBuildEmp(id,eid);
    }


}
