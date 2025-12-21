-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: sistemadesaparecimentos
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `disappearance`
--

DROP TABLE IF EXISTS `disappearance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disappearance` (
  `id_disappearance` int NOT NULL AUTO_INCREMENT,
  `dateDisappearance` date DEFAULT NULL,
  `hourDisappearance` time DEFAULT NULL,
  `location` varchar(200) DEFAULT NULL,
  `contextDisappearance` longtext,
  `clothesDisappearance` varchar(255) DEFAULT NULL,
  `id_peoples` int DEFAULT NULL,
  PRIMARY KEY (`id_disappearance`),
  KEY `id_peoples` (`id_peoples`),
  CONSTRAINT `disappearance_ibfk_1` FOREIGN KEY (`id_peoples`) REFERENCES `peoples` (`id_peoples`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disappearance`
--

LOCK TABLES `disappearance` WRITE;
/*!40000 ALTER TABLE `disappearance` DISABLE KEYS */;
INSERT INTO `disappearance` VALUES (21,'2025-10-14','22:37:00','Praça Central ','Estava saindo do trabalho e indo para casa.','Moletom Cinza, calça jeans escura e tênis preto',29),(22,'2025-07-08','22:01:00','Rodoviária de Curitiba','Foi vista pela última vez aguardando um ônibus para visitar um amigo. Testemunhas relataram que ele parecia ansioso e estava recebendo ligações constantes antes de desaparecer.','Vestido jeans e all star preto',31),(23,'2025-12-11','19:30:00','Faculdade','saindo da faculdade e sumiu ','calça jeans  e camiseta branca',32);
/*!40000 ALTER TABLE `disappearance` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-20 22:43:11
