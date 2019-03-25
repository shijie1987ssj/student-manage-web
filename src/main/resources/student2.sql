/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.10-log : Database - student2
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`student2` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `Adminname` varchar(30) NOT NULL COMMENT '管理员用户名',
  `Adminpassword` varchar(100) DEFAULT NULL COMMENT '管理员密码',
  PRIMARY KEY (`Adminname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `class_info` */

DROP TABLE IF EXISTS `class_info`;

CREATE TABLE `class_info` (
  `Classname` varchar(30) NOT NULL COMMENT '班级名称',
  PRIMARY KEY (`Classname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `club` */

DROP TABLE IF EXISTS `club`;

CREATE TABLE `club` (
  `Clubname` varchar(30) NOT NULL COMMENT '院系名称',
  PRIMARY KEY (`Clubname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `efei` */

DROP TABLE IF EXISTS `efei`;

CREATE TABLE `efei` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `Description` varchar(30) DEFAULT NULL COMMENT '描述',
  `Value` int(11) DEFAULT NULL COMMENT '值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `grade` */

DROP TABLE IF EXISTS `grade`;

CREATE TABLE `grade` (
  `gradename` varchar(30) NOT NULL COMMENT '年级',
  PRIMARY KEY (`gradename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `leader` */

DROP TABLE IF EXISTS `leader`;

CREATE TABLE `leader` (
  `Leadername` varchar(30) NOT NULL COMMENT '领导用户名',
  `Leaderpass` varchar(100) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`Leadername`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `question` */

DROP TABLE IF EXISTS `question`;

CREATE TABLE `question` (
  `Questionid` int(11) NOT NULL COMMENT '评价问题题号',
  `Questionscore` int(11) DEFAULT NULL COMMENT '评价问题分数',
  `Question` varchar(30) DEFAULT NULL COMMENT '评价问题',
  PRIMARY KEY (`Questionid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `stu_piechart` */

DROP TABLE IF EXISTS `stu_piechart`;

CREATE TABLE `stu_piechart` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `Description` varchar(30) DEFAULT NULL COMMENT '描述',
  `Value` int(11) DEFAULT NULL COMMENT '值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `stu_pingjia_teacher` */

DROP TABLE IF EXISTS `stu_pingjia_teacher`;

CREATE TABLE `stu_pingjia_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `Stuid` int(11) DEFAULT NULL COMMENT '学生编号，外键',
  `teacherid` int(11) DEFAULT NULL COMMENT '教师编号，外键',
  `pingjiascore` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `Stuid` int(11) NOT NULL COMMENT '学生编号，主键',
  `Stuname` varchar(30) DEFAULT NULL COMMENT '学生姓名',
  `Stupass` varchar(100) DEFAULT NULL COMMENT '密码',
  `Stuage` int(11) DEFAULT NULL COMMENT '年龄',
  `Stusex` varchar(30) DEFAULT NULL COMMENT '性别',
  `Stuclass` varchar(30) DEFAULT NULL COMMENT '所在班级，外键',
  `Stuclub` varchar(30) DEFAULT NULL COMMENT '所在院系，外键',
  `stuQQ` int(11) DEFAULT NULL COMMENT 'QQ号',
  `Stutelephone` varchar(12) DEFAULT NULL COMMENT '电话号码',
  `stuEmail` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `Stugrade` varchar(30) DEFAULT NULL COMMENT '所在年级，外键',
  PRIMARY KEY (`Stuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `stuscore` */

DROP TABLE IF EXISTS `stuscore`;

CREATE TABLE `stuscore` (
  `stuid` int(11) NOT NULL COMMENT '学生编号主键',
  `english` int(11) DEFAULT NULL COMMENT '英语成绩',
  `math` int(11) DEFAULT NULL COMMENT '数学成绩',
  `Chinese` int(11) DEFAULT NULL COMMENT '语文成绩',
  `Computer` int(11) DEFAULT NULL COMMENT '计算机成绩',
  `Sumscore` int(11) DEFAULT NULL COMMENT '总分',
  `Rank` int(11) DEFAULT NULL COMMENT '排名',
  PRIMARY KEY (`stuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `subjects` */

DROP TABLE IF EXISTS `subjects`;

CREATE TABLE `subjects` (
  `Subjectname` varchar(30) NOT NULL COMMENT '课程名称',
  `Clubname` varchar(30) DEFAULT NULL COMMENT '院系名称',
  PRIMARY KEY (`Subjectname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `Teacherid` int(11) NOT NULL COMMENT '教师编号',
  `Teachername` varchar(30) DEFAULT NULL COMMENT '教师姓名',
  `Teacherage` int(11) DEFAULT NULL COMMENT '年龄',
  `Teachersex` varchar(30) DEFAULT NULL COMMENT '性别',
  `Teacherpass` varchar(100) DEFAULT NULL COMMENT '密码',
  `Teacherclass` varchar(30) DEFAULT NULL COMMENT '授课班级，外键',
  `Teacherclub` varchar(30) DEFAULT NULL COMMENT '所在院系，外键',
  `Subject` varchar(30) DEFAULT NULL COMMENT '所带课程，外键',
  `School` varchar(30) DEFAULT NULL COMMENT '毕业院校',
  `teacherEmail` varchar(30) DEFAULT NULL COMMENT '教师邮箱',
  `Pingjia` varchar(30) DEFAULT NULL COMMENT '是否评价',
  PRIMARY KEY (`Teacherid`),
  KEY `Teacherid` (`Teacherid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `teacherscore` */

DROP TABLE IF EXISTS `teacherscore`;

CREATE TABLE `teacherscore` (
  `Teacherid` int(11) NOT NULL COMMENT '教师编号',
  `Teacherscore` int(11) DEFAULT NULL COMMENT '教师评价得分',
  PRIMARY KEY (`Teacherid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
