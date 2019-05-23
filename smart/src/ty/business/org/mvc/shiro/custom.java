package org.mvc.shiro;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import org.plugin.security.SmartSecurity;
import org.smart.framework.dao.DatabaseHelper;

public class custom implements SmartSecurity {

    @Override
    public String getPassword(String username) {
        String sql = "select password from user where username = ? and `disable` = 0";
        return DatabaseHelper.queryColumn(sql, username);
    }

    @Override
    public Set<String> getRoleNameSet(String username) {
        String sql = "select r.role from user u, user_role ur, role r where u.id = ur.user_id and r.id = ur.role_id and u.username = ?";
        return DatabaseHelper.queryColumnSet(sql, username);
    }

    @Override
    public Set<String> getPermissionNameSet(String roleName) {
        String sql = "select p.url from role r, role_permission rp, permission p where r.id = rp.role_id and p.id = rp.url_id and r.role = ?";
        return DatabaseHelper.queryColumnSet(sql, roleName);
    }

    @Override
    public int lockUser(String username) {
        String sql = "update user set `disable` = 1 where username= ?";
        return DatabaseHelper.update(sql, username);
    }

    @Override
    public Serializable createRole(Map paramMap) {
        String sql = "insert into role(role,description,disabled)values(?,?,?)";
        return DatabaseHelper.insertReturnPK(sql, paramMap.get("role"), paramMap.get("description"), paramMap.get("disabled"));
    }

    @Override
    public void deleteRole(Long roleId) {
        String sql = "delete from role where id=?";
        DatabaseHelper.update(sql, roleId);
    }

    @Override
    public void addUserRole(Map paramMap) {
        //String sql="insert"
    }

    @Override
    public void delUserRole(Map paramMap) {

    }

}
