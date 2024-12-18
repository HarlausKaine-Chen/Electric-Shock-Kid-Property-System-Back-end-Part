-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: hostel
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hostel_apply`
--

DROP TABLE IF EXISTS `hostel_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hostel_apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) DEFAULT NULL COMMENT '学生ID',
  `hostel_no` varchar(100) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '宿舍编号',
  `apply_type` varchar(10) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '申请类别',
  `apply_pro` varchar(10) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '申请进度',
  `crt_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
  `apply_txt` varchar(2000) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '申请描述',
  `name` varchar(100) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '学生姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_estonian_ci COMMENT='宿舍申请/退宿信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hostel_apply`
--

LOCK TABLES `hostel_apply` WRITE;
/*!40000 ALTER TABLE `hostel_apply` DISABLE KEYS */;
INSERT INTO `hostel_apply` VALUES (2,2,'002','申请','审核通过','2024-11-26 14:43:08','test123','学生3'),(4,2,'002','退宿','审核通过','2024-11-27 09:44:57','test','学生3'),(5,2,'002','申请','审核不通过','2024-11-27 12:32:26','test123','学生3'),(6,2,'002','申请','审核通过','2024-11-28 06:59:56','住宿申请','学生3'),(7,2,'002','退宿','审核通过','2024-11-28 12:48:43','退宿申请','学生1');
/*!40000 ALTER TABLE `hostel_apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hostel_info`
--

DROP TABLE IF EXISTS `hostel_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hostel_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hostel_no` varchar(100) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '宿舍编号',
  `hostel_name` varchar(100) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '宿舍名称',
  `crt_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `num` varchar(10) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '可容纳人数',
  `c1` int(11) DEFAULT NULL COMMENT '床1',
  `c2` int(11) DEFAULT NULL COMMENT '床2',
  `c3` int(11) DEFAULT NULL COMMENT '床3',
  `c4` int(11) DEFAULT NULL COMMENT '床4',
  `c5` int(11) DEFAULT NULL COMMENT '床5',
  `c6` int(11) DEFAULT NULL COMMENT '床6',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_estonian_ci COMMENT='宿舍信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hostel_info`
--

LOCK TABLES `hostel_info` WRITE;
/*!40000 ALTER TABLE `hostel_info` DISABLE KEYS */;
INSERT INTO `hostel_info` VALUES (2,'002','002','2024-11-26 01:08:47','5',0,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `hostel_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_info`
--

DROP TABLE IF EXISTS `message_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `message_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `send_id` int(11) DEFAULT NULL COMMENT '发送者ID',
  `accpet_id` int(11) DEFAULT NULL COMMENT '接受者ID',
  `crt_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `content` varchar(1000) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_estonian_ci COMMENT='消息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_info`
--

LOCK TABLES `message_info` WRITE;
/*!40000 ALTER TABLE `message_info` DISABLE KEYS */;
INSERT INTO `message_info` VALUES (1,1,1,'2024-11-28 06:58:40','宿舍编号：002宿舍的3月费用已缴纳'),(2,2,1,'2024-11-28 07:04:56','宿舍编号：002宿舍的4月费用已缴纳'),(3,2,1,'2024-11-28 12:49:04','宿舍编号：002宿舍的5月费用已缴纳'),(4,2,8,'2024-11-28 12:49:04','宿舍编号：002宿舍的5月费用已缴纳'),(5,2,1,'2024-11-28 12:49:25','学生1提了一份报修内容，请到报修登记和进度查询功能查看详细信息'),(6,2,8,'2024-11-28 12:49:25','学生1提了一份报修内容，请到报修登记和进度查询功能查看详细信息'),(7,1,2,'2024-11-28 12:50:03','学生1:您提的报修信息已更新进度为处理中'),(8,1,2,'2024-11-28 12:50:10','学生1:您提的报修信息已更新进度为处理完成'),(9,1,1,'2024-11-28 12:52:03','宿舍编号：002宿舍的6月费用已缴纳'),(10,1,8,'2024-11-28 12:52:03','宿舍编号：002宿舍的6月费用已缴纳');
/*!40000 ALTER TABLE `message_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice_info`
--

DROP TABLE IF EXISTS `notice_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `notice_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext COLLATE utf8_estonian_ci COMMENT '内容',
  `release_date` varchar(100) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '发布日期',
  `title` varchar(200) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '标题',
  `crt_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_estonian_ci COMMENT='公告信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice_info`
--

LOCK TABLES `notice_info` WRITE;
/*!40000 ALTER TABLE `notice_info` DISABLE KEYS */;
INSERT INTO `notice_info` VALUES (1,'<p>sadasdsad<img src=\"http://localhost:8090/hostel/upload/1732715122807.jpg\"></p><p>sadasdsadsa</p>','2024-11-27','test','2024-11-27 13:46:12'),(2,'<p>真的测试吗？</p>','2024-11-28','作为测试用','2024-11-28 12:50:48');
/*!40000 ALTER TABLE `notice_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repair_info`
--

DROP TABLE IF EXISTS `repair_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `repair_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `repair_text` varchar(1000) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '报修内容',
  `user_id` int(11) DEFAULT NULL COMMENT '学生ID',
  `repair_pro` varchar(20) CHARACTER SET utf8 COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '报修进度:待处理 处理中 处理完成',
  `crt_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `name` varchar(100) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '学生姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_estonian_ci COMMENT='报修信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repair_info`
--

LOCK TABLES `repair_info` WRITE;
/*!40000 ALTER TABLE `repair_info` DISABLE KEYS */;
INSERT INTO `repair_info` VALUES (1,'报修测试123',1,'处理完成','2024-11-27 13:01:05','领导'),(2,'学生报修测试123',2,'处理中','2024-11-27 13:04:58','学生3'),(3,'001宿舍水龙头坏了',2,'处理完成','2024-11-28 12:49:25','学生1');
/*!40000 ALTER TABLE `repair_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (4,1,'ld','user','领导','6v4r6ni9p9lpndjql8pyfake10rcjge0','2024-11-22 07:10:16','2024-11-28 13:53:00'),(5,2,'xs1','user','学生','8xveywwg1uriby4qmjchyhgxnfru32ov','2024-11-25 07:48:13','2024-11-29 04:00:04'),(6,3,'xs2','user','学生','3ss1tusr6ifhsom70y50fu4ydip3bpgo','2024-11-25 08:19:37','2024-11-25 09:19:38'),(7,8,'sg01','user','宿管','hqbhtbjed6is2wrphhgfzfs02rvm50tl','2024-11-28 12:47:08','2024-11-28 13:47:08');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(100) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '账号',
  `password` varchar(100) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '密码',
  `name` varchar(100) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '用户姓名',
  `phone` varchar(100) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '手机号',
  `crt_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `up_time` varchar(100) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '更新时间',
  `user_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '用户类型：学生\\宿管 \\领导',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_estonian_ci COMMENT='用户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (1,'ld','ld','领导','13330033003','2024-11-19 01:19:31',NULL,'领导'),(2,'xs1','xs1','学生1','13310011001','2024-11-25 07:45:10','2024-11-28 20:47:47.83','学生'),(3,'xs2','xs2','学生2','15010011001','2024-11-25 08:13:34','2024-11-25 16:19:29.661','学生'),(8,'sg01','sg01','宿管01','13010011001','2024-11-28 07:45:02','2024-11-28 15:48:21.451','宿管');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `we_fees`
--

DROP TABLE IF EXISTS `we_fees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `we_fees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `water_fee` varchar(100) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '水费',
  `electricity_fee` varchar(100) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '电费',
  `hostel_no` varchar(100) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '宿舍编号',
  `crt_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `month` varchar(2) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '月份',
  `is_pay` char(1) CHARACTER SET utf8 COLLATE utf8_estonian_ci DEFAULT '0' COMMENT '是否支付 0-未支付 1-已支付',
  `paydate` varchar(100) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '缴费日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_estonian_ci COMMENT='水电费';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `we_fees`
--

LOCK TABLES `we_fees` WRITE;
/*!40000 ALTER TABLE `we_fees` DISABLE KEYS */;
INSERT INTO `we_fees` VALUES (2,'30','100','002','2024-11-26 02:57:12','1','1','2024-11-26'),(3,'35','56','002','2024-11-28 02:59:20','2','1','2024-11-28'),(4,'65','105','002','2024-11-28 02:59:37','3','1','2024-11-28'),(5,'30','57','002','2024-11-28 02:59:48','4','1','2024-11-28'),(6,'56','101','002','2024-11-28 03:00:00','5','1','2024-11-28'),(7,'67','121','002','2024-11-28 03:00:19','6','1','2024-11-28'),(8,'33','77','002','2024-11-28 03:00:32','7','0',NULL),(9,'12','45','002','2024-11-28 03:00:50','8','0',NULL),(10,'35','80','002','2024-11-28 03:01:03','9','0',NULL),(11,'35','80','002','2024-11-28 03:01:16','10','0',NULL),(12,'45','90','002','2024-11-28 03:01:27','11','0',NULL);
/*!40000 ALTER TABLE `we_fees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'hostel'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-29 12:24:59
