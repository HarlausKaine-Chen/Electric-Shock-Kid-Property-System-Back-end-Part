-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: springboot003ds
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `baoxiuxinxi`
--

DROP TABLE IF EXISTS `baoxiuxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baoxiuxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `baoxiubianhao` varchar(200) NOT NULL COMMENT '报修编号',
  `gerenzhanghao` varchar(200) DEFAULT NULL COMMENT '个人账号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `menpaihao` varchar(200) DEFAULT NULL COMMENT '门牌号',
  `loufangmingcheng` varchar(200) DEFAULT NULL COMMENT '楼房名称',
  `loufangweizhi` varchar(200) DEFAULT NULL COMMENT '楼房位置',
  `baoxiuleixing` varchar(200) DEFAULT NULL COMMENT '报修类型',
  `baoxiuneirong` longtext COMMENT '报修内容',
  `shenqingriqi` date DEFAULT NULL COMMENT '申请日期',
  `sfsh` varchar(200) DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  PRIMARY KEY (`id`),
  UNIQUE KEY `baoxiubianhao` (`baoxiubianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1616406603768 DEFAULT CHARSET=utf8 COMMENT='报修信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baoxiuxinxi`
--

LOCK TABLES `baoxiuxinxi` WRITE;
/*!40000 ALTER TABLE `baoxiuxinxi` DISABLE KEYS */;
INSERT INTO `baoxiuxinxi` VALUES (61,'2021-03-22 09:33:07','报修编号1','个人账号1','姓名1','门牌号1','楼房名称1','楼房位置1','报修类型1','报修内容1','2021-03-22','是',''),(62,'2021-03-22 09:33:07','报修编号2','个人账号2','姓名2','门牌号2','楼房名称2','楼房位置2','报修类型2','报修内容2','2021-03-22','是',''),(63,'2021-03-22 09:33:07','报修编号3','个人账号3','姓名3','门牌号3','楼房名称3','楼房位置3','报修类型3','报修内容3','2021-03-22','是',''),(64,'2021-03-22 09:33:07','报修编号4','个人账号4','姓名4','门牌号4','楼房名称4','楼房位置4','报修类型4','报修内容4','2021-03-22','是',''),(65,'2021-03-22 09:33:07','报修编号5','个人账号5','姓名5','门牌号5','楼房名称5','楼房位置5','报修类型5','报修内容5','2021-03-22','是',''),(66,'2021-03-22 09:33:07','报修编号6','个人账号6','姓名6','门牌号6','楼房名称6','楼房位置6','报修类型6','报修内容6','2021-03-22','是',''),(1616406603767,'2021-03-22 09:50:02','1616406485333','11','韩美','1204房','楼房名称2','楼房位置2','水电维修','水管漏水','2021-04-10','是','马上过去处理');
/*!40000 ALTER TABLE `baoxiuxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bumenxinxi`
--

DROP TABLE IF EXISTS `bumenxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bumenxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `bumenmingcheng` varchar(200) NOT NULL COMMENT '部门名称',
  `fuzeren` varchar(200) NOT NULL COMMENT '负责人',
  `weizhi` varchar(200) DEFAULT NULL COMMENT '位置',
  `chuangjianriqi` date DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1616406815108 DEFAULT CHARSET=utf8 COMMENT='部门信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bumenxinxi`
--

LOCK TABLES `bumenxinxi` WRITE;
/*!40000 ALTER TABLE `bumenxinxi` DISABLE KEYS */;
INSERT INTO `bumenxinxi` VALUES (111,'2021-03-22 09:33:07','部门名称1','负责人1','位置1','2021-03-22'),(112,'2021-03-22 09:33:07','部门名称2','负责人2','位置2','2021-03-22'),(113,'2021-03-22 09:33:07','部门名称3','负责人3','位置3','2021-03-22'),(114,'2021-03-22 09:33:07','部门名称4','负责人4','位置4','2021-03-22'),(115,'2021-03-22 09:33:07','部门名称5','负责人5','位置5','2021-03-22'),(116,'2021-03-22 09:33:07','部门名称6','负责人6','位置6','2021-03-22'),(1616406815107,'2021-03-22 09:53:34','维修部','安安','管理处一楼','2021-04-10');
/*!40000 ALTER TABLE `bumenxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cheweixinxi`
--

DROP TABLE IF EXISTS `cheweixinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cheweixinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `cheweibianhao` varchar(200) NOT NULL COMMENT '编号',
  `cheweimingcheng` varchar(200) NOT NULL COMMENT '名称',
  `dizhi` varchar(200) DEFAULT NULL COMMENT '地址',
  `zhuangtai` varchar(200) DEFAULT NULL COMMENT '状态',
  `faburiqi` date DEFAULT NULL COMMENT '发布日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `cheweibianhao` (`cheweibianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1616406565208 DEFAULT CHARSET=utf8 COMMENT='信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cheweixinxi`
--

LOCK TABLES `cheweixinxi` WRITE;
/*!40000 ALTER TABLE `cheweixinxi` DISABLE KEYS */;
INSERT INTO `cheweixinxi` VALUES (71,'2021-03-22 09:33:07','编号1','名称1','地址1','可停','2021-03-22'),(72,'2021-03-22 09:33:07','编号2','名称2','地址2','可停','2021-03-22'),(73,'2021-03-22 09:33:07','编号3','名称3','地址3','可停','2021-03-22'),(74,'2021-03-22 09:33:07','编号4','名称4','地址4','可停','2021-03-22'),(75,'2021-03-22 09:33:07','编号5','名称5','地址5','可停','2021-03-22'),(76,'2021-03-22 09:33:07','编号6','名称6','地址6','可停','2021-03-22'),(1616406565207,'2021-03-22 09:49:25','001','高档','地下一层','可停','2021-04-10');
/*!40000 ALTER TABLE `cheweixinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','http://localhost:8080/springboot003ds/upload/picture1.jpg'),(2,'picture2','http://localhost:8080/springboot003ds/upload/picture2.jpg'),(3,'picture3','http://localhost:8080/springboot003ds/upload/picture3.jpg'),(6,'homepage',NULL);
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feiyongxinxi`
--

DROP TABLE IF EXISTS `feiyongxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feiyongxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `feiyongbianhao` varchar(200) NOT NULL COMMENT '费用编号',
  `feiyongmingcheng` varchar(200) NOT NULL COMMENT '费用名称',
  `jine` int(11) DEFAULT NULL COMMENT '金额',
  `gerenzhanghao` varchar(200) DEFAULT NULL COMMENT '个人账号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `menpaihao` varchar(200) DEFAULT NULL COMMENT '门牌号',
  `loufangmingcheng` varchar(200) DEFAULT NULL COMMENT '楼房名称',
  `faburiqi` date DEFAULT NULL COMMENT '发布日期',
  `ispay` varchar(200) DEFAULT '未支付' COMMENT '是否支付',
  PRIMARY KEY (`id`),
  UNIQUE KEY `feiyongbianhao` (`feiyongbianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1616406492754 DEFAULT CHARSET=utf8 COMMENT='费用信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feiyongxinxi`
--

LOCK TABLES `feiyongxinxi` WRITE;
/*!40000 ALTER TABLE `feiyongxinxi` DISABLE KEYS */;
INSERT INTO `feiyongxinxi` VALUES (41,'2021-03-22 09:33:07','费用编号1','费用名称1',1,'个人账号1','姓名1','性别1','门牌号1','楼房名称1','2021-03-22','未支付'),(42,'2021-03-22 09:33:07','费用编号2','费用名称2',2,'个人账号2','姓名2','性别2','门牌号2','楼房名称2','2021-03-22','未支付'),(43,'2021-03-22 09:33:07','费用编号3','费用名称3',3,'个人账号3','姓名3','性别3','门牌号3','楼房名称3','2021-03-22','未支付'),(44,'2021-03-22 09:33:07','费用编号4','费用名称4',4,'个人账号4','姓名4','性别4','门牌号4','楼房名称4','2021-03-22','未支付'),(45,'2021-03-22 09:33:07','费用编号5','费用名称5',5,'个人账号5','姓名5','性别5','门牌号5','楼房名称5','2021-03-22','未支付'),(46,'2021-03-22 09:33:07','费用编号6','费用名称6',6,'个人账号6','姓名6','性别6','门牌号6','楼房名称6','2021-03-22','未支付'),(1616406492753,'2021-03-22 09:48:12','1616406386775','管理费',200,'11','韩美','女','1204房','楼房名称2','2021-04-10','已支付');
/*!40000 ALTER TABLE `feiyongxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gonggaoxinxi`
--

DROP TABLE IF EXISTS `gonggaoxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gonggaoxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gonggaobianhao` varchar(200) NOT NULL COMMENT '公告编号',
  `biaoti` varchar(200) NOT NULL COMMENT '标题',
  `gonggaoneirong` longtext COMMENT '公告内容',
  `xiangguantupian` varchar(200) DEFAULT NULL COMMENT '相关图片',
  `faburiqi` date DEFAULT NULL COMMENT '发布日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `gonggaobianhao` (`gonggaobianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1616406784686 DEFAULT CHARSET=utf8 COMMENT='公告信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gonggaoxinxi`
--

LOCK TABLES `gonggaoxinxi` WRITE;
/*!40000 ALTER TABLE `gonggaoxinxi` DISABLE KEYS */;
INSERT INTO `gonggaoxinxi` VALUES (101,'2021-03-22 09:33:07','公告编号1','标题1','公告内容1','http://localhost:8080/springboot003ds/upload/gonggaoxinxi_xiangguantupian1.jpg','2021-03-22'),(102,'2021-03-22 09:33:07','公告编号2','标题2','公告内容2','http://localhost:8080/springboot003ds/upload/gonggaoxinxi_xiangguantupian2.jpg','2021-03-22'),(103,'2021-03-22 09:33:07','公告编号3','标题3','公告内容3','http://localhost:8080/springboot003ds/upload/gonggaoxinxi_xiangguantupian3.jpg','2021-03-22'),(104,'2021-03-22 09:33:07','公告编号4','标题4','公告内容4','http://localhost:8080/springboot003ds/upload/gonggaoxinxi_xiangguantupian4.jpg','2021-03-22'),(105,'2021-03-22 09:33:07','公告编号5','标题5','公告内容5','http://localhost:8080/springboot003ds/upload/gonggaoxinxi_xiangguantupian5.jpg','2021-03-22'),(106,'2021-03-22 09:33:07','公告编号6','标题6','公告内容6','http://localhost:8080/springboot003ds/upload/gonggaoxinxi_xiangguantupian6.jpg','2021-03-22'),(1616406784685,'2021-03-22 09:53:04','1616406654360','小区杀虫','<p>小区近日会进行杀虫23232</p>','http://localhost:8080/springboot003ds/upload/1616406771057.jpg','2021-04-10');
/*!40000 ALTER TABLE `gonggaoxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loufangxinxi`
--

DROP TABLE IF EXISTS `loufangxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loufangxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xinxibianhao` varchar(200) NOT NULL COMMENT '信息编号',
  `loufangmingcheng` varchar(200) NOT NULL COMMENT '楼房名称',
  `loufangweizhi` varchar(200) DEFAULT NULL COMMENT '楼房位置',
  `loucengshu` int(11) DEFAULT NULL COMMENT '楼层数',
  `huxing` varchar(200) DEFAULT NULL COMMENT '户型',
  `huxingshuliang` int(11) DEFAULT NULL COMMENT '户型数量',
  `faburiqi` date DEFAULT NULL COMMENT '发布日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `xinxibianhao` (`xinxibianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1616406533223 DEFAULT CHARSET=utf8 COMMENT='楼房信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loufangxinxi`
--

LOCK TABLES `loufangxinxi` WRITE;
/*!40000 ALTER TABLE `loufangxinxi` DISABLE KEYS */;
INSERT INTO `loufangxinxi` VALUES (51,'2021-03-22 09:33:07','信息编号1','楼房名称1','楼房位置1',1,'户型1',1,'2021-03-22'),(52,'2021-03-22 09:33:07','信息编号2','楼房名称2','楼房位置2',2,'户型2',2,'2021-03-22'),(53,'2021-03-22 09:33:07','信息编号3','楼房名称3','楼房位置3',3,'户型3',3,'2021-03-22'),(54,'2021-03-22 09:33:07','信息编号4','楼房名称4','楼房位置4',4,'户型4',4,'2021-03-22'),(55,'2021-03-22 09:33:07','信息编号5','楼房名称5','楼房位置5',5,'户型5',5,'2021-03-22'),(56,'2021-03-22 09:33:07','信息编号6','楼房名称6','楼房位置6',6,'户型6',6,'2021-03-22'),(1616406533222,'2021-03-22 09:48:52','1616406406313','高档楼','市区内',24,'三房两厅',200,'2021-04-10');
/*!40000 ALTER TABLE `loufangxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tingchexinxi`
--

DROP TABLE IF EXISTS `tingchexinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tingchexinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `cheweimingcheng` varchar(200) DEFAULT NULL COMMENT '名称',
  `dizhi` varchar(200) DEFAULT NULL COMMENT '地址',
  `cheweibianhao` varchar(200) DEFAULT NULL COMMENT '编号',
  `zhuangtai` varchar(200) DEFAULT NULL COMMENT '状态',
  `faburiqi` varchar(200) DEFAULT NULL COMMENT '发布日期',
  `gerenzhanghao` varchar(200) DEFAULT NULL COMMENT '个人账号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `chepaihao` varchar(200) DEFAULT NULL COMMENT '车牌号',
  `shenqingriqi` date DEFAULT NULL COMMENT '申请日期',
  `sfsh` varchar(200) DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1616406627419 DEFAULT CHARSET=utf8 COMMENT='停车信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tingchexinxi`
--

LOCK TABLES `tingchexinxi` WRITE;
/*!40000 ALTER TABLE `tingchexinxi` DISABLE KEYS */;
INSERT INTO `tingchexinxi` VALUES (81,'2021-03-22 09:33:07','名称1','地址1','编号1','状态1','发布日期1','个人账号1','姓名1','车牌号1','2021-03-22','是',''),(82,'2021-03-22 09:33:07','名称2','地址2','编号2','状态2','发布日期2','个人账号2','姓名2','车牌号2','2021-03-22','是',''),(83,'2021-03-22 09:33:07','名称3','地址3','编号3','状态3','发布日期3','个人账号3','姓名3','车牌号3','2021-03-22','是',''),(84,'2021-03-22 09:33:07','名称4','地址4','编号4','状态4','发布日期4','个人账号4','姓名4','车牌号4','2021-03-22','是',''),(85,'2021-03-22 09:33:07','名称5','地址5','编号5','状态5','发布日期5','个人账号5','姓名5','车牌号5','2021-03-22','是',''),(86,'2021-03-22 09:33:07','名称6','地址6','编号6','状态6','发布日期6','个人账号6','姓名6','车牌号6','2021-03-22','是',''),(1616406627418,'2021-03-22 09:50:27','高档','地下一层','001','可停','2021-04-10','11','韩美','京A66666','2021-04-10','是','申请通过');
/*!40000 ALTER TABLE `tingchexinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,1616406360284,'11','yonghu','用户','t05xeiu8z7uq5namr1ibrv67a6d1o5al','2021-03-22 09:46:21','2021-03-22 10:54:14'),(2,1616406377115,'22','yuangong','员工','dyq3qrk52mzy8tc1r9irohbofqhs033t','2021-03-22 09:47:05','2021-03-22 10:54:37'),(3,1,'abo','users','管理员','majoytm0q62ro7eywh8htahx8q7icdel','2021-03-22 09:47:30','2021-03-22 10:51:28');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tousubianhao`
--

DROP TABLE IF EXISTS `tousubianhao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tousubianhao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `tousubianhao` varchar(200) NOT NULL COMMENT '投诉编号',
  `tousumingcheng` varchar(200) NOT NULL COMMENT '投诉名称',
  `tousuneirong` longtext COMMENT '投诉内容',
  `tousuriqi` date DEFAULT NULL COMMENT '投诉日期',
  `gerenzhanghao` varchar(200) DEFAULT NULL COMMENT '个人账号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `sfsh` varchar(200) DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tousubianhao` (`tousubianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1616406650093 DEFAULT CHARSET=utf8 COMMENT='投诉编号';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tousubianhao`
--

LOCK TABLES `tousubianhao` WRITE;
/*!40000 ALTER TABLE `tousubianhao` DISABLE KEYS */;
INSERT INTO `tousubianhao` VALUES (91,'2021-03-22 09:33:07','投诉编号1','投诉名称1','投诉内容1','2021-03-22','个人账号1','姓名1','是',''),(92,'2021-03-22 09:33:07','投诉编号2','投诉名称2','投诉内容2','2021-03-22','个人账号2','姓名2','是',''),(93,'2021-03-22 09:33:07','投诉编号3','投诉名称3','投诉内容3','2021-03-22','个人账号3','姓名3','是',''),(94,'2021-03-22 09:33:07','投诉编号4','投诉名称4','投诉内容4','2021-03-22','个人账号4','姓名4','是',''),(95,'2021-03-22 09:33:07','投诉编号5','投诉名称5','投诉内容5','2021-03-22','个人账号5','姓名5','是',''),(96,'2021-03-22 09:33:07','投诉编号6','投诉名称6','投诉内容6','2021-03-22','个人账号6','姓名6','是',''),(1616406650092,'2021-03-22 09:50:49','1616406536628','卫生没搞好','<p>大门口卫生没搞好23232322</p>','2021-04-10','11','韩美','是','马上安排');
/*!40000 ALTER TABLE `tousubianhao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'abo','abo','管理员','2021-03-22 09:33:07');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yezhuxinxi`
--

DROP TABLE IF EXISTS `yezhuxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yezhuxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gerenzhanghao` varchar(200) DEFAULT NULL COMMENT '个人账号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `leixing` varchar(200) DEFAULT NULL COMMENT '类型',
  `menpaihao` varchar(200) DEFAULT NULL COMMENT '门牌号',
  `loufangmingcheng` varchar(200) DEFAULT NULL COMMENT '楼房名称',
  `loufangweizhi` varchar(200) DEFAULT NULL COMMENT '楼房位置',
  `sfsh` varchar(200) DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1616406407653 DEFAULT CHARSET=utf8 COMMENT='业主信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yezhuxinxi`
--

LOCK TABLES `yezhuxinxi` WRITE;
/*!40000 ALTER TABLE `yezhuxinxi` DISABLE KEYS */;
INSERT INTO `yezhuxinxi` VALUES (31,'2021-03-22 09:33:07','个人账号1','姓名1','性别1','业主','门牌号1','楼房名称1','楼房位置1','是',''),(32,'2021-03-22 09:33:07','个人账号2','姓名2','性别2','业主','门牌号2','楼房名称2','楼房位置2','是',''),(33,'2021-03-22 09:33:07','个人账号3','姓名3','性别3','业主','门牌号3','楼房名称3','楼房位置3','是',''),(34,'2021-03-22 09:33:07','个人账号4','姓名4','性别4','业主','门牌号4','楼房名称4','楼房位置4','是',''),(35,'2021-03-22 09:33:07','个人账号5','姓名5','性别5','业主','门牌号5','楼房名称5','楼房位置5','是',''),(36,'2021-03-22 09:33:07','个人账号6','姓名6','性别6','业主','门牌号6','楼房名称6','楼房位置6','是',''),(1616406407652,'2021-03-22 09:46:47','11','韩美','女','业主','1204房','楼房名称2','楼房位置2','是','信息符合');
/*!40000 ALTER TABLE `yezhuxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yonghu`
--

DROP TABLE IF EXISTS `yonghu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yonghu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gerenzhanghao` varchar(200) NOT NULL COMMENT '个人账号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `xingming` varchar(200) NOT NULL COMMENT '姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `nianling` int(11) DEFAULT NULL COMMENT '年龄',
  `shenfenzhenghaoma` varchar(200) DEFAULT NULL COMMENT '身份证号码',
  `shoujihaoma` varchar(200) DEFAULT NULL COMMENT '手机号码',
  `chepaihao` varchar(200) DEFAULT NULL COMMENT '车牌号',
  `xiangpian` varchar(200) DEFAULT NULL COMMENT '相片',
  PRIMARY KEY (`id`),
  UNIQUE KEY `gerenzhanghao` (`gerenzhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=1616406360285 DEFAULT CHARSET=utf8 COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yonghu`
--

LOCK TABLES `yonghu` WRITE;
/*!40000 ALTER TABLE `yonghu` DISABLE KEYS */;
INSERT INTO `yonghu` VALUES (11,'2021-03-22 09:33:07','用户1','123456','姓名1','男',1,'440300199101010001','13823888881','车牌号1','http://localhost:8080/springboot003ds/upload/yonghu_xiangpian1.jpg'),(12,'2021-03-22 09:33:07','用户2','123456','姓名2','男',2,'440300199202020002','13823888882','车牌号2','http://localhost:8080/springboot003ds/upload/yonghu_xiangpian2.jpg'),(13,'2021-03-22 09:33:07','用户3','123456','姓名3','男',3,'440300199303030003','13823888883','车牌号3','http://localhost:8080/springboot003ds/upload/yonghu_xiangpian3.jpg'),(14,'2021-03-22 09:33:07','用户4','123456','姓名4','男',4,'440300199404040004','13823888884','车牌号4','http://localhost:8080/springboot003ds/upload/yonghu_xiangpian4.jpg'),(15,'2021-03-22 09:33:07','用户5','123456','姓名5','男',5,'440300199505050005','13823888885','车牌号5','http://localhost:8080/springboot003ds/upload/yonghu_xiangpian5.jpg'),(16,'2021-03-22 09:33:07','用户6','123456','姓名6','男',6,'440300199606060006','13823888886','车牌号6','http://localhost:8080/springboot003ds/upload/yonghu_xiangpian6.jpg'),(1616406360284,'2021-03-22 09:46:00','11','11','韩美','女',25,'225633333322563251','12566325421','京A66666','http://localhost:8080/springboot003ds/upload/1616406392169.png');
/*!40000 ALTER TABLE `yonghu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yuangong`
--

DROP TABLE IF EXISTS `yuangong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yuangong` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gonghao` varchar(200) NOT NULL COMMENT '工号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `yuangongxingming` varchar(200) NOT NULL COMMENT '员工姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `nianling` int(11) DEFAULT NULL COMMENT '年龄',
  `shenfenzhenghaoma` varchar(200) DEFAULT NULL COMMENT '身份证号码',
  `shoujihaoma` varchar(200) DEFAULT NULL COMMENT '手机号码',
  `xiangpian` varchar(200) DEFAULT NULL COMMENT '相片',
  `bumen` varchar(200) DEFAULT NULL COMMENT '部门',
  PRIMARY KEY (`id`),
  UNIQUE KEY `gonghao` (`gonghao`)
) ENGINE=InnoDB AUTO_INCREMENT=1616406377116 DEFAULT CHARSET=utf8 COMMENT='员工';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yuangong`
--

LOCK TABLES `yuangong` WRITE;
/*!40000 ALTER TABLE `yuangong` DISABLE KEYS */;
INSERT INTO `yuangong` VALUES (22,'2021-03-22 09:33:07','员工2','123456','员工姓名2','男',20,'440300199202020002','13823888882','http://localhost:8080/springboot003ds/upload/yuangong_xiangpian2.jpg','部门2'),(23,'2021-03-22 09:33:07','员工3','123456','员工姓名3','男',3,'440300199303030003','13823888883','http://localhost:8080/springboot003ds/upload/yuangong_xiangpian3.jpg','部门3'),(24,'2021-03-22 09:33:07','员工4','123456','员工姓名4','男',4,'440300199404040004','13823888884','http://localhost:8080/springboot003ds/upload/yuangong_xiangpian4.jpg','部门4'),(25,'2021-03-22 09:33:07','员工5','123456','员工姓名5','男',5,'440300199505050005','13823888885','http://localhost:8080/springboot003ds/upload/yuangong_xiangpian5.jpg','部门5'),(26,'2021-03-22 09:33:07','员工6','123456','员工姓名6','男',6,'440300199606060006','13823888886','http://localhost:8080/springboot003ds/upload/yuangong_xiangpian6.jpg','部门6'),(1616406377115,'2021-03-22 09:46:17','22','22','李明','男',30,'223666555412512630','12544785960','http://localhost:8080/springboot003ds/upload/1616406434383.png','部门名称2');
/*!40000 ALTER TABLE `yuangong` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-22 22:14:17
