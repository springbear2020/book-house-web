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
-- Table structure for table `t_book`
--

DROP TABLE IF EXISTS `t_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '书名',
  `author` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '作者',
  `translator` varchar(128) DEFAULT NULL COMMENT '译者',
  `keywords` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '关键词',
  `downloads` int NOT NULL DEFAULT '0' COMMENT '下载量',
  `collections` int NOT NULL DEFAULT '0' COMMENT '收藏量',
  `comment` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '评论',
  `book_path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图书保存路径',
  `cover_path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图书封面保存路径',
  `upload_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '上传用户名',
  `upload_time` date NOT NULL COMMENT '上传时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_book`
--

LOCK TABLES `t_book` WRITE;
/*!40000 ALTER TABLE `t_book` DISABLE KEYS */;
INSERT INTO `t_book` VALUES (1,'Java编程思想(第4版)','Bruce Eckel','陈昊鹏','Java 编程 计算机',0,0,'本书赢得了全球程序员的广泛赞誉，即使是最晦涩的概念，在Bruce Eckel的文字亲和力和小而直接的编程示例面前也会化解于无形。从Java的基础语法到最高级特性（深入的面向对象概念、多线程、自动项目构建、单元测试和调试等），本书都能逐步指导你轻松掌握。','WEB-INF/book/Java编程思想(第4版).pdf','static/picture/cover/Java编程思想(第4版).jpeg','bear','2022-03-22'),(2,'Java开发手册(嵩山版)','阿里巴巴','','Java 编程 规范',0,0,'Java开发手册来自万名阿里Java技术精英的经验总结，并经历了多次大规模一线实战检验及完善，铸就了这本高含金量的阿里Java开发手册。','WEB-INF/book/Java开发手册(嵩山版).pdf','static/picture/cover/Java开发手册(嵩山版).png','bear','2022-03-22'),(3,'Head First Java(第2版)','Kathy Sierra & Bert Bates','张然','Java 编程 计算机',0,0,'《HeadFirstJava》是一本完整地面向对象(object-oriented，OO)程序设计和Java的学习指导用书，根据学习理论所设计，你可以从程序语言的基础开始，到线程、网络与分布式程序等项目。','WEB-INF/book/Head First Java(第2版).pdf','static/picture/cover/Head First Java(第2版).jpg','bear','2022-03-22'),(4,'Java并发编程的艺术','方腾飞&魏鹏&程晓明','','Java 编程 计算机',0,0,'《Java并发编程的艺术》内容涵盖Java并发编程机制的底层实现原理、Java内存模型、Java并发编程基础、Java中的锁、并发容器和框架、原子类、并发工具类、线程池、Executor框架等主题，每个主题都做了深入的讲解，同时通过实例介绍了如何应用这些技术。','WEB-INF/book/Java并发编程的艺术.pdf','static/picture/cover/Java并发编程的艺术.png','bear','2022-03-22'),(5,'Java并发编程实战','Brian Goetz&Tim Peierls&Joshua Bloch&Joseph Bowbeer&David Holmes&Doug Lea','童云兰','Java 并发编程 计算机',0,0,'本书深入浅出地介绍了Java线程和并发，是一本完美的Java并发参考手册。书中从并发性和线程安全性的基本概念出发，介绍了如何使用类库提供的基本并发构建块，用于避免并发危险、构造线程安全的类及验证线程安全的规则，如何将小的线程安全类组合成更大的线程安全类，如何利用线程来提高并发应用程序的吞吐量，如何识别可并行执行的任务，如何提高单线程子系统的响应性，如何确保并发程序执行预期任务，如何提高并发代码的性能和可伸缩性等内容，最后介绍了一些高级主题，如显式锁、原子变量、非阻塞算法以及如何开发自定义的同步工具类。','WEB-INF/book/Java并发编程实战.pdf','static/picture/cover/Java并发编程实战.png','bear','2022-03-22'),(6,'Java核心技术卷I基础知识(原书第10版)','Cay S. Horstmann','周立新&陈波&叶乃文&邝劲筠&杜永萍','Java 编程 计算机',0,0,'本书由拥有20多年教学与研究经验的资深Java技术专家撰写（获Jolt大奖），是程序员的优选Java指南。本版针对Java SE 9、10和 11全面更新。','WEB-INF/book/Java核心技术卷I基础知识(原书第10版).pdf','static/picture/cover/Java核心技术卷I基础知识(原书第10版).png','bear','2022-03-22'),(7,'Thing in Java(Fourth Edition)','Bruce Eckel','','Java 编程 计算机',0,0,'本书赢得了全球程序员的广泛赞誉，即使是最晦涩的概念，在Bruce Eckel的文字亲和力和小而直接的编程示例面前也会化解于无形。从Java的基础语法到最高级特性（深入的面向对象概念、多线程、自动项目构建、单元测试和调试等），本书都能逐步指导你轻松掌握。','WEB-INF/book/Thing in Java(Fourth Edition).pdf','static/picture/cover/Thing in Java(Fourth Edition).png','bear','2022-03-22'),(8,'深入理解Java虚拟机JVM高级特性与最佳实践','周志明','','Java JVM 虚拟机 计算机',0,0,'这是一部从工作原理和工程实践两个维度深入剖析JVM的著作，是计算机领域公认的经典，繁体版在台湾也颇受欢迎。自2011年上市以来，前两个版本累计印刷36次，销量超过30万册，两家主要网络书店的评论近90000条，内容上近乎零差评，是原创计算机图书领域不可逾越的丰碑。','WEB-INF/book/深入理解Java虚拟机JVM高级特性与最佳实践.pdf','static/picture/cover/深入理解Java虚拟机JVM高级特性与最佳实践.png','bear','2022-03-22');
/*!40000 ALTER TABLE `t_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `email` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮箱地址',
  `score` int NOT NULL COMMENT '积分',
  `portrait_path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '头像地址',
  `register_date` date NOT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_username` (`username`),
  UNIQUE KEY `uniq_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'bear','bear','springbear2020@163.com',100,'static/picture/portrait/default.jpg','2022-03-22');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-22  9:25:07
