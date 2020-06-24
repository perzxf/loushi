package com.ls.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ls.entity.system.SysUser;

/**
 * @author zhangchuanfei
 */
public interface SysUserMapper extends BaseMapper<SysUser> {


    void updateByPassword(SysUser user);
}
