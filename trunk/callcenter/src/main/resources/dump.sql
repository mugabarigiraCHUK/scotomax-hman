-- MySQL dump 10.13  Distrib 5.1.34, for apple-darwin9.5.0 (i386)
--
-- Host: localhost    Database: apcontact
-- ------------------------------------------------------
-- Server version	5.5.11

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
-- Current Database: `apcontact`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `apcontact` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `apcontact`;

--
-- Table structure for table `acd_condition`
--

DROP TABLE IF EXISTS `acd_condition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acd_condition` (
  `condition_id` int(11) NOT NULL DEFAULT '0',
  `condition_name` varchar(50) NOT NULL DEFAULT '',
  `condition_description` varchar(100) NOT NULL DEFAULT '',
  `condition_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`condition_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acd_condition`
--

LOCK TABLES `acd_condition` WRITE;
/*!40000 ALTER TABLE `acd_condition` DISABLE KEYS */;
INSERT INTO `acd_condition` VALUES (1,'cond1','desc','2011-08-28 15:16:16'),(2,'cond2','test 22','2011-09-01 14:55:29');
/*!40000 ALTER TABLE `acd_condition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `acd_route`
--

DROP TABLE IF EXISTS `acd_route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acd_route` (
  `route_id` int(11) NOT NULL DEFAULT '0',
  `route_name` varchar(50) NOT NULL DEFAULT '',
  `route_description` varchar(100) DEFAULT '',
  `route_condition` int(11) NOT NULL DEFAULT '0',
  `route_caller` varchar(50) DEFAULT '',
  `route_called` varchar(50) DEFAULT '',
  `route_create_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `route_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`route_id`),
  KEY `acd_route_condition_fk` (`route_condition`),
  CONSTRAINT `acd_route_condition_fk` FOREIGN KEY (`route_condition`) REFERENCES `acd_condition` (`condition_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acd_route`
--

LOCK TABLES `acd_route` WRITE;
/*!40000 ALTER TABLE `acd_route` DISABLE KEYS */;
/*!40000 ALTER TABLE `acd_route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agent_level`
--

DROP TABLE IF EXISTS `agent_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agent_level` (
  `level_id` int(11) NOT NULL DEFAULT '0',
  `level_name` varchar(50) NOT NULL DEFAULT '',
  `level_description` varchar(100) DEFAULT '',
  `level_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`level_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent_level`
--

LOCK TABLES `agent_level` WRITE;
/*!40000 ALTER TABLE `agent_level` DISABLE KEYS */;
INSERT INTO `agent_level` VALUES (1,'high','hiso','2011-08-13 14:49:45');
/*!40000 ALTER TABLE `agent_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agent_profile`
--

DROP TABLE IF EXISTS `agent_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agent_profile` (
  `agent_id` int(11) NOT NULL DEFAULT '0',
  `supervisor_id` int(11) NOT NULL DEFAULT '0',
  `level_id` int(11) NOT NULL DEFAULT '0',
  `skill_id` int(11) NOT NULL DEFAULT '0',
  `status_id` int(11) NOT NULL DEFAULT '0',
  `workplan_id` int(11) NOT NULL DEFAULT '0',
  `agent_fullname` varchar(100) NOT NULL DEFAULT '',
  `agent_username` varchar(50) NOT NULL DEFAULT '',
  `agent_password` varchar(50) DEFAULT '',
  `agent_max_call` int(11) NOT NULL DEFAULT '0',
  `agent_allow_outbound` int(11) NOT NULL DEFAULT '0',
  `agent_create_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `agent_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`agent_id`),
  KEY `agent_profile_supervisor_fk` (`supervisor_id`),
  KEY `agent_profile_level_fk` (`level_id`),
  KEY `agent_profile_skill_fk` (`skill_id`),
  KEY `agent_profile_workplan_fk` (`workplan_id`),
  KEY `agent_profile_status_fk` (`status_id`),
  CONSTRAINT `agent_profile_level_fk` FOREIGN KEY (`level_id`) REFERENCES `agent_level` (`level_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `agent_profile_skill_fk` FOREIGN KEY (`skill_id`) REFERENCES `agent_skill` (`skill_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `agent_profile_status_fk` FOREIGN KEY (`status_id`) REFERENCES `agent_status` (`status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `agent_profile_supervisor_fk` FOREIGN KEY (`supervisor_id`) REFERENCES `agent_profile` (`agent_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `agent_profile_workplan_fk` FOREIGN KEY (`workplan_id`) REFERENCES `wkf_workplan` (`workplan_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent_profile`
--

LOCK TABLES `agent_profile` WRITE;
/*!40000 ALTER TABLE `agent_profile` DISABLE KEYS */;
/*!40000 ALTER TABLE `agent_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agent_script`
--

DROP TABLE IF EXISTS `agent_script`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agent_script` (
  `script_id` int(11) NOT NULL DEFAULT '0',
  `business_id` int(11) NOT NULL DEFAULT '0',
  `topic_id` int(11) NOT NULL DEFAULT '0',
  `script_name` varchar(50) NOT NULL DEFAULT '',
  `script_description` varchar(100) DEFAULT '',
  `script_step` int(11) NOT NULL DEFAULT '0',
  `script_message` varchar(1000) DEFAULT '',
  `script_create_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `script_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`script_id`),
  KEY `agent_script_business_fk` (`business_id`),
  KEY `agent_script_topic_fk` (`topic_id`),
  CONSTRAINT `agent_script_business_fk` FOREIGN KEY (`business_id`) REFERENCES `crm_business` (`business_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `agent_script_topic_fk` FOREIGN KEY (`topic_id`) REFERENCES `knw_topic` (`topic_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent_script`
--

LOCK TABLES `agent_script` WRITE;
/*!40000 ALTER TABLE `agent_script` DISABLE KEYS */;
/*!40000 ALTER TABLE `agent_script` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agent_seat`
--

DROP TABLE IF EXISTS `agent_seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agent_seat` (
  `seat_id` int(11) NOT NULL DEFAULT '0',
  `level_id` int(11) NOT NULL DEFAULT '0',
  `skill_id` int(11) NOT NULL DEFAULT '0',
  `status_id` int(11) NOT NULL DEFAULT '0',
  `seat_name` varchar(50) NOT NULL DEFAULT '',
  `seat_description` varchar(100) DEFAULT '',
  `seat_start_period` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `seat_end_period` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `seat_max_call` int(11) NOT NULL DEFAULT '0',
  `seat_allow_outbound` int(11) NOT NULL DEFAULT '0',
  `seat_create_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `seat_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`seat_id`),
  KEY `agent_seat_level_fk` (`level_id`),
  KEY `agent_seat_skill_fk` (`skill_id`),
  KEY `agent_seat_status_fk` (`status_id`),
  CONSTRAINT `agent_seat_level_fk` FOREIGN KEY (`level_id`) REFERENCES `agent_level` (`level_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `agent_seat_skill_fk` FOREIGN KEY (`skill_id`) REFERENCES `agent_skill` (`skill_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `agent_seat_status_fk` FOREIGN KEY (`status_id`) REFERENCES `agent_status` (`status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent_seat`
--

LOCK TABLES `agent_seat` WRITE;
/*!40000 ALTER TABLE `agent_seat` DISABLE KEYS */;
/*!40000 ALTER TABLE `agent_seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agent_skill`
--

DROP TABLE IF EXISTS `agent_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agent_skill` (
  `skill_id` int(11) NOT NULL DEFAULT '0',
  `skill_name` varchar(50) NOT NULL DEFAULT '',
  `skill_description` varchar(100) DEFAULT '',
  `skill_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent_skill`
--

LOCK TABLES `agent_skill` WRITE;
/*!40000 ALTER TABLE `agent_skill` DISABLE KEYS */;
/*!40000 ALTER TABLE `agent_skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agent_status`
--

DROP TABLE IF EXISTS `agent_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agent_status` (
  `status_id` int(11) NOT NULL,
  `status_name` varchar(50) NOT NULL,
  `status_description` varchar(100) DEFAULT NULL,
  `status_update_date` datetime NOT NULL,
  PRIMARY KEY (`status_id`),
  UNIQUE KEY `status_name` (`status_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent_status`
--

LOCK TABLES `agent_status` WRITE;
/*!40000 ALTER TABLE `agent_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `agent_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agent_trigger`
--

DROP TABLE IF EXISTS `agent_trigger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agent_trigger` (
  `trigger_id` int(11) NOT NULL DEFAULT '0',
  `trigger_name` varchar(50) NOT NULL DEFAULT '',
  `trigger_description` varchar(100) DEFAULT '',
  `trigger_command` varchar(500) DEFAULT '',
  `trigger_create_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `trigger_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`trigger_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent_trigger`
--

LOCK TABLES `agent_trigger` WRITE;
/*!40000 ALTER TABLE `agent_trigger` DISABLE KEYS */;
/*!40000 ALTER TABLE `agent_trigger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_business`
--

DROP TABLE IF EXISTS `crm_business`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_business` (
  `business_id` int(11) NOT NULL DEFAULT '0',
  `business_name` varchar(50) NOT NULL DEFAULT '',
  `business_description` varchar(100) DEFAULT '',
  `business_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`business_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_business`
--

LOCK TABLES `crm_business` WRITE;
/*!40000 ALTER TABLE `crm_business` DISABLE KEYS */;
INSERT INTO `crm_business` VALUES (1,'BnsOne','descOne','2011-09-04 12:53:04'),(2,'BnsTwo','descTwo','2011-09-04 12:53:21');
/*!40000 ALTER TABLE `crm_business` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_customer`
--

DROP TABLE IF EXISTS `crm_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `business_id` int(11) NOT NULL DEFAULT '0',
  `status_id` int(11) NOT NULL DEFAULT '0',
  `customer_fullname` varchar(100) NOT NULL DEFAULT '',
  `customer_gender` int(11) NOT NULL DEFAULT '0',
  `customer_address` varchar(500) DEFAULT NULL,
  `customer_birthday` datetime DEFAULT NULL,
  `customer_phone` varchar(100) DEFAULT NULL,
  `customer_email` varchar(100) DEFAULT NULL,
  `customer_create_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `customer_update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `crm_customer_business_fk` (`business_id`),
  KEY `crm_customer_status_fk` (`status_id`),
  CONSTRAINT `crm_customer_business_fk` FOREIGN KEY (`business_id`) REFERENCES `crm_business` (`business_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `crm_customer_status_fk` FOREIGN KEY (`status_id`) REFERENCES `crm_status` (`status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_customer`
--

LOCK TABLES `crm_customer` WRITE;
/*!40000 ALTER TABLE `crm_customer` DISABLE KEYS */;
INSERT INTO `crm_customer` VALUES (10,1,1,'',1,'',NULL,'','','2011-09-07 15:03:49',NULL),(11,1,1,'',1,'',NULL,'','','2011-09-07 15:03:52',NULL),(12,1,1,'',1,'',NULL,'','','2011-09-07 15:04:18',NULL),(13,1,1,'',1,'',NULL,'','','2011-09-07 15:04:20',NULL),(14,1,1,'',1,'',NULL,'','','2011-09-07 15:04:24',NULL),(15,1,1,'',1,'',NULL,'','','2011-09-07 15:04:40',NULL),(16,1,1,'',1,'',NULL,'','','2011-09-08 22:47:34',NULL),(17,1,1,'',1,'',NULL,'','','2011-09-08 22:47:39',NULL),(18,1,1,'',1,'',NULL,'','','2011-09-08 22:47:43',NULL),(19,1,1,'',1,'',NULL,'','','2011-09-08 22:47:47',NULL),(20,1,1,'',1,'',NULL,'','','2011-09-08 23:23:23',NULL);
/*!40000 ALTER TABLE `crm_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_status`
--

DROP TABLE IF EXISTS `crm_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_status` (
  `status_id` int(11) NOT NULL DEFAULT '0',
  `status_name` varchar(50) NOT NULL DEFAULT '',
  `status_description` varchar(100) DEFAULT '',
  `status_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_status`
--

LOCK TABLES `crm_status` WRITE;
/*!40000 ALTER TABLE `crm_status` DISABLE KEYS */;
INSERT INTO `crm_status` VALUES (1,'stsOne','descOne','2011-09-04 12:53:41'),(2,'stsTwo','descTwo','2011-09-04 12:53:51');
/*!40000 ALTER TABLE `crm_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ivr_callflow`
--

DROP TABLE IF EXISTS `ivr_callflow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ivr_callflow` (
  `callflow_id` int(11) NOT NULL AUTO_INCREMENT,
  `voice_id` int(11) NOT NULL,
  `callflow_name` varchar(50) NOT NULL DEFAULT '',
  `callflow_description` varchar(100) DEFAULT NULL,
  `callflow_step` int(11) NOT NULL,
  `callflow_timeout` int(11) NOT NULL,
  `callflow_next_id` int(11) DEFAULT NULL,
  `callflow_back_id` int(11) DEFAULT NULL,
  `callflow_voice_repeat_enable` tinyint(1) NOT NULL DEFAULT '0',
  `callflow_create_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `callflow_update_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `correct_trigger_id` int(11) DEFAULT NULL,
  `incorrect_trigger_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`callflow_id`),
  KEY `ivr_callflow_voice_fk` (`voice_id`),
  KEY `ivr_callflow_callflow_next_fk` (`callflow_next_id`),
  KEY `ivr_callflow_callflow_back_fk` (`callflow_back_id`),
  KEY `correct_trigger_fk` (`correct_trigger_id`),
  KEY `incorrect_trigger_fk` (`incorrect_trigger_id`),
  CONSTRAINT `correct_trigger_fk` FOREIGN KEY (`correct_trigger_id`) REFERENCES `job_trigger` (`trigger_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `incorrect_trigger_fk` FOREIGN KEY (`incorrect_trigger_id`) REFERENCES `job_trigger` (`trigger_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ivr_callflow_callflow_back_fk` FOREIGN KEY (`callflow_back_id`) REFERENCES `ivr_callflow` (`callflow_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ivr_callflow_callflow_next_fk` FOREIGN KEY (`callflow_next_id`) REFERENCES `ivr_callflow` (`callflow_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ivr_callflow_voice_fk` FOREIGN KEY (`voice_id`) REFERENCES `ivr_voiceprompt` (`voice_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ivr_callflow`
--

LOCK TABLES `ivr_callflow` WRITE;
/*!40000 ALTER TABLE `ivr_callflow` DISABLE KEYS */;
INSERT INTO `ivr_callflow` VALUES (1,1,'welcome one','9',9,10,NULL,NULL,0,'2011-08-14 00:00:00','2011-09-11 08:07:12',1,1),(2,1,'option one 1','',1,0,NULL,1,1,'2011-08-14 00:00:00','2011-09-11 06:39:48',NULL,NULL),(3,1,'option 1-1','desc. otn',3,0,NULL,2,1,'2011-08-14 00:00:00','2011-09-11 06:39:48',NULL,NULL),(4,1,'option2','',1,0,NULL,5,1,'2011-08-14 00:00:00','2011-09-11 06:39:49',NULL,NULL),(5,1,'welcome second','welcome flow',1,0,NULL,NULL,1,'2011-08-14 00:00:00','2011-09-11 06:39:49',NULL,NULL),(6,1,'option 1-2','',1,1,NULL,2,1,'2011-08-21 22:58:58','2011-09-11 04:31:01',1,2),(7,1,'Another flow','9',9,2,NULL,NULL,1,'2011-09-05 11:50:53','2011-09-11 06:36:35',NULL,NULL),(8,1,'test','de',1,10,NULL,7,1,'2011-09-11 15:08:03','2011-09-11 08:08:26',1,1),(9,1,'l','l',1,10,NULL,NULL,1,'2011-09-11 15:08:53',NULL,1,1);
/*!40000 ALTER TABLE `ivr_callflow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ivr_callflow_dtmf`
--

DROP TABLE IF EXISTS `ivr_callflow_dtmf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ivr_callflow_dtmf` (
  `callflow_id` int(11) NOT NULL,
  `dtmf_id` int(11) NOT NULL,
  KEY `callflow_fk` (`callflow_id`),
  KEY `dtmf_fk` (`dtmf_id`),
  CONSTRAINT `callflow_fk` FOREIGN KEY (`callflow_id`) REFERENCES `ivr_callflow` (`callflow_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `dtmf_fk` FOREIGN KEY (`dtmf_id`) REFERENCES `ivr_dtmf` (`dtmf_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ivr_callflow_dtmf`
--

LOCK TABLES `ivr_callflow_dtmf` WRITE;
/*!40000 ALTER TABLE `ivr_callflow_dtmf` DISABLE KEYS */;
INSERT INTO `ivr_callflow_dtmf` VALUES (5,1),(5,4),(7,2),(4,3),(6,2),(1,2),(8,6),(9,5);
/*!40000 ALTER TABLE `ivr_callflow_dtmf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ivr_callroute`
--

DROP TABLE IF EXISTS `ivr_callroute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ivr_callroute` (
  `callroute_id` int(11) NOT NULL DEFAULT '0',
  `callroute_name` varchar(50) NOT NULL DEFAULT '',
  `callroute_description` varchar(100) DEFAULT '',
  `callroute_caller` varchar(50) DEFAULT '',
  `callroute_called` varchar(50) DEFAULT '',
  `callroute_create_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `callroute_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`callroute_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ivr_callroute`
--

LOCK TABLES `ivr_callroute` WRITE;
/*!40000 ALTER TABLE `ivr_callroute` DISABLE KEYS */;
/*!40000 ALTER TABLE `ivr_callroute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ivr_channel`
--

DROP TABLE IF EXISTS `ivr_channel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ivr_channel` (
  `channel_id` int(11) NOT NULL DEFAULT '0',
  `channel_name` varchar(50) NOT NULL DEFAULT '',
  `channel_description` varchar(100) DEFAULT '',
  `channel_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`channel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ivr_channel`
--

LOCK TABLES `ivr_channel` WRITE;
/*!40000 ALTER TABLE `ivr_channel` DISABLE KEYS */;
INSERT INTO `ivr_channel` VALUES (1,'mobile','hihi','2011-09-03 10:45:26'),(2,'macbook','hahaha','2011-09-03 10:45:50');
/*!40000 ALTER TABLE `ivr_channel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ivr_dtmf`
--

DROP TABLE IF EXISTS `ivr_dtmf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ivr_dtmf` (
  `dtmf_id` int(11) NOT NULL,
  `dtmf_name` varchar(50) NOT NULL DEFAULT '',
  `dtmf_description` varchar(100) DEFAULT '',
  `dtmf_digit` varchar(50) NOT NULL DEFAULT '',
  `dtmf_correct_callflow_id` int(11) DEFAULT NULL,
  `dtmf_error_callflow_id` int(11) DEFAULT NULL,
  `dtmf_create_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `dtmf_update_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`dtmf_id`),
  KEY `ivr_dtmf_error_callflow_fk` (`dtmf_error_callflow_id`),
  KEY `ivr_dtmf_correct_callflow_fk` (`dtmf_correct_callflow_id`),
  CONSTRAINT `ivr_dtmf_correct_callflow_fk` FOREIGN KEY (`dtmf_correct_callflow_id`) REFERENCES `ivr_callflow` (`callflow_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ivr_dtmf_error_callflow_fk` FOREIGN KEY (`dtmf_error_callflow_id`) REFERENCES `ivr_callflow` (`callflow_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ivr_dtmf`
--

LOCK TABLES `ivr_dtmf` WRITE;
/*!40000 ALTER TABLE `ivr_dtmf` DISABLE KEYS */;
INSERT INTO `ivr_dtmf` VALUES (0,'0','','0',NULL,NULL,'2011-09-11 13:24:09',NULL),(1,'1','1','1',NULL,NULL,'2011-08-14 06:18:24','2011-08-13 23:18:24'),(2,'2','222','2',NULL,NULL,'2011-08-14 06:27:26','2011-08-13 23:27:26'),(3,'333','3333','3',NULL,NULL,'2011-08-24 12:57:20',NULL),(4,'4','4444','4',NULL,NULL,'2011-09-02 06:24:52',NULL),(5,'5','555','5',NULL,NULL,'2011-09-10 15:59:17',NULL),(6,'6','','6',NULL,NULL,'2011-09-10 18:11:47',NULL),(7,'7','','7',NULL,NULL,'2011-09-11 13:23:25',NULL),(8,'8','','8',NULL,NULL,'2011-09-11 13:23:46',NULL),(9,'9','','9',NULL,NULL,'2011-09-11 13:23:59',NULL),(11,'*','','*',NULL,NULL,'2011-09-11 13:24:42',NULL),(12,'#','','#',NULL,NULL,'2011-09-11 13:24:52',NULL);
/*!40000 ALTER TABLE `ivr_dtmf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ivr_pabx`
--

DROP TABLE IF EXISTS `ivr_pabx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ivr_pabx` (
  `pabx_id` int(11) NOT NULL AUTO_INCREMENT,
  `protocol_id` int(11) NOT NULL DEFAULT '0',
  `pabx_name` varchar(50) NOT NULL DEFAULT '',
  `pabx_description` varchar(100) DEFAULT NULL,
  `pabx_update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`pabx_id`),
  KEY `ivr_pabx_protocol_fk` (`protocol_id`),
  CONSTRAINT `ivr_pabx_protocol_fk` FOREIGN KEY (`protocol_id`) REFERENCES `ivr_protocol` (`protocol_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ivr_pabx`
--

LOCK TABLES `ivr_pabx` WRITE;
/*!40000 ALTER TABLE `ivr_pabx` DISABLE KEYS */;
INSERT INTO `ivr_pabx` VALUES (2,1,'lk','lk','2011-09-05 15:18:37'),(5,1,'dd','1dd','2011-09-05 15:19:28');
/*!40000 ALTER TABLE `ivr_pabx` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ivr_protocol`
--

DROP TABLE IF EXISTS `ivr_protocol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ivr_protocol` (
  `protocol_id` int(11) NOT NULL DEFAULT '0',
  `protocol_name` varchar(50) NOT NULL DEFAULT '',
  `protocol_description` varchar(100) DEFAULT '',
  `protocol_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`protocol_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ivr_protocol`
--

LOCK TABLES `ivr_protocol` WRITE;
/*!40000 ALTER TABLE `ivr_protocol` DISABLE KEYS */;
INSERT INTO `ivr_protocol` VALUES (1,'jojo','jk','2011-09-05 11:56:32'),(2,'2','2','2011-09-05 15:19:06');
/*!40000 ALTER TABLE `ivr_protocol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ivr_schedule`
--

DROP TABLE IF EXISTS `ivr_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ivr_schedule` (
  `schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `schedule_name` varchar(50) NOT NULL DEFAULT '',
  `schedule_description` varchar(100) DEFAULT NULL,
  `schedule_caller` varchar(50) NOT NULL DEFAULT '',
  `schedule_called` varchar(50) NOT NULL DEFAULT '',
  `schedule_channel` int(11) NOT NULL DEFAULT '0',
  `schedule_start_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `schedule_retry_time` int(11) NOT NULL DEFAULT '0',
  `schedule_create_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `schedule_update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`schedule_id`),
  KEY `ivr_schedule_channel_fk` (`schedule_channel`),
  CONSTRAINT `ivr_schedule_channel_fk` FOREIGN KEY (`schedule_channel`) REFERENCES `ivr_channel` (`channel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ivr_schedule`
--

LOCK TABLES `ivr_schedule` WRITE;
/*!40000 ALTER TABLE `ivr_schedule` DISABLE KEYS */;
INSERT INTO `ivr_schedule` VALUES (1,'8','8','8','8',2,'2011-09-14 12:00:00',8,'2011-09-05 11:41:32','2011-09-05 04:41:49');
/*!40000 ALTER TABLE `ivr_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ivr_voiceprompt`
--

DROP TABLE IF EXISTS `ivr_voiceprompt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ivr_voiceprompt` (
  `voice_id` int(11) NOT NULL,
  `voice_name` varchar(50) NOT NULL DEFAULT '',
  `voice_description` varchar(100) DEFAULT '',
  `voice_filename` varchar(500) NOT NULL DEFAULT '',
  `voice_create_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `voice_update_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`voice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ivr_voiceprompt`
--

LOCK TABLES `ivr_voiceprompt` WRITE;
/*!40000 ALTER TABLE `ivr_voiceprompt` DISABLE KEYS */;
INSERT INTO `ivr_voiceprompt` VALUES (1,'welcome voice','','\\voice\\welcome.mp3','2011-08-13 22:01:30','2011-08-13 15:01:30'),(2,'good bye','','\\voice\\goodbye.mp3','2011-08-24 12:57:56','2011-08-24 05:57:56');
/*!40000 ALTER TABLE `ivr_voiceprompt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_status`
--

DROP TABLE IF EXISTS `job_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job_status` (
  `status_id` int(11) NOT NULL DEFAULT '0',
  `status_name` varchar(50) NOT NULL DEFAULT '',
  `status_description` varchar(100) DEFAULT '',
  `status_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_status`
--

LOCK TABLES `job_status` WRITE;
/*!40000 ALTER TABLE `job_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `job_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_ticket`
--

DROP TABLE IF EXISTS `job_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job_ticket` (
  `job_id` int(11) NOT NULL DEFAULT '0',
  `customer_id` int(11) NOT NULL DEFAULT '0',
  `agent_id` int(11) NOT NULL DEFAULT '0',
  `seat_id` int(11) NOT NULL DEFAULT '0',
  `solution_id` int(11) NOT NULL DEFAULT '0',
  `status_id` int(11) NOT NULL DEFAULT '0',
  `level_id` int(11) NOT NULL DEFAULT '0',
  `job_name` varchar(50) NOT NULL DEFAULT '',
  `job_description` varchar(100) DEFAULT '',
  `job_voice_record_file` varchar(500) DEFAULT '',
  `job_alert_enable` int(11) NOT NULL DEFAULT '0',
  `job_create_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `job_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `job_close_date` datetime DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`job_id`),
  KEY `job_ticket_customer_fk` (`customer_id`),
  KEY `job_ticket_agent_fk` (`agent_id`),
  KEY `job_ticket_seat_fk` (`seat_id`),
  KEY `job_ticket_solution_fk` (`solution_id`),
  KEY `job_ticket_status_fk` (`status_id`),
  KEY `job_ticket_level_fk` (`level_id`),
  CONSTRAINT `job_ticket_agent_fk` FOREIGN KEY (`agent_id`) REFERENCES `agent_profile` (`agent_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `job_ticket_customer_fk` FOREIGN KEY (`customer_id`) REFERENCES `crm_customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `job_ticket_level_fk` FOREIGN KEY (`level_id`) REFERENCES `agent_level` (`level_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `job_ticket_seat_fk` FOREIGN KEY (`seat_id`) REFERENCES `agent_seat` (`seat_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `job_ticket_solution_fk` FOREIGN KEY (`solution_id`) REFERENCES `knw_solution` (`solution_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `job_ticket_status_fk` FOREIGN KEY (`status_id`) REFERENCES `job_status` (`status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_ticket`
--

LOCK TABLES `job_ticket` WRITE;
/*!40000 ALTER TABLE `job_ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `job_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_trigger`
--

DROP TABLE IF EXISTS `job_trigger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job_trigger` (
  `trigger_id` int(11) NOT NULL DEFAULT '0',
  `trigger_name` varchar(50) NOT NULL DEFAULT '',
  `trigger_description` varchar(100) DEFAULT '',
  `trigger_command` varchar(500) DEFAULT '',
  `trigger_create_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `trigger_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`trigger_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_trigger`
--

LOCK TABLES `job_trigger` WRITE;
/*!40000 ALTER TABLE `job_trigger` DISABLE KEYS */;
INSERT INTO `job_trigger` VALUES (1,'call hello','print out hello','sout.print(\"hello\");','2011-09-10 15:50:08','2011-09-10 08:50:08'),(2,'call error','print out error','sout.print(\"error\");','2011-09-10 15:50:35','2011-09-10 08:50:35');
/*!40000 ALTER TABLE `job_trigger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `knw_category`
--

DROP TABLE IF EXISTS `knw_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `knw_category` (
  `category_id` int(11) NOT NULL DEFAULT '0',
  `parent_category_id` int(11) NOT NULL DEFAULT '0',
  `category_name` varchar(50) NOT NULL DEFAULT '',
  `category_description` varchar(100) DEFAULT '',
  `category_create_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `category_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`category_id`),
  KEY `knw_category_category_fk` (`parent_category_id`),
  CONSTRAINT `knw_category_category_fk` FOREIGN KEY (`parent_category_id`) REFERENCES `knw_category` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knw_category`
--

LOCK TABLES `knw_category` WRITE;
/*!40000 ALTER TABLE `knw_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `knw_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `knw_solution`
--

DROP TABLE IF EXISTS `knw_solution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `knw_solution` (
  `solution_id` int(11) NOT NULL DEFAULT '0',
  `topic_id` int(11) NOT NULL DEFAULT '0',
  `agent_id` int(11) NOT NULL DEFAULT '0',
  `supervisor_id` int(11) NOT NULL DEFAULT '0',
  `status_id` int(11) NOT NULL DEFAULT '0',
  `solution_name` varchar(50) NOT NULL DEFAULT '',
  `solution_description` varchar(1000) DEFAULT '',
  `solution_create_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `solution_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`solution_id`),
  KEY `knw_solution_agent_fk` (`agent_id`),
  KEY `knw_solution_supervisor_fk` (`supervisor_id`),
  KEY `knw_solution_status_fk` (`status_id`),
  KEY `knw_solution_topic_fk` (`topic_id`),
  CONSTRAINT `knw_solution_agent_fk` FOREIGN KEY (`agent_id`) REFERENCES `agent_profile` (`agent_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `knw_solution_status_fk` FOREIGN KEY (`status_id`) REFERENCES `knw_status` (`status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `knw_solution_supervisor_fk` FOREIGN KEY (`supervisor_id`) REFERENCES `agent_profile` (`agent_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `knw_solution_topic_fk` FOREIGN KEY (`topic_id`) REFERENCES `knw_topic` (`topic_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knw_solution`
--

LOCK TABLES `knw_solution` WRITE;
/*!40000 ALTER TABLE `knw_solution` DISABLE KEYS */;
/*!40000 ALTER TABLE `knw_solution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `knw_status`
--

DROP TABLE IF EXISTS `knw_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `knw_status` (
  `status_id` int(11) NOT NULL DEFAULT '0',
  `status_name` varchar(50) NOT NULL DEFAULT '',
  `status_description` varchar(100) DEFAULT '',
  `status_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knw_status`
--

LOCK TABLES `knw_status` WRITE;
/*!40000 ALTER TABLE `knw_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `knw_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `knw_topic`
--

DROP TABLE IF EXISTS `knw_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `knw_topic` (
  `topic_id` int(11) NOT NULL DEFAULT '0',
  `agent_id` int(11) NOT NULL DEFAULT '0',
  `category_id` int(11) NOT NULL DEFAULT '0',
  `status_id` int(11) NOT NULL DEFAULT '0',
  `topic_name` varchar(50) NOT NULL DEFAULT '',
  `topic_description` varchar(100) DEFAULT '',
  `topic_subject` varchar(100) NOT NULL DEFAULT '',
  `topic_create_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `topic_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`topic_id`),
  KEY `knw_topic_agent_fk` (`agent_id`),
  KEY `knw_topic_category_fk` (`category_id`),
  KEY `knw_topic_status_fk` (`status_id`),
  CONSTRAINT `knw_topic_agent_fk` FOREIGN KEY (`agent_id`) REFERENCES `agent_profile` (`agent_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `knw_topic_category_fk` FOREIGN KEY (`category_id`) REFERENCES `knw_category` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `knw_topic_status_fk` FOREIGN KEY (`status_id`) REFERENCES `knw_status` (`status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knw_topic`
--

LOCK TABLES `knw_topic` WRITE;
/*!40000 ALTER TABLE `knw_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `knw_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wkf_calendar`
--

DROP TABLE IF EXISTS `wkf_calendar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wkf_calendar` (
  `calendar_id` int(11) NOT NULL DEFAULT '0',
  `calendar_name` varchar(50) NOT NULL DEFAULT '',
  `calendar_description` varchar(100) DEFAULT '',
  `calendar_enable` int(11) NOT NULL DEFAULT '0',
  `calendar_start_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `calendar_end_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `calendar_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`calendar_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wkf_calendar`
--

LOCK TABLES `wkf_calendar` WRITE;
/*!40000 ALTER TABLE `wkf_calendar` DISABLE KEYS */;
/*!40000 ALTER TABLE `wkf_calendar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wkf_holiday`
--

DROP TABLE IF EXISTS `wkf_holiday`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wkf_holiday` (
  `holiday_id` int(11) NOT NULL DEFAULT '0',
  `calendar_id` int(11) NOT NULL DEFAULT '0',
  `holiday_name` varchar(50) NOT NULL DEFAULT '',
  `holiday_description` varchar(100) DEFAULT '',
  `holiday_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `holiday_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`holiday_id`),
  KEY `wkf_holiday_calendar_fk` (`calendar_id`),
  CONSTRAINT `wkf_holiday_calendar_fk` FOREIGN KEY (`calendar_id`) REFERENCES `wkf_calendar` (`calendar_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wkf_holiday`
--

LOCK TABLES `wkf_holiday` WRITE;
/*!40000 ALTER TABLE `wkf_holiday` DISABLE KEYS */;
/*!40000 ALTER TABLE `wkf_holiday` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wkf_request`
--

DROP TABLE IF EXISTS `wkf_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wkf_request` (
  `request_id` int(11) NOT NULL DEFAULT '0',
  `agent_id` int(11) NOT NULL DEFAULT '0',
  `supervisor_id` int(11) NOT NULL DEFAULT '0',
  `status_id` int(11) NOT NULL DEFAULT '0',
  `request_name` varchar(50) NOT NULL DEFAULT '',
  `request_description` varchar(100) DEFAULT '',
  `request_start_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `request_end_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `request_create_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `request_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`request_id`),
  KEY `wkf_request_agent_fk` (`agent_id`),
  KEY `wkf_request_supervisor_fk` (`supervisor_id`),
  KEY `wkf_request_status_fk` (`status_id`),
  CONSTRAINT `wkf_request_agent_fk` FOREIGN KEY (`agent_id`) REFERENCES `agent_profile` (`agent_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `wkf_request_status_fk` FOREIGN KEY (`status_id`) REFERENCES `wkf_status` (`status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `wkf_request_supervisor_fk` FOREIGN KEY (`supervisor_id`) REFERENCES `agent_profile` (`agent_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wkf_request`
--

LOCK TABLES `wkf_request` WRITE;
/*!40000 ALTER TABLE `wkf_request` DISABLE KEYS */;
/*!40000 ALTER TABLE `wkf_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wkf_status`
--

DROP TABLE IF EXISTS `wkf_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wkf_status` (
  `status_id` int(11) NOT NULL DEFAULT '0',
  `status_name` varchar(50) NOT NULL DEFAULT '',
  `status_description` varchar(100) DEFAULT '',
  `status_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wkf_status`
--

LOCK TABLES `wkf_status` WRITE;
/*!40000 ALTER TABLE `wkf_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `wkf_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wkf_workplan`
--

DROP TABLE IF EXISTS `wkf_workplan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wkf_workplan` (
  `workplan_id` int(11) NOT NULL DEFAULT '0',
  `calendar_id` int(11) NOT NULL DEFAULT '0',
  `workplan_name` varchar(50) NOT NULL DEFAULT '',
  `workplan_description` varchar(100) DEFAULT '',
  `workplan_start_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `workplan_end_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `workplan_start_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `workplan_end_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `workplan_create_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `workplan_update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`workplan_id`),
  KEY `wkf_workplan_calendar_fk` (`calendar_id`),
  CONSTRAINT `wkf_workplan_calendar_fk` FOREIGN KEY (`calendar_id`) REFERENCES `wkf_calendar` (`calendar_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wkf_workplan`
--

LOCK TABLES `wkf_workplan` WRITE;
/*!40000 ALTER TABLE `wkf_workplan` DISABLE KEYS */;
/*!40000 ALTER TABLE `wkf_workplan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-09-11 10:02:35
