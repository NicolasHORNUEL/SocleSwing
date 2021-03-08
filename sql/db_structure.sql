CREATE DATABASE  IF NOT EXISTS `agence-vip-location` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `agence-vip-location`;
-- MySQL dump 10.13  Distrib 8.0.12, for macos10.13 (x86_64)
--
-- Host: 127.0.0.1    Database: agence-vip-location
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Agence`
--

DROP TABLE IF EXISTS `Agence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Agence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Bilan` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Camion`
--

DROP TABLE IF EXISTS `Camion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Camion` (
  `Volume` double NOT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKt0vcbm3ih110yr8ntrcb5dajd` FOREIGN KEY (`id`) REFERENCES `vehicule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Clients`
--

DROP TABLE IF EXISTS `Clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Clients` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `Code_Postale` int(11) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Libelle_Rue` varchar(50) NOT NULL,
  `Numero_Rue` int(11) NOT NULL,
  `Numero_Tel` int(11) NOT NULL,
  `Ville` varchar(50) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `Prenom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_cpw3vhpyn06ugfa90h53mjckj` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Facture`
--

DROP TABLE IF EXISTS `Facture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Facture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Cout_Facture` int(11) NOT NULL,
  `Date_Fin_Reel` date NOT NULL,
  `Numero_Facture` int(11) NOT NULL,
  `Status_Facture` varchar(50) NOT NULL,
  `Type_Reglement` varchar(50) NOT NULL,
  `Agence_ID` int(11) DEFAULT NULL,
  `Reservation_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK43n4m6odnq18wisjnwgka9mg7` (`Agence_ID`),
  KEY `FKgqi53k1ac1ipdsk9mv5npv7d2` (`Reservation_ID`),
  CONSTRAINT `FK43n4m6odnq18wisjnwgka9mg7` FOREIGN KEY (`Agence_ID`) REFERENCES `agence` (`id`),
  CONSTRAINT `FKgqi53k1ac1ipdsk9mv5npv7d2` FOREIGN KEY (`Reservation_ID`) REFERENCES `reservation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Maintenance`
--

DROP TABLE IF EXISTS `Maintenance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Maintenance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Cout_Maintenance` int(11) NOT NULL,
  `Date_Debut` date NOT NULL,
  `Date_Fin` date NOT NULL,
  `Agence_ID` int(11) DEFAULT NULL,
  `Vehicule_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcl6haux1hb6gvdva3c5i0ry7d` (`Agence_ID`),
  KEY `FKc3ilrcpwjoillg4olcm12fmyx` (`Vehicule_ID`),
  CONSTRAINT `FKc3ilrcpwjoillg4olcm12fmyx` FOREIGN KEY (`Vehicule_ID`) REFERENCES `vehicule` (`id`),
  CONSTRAINT `FKcl6haux1hb6gvdva3c5i0ry7d` FOREIGN KEY (`Agence_ID`) REFERENCES `agence` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Permis`
--

DROP TABLE IF EXISTS `Permis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Permis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Date_Obtention` date NOT NULL,
  `Numero_Permis` varchar(50) NOT NULL,
  `Type_Permis` varchar(50) NOT NULL,
  `Client_ID` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmfiora027lamwn8stppbepba5` (`Client_ID`),
  CONSTRAINT `FKmfiora027lamwn8stppbepba5` FOREIGN KEY (`Client_ID`) REFERENCES `clients` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Reservation`
--

DROP TABLE IF EXISTS `Reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Commentaire` varchar(255) NOT NULL,
  `Date_Debut` date NOT NULL,
  `Date_Fin` date NOT NULL,
  `Km_Debut` int(11) NOT NULL,
  `Km_Fin` int(11) NOT NULL,
  `Client_ID` smallint(6) DEFAULT NULL,
  `Vehicule_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKckrg6q0mo5qec8ffbu3s3wpvt` (`Client_ID`),
  KEY `FK7toq782kygaj1rhel2l4nxeqn` (`Vehicule_ID`),
  CONSTRAINT `FK7toq782kygaj1rhel2l4nxeqn` FOREIGN KEY (`Vehicule_ID`) REFERENCES `vehicule` (`id`),
  CONSTRAINT `FKckrg6q0mo5qec8ffbu3s3wpvt` FOREIGN KEY (`Client_ID`) REFERENCES `clients` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Type`
--

DROP TABLE IF EXISTS `Type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Caution` int(11) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `Tarif_Journalier` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Vehicule`
--

DROP TABLE IF EXISTS `Vehicule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Vehicule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Immatriculation` varchar(255) NOT NULL,
  `Kilometrage` int(11) NOT NULL,
  `Marque` varchar(255) NOT NULL,
  `Modele` varchar(255) NOT NULL,
  `Status` varchar(255) NOT NULL,
  `Type_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_hq9h8o90kxy1d7h5fwd9k53i1` (`Immatriculation`),
  KEY `FKkf1y9hde96n4m3svs24pan33k` (`Type_ID`),
  CONSTRAINT `FKkf1y9hde96n4m3svs24pan33k` FOREIGN KEY (`Type_ID`) REFERENCES `type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Voiture`
--

DROP TABLE IF EXISTS `Voiture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Voiture` (
  `nombre_Place` int(11) NOT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK9bxrdi0dalatx9at1di8u90i7` FOREIGN KEY (`id`) REFERENCES `vehicule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'agence-vip-location'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-04 10:27:50
