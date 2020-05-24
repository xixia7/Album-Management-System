/*
Navicat MySQL Data Transfer

Source Server         : Java学习的本地连接
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-04-15 16:37:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `album`
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `update_time` varchar(255) DEFAULT NULL,
  `discription` varchar(255) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `padding1` varchar(255) DEFAULT NULL,
  `padding2` varchar(255) DEFAULT NULL,
  `padding3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of album
-- ----------------------------
INSERT INTO `album` VALUES ('1', '6666', null, null, '66666666', '1', null, null, null);
INSERT INTO `album` VALUES ('2', 'We', null, null, 'We', '1', null, null, null);
INSERT INTO `album` VALUES ('3', '测试', null, null, '另一个用户', '2', null, null, null);

-- ----------------------------
-- Table structure for `photo`
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `headline` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `photo_size` varchar(255) DEFAULT NULL,
  `discription` varchar(255) DEFAULT NULL,
  `album_id` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT '0',
  `padding1` varchar(255) DEFAULT NULL,
  `padding2` varchar(255) DEFAULT NULL,
  `padding3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of photo
-- ----------------------------
INSERT INTO `photo` VALUES ('1', '哈哈哈哈', 'f1632b09ac43416bb30155ee5abbaf28_2.png', '2019-04-14 18:43:00', '2019-04-14 18:43:00', '92K', '哈哈哈哈', '1', '0', null, null, null);
INSERT INTO `photo` VALUES ('2', '凤凰', '6960b94463874448a785c88126157e15_3.jpg', '2019-04-14 18:44:09', '2019-04-14 18:44:09', '108K', '123456', '1', '0', null, null, null);
INSERT INTO `photo` VALUES ('3', 'We', 'c81a305be8d943beae09cd4bd279f87c_1.jpg', '2019-04-14 18:44:41', '2019-04-14 18:44:41', '3239K', 'we', '2', '0', null, null, null);
INSERT INTO `photo` VALUES ('4', '刘钦华', '718ae269ea7142a4a054fc97b52cab9d_5.jpg', '2019-04-14 18:45:32', '2019-04-14 18:45:32', '122K', '刘钦华', '2', '0', null, null, null);
INSERT INTO `photo` VALUES ('5', '香蜜', '3f40116a087f425f8036677f99cfd51e_7.png', '2019-04-14 18:47:26', '2019-04-14 18:47:26', '225K', '香蜜', '3', '0', null, null, null);
INSERT INTO `photo` VALUES ('6', 'hhh ', '5b6bdb8c218a486486aa1d6b5c55167a_psb (4).jpg', '2019-04-14 21:43:25', '2019-04-15 16:34:29', '336K', '哈哈哈哈', '2', '1', null, null, null);

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `pass_word` varchar(255) DEFAULT NULL,
  `user_age` int(11) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `padding1` varchar(255) DEFAULT NULL,
  `padding2` varchar(255) DEFAULT NULL,
  `padding3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '刘钦华', '123', null, '男', null, null, null);
INSERT INTO `users` VALUES ('2', '哈哈哈', '123456', null, '女', null, null, null);
