/*
Navicat MySQL Data Transfer

Source Server         : aliyunMySql
Source Server Version : 50715
Source Host           : tianyuan.mysql.rds.aliyuncs.com:3306
Source Database       : tianyuan

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-01-07 15:33:33
*/

SET FOREIGN_KEY_CHECKS=0;

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
