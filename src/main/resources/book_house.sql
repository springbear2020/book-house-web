-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: 124.221.120.56    Database: book_house
-- ------------------------------------------------------
-- Server version	5.7.37-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `book_house`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `book_house` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `book_house`;

--
-- Table structure for table `t_admin`
--

DROP TABLE IF EXISTS `t_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员 id',
  `username` varchar(16) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `register_date` date NOT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin`
--

LOCK TABLES `t_admin` WRITE;
/*!40000 ALTER TABLE `t_admin` DISABLE KEYS */;
INSERT INTO `t_admin` VALUES (1,'admin','admin','2022-04-29');
/*!40000 ALTER TABLE `t_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_background`
--

DROP TABLE IF EXISTS `t_background`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_background` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '背景图 id',
  `sentence` varchar(128) NOT NULL COMMENT '小句子',
  `path` varchar(128) NOT NULL COMMENT '保存路径',
  `upload_time` date NOT NULL COMMENT '上传时间',
  `upload_user` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_background`
--

LOCK TABLES `t_background` WRITE;
/*!40000 ALTER TABLE `t_background` DISABLE KEYS */;
INSERT INTO `t_background` VALUES (1,'null','static/picture/background/default.png','2022-04-29','admin');
/*!40000 ALTER TABLE `t_background` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_book`
--

DROP TABLE IF EXISTS `t_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书 id',
  `title` varchar(128) NOT NULL COMMENT '书名',
  `author` varchar(128) NOT NULL COMMENT '作者',
  `translator` varchar(128) DEFAULT NULL COMMENT '译者',
  `keywords` varchar(64) NOT NULL COMMENT '关键词',
  `downloads` int(11) NOT NULL DEFAULT '0' COMMENT '下载量',
  `collections` int(11) NOT NULL DEFAULT '0' COMMENT '收藏量',
  `comment` varchar(512) NOT NULL COMMENT '评价',
  `book_path` varchar(128) NOT NULL COMMENT '图书保存路径',
  `cover_path` varchar(128) NOT NULL COMMENT '图书封面保存路径',
  `upload_username` varchar(32) NOT NULL COMMENT '上传用户名',
  `upload_time` date NOT NULL COMMENT '上传时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_book`
--

LOCK TABLES `t_book` WRITE;
/*!40000 ALTER TABLE `t_book` DISABLE KEYS */;
INSERT INTO `t_book` VALUES (1,'克拉拉与太阳','[英] 石黑一雄','宋佥','外国文学',0,0,'克拉拉是一个专为陪伴儿童而设计的太阳能人工智能机器人（AF），具有极高的观察、推理与共情能力。她坐在商店展示橱窗里，注视着街头路人以及前来浏览橱窗的孩子们的一举一动。她始终期待着很快就会有人挑中她，不过，当这种永久改变境遇的可能性出现时，克拉拉却被提醒不要过分相信人类的诺言。\r\n\r\n在《克拉拉与太阳》这部作品中，石黑一雄通过一位令人难忘的叙述者的视角，观察千变万化的现代社会，探索了一个根本性的问题：究竟什么是爱？','null','static/picture/cover/1.jpg','admin','2022-04-29'),(2,'字母表谜案','大山诚一郎','曹逸冰','悬疑小说',0,0,'一座神秘的公寓，不定期举行推理合战。红茶、曲奇，搭配寒意逼人的谜案，与案件相关的字母似乎是重要线索。一群特殊的房客，联手组成侦探团，秘密追踪警视厅也难以锁定的幕后真凶。','null','static/picture/cover/2.jpg','admin','2022-04-29'),(3,'从零开始的女性主义','[日本] 上野千鹤子 / 田房永子','吕灵芝','外国文学',0,0,'日本女性主义理论第一人、《厌女》作者上野千鹤子 面向普通读者的女性主义普及课。女性为何如此艰难？女性如何奋斗至今？又该如何奋斗？工作、婚恋、育儿，该如何以女性主义的角度思考？','null','static/picture/cover/3.jpg','admin','2022-04-29'),(4,'置身事内','兰小欢',NULL,'大国之治',0,0,'“在成功的经济体中，经济政策一定是务实的，不是意识形态化的。是具体的，不是抽象的。”\r\n\r\n直面真问题、深究真逻辑的复旦大学经济学“毕业课”','null','static/picture/cover/4.jpg','admin','2022-04-29'),(5,'也许你该找个人聊聊','[美]洛莉·戈特利布 / 洛莉·戈特利布','张含笑','心理',0,0,'这是一位心理治疗师的回忆录，讲述了发生在诊室中的故事。在这个小小的密闭空间里，人们会展现出最真实、最脆弱的一面；也是在这里，人们获得了陪伴和倾听，也获得了宝贵的觉察、成长与改变。','null','static/picture/cover/5.jpg','admin','2022-04-29'),(6,'刘擎西方现代思想讲义','刘擎',NULL,'思想主义',0,0,'人生的意义，人们向往的自由和公平的价值，人类文明的复杂冲突与未来趋势……这些让你困惑的大小问题，过去也困扰过韦伯、尼采、萨特等杰出的头脑。他们尽最大努力做出阐释，为后人提供了宝贵的思想标识。在这部讲义里，刘擎介绍了现代视域下的19位思想大家，广泛而系统地讨论工具理性的利 弊，如何面对虚无主义，消费主义对人的异化，财富分配的公平正义和全球化等议题。思想不惑，精神明亮。你将在这19位大家的生平故事中，理解他们建构思想大厦的地基与框架。你还会在思想大厦之上，直面个人生活和社会公共领域的诸多难题，收获审慎而真诚的回答。','null','static/picture/cover/6.jpg','admin','2022-04-29'),(7,'下沉年代','[美] 乔治·帕克','刘冉','外国名著',0,0,'“这是一个时代苍凉的侧影：受挫的努力，被辜负的信任，凋零的生机，以及日渐黯淡的希望。力透纸背的书写，栩栩如生的人物，呈现了美国三十多年的沧桑巨变，也为当下社会撕裂的悲剧写下了发人深省的前传。”——刘擎，华东师范大学教授','null','static/picture/cover/7.jpg','admin','2022-04-29'),(8,'文城','余华',NULL,'畅销文学',0,0,'时代的洪流推着每个人做出各自的选择。这是一个荒蛮的年代，结束的尚未结束，开始的尚未开始。我们总是在不同时代、不同国家、不同语言的作家那里，读到自己的感受，甚至是自己的生活。假如文学中真的存在某些神秘的力量，我想可能就是这些。','null','static/picture/cover/8.jpg','admin','2022-04-29');
/*!40000 ALTER TABLE `t_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_download`
--

DROP TABLE IF EXISTS `t_download`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_download` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '下载记录 id',
  `user_id` int(11) NOT NULL COMMENT '用户 id',
  `operation` char(4) NOT NULL COMMENT '操作：下载图书',
  `score_change` char(3) NOT NULL COMMENT '积分变化：-10',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '下载时间',
  `title` varchar(128) NOT NULL COMMENT '下载图书书名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_download`
--

LOCK TABLES `t_download` WRITE;
/*!40000 ALTER TABLE `t_download` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_download` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_favorite`
--

DROP TABLE IF EXISTS `t_favorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_favorite` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收藏记录 id',
  `user_id` int(11) NOT NULL COMMENT '用户 id',
  `book_id` int(11) NOT NULL COMMENT '图书 id',
  `title` varchar(128) NOT NULL COMMENT '书名',
  `author` varchar(128) NOT NULL COMMENT '作者',
  `cover_path` varchar(128) NOT NULL COMMENT '图书封面路径',
  `collect_time` date NOT NULL COMMENT '收藏时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_favorite`
--

LOCK TABLES `t_favorite` WRITE;
/*!40000 ALTER TABLE `t_favorite` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_favorite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_pixabay`
--

DROP TABLE IF EXISTS `t_pixabay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_pixabay` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片 id',
  `condition` varchar(64) DEFAULT NULL COMMENT '检索条件',
  `tags` varchar(64) DEFAULT NULL COMMENT '标签',
  `views` int(11) DEFAULT NULL COMMENT '浏览量',
  `downloads` int(11) DEFAULT NULL COMMENT '下载量',
  `collections` int(11) DEFAULT NULL COMMENT '收藏量',
  `likes` int(11) DEFAULT NULL COMMENT '点赞量',
  `comments` int(11) DEFAULT NULL COMMENT '评论量',
  `add_time` date DEFAULT NULL COMMENT '添加时间',
  `large_image_url` varchar(512) DEFAULT NULL COMMENT '图片访问地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pixabay`
--

LOCK TABLES `t_pixabay` WRITE;
/*!40000 ALTER TABLE `t_pixabay` DISABLE KEYS */;
INSERT INTO `t_pixabay` VALUES (1,'default','default',0,0,0,0,0,'2022-04-29','static/picture/background/default.png');
/*!40000 ALTER TABLE `t_pixabay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_upload`
--

DROP TABLE IF EXISTS `t_upload`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_upload` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '上传记录 id',
  `user_id` int(11) NOT NULL COMMENT '用户 id',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `operation` char(4) NOT NULL COMMENT '操作：上传图书',
  `score_change` char(3) NOT NULL COMMENT '积分变化：+10',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上传时间',
  `title` varchar(128) NOT NULL COMMENT '上传图书书名',
  `book_path` varchar(128) NOT NULL COMMENT '图书保存路径',
  `cover_path` varchar(128) NOT NULL COMMENT '封面保存路径',
  `state` char(3) NOT NULL COMMENT '该条上传记录状态：已处理或未处理',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_upload`
--

LOCK TABLES `t_upload` WRITE;
/*!40000 ALTER TABLE `t_upload` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_upload` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户 id',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `email` varchar(128) NOT NULL COMMENT '邮箱地址',
  `score` int(11) NOT NULL COMMENT '积分',
  `portrait_path` varchar(128) NOT NULL COMMENT '头像保存路径',
  `register_date` date NOT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_username` (`username`),
  UNIQUE KEY `uniq_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_info`
--

DROP TABLE IF EXISTS `t_user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户信息 id',
  `user_id` int(11) NOT NULL COMMENT '用户名',
  `nickname` varchar(64) DEFAULT NULL COMMENT '用户昵称',
  `sex` char(2) DEFAULT NULL COMMENT '性别',
  `birth` date DEFAULT NULL COMMENT '出生年月',
  `location` varchar(128) DEFAULT NULL COMMENT '所在地区',
  `signature` varchar(256) DEFAULT NULL COMMENT '个性签名',
  `collections` int(11) NOT NULL DEFAULT '0' COMMENT '图书收藏量：新用户注册默认为0',
  `uploads` int(11) NOT NULL DEFAULT '0' COMMENT '图书上传量：新用户注册默认为0',
  `downloads` int(11) NOT NULL DEFAULT '0' COMMENT '图书下载量：新用户注册默认为0',
  `last_update_time` date DEFAULT NULL COMMENT '资料上次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_info`
--

LOCK TABLES `t_user_info` WRITE;
/*!40000 ALTER TABLE `t_user_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-29 19:47:56
