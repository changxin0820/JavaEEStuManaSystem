/*
Navicat MySQL Data Transfer

Source Server         : ssm
Source Server Version : 80018
Source Host           : zhangjingmin.mysql.rds.aliyuncs.com:3306
Source Database       : stumanasyst

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-12-24 23:00:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `academy`
-- ----------------------------
DROP TABLE IF EXISTS `academy`;
CREATE TABLE `academy` (
  `id` int(11) NOT NULL COMMENT '学院id',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学院名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of academy
-- ----------------------------
INSERT INTO `academy` VALUES ('10', '计算机学院');
INSERT INTO `academy` VALUES ('11', '测绘学院');
INSERT INTO `academy` VALUES ('14', '历史学院');

-- ----------------------------
-- Table structure for `academy_major`
-- ----------------------------
DROP TABLE IF EXISTS `academy_major`;
CREATE TABLE `academy_major` (
  `academyId` int(11) NOT NULL COMMENT '学院id',
  `majorId` int(11) NOT NULL COMMENT '专业id',
  PRIMARY KEY (`academyId`,`majorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of academy_major
-- ----------------------------
INSERT INTO `academy_major` VALUES ('10', '10');
INSERT INTO `academy_major` VALUES ('10', '11');
INSERT INTO `academy_major` VALUES ('14', '12');

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `money` double DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'qw', '100');
INSERT INTO `account` VALUES ('2', '熊大', '400');
INSERT INTO `account` VALUES ('3', 'er', '200');
INSERT INTO `account` VALUES ('4', 'ert', '300');
INSERT INTO `account` VALUES ('5', '12', '122');

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员账号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `sex` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `phoneNum` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话号码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '课程名称',
  `credit` double(3,2) DEFAULT NULL COMMENT '学分',
  `period` int(11) DEFAULT NULL COMMENT '课时',
  `status` tinyint(4) DEFAULT NULL COMMENT '课程性质1代表必修，0代表选修',
  `time` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上课时间',
  `place` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上课地点',
  `teacherId` int(11) DEFAULT NULL COMMENT '教师id',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `tid` (`teacherId`) USING BTREE,
  CONSTRAINT `tid` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '计组', '3.00', '64', '1', '周五上午', '青楼302', '1');
INSERT INTO `course` VALUES ('4', '地点', '1.00', '48', '0', '周二 08:05-08:10', '地点方', '1');
INSERT INTO `course` VALUES ('10', '大得多', '3.00', '52', '1', '周二 08:10-08:20', '宿舍707', '11');

-- ----------------------------
-- Table structure for `major`
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` int(11) NOT NULL COMMENT '专业id',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '专业名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('10', '软件工程');
INSERT INTO `major` VALUES ('11', '计算机科学与技术');
INSERT INTO `major` VALUES ('12', '考古学');

-- ----------------------------
-- Table structure for `reportcard`
-- ----------------------------
DROP TABLE IF EXISTS `reportcard`;
CREATE TABLE `reportcard` (
  `index` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `performance` json DEFAULT NULL,
  PRIMARY KEY (`index`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of reportcard
-- ----------------------------
INSERT INTO `reportcard` VALUES ('1', '1001', '体验 Mysql JSON');
INSERT INTO `reportcard` VALUES ('2', '1002', '体验 Mysql JSON');
INSERT INTO `reportcard` VALUES ('3', '1003', '体验 Mysql JSON');
INSERT INTO `reportcard` VALUES ('4', '1004', '邓育永');
INSERT INTO `reportcard` VALUES ('5', '1005', '张三');
INSERT INTO `reportcard` VALUES ('6', '1006', '李四');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL COMMENT '角色ID',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `description` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_admin', '管理员');
INSERT INTO `role` VALUES ('2', 'ROLE_teacher', '教师');
INSERT INTO `role` VALUES ('3', 'ROLE_student', '学生');

-- ----------------------------
-- Table structure for `sc`
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc` (
  `sId` int(11) NOT NULL COMMENT '学生id',
  `cId` int(11) NOT NULL COMMENT '课程id',
  `grade` int(11) DEFAULT NULL COMMENT '成绩',
  PRIMARY KEY (`sId`,`cId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES ('123', '1', null);
INSERT INTO `sc` VALUES ('20180005', '1', null);
INSERT INTO `sc` VALUES ('20180005', '4', null);

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(50) unsigned NOT NULL AUTO_INCREMENT COMMENT '学号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sex` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `nation` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '民族',
  `politicsStatus` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '政治面貌',
  `idCard` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证号',
  `majorId` int(11) DEFAULT NULL COMMENT '专业ID',
  `academyId` int(11) DEFAULT NULL COMMENT '学院ID',
  `grade` int(11) DEFAULT NULL COMMENT '年级',
  `phoneNum` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话号码',
  `birth` date DEFAULT NULL COMMENT '出生日期',
  `nativePlace` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '籍贯',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `mid` (`majorId`) USING BTREE,
  KEY `aid` (`academyId`) USING BTREE,
  CONSTRAINT `aid` FOREIGN KEY (`academyId`) REFERENCES `academy` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `mid` FOREIGN KEY (`majorId`) REFERENCES `major` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20180058 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1002', 'ddl生产力', '女', '壮', '党员', '996', '12', '14', '2018', '177', '2020-12-29', '湖北省');
INSERT INTO `student` VALUES ('1004', '费1朔', '女', '壮', '中共党员', '371102199912102257', '12', '14', '2019', '17763305888', '2020-11-30', '陕西');
INSERT INTO `student` VALUES ('1005', '费1说', '女', '汉', '共青团员', '838383883', '12', '14', '3', '99999999', '2020-12-15', '度假酒店');
INSERT INTO `student` VALUES ('20180057', '123', '男', '11', '群众', '11', '10', '10', '11', '11', '2020-12-08', '11');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '职工号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sex` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `nation` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '民族',
  `politicsStatus` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '政治面貌',
  `idCard` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证号',
  `majorId` int(11) DEFAULT NULL COMMENT '专业ID',
  `academyId` int(11) DEFAULT NULL COMMENT '学院ID',
  `createTime` date DEFAULT NULL COMMENT '入职时间',
  `phoneNum` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话号码',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '杜博', null, null, null, null, null, null, null, null, null);
INSERT INTO `teacher` VALUES ('2', '不是说', null, null, null, null, null, null, null, null, null);
INSERT INTO `teacher` VALUES ('3', '胃肠欣', null, null, null, null, null, null, null, null, null);
INSERT INTO `teacher` VALUES ('4', '菲斯说', null, null, null, null, null, null, null, null, null);
INSERT INTO `teacher` VALUES ('5', '等于用', null, null, null, null, null, null, null, null, null);
INSERT INTO `teacher` VALUES ('6', '张敬民', null, null, null, null, null, null, null, null, null);
INSERT INTO `teacher` VALUES ('7', '于明浩', null, null, null, null, null, null, null, null, null);
INSERT INTO `teacher` VALUES ('8', '通张艳', null, null, null, null, null, null, null, null, null);
INSERT INTO `teacher` VALUES ('9', '玉皇大帝', null, null, null, null, null, null, null, null, null);
INSERT INTO `teacher` VALUES ('10', '亡母娘忙', null, null, null, null, null, null, null, null, null);
INSERT INTO `teacher` VALUES ('11', '雅典按', null, null, null, null, null, null, null, null, null);
INSERT INTO `teacher` VALUES ('12', '波塞冬', null, null, null, null, null, null, null, null, null);
INSERT INTO `teacher` VALUES ('13', '九头蛇', null, null, null, null, null, null, null, null, null);
INSERT INTO `teacher` VALUES ('14', '我欸乃', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `teacher_course`
-- ----------------------------
DROP TABLE IF EXISTS `teacher_course`;
CREATE TABLE `teacher_course` (
  `teacherId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师id',
  `courseId` int(11) NOT NULL COMMENT '课程id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of teacher_course
-- ----------------------------

-- ----------------------------
-- Table structure for `user_login`
-- ----------------------------
DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=20180058 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_login
-- ----------------------------
INSERT INTO `user_login` VALUES ('0000001001', '魏昌鑫', '111', '1', '1');
INSERT INTO `user_login` VALUES ('0000001002', '学生甲', '111', '1', '1');
INSERT INTO `user_login` VALUES ('0000001003', 'ddl生产力', '555', '1', '0');
INSERT INTO `user_login` VALUES ('0000001004', 'user', '123', '1', '1');
INSERT INTO `user_login` VALUES ('0000001005', '费三说', '11', '1', '1');
INSERT INTO `user_login` VALUES ('0000001006', '张三', '111', '1', '1');
INSERT INTO `user_login` VALUES ('0000001007', '杜博', '111', '2', '1');
INSERT INTO `user_login` VALUES ('0000001008', '13', '111', '2', '1');
INSERT INTO `user_login` VALUES ('0020180006', '11', '123456', '1', '1');
INSERT INTO `user_login` VALUES ('0020180007', '12', '123456', '1', '1');
INSERT INTO `user_login` VALUES ('0020180056', '124', '123456', '1', '1');
INSERT INTO `user_login` VALUES ('0020180057', '123', '123456', '1', '1');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `uid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `rid` int(11) NOT NULL COMMENT '角色id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_role
-- ----------------------------
