CREATE DATABASE  IF NOT EXISTS `test_oauth2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test_oauth2`;
-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: localhost    Database: test_oauth2
-- ------------------------------------------------------
-- Server version	5.7.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (27),(27),(27);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_permission`
--

DROP TABLE IF EXISTS `sys_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `version` bigint(20) DEFAULT NULL,
  `available` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `resource_type` enum('menu','button') DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq4uf7xhrxa5dnbpf4a47rqvha` (`parent_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_permission`
--

LOCK TABLES `sys_permission` WRITE;
/*!40000 ALTER TABLE `sys_permission` DISABLE KEYS */;
INSERT INTO `sys_permission` VALUES (4,'2020-03-14 11:27:42','2020-03-14 11:51:53',1,_binary '','显示用户','sys:user:show','menu','/userList',NULL),(5,'2020-03-14 11:35:17','2020-03-29 14:21:53',1,_binary '','修改用户','sys:user:update','menu','/userMod',4),(6,'2020-03-14 11:35:17','2020-03-29 14:41:05',1,_binary '','删除用户','sys:user:delete','menu','/userDelete',4),(7,'2020-03-14 11:35:17','2020-03-29 14:42:31',1,_binary '','添加用户','sys:user:add','menu','/userAdd',4);
/*!40000 ALTER TABLE `sys_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_permission_sys_role_list`
--

DROP TABLE IF EXISTS `sys_permission_sys_role_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_permission_sys_role_list` (
  `permissions_id` bigint(20) NOT NULL,
  `sys_role_list_role_id` bigint(20) NOT NULL,
  `authorities_id` bigint(20) NOT NULL,
  KEY `FK8wbt5ns0p3a7kyuitlbatc822` (`authorities_id`),
  KEY `FK5dc9gsqxj5029kdwc7twoavx7` (`sys_role_list_role_id`),
  KEY `FKljcq58fe14r1njsq70d7am83e` (`permissions_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_permission_sys_role_list`
--

LOCK TABLES `sys_permission_sys_role_list` WRITE;
/*!40000 ALTER TABLE `sys_permission_sys_role_list` DISABLE KEYS */;
INSERT INTO `sys_permission_sys_role_list` VALUES (4,2,0),(5,2,0),(6,2,0),(7,2,0);
/*!40000 ALTER TABLE `sys_permission_sys_role_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL,
  `available` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,_binary '','游客角色','ROLE_USER',0),(2,_binary '','管理员角色','ROLE_ADMIN',0),(11,_binary '','guest','ROLE_GUEST',0),(21,_binary '','sdf','ROLE_TEST67',0),(23,_binary '','eret','ROLE_TEST67rer',0),(24,_binary '','ertret','ROLE_TESTerert',0),(25,_binary '','sdfsdfsdf','ROLE_TEST',0),(26,_binary '','45646','ROLE_TEST454',0);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_info` (
  `role_id` bigint(20) NOT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `state` tinyint(4) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (3,'admin','$2a$10$MfMEeGjcCePIthDWVcFPqOBqM13fx7MzfV2aDCjiYndduVLvZs//2','ca4e50ed-e0bf-4e48-a37b-e21b7a19a981',1,'admin'),(1,'user','$2a$10$MfMEeGjcCePIthDWVcFPqOBqM13fx7MzfV2aDCjiYndduVLvZs//2','ca4e50ed-e0bf-4e48-a37b-e21b7a19a981',1,'user');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info_sys_role_list`
--

DROP TABLE IF EXISTS `user_info_sys_role_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_info_sys_role_list` (
  `user_info_list_role_id` bigint(20) NOT NULL,
  `sys_role_list_role_id` bigint(20) NOT NULL,
  KEY `FK17cglkws8bk7b71f6r692ig9d` (`sys_role_list_role_id`),
  KEY `FK3gteuo9ukvr8viv1g6lvd6mmt` (`user_info_list_role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info_sys_role_list`
--

LOCK TABLES `user_info_sys_role_list` WRITE;
/*!40000 ALTER TABLE `user_info_sys_role_list` DISABLE KEYS */;
INSERT INTO `user_info_sys_role_list` VALUES (3,2);
/*!40000 ALTER TABLE `user_info_sys_role_list` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-30 17:48:13
