/*数据库重新排序命令  alter table user AUTO_INCREMENT=1;*/
-- alter table user AUTO_INCREMENT=1;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `gender` int(50) DEFAULT NULL,
  `age` int(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `creattime` VARCHAR (50) DEFAULT NULL,
  `job` int(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
