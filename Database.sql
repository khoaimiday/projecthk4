-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 34.126.180.14    Database: foodorder
-- ------------------------------------------------------
-- Server version	8.0.18-google

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `cities` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `lane` varchar(255) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longtitude` double DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `ward` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'2021-07-19 20:05:06','2021-07-19 20:05:06','Hồ Chí Minh','Việt Nam','Tân Phú','',10.7772,106.625,'','','332 Thoại Ngọc Hầu','R','Phú Thạnh'),(2,'2021-07-19 20:05:06','2021-07-19 20:05:06','Hồ Chí Minh','Việt Nam','Quận 1','',10.7731,106.694,'','','139 Nguyễn Du','R','Phường Bến Thành'),(3,'2021-07-19 20:05:06','2021-07-19 20:05:06','Hồ Chí Minh','Việt Nam','Quận 1','Basement 2, Log 11/12, Saigon Centre Building',10.7734,106.701,'','','65 Le Loi Street','R','Ben Nghe'),(4,'2021-07-19 20:05:06','2021-07-19 20:05:06','Hồ Chí Minh','Việt Nam','Quận Tân Bình','',10.816,106.632,'','','744 Trường Chinh','R','Phường 15'),(5,'2021-07-19 20:05:06','2021-07-19 20:05:06','Hồ Chí Minh','Việt Nam','Quận Tân Bình','',10.8005,106.673,'','','198 Hoàng Văn Thụ','R','Phường 4'),(6,'2021-07-19 20:05:06','2021-07-19 20:05:06','Hồ Chí Minh','Việt Nam','Quận 1','',10.7709,106.693,'','','37 Nguyễn Trãi','R','Phường Phạm Ngũ Lão'),(7,'2021-07-19 20:05:06','2021-07-19 20:05:06','Hồ Chí Minh','Việt Nam','Quận Tân Bình','',10.8059,106.641,'','','55 Nguyễn Đức Thuận','R','Phường 13'),(8,'2021-07-19 20:05:06','2021-07-19 20:05:06','Hồ Chí Minh','Việt Nam','Quận Tân Bình','',10.7851,106.642,'','','644 Âu Cơ','R','Phường 10'),(9,'2021-07-19 20:05:06','2021-07-19 20:05:06','Hồ Chí Minh','Việt Nam','Quận Tân Phú','',NULL,NULL,'','','55 Hòa Bình','R','Tân Thới Hoà'),(10,'2021-07-19 20:05:06','2021-07-19 20:05:06','Hồ Chí Minh','Việt Nam','Quận 1','',NULL,NULL,'','','17 Lê Duẩn','R','Phường Bến Nghé'),(11,'2021-07-19 20:05:06','2021-07-19 20:05:06','Hồ Chí Minh','Việt Nam','Gò Vấp','',NULL,NULL,'','','169 Phạm Ngũ Lão','R','Phường 3'),(12,'2021-07-19 20:05:06','2021-07-19 20:05:06','Hồ Chí Minh','Việt Nam','Quận 1','',NULL,NULL,'','','235 Đ. Nguyễn Văn Cừ','R','Phường Nguyễn Cư Trinh'),(13,'2021-07-19 20:05:06','2021-07-19 20:05:06','Hồ Chí Minh','Việt Nam','Tân Bình','',NULL,NULL,'','','335A Lê Văn Sỹ','R','Phường 1'),(14,'2021-07-19 20:05:06','2021-07-19 20:05:06','Hồ Chí Minh','Việt Nam','Quận 1','',NULL,NULL,'','','220  Đ. Nguyễn Văn Cừ','R','Phường Nguyễn Cư Trinh'),(15,'2021-07-19 20:05:06','2021-07-19 20:05:06','Hồ Chí Minh','Việt Nam','Tân Bình','',NULL,NULL,'','','19-163 Cộng Hòa','R','Phường 12'),(16,'2021-07-19 20:05:06','2021-07-19 20:05:06','Hồ Chí Minh','Việt Nam','Tân Bình','',NULL,NULL,'','','61 Nguyễn Minh Hoàng','R','Phường 12'),(17,'2021-07-19 20:05:06','2021-07-19 20:05:06','Hồ Chí Minh','Việt Nam','Tân Bình','',NULL,NULL,'','','1A Lê Bình','R','Phường 4'),(18,'2021-07-19 20:05:06','2021-07-19 20:05:06','Hồ Chí Minh','Việt Nam','Tân Bình','',NULL,NULL,'','','1 Lý Thường Kiệt','R','Phường 7'),(19,'2021-07-19 20:05:06','2021-07-19 20:05:06','Hồ Chí Minh','Việt Nam','Tân Phú','',NULL,NULL,'','','5 Gò Dầu','R','Tân Quý'),(20,'2021-07-19 20:05:06','2021-07-19 20:05:06','Hồ Chí Minh','Việt Nam','Tân Phú','',NULL,NULL,'','','145 Đ. Độc Lập','R','Tân Thạnh'),(25,'2021-08-01 16:40:42','2021-08-01 16:40:42',NULL,'VN','tan phu',NULL,NULL,NULL,NULL,'11','332/58',NULL,'phu thah'),(26,'2021-08-01 16:46:15','2021-08-01 16:46:15',NULL,'VN','tan phu',NULL,NULL,NULL,NULL,'11','332/58',NULL,'phu thah'),(27,'2021-08-01 21:26:54','2021-08-01 21:26:54',NULL,'989989','Tân Phú',NULL,NULL,NULL,NULL,'70','332/58',NULL,'Phú Thạnh'),(28,'2021-08-01 21:27:48','2021-08-01 21:27:48',NULL,'989989','Tân Phú',NULL,NULL,NULL,NULL,'70','332/58',NULL,'Phú Thạnh'),(29,'2021-08-01 23:24:58','2021-08-01 23:24:58',NULL,'','tan phu',NULL,NULL,NULL,NULL,'11','332/58',NULL,'phu thah'),(30,'2021-08-01 23:25:01','2021-08-01 23:25:01',NULL,'','tan phu',NULL,NULL,NULL,NULL,'11','332/58',NULL,'phu thah'),(31,'2021-08-01 23:25:03','2021-08-01 23:25:03',NULL,'','tan phu',NULL,NULL,NULL,NULL,'11','332/58',NULL,'phu thah'),(32,'2021-08-01 23:25:04','2021-08-01 23:25:04',NULL,'','tan phu',NULL,NULL,NULL,NULL,'11','332/58',NULL,'phu thah'),(33,'2021-08-02 00:29:16','2021-08-02 00:29:16',NULL,'','tan phu',NULL,NULL,NULL,NULL,'11','332/58',NULL,'phu thah'),(34,'2021-08-02 00:40:27','2021-08-02 00:40:27',NULL,'','',NULL,NULL,NULL,NULL,'','',NULL,''),(35,'2021-08-02 00:40:29','2021-08-02 00:40:29',NULL,'','',NULL,NULL,NULL,NULL,'','',NULL,''),(36,'2021-08-02 00:40:30','2021-08-02 00:40:30',NULL,'','',NULL,NULL,NULL,NULL,'','',NULL,''),(37,'2021-08-02 00:40:30','2021-08-02 00:40:30',NULL,'','',NULL,NULL,NULL,NULL,'','',NULL,''),(38,'2021-08-02 00:43:28','2021-08-02 00:43:28',NULL,'VN','tan phu',NULL,NULL,NULL,NULL,'11','332/58',NULL,'phu thah'),(39,'2021-08-02 03:25:33','2021-08-02 03:25:33',NULL,'Vietnam','Tân phú',NULL,NULL,NULL,NULL,'11','332/58',NULL,'Phú Thạnh'),(40,'2021-08-02 03:31:55','2021-08-02 03:31:55',NULL,'Vietnam','Tân phú',NULL,NULL,NULL,NULL,'11','332/58',NULL,'Phú Thạnh'),(41,'2021-08-02 03:33:58','2021-08-02 03:33:58',NULL,'Vietnam','Tân phú',NULL,NULL,NULL,NULL,'11','332/58',NULL,'Phú Thạnh'),(42,'2021-08-02 03:36:00','2021-08-02 03:36:00',NULL,'Vietnam','Tân phú',NULL,NULL,NULL,NULL,'11','332/58',NULL,'Phú Thạnh'),(43,'2021-08-02 03:39:48','2021-08-02 03:39:48',NULL,'Vietnam','Tân phú',NULL,NULL,NULL,NULL,'11','332/58',NULL,'Phú Thạnh'),(44,'2021-08-02 03:40:04','2021-08-02 03:40:04',NULL,'Vietnam','Tân phú',NULL,NULL,NULL,NULL,'11','332/58',NULL,'Phú Thạnh'),(45,'2021-08-02 03:45:13','2021-08-02 03:45:13',NULL,'Vietnam','Tân phú',NULL,NULL,NULL,NULL,'11','332/58',NULL,'Phú Thạnh'),(46,'2021-08-02 03:46:31','2021-08-02 03:46:31',NULL,'Vietnam','Tân phú',NULL,NULL,NULL,NULL,'11','332/58',NULL,'Phú Thạnh'),(47,'2021-08-02 03:47:17','2021-08-02 03:47:17',NULL,'Vietnam','Tân phú',NULL,NULL,NULL,NULL,'11','332/58',NULL,'Phú Thạnh'),(48,'2021-08-02 03:49:30','2021-08-02 03:49:30',NULL,'Vietnam','Tân phú',NULL,NULL,NULL,NULL,'11','332/58',NULL,'Phú Thạnh'),(49,'2021-08-02 03:53:32','2021-08-02 03:53:32',NULL,'Vietnam','Tân phú',NULL,NULL,NULL,NULL,'11','332/58',NULL,'Phú Thạnh'),(50,'2021-08-02 03:55:54','2021-08-02 03:55:54',NULL,'Vietnam','Tân phú',NULL,NULL,NULL,NULL,'11','332/58',NULL,'Phú Thạnh'),(51,'2021-08-02 19:35:10','2021-08-02 19:35:10',NULL,'Vietnam','Tân Phú',NULL,NULL,NULL,NULL,'11','332/58',NULL,'Phú Thạnh'),(52,'2021-08-02 19:35:48','2021-08-02 19:35:48',NULL,'Vietnam','Tân Phú',NULL,NULL,NULL,NULL,'11','332/58',NULL,'Phú Thạnh'),(53,'2021-08-08 18:06:52','2021-08-08 18:06:52',NULL,'08404','HCM',NULL,NULL,NULL,NULL,'11','332/58',NULL,'Tân Phú'),(54,'2021-08-09 13:51:52','2021-08-09 13:51:52',NULL,'','Tân Phu',NULL,NULL,NULL,NULL,'11','332/58',NULL,'Phú Thạnh'),(55,'2021-08-13 19:29:51','2021-08-13 19:29:51',NULL,'Vietnam','Quận Tân Phú',NULL,NULL,NULL,NULL,'11','332/58',NULL,'Phường Phú Thạnh'),(56,'2021-08-13 19:37:12','2021-08-13 19:37:12',NULL,'Vietnam','Quận Tân Phú',NULL,NULL,NULL,NULL,'11','332/58',NULL,'Phường Phú Thạnh'),(57,'2021-08-13 19:38:04','2021-08-13 19:38:04',NULL,'Vietnam','Quận Tân Phú',NULL,NULL,NULL,NULL,'11','332/58',NULL,'Phường Phú Thạnh'),(58,'2021-08-13 19:40:49','2021-08-13 19:40:49',NULL,'Vietnam','Quận Tân Phú',NULL,NULL,NULL,NULL,'11','332/58',NULL,'Phường Phú Thạnh'),(59,'2021-08-13 19:45:12','2021-08-13 19:45:12',NULL,'Vietnam','Quận Tân Phú',NULL,NULL,NULL,NULL,'11','332/58',NULL,'Phường Phú Thạnh'),(60,'2021-08-13 19:45:59','2021-08-13 19:45:59',NULL,'Vietnam','Quận Tân Phú',NULL,NULL,NULL,NULL,'11','332/58',NULL,'Phường Phú Thạnh'),(61,'2021-08-16 01:44:07','2021-08-16 01:44:07',NULL,'VNM','Quận Tân Phú',NULL,NULL,NULL,NULL,'','144 tran huy liệu ',NULL,'Phường Phú Thạnh'),(62,'2021-08-16 15:16:23','2021-08-16 15:16:23',NULL,'VNM','Quận Tân Phú',NULL,NULL,NULL,NULL,'','74 Đường Quách Đình Bảo',NULL,'Phường Phú Thạnh'),(63,'2021-08-16 15:22:52','2021-08-16 15:22:52',NULL,'VNM','Quận Tân Phú',NULL,NULL,NULL,NULL,'','74 Đường Quách Đình Bảo',NULL,'Phường Phú Thạnh');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKdwk6cx0afu8bs9o4t536v1j5v` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'khoaimiday@gmail.com','Huy Vu','909656766'),(2,'khoaimiday@yahoo.com','Huy','909656766');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dish_category`
--

DROP TABLE IF EXISTS `dish_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dish_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dish_category`
--

LOCK TABLES `dish_category` WRITE;
/*!40000 ALTER TABLE `dish_category` DISABLE KEYS */;
INSERT INTO `dish_category` VALUES (1,'Thức ăn nhanh'),(2,'Ăn vặt'),(3,'Ăn sáng'),(4,'Đồ uống'),(5,'Nhà hàng');
/*!40000 ALTER TABLE `dish_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dishes`
--

DROP TABLE IF EXISTS `dishes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dishes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `is_active` bit(1) DEFAULT b'1',
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `quantity` int(11) DEFAULT '0',
  `rate_total` float DEFAULT '0',
  `unit` varchar(255) DEFAULT NULL,
  `dish_category_id` bigint(20) DEFAULT NULL,
  `offer_id` bigint(20) DEFAULT NULL,
  `restaurant_id` bigint(20) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `rate` float DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FKb4o7dmpl17soep9keptqnbdj4` (`dish_category_id`),
  KEY `FK27b34jc2l2e72o1b7bac58a8l` (`offer_id`),
  KEY `FKpslsa9mci7gsfhwukb3mx7s6n` (`restaurant_id`),
  CONSTRAINT `FK27b34jc2l2e72o1b7bac58a8l` FOREIGN KEY (`offer_id`) REFERENCES `offers` (`id`),
  CONSTRAINT `FKb4o7dmpl17soep9keptqnbdj4` FOREIGN KEY (`dish_category_id`) REFERENCES `dish_category` (`id`),
  CONSTRAINT `FKpslsa9mci7gsfhwukb3mx7s6n` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dishes`
--

LOCK TABLES `dishes` WRITE;
/*!40000 ALTER TABLE `dishes` DISABLE KEYS */;
INSERT INTO `dishes` VALUES (1,'2021-07-19 19:50:52','2021-07-19 19:50:52','https://res.cloudinary.com/huyhuynh/image/upload/v1629073938/banhmy_xxsmbv.jpg',_binary '','Bánh mì thịt',15000.00,0,0,'0',3,NULL,1,'bánh mì siêu ngon',0),(2,'2021-07-19 19:50:52','2021-07-19 19:50:52','https://res.cloudinary.com/huyhuynh/image/upload/v1629073938/banhmy_xxsmbv.jpg',_binary '','Bánh mì bì',13000.00,0,0,'0',3,NULL,1,'bánh mì siêu ngon',0),(3,'2021-07-19 19:50:52','2021-07-19 19:50:52','https://res.cloudinary.com/huyhuynh/image/upload/v1629073938/banhmy_xxsmbv.jpg',_binary '','Bánh mì ốp la',18000.00,0,0,'0',3,NULL,1,'bánh mì siêu ngon',0),(4,'2021-07-19 19:50:52','2021-07-19 19:50:52','https://res.cloudinary.com/huyhuynh/image/upload/v1629073940/comsuon_zc1kqa.jpg',_binary '','Cơm tấm sườn',25000.00,0,0,'0',3,NULL,1,'cơm với sườn không',0),(5,'2021-07-19 19:50:52','2021-07-19 19:50:52','https://res.cloudinary.com/huyhuynh/image/upload/v1629073940/comsuon_zc1kqa.jpg',_binary '','Cơm tấm sườn chả',30000.00,0,0,'0',3,NULL,1,'cơm với sườn + chả',0),(6,'2021-07-22 13:07:21','2021-07-22 13:07:21','https://res.cloudinary.com/huyhuynh/image/upload/v1629073942/travai_vujm8u.jpg',_binary '','Trà vải tươi dằm',40000.00,0,0,'0',4,NULL,3,'thức uống',0),(7,'2021-07-22 13:07:21','2021-07-22 13:07:21','https://res.cloudinary.com/huyhuynh/image/upload/v1629073942/tradao_shk1p4.jpg',_binary '','Trà đào đá xay',65000.00,0,0,'0',4,NULL,3,'thức uống',0),(9,'2021-07-22 13:13:29','2021-07-22 13:13:29','https://res.cloudinary.com/huyhuynh/image/upload/v1629073942/trasua_qu43md.png',_binary '','Trà sữa Phúc Long',50000.00,0,0,'0',4,NULL,3,'thức uống',0),(10,'2021-07-22 13:13:29','2021-07-22 13:13:29','https://res.cloudinary.com/huyhuynh/image/upload/v1629073942/tradao_shk1p4.jpg',_binary '','Trà đào Phúc Long',55000.00,0,0,'0',4,NULL,3,'thức uống',0),(11,'2021-07-22 13:19:53','2021-07-22 13:19:53','https://res.cloudinary.com/huyhuynh/image/upload/v1629073938/capuchino_umbbqx.jpg',_binary '','Cà Phê Cappuccino',46000.00,0,0,'0',4,NULL,3,'thức uống',0),(12,'2021-07-22 13:26:34','2021-07-22 13:26:34','https://res.cloudinary.com/huyhuynh/image/upload/v1629073941/suachua_seue3f.jpg',_binary '','Sữa Chua Phúc Bồn Tử Đác Cam',65000.00,0,0,'0',4,NULL,3,'thức uống',0),(13,'2021-07-22 13:26:34','2021-07-22 13:26:34','https://res.cloudinary.com/huyhuynh/image/upload/v1629073938/capheden_iebngs.jpg',_binary '','Cà Phê Đen',38000.00,0,0,'0',4,NULL,3,'thức uống',0),(14,'2021-07-22 13:29:49','2021-07-22 13:29:49','https://res.cloudinary.com/huyhuynh/image/upload/v1629073941/pizza_x8yjvf.jpg',_binary '','Pizza Bò & Tôm Nướng Kiểu Mỹ - Surf & Turf',89000.00,0,0,'0',1,NULL,14,'Pizza',0),(15,'2021-07-22 13:29:49','2021-07-22 13:29:49','https://res.cloudinary.com/huyhuynh/image/upload/v1629073940/pizza2_l1yk3d.jpg',_binary '','Pizza Hải Sản Xốt Cà Chua - Seafood Delight',89000.00,0,0,'0',1,NULL,14,'Pizza',0),(16,'2021-07-22 13:33:11','2021-07-22 13:33:11','https://res.cloudinary.com/huyhuynh/image/upload/v1629073941/pizza3_ljbzop.jpg',_binary '','Pizza Xúc Xích Ý Truyền Thống - Pepperoni Feast',89000.00,0,0,'0',1,NULL,14,'Pizza',0),(17,'2021-07-22 13:33:11','2021-07-22 13:33:11','https://res.cloudinary.com/huyhuynh/image/upload/v1629073940/pizza2_l1yk3d.jpg',_binary '','Pizza Thập Cẩm Thượng Hạng - Extravaganza',89000.00,0,0,'0',1,NULL,14,'Pizza',0),(18,'2021-07-22 13:46:11','2021-07-22 13:46:11','https://res.cloudinary.com/huyhuynh/image/upload/v1629073940/myy_eedtm6.jpg',_binary '','Mì Ý Hải Sản Đút Lò',79000.00,0,0,'0',1,NULL,14,'Mỳ Ý',0),(19,'2021-07-22 13:46:11','2021-07-22 13:46:11','https://res.cloudinary.com/huyhuynh/image/upload/v1629073940/myy_eedtm6.jpg',_binary '','Mì Ý Bò Bằm Đút Lò\r\n',79000.00,0,0,'0',1,NULL,14,'Mỳ Ý',0),(20,'2021-07-22 13:48:15','2021-07-22 13:48:15','https://res.cloudinary.com/huyhuynh/image/upload/v1629073939/coca_pk2uu0.jpg',_binary '','coca-cola',40.00,0,0,'0',4,NULL,14,'thức uống',0),(21,'2021-07-22 13:55:14','2021-07-22 13:55:14','https://res.cloudinary.com/huyhuynh/image/upload/v1629073940/fanta_mueegh.jpg',_binary '','Fanta',40.00,0,0,'0',4,NULL,14,'thức uống',0),(22,'2021-07-22 13:55:14','2021-07-22 13:55:14','https://res.cloudinary.com/huyhuynh/image/upload/v1629073941/sprite_kji6dw.jpg',_binary '','Sprite',40000.00,0,0,'0',4,NULL,14,'thức uống',0),(23,'2021-07-22 13:55:14','2021-07-22 13:55:14','https://res.cloudinary.com/huyhuynh/image/upload/v1629073938/banhtrang_mposzu.jpg',_binary '','Bánh tráng mỡ hành',20000.00,0,0,'0',2,NULL,20,'Ăn vặt',0),(24,'2021-07-22 13:55:14','2021-07-22 13:55:14','https://res.cloudinary.com/huyhuynh/image/upload/v1629073938/banhtrang_mposzu.jpg',_binary '','Bánh tráng me',20000.00,0,0,'0',2,NULL,20,'Ăn vặt',0),(25,'2021-07-22 14:06:25','2021-07-22 14:06:25','https://res.cloudinary.com/huyhuynh/image/upload/v1629073939/cavien_xy5kwz.jpg',_binary '','Cá viên chiên',40000.00,0,0,'0',2,NULL,20,'đồ chiên',0),(26,'2021-07-22 14:06:25','2021-07-22 14:06:25','https://res.cloudinary.com/huyhuynh/image/upload/v1629073939/cavien_xy5kwz.jpg',_binary '','Bò viên chiên',40000.00,0,0,'0',2,NULL,20,'đồ chiên',0),(27,'2021-07-22 14:38:52','2021-07-22 14:38:52','https://res.cloudinary.com/huyhuynh/image/upload/v1629073939/banhtrangnuong_echb5r.jpg',_binary '','bánh tráng nướng',15000.00,0,0,'0',2,NULL,16,'ăn vặt',0),(28,'2021-07-22 14:38:52','2021-07-22 14:38:52','https://res.cloudinary.com/huyhuynh/image/upload/v1629073939/banhtranglongan_dh64uj.jpg',_binary '','bánh tráng long an',20000.00,0,0,'0',2,NULL,16,'ăn vặt',0),(29,'2021-07-22 15:56:08','2021-07-22 15:56:08','https://res.cloudinary.com/huyhuynh/image/upload/v1629073942/trasenvang_k9htcf.png',_binary '','Trà sen vàng',55000.00,0,0,'0',4,NULL,4,'thức uống',0),(30,'2021-07-22 15:56:08','2021-07-22 15:56:08','https://res.cloudinary.com/huyhuynh/image/upload/v1629073943/trathachvai_w0u5fu.png',_binary '','Trà thạch vải',55000.00,0,0,'0',4,NULL,4,'đồ uống',0),(31,'2021-07-22 16:00:27','2021-07-22 16:00:27','https://res.cloudinary.com/huyhuynh/image/upload/v1629073938/capheden_iebngs.jpg',_binary '','Cà phê phin',50000.00,0,0,'0',4,NULL,4,'đồ uống',0),(32,'2021-07-22 16:00:27','2021-07-22 16:00:27','https://res.cloudinary.com/huyhuynh/image/upload/v1629073940/freeze_mowqvx.png',_binary '','Frezze cà phê phin',65.00,0,0,'0',4,NULL,4,'đồ uống',0),(33,'2021-07-22 16:03:18','2021-07-22 16:03:18','https://res.cloudinary.com/huyhuynh/image/upload/v1629073941/supcahoi_nr1he4.png',_binary '','Súp cá hồi',100000.00,0,0,'0',5,NULL,21,'Súp',0),(34,'2021-07-22 16:03:18','2021-07-22 16:03:18','',_binary '','Súp hải sản',100000.00,0,0,'0',5,NULL,21,'Súp',0),(35,'2021-07-22 16:04:37','2021-07-22 16:04:37','https://res.cloudinary.com/huyhuynh/image/upload/v1629073942/suoncuu_gl15bg.png\r\n',_binary '','Sườn cừu nướng',500000.00,0,0,'0',5,NULL,21,'món ăn cao cấp',0),(36,'2021-07-22 16:04:37','2021-07-22 16:04:37','https://res.cloudinary.com/huyhuynh/image/upload/v1629073942/tomhum_vidiun.jpg',_binary '','Tôm hùm hấp bia',2000000.00,0,0,'0',5,NULL,21,'món ăn cao cấp',0),(37,'2021-07-22 16:09:32','2021-07-22 16:09:32','https://res.cloudinary.com/huyhuynh/image/upload/v1629073939/comsuon2_i4bdmb.jpg',_binary '','Cơm tấm',45000.00,0,0,'0',3,NULL,8,'cơm',0),(38,'2021-07-22 16:09:32','2021-07-22 16:09:32','https://res.cloudinary.com/huyhuynh/image/upload/v1629073939/comsuon2_i4bdmb.jpg',_binary '','Cơm trứng ốp la',40000.00,0,0,'0',3,NULL,8,'cơm',0),(39,'2021-07-22 16:20:13','2021-07-22 16:20:13','https://res.cloudinary.com/huyhuynh/image/upload/v1629073940/lau_dfqbph.jpg',_binary '','Lẩu bình thường',900000.00,0,0,'0',5,NULL,13,'lẩu',0),(40,'2021-07-22 16:20:13','2021-07-22 16:20:13','https://res.cloudinary.com/huyhuynh/image/upload/v1629073940/lau_dfqbph.jpg',_binary '','Lẩu đặc biệt',1500000.00,0,0,'0',5,NULL,13,'lẩu',0),(41,'2021-07-22 16:22:20','2021-07-22 16:22:20','https://res.cloudinary.com/huyhuynh/image/upload/v1629073940/lau_dfqbph.jpg',_binary '','Lẩu uyên ương',1000000.00,0,0,'0',5,NULL,13,'lẩu',0),(42,'2021-07-22 16:22:20','2021-07-22 16:22:20','https://res.cloudinary.com/huyhuynh/image/upload/v1629073940/lau_dfqbph.jpg',_binary '','Lẩu 4 ngăn',2000000.00,0,0,'0',5,NULL,13,'lẩu',0),(43,'2021-07-22 16:24:48','2021-07-22 16:24:48','https://res.cloudinary.com/huyhuynh/image/upload/v1629073940/hutieu_f7d8wi.jpg',_binary '','Hủ tiếu bình thường',40.00,0,0,'0',3,NULL,19,'hủ tiếu',0),(44,'2021-07-22 16:24:48','2021-07-22 16:24:48','https://res.cloudinary.com/huyhuynh/image/upload/v1629073940/hutieu_f7d8wi.jpg',_binary '','Hủ tiếu đặc biệt',65000.00,0,0,'0',3,NULL,19,'hủ tiếu',0),(45,'2021-07-22 16:27:41','2021-07-22 16:27:41','https://res.cloudinary.com/huyhuynh/image/upload/v1629073940/hutieu_f7d8wi.jpg',_binary '','Hủ tiếu Mỹ Tho',40.00,0,0,'0',3,NULL,19,'hủ tiếu',0),(46,'2021-07-22 16:27:41','2021-07-22 16:27:41','https://res.cloudinary.com/huyhuynh/image/upload/v1629073940/hutieu_f7d8wi.jpg',_binary '','Hủ tiếu Mỹ Tho đặc biệt',80000.00,0,0,'0',3,NULL,19,'hộp',0),(47,'2021-07-22 16:30:00','2021-07-22 16:30:00','https://res.cloudinary.com/huyhuynh/image/upload/v1629073940/pho_ahektp.jpg',_binary '','Phở gà',40.00,0,0,'0',3,NULL,18,'phở',0),(48,'2021-07-22 16:30:00','2021-07-22 16:30:00','https://res.cloudinary.com/huyhuynh/image/upload/v1629073940/pho_ahektp.jpg',_binary '','Phở gà đặc biệt',65.00,0,0,'0',3,NULL,18,'hộp',0),(49,'2021-07-22 16:31:59','2021-07-22 16:31:59','https://res.cloudinary.com/huyhuynh/image/upload/v1629073939/cua_fqwt85.jpg',_binary '','Cua rang me',100000.00,0,0,'0',5,NULL,12,'hải sản',0);
/*!40000 ALTER TABLE `dishes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favourite`
--

DROP TABLE IF EXISTS `favourite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favourite` (
  `restaurant_id` bigint(20) NOT NULL,
  `customer_id` bigint(20) NOT NULL,
  PRIMARY KEY (`customer_id`,`restaurant_id`),
  KEY `FK4pjqxqdnp03fy7junt2eer8c6` (`restaurant_id`),
  CONSTRAINT `FK4pjqxqdnp03fy7junt2eer8c6` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`),
  CONSTRAINT `FKcwvy3mff4gwdf1vorfrwrv2s0` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favourite`
--

LOCK TABLES `favourite` WRITE;
/*!40000 ALTER TABLE `favourite` DISABLE KEYS */;
INSERT INTO `favourite` VALUES (2,1),(4,2);
/*!40000 ALTER TABLE `favourite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offers`
--

DROP TABLE IF EXISTS `offers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `offers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `actived_date` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `discount_percent` int(11) DEFAULT NULL,
  `expired_date` datetime DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `price_promo` decimal(19,2) DEFAULT NULL,
  `restaurant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpttkq4csfo8x0rceynl715rhp` (`restaurant_id`),
  CONSTRAINT `FKpttkq4csfo8x0rceynl715rhp` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offers`
--

LOCK TABLES `offers` WRITE;
/*!40000 ALTER TABLE `offers` DISABLE KEYS */;
INSERT INTO `offers` VALUES (1,'2021-08-16 00:00:00','2021-08-16 00:00:00','2021-08-16 00:00:00','20210823',10,'2021-08-23 00:00:00',NULL,0.00,1),(2,'2021-08-09 00:00:00','2021-08-13 00:00:00','2021-08-13 00:00:00','20210823',10,'2021-08-19 00:00:00',NULL,0.00,3),(3,'2021-08-09 00:00:00','2021-08-13 00:00:00','2021-08-13 00:00:00','20210823',15,'2021-08-29 00:00:00',NULL,0.00,4),(4,'2021-08-09 00:00:00','2021-08-09 00:00:00','2021-08-09 00:00:00','20210724',10,'2021-08-14 00:00:00',NULL,0.00,1);
/*!40000 ALTER TABLE `offers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `dishes_id` bigint(20) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `original_price` decimal(19,2) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `selling_price` decimal(19,2) DEFAULT NULL,
  `unit_price` decimal(19,2) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt4dc2r9nbvbujrljv3e23iibt` (`order_id`),
  CONSTRAINT `FKt4dc2r9nbvbujrljv3e23iibt` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
INSERT INTO `order_item` VALUES (1,'2021-08-16 01:44:07','2021-08-16 01:44:07',3,'https://res.cloudinary.com/huyhuynh/image/upload/v1629073938/banhmy_xxsmbv.jpg',NULL,2,NULL,18000.00,1),(2,'2021-08-16 01:44:07','2021-08-16 01:44:07',1,'https://res.cloudinary.com/huyhuynh/image/upload/v1629073938/banhmy_xxsmbv.jpg',NULL,3,NULL,15000.00,1),(3,'2021-08-16 01:44:07','2021-08-16 01:44:07',4,'https://res.cloudinary.com/huyhuynh/image/upload/v1629073940/comsuon_zc1kqa.jpg',NULL,2,NULL,25000.00,1),(4,'2021-08-16 01:44:07','2021-08-16 01:44:07',2,'https://res.cloudinary.com/huyhuynh/image/upload/v1629073938/banhmy_xxsmbv.jpg',NULL,3,NULL,13000.00,1),(5,'2021-08-16 15:16:23','2021-08-16 15:16:23',30,'https://res.cloudinary.com/huyhuynh/image/upload/v1629073943/trathachvai_w0u5fu.png',NULL,5,NULL,55000.00,2),(6,'2021-08-16 15:22:53','2021-08-16 15:22:53',6,'https://res.cloudinary.com/huyhuynh/image/upload/v1629073942/travai_vujm8u.jpg',NULL,1,NULL,40000.00,3),(7,'2021-08-16 15:22:53','2021-08-16 15:22:53',9,'https://res.cloudinary.com/huyhuynh/image/upload/v1629073942/trasua_qu43md.png',NULL,1,NULL,50000.00,3),(8,'2021-08-16 15:22:53','2021-08-16 15:22:53',12,'https://res.cloudinary.com/huyhuynh/image/upload/v1629073941/suachua_seue3f.jpg',NULL,1,NULL,65000.00,3);
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `offer_code` varchar(255) DEFAULT NULL,
  `order_tracking_number` varchar(255) DEFAULT NULL,
  `ship_money` decimal(19,2) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_price` decimal(19,2) DEFAULT NULL,
  `total_quantity` int(11) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `shipping_address_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK624gtjin3po807j3vix093tlf` (`customer_id`),
  KEY `FKh0uue95ltjysfmkqb5abgk7tj` (`shipping_address_id`),
  CONSTRAINT `FK624gtjin3po807j3vix093tlf` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKh0uue95ltjysfmkqb5abgk7tj` FOREIGN KEY (`shipping_address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2021-08-16 01:44:07','2021-08-16 01:44:07',NULL,'9835f580-a128-4225-a33f-8328ea8da870',12000.00,'Cash On Delivery',170000.00,10,1,61),(2,'2021-08-16 15:16:23','2021-08-16 15:16:23',NULL,'12ec6be4-3cd1-43dd-ab72-8444e8978d20',47640.00,'Cash On Delivery',275000.00,5,1,62),(3,'2021-08-16 15:22:53','2021-08-16 15:22:53',NULL,'f492478a-17e0-46b0-8f7e-05f5c5c6a049',97440.00,'Cash On Delivery',155000.00,3,2,63);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ratings`
--

DROP TABLE IF EXISTS `ratings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ratings` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `rate` float DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `restaurant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfqq64nc13hqj7yp8pts681p87` (`customer_id`),
  KEY `FKntiwrmxidegn417oxunmtnjpa` (`restaurant_id`),
  CONSTRAINT `FKfqq64nc13hqj7yp8pts681p87` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKntiwrmxidegn417oxunmtnjpa` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ratings`
--

LOCK TABLES `ratings` WRITE;
/*!40000 ALTER TABLE `ratings` DISABLE KEYS */;
INSERT INTO `ratings` VALUES (7,'2021-08-16 01:59:46','2021-08-16 01:59:46','ĐỒ ĂN NGON',4,1,13),(8,'2021-08-16 02:00:41','2021-08-16 02:00:41','Đồ uống ngon',4,1,3),(9,'2021-08-16 07:24:51','2021-08-16 07:24:51','Nhà Hàng Đẹp',4,1,1),(10,'2021-08-16 07:25:48','2021-08-16 07:25:48','Nhà hàng phục vụ tốt',4,1,1);
/*!40000 ALTER TABLE `ratings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurants`
--

DROP TABLE IF EXISTS `restaurants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurants` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `is_active` bit(1) DEFAULT b'1',
  `phone_number` varchar(255) DEFAULT NULL,
  `rate_count` int(11) DEFAULT '0',
  `rate_total` float DEFAULT '0',
  `address_id` bigint(20) DEFAULT NULL,
  `rate` float DEFAULT '0',
  `wish_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk34ytadhc6pmax9onb9uq640x` (`address_id`),
  CONSTRAINT `FKk34ytadhc6pmax9onb9uq640x` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurants`
--

LOCK TABLES `restaurants` WRITE;
/*!40000 ALTER TABLE `restaurants` DISABLE KEYS */;
INSERT INTO `restaurants` VALUES (1,'2021-07-19 19:49:33','2021-08-16 07:25:48','khoaimiday@gmail.com','Khoaimi restaurant','https://res.cloudinary.com/huyhuynh/image/upload/v1629075834/nhahang1_heglff.jpg',_binary '','0909656766',2,4,2,0,NULL),(2,'2021-07-19 19:49:33','2021-07-19 19:49:33','princyuyen@gmail.com','Princy restaurant','https://res.cloudinary.com/huyhuynh/image/upload/v1629075834/nhahang2_atdqhy.jpg',_binary '','0909188624',0,0,3,0,NULL),(3,'2021-07-22 12:17:35','2021-08-16 02:00:41','phuclong@gmail.com','Phúc Long','https://res.cloudinary.com/huyhuynh/image/upload/v1629075835/phuclong_mecupn.jpg',_binary '','0931231234',1,4,4,0,NULL),(4,'2021-07-22 12:17:35','2021-07-22 12:17:35','customerservice@highlandscoffee.com.vn','HighLand','https://res.cloudinary.com/huyhuynh/image/upload/v1629075834/highland_jg6x6a.jpg',_binary '','19001755',0,0,5,0,NULL),(7,'2021-07-22 12:22:25','2021-07-22 12:22:25','phohung@gmail.com','Phở Hùng','https://res.cloudinary.com/huyhuynh/image/upload/v1629075835/phohung_uqtrg5.jpg',_binary '','0908222444',0,0,6,0,NULL),(8,'2021-07-22 12:22:25','2021-07-22 12:22:25','thao1990@gmail.com','Cơm Tấm Thảo','https://res.cloudinary.com/huyhuynh/image/upload/v1629075833/comtamthao_xklqaz.jpg',_binary '','0775432100',0,0,7,0,NULL),(9,'2021-07-22 12:22:25','2021-07-22 12:22:25','tustore@gmail.com','Cô Tú','https://res.cloudinary.com/huyhuynh/image/upload/v1629075833/cotu_eefmjh.jpg',_binary '','0903789789',0,0,8,0,NULL),(10,'2021-07-22 12:22:25','2021-07-22 12:22:25','thienvu@gmail.com','Ăn vặt Thiên Vũ','https://res.cloudinary.com/huyhuynh/image/upload/v1629075835/thienvu_gt83yu.jpg',_binary '','0905257752',0,0,9,0,NULL),(11,'2021-07-22 12:22:25','2021-07-22 12:22:25','foodhouse@gmail.com','Nhà Hàng Ngon','https://res.cloudinary.com/huyhuynh/image/upload/v1629075834/nhahangngon_nvv230.jpg',_binary '','0901002233',0,0,10,0,NULL),(12,'2021-07-22 12:22:25','2021-07-22 12:22:25','foodhouse@gmail.com','Ẩm Thực Hải Sản','https://res.cloudinary.com/huyhuynh/image/upload/v1629075833/amthuchaisan_omlfzq.jpg',_binary '','028.3453456',0,0,11,0,NULL),(13,'2021-07-22 12:47:55','2021-08-16 01:59:46','foodhouse@gmail.com','Nhà hàng lẩu Hai Di Lao','https://res.cloudinary.com/huyhuynh/image/upload/v1629075834/haidilao_l6ltlm.jpg',_binary '','0862 000 271',1,4,12,0,NULL),(14,'2021-07-22 12:47:55','2021-07-22 12:47:55','foodhouse@gmail.com','Domino\'s Pizza','https://res.cloudinary.com/huyhuynh/image/upload/v1629075833/domino_esscso.jpg',_binary '','1900 6099',0,0,13,0,NULL),(15,'2021-07-22 12:47:55','2021-07-22 12:47:55','foodhouse@gmail.com','Cơm Gia Đình','https://res.cloudinary.com/huyhuynh/image/upload/v1629075833/comtam_qankra.jpg',_binary '','0862 000 271',0,0,14,0,NULL),(16,'2021-07-22 12:47:55','2021-07-22 12:47:55','foodhouse@gmail.com','Thiên Hương','https://res.cloudinary.com/huyhuynh/image/upload/v1629075835/thienhuong_eflbpf.jpg',_binary '','1900 6099',0,0,13,0,NULL),(17,'2021-07-22 12:47:55','2021-07-22 12:47:55','foodhouse@gmail.com','Bún Đậu Cô 2','https://res.cloudinary.com/huyhuynh/image/upload/v1629075834/nhahang1_heglff.jpg',_binary '','0862 000 271',0,0,15,0,NULL),(18,'2021-07-22 12:47:55','2021-07-22 12:47:55','foodhouse@gmail.com','Phở Nga','https://res.cloudinary.com/huyhuynh/image/upload/v1629075834/phobinh_isbd0n.jpg',_binary '','1900 6099',0,0,16,0,NULL),(19,'2021-07-22 12:47:55','2021-07-22 12:47:55','foodhouse@gmail.com','Hủ Tiếu Mỹ Tho','https://res.cloudinary.com/huyhuynh/image/upload/v1629075834/hutieu_lvyahi.jpg',_binary '','1900 6099',0,0,17,0,NULL),(20,'2021-07-22 12:47:55','2021-07-22 12:47:55','foodhouse@gmail.com','Cô Út','https://res.cloudinary.com/huyhuynh/image/upload/v1629075833/cout_p2bl4r.jpg',_binary '','1900 6099',0,0,18,0,NULL),(21,'2021-07-22 12:47:55','2021-07-22 12:47:55','foodhouse@gmail.com','Nhà Hàng Biển Đông','https://res.cloudinary.com/huyhuynh/image/upload/v1629075833/biendong_pwhcim.jpg',_binary '','1900 6099',0,0,19,0,NULL),(22,'2021-07-22 12:47:55','2021-07-22 12:47:55','foodhouse@gmail.com','Trà Sữa Cô Tám','https://res.cloudinary.com/huyhuynh/image/upload/v1629075835/trasua_xhzmqo.jpg',_binary '','1900 6099',0,0,20,0,NULL);
/*!40000 ALTER TABLE `restaurants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'2021-07-31 01:22:53','2021-07-31 01:22:53','ROLE_USER'),(2,'2021-07-31 01:23:01','2021-07-31 01:23:01','ROLE_MODERATOR'),(3,'2021-07-31 01:23:06','2021-07-31 01:23:06','ROLE_ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`user_id`),
  KEY `FKhfh9dx7w3ubf1co1vdev94g3f` (`user_id`),
  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `full_name` varchar(100) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `is_active` bit(1) DEFAULT b'1',
  `password` varchar(120) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `reset_password_token` varchar(255) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `verifycation_code` varchar(255) DEFAULT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKk8d0f2n7n88w1a16yhua64onx` (`user_name`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`),
  KEY `FKditu6lr4ek16tkxtdsne0gxib` (`address_id`),
  CONSTRAINT `FKditu6lr4ek16tkxtdsne0gxib` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2021-07-31 01:25:39','2021-07-31 01:25:39','','khoaimiday@gmail.com','Vũ Đức Huy','Male',_binary '','pemonhon','0909656766',NULL,'khoaimi',NULL,NULL),(13,'2021-08-15 23:28:58',NULL,NULL,'huyhuynh9693@gmail.com','Huynh Quoc Huy',NULL,NULL,'huy9693','0986032638',NULL,'huynhhuy',NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-17  9:14:52
