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
-- Dumping data for table `Agence`
--

LOCK TABLES `Agence` WRITE;
/*!40000 ALTER TABLE `Agence` DISABLE KEYS */;
INSERT INTO `Agence` VALUES (1,124);
/*!40000 ALTER TABLE `Agence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Camion`
--

LOCK TABLES `Camion` WRITE;
/*!40000 ALTER TABLE `Camion` DISABLE KEYS */;
INSERT INTO `Camion` VALUES (9,3),(2.8,4);
/*!40000 ALTER TABLE `Camion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Clients`
--

LOCK TABLES `Clients` WRITE;
/*!40000 ALTER TABLE `Clients` DISABLE KEYS */;
INSERT INTO `Clients` VALUES (1,34190,'francis@hotmail.fr','Place de l\'étoile',1,'0467977838','MONTPELLIER','DUPONT','1980-10-23','77-77777777-33','C','Francis'),(2,34300,'vivelaflotte@yahoo.fr','Avenue de la mer',158,'0467999003','PALAVAS-LES-FLOTS','CAPITAINE','1949-01-05','54789-56783-45','B','Haddock'),(3,13013,'rayon2soleil@gmail.com','rue de l\'Espoir',13,'0359111333','MARSEILLE','HOULLA','1953-01-13','54513-56793-13','B','Micheline'),(4,11100,'albert11@msn.com','boulevard Kleber',48,'0459111111','NARBONNE','DUBOUT','1963-04-15','54778-57865-11','B','Albert'),(5,91100,'fernand@minitel.fr','rue notre dame des champs',2,'0459111111','GIF-SUR-YVETTE','LEGER','1881-02-04','66-66666666-91','C','Fernand');
/*!40000 ALTER TABLE `Clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Facture`
--

LOCK TABLES `Facture` WRITE;
/*!40000 ALTER TABLE `Facture` DISABLE KEYS */;
INSERT INTO `Facture` VALUES (1,180,'FAC20210311.1523','PAYE',3);
/*!40000 ALTER TABLE `Facture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Maintenance`
--

LOCK TABLES `Maintenance` WRITE;
/*!40000 ALTER TABLE `Maintenance` DISABLE KEYS */;
INSERT INTO `Maintenance` VALUES (1,0,'2021-03-11',NULL,1,4),(2,56,'2021-03-11','2021-03-11',1,1);
/*!40000 ALTER TABLE `Maintenance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Paiement`
--

LOCK TABLES `Paiement` WRITE;
/*!40000 ALTER TABLE `Paiement` DISABLE KEYS */;
INSERT INTO `Paiement` VALUES (1,'LIQUIDE',1,1);
/*!40000 ALTER TABLE `Paiement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Reservation`
--

LOCK TABLES `Reservation` WRITE;
/*!40000 ALTER TABLE `Reservation` DISABLE KEYS */;
INSERT INTO `Reservation` VALUES (1,'','2021-03-11','2021-06-19',10000,0,'ENCOURS',1,3),(2,'Le petit chien est accepté à bord du véhicule','2021-03-11','2021-05-26',10000,0,'ENCOURS',3,1),(3,'Pour une première !','2020-11-10','2020-11-12',8000,11000,'TERMINEE',2,4),(4,'Longue durée','2020-06-10','2021-03-11',1000,0,'ENCOURS',5,7);
/*!40000 ALTER TABLE `Reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Type`
--

LOCK TABLES `Type` WRITE;
/*!40000 ALTER TABLE `Type` DISABLE KEYS */;
INSERT INTO `Type` VALUES (1,300,30,'BERLINE'),(2,300,40,'CABRIOLET'),(3,500,45,'DEMENAGEMENT'),(4,600,60,'FRIGORIFIQUE'),(5,600,50,'SPORT');
/*!40000 ALTER TABLE `Type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Vehicule`
--

LOCK TABLES `Vehicule` WRITE;
/*!40000 ALTER TABLE `Vehicule` DISABLE KEYS */;
INSERT INTO `Vehicule` VALUES (1,'HG-579-IK',10000,'VW','POLO',1),(2,'BB-555-DD',50000,'PEUGEOT','3008',2),(3,'HH-999-TT',10000,'VW','KRAFTER',3),(4,'AA-777-MM',11000,'PEUGEOT','EXPERT',4),(5,'RM-141-VV',5000,'RENAULT','MEGANE-GT',5),(6,'FE-992-RS',5000,'FORD','ESCORT RS COSWORTH',5),(7,'LD-997-SV',1000,'LAMBORGHINI','DIABLO SV',5);
/*!40000 ALTER TABLE `Vehicule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Voiture`
--

LOCK TABLES `Voiture` WRITE;
/*!40000 ALTER TABLE `Voiture` DISABLE KEYS */;
INSERT INTO `Voiture` VALUES (5,1),(5,2),(2,5),(5,6),(2,7);
/*!40000 ALTER TABLE `Voiture` ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2021-03-11 15:39:44