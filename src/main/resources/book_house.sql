-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 124.221.120.56    Database: book_house
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `book_house`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `book_house` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `book_house`;

--
-- Table structure for table `log_login`
--

DROP TABLE IF EXISTS `log_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log_login` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '登录日志 id',
  `user_id` int NOT NULL COMMENT '用户 id',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `ip` char(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '登录 ip',
  `location` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '登录位置',
  `time` timestamp NOT NULL COMMENT '登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_login`
--

LOCK TABLES `log_login` WRITE;
/*!40000 ALTER TABLE `log_login` DISABLE KEYS */;
INSERT INTO `log_login` VALUES (1,2,'bear','0:0:0:0:0:0:0:1','未知','2022-03-26 18:50:24'),(2,2,'bear','0:0:0:0:0:0:0:1','未知','2022-03-26 18:52:58'),(3,2,'bear','0:0:0:0:0:0:0:1','未知','2022-03-26 18:54:22'),(4,2,'bear','0:0:0:0:0:0:0:1','未知','2022-03-26 18:58:25'),(5,2,'bear','0:0:0:0:0:0:0:1','未知','2022-03-26 19:00:02'),(6,2,'bear','0:0:0:0:0:0:0:1','未知','2022-03-26 21:11:40'),(7,2,'bear','0:0:0:0:0:0:0:1','未知','2022-03-26 21:21:40'),(8,2,'bear','0:0:0:0:0:0:0:1','未知','2022-03-26 22:02:42'),(9,2,'bear','0:0:0:0:0:0:0:1','未知','2022-03-27 00:44:40'),(10,2,'bear','0:0:0:0:0:0:0:1','未知','2022-03-27 01:02:54'),(11,2,'bear','0:0:0:0:0:0:0:1','未知','2022-03-27 01:15:16'),(12,2,'bear','0:0:0:0:0:0:0:1','未知','2022-03-27 01:17:13'),(13,2,'bear','0:0:0:0:0:0:0:1','未知','2022-03-27 01:18:24'),(14,1,'Snake','0:0:0:0:0:0:0:1','未知','2022-03-27 04:13:12'),(15,2,'bear','0:0:0:0:0:0:0:1','未知','2022-03-27 04:34:38'),(16,2,'bear','0:0:0:0:0:0:0:1','未知','2022-03-27 05:03:15'),(17,2,'bear','0:0:0:0:0:0:0:1','未知','2022-03-27 05:06:34'),(18,1,'Snake','0:0:0:0:0:0:0:1','未知','2022-03-27 05:10:47'),(19,2,'bear','0:0:0:0:0:0:0:1','未知','2022-03-27 05:11:01'),(20,1,'Snake','0:0:0:0:0:0:0:1','未知','2022-03-27 06:19:56'),(21,1,'Snake','0:0:0:0:0:0:0:1','未知','2022-03-27 06:22:32'),(22,2,'bear','0:0:0:0:0:0:0:1','未知','2022-03-27 07:01:10'),(23,2,'bear','0:0:0:0:0:0:0:1','未知','2022-03-27 15:12:11'),(24,2,'bear','0:0:0:0:0:0:0:1','未知','2022-03-27 16:29:15'),(25,1,'Snake','0:0:0:0:0:0:0:1','未知','2022-03-27 17:45:21'),(26,1,'Snake','0:0:0:0:0:0:0:1','未知','2022-03-27 17:51:44'),(27,1,'Snake','0:0:0:0:0:0:0:1','未知','2022-03-27 18:01:05'),(28,1,'Snake','0:0:0:0:0:0:0:1','未知','2022-03-27 18:06:16');
/*!40000 ALTER TABLE `log_login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_admin`
--

DROP TABLE IF EXISTS `t_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_admin` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '管理员 id',
  `username` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `register_date` date NOT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin`
--

LOCK TABLES `t_admin` WRITE;
/*!40000 ALTER TABLE `t_admin` DISABLE KEYS */;
INSERT INTO `t_admin` VALUES (1,'admin','admin','2022-03-27');
/*!40000 ALTER TABLE `t_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_book`
--

DROP TABLE IF EXISTS `t_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_book` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '图书 id',
  `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '书名',
  `author` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '作者',
  `translator` varchar(128) DEFAULT NULL COMMENT '译者',
  `keywords` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '关键词',
  `downloads` int NOT NULL DEFAULT '0' COMMENT '下载量',
  `collections` int NOT NULL DEFAULT '0' COMMENT '收藏量',
  `comment` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评价',
  `book_path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图书保存路径',
  `cover_path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图书封面保存路径',
  `upload_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '上传用户名',
  `upload_time` date NOT NULL COMMENT '上传时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_book`
--

LOCK TABLES `t_book` WRITE;
/*!40000 ALTER TABLE `t_book` DISABLE KEYS */;
INSERT INTO `t_book` VALUES (1,'Java编程思想(第4版)','Bruce Eckel','陈昊鹏','Java 编程 计算机',2,11,'本书赢得了全球程序员的广泛赞誉，即使是最晦涩的概念，在Bruce Eckel的文字亲和力和小而直接的编程示例面前也会化解于无形。从Java的基础语法到最高级特性（深入的面向对象概念、多线程、自动项目构建、单元测试和调试等），本书都能逐步指导你轻松掌握。','WEB-INF/book/Java编程思想(第4版).pdf','static/picture/cover/Java编程思想(第4版).jpeg','bear','2022-03-22'),(2,'Java开发手册(嵩山版)','阿里巴巴','','Java 编程 规范',29,31,'Java开发手册来自万名阿里Java技术精英的经验总结，并经历了多次大规模一线实战检验及完善，铸就了这本高含金量的阿里Java开发手册。','WEB-INF/book/Java开发手册(嵩山版).pdf','static/picture/cover/Java开发手册(嵩山版).png','bear','2022-03-22'),(3,'Head First Java(第2版)','Kathy Sierra & Bert Bates','张然','Java 编程 计算机',5,25,'《HeadFirstJava》是一本完整地面向对象(object-oriented，OO)程序设计和Java的学习指导用书，根据学习理论所设计，你可以从程序语言的基础开始，到线程、网络与分布式程序等项目。','WEB-INF/book/Head First Java(第2版).pdf','static/picture/cover/Head First Java(第2版).jpg','bear','2022-03-22'),(4,'Java并发编程的艺术','方腾飞&魏鹏&程晓明','','Java 编程 计算机',2,18,'《Java并发编程的艺术》内容涵盖Java并发编程机制的底层实现原理、Java内存模型、Java并发编程基础、Java中的锁、并发容器和框架、原子类、并发工具类、线程池、Executor框架等主题，每个主题都做了深入的讲解，同时通过实例介绍了如何应用这些技术。','WEB-INF/book/Java并发编程的艺术.pdf','static/picture/cover/Java并发编程的艺术.png','bear','2022-03-22'),(5,'Java并发编程实战','Brian Goetz&Tim Peierls&Joshua Bloch&Joseph Bowbeer&David Holmes&Doug Lea','童云兰','Java 并发编程 计算机',3,10,'本书深入浅出地介绍了Java线程和并发，是一本完美的Java并发参考手册。书中从并发性和线程安全性的基本概念出发，介绍了如何使用类库提供的基本并发构建块，用于避免并发危险、构造线程安全的类及验证线程安全的规则，如何将小的线程安全类组合成更大的线程安全类，如何利用线程来提高并发应用程序的吞吐量，如何识别可并行执行的任务，如何提高单线程子系统的响应性，如何确保并发程序执行预期任务，如何提高并发代码的性能和可伸缩性等内容，最后介绍了一些高级主题，如显式锁、原子变量、非阻塞算法以及如何开发自定义的同步工具类。','WEB-INF/book/Java并发编程实战.pdf','static/picture/cover/Java并发编程实战.png','bear','2022-03-22'),(6,'Java核心技术卷I基础知识(原书第10版)','Cay S. Horstmann','周立新&陈波&叶乃文&邝劲筠&杜永萍','Java 编程 计算机',0,6,'本书由拥有20多年教学与研究经验的资深Java技术专家撰写（获Jolt大奖），是程序员的优选Java指南。本版针对Java SE 9、10和 11全面更新。','WEB-INF/book/Java核心技术卷I基础知识(原书第10版).pdf','static/picture/cover/Java核心技术卷I基础知识(原书第10版).png','bear','2022-03-22'),(7,'Thing in Java(Fourth Edition)','Bruce Eckel','','Java 编程 计算机',2,3,'本书赢得了全球程序员的广泛赞誉，即使是最晦涩的概念，在Bruce Eckel的文字亲和力和小而直接的编程示例面前也会化解于无形。从Java的基础语法到最高级特性（深入的面向对象概念、多线程、自动项目构建、单元测试和调试等），本书都能逐步指导你轻松掌握。','WEB-INF/book/Thing in Java(Fourth Edition).pdf','static/picture/cover/Thing in Java(Fourth Edition).png','bear','2022-03-22'),(8,'深入理解Java虚拟机JVM高级特性与最佳实践','周志明','','Java JVM 虚拟机 计算机',0,7,'这是一部从工作原理和工程实践两个维度深入剖析JVM的著作，是计算机领域公认的经典，繁体版在台湾也颇受欢迎。自2011年上市以来，前两个版本累计印刷36次，销量超过30万册，两家主要网络书店的评论近90000条，内容上近乎零差评，是原创计算机图书领域不可逾越的丰碑。','WEB-INF/book/深入理解Java虚拟机JVM高级特性与最佳实践.pdf','static/picture/cover/深入理解Java虚拟机JVM高级特性与最佳实践.png','bear','2022-03-22'),(9,'鸟哥的Linux私房菜-基础篇(第四版)','鸟哥','','Linux 操作系统',0,4,'本书是知名度颇高的Linux入门书《鸟哥的Linux私房菜基础学习篇》的新版，全面而详细地介绍了Linux操作系统。','WEB-INF/book/鸟哥的Linux私房菜-基础篇(第四版).pdf','static/picture/cover/鸟哥的Linux私房菜-基础篇(第四版).png','bear','2022-03-23'),(17,'12','12','12','12',0,0,'12','WEB-INF/book/Java核心技术卷I基础知识(原书第10版).pdf','static/picture/cover/Java核心技术卷I基础知识(原书第10版).png','bear','2022-03-28'),(18,'11','11','11','11',0,0,'11','WEB-INF/book/Java开发手册(嵩山版).pdf','static/picture/cover/Java开发手册(嵩山版).png','bear','2022-03-28'),(19,'123','123','123','123',0,0,'123','WEB-INF/book/Java并发编程的艺术.pdf','static/picture/cover/Java并发编程的艺术.png','bear','2022-03-28'),(20,'Head First Java','admin','张然','Java 编程语言',0,0,'本书赢得了全球程序员的广泛赞誉，即使是最晦涩的概念，在Bruce Eckel的文字亲和力和小而直接的编程示例面前也会化解于无形。从Java的基础语法到最高级特性（深入的面向对象概念、多线程、自动项目构建、单元测试和调试等），本书都能逐步指导你轻松掌握。','WEB-INF/book/_1-20220328094544.pdf','static/picture/cover/_1-20220328094544.png','Snake','2022-03-28'),(21,'123','123','123','123',0,0,'123','WEB-INF/book/_1-20220328094544.pdf','static/picture/cover/_1-20220328094544.png','Snake','2022-03-28'),(22,'111','111','111','111',0,0,'111','WEB-INF/book/_1-20220328094544.pdf','static/picture/cover/_1-20220328094544.png','Snake','2022-03-28'),(23,'55555','5555','55555','55555',0,0,'55555','WEB-INF/book/_1-20220328100122.pdf','static/picture/cover/_1-20220328100122.png','Snake','2022-03-28'),(24,'55555','555555','55555','5555',0,0,'5555','WEB-INF/book/_1-20220328100122.pdf','static/picture/cover/_1-20220328100122.png','Snake','2022-03-28'),(25,'qwe','qwe','qe','qweq',0,0,'qe','WEB-INF/book/Thing in Java(Fourth Edition).pdf','static/picture/cover/Thing in Java(Fourth Edition).png','Snake','2022-03-28');
/*!40000 ALTER TABLE `t_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_download`
--

DROP TABLE IF EXISTS `t_download`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_download` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '下载记录 id',
  `user_id` int NOT NULL COMMENT '用户 id',
  `operation` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作：下载图书',
  `score_change` char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '积分变化：-10',
  `time` timestamp NOT NULL COMMENT '下载时间',
  `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '下载图书书名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_download`
--

LOCK TABLES `t_download` WRITE;
/*!40000 ALTER TABLE `t_download` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_download` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `update_user_downloads_when_user_download_insert` AFTER INSERT ON `t_download` FOR EACH ROW BEGIN
    UPDATE t_user_info SET downloads = downloads + 1 WHERE user_id = new.user_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `t_favorite`
--

DROP TABLE IF EXISTS `t_favorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_favorite` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '收藏记录 id',
  `user_id` int NOT NULL COMMENT '用户 id',
  `book_id` int NOT NULL COMMENT '图书 id',
  `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '书名',
  `author` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '作者',
  `cover_path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图书封面路径',
  `collect_time` timestamp NOT NULL COMMENT '收藏时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_favorite`
--

LOCK TABLES `t_favorite` WRITE;
/*!40000 ALTER TABLE `t_favorite` DISABLE KEYS */;
INSERT INTO `t_favorite` VALUES (1,2,2,'Java开发手册(嵩山版)','阿里巴巴','static/picture/cover/Java开发手册(嵩山版).png','2022-03-26 18:50:57'),(3,2,4,'Java并发编程的艺术','方腾飞','static/picture/cover/Java并发编程的艺术.png','2022-03-26 22:03:23'),(4,1,2,'Java开发手册(嵩山版)','阿里巴巴','static/picture/cover/Java开发手册(嵩山版).png','2022-03-27 17:52:08'),(5,1,-1,'','','','2022-03-27 17:52:12'),(6,1,6,'Java核心技术卷I基础知识(原书第10版)','Cay S. Horstmann','static/picture/cover/Java核心技术卷I基础知识(原书第10版).png','2022-03-27 17:52:15');
/*!40000 ALTER TABLE `t_favorite` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `update_user_favorites_when_favorite_insert` AFTER INSERT ON `t_favorite` FOR EACH ROW BEGIN
    UPDATE t_user_info SET collections = (SELECT COUNT(*) FROM t_favorite WHERE user_id=new.user_id );
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `update_user_favorites_when_favorite_delete` AFTER DELETE ON `t_favorite` FOR EACH ROW BEGIN
    UPDATE t_user_info SET collections = (SELECT COUNT(*) FROM t_favorite WHERE user_id=old.user_id );
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `t_pixabay`
--

DROP TABLE IF EXISTS `t_pixabay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_pixabay` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '图片 id',
  `condition` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '检索条件',
  `tags` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '标签',
  `views` int DEFAULT NULL COMMENT '浏览量',
  `downloads` int DEFAULT NULL COMMENT '下载量',
  `collections` int DEFAULT NULL COMMENT '收藏量',
  `likes` int DEFAULT NULL COMMENT '点赞量',
  `comments` int DEFAULT NULL COMMENT '评论量',
  `add_time` date DEFAULT NULL COMMENT '添加时间',
  `large_image_url` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '图片访问地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pixabay`
--

LOCK TABLES `t_pixabay` WRITE;
/*!40000 ALTER TABLE `t_pixabay` DISABLE KEYS */;

/*!40000 ALTER TABLE `t_pixabay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_upload`
--

DROP TABLE IF EXISTS `t_upload`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_upload` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '上传记录 id',
  `user_id` int NOT NULL COMMENT '用户 id',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `operation` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作：上传图书',
  `score_change` char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '积分变化：+10',
  `time` timestamp NOT NULL COMMENT '上传时间',
  `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '上传图书书名',
  `book_path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图书保存路径',
  `cover_path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '封面保存路径',
  `state` char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '该条上传记录状态：已处理或未处理',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_upload`
--

LOCK TABLES `t_upload` WRITE;
/*!40000 ALTER TABLE `t_upload` DISABLE KEYS */;
INSERT INTO `t_upload` VALUES (26,1,'Snake','上传图书','+10','2022-03-27 17:45:44','Head First Java(第2版).pdf','/WEB-INF/upload/1-20220328094544.pdf','/WEB-INF/upload/1-20220328094544.png','已处理'),(27,1,'Snake','上传图书','+10','2022-03-27 17:53:16','_1-20220328094544.pdf','/WEB-INF/upload/1-20220328095316.pdf','/WEB-INF/upload/1-20220328095316.png','已处理'),(28,1,'Snake','上传图书','+10','2022-03-27 18:01:22','Java编程思想(第4版).pdf','/WEB-INF/upload/1-20220328100122.pdf','/WEB-INF/upload/1-20220328100122.png','已处理'),(29,1,'Snake','上传图书','+10','2022-03-27 18:06:27','Thing in Java(Fourth Edition).pdf','/WEB-INF/upload/1-20220328100627.pdf','/WEB-INF/upload/1-20220328100627.png','已处理');
/*!40000 ALTER TABLE `t_upload` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `update_user_uploads_when_user_upload_insert` AFTER INSERT ON `t_upload` FOR EACH ROW BEGIN
    UPDATE t_user_info SET uploads = uploads + 1 WHERE user_id = new.user_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户 id',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `email` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮箱地址',
  `score` int NOT NULL COMMENT '积分',
  `portrait_path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '头像保存路径',
  `register_date` date NOT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_username` (`username`),
  UNIQUE KEY `uniq_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'Snake','123','123@123.com',30,'static/picture/portrait/1.png','2022-03-26'),(2,'bear','bear','springbear2020@163.com',10040,'static/picture/portrait/2.png','2022-03-26');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `add_user_id_into_user_info_when_user_insert` AFTER INSERT ON `t_user` FOR EACH ROW BEGIN
    INSERT INTO t_user_info (user_id) VALUES (new.id);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `t_user_info`
--

DROP TABLE IF EXISTS `t_user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户信息 id',
  `user_id` int NOT NULL COMMENT '用户名',
  `nickname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户昵称',
  `sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '性别',
  `birth` date DEFAULT NULL COMMENT '出生年月',
  `location` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所在地区',
  `signature` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '个性签名',
  `collections` int NOT NULL DEFAULT '0' COMMENT '图书收藏量：新用户注册默认为0',
  `uploads` int NOT NULL DEFAULT '0' COMMENT '图书上传量：新用户注册默认为0',
  `downloads` int NOT NULL DEFAULT '0' COMMENT '图书下载量：新用户注册默认为0',
  `last_update_time` date DEFAULT NULL COMMENT '资料上次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_info`
--

LOCK TABLES `t_user_info` WRITE;
/*!40000 ALTER TABLE `t_user_info` DISABLE KEYS */;
INSERT INTO `t_user_info` VALUES (1,1,'hyl','保密','2022-03-07','湖北省武汉市','我永远喜欢恋恋',3,5,1,'2022-03-26'),(2,2,'Spring-_-Bear','男','2000-06-15','贵州省/贵阳市','人生如逆旅，我亦是行人',3,34,4,'2022-03-26');
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

-- Dump completed on 2022-03-28 16:39:59
