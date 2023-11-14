-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: healthystyle
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `password_reset_token`
--

DROP TABLE IF EXISTS `password_reset_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `password_reset_token` (
  `id` int NOT NULL AUTO_INCREMENT,
  `token` varchar(255) NOT NULL,
  `user_id` bigint NOT NULL,
  `expiry_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `password_reset_token_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password_reset_token`
--

LOCK TABLES `password_reset_token` WRITE;
/*!40000 ALTER TABLE `password_reset_token` DISABLE KEYS */;
INSERT INTO `password_reset_token` VALUES (27,'893d392f-d7b1-4009-828e-21e7b9952d7b',1,'2023-10-24 21:47:41'),(28,'f2795ccf-2e55-4095-8279-32a07e43938e',1,'2023-10-24 21:51:14'),(29,'f82f469b-644c-4ad9-a660-04b1693efde0',1,'2023-10-25 12:45:51'),(30,'004328f8-3672-40b0-a8af-04cfcaf9ec87',1,'2023-10-25 13:32:26');
/*!40000 ALTER TABLE `password_reset_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posts` (
  `post_id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `date_added` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `description` text,
  `up_votes` int DEFAULT '0',
  `down_votes` int DEFAULT '0',
  `url_link` varchar(300) NOT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (1,'Secrets of a Healthy Lifestyle','2023-10-10 08:00:00','In this fascinating post, we will reveal the secrets of a healthy lifestyle. You will learn how to take care of your body and mind, maintain physical activity, follow a healthy diet, cope with stress, and much more. This handy lesson is perfect for those who want to lead a healthier, more active, and happier life.',119,90,'https://example.com/healthy-lifestyle-secrets'),(3,'The Art of Healthy Eating','2023-10-09 12:30:00','In this comprehensive article, we discuss the importance of healthy eating for your body and mind. You will learn about the role of vitamins, minerals, and which foods are worth including in your daily diet to maintain a healthy lifestyle. If you\'re interested in healthy eating and its impact on your well-being, this post is for you.',40,19,'https://example.com/healthy-eating-art'),(4,'Physical Activity and Its Benefits','2023-10-08 16:15:00','Recent studies have shown that regular physical activity has a tremendous impact on health. In this extensive article, we present the benefits of regular exercise, what types of activities are worth choosing to enjoy health and energy. Start your journey to a healthier lifestyle today!',18,2,'https://example.com/physical-activity-benefits'),(5,'5 Healthy Foods Worth Adding to Your Diet','2023-10-11 10:45:00','In this post, we discuss 5 healthy foods that you should consider adding to your daily diet. You will learn why these products are beneficial for your health and what nutritional properties they have.',20,3,'https://example.com/healthy-foods-4'),(6,'The Benefits of Healthy Eating for Your Body','2023-10-12 07:30:00','Healthy eating can have a tremendous impact on your body. We present the benefits of healthy eating for health and well-being. You will learn which products are worth including in your diet to enjoy long-term benefits.',15,2,'https://example.com/benefits-of-healthy-eating'),(7,'Healthy Breakfasts to Start Your Day','2023-10-13 05:15:00','The first meal of the day is important for a healthy lifestyle. In this article, we present healthy breakfasts that will provide you with energy and vitamins for the whole day. Discover ideas for delicious and nutritious breakfasts.',19,3,'https://example.com/healthy-breakfasts'),(8,'saddddd','2023-10-11 10:59:55','sadddddasdasdasd',1,1,'saddddd'),(9,'new','2023-10-11 15:35:10','new\r\n',1,2,'new'),(10,'123','2023-10-22 12:24:25','123',0,0,'123'),(11,'123','2023-10-25 12:30:28','123',0,0,'123');
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `description` varchar(5000) NOT NULL,
  `short_description` varchar(3000) NOT NULL,
  `category` enum('COSMETICS','BATON') NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `img_url` varchar(200) NOT NULL,
  `first_paragraph_title` varchar(100) NOT NULL,
  `first_paragraph_description` varchar(3000) NOT NULL,
  `second_paragraph_title` varchar(3000) NOT NULL,
  `second_paragraph_description` varchar(100) NOT NULL,
  `first_photo` varchar(100) NOT NULL,
  `second_photo` varchar(100) NOT NULL,
  `third_photo` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Organic Superfood Green Smoothie Mix','Elevate your daily nutrition with our organic superfood green smoothie mix. This nutrient-packed blend is specially crafted to support your health and well-being. We\'ve carefully selected organic kale, spinach, spirulina, and a variety of antioxidants to create a powerful mix that can be a game-changer for your diet. Start your day with a burst of energy and nutrients by blending it into a delicious smoothie. Alternatively, get creative and incorporate it into your recipes, from vibrant salads to revitalizing soups.','Nutrient-packed blend for a healthy lifestyle','COSMETICS',19.99,'honeyJar.png','Nutrient-Rich Ingredients','Our smoothie mix is a comprehensive source of vitamins, minerals, and antioxidants.','Versatile Usage','Integrate it into your daily routine for a healthier and more vibrant lifestyle.','smoothie1.jpg','smoothie2.jpg','smoothie3.jpg'),(2,'Organic Mixed Berries Protein Bars','Discover a delicious and health-conscious way to recharge after your workout or as a guilt-free snack throughout the day with our organic mixed berries protein bars. Each bar is a mouthwatering fusion of organic berries, nuts, and plant-based protein. Fuel your body with clean and sustainable energy. Our bars are entirely free from artificial additives and preservatives, ensuring you\'re consuming only the purest ingredients to support your fitness goals and active lifestyle.','Delicious protein bars for active individuals','BATON',12.99,'honeyJar.png','Plant-Powered Nutrition','Packed with organic berries, nuts, and plant-based protein.','Refuel and Recover','Elevate your daily nutrition with our organic mixed berries protein bars.','proteinBar1.png','proteinBar2.bmp','proteinBar3.png'),(3,'Natural Almond Trail Mix','Our natural almond trail mix is a delightful combination of roasted almonds, dried cranberries, and dark chocolate chunks. It\'s a guilt-free indulgence that provides energy and antioxidants. Perfect for hikers, runners, or as an on-the-go snack for busy days. Keep your energy levels high with this delicious mix.','Delicious and energy-boosting trail mix','COSMETICS',7.99,'honeyJar.png','Premium Ingredients','We use high-quality almonds, cranberries, and dark chocolate chunks.','On-the-Go Snack','Take it with you for a quick energy boost during your busy day.','almoundMix1.jpg','almoundMix2.jpg','almoundMix3.jpg'),(4,'Organic Turmeric Powder','Turmeric is a potent superfood known for its anti-inflammatory and antioxidant properties. Our organic turmeric powder is a high-quality spice that can elevate the flavor and health benefits of your meals. It\'s perfect for curries, soups, or golden milk. Turmeric supports joint health and overall well-being.','High-quality organic turmeric powder','COSMETICS',5.99,'honeyJar.png','Spice with Health Benefits','Turmeric is renowned for its anti-inflammatory and antioxidant properties.','Culinary Delight','Enhance your recipes with the rich flavor of turmeric for a healthier lifestyle.','urmericPowder1.jpg','urmericPowder2.jpg','urmericPowder3.jpg'),(5,'Organic Green Tea','Our organic green tea is a refreshing and healthful choice for tea enthusiasts. Green tea is renowned for its antioxidants and potential health benefits. It\'s a perfect companion for relaxation or as a hydrating beverage throughout the day. Enjoy the soothing and invigorating properties of green tea.','Certified organic green tea','COSMETICS',3.99,'honeyJar.png','Antioxidant-Rich Tea','Green tea is celebrated for its high antioxidant content.','Sip and Savor','Savor the refreshing taste of green tea for overall well-being.','greenTea1.jpg','greenTea2.jpg','greenTea3.jpg');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'QuanPL68@gmail.com','{noop}123'),(2,'user@example.com','{noop}userpass'),(3,'editor@example.com','{noop}editorpass'),(13,'123','{bcrypt}$2a$10$/fuNZt/ZkkNNA6rWUBQd7uZHayMYlojj.N0893bYMyeiRAJKIDw0W');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'ADMIN','pełne uprawnienia'),(2,'USER','podstawowe uprawnienia, możliwość oddawania głosów'),(3,'EDITOR','podstawowe uprawnienia + możliwość zarządzania treściami');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_user_roles_role_id` (`role_id`),
  CONSTRAINT `fk_user_roles_role_id` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`id`),
  CONSTRAINT `fk_user_roles_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1),(2,2),(3,2),(13,2);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote`
--

DROP TABLE IF EXISTS `vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vote` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `post_id` bigint NOT NULL,
  `voted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `post_id` (`post_id`),
  CONSTRAINT `vote_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote`
--

LOCK TABLES `vote` WRITE;
/*!40000 ALTER TABLE `vote` DISABLE KEYS */;
INSERT INTO `vote` VALUES (94,13,1,1),(95,13,3,0),(96,2,1,0);
/*!40000 ALTER TABLE `vote` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-14 17:18:55
