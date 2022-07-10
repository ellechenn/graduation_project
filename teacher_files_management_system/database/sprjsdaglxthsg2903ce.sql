/*
Navicat MySQL Data Transfer

Source Server         : localhost_3307
Source Server Version : 50736
Source Host           : localhost:3307
Source Database       : sprjsdaglxthsg2903ce

Target Server Type    : MYSQL
Target Server Version : 50736
File Encoding         : 65001

Date: 2022-03-21 21:33:46
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `admin_info`
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `mima` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `nickName` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
  `sex` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `age` int(10) DEFAULT NULL COMMENT '年龄',
  `birthday` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '生日',
  `phone` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `address` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `code` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '编号',
  `email` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `cardId` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证',
  `account` double(10,2) DEFAULT NULL COMMENT '余额',
  `level` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '管理员' COMMENT '权限等级',
  `fileIds` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商品图片id，用英文逗号隔开',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_name` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='管理员信息表';

-- ----------------------------
-- Records of admin_info
-- ----------------------------
INSERT INTO `admin_info` VALUES ('1', 'hsg', '94b40c6db280230b4211b06fa04c7be1', '何升高', '男', '222', '2020-11-02 00:04:25', '18843232356', '上海市ddff33', '111fsfsggsss11', 'aa@163.com', '342425199001116372', '2100.00', '管理员', '[56]');

-- ----------------------------
-- Table structure for `collect_info`
-- ----------------------------
DROP TABLE IF EXISTS `collect_info`;
CREATE TABLE `collect_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shoucangmingcheng` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `shangpinxinxiid` bigint(20) DEFAULT NULL,
  `level` varchar(10) CHARACTER SET utf8mb4 DEFAULT NULL,
  `addtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of collect_info
-- ----------------------------

-- ----------------------------
-- Table structure for `comment_info`
-- ----------------------------
DROP TABLE IF EXISTS `comment_info`;
CREATE TABLE `comment_info` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `content` varchar(175) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '评价内容',
  `shujuid` bigint(10) NOT NULL DEFAULT '0' COMMENT '所属商品',
  `userId` bigint(10) NOT NULL DEFAULT '0' COMMENT '评价人id',
  `level` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户等级',
  `createTime` varchar(175) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建时间',
  `biao` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='商品评价表';

-- ----------------------------
-- Records of comment_info
-- ----------------------------

-- ----------------------------
-- Table structure for `jiaoshijibendangan_info`
-- ----------------------------
DROP TABLE IF EXISTS `jiaoshijibendangan_info`;
CREATE TABLE `jiaoshijibendangan_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gonghao` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `xingbie` varchar(50) DEFAULT NULL,
  `nianling` varchar(50) DEFAULT NULL,
  `xueli` varchar(50) DEFAULT NULL,
  `xianzaizhicheng` varchar(50) DEFAULT NULL,
  `minzu` varchar(50) DEFAULT NULL,
  `dianhuahaoma` varchar(50) DEFAULT NULL,
  `shenfenzheng` varchar(50) DEFAULT NULL,
  `youxiang` varchar(50) DEFAULT NULL,
  `zhengzhimianmao` varchar(50) DEFAULT NULL,
  `renjiaokemu` varchar(50) DEFAULT NULL,
  `jiatingzhuzhi` varchar(50) DEFAULT NULL,
  `shentizhuangkuang` varchar(500) DEFAULT NULL,
  `xuexiao` varchar(50) DEFAULT NULL,
  `zaibenxiaorenzhishijian` varchar(50) DEFAULT NULL,
  `xuexijingli` varchar(500) DEFAULT NULL,
  `gongzuojingli` varchar(500) DEFAULT NULL,
  `zhaopian` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT '是',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of jiaoshijibendangan_info
-- ----------------------------
INSERT INTO `jiaoshijibendangan_info` VALUES ('2', '010', '司宪策', '女', '33', '博士', '', '壮族', '13052154877', '330327199504059511', 'trodd@yahoo.com', '党员', '', '河滨东路139号', '健康', '华中科技大学', '2022-3-13', '初中', '', '[196]', '是', '2022-03-02 19:40:16');
INSERT INTO `jiaoshijibendangan_info` VALUES ('3', '013', '郑亚斌', '女', '23', '研究生', '', '壮族', '13769548711', '330327199005060003', '56547474@qq.com', '团员', '', '开明路22号', '良好', '南开大学', '2022-2-27', '中学', '', '[197]', '是', '2022-03-02 19:40:16');
INSERT INTO `jiaoshijibendangan_info` VALUES ('4', '029', '张燕', '女', '36', '研究生', '', '汉族', '13748589658', '330327198615482633', 'grhtrhk@163.com', '党员', '', '建兴路138号', '健康', '中国人民大学', '2022-2-3', '高中', '', '[198]', '是', '2022-03-02 19:40:16');
INSERT INTO `jiaoshijibendangan_info` VALUES ('5', '032', '梅邹雁', '男', '34', '大专', '', '傣族', '13489665487', '330327198501020300', 'grorti@qq.com', '务农', '', '上江小区2幢', '良好', '吉林大学', '2022-3-13', '初中', '', '[199]', '是', '2022-03-02 19:40:16');
INSERT INTO `jiaoshijibendangan_info` VALUES ('6', '015', '科比', '女', '36', '初中', '', '汉族', '13910215489', '330327198406150488', 'regrodd@qq.com', '党员', '', '东城路99号', '中等', '上海交通大学', '2022-2-2', '初中', '', '[200]', '是', '2022-03-02 19:40:16');
INSERT INTO `jiaoshijibendangan_info` VALUES ('7', '031', '王柏弘', '女', '36', '小学', '', '汉族', '13184865998', '330327199010142546', '2352352@qq.com', '团员', '', '泰兴路22号', '偏差', '浙江大学', '2022-3-23', '硕士', '', '[201]', '是', '2022-03-02 19:40:16');
INSERT INTO `jiaoshijibendangan_info` VALUES ('8', '020', '乔维', '女', '24', '硕士', '', '蒙古族', '13186835580', '330327198708070789', '	fegge@163.com', '团员', '', '龙翔路11号', '偏差', '南京大学', '2022-2-24', '中学', '', '[202]', '是', '2022-03-02 19:40:16');
INSERT INTO `jiaoshijibendangan_info` VALUES ('9', '001', '霍建华', '男', '24', '硕士', '', '回族', '13544655202', '330327198811020456', '43643933@qq.com', '党员', '', '复兴街27号', '中等', '天津大学', '2022-3-23', '硕士', '', '[203]', '是', '2022-03-02 19:40:16');

-- ----------------------------
-- Table structure for `jiaoshixinxi_info`
-- ----------------------------
DROP TABLE IF EXISTS `jiaoshixinxi_info`;
CREATE TABLE `jiaoshixinxi_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gonghao` varchar(50) DEFAULT NULL,
  `mima` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT '是',
  `level` varchar(10) DEFAULT '教师',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of jiaoshixinxi_info
-- ----------------------------
INSERT INTO `jiaoshixinxi_info` VALUES ('2', '025', 'dc5c7986daef50c1e02ab09b442ee34f', '吴亦凡', '是', '教师', '2022-03-02 19:40:16');
INSERT INTO `jiaoshixinxi_info` VALUES ('3', '011', 'dc5c7986daef50c1e02ab09b442ee34f', '吴永国', '是', '教师', '2022-03-02 19:40:16');
INSERT INTO `jiaoshixinxi_info` VALUES ('4', '014', 'dc5c7986daef50c1e02ab09b442ee34f', '詹姆斯', '是', '教师', '2022-03-02 19:40:16');
INSERT INTO `jiaoshixinxi_info` VALUES ('5', '026', 'dc5c7986daef50c1e02ab09b442ee34f', '李景阳', '是', '教师', '2022-03-02 19:40:16');
INSERT INTO `jiaoshixinxi_info` VALUES ('6', '020', 'dc5c7986daef50c1e02ab09b442ee34f', '孙俪', '是', '教师', '2022-03-02 19:40:16');
INSERT INTO `jiaoshixinxi_info` VALUES ('7', '007', 'dc5c7986daef50c1e02ab09b442ee34f', '黄行阳', '是', '教师', '2022-03-02 19:40:16');
INSERT INTO `jiaoshixinxi_info` VALUES ('8', '013', 'dc5c7986daef50c1e02ab09b442ee34f', '滕少华', '是', '教师', '2022-03-02 19:40:16');
INSERT INTO `jiaoshixinxi_info` VALUES ('9', '001', 'dc5c7986daef50c1e02ab09b442ee34f', '王柏弘', '是', '教师', '2022-03-02 19:40:16');

-- ----------------------------
-- Table structure for `jiaoxuechengguojieshao_info`
-- ----------------------------
DROP TABLE IF EXISTS `jiaoxuechengguojieshao_info`;
CREATE TABLE `jiaoxuechengguojieshao_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gonghao` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `riqi` date DEFAULT NULL,
  `suohuodejiangxiang` varchar(50) DEFAULT NULL,
  `jiangxiangneirong` varchar(500) DEFAULT NULL,
  `status` varchar(10) DEFAULT '是',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of jiaoxuechengguojieshao_info
-- ----------------------------
INSERT INTO `jiaoxuechengguojieshao_info` VALUES ('2', '021', '鲁艾弈', '2022-02-09', '', '', '是', '2022-03-02 19:40:16');
INSERT INTO `jiaoxuechengguojieshao_info` VALUES ('3', '003', '舒畅', '2022-02-01', '', '', '是', '2022-03-02 19:40:16');
INSERT INTO `jiaoxuechengguojieshao_info` VALUES ('4', '010', '吴永国', '2022-02-02', '', '', '是', '2022-03-02 19:40:16');
INSERT INTO `jiaoxuechengguojieshao_info` VALUES ('5', '007', '邓超', '2022-02-02', '', '', '是', '2022-03-02 19:40:16');
INSERT INTO `jiaoxuechengguojieshao_info` VALUES ('6', '015', '王永民', '2022-02-02', '', '', '是', '2022-03-02 19:40:16');
INSERT INTO `jiaoxuechengguojieshao_info` VALUES ('7', '020', '何永康', '2022-02-02', '', '', '是', '2022-03-02 19:40:16');
INSERT INTO `jiaoxuechengguojieshao_info` VALUES ('8', '002', '姚明', '2022-03-22', '', '', '是', '2022-03-02 19:40:16');
INSERT INTO `jiaoxuechengguojieshao_info` VALUES ('9', '001', '郭家顺', '2022-02-09', '', '', '是', '2022-03-02 19:40:16');

-- ----------------------------
-- Table structure for `jiaoxuegongzuoliang_info`
-- ----------------------------
DROP TABLE IF EXISTS `jiaoxuegongzuoliang_info`;
CREATE TABLE `jiaoxuegongzuoliang_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gonghao` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `xuenian` varchar(50) DEFAULT NULL,
  `xueqi` varchar(50) DEFAULT NULL,
  `kechengmingcheng` varchar(50) DEFAULT NULL,
  `jiaoxueneirong` varchar(500) DEFAULT NULL,
  `jiaoxuekeshi` varchar(50) DEFAULT NULL,
  `jiaoxueduixiang` varchar(50) DEFAULT NULL,
  `jiaoxuebanrenshu` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT '是',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of jiaoxuegongzuoliang_info
-- ----------------------------
INSERT INTO `jiaoxuegongzuoliang_info` VALUES ('2', '028', '鲁艾弈', '2025', '第二学期', '法律', '', '', '', '74', '是', '2022-03-02 19:40:16');
INSERT INTO `jiaoxuegongzuoliang_info` VALUES ('3', '008', '陈燕琪', '2025', '第一学期', '政治', '', '', '', '69', '是', '2022-03-02 19:40:16');
INSERT INTO `jiaoxuegongzuoliang_info` VALUES ('4', '012', '王柏弘', '2026', '第一学期', '语文', '', '', '', '17', '是', '2022-03-02 19:40:16');
INSERT INTO `jiaoxuegongzuoliang_info` VALUES ('5', '013', '官小芝', '2025', '第一学期', '数学', '', '', '', '26', '是', '2022-03-02 19:40:16');
INSERT INTO `jiaoxuegongzuoliang_info` VALUES ('6', '034', '吴永国', '2025', '第二学期', '线性代数', '', '', '', '74', '是', '2022-03-02 19:40:16');
INSERT INTO `jiaoxuegongzuoliang_info` VALUES ('7', '010', '科比', '2022', '第二学期', '英语', '', '', '', '66', '是', '2022-03-02 19:40:16');
INSERT INTO `jiaoxuegongzuoliang_info` VALUES ('8', '014', '郭依洁', '2024', '第一学期', '历史', '', '', '', '96', '是', '2022-03-02 19:40:16');
INSERT INTO `jiaoxuegongzuoliang_info` VALUES ('9', '001', '河升镇', '2022', '第二学期', '软件工程', '', '', '', '26', '是', '2022-03-02 19:40:16');
INSERT INTO `jiaoxuegongzuoliang_info` VALUES ('10', '001', '王柏弘', '2022', '第一学期', '计算机', '发生发撒法发生', '60', '教学对象', '50', '是', '2022-03-02 19:56:29');

-- ----------------------------
-- Table structure for `keyanlunwen_info`
-- ----------------------------
DROP TABLE IF EXISTS `keyanlunwen_info`;
CREATE TABLE `keyanlunwen_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gonghao` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `shijian` date DEFAULT NULL,
  `lunwenmingcheng` varchar(50) DEFAULT NULL,
  `shifoufabiao` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT '是',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of keyanlunwen_info
-- ----------------------------
INSERT INTO `keyanlunwen_info` VALUES ('2', '011', '袁庆轩', '2022-03-28', 'A论文', '否', '是', '2022-03-02 19:40:16');
INSERT INTO `keyanlunwen_info` VALUES ('3', '027', '鹿晗', '2022-03-28', 'R论文', '否', '是', '2022-03-02 19:40:16');
INSERT INTO `keyanlunwen_info` VALUES ('4', '017', '詹姆斯', '2022-03-25', 'J论文', '是', '是', '2022-03-02 19:40:16');
INSERT INTO `keyanlunwen_info` VALUES ('5', '028', '官小芝', '2022-03-09', 'E论文', '否', '是', '2022-03-02 19:40:16');
INSERT INTO `keyanlunwen_info` VALUES ('6', '014', '陈明希', '2022-03-07', 'P论文', '否', '是', '2022-03-02 19:40:16');
INSERT INTO `keyanlunwen_info` VALUES ('7', '008', '科比', '2022-02-16', 'X论文', '是', '是', '2022-03-02 19:40:16');
INSERT INTO `keyanlunwen_info` VALUES ('8', '019', '郑亚斌', '2022-03-25', 'G论文', '否', '是', '2022-03-02 19:40:16');
INSERT INTO `keyanlunwen_info` VALUES ('9', '001', '孙俪', '2022-03-09', 'D论文', '否', '是', '2022-03-02 19:40:16');

-- ----------------------------
-- Table structure for `keyanxiangmu_info`
-- ----------------------------
DROP TABLE IF EXISTS `keyanxiangmu_info`;
CREATE TABLE `keyanxiangmu_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gonghao` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `shijian` date DEFAULT NULL,
  `xiangmumingcheng` varchar(50) DEFAULT NULL,
  `xiangmufaqiren` varchar(50) DEFAULT NULL,
  `canyurenshu` varchar(50) DEFAULT NULL,
  `shifouhuojiang` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT '是',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of keyanxiangmu_info
-- ----------------------------
INSERT INTO `keyanxiangmu_info` VALUES ('2', '031', '陈小巧', '2022-02-13', 'S项目', '005', '25', '是', '是', '2022-03-02 19:40:16');
INSERT INTO `keyanxiangmu_info` VALUES ('3', '014', '李景阳', '2022-03-09', 'C项目', '003', '51', '是', '是', '2022-03-02 19:40:16');
INSERT INTO `keyanxiangmu_info` VALUES ('4', '026', '陈贵柏', '2022-02-02', 'R项目', '019', '45', '是', '是', '2022-03-02 19:40:16');
INSERT INTO `keyanxiangmu_info` VALUES ('5', '032', '易建联', '2022-03-09', 'J项目', '024', '25', '是', '是', '2022-03-02 19:40:16');
INSERT INTO `keyanxiangmu_info` VALUES ('6', '008', '梅邹雁', '2022-02-13', 'H项目', '030', '90', '否', '是', '2022-03-02 19:40:16');
INSERT INTO `keyanxiangmu_info` VALUES ('7', '025', '李大汉', '2022-02-02', 'K项目', '007', '51', '是', '是', '2022-03-02 19:40:16');
INSERT INTO `keyanxiangmu_info` VALUES ('8', '010', '张燕', '2022-02-02', 'A项目', '022', '51', '否', '是', '2022-03-02 19:40:16');
INSERT INTO `keyanxiangmu_info` VALUES ('9', '001', '吴永国', '2022-02-11', 'B项目', '001', '38', '否', '是', '2022-03-02 19:40:16');

-- ----------------------------
-- Table structure for `keyanzhuanli_info`
-- ----------------------------
DROP TABLE IF EXISTS `keyanzhuanli_info`;
CREATE TABLE `keyanzhuanli_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gonghao` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `shijian` date DEFAULT NULL,
  `zhuanlimingcheng` varchar(50) DEFAULT NULL,
  `shifoupizhun` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT '是',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of keyanzhuanli_info
-- ----------------------------
INSERT INTO `keyanzhuanli_info` VALUES ('2', '009', '鲁艾弈', '2022-03-17', 'G专利', '是', '是', '2022-03-02 19:40:16');
INSERT INTO `keyanzhuanli_info` VALUES ('3', '025', '王与馨', '2022-03-23', 'K专利', '是', '是', '2022-03-02 19:40:16');
INSERT INTO `keyanzhuanli_info` VALUES ('4', '003', '余少庆', '2022-04-01', 'D专利', '否', '是', '2022-03-02 19:40:16');
INSERT INTO `keyanzhuanli_info` VALUES ('5', '029', '吴亦凡', '2022-03-22', 'E专利', '否', '是', '2022-03-02 19:40:16');
INSERT INTO `keyanzhuanli_info` VALUES ('6', '031', '何永康', '2022-03-23', 'B专利', '是', '是', '2022-03-02 19:40:16');
INSERT INTO `keyanzhuanli_info` VALUES ('7', '015', '方之明', '2022-03-23', 'N专利', '是', '是', '2022-03-02 19:40:16');
INSERT INTO `keyanzhuanli_info` VALUES ('8', '016', '官小芝', '2022-02-21', 'X专利', '是', '是', '2022-03-02 19:40:16');
INSERT INTO `keyanzhuanli_info` VALUES ('9', '001', '舒畅', '2022-03-22', 'F专利', '否', '是', '2022-03-02 19:40:16');

-- ----------------------------
-- Table structure for `nx_system_file_info`
-- ----------------------------
DROP TABLE IF EXISTS `nx_system_file_info`;
CREATE TABLE `nx_system_file_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `originName` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '原始文件名',
  `fileName` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '存储文件名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='文件信息表';

-- ----------------------------
-- Records of nx_system_file_info
-- ----------------------------
INSERT INTO `nx_system_file_info` VALUES ('188', 'yhtx1.jpg', 'yhtx1.jpg');
INSERT INTO `nx_system_file_info` VALUES ('189', 'yhtx2.jpg', 'yhtx2.jpg');
INSERT INTO `nx_system_file_info` VALUES ('190', 'yhtx3.jpg', 'yhtx3.jpg');
INSERT INTO `nx_system_file_info` VALUES ('191', 'yhtx4.jpg', 'yhtx4.jpg');
INSERT INTO `nx_system_file_info` VALUES ('192', 'yhtx5.jpg', 'yhtx5.jpg');
INSERT INTO `nx_system_file_info` VALUES ('193', 'yhtx6.jpg', 'yhtx6.jpg');
INSERT INTO `nx_system_file_info` VALUES ('194', 'yhtx7.jpg', 'yhtx7.jpg');
INSERT INTO `nx_system_file_info` VALUES ('195', 'yhtx8.jpg', 'yhtx8.jpg');
INSERT INTO `nx_system_file_info` VALUES ('196', 'jiaoshijibendangan1.jpg', 'jiaoshijibendangan1.jpg');
INSERT INTO `nx_system_file_info` VALUES ('197', 'jiaoshijibendangan2.jpg', 'jiaoshijibendangan2.jpg');
INSERT INTO `nx_system_file_info` VALUES ('198', 'jiaoshijibendangan3.jpg', 'jiaoshijibendangan3.jpg');
INSERT INTO `nx_system_file_info` VALUES ('199', 'jiaoshijibendangan4.jpg', 'jiaoshijibendangan4.jpg');
INSERT INTO `nx_system_file_info` VALUES ('200', 'jiaoshijibendangan5.jpg', 'jiaoshijibendangan5.jpg');
INSERT INTO `nx_system_file_info` VALUES ('201', 'jiaoshijibendangan6.jpg', 'jiaoshijibendangan6.jpg');
INSERT INTO `nx_system_file_info` VALUES ('202', 'jiaoshijibendangan7.jpg', 'jiaoshijibendangan7.jpg');
INSERT INTO `nx_system_file_info` VALUES ('203', 'jiaoshijibendangan8.jpg', 'jiaoshijibendangan8.jpg');

-- ----------------------------
-- Table structure for `richtext_info`
-- ----------------------------
DROP TABLE IF EXISTS `richtext_info`;
CREATE TABLE `richtext_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `content` longtext COLLATE utf8mb4_unicode_ci COMMENT '公告内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='用户上传信息表';

-- ----------------------------
-- Records of richtext_info
-- ----------------------------

-- ----------------------------
-- Table structure for `shiziduiwu_info`
-- ----------------------------
DROP TABLE IF EXISTS `shiziduiwu_info`;
CREATE TABLE `shiziduiwu_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zhanghao` varchar(50) DEFAULT NULL,
  `mima` varchar(50) DEFAULT NULL,
  `mingcheng` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT '是',
  `level` varchar(10) DEFAULT '师资队伍',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of shiziduiwu_info
-- ----------------------------
INSERT INTO `shiziduiwu_info` VALUES ('2', '014', 'dc5c7986daef50c1e02ab09b442ee34f', 'X名称', '是', '师资队伍', '2022-03-02 19:40:16');
INSERT INTO `shiziduiwu_info` VALUES ('3', '002', 'dc5c7986daef50c1e02ab09b442ee34f', 'B名称', '是', '师资队伍', '2022-03-02 19:40:16');
INSERT INTO `shiziduiwu_info` VALUES ('4', '020', 'dc5c7986daef50c1e02ab09b442ee34f', 'A名称', '是', '师资队伍', '2022-03-02 19:40:16');
INSERT INTO `shiziduiwu_info` VALUES ('5', '007', 'dc5c7986daef50c1e02ab09b442ee34f', 'P名称', '是', '师资队伍', '2022-03-02 19:40:16');
INSERT INTO `shiziduiwu_info` VALUES ('6', '027', 'dc5c7986daef50c1e02ab09b442ee34f', 'N名称', '是', '师资队伍', '2022-03-02 19:40:16');
INSERT INTO `shiziduiwu_info` VALUES ('7', '008', 'dc5c7986daef50c1e02ab09b442ee34f', 'H名称', '是', '师资队伍', '2022-03-02 19:40:16');
INSERT INTO `shiziduiwu_info` VALUES ('8', '013', 'dc5c7986daef50c1e02ab09b442ee34f', 'M名称', '是', '师资队伍', '2022-03-02 19:40:16');
INSERT INTO `shiziduiwu_info` VALUES ('9', '001', 'dc5c7986daef50c1e02ab09b442ee34f', 'Y名称', '是', '师资队伍', '2022-03-02 19:40:16');
