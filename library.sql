-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2019 at 04:18 PM
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
-- Functions
--
CREATE DEFINER=`bayhaqi`@`localhost` FUNCTION `login` (`A` VARCHAR(32), `B` VARCHAR(32)) RETURNS INT(11) begin
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
  `ID_anggota` int(11) NOT NULL,
  `nama_anggota` varchar(52) DEFAULT NULL,
  `alamat` text,
  `no_telp` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `tgl_pengadaan` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `id_users` int(11) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_users`, `username`, `password`, `name`) VALUES
(1, 'bayhaqi', '1', 'bayhaqi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`ID_anggota`);

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
  ADD PRIMARY KEY (`id_users`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_users` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
