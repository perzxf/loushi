package com.ls.service.system.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ls.common.Consts;
import com.ls.entity.system.SysUser;
import com.ls.mapper.system.SysUserMapper;
import com.ls.service.system.SysUserService;
import com.ls.utils.Md5Util;

import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author zhangchuanfei
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Override
    public SysUser findByUserName(String userName) {
        SysUser user = new SysUser();
        user.setUserName(userName);
        SysUser sysUser = baseMapper.selectOne(user);
        log.info("查询到的用户信息：{}",sysUser != null ? sysUser.toString() : null);
        return sysUser;
    }

    @Override
    public SysUser findByEmail(String email) {
        SysUser user = new SysUser();
        user.setEmail(email);
        SysUser sysUser = baseMapper.selectOne(user);
        log.info("查询到的用户信息：{}",sysUser != null ? sysUser.toString() : null);
        return sysUser;
    }


    @Override
    public SysUser getByUserId(Long userId) {
        SysUser user = new SysUser();
        user.setUserId(userId);
        SysUser sysUser = baseMapper.selectOne(user);
        log.info("查询到的用户信息：{}",sysUser != null ? sysUser.toString() : null);
        return sysUser;
    }

    @Override
    public void saveUser(SysUser user) {
        user = createByUser(user);
        baseMapper.insert(user);
        log.info("保存的用户信息：{}",user.toString());
    }

    @Override
    public List <SysUser> selectUserList(SysUser user,int page,int pageSize) {

        //设置分页
        Page<SysUser> userPage = new Page<>();
        userPage.setCurrent(page);  //当前第几页
        userPage.setSize(pageSize); //每页几条数据

        //查询条件
        Wrapper<SysUser> wrapper = new EntityWrapper<>();
        wrapper.ge("user_id",1); //userId 大于等于1
        if(user != null){
            wrapper.like("nick_name", user.getNickName()); // 模糊查询
        }
        wrapper.orderBy("create_date", false); // 按照创建时间倒序排序

        List<SysUser> users = baseMapper.selectPage(userPage, wrapper);
        log.info("当前第{}页,每页展示{}条数据,查询到用户信息一共{}条",page,pageSize,users.size());
        return users;
    }

    @Override
    public Integer getCount(SysUser user) {

        Wrapper<SysUser> wrapper = new EntityWrapper<>();

        return baseMapper.selectCount(wrapper);
    }

    @Override
    public void updateByPassword(Long userId, String password) {
        SysUser user = new SysUser();
        user.setUserId(userId);
        user.setPassword(password);
        baseMapper.updateByPassword(user);
    }


    /**
     * 创建用户基本情况
     * @param user
     * @return
     */
    private SysUser createByUser(SysUser user) {
        //密码+盐
        user.setPassword(Md5Util.md5(user.getPassword(), Consts.SALT));
        //头像
        user.setHeadPortrait("tou.jpg");
        //创建时间
        Date date = new Date();
        user.setCreateDate(date);
        //开始使用时间
        user.setStartDate(date);
        //结束使用时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DAY_OF_WEEK, Consts.DAY); //把日期往后增加3天
        user.setEndDate(calendar.getTime());
        //默认未封禁
        user.setIsOff(Consts.ISOFF);
        return user;
    }



}
