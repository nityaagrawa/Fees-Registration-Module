/*
SQLyog - Free MySQL GUI v5.17
Host - 5.5.27 : Database - fees
*********************************************************************
Server version : 5.5.27
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `fees`;

USE `fees`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `stud_name` varchar(20) DEFAULT NULL,
  `stud_age` int(11) DEFAULT NULL,
  `stud_pass` varchar(20) DEFAULT NULL,
  `stud_fees` varchar(10) DEFAULT NULL,
  `stud_id` varchar(10) NOT NULL,
  PRIMARY KEY (`stud_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `student` */

insert into `student` (`stud_name`,`stud_age`,`stud_pass`,`stud_fees`,`stud_id`) values (' aliva ',23,' 0987 ',' unpaid ','17bbt0912');
insert into `student` (`stud_name`,`stud_age`,`stud_pass`,`stud_fees`,`stud_id`) values (' shivam ',20,' 4567 ',' paid ','17bcb0078');
insert into `student` (`stud_name`,`stud_age`,`stud_pass`,`stud_fees`,`stud_id`) values (' aadhya ',18,' 9876 ','unpaid','17bce2354');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_name` varchar(20) DEFAULT NULL,
  `user_pass` varchar(20) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `user_id` varchar(10) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert into `user` (`user_name`,`user_pass`,`role`,`user_id`) values (' aliva ',' 0987 ',' student ',' 17bbt0912');
insert into `user` (`user_name`,`user_pass`,`role`,`user_id`) values ('shivam ','4567 ',' student ',' 17bcb0078');
insert into `user` (`user_name`,`user_pass`,`role`,`user_id`) values ('nitya','9801','admin','0289');
insert into `user` (`user_name`,`user_pass`,`role`,`user_id`) values ('aadhya','9876','student','17bce2354');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
