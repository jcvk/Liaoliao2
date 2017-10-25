package cn.huashantech.liaoliao2.entity.po;


import cn.huashantech.liaoliao2.entity.Base.BaseEntity;

/**
 * @author lihang
 * @create 2017-06-16 下午5:53
 */
public class UserRoleInfo extends BaseEntity<UserRoleInfo> {

    private String roleIcon;
    // ['ROLE_GUEST', 'ROLE_USER', 'ROLE_ADMIN', 'ROLE_OPERATOR',
    // 'ROLE_KEDOU', 'ROLE_ALPHA', 'ROLE_FINANCE', 'ROLE_ASSISTANT',
    // 'ROLE_ORGANIZATION', 'ROLE_ANCHOR']
    private String userRole;

    public String getRoleIcon() {
        return roleIcon;
    }

    public void setRoleIcon(String roleIcon) {
        this.roleIcon = roleIcon;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
