/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : mybatisdemo

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2017-07-29 08:21:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for learn_resource
-- ----------------------------
DROP TABLE IF EXISTS `learn_resource`;
CREATE TABLE `learn_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `author` varchar(20) DEFAULT NULL COMMENT '作者',
  `title` varchar(100) DEFAULT NULL COMMENT '描述',
  `url` varchar(100) DEFAULT NULL COMMENT '地址链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1169 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of learn_resource
-- ----------------------------
INSERT INTO `learn_resource` VALUES ('1033', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1034', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1035', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1036', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1037', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1038', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1039', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1040', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1041', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1042', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1043', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1044', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1045', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1046', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1047', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1048', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1049', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1050', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1051', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1052', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1053', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1054', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1055', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1056', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1057', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1058', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1059', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1060', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1061', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1062', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1063', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1064', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1065', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1066', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1067', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1068', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1069', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1070', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1071', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1072', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1073', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1074', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1075', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1076', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1077', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1078', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1079', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1080', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1081', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1082', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1083', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1084', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1085', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1086', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1087', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1088', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1089', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1090', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1091', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1092', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1093', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1094', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1095', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1096', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1097', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1098', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1099', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1100', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1101', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1102', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1103', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1104', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1105', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1106', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1107', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1108', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1109', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1110', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1111', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1112', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1113', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1114', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1115', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1116', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1117', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1118', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1119', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1120', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1121', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1122', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1123', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1124', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1125', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1126', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1127', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1128', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1129', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1130', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1131', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1132', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1133', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1134', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1135', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1136', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1137', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1138', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1139', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1140', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1141', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1142', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1143', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1144', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1145', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1146', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1147', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1148', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1149', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1150', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1151', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1152', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1153', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1154', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1155', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1156', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1157', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1158', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1159', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1160', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1161', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1162', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1163', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1164', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');
INSERT INTO `learn_resource` VALUES ('1165', '官方SpriongBoot例子', '官方SpriongBoot例子', 'https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
INSERT INTO `learn_resource` VALUES ('1166', '龙果学院', 'Spring Boot 教程系列学习', 'http://www.roncoo.com/article/detail/124661');
INSERT INTO `learn_resource` VALUES ('1167', '嘟嘟MD独立博客', 'Spring Boot干货系列', 'http://tengj.top/');
INSERT INTO `learn_resource` VALUES ('1168', '后端编程嘟', 'Spring Boot视频教程', 'http://www.toutiao.com/m1559096720023553/');

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('1', 'wr', 'ewr');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `available` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `parent_ids` varchar(50) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '0', '主页', '0', '0/', '/learn/index', 'learn', '/learn/index');
INSERT INTO `sys_permission` VALUES ('2', '0', '主页ifream', '1', '0/1', '/learn/main', 'learn', '/learn/maine');
INSERT INTO `sys_permission` VALUES ('3', '0', '教程列表', '1', '0/1', '/learn/resource', 'learn', '/learn/resource');
INSERT INTO `sys_permission` VALUES ('4', '0', '教程列表ajax', '1', '0', '/learn/queryLearnList', 'learn', '/learn/queryLearnList');
INSERT INTO `sys_permission` VALUES ('5', '0', '用户管理首页', '1', '0', '/user/index', 'user', '/user/index');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `available` varchar(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '0', '管理员', 'admin');
INSERT INTO `sys_role` VALUES ('2', '0', 'VIP会员', 'vip');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `permission_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '2');
INSERT INTO `sys_role_permission` VALUES ('2', '1');
INSERT INTO `sys_role_permission` VALUES ('3', '1');
INSERT INTO `sys_role_permission` VALUES ('4', '1');
INSERT INTO `sys_role_permission` VALUES ('5', '1');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `role_id` varchar(200) DEFAULT NULL,
  `uid` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('1', '5');
INSERT INTO `sys_user_role` VALUES ('1', '6');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `userName` varchar(32) DEFAULT NULL COMMENT '用户名',
  `passWord` varchar(32) DEFAULT NULL COMMENT '密码',
  `user_sex` varchar(32) DEFAULT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `uid` int(50) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'admin', '管理员', '3ef7164d1f6167cb9f2658c07d3c2f0a', '8d78869f470951332959580424d4bf4f', '0');
INSERT INTO `user_info` VALUES ('5', 'xuzhiyong', '许志勇', '34eb870f9b499c03ec924659f0f15131', 'eHV6aGl5b25n', '1');
INSERT INTO `user_info` VALUES ('6', 'liuyingying', '柳阴阴', 'afaf550e603754b4f0087504f7fdf1c6', 'bGl1eWluZ3lpbmc=', '1');

-- ----------------------------
-- Table structure for 测试
-- ----------------------------
DROP TABLE IF EXISTS `测试`;
CREATE TABLE `测试` (
  `编号` int(10) NOT NULL,
  `名称` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`编号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of 测试
-- ----------------------------
INSERT INTO `测试` VALUES ('1', '哈哈哈');
