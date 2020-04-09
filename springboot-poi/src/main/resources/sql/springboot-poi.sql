/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE IF NOT EXISTS `springboot-poi` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `springboot-poi`;

CREATE TABLE IF NOT EXISTS `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT 'name',
  `countryCode` varchar(50) NOT NULL DEFAULT '' COMMENT 'countryCode',
  `district` varchar(50) NOT NULL DEFAULT '' COMMENT 'district',
  `population` int(11) NOT NULL DEFAULT '-1' COMMENT 'population',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COMMENT='city';

/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` (`id`, `name`, `countryCode`, `district`, `population`) VALUES
	(1, 'Java', '255', 'asdf', 9997),
	(6, 'lin', '123', 'lin', 996),
	(7, 'lin', 'lin', 'lin', 99),
	(8, 'Java', 'af', 'asdf', 9999),
	(9, 'Java', 'é¿æ¯æ¾å¤§', 'asdf', 12),
	(10, 'Java', '阿斯放大', '爱上', 9996),
	(11, '学习过程的总结', '阿斯放大', '爱上', 9999),
	(12, '学习过程的总结', '阿斯', '爱上', 9999),
	(13, 'Java', 'af', 'asdf', 9999),
	(14, '常见菜式', 'af', 'asdf', 9999),
	(15, 'Java', 'af', '爱上', 9992),
	(16, 'Java', '阿斯放大', '爱上', 9999);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
