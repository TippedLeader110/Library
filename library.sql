-- MySQL dump 10.16  Distrib 10.1.26-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	10.1.26-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `anggota`
--

DROP TABLE IF EXISTS `anggota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `anggota` (
  `id` int(11) NOT NULL,
  `nama` varchar(11) DEFAULT NULL,
  `alamat` text,
  `no_telp` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anggota`
--

LOCK TABLES `anggota` WRITE;
/*!40000 ALTER TABLE `anggota` DISABLE KEYS */;
INSERT INTO `anggota` VALUES (1,'bayhaqi','Goblogverse','666'),(2,'ihsan',' budi',' 9087'),(4,' ali',' patumbak',' 09876');
/*!40000 ALTER TABLE `anggota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `ISBN` varchar(32) NOT NULL,
  `Penerbit` text,
  `Pengarang` text,
  `thn_buku` int(4) DEFAULT NULL,
  `jmlh` int(4) DEFAULT NULL,
  `tgl_pengadaan` date DEFAULT NULL,
  `Judul` varchar(50) DEFAULT NULL,
  `lokasi` text NOT NULL,
  PRIMARY KEY (`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES ('1','2','1',1,1,'2019-06-14','3','1'),('2',' wao','ihsan',2019,4,'2019-02-02',' wao','disini'),('3','Milkita','Saiki Kusuo',2019,3,'2019-05-09','How to be a esper','rak a'),('4','TeaSeries','Pewdiepie',2017,5,'2019-06-11','Cross a bridge','Swedia'),('6','10','6',2019,6,'2019-06-13','8','6');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `kembali`
--

DROP TABLE IF EXISTS `kembali`;
/*!50001 DROP VIEW IF EXISTS `kembali`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `kembali` (
  `id_transaksi` tinyint NOT NULL,
  `isbn` tinyint NOT NULL,
  `anggota` tinyint NOT NULL,
  `petugas` tinyint NOT NULL,
  `judul` tinyint NOT NULL,
  `t_pinjam` tinyint NOT NULL,
  `t_kembali` tinyint NOT NULL,
  `t_deadline` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `lok_book`
--

DROP TABLE IF EXISTS `lok_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lok_book` (
  `id_rak` int(11) NOT NULL,
  `lokasi` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id_rak`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lok_book`
--

LOCK TABLES `lok_book` WRITE;
/*!40000 ALTER TABLE `lok_book` DISABLE KEYS */;
/*!40000 ALTER TABLE `lok_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `pinjam`
--

DROP TABLE IF EXISTS `pinjam`;
/*!50001 DROP VIEW IF EXISTS `pinjam`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `pinjam` (
  `id_transaksi` tinyint NOT NULL,
  `nama` tinyint NOT NULL,
  `isbn` tinyint NOT NULL,
  `judul` tinyint NOT NULL,
  `t_pinjam` tinyint NOT NULL,
  `t_kembali` tinyint NOT NULL,
  `denda` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `pinjam_book`
--

DROP TABLE IF EXISTS `pinjam_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinjam_book` (
  `id_transaksi` int(11) NOT NULL AUTO_INCREMENT,
  `id_anggota` int(11) NOT NULL,
  `id_petugas` int(11) NOT NULL,
  `ISBN` varchar(32) NOT NULL,
  `t_pinjam` date DEFAULT NULL,
  `t_deadline` date DEFAULT NULL,
  `t_kembali` date DEFAULT NULL,
  `denda` int(8) DEFAULT NULL,
  PRIMARY KEY (`id_transaksi`),
  KEY `id_anggota` (`id_anggota`),
  KEY `ISBN` (`ISBN`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinjam_book`
--

LOCK TABLES `pinjam_book` WRITE;
/*!40000 ALTER TABLE `pinjam_book` DISABLE KEYS */;
INSERT INTO `pinjam_book` VALUES (9,2,3,'1','2019-06-11','2019-06-14','2019-06-13',0),(10,2,3,'2','2019-06-11','2019-06-14',NULL,NULL),(11,2,3,'4','2019-06-11','2019-06-14','2019-06-12',0);
/*!40000 ALTER TABLE `pinjam_book` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp932 */ ;
/*!50003 SET character_set_results = cp932 */ ;
/*!50003 SET collation_connection  = cp932_japanese_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER peminjaman after INSERT ON pinjam_book
FOR EACH ROW BEGIN
UPDATE book
SET jumlah = jumlah - 1
WHERE
isbn = NEW.isbn;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp932 */ ;
/*!50003 SET character_set_results = cp932 */ ;
/*!50003 SET collation_connection  = cp932_japanese_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER pengembalian after update ON pinjam_book
FOR EACH ROW BEGIN
UPDATE book
SET jumlah = jumlah + 1
WHERE
isbn = NEW.isbn;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `reg_book`
--

DROP TABLE IF EXISTS `reg_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reg_book` (
  `no_regis` int(11) NOT NULL,
  `id_rak` int(11) NOT NULL,
  `ISBN` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`no_regis`),
  KEY `ISBN` (`ISBN`),
  CONSTRAINT `reg_book_ibfk_1` FOREIGN KEY (`ISBN`) REFERENCES `book` (`ISBN`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reg_book`
--

LOCK TABLES `reg_book` WRITE;
/*!40000 ALTER TABLE `reg_book` DISABLE KEYS */;
/*!40000 ALTER TABLE `reg_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `nama` varchar(11) DEFAULT NULL,
  `alamat` text,
  `no_telp` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'bayhaqi','1','bayhaqi',NULL,NULL),(2,'rafid','2','rafid','lala','666'),(3,'ali','nigger','  ali',' patumbak','  96');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `kembali`
--

/*!50001 DROP TABLE IF EXISTS `kembali`*/;
/*!50001 DROP VIEW IF EXISTS `kembali`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `kembali` AS select `d`.`id_transaksi` AS `id_transaksi`,`c`.`ISBN` AS `isbn`,`a`.`nama` AS `anggota`,`b`.`nama` AS `petugas`,`c`.`Judul` AS `judul`,`d`.`t_pinjam` AS `t_pinjam`,`d`.`t_kembali` AS `t_kembali`,`d`.`t_deadline` AS `t_deadline` from (((`pinjam_book` `d` join `anggota` `a` on((`a`.`id` = `d`.`id_anggota`))) join `users` `b` on((`b`.`id` = `d`.`id_petugas`))) join `book` `c` on((`c`.`ISBN` = `d`.`ISBN`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `pinjam`
--

/*!50001 DROP TABLE IF EXISTS `pinjam`*/;
/*!50001 DROP VIEW IF EXISTS `pinjam`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `pinjam` AS select `a`.`id_transaksi` AS `id_transaksi`,`b`.`nama` AS `nama`,`a`.`ISBN` AS `isbn`,`c`.`Judul` AS `judul`,`a`.`t_pinjam` AS `t_pinjam`,`a`.`t_kembali` AS `t_kembali`,`a`.`denda` AS `denda` from ((`pinjam_book` `a` join `anggota` `b` on((`a`.`id_anggota` = `b`.`id`))) join `book` `c` on((`a`.`ISBN` = `c`.`ISBN`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-17 10:26:47
