/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE IF NOT EXISTS `springsecurity-rbac` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;
USE `springsecurity-rbac`;

CREATE TABLE IF NOT EXISTS `tb_basic_modular` (
  `modular_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '模块编号',
  `modular_name` varchar(200) COLLATE utf8mb4_bin NOT NULL DEFAULT '0' COMMENT '模块名称',
  `modular_sort` int(11) NOT NULL DEFAULT '0' COMMENT '模块排序',
  PRIMARY KEY (`modular_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*!40000 ALTER TABLE `tb_basic_modular` DISABLE KEYS */;
INSERT INTO `tb_basic_modular` (`modular_id`, `modular_name`, `modular_sort`) VALUES
	(1, '系统管理', 0);
/*!40000 ALTER TABLE `tb_basic_modular` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `tb_basic_permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `modular_id` int(11) NOT NULL COMMENT '模块编号',
  `permission_name` varchar(200) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '权限名称',
  `permission_action` varchar(1024) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '权限路径',
  `permission_word` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '权限标识符',
  `permission_parent` int(11) NOT NULL COMMENT '权限的父权限，如为0是菜单',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*!40000 ALTER TABLE `tb_basic_permission` DISABLE KEYS */;
INSERT INTO `tb_basic_permission` (`permission_id`, `modular_id`, `permission_name`, `permission_action`, `permission_word`, `permission_parent`) VALUES
	(1, 1, '系统增加', '', 'ADD', 0),
	(2, 1, '系统查询', '', 'LIST', 0),
	(3, 1, '系统删除', '', 'DELETE', 0),
	(4, 1, '系统更新', '', 'EDIT', 0);
/*!40000 ALTER TABLE `tb_basic_permission` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `tb_basic_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role_name` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '角色名',
  `role_permissions` varchar(2000) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '角色权限',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*!40000 ALTER TABLE `tb_basic_role` DISABLE KEYS */;
INSERT INTO `tb_basic_role` (`role_id`, `role_name`, `role_permissions`) VALUES
	(1, '系统管理员', '1,2,3,4');
/*!40000 ALTER TABLE `tb_basic_role` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `tb_basic_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `role_id` int(11) NOT NULL COMMENT '角色编号',
  `user_name` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '用户名',
  `user_password` varchar(500) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '密码',
  `user_account` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '0' COMMENT '用户账号',
  `user_status` int(11) NOT NULL DEFAULT '0' COMMENT '状态，1表示可用，非1禁用',
  `user_create_date` datetime NOT NULL COMMENT '创建日期',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*!40000 ALTER TABLE `tb_basic_user` DISABLE KEYS */;
INSERT INTO `tb_basic_user` (`user_id`, `role_id`, `user_name`, `user_password`, `user_account`, `user_status`, `user_create_date`) VALUES
	(1, 1, 'lin', '{bcrypt}$2a$10$J81DMSvO8VUlowo2srxCO.REHDBLA5cmpuFckX0HxUSnU/O6Js0ru', 'lin', 0, '2020-06-00 12:55:11');
/*!40000 ALTER TABLE `tb_basic_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
