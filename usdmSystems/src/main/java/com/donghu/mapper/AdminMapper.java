package com.donghu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.donghu.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper extends BaseMapper<Admin> {
    /**
     * 用户登录
     *
     * @param admin
     * @return
     */
    public Admin getLoginUser(Admin admin);

    /**
     * 根据条件查询用户
     *
     * @param search
     * @return
     */
    public List<Admin> SearchUserInfo(@Param("search") String search);

    /**
     * 查询用户id
     */
    public int SearchUserId(@Param("name") String name);

    /**
     * 添加用户权限
     */
    public Integer AddAdminRole(@Param("id") Integer id);

    /**
     * 删除用户后删除权限
     */
    public Integer deleteAdminRole(@Param("AdminId") Integer id);
}
