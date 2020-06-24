package com.ls.controller.system;


import com.ls.entity.system.SysUser;
import com.ls.service.system.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author zhangchuanfei
 */
@Controller
public class SysUserController {

    private static final Logger log = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private SysUserService userService;


    @GetMapping("/system/user/index")
    public String toUserIndex(){
        return "user/index";
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @PostMapping("/system/user/register")
    @ResponseBody
    public Map<String,Object> register(SysUser user){
        Map<String,Object> map = new HashMap<>();
        if(user == null){
            map.put("success",false);
            map.put("errorInfo","用户信息为空！");
        }else if(userService.findByEmail(user.getEmail()) != null){
            map.put("success",false);
            map.put("errorInfo","邮箱已存在，请更换！");
        }else if(userService.findByUserName(user.getUserName()) != null){
            map.put("success",false);
            map.put("errorInfo","用户名已存在，请更换！");
        }else{
            userService.saveUser(user);
            map.put("success",true);
        }
        return map;
    }

    /**
     * 用户列表分页查询
     * @param user
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/system/user/list")
    @ResponseBody
    public Map<String,Object> listByUser(@RequestBody  SysUser user, Integer page, Integer pageSize){
        Map<String,Object> map = new HashMap<>();
        log.info("当前第{}页,每页展示{}条数据,条件查询的用户信息：{}",page,pageSize,user.toString());

        //查询用户列表 带查询 带分页
        List <SysUser> sysUsers = userService.selectUserList(user,page,pageSize);
        //查询用户总条数
        Integer count = userService.getCount(user);
        log.info("用户列表总共有{}条",count);

        map.put("data",sysUsers);
        map.put("count",count);
        map.put("code",0);
        return map;
    }

}
