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
-- Table structure for table `agendas`
--

DROP TABLE IF EXISTS `agendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agendas` (
  `agd_id` int NOT NULL AUTO_INCREMENT,
  `ubc_id` int NOT NULL,
  `evt_id` int NOT NULL,
  `entradas_disponibles` int NOT NULL,
  `agd_fecha_inicio` datetime NOT NULL,
  `agd_fecha_fin` datetime DEFAULT NULL,
  PRIMARY KEY (`agd_id`),
  KEY `evt_id` (`evt_id`),
  KEY `ubc_id` (`ubc_id`),
  CONSTRAINT `agendas_ibfk_1` FOREIGN KEY (`evt_id`) REFERENCES `eventos` (`evt_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `agendas_ibfk_2` FOREIGN KEY (`ubc_id`) REFERENCES `ubicaciones` (`ubc_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `agendas_chk_1` CHECK ((`entradas_disponibles` > 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agendas`
--

LOCK TABLES `agendas` WRITE;
/*!40000 ALTER TABLE `agendas` DISABLE KEYS */;
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
  `ast_estado` enum('reservado','fuera-servicio','libre') NOT NULL,
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
/*!40000 ALTER TABLE `asientos` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventos`
--

LOCK TABLES `eventos` WRITE;
/*!40000 ALTER TABLE `eventos` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recargas`
--

LOCK TABLES `recargas` WRITE;
/*!40000 ALTER TABLE `recargas` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
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
  `rol_nombre` varchar(10) NOT NULL,
  `rol_descripcion` text,
  PRIMARY KEY (`rol_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
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
  `trn_tipo` enum('compra','devolucion') NOT NULL,
  `trn_saldo_anterior` float NOT NULL,
  `trn_saldo_nuevo` float NOT NULL,
  PRIMARY KEY (`trn_id`),
  KEY `trn_usuario` (`trn_usuario`),
  CONSTRAINT `transacciones_ibfk_1` FOREIGN KEY (`trn_usuario`) REFERENCES `usuarios` (`usr_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transacciones`
--

LOCK TABLES `transacciones` WRITE;
/*!40000 ALTER TABLE `transacciones` DISABLE KEYS */;
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
  `ubc_direccion` text NOT NULL,
  `ubc_capacidad` int NOT NULL,
  PRIMARY KEY (`ubc_id`),
  CONSTRAINT `ubicaciones_chk_1` CHECK ((`ubc_capacidad` > 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ubicaciones`
--

LOCK TABLES `ubicaciones` WRITE;
/*!40000 ALTER TABLE `ubicaciones` DISABLE KEYS */;
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
  `usr_saldo` float DEFAULT NULL,
  `usr_nombre1` varchar(30) NOT NULL,
  `usr_nombre2` varchar(30) DEFAULT NULL,
  `usr_apellido1` varchar(30) NOT NULL,
  `usr_apellido2` varchar(30) DEFAULT NULL,
  `usr_telefono` varchar(15) DEFAULT NULL,
  `usr_cedula` varchar(15) NOT NULL,
  `usr_rol` int NOT NULL,
  `usr_estado` enum('activo','suspendido','inactivo','bloqueado','en_revision') NOT NULL DEFAULT 'activo',
  PRIMARY KEY (`usr_id`),
  UNIQUE KEY `usr_correo` (`usr_correo`),
  UNIQUE KEY `usr_cedula` (`usr_cedula`),
  KEY `usr_rol` (`usr_rol`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`usr_rol`) REFERENCES `roles` (`rol_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
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

-- Dump completed on 2024-11-27 20:23:00
