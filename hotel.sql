/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50545
Source Host           : localhost:3306
Source Database       : hotel

Target Server Type    : MYSQL
Target Server Version : 50545
File Encoding         : 65001

Date: 2015-09-09 12:34:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `name` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `roomNumber` int(11) DEFAULT NULL,
  `isHasRegister` tinyint(255) DEFAULT '0',
  `IDnumber` varchar(255) DEFAULT '',
  `StartDate` varchar(255) DEFAULT NULL,
  `EndDate` varchar(255) DEFAULT NULL,
  `Countdays` int(11) DEFAULT NULL COMMENT '居住天数',
  `pub` int(11) DEFAULT NULL,
  `bar` int(11) DEFAULT NULL,
  `taxi` int(11) DEFAULT NULL,
  `coffee` int(11) DEFAULT NULL,
  `sum` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('姓名', '102', '1', '身份证号码', null, null, null, null, null, null, null, null);
INSERT INTO `customer` VALUES ('胥哲', '101', '1', '身份证号码', null, null, null, '50', null, null, null, null);
INSERT INTO `customer` VALUES ('小王', '103', '0', '身份证号码', null, null, null, null, null, null, null, null);
INSERT INTO `customer` VALUES ('小男', '104', '0', '身份证号码', null, null, null, null, null, null, null, null);
INSERT INTO `customer` VALUES ('v你的空间深V', '105', '0', '身份证号码', null, null, null, null, null, null, null, null);
INSERT INTO `customer` VALUES ('v你的空间', '106', '0', '身份证号码', null, null, null, null, null, null, null, null);
INSERT INTO `customer` VALUES ('姓名', '107', '0', '身份证号码', null, null, null, null, null, null, null, null);
INSERT INTO `customer` VALUES ('我是第一个有日期的', '108', '0', '身份证号码', '2015-09-16', '2015-09-24', null, null, null, null, null, null);
INSERT INTO `customer` VALUES ('可以计算天数', '109', '1', '身份证号码', '2015-10-02', '2015-11-25', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for roominfor
-- ----------------------------
DROP TABLE IF EXISTS `roominfor`;
CREATE TABLE `roominfor` (
  `roomNumber` int(11) NOT NULL,
  `isBooked` int(4) NOT NULL DEFAULT '0',
  `master` varchar(255) DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roominfor
-- ----------------------------
INSERT INTO `roominfor` VALUES ('101', '0', '  ');
INSERT INTO `roominfor` VALUES ('102', '0', '');
INSERT INTO `roominfor` VALUES ('103', '0', '');
INSERT INTO `roominfor` VALUES ('104', '0', '');
INSERT INTO `roominfor` VALUES ('105', '1', 'v你的空间深V');
INSERT INTO `roominfor` VALUES ('106', '1', 'v你的空间');
INSERT INTO `roominfor` VALUES ('107', '0', '姓名');
INSERT INTO `roominfor` VALUES ('108', '1', '我是第一个有日期的');
INSERT INTO `roominfor` VALUES ('109', '0', '');
INSERT INTO `roominfor` VALUES ('110', '0', null);
INSERT INTO `roominfor` VALUES ('111', '0', null);
INSERT INTO `roominfor` VALUES ('112', '0', '');
INSERT INTO `roominfor` VALUES ('113', '0', '');
INSERT INTO `roominfor` VALUES ('114', '0', null);
INSERT INTO `roominfor` VALUES ('115', '0', null);
INSERT INTO `roominfor` VALUES ('116', '0', null);
INSERT INTO `roominfor` VALUES ('117', '0', null);
INSERT INTO `roominfor` VALUES ('118', '0', null);
INSERT INTO `roominfor` VALUES ('119', '0', null);
INSERT INTO `roominfor` VALUES ('120', '0', null);
INSERT INTO `roominfor` VALUES ('201', '0', null);
INSERT INTO `roominfor` VALUES ('202', '0', null);
INSERT INTO `roominfor` VALUES ('203', '1', '可以计算天数');
INSERT INTO `roominfor` VALUES ('204', '0', null);
INSERT INTO `roominfor` VALUES ('205', '0', null);
INSERT INTO `roominfor` VALUES ('206', '0', null);
INSERT INTO `roominfor` VALUES ('207', '0', null);
INSERT INTO `roominfor` VALUES ('208', '0', null);
INSERT INTO `roominfor` VALUES ('209', '0', null);
INSERT INTO `roominfor` VALUES ('210', '0', null);
INSERT INTO `roominfor` VALUES ('211', '0', null);
INSERT INTO `roominfor` VALUES ('212', '0', null);
INSERT INTO `roominfor` VALUES ('213', '0', null);
INSERT INTO `roominfor` VALUES ('214', '0', null);
INSERT INTO `roominfor` VALUES ('215', '0', null);
INSERT INTO `roominfor` VALUES ('216', '0', null);
INSERT INTO `roominfor` VALUES ('217', '0', null);
INSERT INTO `roominfor` VALUES ('218', '0', null);
INSERT INTO `roominfor` VALUES ('219', '0', null);
INSERT INTO `roominfor` VALUES ('220', '0', null);
INSERT INTO `roominfor` VALUES ('301', '0', null);
INSERT INTO `roominfor` VALUES ('302', '0', null);
INSERT INTO `roominfor` VALUES ('303', '1', '??');
INSERT INTO `roominfor` VALUES ('304', '0', null);
INSERT INTO `roominfor` VALUES ('305', '0', null);
INSERT INTO `roominfor` VALUES ('306', '0', null);
INSERT INTO `roominfor` VALUES ('307', '0', null);
INSERT INTO `roominfor` VALUES ('308', '0', null);
INSERT INTO `roominfor` VALUES ('309', '0', null);
INSERT INTO `roominfor` VALUES ('310', '0', null);
INSERT INTO `roominfor` VALUES ('311', '0', null);
INSERT INTO `roominfor` VALUES ('312', '0', null);
INSERT INTO `roominfor` VALUES ('313', '0', null);
INSERT INTO `roominfor` VALUES ('314', '0', null);
INSERT INTO `roominfor` VALUES ('315', '0', null);
INSERT INTO `roominfor` VALUES ('316', '0', null);
INSERT INTO `roominfor` VALUES ('317', '0', null);
INSERT INTO `roominfor` VALUES ('318', '0', null);
INSERT INTO `roominfor` VALUES ('319', '0', null);
INSERT INTO `roominfor` VALUES ('320', '0', null);
INSERT INTO `roominfor` VALUES ('401', '0', null);
INSERT INTO `roominfor` VALUES ('402', '0', null);
INSERT INTO `roominfor` VALUES ('403', '0', null);
INSERT INTO `roominfor` VALUES ('404', '1', '??');
INSERT INTO `roominfor` VALUES ('405', '0', null);
INSERT INTO `roominfor` VALUES ('406', '0', null);
INSERT INTO `roominfor` VALUES ('407', '0', null);
INSERT INTO `roominfor` VALUES ('408', '0', null);
INSERT INTO `roominfor` VALUES ('409', '0', null);
INSERT INTO `roominfor` VALUES ('410', '0', null);
INSERT INTO `roominfor` VALUES ('411', '0', null);
INSERT INTO `roominfor` VALUES ('412', '0', null);
INSERT INTO `roominfor` VALUES ('413', '0', null);
INSERT INTO `roominfor` VALUES ('414', '0', null);
INSERT INTO `roominfor` VALUES ('415', '0', null);
INSERT INTO `roominfor` VALUES ('416', '0', null);
INSERT INTO `roominfor` VALUES ('417', '0', null);
INSERT INTO `roominfor` VALUES ('418', '0', null);
INSERT INTO `roominfor` VALUES ('419', '0', null);
INSERT INTO `roominfor` VALUES ('420', '0', null);
INSERT INTO `roominfor` VALUES ('501', '0', null);
INSERT INTO `roominfor` VALUES ('502', '1', '??');
INSERT INTO `roominfor` VALUES ('503', '0', null);
INSERT INTO `roominfor` VALUES ('504', '0', null);
INSERT INTO `roominfor` VALUES ('505', '0', null);
INSERT INTO `roominfor` VALUES ('506', '0', null);
INSERT INTO `roominfor` VALUES ('507', '0', null);
INSERT INTO `roominfor` VALUES ('508', '0', null);
INSERT INTO `roominfor` VALUES ('509', '0', null);
INSERT INTO `roominfor` VALUES ('510', '0', null);
INSERT INTO `roominfor` VALUES ('511', '0', null);
INSERT INTO `roominfor` VALUES ('512', '0', null);
INSERT INTO `roominfor` VALUES ('513', '0', null);
INSERT INTO `roominfor` VALUES ('514', '0', null);
INSERT INTO `roominfor` VALUES ('515', '0', null);
INSERT INTO `roominfor` VALUES ('516', '0', null);
INSERT INTO `roominfor` VALUES ('517', '0', null);
INSERT INTO `roominfor` VALUES ('518', '0', null);
INSERT INTO `roominfor` VALUES ('519', '0', null);
INSERT INTO `roominfor` VALUES ('520', '0', null);
INSERT INTO `roominfor` VALUES ('601', '0', null);
INSERT INTO `roominfor` VALUES ('602', '0', null);
INSERT INTO `roominfor` VALUES ('603', '0', null);
INSERT INTO `roominfor` VALUES ('604', '0', null);
INSERT INTO `roominfor` VALUES ('605', '0', null);
INSERT INTO `roominfor` VALUES ('606', '0', null);
INSERT INTO `roominfor` VALUES ('607', '0', null);
INSERT INTO `roominfor` VALUES ('608', '0', null);
INSERT INTO `roominfor` VALUES ('609', '0', null);
INSERT INTO `roominfor` VALUES ('610', '0', null);
INSERT INTO `roominfor` VALUES ('611', '0', null);
INSERT INTO `roominfor` VALUES ('612', '0', null);
INSERT INTO `roominfor` VALUES ('613', '0', null);
INSERT INTO `roominfor` VALUES ('614', '0', null);
INSERT INTO `roominfor` VALUES ('615', '0', null);
INSERT INTO `roominfor` VALUES ('616', '0', null);
INSERT INTO `roominfor` VALUES ('617', '0', null);
INSERT INTO `roominfor` VALUES ('618', '0', null);
INSERT INTO `roominfor` VALUES ('619', '0', null);
INSERT INTO `roominfor` VALUES ('620', '0', null);
INSERT INTO `roominfor` VALUES ('701', '0', null);
INSERT INTO `roominfor` VALUES ('702', '1', '??');
INSERT INTO `roominfor` VALUES ('703', '0', null);
INSERT INTO `roominfor` VALUES ('704', '1', '??');
INSERT INTO `roominfor` VALUES ('705', '0', null);
INSERT INTO `roominfor` VALUES ('706', '0', null);
INSERT INTO `roominfor` VALUES ('707', '0', null);
INSERT INTO `roominfor` VALUES ('708', '0', null);
INSERT INTO `roominfor` VALUES ('709', '0', null);
INSERT INTO `roominfor` VALUES ('710', '0', null);
INSERT INTO `roominfor` VALUES ('711', '0', null);
INSERT INTO `roominfor` VALUES ('712', '0', null);
INSERT INTO `roominfor` VALUES ('713', '0', null);
INSERT INTO `roominfor` VALUES ('714', '0', null);
INSERT INTO `roominfor` VALUES ('715', '0', null);
INSERT INTO `roominfor` VALUES ('716', '0', null);
INSERT INTO `roominfor` VALUES ('717', '0', null);
INSERT INTO `roominfor` VALUES ('718', '0', null);
INSERT INTO `roominfor` VALUES ('719', '0', null);
INSERT INTO `roominfor` VALUES ('720', '1', '??');
INSERT INTO `roominfor` VALUES ('801', '1', '??');
INSERT INTO `roominfor` VALUES ('802', '0', null);
INSERT INTO `roominfor` VALUES ('803', '0', null);
INSERT INTO `roominfor` VALUES ('804', '0', null);
INSERT INTO `roominfor` VALUES ('805', '0', null);
INSERT INTO `roominfor` VALUES ('806', '0', null);
INSERT INTO `roominfor` VALUES ('807', '0', null);
INSERT INTO `roominfor` VALUES ('808', '0', null);
INSERT INTO `roominfor` VALUES ('809', '0', null);
INSERT INTO `roominfor` VALUES ('810', '0', null);
INSERT INTO `roominfor` VALUES ('811', '0', null);
INSERT INTO `roominfor` VALUES ('812', '0', null);
INSERT INTO `roominfor` VALUES ('813', '0', null);
INSERT INTO `roominfor` VALUES ('814', '0', null);
INSERT INTO `roominfor` VALUES ('815', '0', null);
INSERT INTO `roominfor` VALUES ('816', '0', null);
INSERT INTO `roominfor` VALUES ('817', '0', null);
INSERT INTO `roominfor` VALUES ('818', '0', null);
INSERT INTO `roominfor` VALUES ('819', '0', null);
INSERT INTO `roominfor` VALUES ('820', '0', null);
INSERT INTO `roominfor` VALUES ('901', '0', null);
INSERT INTO `roominfor` VALUES ('902', '0', null);
INSERT INTO `roominfor` VALUES ('903', '0', null);
INSERT INTO `roominfor` VALUES ('904', '0', null);
INSERT INTO `roominfor` VALUES ('905', '0', null);
INSERT INTO `roominfor` VALUES ('906', '0', null);
INSERT INTO `roominfor` VALUES ('907', '0', null);
INSERT INTO `roominfor` VALUES ('908', '0', null);
INSERT INTO `roominfor` VALUES ('909', '0', null);
INSERT INTO `roominfor` VALUES ('910', '0', null);
INSERT INTO `roominfor` VALUES ('911', '0', null);
INSERT INTO `roominfor` VALUES ('912', '0', null);
INSERT INTO `roominfor` VALUES ('913', '0', null);
INSERT INTO `roominfor` VALUES ('914', '0', null);
INSERT INTO `roominfor` VALUES ('915', '0', null);
INSERT INTO `roominfor` VALUES ('916', '0', null);
INSERT INTO `roominfor` VALUES ('917', '0', null);
INSERT INTO `roominfor` VALUES ('918', '0', null);
INSERT INTO `roominfor` VALUES ('919', '0', null);
INSERT INTO `roominfor` VALUES ('920', '0', null);
INSERT INTO `roominfor` VALUES ('1001', '0', null);
INSERT INTO `roominfor` VALUES ('1002', '0', null);
INSERT INTO `roominfor` VALUES ('1003', '0', null);
INSERT INTO `roominfor` VALUES ('1004', '0', null);
INSERT INTO `roominfor` VALUES ('1005', '0', null);
INSERT INTO `roominfor` VALUES ('1006', '0', null);
INSERT INTO `roominfor` VALUES ('1007', '0', null);
INSERT INTO `roominfor` VALUES ('1008', '0', null);
INSERT INTO `roominfor` VALUES ('1009', '0', null);
INSERT INTO `roominfor` VALUES ('1010', '0', null);
INSERT INTO `roominfor` VALUES ('1011', '0', null);
INSERT INTO `roominfor` VALUES ('1012', '0', null);
INSERT INTO `roominfor` VALUES ('1013', '0', null);
INSERT INTO `roominfor` VALUES ('1014', '0', null);
INSERT INTO `roominfor` VALUES ('1015', '0', null);
INSERT INTO `roominfor` VALUES ('1016', '0', null);
INSERT INTO `roominfor` VALUES ('1017', '0', null);
INSERT INTO `roominfor` VALUES ('1018', '0', null);
INSERT INTO `roominfor` VALUES ('1019', '0', null);
INSERT INTO `roominfor` VALUES ('1020', '0', null);
INSERT INTO `roominfor` VALUES ('1101', '0', null);
INSERT INTO `roominfor` VALUES ('1102', '0', null);
INSERT INTO `roominfor` VALUES ('1103', '0', null);
INSERT INTO `roominfor` VALUES ('1104', '0', null);
INSERT INTO `roominfor` VALUES ('1105', '0', null);
INSERT INTO `roominfor` VALUES ('1106', '0', null);
INSERT INTO `roominfor` VALUES ('1107', '0', null);
INSERT INTO `roominfor` VALUES ('1108', '0', null);
INSERT INTO `roominfor` VALUES ('1109', '0', null);
INSERT INTO `roominfor` VALUES ('1110', '0', null);
INSERT INTO `roominfor` VALUES ('1111', '0', null);
INSERT INTO `roominfor` VALUES ('1112', '0', null);
INSERT INTO `roominfor` VALUES ('1113', '0', null);
INSERT INTO `roominfor` VALUES ('1114', '0', null);
INSERT INTO `roominfor` VALUES ('1115', '0', null);
INSERT INTO `roominfor` VALUES ('1116', '0', null);
INSERT INTO `roominfor` VALUES ('1117', '0', null);
INSERT INTO `roominfor` VALUES ('1118', '0', null);
INSERT INTO `roominfor` VALUES ('1119', '0', null);
INSERT INTO `roominfor` VALUES ('1120', '0', null);
INSERT INTO `roominfor` VALUES ('1201', '0', null);
INSERT INTO `roominfor` VALUES ('1202', '0', null);
INSERT INTO `roominfor` VALUES ('1203', '0', null);
INSERT INTO `roominfor` VALUES ('1204', '1', '??');
INSERT INTO `roominfor` VALUES ('1205', '1', '姓名');
INSERT INTO `roominfor` VALUES ('1206', '0', null);
INSERT INTO `roominfor` VALUES ('1207', '0', null);
INSERT INTO `roominfor` VALUES ('1208', '0', null);
INSERT INTO `roominfor` VALUES ('1209', '0', null);
INSERT INTO `roominfor` VALUES ('1210', '0', null);
INSERT INTO `roominfor` VALUES ('1211', '0', null);
INSERT INTO `roominfor` VALUES ('1212', '0', null);
INSERT INTO `roominfor` VALUES ('1213', '0', null);
INSERT INTO `roominfor` VALUES ('1214', '0', null);
INSERT INTO `roominfor` VALUES ('1215', '0', null);
INSERT INTO `roominfor` VALUES ('1216', '0', null);
INSERT INTO `roominfor` VALUES ('1217', '0', null);
INSERT INTO `roominfor` VALUES ('1218', '0', null);
INSERT INTO `roominfor` VALUES ('1219', '0', null);
INSERT INTO `roominfor` VALUES ('1220', '0', null);
INSERT INTO `roominfor` VALUES ('1301', '1', '??');
INSERT INTO `roominfor` VALUES ('1302', '0', null);
INSERT INTO `roominfor` VALUES ('1303', '0', null);
INSERT INTO `roominfor` VALUES ('1304', '0', null);
INSERT INTO `roominfor` VALUES ('1305', '0', null);
INSERT INTO `roominfor` VALUES ('1306', '0', null);
INSERT INTO `roominfor` VALUES ('1307', '0', null);
INSERT INTO `roominfor` VALUES ('1308', '0', null);
INSERT INTO `roominfor` VALUES ('1309', '0', null);
INSERT INTO `roominfor` VALUES ('1310', '0', null);
INSERT INTO `roominfor` VALUES ('1311', '0', null);
INSERT INTO `roominfor` VALUES ('1312', '0', null);
INSERT INTO `roominfor` VALUES ('1313', '0', null);
INSERT INTO `roominfor` VALUES ('1314', '0', null);
INSERT INTO `roominfor` VALUES ('1315', '0', null);
INSERT INTO `roominfor` VALUES ('1316', '0', null);
INSERT INTO `roominfor` VALUES ('1317', '0', null);
INSERT INTO `roominfor` VALUES ('1318', '0', null);
INSERT INTO `roominfor` VALUES ('1319', '0', null);
INSERT INTO `roominfor` VALUES ('1320', '0', null);
