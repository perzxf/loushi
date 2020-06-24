package com.ls.entity.system;

/**
 * @author zhangchuanfei
 */
public class SysRole {


    /**
     * 角色ID（主键）
     */
    private Long    roleId;

    /**
     * 角色名称
     */
    private String  roleName;

    /**
     * 角色备注
     */
    private String  remark;

    /**
     * 显示顺序
     */
    private Integer  sort;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", remark='" + remark + '\'' +
                ", sort=" + sort +
                '}';
    }
}
