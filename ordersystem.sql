/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : ordersystem

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 24/10/2019 09:59:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `addressId` int(200) NOT NULL AUTO_INCREMENT,
  `userId` int(200) NULL DEFAULT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contact` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phoneNumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`addressId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (1, 1, '福州大学生活一区', '张三', '13386952503');
INSERT INTO `address` VALUES (2, 1, '福建师范大学旗山校区桂苑', '黄浩', '18654326666');
INSERT INTO `address` VALUES (3, 2, '中国', '李四', '13354268371');
INSERT INTO `address` VALUES (4, 2, '中国', '李四', '13354268371');

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminId` int(200) NOT NULL AUTO_INCREMENT,
  `phoneNumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `passWord` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `updateDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`adminId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '18120732222', 'a123456', '大明', '2019-10-21 19:33:18', '2019-10-21 19:33:21');
INSERT INTO `admin` VALUES (2, '13350796566', 'ea48576f30be1669971699c09ad05c94', '小明', '2019-10-21 19:32:09', '2019-10-21 19:32:12');

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity`  (
  `commodityId` int(200) NOT NULL AUTO_INCREMENT,
  `commodityName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `imagePath` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double(200, 2) NULL DEFAULT NULL,
  `commodityDesc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `updateDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`commodityId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES (1, '香辣蛋包饭', NULL, 11.00, NULL, '2019-10-21 19:44:13', '2019-10-21 19:44:17');
INSERT INTO `commodity` VALUES (2, '黑椒牛肉饭', NULL, 16.50, NULL, '2019-10-21 19:43:30', '2019-10-21 19:43:34');
INSERT INTO `commodity` VALUES (3, '芝士培根蛋包饭', NULL, 12.60, NULL, '2019-10-21 19:42:37', '2019-10-21 19:42:39');
INSERT INTO `commodity` VALUES (4, '番茄肉酱意面', NULL, 13.50, NULL, '2019-10-21 19:40:53', '2019-10-21 19:40:56');
INSERT INTO `commodity` VALUES (5, '菠萝虾焗饭', NULL, 15.80, NULL, '2019-10-21 19:40:22', '2019-10-21 19:40:27');
INSERT INTO `commodity` VALUES (9, 'ceshi', NULL, 22.00, 'haochi', NULL, NULL);
INSERT INTO `commodity` VALUES (10, 'ceshi1', NULL, 22.00, 'haochi', NULL, NULL);
INSERT INTO `commodity` VALUES (11, 'ceshi11', NULL, 22.00, 'haochi', NULL, NULL);
INSERT INTO `commodity` VALUES (12, NULL, NULL, NULL, NULL, '2019-10-23 23:53:12', '2019-10-23 23:53:12');
INSERT INTO `commodity` VALUES (13, 'ceshi2', NULL, 22.00, 'ceshi2', '2019-10-23 23:54:30', '2019-10-23 23:54:30');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `orderId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `addressId` int(200) NULL DEFAULT NULL,
  `userId` int(200) NULL DEFAULT NULL,
  `statue` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sum` float(200, 2) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `updateDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`orderId`) USING BTREE,
  INDEX `userId_order`(`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', NULL, 1, '已取消', 32.30, '2019-10-21 19:54:13', '2019-10-21 19:54:15');
INSERT INTO `order` VALUES ('1571850014', 1, 1, '已下单', 301.00, '2019-10-24 01:00:14', '2019-10-24 01:00:14');
INSERT INTO `order` VALUES ('1571850121000977', 1, 1, '已下单', 301.00, '2019-10-24 01:02:01', '2019-10-24 01:02:01');
INSERT INTO `order` VALUES ('2', NULL, 1, '配送中', 22.00, '2019-10-21 19:53:50', '2019-10-21 19:53:53');
INSERT INTO `order` VALUES ('201910240115710345', 1, 1, '已取消', 301.00, '2019-10-24 01:15:10', '2019-10-24 01:19:29');
INSERT INTO `order` VALUES ('3', NULL, 1, '已完成', 50.40, '2019-10-21 19:53:24', '2019-10-21 19:53:27');

-- ----------------------------
-- Table structure for order_commodity
-- ----------------------------
DROP TABLE IF EXISTS `order_commodity`;
CREATE TABLE `order_commodity`  (
  `ordercomId` int(200) NOT NULL AUTO_INCREMENT,
  `orderId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `commodityId` int(200) NULL DEFAULT NULL,
  `count` int(10) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `updateDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`ordercomId`) USING BTREE,
  INDEX `orderId`(`orderId`) USING BTREE,
  INDEX `commodityId`(`commodityId`) USING BTREE,
  CONSTRAINT `commodityId` FOREIGN KEY (`commodityId`) REFERENCES `commodity` (`commodityId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_commodity
-- ----------------------------
INSERT INTO `order_commodity` VALUES (1, '1', 2, 1, '2019-10-21 19:54:13', '2019-10-21 19:54:13');
INSERT INTO `order_commodity` VALUES (2, '1', 5, 1, '2019-10-21 19:53:50', '2019-10-21 19:53:50');
INSERT INTO `order_commodity` VALUES (3, '2', 1, 2, '2019-10-21 20:15:20', '2019-10-21 20:15:23');
INSERT INTO `order_commodity` VALUES (4, '3', 3, 4, '2019-10-21 19:53:24', '2019-10-21 19:53:24');
INSERT INTO `order_commodity` VALUES (5, '1571850121000977', 1, 1, '2019-10-24 01:02:02', '2019-10-24 01:02:02');
INSERT INTO `order_commodity` VALUES (6, '1571850121000977', 2, 1, '2019-10-24 01:02:02', '2019-10-24 01:02:02');
INSERT INTO `order_commodity` VALUES (7, '1571850121000977', 3, 1, '2019-10-24 01:02:02', '2019-10-24 01:02:02');
INSERT INTO `order_commodity` VALUES (8, '201910240115710345', 1, 1, '2019-10-24 01:15:10', '2019-10-24 01:15:10');
INSERT INTO `order_commodity` VALUES (9, '201910240115710345', 2, 1, '2019-10-24 01:15:10', '2019-10-24 01:15:10');
INSERT INTO `order_commodity` VALUES (10, '201910240115710345', 3, 1, '2019-10-24 01:15:10', '2019-10-24 01:15:10');
INSERT INTO `order_commodity` VALUES (11, '201910240115710345', 1, 1, '2019-10-24 01:16:40', '2019-10-24 01:16:40');
INSERT INTO `order_commodity` VALUES (12, '201910240115710345', 2, 2, '2019-10-24 01:16:40', '2019-10-24 01:16:40');
INSERT INTO `order_commodity` VALUES (13, '201910240115710345', 3, 3, '2019-10-24 01:16:40', '2019-10-24 01:16:40');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` int(200) NOT NULL AUTO_INCREMENT,
  `phoneNumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `passWord` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` double(200, 2) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `updateDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '13386952503', '4297f44b13955235245b2497399d7a93', '张三', 8495.00, '2019-10-21 19:16:26', '2019-10-24 01:19:29');
INSERT INTO `user` VALUES (2, '18950767589', 'a123', '李四', 300.00, '2019-10-21 19:15:25', '2019-10-21 19:15:25');
INSERT INTO `user` VALUES (3, '18050961234', 'a123', '王五', 200.00, '2019-10-21 20:08:57', '2019-10-21 20:08:57');
INSERT INTO `user` VALUES (9, '11123221131', '4297f44b13955235245b2497399d7a93', '小红', NULL, '2019-10-22 02:09:17', '2019-10-22 02:09:17');
INSERT INTO `user` VALUES (10, '1123221131', '4297f44b13955235245b2497399d7a93', '小红', NULL, '2019-10-22 02:16:27', '2019-10-22 02:16:27');
INSERT INTO `user` VALUES (11, '112322111', '4297f44b13955235245b2497399d7a93', '小红', NULL, '2019-10-22 10:28:47', '2019-10-22 10:28:47');
INSERT INTO `user` VALUES (12, '11232211', '4297f44b13955235245b2497399d7a93', '小红', NULL, '2019-10-22 10:29:13', '2019-10-22 10:29:13');
INSERT INTO `user` VALUES (14, '123213', '4297f44b13955235245b2497399d7a93', NULL, NULL, '2019-10-23 22:46:43', '2019-10-23 22:46:43');

SET FOREIGN_KEY_CHECKS = 1;
