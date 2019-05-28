-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2019 at 06:10 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `orang` (IN `human` TEXT)  begin
select id, nama, alamat, no_telp from human;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sel_branch` ()  begin
select * from branch;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `tambah_buku` (IN `ISBN` VARCHAR(32), IN `ID_Penerbit` INT(8), IN `ID_Pengarang` INT(8), IN `thn_buku` INT(4), IN `jmlh` INT(4), IN `tgl_pengadaan` DATE, IN `Judul` VARCHAR(50))  begin
insert into book values(ISBN, ID_Penerbit, ID_Pengarang, thn_buku, jmlh, tgl_pengadaan, Judul);
end$$

--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `login` (`A` VARCHAR(32), `B` VARCHAR(32)) RETURNS INT(11) begin
    declare cou int;

SELECT COUNT(*) 
into cou 
from users
where username = A 
AND password = B;
    
    RETURN cou;
    END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `id` int(11) NOT NULL,
  `nama` varchar(11) DEFAULT NULL,
  `alamat` text,
  `no_telp` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`id`, `nama`, `alamat`, `no_telp`) VALUES
(1, '0', 'Goblogverse', '666'),
(2, '0', 'Tololverse', '6969');

-- --------------------------------------------------------

--
-- Stand-in structure for view `apa`
-- (See below for the actual view)
--
CREATE TABLE `apa` (
);

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `ISBN` varchar(32) NOT NULL,
  `ID_Penerbit` int(8) DEFAULT NULL,
  `ID_Pengarang` int(8) DEFAULT NULL,
  `thn_buku` int(4) DEFAULT NULL,
  `jmlh` int(4) DEFAULT NULL,
  `tgl_pengadaan` date DEFAULT NULL,
  `Judul` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`ISBN`, `ID_Penerbit`, `ID_Pengarang`, `thn_buku`, `jmlh`, `tgl_pengadaan`, `Judul`) VALUES
('69666', 666, 69, 2019, 3, '2019-05-09', 'How to be a N I G G A');

-- --------------------------------------------------------

--
-- Stand-in structure for view `kembali`
-- (See below for the actual view)
--
CREATE TABLE `kembali` (
);

-- --------------------------------------------------------

--
-- Table structure for table `lok_book`
--

CREATE TABLE `lok_book` (
  `id_rak` int(11) NOT NULL,
  `lokasi` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `penerbit_book`
--

CREATE TABLE `penerbit_book` (
  `ID_penerbit` int(11) NOT NULL,
  `nama_p` varchar(52) DEFAULT NULL,
  `alamat` text,
  `no_telp` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pengarang_book`
--

CREATE TABLE `pengarang_book` (
  `ID_pengarang` int(11) NOT NULL,
  `nama_pengarang` varchar(52) DEFAULT NULL,
  `alamat` text,
  `no_telp` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Stand-in structure for view `pinjam`
-- (See below for the actual view)
--
CREATE TABLE `pinjam` (
);

-- --------------------------------------------------------

--
-- Table structure for table `pinjam_book`
--

CREATE TABLE `pinjam_book` (
  `id_transaksi` int(11) NOT NULL,
  `id_anggota` int(11) NOT NULL,
  `ISBN` varchar(32) NOT NULL,
  `t_pinjam` date DEFAULT NULL,
  `t_kembali` date DEFAULT NULL,
  `denda` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pinjam_book`
--

INSERT INTO `pinjam_book` (`id_transaksi`, `id_anggota`, `ISBN`, `t_pinjam`, `t_kembali`, `denda`) VALUES
(1, 1, '1', '2019-05-06', '2019-05-08', 900),
(2, 2, '2', '2019-05-02', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `reg_book`
--

CREATE TABLE `reg_book` (
  `no_regis` int(11) NOT NULL,
  `id_rak` int(11) NOT NULL,
  `ISBN` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `nama` varchar(11) DEFAULT NULL,
  `alamat` text,
  `no_telp` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `nama`, `alamat`, `no_telp`) VALUES
(1, 'bayhaqi', '1', 'bayhaqi', NULL, NULL),
(2, 'rafid', '2', 'rafid', 'lala', '666');

-- --------------------------------------------------------

--
-- Structure for view `apa`
--
DROP TABLE IF EXISTS `apa`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `apa`  AS  select `a`.`id_transaksi` AS `id_transaksi`,`b`.`nama_anggota` AS `nama_anggota`,`a`.`ISBN` AS `ISBN`,`a`.`t_pinjam` AS `t_pinjam`,`a`.`t_kembali` AS `t_kembali`,`a`.`denda` AS `denda` from (`pinjam_book` `a` join `anggota` `b`) where (`a`.`id_anggota` = `b`.`id_anggota`) ;

-- --------------------------------------------------------

--
-- Structure for view `kembali`
--
DROP TABLE IF EXISTS `kembali`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `kembali`  AS  select `a`.`id_transaksi` AS `id_transaksi`,`b`.`nama_anggota` AS `nama_anggota`,`a`.`ISBN` AS `ISBN`,`a`.`t_pinjam` AS `t_pinjam`,`a`.`t_kembali` AS `t_kembali`,`a`.`denda` AS `denda` from (`pinjam_book` `a` join `anggota` `b`) where ((`a`.`id_anggota` = `b`.`id_anggota`) and (`a`.`t_pinjam` is not null) and (`a`.`t_kembali` is not null)) ;

-- --------------------------------------------------------

--
-- Structure for view `pinjam`
--
DROP TABLE IF EXISTS `pinjam`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `pinjam`  AS  select `a`.`id_transaksi` AS `id_transaksi`,`b`.`nama_anggota` AS `nama_anggota`,`a`.`ISBN` AS `ISBN`,`a`.`t_pinjam` AS `t_pinjam`,`a`.`t_kembali` AS `t_kembali`,`a`.`denda` AS `denda` from (`pinjam_book` `a` join `anggota` `b`) where ((`a`.`id_anggota` = `b`.`id_anggota`) and (`a`.`t_pinjam` is not null) and isnull(`a`.`t_kembali`)) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`ISBN`),
  ADD KEY `ID_Penerbit` (`ID_Penerbit`),
  ADD KEY `ID_Pengarang` (`ID_Pengarang`);

--
-- Indexes for table `lok_book`
--
ALTER TABLE `lok_book`
  ADD PRIMARY KEY (`id_rak`);

--
-- Indexes for table `penerbit_book`
--
ALTER TABLE `penerbit_book`
  ADD PRIMARY KEY (`ID_penerbit`);

--
-- Indexes for table `pengarang_book`
--
ALTER TABLE `pengarang_book`
  ADD PRIMARY KEY (`ID_pengarang`);

--
-- Indexes for table `pinjam_book`
--
ALTER TABLE `pinjam_book`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_anggota` (`id_anggota`),
  ADD KEY `ISBN` (`ISBN`);

--
-- Indexes for table `reg_book`
--
ALTER TABLE `reg_book`
  ADD PRIMARY KEY (`no_regis`),
  ADD KEY `ISBN` (`ISBN`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reg_book`
--
ALTER TABLE `reg_book`
  ADD CONSTRAINT `reg_book_ibfk_1` FOREIGN KEY (`ISBN`) REFERENCES `book` (`ISBN`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
