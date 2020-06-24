package com.ls.controller.admin;


import com.ls.common.Consts;
import com.ls.entity.system.SysMenu;
import com.ls.entity.system.SysUser;
import com.ls.service.system.SysMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * 管理员 - 首页或者跳转url控制器
 */
@Controller
public class IndexAdminController {

    @Autowired
    private SysMenuService menuService;

    @RequiresPermissions(value="进入管理员主页")
    @GetMapping("/toAdminUserCenterPage")
    public String toAdminUserCenterPage(HttpSession session, Model model){

        SysUser currentUser = (SysUser) session.getAttribute(Consts.CURRENT_USER);
        List<SysMenu> sysMenus = menuService.selectMenusByUser(currentUser.getUserId());
        model.addAttribute("menus",sysMenus);

        return "admin/index";
    }

    @GetMapping("/loginDefault")
    public String toLoginDefault(){
        return "admin/default";
    }

}
