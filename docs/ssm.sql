-- Create Database ssm
CREATE DATABASE `ssm` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';

USE `ssm`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_group
-- ----------------------------
DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group` (
    `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name` varchar(32) CHARACTER SET utf8mb4 NOT NULL COMMENT '群组名称',
    `visible` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '是否可见（0：否，1：是）',
    `remark` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '备注',
    `create_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `last_update_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='群组表';

-- ----------------------------
-- Records of t_group
-- ----------------------------
BEGIN;
INSERT INTO `t_group`(`name`, `visible`, `remark`) VALUES ('徒步爱好群', 1, '喜欢徒步的人的组织，欢迎加入');
INSERT INTO `t_group`(`name`, `visible`, `remark`) VALUES ('编程爱好群', 1, '喜欢编程的“猿”们，一起来码出世界吧');
INSERT INTO `t_group`(`name`, `visible`, `remark`) VALUES ('音乐爱好群', 1, '音乐让我们距离更近');
INSERT INTO `t_group`(`name`, `visible`, `remark`) VALUES ('篮球爱好群', 0, '篮球群，欢迎来虐');
INSERT INTO `t_group`(`name`, `visible`, `remark`) VALUES ('羽毛球爱好群', 1, '羽毛球的世界，你们不懂');
INSERT INTO `t_group`(`name`, `visible`, `remark`) VALUES ('义工群', 1, '欢迎有爱心的各位人士加入');
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
    `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name` varchar(128) CHARACTER SET utf8mb4 NOT NULL COMMENT '姓名',
    `gender` varchar(32) CHARACTER SET utf8mb4 DEFAULT '保密' COMMENT '性别',
    `birthday` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '生日',
    `tel` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '联系电话',
    `address` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '联系地址',
    `remark` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '备注',
    `create_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `last_update_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user`(`name`, `gender`, `birthday`, `tel`, `address`, `remark`) VALUES ('刘一', '男', '2000-01-11', '13800138001', '地球村1号', '爱好打篮球');
INSERT INTO `t_user`(`name`, `gender`, `birthday`, `tel`, `address`, `remark`) VALUES ('陈二', '男', '1999-02-24', '13800138002', '地球村2号', '测试员');
INSERT INTO `t_user`(`name`, `gender`, `birthday`, `tel`, `address`, `remark`) VALUES ('张三', '保密', '2001-10-02', '13800138003', '地球村3号', '');
INSERT INTO `t_user`(`name`, `gender`, `birthday`, `tel`, `address`, `remark`) VALUES ('李四', '女', '1998-05-30', '13800138004', '地球村4号', NULL);
INSERT INTO `t_user`(`name`, `gender`, `birthday`, `tel`, `address`, `remark`) VALUES ('王五', '女', '1999-12-31', '13800138005', '地球村5号', '党员');
INSERT INTO `t_user`(`name`, `gender`, `birthday`, `tel`, `address`, `remark`) VALUES ('赵六', '保密', '2002-02-04', '13800138006', '地球村6号', '群众');
INSERT INTO `t_user`(`name`, `gender`, `birthday`, `tel`, `address`, `remark`) VALUES ('朱七', '男', '2000-11-28', '13800138007', '地球村7号', '党员');
INSERT INTO `t_user`(`name`, `gender`, `birthday`, `tel`, `address`, `remark`) VALUES ('周八', '男', '2001-09-06', '13800138008', '地球村8号', '团员');
INSERT INTO `t_user`(`name`, `gender`, `birthday`, `tel`, `address`, `remark`) VALUES ('吴九', '女', '2001-07-12', '13800138009', '地球村9号', '特长生');
INSERT INTO `t_user`(`name`, `gender`, `birthday`, `tel`, `address`, `remark`) VALUES ('郑十', '男', '2000-04-09', '13800138010', '地球村10号', '无');
COMMIT;

-- ----------------------------
-- Table structure for t_user_group_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_user_group_relation`;
CREATE TABLE `t_user_group_relation` (
    `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `user_id` int(10) unsigned NOT NULL COMMENT '用户ID',
    `group_id` int(10) unsigned NOT NULL COMMENT '群组ID',
    `create_dt` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `user_id_fk` (`user_id`),
    KEY `group_id_fk` (`group_id`),
    CONSTRAINT `group_id_fk` FOREIGN KEY (`group_id`) REFERENCES `t_group` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='用户-群组关系表';

-- ----------------------------
-- Records of t_user_group_relation
-- ----------------------------
BEGIN;
INSERT INTO `t_user_group_relation`(`user_id`, `group_id`) VALUES (1, 1);
INSERT INTO `t_user_group_relation`(`user_id`, `group_id`) VALUES (1, 3);
INSERT INTO `t_user_group_relation`(`user_id`, `group_id`) VALUES (1, 6);
INSERT INTO `t_user_group_relation`(`user_id`, `group_id`) VALUES (2, 5);
INSERT INTO `t_user_group_relation`(`user_id`, `group_id`) VALUES (3, 5);
INSERT INTO `t_user_group_relation`(`user_id`, `group_id`) VALUES (3, 6);
INSERT INTO `t_user_group_relation`(`user_id`, `group_id`) VALUES (4, 1);
INSERT INTO `t_user_group_relation`(`user_id`, `group_id`) VALUES (4, 2);
INSERT INTO `t_user_group_relation`(`user_id`, `group_id`) VALUES (4, 4);
INSERT INTO `t_user_group_relation`(`user_id`, `group_id`) VALUES (4, 6);
INSERT INTO `t_user_group_relation`(`user_id`, `group_id`) VALUES (5, 2);
INSERT INTO `t_user_group_relation`(`user_id`, `group_id`) VALUES (6, 3);
INSERT INTO `t_user_group_relation`(`user_id`, `group_id`) VALUES (6, 4);
INSERT INTO `t_user_group_relation`(`user_id`, `group_id`) VALUES (7, 3);
INSERT INTO `t_user_group_relation`(`user_id`, `group_id`) VALUES (8, 2);
INSERT INTO `t_user_group_relation`(`user_id`, `group_id`) VALUES (8, 3);
INSERT INTO `t_user_group_relation`(`user_id`, `group_id`) VALUES (8, 4);
INSERT INTO `t_user_group_relation`(`user_id`, `group_id`) VALUES (9, 4);
INSERT INTO `t_user_group_relation`(`user_id`, `group_id`) VALUES (9, 6);
INSERT INTO `t_user_group_relation`(`user_id`, `group_id`) VALUES (10, 1);
INSERT INTO `t_user_group_relation`(`user_id`, `group_id`) VALUES (10, 5);
INSERT INTO `t_user_group_relation`(`user_id`, `group_id`) VALUES (10, 6);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;