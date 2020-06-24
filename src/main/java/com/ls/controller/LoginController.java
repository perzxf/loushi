package com.ls.controller;

import com.ls.common.Consts;
import com.ls.entity.system.SysMenu;
import com.ls.entity.system.SysUser;
import com.ls.service.system.SysMenuService;
import com.ls.service.system.SysUserService;
import com.ls.utils.Md5Util;
import com.ls.utils.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangchuanfei
 */
@Controller
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private SysUserService userService;


    /**
     * 用户登录
     */
    @ResponseBody
    @PostMapping("/user/login")
    public Map<String,Object> login(SysUser user, HttpSession session){
        Map<String,Object> map = new HashMap<>();
        if(StringUtil.isEmpty(user.getUserName())){
            map.put("success",false);
            map.put("errorInfo","请输入用户名！");
        }else if(StringUtil.isEmpty(user.getPassword())){
            map.put("success",false);
            map.put("errorInfo","请输入密码！");
        }else{
            Subject subject = SecurityUtils.getSubject();
            //加密后的密码
            String password = Md5Util.md5(user.getPassword(), Consts.SALT);

            UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),password);
            try {
                subject.login(token);       //登录验证
                String userName = (String) SecurityUtils.getSubject().getPrincipal();
                SysUser currentUser = userService.findByUserName(userName);
                if (currentUser.getIsOff() != Consts.ISOFF) {
                    map.put("success", false);
                    map.put("errorInfo", "该用户已封禁，请联系管理员！");
                    subject.logout();
                } else {
                    session.setAttribute(Consts.CURRENT_USER,currentUser);
                    map.put("success", true);
                }
            }catch (Exception e){
                e.printStackTrace();
                map.put("success", false);
                map.put("errorInfo", "用户名或密码错误！");
            }
        }
        return map;
    }


}
