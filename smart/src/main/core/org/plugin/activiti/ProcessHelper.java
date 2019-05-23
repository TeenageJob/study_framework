package org.plugin.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.plugin.activiti.base.BaseActiviti;
import org.plugin.activiti.userAndGroup.UserAndGroup;

/**
 * 流程助手类
 */
public class ProcessHelper {

    /**
     * 获取process
     *
     * @return
     */
    public static ProcessEngine getProcessEngine() {
        return BaseActiviti.getProcessEngine();
    }

    /**
     * 创建用户
     *
     * @param userId    用户id
     * @param firstName 姓
     * @param lastName  名
     * @param email     邮箱
     * @return boolean
     */
    public static boolean createUser(String userId, String firstName, String lastName, String email,String password) {
        return UserAndGroup.createUser(userId, firstName, lastName, email,password);
    }

    /**
     * 删除用户
     *
     * @param userId 用户id
     * @return boolean
     */
    public static boolean deleteUser(String userId) {
        UserAndGroup.deleteUser(userId);
        return true;
    }

    /**
     * 查询用户
     *
     * @param userId 用户id
     * @return User
     */
    public static User queryUser(String userId) {
        return UserAndGroup.queryUser(userId);
    }

    /**
     * 创建用户组
     *
     * @param groupId   组id
     * @param groupName 组名
     * @param type      类型
     * @return boolean
     */
    public static boolean addGroup(String groupId, String groupName, String type) {
        UserAndGroup.addGroup(groupId, groupName, type);
        return true;
    }

    /**
     * 删除组
     *
     * @param groupId 组id
     * @return boolean
     */
    public static boolean deleteGroup(String groupId) {
        UserAndGroup.deleteGroup(groupId);
        return true;
    }

    /**
     * 查询组
     *
     * @param groupId 组id
     * @return Group
     */
    public static Group queryGroup(String groupId) {
        return UserAndGroup.queryGroup(groupId);
    }

    /**
     * 添加组员
     *
     * @param userId  用户id
     * @param groupId 组id
     * @return boolean
     */
    public static boolean addGroupMember(String userId, String groupId) {
        UserAndGroup.addGroupMember(userId, groupId);
        return true;
    }

    /**
     * 移除组员
     *
     * @param userId  用户id
     * @param groupId 组id
     * @return boolean
     */
    public static boolean removeGroupMember(String userId, String groupId) {
        UserAndGroup.removeGroupMember(userId, groupId);
        return true;
    }
}
