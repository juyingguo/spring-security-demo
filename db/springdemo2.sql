/*
Navicat MySQL Data Transfer

Source Server         : mysql_local_3307
Source Server Version : 50737
Source Host           : localhost:3307
Source Database       : springdemo2

Target Server Type    : MYSQL
Target Server Version : 50737
File Encoding         : 65001

Date: 2022-12-15 10:34:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `enable` tinyint(2) unsigned NOT NULL DEFAULT '1' COMMENT '用户是否可用',
  `roles` text COMMENT '用户角色，多个角色之间用逗号隔开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', '123', '1', 'ROLE_ADMIN,ROLE_USER');
INSERT INTO `users` VALUES ('2', 'user', '123', '1', 'ROLE_USER');
