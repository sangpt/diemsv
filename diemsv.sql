/*
Navicat MySQL Data Transfer

Source Server         : lib
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : diemsv

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2016-04-19 21:03:29
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `diem`
-- ----------------------------
DROP TABLE IF EXISTS `diem`;
CREATE TABLE `diem` (
  `MaLop` varchar(10) NOT NULL,
  `MaSV` varchar(10) NOT NULL,
  `DiemQT` float DEFAULT NULL,
  `DiemCK` float DEFAULT NULL,
  `DiemSo` float DEFAULT NULL,
  `DiemChu` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`MaLop`,`MaSV`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of diem
-- ----------------------------
INSERT INTO `diem` VALUES ('LH01', 'SV01', '9', '7', '7.6', 'B');
INSERT INTO `diem` VALUES ('LH01', 'SV03', '3', '8', '6.5', 'C+');
INSERT INTO `diem` VALUES ('LH02', 'SV01', '8', '8', '8', 'B+');
INSERT INTO `diem` VALUES ('LH02', 'SV04', '5', '6', '5.7', 'C');
INSERT INTO `diem` VALUES ('LH02', 'SV05', '6', '8', '7.4', 'B');
INSERT INTO `diem` VALUES ('LH03', 'SV01', '9', '9', '9', 'A');
INSERT INTO `diem` VALUES ('LH03', 'SV02', '3', '3', '3', 'F');

-- ----------------------------
-- Table structure for `gv`
-- ----------------------------
DROP TABLE IF EXISTS `gv`;
CREATE TABLE `gv` (
  `MaGV` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `HoTen` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Vien` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NgaySinh` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GioiTinh` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DiaChi` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaGV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of gv
-- ----------------------------
INSERT INTO `gv` VALUES ('GV01', 'Vu Khac Ngoc', 'Hoa', '01/05/1974', 'Nam', 'Ha Noi');
INSERT INTO `gv` VALUES ('GV02', 'Le Thanh Nam', 'Toan Tin', '13/02/1970', 'Nam', 'Hung Yen');
INSERT INTO `gv` VALUES ('GV03', 'Pham Bich Ngoc', 'CNTT', '16/06/1976', 'Nu', 'Ha Noi');
INSERT INTO `gv` VALUES ('GV04', 'Pham Mai Phuong', 'Ngoai Ngu', '22/12/1969', 'Nu', 'Ha Noi');

-- ----------------------------
-- Table structure for `hp`
-- ----------------------------
DROP TABLE IF EXISTS `hp`;
CREATE TABLE `hp` (
  `MaHP` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenHP` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SoTinChi` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HeSo` float DEFAULT NULL,
  PRIMARY KEY (`MaHP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of hp
-- ----------------------------
INSERT INTO `hp` VALUES ('CH01', 'Hoa dai cuong', '3', '0.3');
INSERT INTO `hp` VALUES ('FL01', 'TOEIC 1', '2', '0.5');
INSERT INTO `hp` VALUES ('IT02', 'He dieu hanh', '3', '0.3');
INSERT INTO `hp` VALUES ('MI01', 'Dai so', '4', '0.3');

-- ----------------------------
-- Table structure for `login`
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `permission` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('*temp*', 'sang', 'sang', null);
INSERT INTO `login` VALUES ('1', '1', 'Cao Thai Son', '0');
INSERT INTO `login` VALUES ('sang', 'sang', 'Pham Tuan Sang', '1');
INSERT INTO `login` VALUES ('son', 'son', 'Luong Cong Son', '1');

-- ----------------------------
-- Table structure for `lop`
-- ----------------------------
DROP TABLE IF EXISTS `lop`;
CREATE TABLE `lop` (
  `MaLop` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaHP` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MaGV` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MaKyHoc` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaLop`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of lop
-- ----------------------------
INSERT INTO `lop` VALUES ('LH01', 'IT02', 'GV03', '20152');
INSERT INTO `lop` VALUES ('LH02', 'CH01', 'GV01', '20152');
INSERT INTO `lop` VALUES ('LH03', 'MI01', 'GV02', '20152');
INSERT INTO `lop` VALUES ('LH04', 'FL01', 'GV04', '20152');

-- ----------------------------
-- Table structure for `sv`
-- ----------------------------
DROP TABLE IF EXISTS `sv`;
CREATE TABLE `sv` (
  `MaSV` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `HoTen` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LopSV` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NgaySinh` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GioiTinh` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DiaChi` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaSV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sv
-- ----------------------------
INSERT INTO `sv` VALUES ('SV01', 'Phạm Tuấn Sang', 'CN2', '26/08/1996', 'Nam', 'Hà Nội');
INSERT INTO `sv` VALUES ('SV02', 'Lương Công Sơn', 'CN2', '23/03/1996', 'Nam', 'Hà Nội');
INSERT INTO `sv` VALUES ('SV03', 'Trần Đăng Huy', 'QT1', '10/10/1995', 'Nam', 'Bắc Giang');
INSERT INTO `sv` VALUES ('SV04', 'Phạm Bình Minh', 'CN1', '01/03/1996', 'Nam', 'Hải Phòng');
INSERT INTO `sv` VALUES ('SV05', 'Nguyễn Hoài Phương', 'KS2', '12/11/1996', 'Nu', 'Lạng Sơn');
INSERT INTO `sv` VALUES ('SV06', 'Nguyễn Quỳnh Như', 'KS1', '13/12/1996', 'Nam', 'Hưng Yên');
INSERT INTO `sv` VALUES ('SV07', 'Trịnh Thu Hoài', 'QT2', '30/05/1996', 'Nu', 'Hà Nội');
