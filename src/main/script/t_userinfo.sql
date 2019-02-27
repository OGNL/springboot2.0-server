/*
Navicat MySQL Data Transfer

Source Server         : localhost-mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : testdb

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-02-27 23:58:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_userinfo`;
CREATE TABLE `t_userinfo` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_userinfo
-- ----------------------------
INSERT INTO `t_userinfo` VALUES ('1', 'zzz', '13921351476', '123456', '上海浦东');
INSERT INTO `t_userinfo` VALUES ('2', 'qqq', '17625011065', '123456', '江苏南京');
INSERT INTO `t_userinfo` VALUES ('3', 'www', '17625011066', '123456', '安徽合肥');
INSERT INTO `t_userinfo` VALUES ('4', 'eee', '17625011067', '123456', '湖北武汉');
INSERT INTO `t_userinfo` VALUES ('5', 'yyy', '17625011069', '123456', '河南郑州');
