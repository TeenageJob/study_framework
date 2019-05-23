package org.plugin.activiti.userAndGroup;

import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.plugin.activiti.base.BaseActiviti;

public class UserAndGroup extends BaseActiviti {


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
        User user = identityService.newUser(userId);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        identityService.saveUser(user);
        return true;
    }

    /**
     * 删除用户
     *
     * @param userId 用户id
     * @return boolean
     */
    public static boolean deleteUser(String userId) {
        identityService.deleteUser(userId);
        return true;
    }

    /**
     * 查询用户
     *
     * @param userId 用户id
     * @return User
     */
    public static User queryUser(String userId) {
        return identityService.createUserQuery().userId(userId).singleResult();
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
        Group group = identityService.newGroup(groupId);
        group.setName(groupName);
        group.setType(type);
        identityService.saveGroup(group);
        return true;
    }

    /**
     * 删除组
     *
     * @param groupId 组id
     * @return boolean
     */
    public static boolean deleteGroup(String groupId) {
        identityService.deleteGroup(groupId);
        return true;
    }

    /**
     * 查询组
     *
     * @param groupId 组id
     * @return Group
     */
    public static Group queryGroup(String groupId) {
        return identityService.createGroupQuery().groupId(groupId).singleResult();
    }

    /**
     * 添加组员
     *
     * @param userId  用户id
     * @param groupId 组id
     * @return boolean
     */
    public static boolean addGroupMember(String userId, String groupId) {
        identityService.createMembership(userId, groupId);
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
        identityService.deleteMembership(userId, groupId);
        return true;
    }

}
