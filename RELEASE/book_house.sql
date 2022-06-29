/*
 Navicat Premium Data Transfer

 Source Server         : root-localhost
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : book_house

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 27/06/2022 18:47:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE DATABASE IF NOT EXISTS `book_house`;


USE `book_house`;

-- ----------------------------
-- Table structure for log_login
-- ----------------------------
DROP TABLE IF EXISTS `log_login`;
CREATE TABLE `log_login`  (
                              `id` int NOT NULL AUTO_INCREMENT COMMENT '登录日志 ID',
                              `user_id` int NOT NULL COMMENT '用户 ID',
                              `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
                              `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '登录 IP',
                              `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'IP 归属地',
                              `time` timestamp NOT NULL COMMENT '登录时间',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of log_login
-- ----------------------------
INSERT INTO `log_login` VALUES (1, 1, 'admin', '127.0.0.1', '未知地点', '2022-06-27 18:24:24');

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
                            `id` int NOT NULL AUTO_INCREMENT COMMENT '管理员 id',
                            `username` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
                            `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
                            `register_date` date NOT NULL COMMENT '注册时间',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'admin', 'admin', '2022-06-27');

-- ----------------------------
-- Table structure for t_background
-- ----------------------------
DROP TABLE IF EXISTS `t_background`;
CREATE TABLE `t_background`  (
                                 `id` int NOT NULL AUTO_INCREMENT COMMENT '背景图 id',
                                 `sentence` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '小句子',
                                 `path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '保存路径',
                                 `upload_time` date NOT NULL COMMENT '上传时间',
                                 `upload_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_background
-- ----------------------------
INSERT INTO `t_background` VALUES (1, '', 'static/picture/background/20220627183005.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (2, '', 'static/picture/background/20220627183009.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (3, '', 'static/picture/background/20220627183013.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (4, '', 'static/picture/background/20220627183016.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (5, '', 'static/picture/background/20220627183020.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (6, '', 'static/picture/background/20220627183022.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (7, '', 'static/picture/background/20220627183026.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (8, '', 'static/picture/background/20220627183029.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (9, '', 'static/picture/background/20220627183032.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (10, '', 'static/picture/background/20220627183035.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (11, '', 'static/picture/background/20220627183037.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (12, '', 'static/picture/background/20220627183040.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (13, '', 'static/picture/background/20220627183044.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (14, '', 'static/picture/background/20220627183047.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (15, '', 'static/picture/background/20220627183050.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (16, '', 'static/picture/background/20220627183053.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (17, '', 'static/picture/background/20220627183055.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (18, '', 'static/picture/background/20220627183058.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (19, '', 'static/picture/background/20220627183101.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (20, '', 'static/picture/background/20220627183104.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (21, '', 'static/picture/background/20220627183108.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (22, '', 'static/picture/background/20220627183206.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (23, '', 'static/picture/background/20220627183209.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (24, '', 'static/picture/background/20220627183211.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (25, '', 'static/picture/background/20220627183215.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (26, '', 'static/picture/background/20220627183218.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (27, '', 'static/picture/background/20220627183222.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (28, '', 'static/picture/background/20220627183226.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (29, '', 'static/picture/background/20220627183229.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (30, '', 'static/picture/background/20220627183232.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (31, '', 'static/picture/background/20220627183235.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (32, '', 'static/picture/background/20220627183238.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (33, '', 'static/picture/background/20220627183241.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (34, '', 'static/picture/background/20220627183244.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (35, '', 'static/picture/background/20220627183249.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (36, '', 'static/picture/background/20220627183252.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (37, '', 'static/picture/background/20220627183256.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (38, '', 'static/picture/background/20220627183300.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (39, '', 'static/picture/background/20220627183303.png', '2022-06-27', 'admin');
INSERT INTO `t_background` VALUES (40, '', 'static/picture/background/20220627183306.png', '2022-06-27', 'admin');

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
                           `id` int NOT NULL AUTO_INCREMENT COMMENT '图书 id',
                           `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '书名',
                           `author` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '作者',
                           `translator` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '译者',
                           `keywords` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '关键词',
                           `downloads` int NOT NULL DEFAULT 0 COMMENT '下载量',
                           `collections` int NOT NULL DEFAULT 0 COMMENT '收藏量',
                           `comment` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评价',
                           `book_path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图书保存路径',
                           `cover_path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图书封面保存路径',
                           `upload_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '上传用户名',
                           `upload_time` date NOT NULL COMMENT '上传时间',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES (1, 'Java并发编程的艺术', '方腾飞 / 魏鹏 / 程晓明', '', 'Java 编程语言 计算机', 1, 1, '并发编程领域的扛鼎之作，作者是阿里和1号店的资深Java技术专家，对并发编程有非常深入的研究，《Java并发编程的艺术》是他们多年一线开发经验的结晶。本书的部分内容在出版早期发表在Java并发编程网和InfoQ等技术社区，得到了非常高的评价。它选取了Java并发编程中最核心的技术进行讲解，从JDK源码、JVM、CPU等多角度全面剖析和讲解了Java并发编程的框架、工具、原理和方法，对Java并发编程进行了最为深入和透彻的阐述。', 'WEB-INF/book/Java并发编程的艺术.pdf', 'static/picture/cover/Java并发编程的艺术.jpg', 'admin', '2022-06-27');

-- ----------------------------
-- Table structure for t_download
-- ----------------------------
DROP TABLE IF EXISTS `t_download`;
CREATE TABLE `t_download`  (
                               `id` int NOT NULL AUTO_INCREMENT COMMENT '下载记录 id',
                               `user_id` int NOT NULL COMMENT '用户 id',
                               `operation` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作：下载图书',
                               `score_change` char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '积分变化：-10',
                               `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '下载时间',
                               `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '下载图书书名',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_download
-- ----------------------------
INSERT INTO `t_download` VALUES (1, 1, '下载图书', '-10', '2022-06-27 18:27:15', 'Java并发编程的艺术');

-- ----------------------------
-- Table structure for t_favorite
-- ----------------------------
DROP TABLE IF EXISTS `t_favorite`;
CREATE TABLE `t_favorite`  (
                               `id` int NOT NULL AUTO_INCREMENT COMMENT '收藏记录 id',
                               `user_id` int NOT NULL COMMENT '用户 id',
                               `book_id` int NOT NULL COMMENT '图书 id',
                               `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '书名',
                               `author` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '作者',
                               `cover_path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图书封面路径',
                               `collect_time` date NOT NULL COMMENT '收藏时间',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_favorite
-- ----------------------------
INSERT INTO `t_favorite` VALUES (1, 1, 1, 'Java并发编程的艺术', '方腾飞 / 魏鹏 / 程晓明', 'static/picture/cover/Java并发编程的艺术.jpg', '2022-06-27');

-- ----------------------------
-- Table structure for t_pixabay
-- ----------------------------
DROP TABLE IF EXISTS `t_pixabay`;
CREATE TABLE `t_pixabay`  (
                              `id` int NOT NULL AUTO_INCREMENT COMMENT '图片 id',
                              `condition` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '检索条件',
                              `tags` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签',
                              `views` int NULL DEFAULT NULL COMMENT '浏览量',
                              `downloads` int NULL DEFAULT NULL COMMENT '下载量',
                              `collections` int NULL DEFAULT NULL COMMENT '收藏量',
                              `likes` int NULL DEFAULT NULL COMMENT '点赞量',
                              `comments` int NULL DEFAULT NULL COMMENT '评论量',
                              `add_time` date NULL DEFAULT NULL COMMENT '添加时间',
                              `large_image_url` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片访问地址',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_pixabay
-- ----------------------------

-- ----------------------------
-- Table structure for t_upload
-- ----------------------------
DROP TABLE IF EXISTS `t_upload`;
CREATE TABLE `t_upload`  (
                             `id` int NOT NULL AUTO_INCREMENT COMMENT '上传记录 id',
                             `user_id` int NOT NULL COMMENT '用户 id',
                             `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
                             `operation` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作：上传图书',
                             `score_change` char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '积分变化：+10',
                             `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上传时间',
                             `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '上传图书书名',
                             `book_path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图书保存路径',
                             `cover_path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '封面保存路径',
                             `state` char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '该条上传记录状态：已处理或未处理',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_upload
-- ----------------------------
INSERT INTO `t_upload` VALUES (1, 1, 'admin', '上传图书', '+10', '2022-06-27 18:27:03', 'Java并发编程的艺术.pdf', '/WEB-INF/upload/1-20220627182524.pdf', '/WEB-INF/upload/1-20220627182524.png', '已处理');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
                           `id` int NOT NULL AUTO_INCREMENT COMMENT '用户 id',
                           `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
                           `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
                           `email` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮箱地址',
                           `score` int NOT NULL COMMENT '积分',
                           `portrait_path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '头像保存路径',
                           `register_date` date NOT NULL COMMENT '注册时间',
                           PRIMARY KEY (`id`) USING BTREE,
                           UNIQUE INDEX `uniq_username`(`username` ASC) USING BTREE,
                           UNIQUE INDEX `uniq_email`(`email` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', 'admin', 'admin@admin.com', 9999, 'static/picture/portrait/default.png', '2022-06-27');

-- ----------------------------
-- Table structure for t_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info`  (
                                `id` int NOT NULL AUTO_INCREMENT COMMENT '用户信息 id',
                                `user_id` int NOT NULL COMMENT '用户名',
                                `nickname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户昵称',
                                `sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
                                `birth` date NULL DEFAULT NULL COMMENT '出生年月',
                                `location` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所在地区',
                                `signature` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '个性签名',
                                `collections` int NOT NULL DEFAULT 0 COMMENT '图书收藏量：新用户注册默认为0',
                                `uploads` int NOT NULL DEFAULT 0 COMMENT '图书上传量：新用户注册默认为0',
                                `downloads` int NOT NULL DEFAULT 0 COMMENT '图书下载量：新用户注册默认为0',
                                `last_update_time` date NULL DEFAULT NULL COMMENT '资料上次更新时间',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user_info
-- ----------------------------
INSERT INTO `t_user_info` VALUES (1, 1, 'Spring-_-Bear', '男', '2022-03-14', '湖北省/武汉市', '长相思兮长相忆，短相思兮无穷极。', 0, 0, 0, '2022-06-27');

-- ----------------------------
-- Triggers structure for table t_download
-- ----------------------------
DROP TRIGGER IF EXISTS `update_user_downloads_when_user_download_insert`;
delimiter ;;
CREATE TRIGGER `update_user_downloads_when_user_download_insert` AFTER INSERT ON `t_download` FOR EACH ROW BEGIN
    UPDATE t_user_info SET downloads = downloads + 1 WHERE user_id = new.user_id;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table t_favorite
-- ----------------------------
DROP TRIGGER IF EXISTS `update_user_favorites_when_favorite_delete`;
delimiter ;;
CREATE TRIGGER `update_user_favorites_when_favorite_delete` AFTER DELETE ON `t_favorite` FOR EACH ROW BEGIN
    UPDATE t_user_info SET collections = (SELECT COUNT(*) FROM t_favorite WHERE user_id=old.user_id );
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table t_favorite
-- ----------------------------
DROP TRIGGER IF EXISTS `update_user_favorites_when_favorite_insert`;
delimiter ;;
CREATE TRIGGER `update_user_favorites_when_favorite_insert` AFTER INSERT ON `t_favorite` FOR EACH ROW BEGIN
    UPDATE t_user_info SET collections = (SELECT COUNT(*) FROM t_favorite WHERE user_id=new.user_id );
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table t_upload
-- ----------------------------
DROP TRIGGER IF EXISTS `update_user_uploads_when_user_upload_insert`;
delimiter ;;
CREATE TRIGGER `update_user_uploads_when_user_upload_insert` AFTER INSERT ON `t_upload` FOR EACH ROW BEGIN
    UPDATE t_user_info SET uploads = uploads + 1 WHERE user_id = new.user_id;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table t_user
-- ----------------------------
DROP TRIGGER IF EXISTS `add_user_id_to_user_info_when_user_insert`;
delimiter ;;
CREATE TRIGGER `add_user_id_to_user_info_when_user_insert` AFTER INSERT ON `t_user` FOR EACH ROW BEGIN
    INSERT INTO t_user_info(user_id) SELECT id FROM t_user WHERE id = new.id;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
