package com.donghu.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.donghu.mapper.AdminMapper;
import com.donghu.pojo.Admin;
import com.donghu.service.IAdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AdminServiceImpl
 * @Description: TODO
 * @Author donghu1z
 * @Date 2021/12/3
 * @Version V1.0
 **/
@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private AdminMapper adminMapper;

    /**
     * 登录
     *
     * @param admin
     * @return
     */
    @Override
    public Admin getLoginUser(Admin admin) {
        return adminMapper.getLoginUser(admin);
//        return adminMapper.selectOne(Wrappers.lambdaQuery(Admin).eq())
    }

    /**
     * 根据条件查询用户
     *
     * @param search
     * @return
     */
    @Override
    public List<Admin> SearchUserInfo(String search) {
        return adminMapper.SearchUserInfo(search);

    }

    /**
     * 查询用户id
     */
    public int SearchUserId(String name) {
        return adminMapper.SearchUserId(name);
    }

    /**
     * 添加用户
     *
     * @param admin
     * @return
     */
    @Override
    public Integer saveAdmin(Admin admin) {
        return adminMapper.insert(admin);
    }

    /**
     * 添加用户权限
     */
    @Override
    public Integer AddAdminRole(Integer id) {
        return adminMapper.AddAdminRole(id);
    }

    /**
     * 根据id删除用户
     */
    @Override
    public Integer deleteById(Integer id) {
        return adminMapper.deleteById(id);
    }

    /**
     * 删除用户后删除权限
     *
     * @param id
     * @return
     */
    @Override
    public Integer deleteAdminRole(int id) {
        System.out.println("要删除权限的用户id==》" + id);
        return adminMapper.deleteAdminRole(id);
    }

    /**
     * 更新用户信息
     */

    @Override
    public Integer updateUser(Admin admin) {
        return adminMapper.updateById(admin);
    }

}
