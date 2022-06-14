package com.donghu.service;

import com.donghu.pojo.Admin;

import java.util.List;

public interface IAdminService {
    /**
     * 登录
     * @param admin
     * @return
     */
    Admin getLoginUser(Admin admin);

    /**
     * 根据条件查询用户
     * @param search
     * @return
     */
    List<Admin> SearchUserInfo(String search);

    /**
     * 查询用户id
     */
    public int SearchUserId(String name);

    /**
     * 添加用户
     *
     * @param admin
     * @return
     */
    Integer saveAdmin(Admin admin);
    /**
     * 添加用户权限
     */
    Integer AddAdminRole(Integer id);

    /**
     * 根据id删除用户
     */
    public Integer deleteById(Integer id);

    /**
     * 根据用户id删除对应权限
     * @param id
     * @return
     */
    Integer deleteAdminRole(int id);
    /**
     * 更新用户信息
     */
    Integer updateUser(Admin admin);
}
