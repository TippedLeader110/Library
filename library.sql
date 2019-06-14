-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 14, 2019 at 08:49 AM
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
CREATE DEFINER=`root`@`localhost` FUNCTION `denda` (`date1` DATE, `id` INT(11), `id_trans` INT(11), `uang` INT(11)) RETURNS INT(11) begin
declare date2 date;
declare b int;
Select t_deadline from pinjam_book where id_anggota = id and id_transaksi = id_trans into date2;
if day(date1) > day(date2) then
set b = (day(date1) - day(date2)) * uang;
else
set b = 0;
end if;
return b;
end$$

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
(1, 'bayhaqi', 'Goblogverse', '666'),
(2, 'ihsan', ' budi', ' 9087'),
(4, ' ali', ' patumbak', ' 09876');

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
  `Penerbit` text,
  `Pengarang` text,
  `thn_buku` int(4) DEFAULT NULL,
  `jmlh` int(4) DEFAULT NULL,
  `tgl_pengadaan` date DEFAULT NULL,
  `Judul` varchar(50) DEFAULT NULL,
  `lokasi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`ISBN`, `Penerbit`, `Pengarang`, `thn_buku`, `jmlh`, `tgl_pengadaan`, `Judul`, `lokasi`) VALUES
('1', '2', '1', 1, 1, '2019-06-14', '3', '1'),
('2', ' wao', 'ihsan', 2019, 4, '2019-02-02', ' wao', 'disini'),
('3', 'Milkita', 'Saiki Kusuo', 2019, 3, '2019-05-09', 'How to be a esper', 'rak a'),
('4', 'TeaSeries', 'Pewdiepie', 2017, 5, '2019-06-11', 'Cross a bridge', 'Swedia'),
('6', '10', '6', 2019, 6, '2019-06-13', '8', '6');

-- --------------------------------------------------------

--
-- Stand-in structure for view `buku`
-- (See below for the actual view)
--
CREATE TABLE `buku` (
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `kembali`
-- (See below for the actual view)
--
CREATE TABLE `kembali` (
`id_transaksi` int(11)
,`isbn` varchar(32)
,`anggota` varchar(11)
,`petugas` varchar(11)
,`judul` varchar(50)
,`t_pinjam` date
,`t_kembali` date
,`t_deadline` date
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

--
-- Dumping data for table `penerbit_book`
--

INSERT INTO `penerbit_book` (`ID_penerbit`, `nama_p`, `alamat`, `no_telp`) VALUES
(1, '1', '1', 1),
(666, 'Nibba', 'nibba', 6969);

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

--
-- Dumping data for table `pengarang_book`
--

INSERT INTO `pengarang_book` (`ID_pengarang`, `nama_pengarang`, `alamat`, `no_telp`) VALUES
(1, '1', '1', 1),
(69, 'lala', 'lala', 666);

-- --------------------------------------------------------

--
-- Stand-in structure for view `pinjam`
-- (See below for the actual view)
--
CREATE TABLE `pinjam` (
`id_transaksi` int(11)
,`nama` varchar(11)
,`isbn` varchar(32)
,`judul` varchar(50)
,`t_pinjam` date
,`t_kembali` date
,`denda` int(8)
);

-- --------------------------------------------------------

--
-- Table structure for table `pinjam_book`
--

CREATE TABLE `pinjam_book` (
  `id_transaksi` int(11) NOT NULL,
  `id_anggota` int(11) NOT NULL,
  `id_petugas` int(11) NOT NULL,
  `ISBN` varchar(32) NOT NULL,
  `t_pinjam` date DEFAULT NULL,
  `t_deadline` date DEFAULT NULL,
  `t_kembali` date DEFAULT NULL,
  `denda` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pinjam_book`
--

INSERT INTO `pinjam_book` (`id_transaksi`, `id_anggota`, `id_petugas`, `ISBN`, `t_pinjam`, `t_deadline`, `t_kembali`, `denda`) VALUES
(9, 2, 3, '1', '2019-06-11', '2019-06-14', '2019-06-13', 0),
(10, 2, 3, '2', '2019-06-11', '2019-06-14', NULL, NULL),
(11, 2, 3, '4', '2019-06-11', '2019-06-14', '2019-06-12', 0);

--
-- Triggers `pinjam_book`
--
DELIMITER $$
CREATE TRIGGER `peminjaman` AFTER INSERT ON `pinjam_book` FOR EACH ROW BEGIN
UPDATE book
SET jumlah = jumlah - 1
WHERE
isbn = NEW.isbn;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `pengembalian` AFTER UPDATE ON `pinjam_book` FOR EACH ROW BEGIN
UPDATE book
SET jumlah = jumlah + 1
WHERE
isbn = NEW.isbn;
END
$$
DELIMITER ;

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
(2, 'rafid', '2', 'rafid', 'lala', '666'),
(3, 'ali', 'nigger', '  ali', ' patumbak', '  96');

-- --------------------------------------------------------

--
-- Structure for view `apa`
--
DROP TABLE IF EXISTS `apa`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `apa`  AS  select `a`.`id_transaksi` AS `id_transaksi`,`b`.`nama_anggota` AS `nama_anggota`,`a`.`ISBN` AS `ISBN`,`a`.`t_pinjam` AS `t_pinjam`,`a`.`t_kembali` AS `t_kembali`,`a`.`denda` AS `denda` from (`pinjam_book` `a` join `anggota` `b`) where (`a`.`id_anggota` = `b`.`id_anggota`) ;

-- --------------------------------------------------------

--
-- Structure for view `buku`
--
DROP TABLE IF EXISTS `buku`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `buku`  AS  select `a`.`ISBN` AS `ISBN`,`a`.`Judul` AS `judul`,`b`.`nama_p` AS `nama_p`,`c`.`nama_pengarang` AS `nama_pengarang`,`a`.`thn_buku` AS `thn_buku`,`a`.`jmlh` AS `jmlh` from ((`book` `a` join `penerbit_book` `b`) join `pengarang_book` `c`) where ((`a`.`ID_Penerbit` = `b`.`ID_penerbit`) and (`a`.`ID_Pengarang` = `c`.`ID_pengarang`)) ;

-- --------------------------------------------------------

--
-- Structure for view `kembali`
--
DROP TABLE IF EXISTS `kembali`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `kembali`  AS  select `d`.`id_transaksi` AS `id_transaksi`,`c`.`ISBN` AS `isbn`,`a`.`nama` AS `anggota`,`b`.`nama` AS `petugas`,`c`.`Judul` AS `judul`,`d`.`t_pinjam` AS `t_pinjam`,`d`.`t_kembali` AS `t_kembali`,`d`.`t_deadline` AS `t_deadline` from (((`pinjam_book` `d` join `anggota` `a` on((`a`.`id` = `d`.`id_anggota`))) join `users` `b` on((`b`.`id` = `d`.`id_petugas`))) join `book` `c` on((`c`.`ISBN` = `d`.`ISBN`))) ;

-- --------------------------------------------------------

--
-- Structure for view `pinjam`
--
DROP TABLE IF EXISTS `pinjam`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `pinjam`  AS  select `a`.`id_transaksi` AS `id_transaksi`,`b`.`nama` AS `nama`,`a`.`ISBN` AS `isbn`,`c`.`Judul` AS `judul`,`a`.`t_pinjam` AS `t_pinjam`,`a`.`t_kembali` AS `t_kembali`,`a`.`denda` AS `denda` from ((`pinjam_book` `a` join `anggota` `b` on((`a`.`id_anggota` = `b`.`id`))) join `book` `c` on((`a`.`ISBN` = `c`.`ISBN`))) ;

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
  ADD PRIMARY KEY (`ISBN`);

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
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pinjam_book`
--
ALTER TABLE `pinjam_book`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

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
