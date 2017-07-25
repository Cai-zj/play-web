SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for users 创建用户表
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `enabled` tinyint(1) NOT NULL COMMENT '是否启用',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
SET FOREIGN_KEY_CHECKS=1;

-- ----------------------------
-- Records of users 插入记录  管理员账号:admin  密码:gufeng
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', '96def8c4495ab9c7ca8e4395b18a95df', '1', '2017-07-25 13:17:23');
SET FOREIGN_KEY_CHECKS=1;


-- ----------------------------
-- Table structure for authorities 权限表
-- ----------------------------
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `authority` varchar(50) NOT NULL COMMENT '权限',
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET FOREIGN_KEY_CHECKS=1;


-- ----------------------------
-- Records of authorities 插入记录
-- ----------------------------
INSERT INTO `authorities` VALUES ('admin', 'ROLE_ADMIN');
SET FOREIGN_KEY_CHECKS=1;
