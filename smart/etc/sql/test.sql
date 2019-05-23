/*
Navicat MySQL Data Transfer

Source Server         : aliyunMySql
Source Server Version : 50715
Source Host           : tianyuan.mysql.rds.aliyuncs.com:3306
Source Database       : tianyuan

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-01-09 09:24:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for business_title
-- ----------------------------
DROP TABLE IF EXISTS `business_title`;
CREATE TABLE `business_title` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '业务标题id',
  `label_name` varchar(20) NOT NULL COMMENT '菜单名称',
  `name` varchar(50) NOT NULL COMMENT '业务标题名称',
  `id_flag` varchar(50) NOT NULL,
  `collapse` varchar(100) NOT NULL COMMENT '业务collapse id',
  `title_class` varchar(100) NOT NULL COMMENT '标题样式',
  `number_class` varchar(100) NOT NULL COMMENT '业务个数样式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business_title
-- ----------------------------
INSERT INTO `business_title` VALUES ('1', '菜单管理', '单位参保', 'headingOne', '#collapseOne', 'glyphicon glyphicon-education', 'label-success');
INSERT INTO `business_title` VALUES ('2', '菜单管理', '个人参保', 'headingTwo', '#collapseTwo', 'glyphicon glyphicon-tree-conifer', 'label-info');
INSERT INTO `business_title` VALUES ('3', '权限管理', '单位停保', 'heading3', '#collapse3', 'glyphicon glyphicon-random', 'label-warning');
INSERT INTO `business_title` VALUES ('4', '权限管理', '个人停保', 'heading4', '#collapse4', 'glyphicon glyphicon-heart', 'label-danger');

-- ----------------------------
-- Table structure for business_url
-- ----------------------------
DROP TABLE IF EXISTS `business_url`;
CREATE TABLE `business_url` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '业务功能id',
  `label_name` varchar(20) NOT NULL COMMENT '菜单名称',
  `title_name` varchar(100) NOT NULL COMMENT '业务标题名称',
  `url` varchar(100) NOT NULL COMMENT '业务功能访问的url',
  `url_name` varchar(50) NOT NULL COMMENT '业务名称',
  `permission` varchar(50) NOT NULL COMMENT '权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business_url
-- ----------------------------
INSERT INTO `business_url` VALUES ('1', '菜单管理', '单位参保', '/a/aa/aaa', '社保一', 'admin:sb1:*');
INSERT INTO `business_url` VALUES ('2', '菜单管理', '单位参保', '/a/aa/aab', '社保二', 'admin:sb1:*');
INSERT INTO `business_url` VALUES ('3', '菜单管理', '单位参保', '/a/aa/aac', '社保三', 'admin:sb1:*');
INSERT INTO `business_url` VALUES ('4', '菜单管理', '单位参保', '/a/aa/aad', '社保四', 'admin:sb1:*');
INSERT INTO `business_url` VALUES ('5', '菜单管理', '单位参保', '/a/aa/aae', '社保五', 'admin:sb1:*');
INSERT INTO `business_url` VALUES ('6', '菜单管理', '个人参保', '/a/ab/aae', '社保五', 'admin:sb1:*');
INSERT INTO `business_url` VALUES ('7', '菜单管理', '个人参保', '/a/ab/aad', '社保四', 'admin:sb1:*');
INSERT INTO `business_url` VALUES ('8', '菜单管理', '个人参保', '/a/ab/aac', '社保三', 'admin:sb1:*');
INSERT INTO `business_url` VALUES ('9', '权限管理', '个人停保', '/a/ac/aae', '社保五', 'admin:sb1:*');
INSERT INTO `business_url` VALUES ('10', '权限管理', '个人停保', '/a/ac/aad', '社保四', 'admin:sb1:*');
INSERT INTO `business_url` VALUES ('11', '权限管理', '个人停保', '/a/ac/aac', '社保三', 'admin:sb1:*');
INSERT INTO `business_url` VALUES ('12', '权限管理', '个人停保', '/a/ac/aab', '社保二', 'admin:sb1:*');
INSERT INTO `business_url` VALUES ('13', '权限管理', '个人停保', '/a/ac/aaa', '社保一', 'admin:sb1:*');
INSERT INTO `business_url` VALUES ('14', '权限管理', '单位停保', '/a/ad/aae', '社保五', 'admin:sb1:*');
INSERT INTO `business_url` VALUES ('15', '权限管理', '单位停保', '/a/ad/aad', '社保四', 'admin:sb1:*');
INSERT INTO `business_url` VALUES ('16', '权限管理', '单位停保', '/a/ad/aac', '社保三', 'admin:sb1:*');
INSERT INTO `business_url` VALUES ('17', '权限管理', '单位停保', '/a/ad/aab', '社保二', 'admin:sb1:*');
INSERT INTO `business_url` VALUES ('18', '权限管理', '单位停保', '/a/ad/aaa', '社保一', 'admin:sb1:*');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 NOT NULL,
  `description` varchar(50) DEFAULT '0',
  `disabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '个人', '社保一', 'admin:sb1:*', '添加权限', '0');
INSERT INTO `permission` VALUES ('2', '个人', '社保二', 'admin:sb2:*', '更新权限', '0');
INSERT INTO `permission` VALUES ('3', '单位', '社保三', 'admin:sb3:*', '删除权限', '0');
INSERT INTO `permission` VALUES ('4', '单位', '社保四', 'admin:sb4:*', '查询权限', '0');
INSERT INTO `permission` VALUES ('5', '单位', '社保五', 'admin:sb5:*', '社保五所有权限', '0');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(50) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `disabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'super_admin', '超级管理员', '0');
INSERT INTO `role` VALUES ('2', 'admin', '管理员', '0');
INSERT INTO `role` VALUES ('3', 'user', '用户', '0');
INSERT INTO `role` VALUES ('4', 'salesmane', '业务员', '0');

-- ----------------------------
-- Table structure for role_label
-- ----------------------------
DROP TABLE IF EXISTS `role_label`;
CREATE TABLE `role_label` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '业务标签',
  `role` varchar(20) NOT NULL COMMENT '角色',
  `name` varchar(50) NOT NULL COMMENT '业务标签名称',
  `tab_id` varchar(50) NOT NULL COMMENT '侧栏的id',
  `span_class` varchar(100) NOT NULL COMMENT '业务标签样式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_label
-- ----------------------------
INSERT INTO `role_label` VALUES ('1', 'spuer_admin', '菜单管理', 'menuManagement', 'glyphicon glyphicon-home');
INSERT INTO `role_label` VALUES ('2', 'spuer_admin', '权限管理', 'authorityManagement', 'glyphicon glyphicon-lock');
INSERT INTO `role_label` VALUES ('3', 'spuer_admin', '开发管理', 'exploitManagement', 'glyphicon glyphicon-wrench');
INSERT INTO `role_label` VALUES ('4', 'spuer_admin', '系统管理', 'systemManagement', 'glyphicon glyphicon-cog');
INSERT INTO `role_label` VALUES ('5', 'spuer_admin', '通知管理', 'informManagement', 'glyphicon glyphicon-earphone');
INSERT INTO `role_label` VALUES ('6', 'spuer_admin', '任务开发', 'taskExploit', 'glyphicon glyphicon-duplicate');
INSERT INTO `role_label` VALUES ('7', 'admin', '菜单管理', 'menuManagement', 'glyphicon glyphicon-home');
INSERT INTO `role_label` VALUES ('8', 'admin', '权限管理', 'authorityManagement', 'glyphicon glyphicon-lock');
INSERT INTO `role_label` VALUES ('9', 'admin', '开发管理', 'exploitManagement', 'glyphicon glyphicon-wrench');
INSERT INTO `role_label` VALUES ('10', 'admin', '系统管理', 'systemManagement', 'glyphicon glyphicon-cog');
INSERT INTO `role_label` VALUES ('11', 'admin', '通知管理', 'informManagement', 'glyphicon glyphicon-earphone');
INSERT INTO `role_label` VALUES ('12', 'admin', '任务开发', 'taskExploit', 'glyphicon glyphicon-duplicate');
INSERT INTO `role_label` VALUES ('13', 'salesman', '业务办理', 'businessHanding', 'glyphicon glyphicon-home');
INSERT INTO `role_label` VALUES ('14', 'salesman', '业务审核', 'businessAudit', 'glyphicon glyphicon-lock');
INSERT INTO `role_label` VALUES ('15', 'salesman', '通用业务', 'commonBusiness', 'glyphicon glyphicon-wrench');
INSERT INTO `role_label` VALUES ('16', 'salesman', '一卡通', 'oneCard', 'glyphicon glyphicon-cog');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `url_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '2', '1');
INSERT INTO `role_permission` VALUES ('6', '2', '2');
INSERT INTO `role_permission` VALUES ('7', '2', '3');
INSERT INTO `role_permission` VALUES ('8', '2', '4');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `username` varchar(25) NOT NULL,
  `salt` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `expired` int(1) DEFAULT '0',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `last_login_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `disable` int(1) DEFAULT '0',
  `lock` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '46490630@qq.com', 'tianyuan', 'tianyuan', '6c3f1225122c5e51b4d835311afb6e9d', '0', '2018-01-08 10:18:42', '2018-01-08 10:18:42', '0', '0');

-- ----------------------------
-- Table structure for user_attrs
-- ----------------------------
DROP TABLE IF EXISTS `user_attrs`;
CREATE TABLE `user_attrs` (
  `USERNAME` varchar(30) NOT NULL,
  `ATTR_KEY` varchar(50) NOT NULL,
  `ATTR_VAL` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_attrs
-- ----------------------------
INSERT INTO `user_attrs` VALUES ('admin', 'group', 'ADMIN_ROLE');
INSERT INTO `user_attrs` VALUES ('admin', 'group', 'MANAGEMENT_ROLE');
INSERT INTO `user_attrs` VALUES ('admin', 'group', 'DEV_ROLE');
INSERT INTO `user_attrs` VALUES ('admin', 'school', 'GuangZhou');
INSERT INTO `user_attrs` VALUES ('admin', 'school', 'ZhuHai');
INSERT INTO `user_attrs` VALUES ('zhangsan', 'group', 'DEV_ROLE');

-- ----------------------------
-- Table structure for user_information
-- ----------------------------
DROP TABLE IF EXISTS `user_information`;
CREATE TABLE `user_information` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `phone` bigint(11) NOT NULL COMMENT '电话',
  `operator` varchar(20) NOT NULL COMMENT '经办人',
  `operator_id` int(6) NOT NULL COMMENT '经办人id',
  `operator_organzation` varchar(50) NOT NULL COMMENT '经办机构',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_information
-- ----------------------------
INSERT INTO `user_information` VALUES ('1', 'tianyuan', '46490630@qq.com', '18428327427', '田源', '1', '西华大学');

-- ----------------------------
-- Table structure for user_question
-- ----------------------------
DROP TABLE IF EXISTS `user_question`;
CREATE TABLE `user_question` (
  `USERNAME` varchar(30) NOT NULL,
  `QUESTION` varchar(200) NOT NULL,
  `ANSWER` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_question
-- ----------------------------
INSERT INTO `user_question` VALUES ('admin', '使用过的密码是？', '123');
INSERT INTO `user_question` VALUES ('admin', '你的年龄是？', '24');
INSERT INTO `user_question` VALUES ('zhangsan', '我的名字是？', 'zhangsan');
INSERT INTO `user_question` VALUES ('zhangsan', '我在哪里工作？', 'guangzhou');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '2');
