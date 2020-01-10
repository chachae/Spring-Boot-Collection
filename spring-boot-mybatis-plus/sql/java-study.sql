/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : jwt

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 08/01/2020 08:48:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES (1, '技术部', '技术支持');
INSERT INTO `t_department` VALUES (2, '策划部', '活动策划与组织');
INSERT INTO `t_department` VALUES (3, '售后部门', '产品售后与维护');
INSERT INTO `t_department` VALUES (4, '监督组', '纪律监督');
INSERT INTO `t_department` VALUES (5, '营销部', '产品营销');

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `expression` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES (1, '用户列表', 'user:list');
INSERT INTO `t_permission` VALUES (2, '新增用户', 'user:save');
INSERT INTO `t_permission` VALUES (3, '更新用户', 'user:update');
INSERT INTO `t_permission` VALUES (4, '删除用户', 'user:delete');
INSERT INTO `t_permission` VALUES (5, '角色列表', 'role:list');
INSERT INTO `t_permission` VALUES (6, '新增角色', 'role:save');
INSERT INTO `t_permission` VALUES (7, '删除角色', 'role:delete');
INSERT INTO `t_permission` VALUES (8, '更新角色', 'role:update');
INSERT INTO `t_permission` VALUES (9, '权限列表', 'permission:list');
INSERT INTO `t_permission` VALUES (10, '新增权限', 'permission:save');
INSERT INTO `t_permission` VALUES (11, '删除权限', 'permission:delete');
INSERT INTO `t_permission` VALUES (12, '更新权限', 'permission:update');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '管理员', 'OWNER');
INSERT INTO `t_role` VALUES (2, '运维', 'SERVER MANAGER');
INSERT INTO `t_role` VALUES (3, '信息分析员', 'DATA MANAGER');
INSERT INTO `t_role` VALUES (4, '数据库管理员', 'DBA');
INSERT INTO `t_role` VALUES (5, '后端', 'BACKGROUND');
INSERT INTO `t_role` VALUES (6, '售后人员', 'POST SALE');
INSERT INTO `t_role` VALUES (9, 'saveTest', 'SAVE TEST');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission`  (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES (3, 1);
INSERT INTO `t_role_permission` VALUES (3, 2);
INSERT INTO `t_role_permission` VALUES (3, 3);
INSERT INTO `t_role_permission` VALUES (3, 4);
INSERT INTO `t_role_permission` VALUES (2, 5);
INSERT INTO `t_role_permission` VALUES (2, 6);
INSERT INTO `t_role_permission` VALUES (2, 7);
INSERT INTO `t_role_permission` VALUES (2, 8);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `admin` int(1) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'psy', '1', 1, 1);
INSERT INTO `t_user` VALUES (3, 'rick', '1', 0, 1);
INSERT INTO `t_user` VALUES (4, 'jpa', '000000', 0, 0);

-- ----------------------------
-- Table structure for t_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info`  (
  `id` int(11) NOT NULL COMMENT 'id',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱地址',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `gender` int(1) NULL DEFAULT NULL COMMENT '性别',
  `department_id` int(10) NULL DEFAULT NULL COMMENT '部门id',
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  `qq_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'QQ号',
  `wechat_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信id',
  `site` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个人主页',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个人介绍',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '登陆时间',
  `login_ip` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录IP',
  `full_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_info
-- ----------------------------
INSERT INTO `t_user_info` VALUES (1, 'real@qq.com', '13600000000', 1, 1, 'https://www.avatar.com/54y3498tj98.png', '36058188', 'real1998', 'https://www.nsd.top', 'Hello World !', '2019-12-18 11:39:17', '2019-12-24 14:00:00', '2020-01-01 12:27:38', '127.0.0.1', '张三');
INSERT INTO `t_user_info` VALUES (3, 'rick@ndda.org', '15113022888', 1, 5, 'https://www.avatar.com/54y3498tj98.png', '65581338', '0', 'https://www.baidu.com', 'No.', '2019-12-21 10:30:18', '2019-12-21 13:56:18', '2020-01-01 12:54:28', '127.0.0.1', '李四');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (1, 3);
INSERT INTO `t_user_role` VALUES (1, 4);
INSERT INTO `t_user_role` VALUES (1, 5);
INSERT INTO `t_user_role` VALUES (3, 1);
INSERT INTO `t_user_role` VALUES (3, 2);
INSERT INTO `t_user_role` VALUES (3, 3);

SET FOREIGN_KEY_CHECKS = 1;
