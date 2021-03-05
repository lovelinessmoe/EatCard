/*
 Navicat Premium Data Transfer

 Source Server         : MyMeow
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : EatCard

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 05/03/2021 20:11:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Card_detail
-- ----------------------------
DROP TABLE IF EXISTS `Card_detail`;
CREATE TABLE `Card_detail` (
  `D_id` int NOT NULL AUTO_INCREMENT,
  `C_id` int NOT NULL,
  `change_money` int NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`D_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Card_detail
-- ----------------------------
BEGIN;
INSERT INTO `Card_detail` VALUES (3, 1, 100, '2020-12-29');
INSERT INTO `Card_detail` VALUES (4, 2, 1000, '2020-12-29');
INSERT INTO `Card_detail` VALUES (5, 2, -1, '2020-12-29');
INSERT INTO `Card_detail` VALUES (6, 2, -10000, '2020-12-29');
INSERT INTO `Card_detail` VALUES (7, 2, -1, '2020-12-29');
INSERT INTO `Card_detail` VALUES (8, 2, -90, '2020-12-29');
INSERT INTO `Card_detail` VALUES (9, 2, -1000, '2020-12-29');
INSERT INTO `Card_detail` VALUES (10, 8, 999, '2020-12-29');
INSERT INTO `Card_detail` VALUES (11, 8, -1, '2020-12-29');
INSERT INTO `Card_detail` VALUES (12, 8, -1, '2020-12-29');
INSERT INTO `Card_detail` VALUES (13, 8, -1, '2020-12-29');
INSERT INTO `Card_detail` VALUES (14, 8, -3, '2020-12-29');
INSERT INTO `Card_detail` VALUES (15, 7, 2, '2020-12-29');
INSERT INTO `Card_detail` VALUES (16, 7, -2, '2020-12-29');
INSERT INTO `Card_detail` VALUES (17, 9, 1, '2020-12-30');
INSERT INTO `Card_detail` VALUES (18, 9, 100, '2020-12-30');
INSERT INTO `Card_detail` VALUES (19, 9, -10, '2020-12-30');
INSERT INTO `Card_detail` VALUES (20, 9, -191, '2020-12-30');
INSERT INTO `Card_detail` VALUES (21, 9, 10, '2020-12-30');
INSERT INTO `Card_detail` VALUES (22, 9, 100, '2020-12-30');
INSERT INTO `Card_detail` VALUES (23, 9, 10, '2020-12-30');
INSERT INTO `Card_detail` VALUES (24, 9, 10, '2020-12-30');
INSERT INTO `Card_detail` VALUES (25, 9, 10, '2020-12-30');
INSERT INTO `Card_detail` VALUES (26, 9, 1, '2020-12-30');
INSERT INTO `Card_detail` VALUES (27, 9, 111, '2020-12-30');
INSERT INTO `Card_detail` VALUES (28, 9, 10, '2020-12-30');
INSERT INTO `Card_detail` VALUES (29, 9, 110, '2020-12-30');
INSERT INTO `Card_detail` VALUES (30, 9, 210, '2020-12-30');
INSERT INTO `Card_detail` VALUES (31, 9, 230, '2020-12-30');
INSERT INTO `Card_detail` VALUES (32, 9, 5030, '2020-12-30');
INSERT INTO `Card_detail` VALUES (33, 9, 10, '2020-12-31');
INSERT INTO `Card_detail` VALUES (34, 9, -10, '2020-12-31');
INSERT INTO `Card_detail` VALUES (35, 10, 111, '2021-01-01');
INSERT INTO `Card_detail` VALUES (36, 10, -10, '2021-01-01');
INSERT INTO `Card_detail` VALUES (37, 9, -100, '2021-01-01');
COMMIT;

-- ----------------------------
-- Table structure for Card_info
-- ----------------------------
DROP TABLE IF EXISTS `Card_info`;
CREATE TABLE `Card_info` (
  `C_id` int NOT NULL AUTO_INCREMENT,
  `C_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `C_money` decimal(65,2) NOT NULL,
  `C_state` tinyint NOT NULL DEFAULT '1',
  `Admin` tinyint(1) NOT NULL DEFAULT '0',
  `Admin_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`C_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Card_info
-- ----------------------------
BEGIN;
INSERT INTO `Card_info` VALUES (1, 'Admin', 0.00, 1, 1, '123');
INSERT INTO `Card_info` VALUES (8, '小猪', 1104.00, 0, 0, '');
INSERT INTO `Card_info` VALUES (9, '狗子', 5742.10, 1, 0, '');
INSERT INTO `Card_info` VALUES (10, '小猫', 102.00, 1, 0, '');
INSERT INTO `Card_info` VALUES (11, '驴子', 10.00, 1, 0, '');
INSERT INTO `Card_info` VALUES (12, 'TestFinal', 0.00, 1, 0, '');
INSERT INTO `Card_info` VALUES (13, '消费大师', 1.00, 1, 0, '');
INSERT INTO `Card_info` VALUES (15, '000', 1.00, 1, 0, '');
INSERT INTO `Card_info` VALUES (16, '777', 10.00, 0, 0, '');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
