/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.6.36 : Database - story
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`story` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `story`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `cid` int(11) NOT NULL,
  `cname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `category` */

/*Table structure for table `comments` */

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `commentid` int(50) NOT NULL AUTO_INCREMENT,
  `story` int(50) NOT NULL,
  `people` int(50) DEFAULT NULL,
  `comment` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`commentid`),
  KEY `story` (`story`),
  KEY `people` (`people`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`story`) REFERENCES `novel` (`novelid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`people`) REFERENCES `person` (`personid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comments` */

/*Table structure for table `novel` */

DROP TABLE IF EXISTS `novel`;

CREATE TABLE `novel` (
  `novelid` int(30) NOT NULL AUTO_INCREMENT,
  `categorys` int(20) DEFAULT NULL,
  `novelname` varchar(30) NOT NULL,
  `author` int(50) DEFAULT NULL,
  `content` varchar(5000) NOT NULL,
  PRIMARY KEY (`novelid`),
  KEY `categorys` (`categorys`),
  KEY `author` (`author`),
  CONSTRAINT `novel_ibfk_1` FOREIGN KEY (`categorys`) REFERENCES `category` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `novel_ibfk_2` FOREIGN KEY (`author`) REFERENCES `person` (`personid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `novel` */

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `personid` int(50) NOT NULL AUTO_INCREMENT,
  `account` varchar(15) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `signature` varchar(200) DEFAULT NULL,
  `filepath` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`personid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `person` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
