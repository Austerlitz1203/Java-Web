-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.10.1-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 e-commerce 的数据库结构
CREATE DATABASE IF NOT EXISTS `e-commerce` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `e-commerce`;

-- 导出  表 e-commerce.category 结构
CREATE TABLE IF NOT EXISTS `category` (
  `cname` varchar(50) NOT NULL,
  `cdiscription` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  e-commerce.category 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`cname`, `cdiscription`) VALUES
	('ELERTRONICS', 'goods about electronics'),
	('MOBILES', 'goods of mobiles'),
	('LAPTOPS', 'goods about laptops'),
	('COMPUTERS', 'goods about computers'),
	('CAMERAS', 'goods about cameras');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- 导出  表 e-commerce.message 结构
CREATE TABLE IF NOT EXISTS `message` (
  `message` varchar(200) NOT NULL,
  `msg` varchar(200) NOT NULL,
  `title` varchar(200) NOT NULL,
  `date` varchar(200) NOT NULL,
  `to` int(11) NOT NULL DEFAULT 0,
  `from` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  e-commerce.message 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;

-- 导出  表 e-commerce.orderdata 结构
CREATE TABLE IF NOT EXISTS `orderdata` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) NOT NULL,
  `price` float NOT NULL DEFAULT 0,
  `qun` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  e-commerce.orderdata 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `orderdata` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderdata` ENABLE KEYS */;

-- 导出  表 e-commerce.orders 结构
CREATE TABLE IF NOT EXISTS `orders` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(50) NOT NULL,
  `uid` int(11) NOT NULL DEFAULT 0,
  `addr` varchar(200) NOT NULL,
  `contact` varchar(200) NOT NULL,
  `pay` varchar(200) NOT NULL DEFAULT '0',
  `charg` int(11) NOT NULL DEFAULT 0,
  `states` varchar(50) NOT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  e-commerce.orders 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- 导出  表 e-commerce.product 结构
CREATE TABLE IF NOT EXISTS `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) NOT NULL,
  `price` float NOT NULL DEFAULT 0,
  `pic` varchar(200) NOT NULL DEFAULT '',
  `discount` float NOT NULL DEFAULT 0,
  `discription` varchar(200) NOT NULL DEFAULT '',
  `cname` varchar(200) NOT NULL DEFAULT '',
  `brand` varchar(200) NOT NULL DEFAULT '',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

-- 正在导出表  e-commerce.product 的数据：~7 rows (大约)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`pid`, `pname`, `price`, `pic`, `discount`, `discription`, `cname`, `brand`) VALUES
	(9, 'iphone 13 pro', 9999, 'MOBILES1833306440.png', 10, 'With 6GB of RAM,128GB of internal storage', 'MOBILES', 'apple'),
	(10, 'thinkpad x 13', 6999, 'COMPUTERS544826320.png', 10, 'With this GeForce GTX 16 Series laptop,experience the mind-blowing', 'LAPTOPS', 'lenovo'),
	(11, 'Red mi k40', 4999, 'MOBILES1292441015.png', 20, 'Screen 6.67 inch AMOLED (E4) 120Hz processor Qualcomm Snapdragon 870 Front 20 million pixel AI lens Rear 48 million pixel main lens', 'MOBILES', 'xiaomi'),
	(12, 'matebook 16s', 9199, 'COMPUTERS-1590054360.png', 25, 'HUAWEI MateBook 16s 12th Generation Core Standard Pressed i9 16GB 1TB 16-inch 2.5K High Color Touchscreen Space Gray', 'COMPUTERS', 'huawei'),
	(13, 'snoy', 27900, 'CAMERAS-2073068930.png', 10, 'Full-frame mirrorless  camera Picture quality flagship (black, approx. 61 million effective pixels, approx. 10 fps continuous shooting, 15 stops of dynamic range, real-time eye focus)', 'CAMERAS', 'sony'),
	(14, 'magicbook 16pro', 6999, 'LAPTOPS1342886181.png', 10, 'Honor MagicBook 16 Pro 2021 16.1-inch High Performance Standard Pressure Thin and Light Gaming Laptop (Windows 10 Home or Windows 11 Home Edition Random R7-5800H 16+512G 144Hz GTX1650)', 'LAPTOPS', 'honor'),
	(15, 'retro digital camera ', 1263, 'CAMERAS495647973.png', 10, 'Casio co-branded student new retro digital camera anti-shake 48 million HD pixel campus portable travel Black 32G memory can be imported into mobile phones', 'CAMERAS', 'Casio');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- 导出  表 e-commerce.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(50) NOT NULL,
  `uemail` varchar(50) NOT NULL,
  `uphon` varchar(50) NOT NULL,
  `upassword` varchar(200) NOT NULL,
  `uaddr` varchar(200) NOT NULL,
  `utype` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- 正在导出表  e-commerce.user 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`uid`, `uname`, `uemail`, `uphon`, `upassword`, `uaddr`, `utype`) VALUES
	(1, 'leo', 'ljun3889@gmail.com', '18168842456', '123456789', 'changzhouprovince', 'normal'),
	(2, 'leo', 'leo123@gmail.com', '1340160279', '123456789', 'province jiangsu', 'admin'),
	(3, 'mingfei lu', 'lmf123@gmail.com', '1335689452', '123456789', 'Kassel College', 'normal');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
