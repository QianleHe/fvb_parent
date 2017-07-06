
CREATE DATABASE IF NOT EXISTS `FoodVoteBox`  DEFAULT CHARACTER SET utf8;
USE `FoodVoteBox`;


-- user part ----------------------


DROP TABLE IF EXISTS `fvb_user`;
CREATE TABLE `fvb_user` (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码，加密存储',
  `phone` varchar(20) DEFAULT NULL COMMENT '注册手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '注册邮箱',
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `picid` VARCHAR(50) DEFAULT NULL COMMENT '头像图片名',
  PRIMARY KEY (`userid`),
  UNIQUE KEY `username` (`username`) USING BTREE,
  UNIQUE KEY `phone` (`phone`) USING BTREE,
  UNIQUE KEY `email` (`email`) USING BTREE,
  UNIQUE KEY `picid` (`picid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='用户表';



--  Restaurant table  -----------------
DROP TABLE IF EXISTS `fvb_restaurant`;
CREATE TABLE `fvb_restaurant` (
  `restaurantid` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `restaurantname` VARCHAR(100) NOT NULL,
  `city` VARCHAR(30) DEFAULT NULL,
  `address` VARCHAR(200) DEFAULT NULL,
  `phone` VARCHAR(30) DEFAULT NULL,
  `price` VARCHAR(10) DEFAULT NULL,
  `rating` VARCHAR(10) DEFAULT NULL,
  `yelpurl` VARCHAR(200) DEFAULT NULL,
  `imgurl` VARCHAR(200) DEFAULT NULL,
  `updated` DATETIME DEFAULT NULL,
  PRIMARY KEY (`restaurantid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='fvb_restaurant';

--  Event table  -------------------------

DROP TABLE IF EXISTS `fvb_event`;
CREATE TABLE `fvb_event` (
  `eventid` bigint(20) NOT NULL AUTO_INCREMENT,
  `eventname` varchar(100) NOT NULL,
  `eventdate` datetime NOT NULL,
  `ownerid` bigint(20) NOT NULL,
  `description` varchar(200),
  `resultid` bigint(20) DEFAULT NULL,
  `submitted` boolean DEFAULT FALSE,
  PRIMARY KEY (`eventid`),
  KEY `ownerid` (`ownerid`) USING BTREE,
  CONSTRAINT FOREIGN KEY (`ownerid`) REFERENCES `fvb_user` (`userid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Event table';

INSERT INTO `fvb_event` VALUES ('1', '6.25 Party', '2015-05-16 15:19:39', '18');

-- EventMember table  ------------

DROP TABLE IF EXISTS `fvb_eventMember`;
CREATE TABLE `fvb_eventMember` (
  `eventid` bigint(20) NOT NULL,
  `memberid` bigint(20) NOT NULL,
  `voted` boolean DEFAULT FALSE,
  PRIMARY KEY (`eventid`, `memberid`),
  CONSTRAINT FOREIGN KEY (`eventid`) REFERENCES `fvb_event` (`eventid`) ON DELETE CASCADE,
  CONSTRAINT FOREIGN KEY (`memberid`) REFERENCES `fvb_user` (`userid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='EventMember table';


-- EventRestaurant table  --------------

DROP TABLE IF EXISTS `fvb_eventRestaurant`;
CREATE TABLE `fvb_eventRestaurant` (
  `eventid` bigint(20) NOT NULL,
  `restaurantid` bigint(20) NOT NULL,
  `votes` int default 0,
  PRIMARY KEY (`eventid`, `restaurantid`),
  CONSTRAINT FOREIGN KEY (`eventid`) REFERENCES `fvb_event` (`eventid`) ON DELETE CASCADE,
  CONSTRAINT FOREIGN KEY (`restaurantid`) REFERENCES `fvb_restaurant` (`restaurantid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='EventRestaurant table';




INSERT INTO `fvb_user` VALUES ('9', 'zhangsan', 'e10adc3949ba59abbe56e057f20f883e', '13800000000', 'aaa@qq.com', '2015-05-16 15:19:39', '2015-05-16 15:19:39', NULL );
INSERT INTO `fvb_user` VALUES ('10', 'zhangsan1', '195d91be1e3ba6f1c857d46f24c5a454', '13800000001', null, '2015-05-16 17:13:10', '2015-05-16 17:13:10', NULL );
INSERT INTO `fvb_user` VALUES ('11', 'zhangsan2', '195d91be1e3ba6f1c857d46f24c5a454', '13800000002', null, '2015-05-16 17:25:09', '2015-05-16 17:25:09', NULL );
INSERT INTO `fvb_user` VALUES ('12', 'zhangsan3', '195d91be1e3ba6f1c857d46f24c5a454', '13800000003', null, '2015-05-16 17:27:44', '2015-05-16 17:27:44', NULL );

-- friend part --------------------
DROP TABLE IF EXISTS `fvb_user_friends`;
CREATE TABLE `fvb_user_friends` (
  `userid` bigint(20) NOT NULL,
  `friendid` bigint(20) NOT NULL,
  `friend_name` varchar(50) NOT NULL COMMENT 'friend_name',
  PRIMARY KEY (`userid`,`friendid`),
  CONSTRAINT FOREIGN KEY (`userid`) REFERENCES `fvb_user` (`userid`) ON DELETE CASCADE,
  CONSTRAINT FOREIGN KEY (`friendid`) REFERENCES `fvb_user` (`userid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='朋友表';


-- Added Restaurants -----------------
DROP TABLE IF EXISTS `fvb_user_added_restaurants`;
CREATE TABLE `fvb_user_added_restaurants` (
  `userid` BIGINT(20) NOT NULL,
  `restaurantid` BIGINT(20) NOT NULL,
  PRIMARY KEY (`userid`, `restaurantid`),
  CONSTRAINT FOREIGN KEY (`userid`) REFERENCES `fvb_user` (`userid`) ON DELETE CASCADE,
  CONSTRAINT FOREIGN KEY (`restaurantid`) REFERENCES `fvb_restaurant` (`restaurantid`) ON DELETE CASCADE
)