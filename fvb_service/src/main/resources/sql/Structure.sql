
CREATE DATABASE IF NOT EXISTS `FoodVoteBox`  DEFAULT CHARACTER SET utf8;
USE `FoodVoteBox`;


-- user part ----------------------


DROP TABLE IF EXISTS `fvb_user`;
CREATE TABLE `fvb_user` (
  `friendid` bigint(20) NOT NULL AUTO_INCREMENT,
  `friendname` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码，加密存储',
  `phone` varchar(20) DEFAULT NULL COMMENT '注册手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '注册邮箱',
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  PRIMARY KEY (`friendid`),
  UNIQUE KEY `friendname` (`friendname`) USING BTREE,
  UNIQUE KEY `phone` (`phone`) USING BTREE,
  UNIQUE KEY `email` (`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='用户表';


INSERT INTO `fvb_user` VALUES ('9', 'zhangsan', 'e10adc3949ba59abbe56e057f20f883e', '13800000000', 'aaa@qq.com', '2015-05-16 15:19:39', '2015-05-16 15:19:39');
INSERT INTO `fvb_user` VALUES ('10', 'zhangsan1', '195d91be1e3ba6f1c857d46f24c5a454', '13800000001', null, '2015-05-16 17:13:10', '2015-05-16 17:13:10');
INSERT INTO `fvb_user` VALUES ('11', 'zhangsan2', '195d91be1e3ba6f1c857d46f24c5a454', '13800000002', null, '2015-05-16 17:25:09', '2015-05-16 17:25:09');
INSERT INTO `fvb_user` VALUES ('12', 'zhangsan3', '195d91be1e3ba6f1c857d46f24c5a454', '13800000003', null, '2015-05-16 17:27:44', '2015-05-16 17:27:44');

-- friend part --------------------
DROP TABLE IF EXISTS `fvb_user_friends`;
CREATE TABLE `fvb_user_friends` (
  `userid` bigint(20) NOT NULL,
  `friendid` bigint(20) NOT NULL,
  `friend_name` varchar(50) NOT NULL COMMENT 'friend_name',
  PRIMARY KEY (`userid`,`friendid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='朋友表';