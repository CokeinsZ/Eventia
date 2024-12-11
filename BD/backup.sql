-- MySQL dump 10.13  Distrib 8.0.39, for Win64 (x86_64)
--
-- Host: localhost    Database: eventia
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `eventia`
--

/*!40000 DROP DATABASE IF EXISTS `eventia`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `eventia` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `eventia`;

--
-- Table structure for table `agenda_asientos`
--

DROP TABLE IF EXISTS `agenda_asientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agenda_asientos` (
  `agd_id` int NOT NULL,
  `ast_id` varchar(5) NOT NULL,
  `ubc_id` int NOT NULL,
  `estado` enum('reservado','fuera-servicio','libre') NOT NULL,
  PRIMARY KEY (`agd_id`,`ast_id`,`ubc_id`),
  KEY `ast_id` (`ast_id`,`ubc_id`),
  CONSTRAINT `agenda_asientos_ibfk_1` FOREIGN KEY (`agd_id`) REFERENCES `agendas` (`agd_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `agenda_asientos_ibfk_2` FOREIGN KEY (`ast_id`, `ubc_id`) REFERENCES `asientos` (`ast_id`, `ubc_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda_asientos`
--

LOCK TABLES `agenda_asientos` WRITE;
/*!40000 ALTER TABLE `agenda_asientos` DISABLE KEYS */;
INSERT INTO `agenda_asientos` VALUES (1,'A1',1,'libre'),(2,'A2',2,'libre'),(3,'A3',3,'libre'),(4,'A4',4,'libre'),(5,'A5',5,'libre'),(6,'A6',6,'libre'),(7,'A7',7,'libre'),(8,'A8',8,'libre'),(9,'A9',9,'libre'),(10,'A10',10,'libre'),(31,'A4',16,'libre'),(31,'F1A1',16,'libre'),(31,'F1A2',16,'libre'),(31,'F2A1',16,'libre'),(31,'F2A2',16,'libre'),(31,'F3A1',16,'libre'),(31,'F3A2',16,'libre'),(31,'F4A1',16,'libre'),(31,'F4A2',16,'libre'),(31,'F5A1',16,'libre'),(31,'F5A2',16,'libre');
/*!40000 ALTER TABLE `agenda_asientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agendas`
--

DROP TABLE IF EXISTS `agendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agendas` (
  `agd_id` int NOT NULL AUTO_INCREMENT,
  `ubc_id` int NOT NULL,
  `evt_id` int NOT NULL,
  `agd_fecha_inicio` datetime NOT NULL,
  `agd_fecha_fin` datetime DEFAULT NULL,
  `agd_estado` enum('activo','terminada') DEFAULT 'activo',
  PRIMARY KEY (`agd_id`),
  KEY `evt_id` (`evt_id`),
  KEY `ubc_id` (`ubc_id`),
  CONSTRAINT `agendas_ibfk_1` FOREIGN KEY (`evt_id`) REFERENCES `eventos` (`evt_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `agendas_ibfk_2` FOREIGN KEY (`ubc_id`) REFERENCES `ubicaciones` (`ubc_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agendas`
--

LOCK TABLES `agendas` WRITE;
/*!40000 ALTER TABLE `agendas` DISABLE KEYS */;
INSERT INTO `agendas` VALUES (1,1,1,'2023-01-01 10:00:00','2023-01-01 12:00:00','activo'),(2,2,2,'2023-02-01 10:00:00','2023-02-01 12:00:00','activo'),(3,3,3,'2023-03-01 10:00:00','2023-03-01 12:00:00','activo'),(4,4,4,'2023-04-01 10:00:00','2023-04-01 12:00:00','activo'),(5,5,5,'2023-05-01 10:00:00','2023-05-01 12:00:00','activo'),(6,6,6,'2023-06-01 10:00:00','2023-06-01 12:00:00','activo'),(7,7,7,'2023-07-01 10:00:00','2023-07-01 12:00:00','activo'),(8,8,8,'2023-08-01 10:00:00','2023-08-01 12:00:00','activo'),(9,9,9,'2023-09-01 10:00:00','2023-09-01 12:00:00','activo'),(10,10,10,'2023-10-01 10:00:00','2023-10-01 12:00:00','activo'),(31,16,1,'2026-01-01 10:00:00','2026-01-01 11:00:00','activo');
/*!40000 ALTER TABLE `agendas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asientos`
--

DROP TABLE IF EXISTS `asientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asientos` (
  `ast_id` varchar(5) NOT NULL,
  `ubc_id` int NOT NULL,
  PRIMARY KEY (`ast_id`,`ubc_id`),
  KEY `ubc_id` (`ubc_id`),
  CONSTRAINT `asientos_ibfk_1` FOREIGN KEY (`ubc_id`) REFERENCES `ubicaciones` (`ubc_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asientos`
--

LOCK TABLES `asientos` WRITE;
/*!40000 ALTER TABLE `asientos` DISABLE KEYS */;
INSERT INTO `asientos` VALUES ('A1',1),('A2',2),('A3',3),('A4',4),('A5',5),('A6',6),('A7',7),('A8',8),('A9',9),('A10',10),('A4',16),('F1A1',16),('F1A2',16),('F2A1',16),('F2A2',16),('F3A1',16),('F3A2',16),('F4A1',16),('F4A2',16),('F5A1',16),('F5A2',16);
/*!40000 ALTER TABLE `asientos` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`stive`@`localhost`*/ /*!50003 TRIGGER `incrementar_capacidad_ubicacion` AFTER INSERT ON `asientos` FOR EACH ROW BEGIN
  UPDATE ubicaciones
  SET ubc_capacidad = ubc_capacidad + 1
  WHERE ubc_id = NEW.ubc_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`stive`@`localhost`*/ /*!50003 TRIGGER `disminuir_capacidad_ubicacion` AFTER DELETE ON `asientos` FOR EACH ROW BEGIN
  UPDATE ubicaciones
  SET ubc_capacidad = ubc_capacidad - 1
  WHERE ubc_id = OLD.ubc_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `calificaciones`
--

DROP TABLE IF EXISTS `calificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calificaciones` (
  `cal_usuario` int NOT NULL DEFAULT '0',
  `cal_evento` int NOT NULL,
  `cal_comentario` text,
  `cal_num_estrellas` enum('1','2','3','4','5') NOT NULL,
  PRIMARY KEY (`cal_usuario`,`cal_evento`),
  KEY `cal_evento` (`cal_evento`),
  CONSTRAINT `calificaciones_ibfk_1` FOREIGN KEY (`cal_usuario`) REFERENCES `usuarios` (`usr_id`) ON DELETE SET DEFAULT ON UPDATE CASCADE,
  CONSTRAINT `calificaciones_ibfk_2` FOREIGN KEY (`cal_evento`) REFERENCES `eventos` (`evt_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calificaciones`
--

LOCK TABLES `calificaciones` WRITE;
/*!40000 ALTER TABLE `calificaciones` DISABLE KEYS */;
INSERT INTO `calificaciones` VALUES (1,1,'Great event!','5'),(2,2,'Good event','4'),(3,3,'Average event','3'),(4,4,'Not bad','4'),(5,5,'Excellent!','5'),(6,6,'Could be better','3'),(7,7,'Loved it','5'),(8,8,'Nice event','4'),(9,9,'Okay','3'),(10,10,'Fantastic','5');
/*!40000 ALTER TABLE `calificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `cat_id` int NOT NULL AUTO_INCREMENT,
  `cat_nombre` varchar(10) NOT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Music'),(2,'Art'),(3,'Tech'),(4,'Sports'),(5,'Education'),(6,'Health'),(7,'Business'),(8,'Food'),(9,'Travel'),(10,'Fashion');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento_categoria`
--

DROP TABLE IF EXISTS `evento_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evento_categoria` (
  `evt_id` int NOT NULL,
  `cat_id` int NOT NULL,
  PRIMARY KEY (`evt_id`,`cat_id`),
  KEY `cat_id` (`cat_id`),
  CONSTRAINT `evento_categoria_ibfk_1` FOREIGN KEY (`evt_id`) REFERENCES `eventos` (`evt_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `evento_categoria_ibfk_2` FOREIGN KEY (`cat_id`) REFERENCES `categorias` (`cat_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento_categoria`
--

LOCK TABLES `evento_categoria` WRITE;
/*!40000 ALTER TABLE `evento_categoria` DISABLE KEYS */;
INSERT INTO `evento_categoria` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10);
/*!40000 ALTER TABLE `evento_categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventos`
--

DROP TABLE IF EXISTS `eventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eventos` (
  `evt_id` int NOT NULL AUTO_INCREMENT,
  `evt_organizador` int NOT NULL,
  `evt_nombre` varchar(30) NOT NULL,
  `evt_descripcion` text,
  `evt_precio` float NOT NULL,
  PRIMARY KEY (`evt_id`),
  KEY `evt_organizador` (`evt_organizador`),
  CONSTRAINT `eventos_ibfk_1` FOREIGN KEY (`evt_organizador`) REFERENCES `usuarios` (`usr_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventos`
--

LOCK TABLES `eventos` WRITE;
/*!40000 ALTER TABLE `eventos` DISABLE KEYS */;
INSERT INTO `eventos` VALUES (1,3,'Event 1','Description 1',50),(2,3,'Event 2','Description 2',60),(3,4,'Event 3','Description 3',70),(4,4,'Event 4','Description 4',80),(5,5,'Event 5','Description 5',90),(6,5,'Event 6','Description 6',100),(7,6,'Event 7','Description 7',110),(8,6,'Event 8','Description 8',120),(9,7,'Event 9','Description 9',130),(10,7,'Event 10','Description 10',140);
/*!40000 ALTER TABLE `eventos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recargas`
--

DROP TABLE IF EXISTS `recargas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recargas` (
  `rec_id` int NOT NULL AUTO_INCREMENT,
  `usr_id` int NOT NULL,
  `rec_fecha` datetime NOT NULL,
  `rec_monto` float NOT NULL,
  `rec_estado` enum('pendiente','aprobada','rechazada') NOT NULL,
  PRIMARY KEY (`rec_id`),
  KEY `usr_id` (`usr_id`),
  CONSTRAINT `recargas_ibfk_1` FOREIGN KEY (`usr_id`) REFERENCES `usuarios` (`usr_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recargas`
--

LOCK TABLES `recargas` WRITE;
/*!40000 ALTER TABLE `recargas` DISABLE KEYS */;
INSERT INTO `recargas` VALUES (1,1,'2023-01-01 08:00:00',100,'aprobada'),(2,2,'2023-02-01 08:00:00',200,'aprobada'),(3,3,'2023-03-01 08:00:00',300,'aprobada'),(4,4,'2023-04-01 08:00:00',400,'aprobada'),(5,5,'2023-05-01 08:00:00',500,'aprobada'),(6,6,'2023-06-01 08:00:00',600,'aprobada'),(7,7,'2023-07-01 08:00:00',700,'aprobada'),(8,8,'2023-08-01 08:00:00',800,'aprobada'),(9,9,'2023-09-01 08:00:00',900,'aprobada'),(10,10,'2023-10-01 08:00:00',1000,'aprobada');
/*!40000 ALTER TABLE `recargas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservas` (
  `rsv_id` int NOT NULL AUTO_INCREMENT,
  `rsv_usuario` int NOT NULL,
  `rsv_agenda` int NOT NULL,
  `rsv_fecha` datetime NOT NULL,
  `rsv_asiento` varchar(5) DEFAULT NULL,
  `rsv_estado` enum('confirmada','pendiente','cancelada','completada') NOT NULL,
  PRIMARY KEY (`rsv_id`),
  KEY `rsv_usuario` (`rsv_usuario`),
  KEY `rsv_agenda` (`rsv_agenda`),
  KEY `rsv_asiento` (`rsv_asiento`),
  CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`rsv_usuario`) REFERENCES `usuarios` (`usr_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `reservas_ibfk_2` FOREIGN KEY (`rsv_agenda`) REFERENCES `agendas` (`agd_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `reservas_ibfk_3` FOREIGN KEY (`rsv_asiento`) REFERENCES `asientos` (`ast_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
INSERT INTO `reservas` VALUES (1,1,1,'2023-01-01 09:00:00','A1','confirmada'),(2,2,2,'2023-02-01 09:00:00','A2','confirmada'),(3,3,3,'2023-03-01 09:00:00','A3','confirmada'),(4,4,4,'2023-04-01 09:00:00','A4','confirmada'),(5,5,5,'2023-05-01 09:00:00','A5','confirmada'),(6,6,6,'2023-06-01 09:00:00','A6','confirmada'),(7,7,7,'2023-07-01 09:00:00','A7','confirmada'),(8,8,8,'2023-08-01 09:00:00','A8','confirmada'),(9,9,9,'2023-09-01 09:00:00','A9','confirmada'),(10,10,10,'2023-10-01 09:00:00','A10','confirmada');
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `rol_id` int NOT NULL AUTO_INCREMENT,
  `rol_nombre` varchar(30) NOT NULL,
  `rol_descripcion` text,
  PRIMARY KEY (`rol_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Admin','Administrator role'),(2,'User','Regular user role'),(3,'Organizer','Event organizer role');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transacciones`
--

DROP TABLE IF EXISTS `transacciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transacciones` (
  `trn_id` int NOT NULL AUTO_INCREMENT,
  `trn_usuario` int NOT NULL,
  `trn_reserva` int NOT NULL,
  `trn_fecha` datetime NOT NULL,
  `trn_tipo` enum('compra','devolucion','retiro','transferencia') NOT NULL,
  `trn_saldo_anterior` float NOT NULL,
  `trn_saldo_nuevo` float NOT NULL,
  PRIMARY KEY (`trn_id`),
  KEY `trn_usuario` (`trn_usuario`),
  CONSTRAINT `transacciones_ibfk_1` FOREIGN KEY (`trn_usuario`) REFERENCES `usuarios` (`usr_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transacciones`
--

LOCK TABLES `transacciones` WRITE;
/*!40000 ALTER TABLE `transacciones` DISABLE KEYS */;
INSERT INTO `transacciones` VALUES (1,1,1,'2023-01-01 09:30:00','compra',100,50),(2,2,2,'2023-02-01 09:30:00','compra',200,140),(3,3,3,'2023-03-01 09:30:00','compra',300,230),(4,4,4,'2023-04-01 09:30:00','compra',400,320),(5,5,5,'2023-05-01 09:30:00','compra',500,410),(6,6,6,'2023-06-01 09:30:00','compra',600,500),(7,7,7,'2023-07-01 09:30:00','compra',700,590),(8,8,8,'2023-08-01 09:30:00','compra',800,680),(9,9,9,'2023-09-01 09:30:00','compra',900,770),(10,10,10,'2023-10-01 09:30:00','compra',1000,860);
/*!40000 ALTER TABLE `transacciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ubicaciones`
--

DROP TABLE IF EXISTS `ubicaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ubicaciones` (
  `ubc_id` int NOT NULL AUTO_INCREMENT,
  `ubc_nombre` varchar(30) NOT NULL,
  `ubc_ciudad` varchar(30) NOT NULL,
  `ubc_direccion` text NOT NULL,
  `ubc_capacidad` int DEFAULT '0',
  PRIMARY KEY (`ubc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ubicaciones`
--

LOCK TABLES `ubicaciones` WRITE;
/*!40000 ALTER TABLE `ubicaciones` DISABLE KEYS */;
INSERT INTO `ubicaciones` VALUES (1,'Location 1','City 1','Address 1',1),(2,'Location 2','City 2','Address 2',1),(3,'Location 3','City 3','Address 3',1),(4,'Location 4','City 4','Address 4',1),(5,'Location 5','City 5','Address 5',1),(6,'Location 6','City 6','Address 6',1),(7,'Location 7','City 7','Address 7',1),(8,'Location 8','City 8','Address 8',1),(9,'Location 9','City 9','Address 9',1),(10,'Location 10','City 10','Address 10',1),(13,'Prueba','ChupameEstePenco','Allá, arribita de allá abajo',10),(14,'Prueba','ChupameEstePenco','Allá, arribita de allá abajo',10),(15,'Prueba','ChupameEstePenco','Allá, arribita de allá abajo',10),(16,'Prueba','ChupameEstePenco','Allá, arribita de allá abajo',11);
/*!40000 ALTER TABLE `ubicaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `usr_id` int NOT NULL AUTO_INCREMENT,
  `usr_correo` varchar(250) NOT NULL,
  `usr_contrasena` varchar(61) NOT NULL,
  `usr_saldo` float DEFAULT '0',
  `usr_nombre1` varchar(30) NOT NULL,
  `usr_nombre2` varchar(30) DEFAULT NULL,
  `usr_apellido1` varchar(30) NOT NULL,
  `usr_apellido2` varchar(30) DEFAULT NULL,
  `usr_telefono` varchar(15) DEFAULT NULL,
  `usr_cedula` varchar(15) NOT NULL,
  `usr_rol` int NOT NULL,
  `usr_estado` enum('activo','suspendido','inactivo','bloqueado','en_revision') DEFAULT 'activo',
  PRIMARY KEY (`usr_id`),
  UNIQUE KEY `usr_correo` (`usr_correo`),
  UNIQUE KEY `usr_cedula` (`usr_cedula`),
  KEY `usr_rol` (`usr_rol`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`usr_rol`) REFERENCES `roles` (`rol_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'user1@example.com','password1',100,'John','A','Doe','B','1234567890','1234567890',1,'activo'),(2,'user2@example.com','password2',200,'Jane','B','Smith','C','0987654321','0987654321',1,'activo'),(3,'user3@example.com','password3',300,'Alice','C','Johnson','D','1122334455','1122334455',2,'activo'),(4,'user4@example.com','password4',400,'Bob','D','Brown','E','2233445566','2233445566',2,'activo'),(5,'user5@example.com','password5',500,'Charlie','E','Davis','F','3344556677','3344556677',2,'activo'),(6,'user6@example.com','password6',600,'David','F','Miller','G','4455667788','4455667788',2,'activo'),(7,'user7@example.com','password7',700,'Eve','G','Wilson','H','5566778899','5566778899',2,'activo'),(8,'user8@example.com','password8',800,'Frank','H','Moore','I','6677889900','6677889900',3,'activo'),(9,'user9@example.com','password9',900,'Grace','I','Taylor','J','7788990011','7788990011',3,'activo'),(10,'user10@example.com','password10',1000,'Hank','J','Anderson','K','8899001122','8899001122',3,'activo');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'eventia'
--

--
-- Dumping routines for database 'eventia'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-11 15:45:42
