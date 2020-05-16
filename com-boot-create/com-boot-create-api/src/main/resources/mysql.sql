/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.29-log : Database - mytest
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mytest` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mytest`;

/*Table structure for table `user_test` */

DROP TABLE IF EXISTS `user_test`;

CREATE TABLE `user_test` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(30) NOT NULL COMMENT '姓名',
  `age` int(11) NOT NULL COMMENT '年龄',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `act_age` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户测试';

/*Data for the table `user_test` */

insert  into `user_test`(`id`,`name`,`age`,`email`,`act_age`,`create_time`,`update_time`) values (1,'陶金',18,'test1@baomidou.com',1,'2020-05-14 02:41:00','2020-05-14 03:06:51'),(2,'Jack',20,'test2@baomidou.com',0,'2020-05-14 02:41:00','2020-05-14 02:41:00'),(3,'Tom',28,'test3@baomidou.com',0,'2020-05-14 02:41:00','2020-05-14 02:41:00'),(4,'Sandy',21,'test4@baomidou.com',1,'2020-05-14 02:41:00','2020-05-14 02:41:00'),(5,'Billie',24,'test5@baomidou.com',0,'2020-05-14 02:41:00','2020-05-14 02:41:00'),(6,'陶金',26,'',0,'2020-05-14 02:41:00','2020-05-14 02:41:00'),(7,'陶金',26,'',0,'2020-05-14 02:41:00','2020-05-14 02:41:00'),(8,'陶金',26,'',0,'2020-05-14 02:41:00','2020-05-14 02:41:00'),(9,'guyao',26,'',11,'2020-05-14 02:45:37','2020-05-14 02:45:37'),(10,'guyao',26,'',11,'2020-05-14 02:51:14','2020-05-14 02:51:14');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
