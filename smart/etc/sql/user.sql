/*
Navicat MySQL Data Transfer

Source Server         : aliyunMySql
Source Server Version : 50715
Source Host           : tianyuan.mysql.rds.aliyuncs.com:3306
Source Database       : tianyuan

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-01-07 10:48:25
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `last_login_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `disable` int(1) DEFAULT '0',
  `lock` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '', 'tianyuan', '', '123456', '0', '2017-12-29 09:46:24', '2017-12-29 09:46:24', '0', '0');


/*
Navicat MySQL Data Transfer

Source Server         : aliyunMySql
Source Server Version : 50715
Source Host           : tianyuan.mysql.rds.aliyuncs.com:3306
Source Database       : tianyuan

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-01-07 10:48:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '2');


/*
Navicat MySQL Data Transfer

Source Server         : aliyunMySql
Source Server Version : 50715
Source Host           : tianyuan.mysql.rds.aliyuncs.com:3306
Source Database       : tianyuan

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-01-07 10:48:05
*/

SET FOREIGN_KEY_CHECKS=0;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', null, '0');
INSERT INTO `role` VALUES ('2', 'user', null, '0');


/*
Navicat MySQL Data Transfer

Source Server         : aliyunMySql
Source Server Version : 50715
Source Host           : tianyuan.mysql.rds.aliyuncs.com:3306
Source Database       : tianyuan

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-01-07 10:48:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `url_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '1');
INSERT INTO `role_permission` VALUES ('2', '1', '2');
INSERT INTO `role_permission` VALUES ('3', '1', '3');
INSERT INTO `role_permission` VALUES ('4', '1', '4');
INSERT INTO `role_permission` VALUES ('5', '2', '1');


/*
Navicat MySQL Data Transfer

Source Server         : aliyunMySql
Source Server Version : 50715
Source Host           : tianyuan.mysql.rds.aliyuncs.com:3306
Source Database       : tianyuan

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-01-07 10:47:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` tinyint(10) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 NOT NULL,
  `description` varchar(50) DEFAULT '0',
  `disabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', null, null, 'user:*', '登录页面', '0');
INSERT INTO `permission` VALUES ('2', null, null, 'product.create', null, '0');
INSERT INTO `permission` VALUES ('3', null, null, 'product.edit', null, '0');
INSERT INTO `permission` VALUES ('4', null, null, 'product.delete', null, '0');
