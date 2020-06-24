package com.ls.service.system;

import com.baomidou.mybatisplus.service.IService;
import com.ls.entity.system.SysUser;

import java.util.List;

/**
 * @author zhangchuanfei
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 根据用户名查找用户实体
     */
    public SysUser findByUserName(String userName);

    /**
     * 根据邮箱查找用户实体
     */
    public SysUser findByEmail(String email);

    /**
     * 根据id获取用户信息
     */
    public SysUser getByUserId(Long userId);

    /**
     * 新增用户
     */
    public void saveUser(SysUser user);

    /**
     * 查询用户列表 带查询 带分页
     */
    public List<SysUser> selectUserList(SysUser user,int page,int pageSize);

    /**
     * 查询用户总条数
     */
    public Integer getCount(SysUser user);

    /**
     * 修改用户密码
     */
    void updateByPassword(Long userId, String password);
}
