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

 Date: 27/10/2019 12:27:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `addressId` int(200) NOT NULL,
  `userId` int(200) NOT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `contact` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phoneNumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`addressId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (1, 1, '福州大学生活一区', '张三', '13386952503');
INSERT INTO `address` VALUES (2, 1, '福建师范大学旗山校区桂苑', '黄浩', '18654326666');
INSERT INTO `address` VALUES (3, 2, '福州大学西楼404', '李四', '18950767589');

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminId` int(200) NOT NULL,
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
  `commodityId` int(200) NOT NULL,
  `commodityName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `imagePath` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double(200, 2) NULL DEFAULT NULL,
  `commodityDesc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `updateDate` datetime(0) NULL DEFAULT NULL,
  `cstatue` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`commodityId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES (1, '香辣蛋包饭', '389a9fffefde4e9bb90f3d84bbd0de82.png', 11.00, '经典蛋包饭搭配香辣酱，爱吃辣小伙伴必选。 主要原料：大米,猪肉末', '2019-10-21 19:44:13', '2019-10-26 17:54:41', 1);
INSERT INTO `commodity` VALUES (2, '黑椒牛肉饭', 'hjnrf.png', 16.50, '澳洲进口精选肥牛，肥瘦适中，再配上日本特有酱汁，无人能够抵抗住它的诱惑！ 主要原料：紫甘蓝,苦菊,洋葱,番茄,香菇,米饭,牛肉', '2019-10-21 19:43:30', '2019-10-21 19:43:34', 1);
INSERT INTO `commodity` VALUES (3, '芝士培根蛋包饭', 'zspgdbf.png', 12.60, '芝士酱与培根的搭配，让宝宝肉肉一次吃个够主要原料：大米,培根', '2019-10-21 19:42:37', '2019-10-21 19:42:39', 1);
INSERT INTO `commodity` VALUES (4, '番茄肉酱意面', 'fqrjym.png', 13.50, '番茄肉酱是经典款，番茄微酸，肉馅多汁。 主要原料：香菇,意大利面,番茄', '2019-10-21 19:40:53', '2019-10-21 19:40:56', 1);
INSERT INTO `commodity` VALUES (5, '菠萝虾焗饭', 'blxjf.png', 15.80, '菠萝与虾仁完美结合，加上芝士覆盖焗烤，这应该是梦一场。 主要原料：苦菊,洋葱,大米,菠萝,香菇,米饭,菠萝,虾仁', '2019-10-21 19:40:22', '2019-10-21 19:40:27', 1);
INSERT INTO `commodity` VALUES (6, '芝士培根焗饭', 'zspgjf.png', 12.00, '培根芝士焗饭是一道由培根、芝士粉等食材制作的美食。 主要原料：大米,培根,芝士', '2019-10-26 14:31:34', '2019-10-26 14:31:37', 1);
INSERT INTO `commodity` VALUES (7, '南蛮鸡排饭', 'nmjpf.png', 13.00, '南蛮鸡排饭 主要原料：鸡排', '2019-10-26 14:48:33', '2019-10-26 14:48:37', 1);
INSERT INTO `commodity` VALUES (8, '照烧鸡咖喱饭', 'zsjglf.png', 14.00, '鲜嫩无骨鸡腿肉，煎至金黄色，配上咖喱，满足了你对白米饭的一切幻想。 主要原料：大米,鸡肉,咖喱', '2019-10-26 14:58:16', '2019-10-26 14:58:19', 1);
INSERT INTO `commodity` VALUES (9, '金枪鱼焗饭', 'jqyjf.png', 17.00, '金枪鱼与芝士的完美结合，味道鲜美，回味无穷！ 主要原料：米饭,金枪鱼,芝士\r\n\r\n金枪鱼与芝士的完美结合，味道鲜美，回味无穷！ 主要原料：米饭,金枪鱼,芝士\r\n\r\n金枪鱼与芝士的完美结合，味道鲜美，回味无穷！ 主要原料：米饭,金枪鱼,芝士\r\n\r\n金枪鱼与芝士的完美结合，味道鲜美，回味无穷！ 主要原料：米饭,金枪鱼,芝士', '2019-10-26 15:00:54', '2019-10-26 15:00:57', 1);
INSERT INTO `commodity` VALUES (10, '菌菇奶油蛋包饭', 'jgnydbf.png', 15.00, '奶香浓郁+滑嫩的鸡蛋+颗粒分明的米饭，没有很用力也能考出好成绩！ 主要原料：奶油,猪肉,金针菇,香菇,平菇,大米,奶油', '2019-10-26 15:03:38', '2019-10-26 15:03:42', 1);
INSERT INTO `commodity` VALUES (11, '海鲜奶油焗饭', 'hxnyjf.png', 15.50, '海鲜奶油焗饭是芝士与米饭的完美结合，再加上浓郁的奶油与海鲜的搭配，完美！ 主要原料：紫甘蓝,洋葱,鸡肉,章鱼,芝士', '2019-10-26 15:05:33', '2019-10-26 15:05:36', 1);
INSERT INTO `commodity` VALUES (12, '蟹柳蔬菜沙拉', 'xlscsl.png', 10.00, '翠绿清爽有机生菜，搭配蟹柳、香甜可口的玉米，口感丰富清新诱人！ 主要原料：紫甘蓝,甘蓝,蟹柳', '2019-10-26 15:08:11', '2019-10-26 15:08:14', 1);
INSERT INTO `commodity` VALUES (13, '虾仁培根沙拉', 'xrpgsl.png', 12.00, 'Q弹的虾仁碰撞培根，海鲜蔬果统统碗里来。 主要原料：生菜,紫甘蓝,苦菊,培根,虾仁,风味沙拉酱', '2019-10-26 15:10:25', '2019-10-26 15:10:28', 1);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `orderId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `addressId` int(11) NULL DEFAULT NULL,
  `userId` int(200) NULL DEFAULT NULL,
  `statue` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sum` double(200, 2) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `updateDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`orderId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', 1, 1, '已取消', 32.30, '2019-10-21 19:54:13', '2019-10-21 19:54:15');
INSERT INTO `order` VALUES ('2', 1, 1, '配送中', 22.00, '2019-10-21 19:53:50', '2019-10-21 19:53:53');
INSERT INTO `order` VALUES ('3', 1, 1, '已完成', 50.40, '2019-10-21 19:53:24', '2019-10-21 19:53:27');

-- ----------------------------
-- Table structure for order_commodity
-- ----------------------------
DROP TABLE IF EXISTS `order_commodity`;
CREATE TABLE `order_commodity`  (
  `ordercomId` int(200) NOT NULL,
  `orderId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `commodityId` int(200) NULL DEFAULT NULL,
  `count` int(10) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `updateDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`ordercomId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_commodity
-- ----------------------------
INSERT INTO `order_commodity` VALUES (1, '1', 2, 1, '2019-10-21 19:54:13', '2019-10-21 19:54:13');
INSERT INTO `order_commodity` VALUES (2, '1', 5, 1, '2019-10-21 19:53:50', '2019-10-21 19:53:50');
INSERT INTO `order_commodity` VALUES (3, '2', 1, 2, '2019-10-21 20:15:20', '2019-10-21 20:15:23');
INSERT INTO `order_commodity` VALUES (4, '3', 3, 4, '2019-10-21 19:53:24', '2019-10-21 19:53:24');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` int(200) NOT NULL,
  `phoneNumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `passWord` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` float(200, 2) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `updateDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '13386952503', 'a123', '张三', 500.00, '2019-10-21 19:16:26', '2019-10-21 19:16:29');
INSERT INTO `user` VALUES (2, '18950767589', 'a123', '李四', 300.00, '2019-10-21 19:15:25', '2019-10-21 19:15:25');
INSERT INTO `user` VALUES (3, '18050961234', 'a123', '王五', 200.00, '2019-10-21 20:08:57', '2019-10-21 20:08:57');

SET FOREIGN_KEY_CHECKS = 1;
