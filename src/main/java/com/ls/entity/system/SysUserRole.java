package com.ls.entity.system;

/**
 * @author zhangchuanfei
 */
public class SysUserRole {


    /**
     * 主键ID
     */
    private Long    urId;

    /**
     * 用户ID（关联用户表）
     */
    private Long    userId;

    /**
     * 角色ID（关联角色表）
     */
    private Long    roleId;


    public Long getUrId() {
        return urId;
    }

    public void setUrId(Long urId) {
        this.urId = urId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "SysUserRole{" +
                "urId=" + urId +
                ", userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
