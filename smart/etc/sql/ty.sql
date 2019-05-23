/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : ty

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-02-06 09:37:05
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
INSERT INTO `business_title` VALUES ('1', '菜单管理', '单位参保', 'headingOne', 'collapseOne', 'glyphicon glyphicon-education', 'label-success');
INSERT INTO `business_title` VALUES ('2', '菜单管理', '个人参保', 'headingTwo', 'collapseTwo', 'glyphicon glyphicon-tree-conifer', 'label-info');
INSERT INTO `business_title` VALUES ('3', '权限管理', '单位停保', 'headingThree', 'collapseThree', 'glyphicon glyphicon-random', 'label-warning');
INSERT INTO `business_title` VALUES ('4', '权限管理', '个人停保', 'headingFour', 'collapseFour', 'glyphicon glyphicon-heart', 'label-danger');

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
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` char(10) DEFAULT NULL,
  `time` char(8) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('1', '2017-11-22', '11:45:05', 'update product by id is 12');
INSERT INTO `log` VALUES ('2', '2017-11-22', '11:45:14', 'update product by id is 11');
INSERT INTO `log` VALUES ('3', '2017-11-22', '11:45:22', 'update product by id is 10');
INSERT INTO `log` VALUES ('4', '2017-11-22', '11:45:30', 'update product by id is 9');
INSERT INTO `log` VALUES ('5', '2017-11-22', '11:45:42', 'update product by id is 12');
INSERT INTO `log` VALUES ('6', '2017-11-22', '14:20:36', 'update product by id is 12');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '菜单名',
  `tab_id` varchar(50) NOT NULL COMMENT 'tab_id,业务功能tab元素的id',
  `span_class` varchar(100) DEFAULT NULL COMMENT '菜单名样式',
  `span_style` varchar(100) DEFAULT NULL COMMENT '样式颜色',
  `warp_id` varchar(50) DEFAULT NULL COMMENT '外层用于收缩的div的id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '菜单管理', 'menuManagement', 'glyphicon glyphicon-home', '#A9D86E', 'menuManagement_warp');
INSERT INTO `menu` VALUES ('2', '权限管理', 'exploitManagement', 'glyphicon glyphicon-wrench', '#8175c7', 'exploitManagement_warp');
INSERT INTO `menu` VALUES ('3', '系统管理', 'systemManagement', 'glyphicon glyphicon-cog', '#fcce54', 'systemManagement_warp');
INSERT INTO `menu` VALUES ('4', '通知管理', 'informManagement', 'glyphicon glyphicon-earphone', '#344860', 'informManagement_warp');
INSERT INTO `menu` VALUES ('5', '任务开发', 'taskExploit', 'glyphicon glyphicon-duplicate', '#93c059', 'taskExploit_warp');
INSERT INTO `menu` VALUES ('6', '业务办理', 'businessHanding', 'glyphicon glyphicon-home', '#55ACEE', 'businessHanding_warp');
INSERT INTO `menu` VALUES ('7', '业务审核', 'businessAudit', 'glyphicon glyphicon-lock', '#5cb85c', 'businessAudit_warp');
INSERT INTO `menu` VALUES ('8', '通用业务', 'commonBusiness', 'glyphicon glyphicon-wrench', '#ff6c60', 'commonBusiness_warp');
INSERT INTO `menu` VALUES ('9', '一卡通', 'oneCard', 'glyphicon glyphicon-cog', '#a659fc', 'oneCard_warp');
INSERT INTO `menu` VALUES ('10', '开发管理', 'exploitManagement', 'glyphicon glyphicon-wrench', '#fccb48', 'exploitManagement_warp');

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
INSERT INTO `role` VALUES ('3', 'salesmane', '业务员', '0');
INSERT INTO `role` VALUES ('5', 'user', '用户', '0');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '业务标签',
  `role` varchar(25) NOT NULL COMMENT '角色',
  `menu` varchar(25) NOT NULL COMMENT '业务标签名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', 'super_admin', '菜单管理');
INSERT INTO `role_menu` VALUES ('2', 'super_admin', '权限管理');
INSERT INTO `role_menu` VALUES ('3', 'super_admin', '开发管理');
INSERT INTO `role_menu` VALUES ('4', 'super_admin', '系统管理');
INSERT INTO `role_menu` VALUES ('5', 'super_admin', '通知管理');
INSERT INTO `role_menu` VALUES ('6', 'super_admin', '任务开发');
INSERT INTO `role_menu` VALUES ('7', 'admin', '菜单管理');
INSERT INTO `role_menu` VALUES ('8', 'admin', '权限管理');
INSERT INTO `role_menu` VALUES ('9', 'admin', '开发管理');
INSERT INTO `role_menu` VALUES ('10', 'admin', '系统管理');
INSERT INTO `role_menu` VALUES ('11', 'admin', '通知管理');
INSERT INTO `role_menu` VALUES ('12', 'admin', '任务开发');
INSERT INTO `role_menu` VALUES ('13', 'salesmane', '业务办理');
INSERT INTO `role_menu` VALUES ('14', 'salesmane', '业务审核');
INSERT INTO `role_menu` VALUES ('15', 'salesmane', '通用业务');
INSERT INTO `role_menu` VALUES ('16', 'salesmane', '一卡通');

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
-- Table structure for sessions
-- ----------------------------
DROP TABLE IF EXISTS `sessions`;
CREATE TABLE `sessions` (
  `id` varchar(200) NOT NULL,
  `session` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sessions
-- ----------------------------
INSERT INTO `sessions` VALUES ('7678e3b5-2a44-4409-9e5f-7777ee2ec844', 'rO0ABXNyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0Lk9ubGluZVNlc3Npb26dHKG41YxibgMAA0wABnN0YXR1c3QAOUxvcmcvYXBhY2hlL3NoaXJvL3Nlc3Npb24vbWd0L09ubGluZVNlc3Npb24kT25saW5lU3RhdHVzO0wACnN5c3RlbUhvc3R0ABJMamF2YS9sYW5nL1N0cmluZztMAAl1c2VyQWdlbnRxAH4AAnhyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0LlNpbXBsZVNlc3Npb26dHKG41YxibgMAAHhwdwIAW3QAJDc2NzhlM2I1LTJhNDQtNDQwOS05ZTVmLTc3NzdlZTJlYzg0NHNyAA5qYXZhLnV0aWwuRGF0ZWhqgQFLWXQZAwAAeHB3CAAAAWBo1fAXeHNxAH4ABncIAAABYGjW0yF4dxMAAAAAABt3QAAJMTI3LjAuMC4xeH5yADdvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0Lk9ubGluZVNlc3Npb24kT25saW5lU3RhdHVzAAAAAAAAAAASAAB4cgAOamF2YS5sYW5nLkVudW0AAAAAAAAAABIAAHhwdAAHb25fbGluZXQADjEyNy4wLjAuMTo4MDgwdABtTW96aWxsYS81LjAgKFdpbmRvd3MgTlQgMTAuMDsgV09XNjQpIEFwcGxlV2ViS2l0LzUzNy4zNiAoS0hUTUwsIGxpa2UgR2Vja28pIENocm9tZS82MC4wLjMxMTIuOTAgU2FmYXJpLzUzNy4zNncCAwBxAH4ADnEAfgALeA==');
INSERT INTO `sessions` VALUES ('95ea9a2e-2968-4ffb-828a-13d36e951dd7', 'rO0ABXNyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0Lk9ubGluZVNlc3Npb26dHKG41YxibgMAA0wABnN0YXR1c3QAOUxvcmcvYXBhY2hlL3NoaXJvL3Nlc3Npb24vbWd0L09ubGluZVNlc3Npb24kT25saW5lU3RhdHVzO0wACnN5c3RlbUhvc3R0ABJMamF2YS9sYW5nL1N0cmluZztMAAl1c2VyQWdlbnRxAH4AAnhyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0LlNpbXBsZVNlc3Npb26dHKG41YxibgMAAHhwdwIAW3QAJDk1ZWE5YTJlLTI5NjgtNGZmYi04MjhhLTEzZDM2ZTk1MWRkN3NyAA5qYXZhLnV0aWwuRGF0ZWhqgQFLWXQZAwAAeHB3CAAAAWBo7srxeHNxAH4ABncIAAABYGj2d5d4dxkAAAAAABt3QAAPMDowOjA6MDowOjA6MDoxeH5yADdvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0Lk9ubGluZVNlc3Npb24kT25saW5lU3RhdHVzAAAAAAAAAAASAAB4cgAOamF2YS5sYW5nLkVudW0AAAAAAAAAABIAAHhwdAAHb25fbGluZXQAFDA6MDowOjA6MDowOjA6MTo4MDgxdABtTW96aWxsYS81LjAgKFdpbmRvd3MgTlQgMTAuMDsgV09XNjQpIEFwcGxlV2ViS2l0LzUzNy4zNiAoS0hUTUwsIGxpa2UgR2Vja28pIENocm9tZS82MC4wLjMxMTIuOTAgU2FmYXJpLzUzNy4zNncCAwBxAH4ADnEAfgALeA==');
INSERT INTO `sessions` VALUES ('085b0663-6f57-4612-ab6c-bc29e95bca9f', 'rO0ABXNyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0Lk9ubGluZVNlc3Npb26dHKG41YxibgMAA0wABnN0YXR1c3QAOUxvcmcvYXBhY2hlL3NoaXJvL3Nlc3Npb24vbWd0L09ubGluZVNlc3Npb24kT25saW5lU3RhdHVzO0wACnN5c3RlbUhvc3R0ABJMamF2YS9sYW5nL1N0cmluZztMAAl1c2VyQWdlbnRxAH4AAnhyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0LlNpbXBsZVNlc3Npb26dHKG41YxibgMAAHhwdwIA23QAJDA4NWIwNjYzLTZmNTctNDYxMi1hYjZjLWJjMjllOTViY2E5ZnNyAA5qYXZhLnV0aWwuRGF0ZWhqgQFLWXQZAwAAeHB3CAAAAWBo9ru/eHNxAH4ABncIAAABYGj26zp4dxkAAAAAABt3QAAPMDowOjA6MDowOjA6MDoxc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAADHcIAAAAEAAAAAJ0AFBvcmcuYXBhY2hlLnNoaXJvLnN1YmplY3Quc3VwcG9ydC5EZWZhdWx0U3ViamVjdENvbnRleHRfQVVUSEVOVElDQVRFRF9TRVNTSU9OX0tFWXNyABFqYXZhLmxhbmcuQm9vbGVhbs0gcoDVnPruAgABWgAFdmFsdWV4cAF0AE1vcmcuYXBhY2hlLnNoaXJvLnN1YmplY3Quc3VwcG9ydC5EZWZhdWx0U3ViamVjdENvbnRleHRfUFJJTkNJUEFMU19TRVNTSU9OX0tFWXNyADJvcmcuYXBhY2hlLnNoaXJvLnN1YmplY3QuU2ltcGxlUHJpbmNpcGFsQ29sbGVjdGlvbqh/WCXGowhKAwABTAAPcmVhbG1QcmluY2lwYWxzdAAPTGphdmEvdXRpbC9NYXA7eHBzcgAXamF2YS51dGlsLkxpbmtlZEhhc2hNYXA0wE5cEGzA+wIAAVoAC2FjY2Vzc09yZGVyeHEAfgAJP0AAAAAAAAx3CAAAABAAAAABdAAGY3VzdG9tc3IAF2phdmEudXRpbC5MaW5rZWRIYXNoU2V02GzXWpXdKh4CAAB4cgARamF2YS51dGlsLkhhc2hTZXS6RIWVlri3NAMAAHhwdwwAAAAQP0AAAAAAAAF0AAh0aWFueXVhbnh4AHcBAXEAfgATeHh4fnIAN29yZy5hcGFjaGUuc2hpcm8uc2Vzc2lvbi5tZ3QuT25saW5lU2Vzc2lvbiRPbmxpbmVTdGF0dXMAAAAAAAAAABIAAHhyAA5qYXZhLmxhbmcuRW51bQAAAAAAAAAAEgAAeHB0AAdvbl9saW5ldAAUMDowOjA6MDowOjA6MDoxOjgwODF0AG1Nb3ppbGxhLzUuMCAoV2luZG93cyBOVCAxMC4wOyBXT1c2NCkgQXBwbGVXZWJLaXQvNTM3LjM2IChLSFRNTCwgbGlrZSBHZWNrbykgQ2hyb21lLzYwLjAuMzExMi45MCBTYWZhcmkvNTM3LjM2dwIDAHEAfgAecQB+ABt4');
INSERT INTO `sessions` VALUES ('c17cc8ea-edda-4594-919e-ca4bc5ca9e3e', 'rO0ABXNyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0Lk9ubGluZVNlc3Npb26dHKG41YxibgMAA0wABnN0YXR1c3QAOUxvcmcvYXBhY2hlL3NoaXJvL3Nlc3Npb24vbWd0L09ubGluZVNlc3Npb24kT25saW5lU3RhdHVzO0wACnN5c3RlbUhvc3R0ABJMamF2YS9sYW5nL1N0cmluZztMAAl1c2VyQWdlbnRxAH4AAnhyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0LlNpbXBsZVNlc3Npb26dHKG41YxibgMAAHhwdwIA23QAJGMxN2NjOGVhLWVkZGEtNDU5NC05MTllLWNhNGJjNWNhOWUzZXNyAA5qYXZhLnV0aWwuRGF0ZWhqgQFLWXQZAwAAeHB3CAAAAWBo+ASNeHNxAH4ABncIAAABYGj4GDh4dxkAAAAAABt3QAAPMDowOjA6MDowOjA6MDoxc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAADHcIAAAAEAAAAAJ0AFBvcmcuYXBhY2hlLnNoaXJvLnN1YmplY3Quc3VwcG9ydC5EZWZhdWx0U3ViamVjdENvbnRleHRfQVVUSEVOVElDQVRFRF9TRVNTSU9OX0tFWXNyABFqYXZhLmxhbmcuQm9vbGVhbs0gcoDVnPruAgABWgAFdmFsdWV4cAF0AE1vcmcuYXBhY2hlLnNoaXJvLnN1YmplY3Quc3VwcG9ydC5EZWZhdWx0U3ViamVjdENvbnRleHRfUFJJTkNJUEFMU19TRVNTSU9OX0tFWXNyADJvcmcuYXBhY2hlLnNoaXJvLnN1YmplY3QuU2ltcGxlUHJpbmNpcGFsQ29sbGVjdGlvbqh/WCXGowhKAwABTAAPcmVhbG1QcmluY2lwYWxzdAAPTGphdmEvdXRpbC9NYXA7eHBzcgAXamF2YS51dGlsLkxpbmtlZEhhc2hNYXA0wE5cEGzA+wIAAVoAC2FjY2Vzc09yZGVyeHEAfgAJP0AAAAAAAAx3CAAAABAAAAABdAAGY3VzdG9tc3IAF2phdmEudXRpbC5MaW5rZWRIYXNoU2V02GzXWpXdKh4CAAB4cgARamF2YS51dGlsLkhhc2hTZXS6RIWVlri3NAMAAHhwdwwAAAAQP0AAAAAAAAF0AAh0aWFueXVhbnh4AHcBAXEAfgATeHh4fnIAN29yZy5hcGFjaGUuc2hpcm8uc2Vzc2lvbi5tZ3QuT25saW5lU2Vzc2lvbiRPbmxpbmVTdGF0dXMAAAAAAAAAABIAAHhyAA5qYXZhLmxhbmcuRW51bQAAAAAAAAAAEgAAeHB0AAdvbl9saW5ldAAUMDowOjA6MDowOjA6MDoxOjgwODF0AG1Nb3ppbGxhLzUuMCAoV2luZG93cyBOVCAxMC4wOyBXT1c2NCkgQXBwbGVXZWJLaXQvNTM3LjM2IChLSFRNTCwgbGlrZSBHZWNrbykgQ2hyb21lLzYwLjAuMzExMi45MCBTYWZhcmkvNTM3LjM2dwIDAHEAfgAecQB+ABt4');
INSERT INTO `sessions` VALUES ('b6985edc-6867-42b7-a258-ad66de6663a4', 'rO0ABXNyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0Lk9ubGluZVNlc3Npb26dHKG41YxibgMAA0wABnN0YXR1c3QAOUxvcmcvYXBhY2hlL3NoaXJvL3Nlc3Npb24vbWd0L09ubGluZVNlc3Npb24kT25saW5lU3RhdHVzO0wACnN5c3RlbUhvc3R0ABJMamF2YS9sYW5nL1N0cmluZztMAAl1c2VyQWdlbnRxAH4AAnhyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0LlNpbXBsZVNlc3Npb26dHKG41YxibgMAAHhwdwIAW3QAJGI2OTg1ZWRjLTY4NjctNDJiNy1hMjU4LWFkNjZkZTY2NjNhNHNyAA5qYXZhLnV0aWwuRGF0ZWhqgQFLWXQZAwAAeHB3CAAAAWBswkj+eHNxAH4ABncIAAABYGzDK554dxkAAAAAABt3QAAPMDowOjA6MDowOjA6MDoxeH5yADdvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0Lk9ubGluZVNlc3Npb24kT25saW5lU3RhdHVzAAAAAAAAAAASAAB4cgAOamF2YS5sYW5nLkVudW0AAAAAAAAAABIAAHhwdAAHb25fbGluZXQAFDA6MDowOjA6MDowOjA6MTo4MDgxdABtTW96aWxsYS81LjAgKFdpbmRvd3MgTlQgMTAuMDsgV09XNjQpIEFwcGxlV2ViS2l0LzUzNy4zNiAoS0hUTUwsIGxpa2UgR2Vja28pIENocm9tZS82MC4wLjMxMTIuOTAgU2FmYXJpLzUzNy4zNncCAwBxAH4ADnEAfgALeA==');
INSERT INTO `sessions` VALUES ('32e86c8f-ff2b-4ed9-a295-5a84a9e86d3f', 'rO0ABXNyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0Lk9ubGluZVNlc3Npb26dHKG41YxibgMAA0wABnN0YXR1c3QAOUxvcmcvYXBhY2hlL3NoaXJvL3Nlc3Npb24vbWd0L09ubGluZVNlc3Npb24kT25saW5lU3RhdHVzO0wACnN5c3RlbUhvc3R0ABJMamF2YS9sYW5nL1N0cmluZztMAAl1c2VyQWdlbnRxAH4AAnhyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0LlNpbXBsZVNlc3Npb26dHKG41YxibgMAAHhwdwIAW3QAJDMyZTg2YzhmLWZmMmItNGVkOS1hMjk1LTVhODRhOWU4NmQzZnNyAA5qYXZhLnV0aWwuRGF0ZWhqgQFLWXQZAwAAeHB3CAAAAWBuHqr+eHEAfgAHdxkAAAAAABt3QAAPMDowOjA6MDowOjA6MDoxeH5yADdvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0Lk9ubGluZVNlc3Npb24kT25saW5lU3RhdHVzAAAAAAAAAAASAAB4cgAOamF2YS5sYW5nLkVudW0AAAAAAAAAABIAAHhwdAAHb25fbGluZXQAFDA6MDowOjA6MDowOjA6MTo5MDgwdABtTW96aWxsYS81LjAgKFdpbmRvd3MgTlQgMTAuMDsgV09XNjQpIEFwcGxlV2ViS2l0LzUzNy4zNiAoS0hUTUwsIGxpa2UgR2Vja28pIENocm9tZS82MC4wLjMxMTIuOTAgU2FmYXJpLzUzNy4zNncCAwBxAH4ADXEAfgAKeA==');
INSERT INTO `sessions` VALUES ('34c47b3f-c7f7-4451-9de3-353aa7547e80', 'rO0ABXNyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0Lk9ubGluZVNlc3Npb26dHKG41YxibgMAA0wABnN0YXR1c3QAOUxvcmcvYXBhY2hlL3NoaXJvL3Nlc3Npb24vbWd0L09ubGluZVNlc3Npb24kT25saW5lU3RhdHVzO0wACnN5c3RlbUhvc3R0ABJMamF2YS9sYW5nL1N0cmluZztMAAl1c2VyQWdlbnRxAH4AAnhyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0LlNpbXBsZVNlc3Npb26dHKG41YxibgMAAHhwdwIA23QAJDM0YzQ3YjNmLWM3ZjctNDQ1MS05ZGUzLTM1M2FhNzU0N2U4MHNyAA5qYXZhLnV0aWwuRGF0ZWhqgQFLWXQZAwAAeHB3CAAAAWCV0xz2eHEAfgAHdxkAAAAAABt3QAAPMDowOjA6MDowOjA6MDoxc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAADHcIAAAAEAAAAAF0ABFzaGlyb1NhdmVkUmVxdWVzdHNyACZvcmcuYXBhY2hlLnNoaXJvLndlYi51dGlsLlNhdmVkUmVxdWVzdK/OPK15gsq6AgADTAAGbWV0aG9kcQB+AAJMAAtxdWVyeVN0cmluZ3EAfgACTAAKcmVxdWVzdFVSSXEAfgACeHB0AANHRVRwdAAWL3NtYXJ0L2NvbW1vbi9sb2dpbi5kb3h4fnIAN29yZy5hcGFjaGUuc2hpcm8uc2Vzc2lvbi5tZ3QuT25saW5lU2Vzc2lvbiRPbmxpbmVTdGF0dXMAAAAAAAAAABIAAHhyAA5qYXZhLmxhbmcuRW51bQAAAAAAAAAAEgAAeHB0AAdvbl9saW5ldAAUMDowOjA6MDowOjA6MDoxOjkwODB0AG5Nb3ppbGxhLzUuMCAoV2luZG93cyBOVCAxMC4wOyBXT1c2NCkgQXBwbGVXZWJLaXQvNTM3LjM2IChLSFRNTCwgbGlrZSBHZWNrbykgQ2hyb21lLzYzLjAuMzIzOS4xMDggU2FmYXJpLzUzNy4zNncCAwBxAH4AFHEAfgAReA==');
INSERT INTO `sessions` VALUES ('6cf2485f-d951-4afd-8098-2b31e4902eb1', 'rO0ABXNyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0Lk9ubGluZVNlc3Npb26dHKG41YxibgMAA0wABnN0YXR1c3QAOUxvcmcvYXBhY2hlL3NoaXJvL3Nlc3Npb24vbWd0L09ubGluZVNlc3Npb24kT25saW5lU3RhdHVzO0wACnN5c3RlbUhvc3R0ABJMamF2YS9sYW5nL1N0cmluZztMAAl1c2VyQWdlbnRxAH4AAnhyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0LlNpbXBsZVNlc3Npb26dHKG41YxibgMAAHhwdwIA23QAJDZjZjI0ODVmLWQ5NTEtNGFmZC04MDk4LTJiMzFlNDkwMmViMXNyAA5qYXZhLnV0aWwuRGF0ZWhqgQFLWXQZAwAAeHB3CAAAAWCV1I/leHNxAH4ABncIAAABYJXbTER4dxkAAAAAABt3QAAPMDowOjA6MDowOjA6MDoxc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAADHcIAAAAEAAAAAF0ABFzaGlyb1NhdmVkUmVxdWVzdHNyACZvcmcuYXBhY2hlLnNoaXJvLndlYi51dGlsLlNhdmVkUmVxdWVzdK/OPK15gsq6AgADTAAGbWV0aG9kcQB+AAJMAAtxdWVyeVN0cmluZ3EAfgACTAAKcmVxdWVzdFVSSXEAfgACeHB0AANHRVRwdAAWL3NtYXJ0L2NvbW1vbi9sb2dpbi5kb3h4fnIAN29yZy5hcGFjaGUuc2hpcm8uc2Vzc2lvbi5tZ3QuT25saW5lU2Vzc2lvbiRPbmxpbmVTdGF0dXMAAAAAAAAAABIAAHhyAA5qYXZhLmxhbmcuRW51bQAAAAAAAAAAEgAAeHB0AAdvbl9saW5ldAAUMDowOjA6MDowOjA6MDoxOjkwODB0AG5Nb3ppbGxhLzUuMCAoV2luZG93cyBOVCAxMC4wOyBXT1c2NCkgQXBwbGVXZWJLaXQvNTM3LjM2IChLSFRNTCwgbGlrZSBHZWNrbykgQ2hyb21lLzYzLjAuMzIzOS4xMDggU2FmYXJpLzUzNy4zNncCAwBxAH4AFXEAfgASeA==');
INSERT INTO `sessions` VALUES ('81c75538-8957-44a7-a87f-0d802c0789f4', 'rO0ABXNyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0Lk9ubGluZVNlc3Npb26dHKG41YxibgMAA0wABnN0YXR1c3QAOUxvcmcvYXBhY2hlL3NoaXJvL3Nlc3Npb24vbWd0L09ubGluZVNlc3Npb24kT25saW5lU3RhdHVzO0wACnN5c3RlbUhvc3R0ABJMamF2YS9sYW5nL1N0cmluZztMAAl1c2VyQWdlbnRxAH4AAnhyACpvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0LlNpbXBsZVNlc3Npb26dHKG41YxibgMAAHhwdwIAW3QAJDgxYzc1NTM4LTg5NTctNDRhNy1hODdmLTBkODAyYzA3ODlmNHNyAA5qYXZhLnV0aWwuRGF0ZWhqgQFLWXQZAwAAeHB3CAAAAWCV3WHMeHEAfgAHdxkAAAAAABt3QAAPMDowOjA6MDowOjA6MDoxeH5yADdvcmcuYXBhY2hlLnNoaXJvLnNlc3Npb24ubWd0Lk9ubGluZVNlc3Npb24kT25saW5lU3RhdHVzAAAAAAAAAAASAAB4cgAOamF2YS5sYW5nLkVudW0AAAAAAAAAABIAAHhwdAAHb25fbGluZXQAFDA6MDowOjA6MDowOjA6MTo5MDgwdABuTW96aWxsYS81LjAgKFdpbmRvd3MgTlQgMTAuMDsgV09XNjQpIEFwcGxlV2ViS2l0LzUzNy4zNiAoS0hUTUwsIGxpa2UgR2Vja28pIENocm9tZS82My4wLjMyMzkuMTA4IFNhZmFyaS81MzcuMzZ3AgMAcQB+AA1xAH4ACng=');

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
