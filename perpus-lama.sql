-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 16 Jun 2019 pada 18.47
-- Versi Server: 10.1.26-MariaDB
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
-- Database: `perpus`
--

DELIMITER $$
--
-- Fungsi
--
CREATE DEFINER=`root`@`localhost` FUNCTION `denda` (`id` INT(11)) RETURNS INT(11) begin
declare date1 date;
declare date2 date;
declare b int;
Select pinjam_book.t_pinjam from pinjam_book where pinjam_book.id_transaksi = id into date1;
Select pinjam_book.t_kembali from pinjam_book where id_transaksi = id into date2;
if day(date2)-day(date1) > 3 then
set b = (day(date2) - day(date1)) * 300;
end if;
return b;
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `book`
--

CREATE TABLE `book` (
  `ISBN` varchar(32) NOT NULL,
  `id_rak` varchar(11) NOT NULL,
  `Penerbit` varchar(100) DEFAULT NULL,
  `Pengarang` varchar(100) DEFAULT NULL,
  `thn_buku` int(4) DEFAULT NULL,
  `jmlh` int(4) DEFAULT NULL,
  `tgl_pengadaan` date DEFAULT NULL,
  `Judul` varchar(150) DEFAULT NULL,
  `jenis_buku` enum('Umum','Khusus','Mapel','') NOT NULL,
  `kategori` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `book`
--

INSERT INTO `book` (`ISBN`, `id_rak`, `Penerbit`, `Pengarang`, `thn_buku`, `jmlh`, `tgl_pengadaan`, `Judul`, `jenis_buku`, `kategori`) VALUES
('1', 'b3', 'Tea Series', 'Felix Ulric Kjellberg', 2019, 1, '2019-05-04', 'Me and the boys', 'Umum', 'Novel'),
('11', 'a1', '1', '1', 1, 1, '2019-06-15', '1', 'Umum', 'Novel'),
('14022', 'b2', 'Medan Fried Chicken', 'Aldo Wijoyo', 2017, 120, '2017-06-19', 'Bagaimana cara memilih makanan dalam islam', 'Umum', 'Agama'),
('14045', 'b2', 'USU Press', 'Ali Hidayat', 2030, 240, '2031-02-21', 'Belajar TIK', 'Mapel', 'TKJ 10'),
('14299', 'a1', 'Airlanggah', 'Ali \"desperate\" hidayat', 2012, 240, '2013-02-02', 'Cara Memperbaiki Keturunan', 'Umum', 'Sosial'),
('172044', 'a1', 'GachaGacha', 'Rafid Syahrial', 2010, 401, '2011-02-19', 'Mari Belajar bahasa nigeria', 'Umum', 'Bahasa'),
('177013', 'a1', 'Gramenigga', 'Bayhaqi Daulay', 2013, 231, '2014-02-01', 'Kelapa Jatuh kok dihitung?', 'Umum', 'IPA'),
('2', 'b2', 'Anotha One', 'DJ Khaled', 2019, 3, '2019-05-09', 'How to be Succesful in Suffering', 'Umum', 'Keuangan'),
('90', 'a1', 'Gramedia', 'naufal', 2077, 1000, '2019-05-04', 'Glad to be white', 'Umum', 'Biografi'),
('978-602-250-149-7', 'a2', 'Gema Insani', 'Fikri Habibullah M', 2013, 8, '2019-06-16', 'Tuhan, Izinkan Aku Pacaran', 'Khusus', 'Romansa'),
('978-602-250-235-7', 'a1', 'Gema Insani', 'Uwais Ramadhan', 2015, 3, '2019-06-16', 'Kisah 7 Bayi Bisa Bicara', 'Umum', 'IPA'),
('978-602-250-262-3', 'a1', 'Gema Insani', 'Toni Raharjo', 2015, 17, '2019-06-16', 'Jejak-jejak Cinta', 'Umum', 'Novel'),
('978-602-260-233-3', 'a3', 'Gema Insani', 'Salma', 2014, 3, '2019-06-16', 'Tetap Sehat setelah Usia 40 Tahun', 'Umum', 'IPA'),
('978-602-289-123-94', 'a1', 'Alfabeta, cv', 'Jacobus Ranjabar', 2015, 18, '2019-06-16', 'Perubahan Sosial', 'Umum', 'Sosial'),
('978-602-702-60-0-1', 'a2', 'Dimar Intermedia - Kediri', 'Bayu Pramutoko', 2014, 5, '2019-06-16', 'Manajemen Pemasaran', 'Umum', 'Keuangan'),
('978-602-760-511-4', 'a2', 'Wedatama Widya Sastra', 'Maman Mahayana', 2015, 21, '2019-06-16', 'Bahasa Indonesia Kreatif Edisi Revisi', 'Umum', 'Bahasa'),
('979-97312-11-6', 'a1', 'Lentera Dipantera', 'Pramoedya Ananta Toer', 2010, 12, '2019-06-16', 'Panggil Aku Kartini Saja', 'Umum', 'Biografi');

--
-- Trigger `book`
--
DELIMITER $$
CREATE TRIGGER `insert_lokasi` AFTER INSERT ON `book` FOR EACH ROW BEGIN
if not exists (select id_rak from lok_book where id_rak = new.id_rak) then
insert into lok_book (id_rak, lokasi) values (new.id_rak,'rak '+substring(new.id_rak,1,1)+' tingkat '+substring(new.id_rak,1,2));
end if;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `insert_lokasi2` AFTER UPDATE ON `book` FOR EACH ROW BEGIN
if not exists (select id_rak from lok_book where id_rak = new.id_rak) then
insert into lok_book (id_rak, lokasi) values (new.id_rak,'rak '+substring(new.id_rak,1,1)+' tingkat '+substring(new.id_rak,1,2));
end if;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `buku`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `buku` (
`isbn` varchar(32)
,`lokasi` text
,`penerbit` varchar(100)
,`pengarang` varchar(100)
,`thn_buku` int(4)
,`jmlh` int(4)
,`tgl_pengadaan` date
,`judul` varchar(150)
,`jenis_buku` enum('Umum','Khusus','Mapel','')
,`kategori` varchar(11)
);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kelas`
--

CREATE TABLE `kelas` (
  `id_kelas` varchar(11) NOT NULL,
  `tingkat` varchar(11) NOT NULL,
  `jurusan` text NOT NULL,
  `kelas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kelas`
--

INSERT INTO `kelas` (`id_kelas`, `tingkat`, `jurusan`, `kelas`) VALUES
('10.pst.1', '10', 'Produksi dan Siaran Televisi', 1),
('10.pst.2', '10', 'Produksi dan Siaran Televisi', 2),
('10.pst.3', '10', 'Produksi dan Siaran Televisi', 3),
('10.tav.1', '10', 'Teknik Audio Vidio', 1),
('10.tav.2', '10', 'Teknik Audio Vidio', 2),
('10.tav.3', '10', 'Teknik Audio Vidio', 3),
('10.tbsm.1', '10', 'Teknik dan Bisnis Sepeda Motor', 1),
('10.tbsm.2', '10', 'Teknik dan Bisnis Sepeda Motor', 2),
('10.tbsm.3', '10', 'Teknik dan Bisnis Sepeda Motor', 3),
('10.titl.1', '10', 'Teknik Instalasi Tenaga Listrik', 1),
('10.titl.2', '10', 'Teknik Instalasi Tenaga Listrik', 2),
('10.titl.3', '10', 'Teknik Instalasi Tenaga Listrik', 3),
('10.tkj.1', '10', 'Teknik Komputer dan Jaringan', 1),
('10.tkj.2', '10', 'Teknik Komputer dan Jaringan', 2),
('10.tkj.3', '10', 'Teknik Komputer dan Jaringan', 3),
('10.tkro.1', '10', 'Teknik Kendaraan Ringan Otomotif', 1),
('10.tkro.2', '10', 'Teknik Kendaraan Ringan Otomotif', 2),
('10.tkro.3', '10', 'Teknik Kendaraan Ringan Otomotif', 3),
('10.tpg.1', '10', 'Teknik Pengelasan', 1),
('10.tpg.2', '10', 'Teknik Pengelasan', 2),
('10.tpg.3', '10', 'Teknik Pengelasan', 3),
('10.tpm.1', '10', 'Teknik Pemesinan', 1),
('10.tpm.2', '10', 'Teknik Pemesinan', 2),
('10.tpm.3', '10', 'Teknik Pemesinan', 3),
('10.tptu.1', '10', 'Teknik Pendingin dan Tata Udara', 1),
('10.tptu.2', '10', 'Teknik Pendingin dan Tata Udara', 2),
('10.tptu.3', '10', 'Teknik Pendingin dan Tata Udara', 3),
('11.bkp.1', '11', 'Bisnis dan Konstruksi Properti', 1),
('11.bkp.2', '11', 'Bisnis dan Konstruksi Properti', 2),
('11.bkp.3', '11', 'Bisnis dan Konstruksi Properti', 3),
('11.dpib.1', '11', 'Desain Permodelan dan Informasi Bangunan', 1),
('11.dpib.2', '11', 'Desain Permodelan dan Informasi Bangunan', 2),
('11.dpib.3', '11', 'Desain Permodelan dan Informasi Bangunan', 3),
('11.pst.1', '11', 'Produksi dan Siaran Televisi', 1),
('11.pst.2', '11', 'Produksi dan Siaran Televisi', 2),
('11.pst.3', '11', 'Produksi dan Siaran Televisi', 3),
('11.rpl.1', '11', 'Rekayasa Perangkat Lunak', 1),
('11.rpl.2', '11', 'Rekayasa Perangkat Lunak', 2),
('11.rpl.3', '11', 'Rekayasa Perangkat Lunak', 3),
('11.tav.1', '11', 'Teknik Audio Vidio', 1),
('11.tav.2', '11', 'Teknik Audio Vidio', 2),
('11.tav.3', '11', 'Teknik Audio Vidio', 3),
('11.tbsm.1', '11', 'Teknik dan Bisnis Sepeda Motor', 1),
('11.tbsm.2', '11', 'Teknik dan Bisnis Sepeda Motor', 2),
('11.tbsm.3', '11', 'Teknik dan Bisnis Sepeda Motor', 3),
('11.tg.1', '11', 'Teknik Geomatika', 1),
('11.tg.2', '11', 'Teknik Geomatika', 2),
('11.tg.3', '11', 'Teknik Geomatika', 3),
('11.tgtl.1', '11', 'Teknik Jaringan Tenaga Listrik', 1),
('11.tgtl.2', '11', 'Teknik Jaringan Tenaga Listrik', 2),
('11.tgtl.3', '11', 'Teknik Jaringan Tenaga Listrik', 3),
('11.titl.1', '11', 'Teknik Instalasi Tenaga Listrik', 1),
('11.titl.2', '11', 'Teknik Instalasi Tenaga Listrik', 2),
('11.titl.3', '11', 'Teknik Instalasi Tenaga Listrik', 3),
('11.tkj.1', '11', 'Teknik Komputer dan Jaringan', 1),
('11.tkj.2', '11', 'Teknik Komputer dan Jaringan', 2),
('11.tkj.3', '11', 'Teknik Komputer dan Jaringan', 3),
('11.tkro.1', '11', 'Teknik Kendaraan Ringan Otomotif', 1),
('11.tkro.2', '11', 'Teknik Kendaraan Ringan Otomotif', 2),
('11.tkro.3', '11', 'Teknik Kendaraan Ringan Otomotif', 3),
('11.tpg.1', '11', 'Teknik Pengelasan', 1),
('11.tpg.2', '11', 'Teknik Pengelasan', 2),
('11.tpg.3', '11', 'Teknik Pengelasan', 3),
('11.tpm.1', '11', 'Teknik Pemesinan', 1),
('11.tpm.2', '11', 'Teknik Pemesinan', 2),
('11.tpm.3', '11', 'Teknik Pemesinan', 3),
('11.tptu.1', '11', 'Teknik Pendingin dan Tata Udara', 1),
('11.tptu.2', '11', 'Teknik Pendingin dan Tata Udara', 2),
('11.tptu.3', '11', 'Teknik Pendingin dan Tata Udara', 3),
('12.bkp.1', '12', 'Bisnis dan Konstruksi Properti', 1),
('12.bkp.2', '12', 'Bisnis dan Konstruksi Properti', 2),
('12.bkp.3', '12', 'Bisnis dan Konstruksi Properti', 3),
('12.dpib.1', '12', 'Desain Permodelan dan Informasi Bangunan', 1),
('12.dpib.2', '12', 'Desain Permodelan dan Informasi Bangunan', 2),
('12.dpib.3', '12', 'Desain Permodelan dan Informasi Bangunan', 3),
('12.pst.1', '12', 'Produksi dan Siaran Televisi', 1),
('12.pst.2', '12', 'Produksi dan Siaran Televisi', 2),
('12.pst.3', '12', 'Produksi dan Siaran Televisi', 3),
('12.rpl.1', '12', 'Rekayasa Perangkat Lunak', 1),
('12.rpl.2', '12', 'Rekayasa Perangkat Lunak', 2),
('12.rpl.3', '12', 'Rekayasa Perangkat Lunak', 3),
('12.tav.1', '12', 'Teknik Audio Vidio', 1),
('12.tav.2', '12', 'Teknik Audio Vidio', 2),
('12.tav.3', '12', 'Teknik Audio Vidio', 3),
('12.tbsm.1', '12', 'Teknik dan Bisnis Sepeda Motor', 1),
('12.tbsm.2', '12', 'Teknik dan Bisnis Sepeda Motor', 2),
('12.tbsm.3', '12', 'Teknik dan Bisnis Sepeda Motor', 3),
('12.tg.1', '12', 'Teknik Geomatika', 1),
('12.tg.2', '12', 'Teknik Geomatika', 2),
('12.tg.3', '12', 'Teknik Geomatika', 3),
('12.tgtl.1', '12', 'Teknik Jaringan Tenaga Listrik', 1),
('12.tgtl.2', '12', 'Teknik Jaringan Tenaga Listrik', 2),
('12.tgtl.3', '12', 'Teknik Jaringan Tenaga Listrik', 3),
('12.titl.1', '12', 'Teknik Instalasi Tenaga Listrik', 1),
('12.titl.2', '12', 'Teknik Instalasi Tenaga Listrik', 2),
('12.titl.3', '12', 'Teknik Instalasi Tenaga Listrik', 3),
('12.tkj.1', '12', 'Teknik Komputer dan Jaringan', 1),
('12.tkj.2', '12', 'Teknik Komputer dan Jaringan', 2),
('12.tkj.3', '12', 'Teknik Komputer dan Jaringan', 3),
('12.tkro.1', '12', 'Teknik Kendaraan Ringan Otomotif', 1),
('12.tkro.2', '12', 'Teknik Kendaraan Ringan Otomotif', 2),
('12.tkro.3', '12', 'Teknik Kendaraan Ringan Otomotif', 3),
('12.tpg.1', '12', 'Teknik Pengelasan', 1),
('12.tpg.2', '12', 'Teknik Pengelasan', 2),
('12.tpg.3', '12', 'Teknik Pengelasan', 3),
('12.tpm.1', '12', 'Teknik Pemesinan', 1),
('12.tpm.2', '12', 'Teknik Pemesinan', 2),
('12.tpm.3', '12', 'Teknik Pemesinan', 3),
('12.tptu.1', '12', 'Teknik Pendingin dan Tata Udara', 1),
('12.tptu.2', '12', 'Teknik Pendingin dan Tata Udara', 2),
('12.tptu.3', '12', 'Teknik Pendingin dan Tata Udara', 3),
('A.bkp.0', 'Alumni', 'Bisnis dan Konstruksi Properti', 0),
('A.dpib.0', 'Alumni', 'Desain Permodelan dan Informasi Bangunan', 0),
('A.pst.0', 'Alumni', 'Produksi dan Siaran Televisi', 0),
('A.rpl.0', 'Alumni', 'Rekayasa Perangkat Lunak', 0),
('A.tav.0', 'Alumni', 'Teknik Audio Vidio', 0),
('A.tbsm.0', 'Alumni', 'Teknik dan Bisnis Sepeda Motor', 0),
('A.tg.0', 'Alumni', 'Teknik Geomatika', 0),
('A.tgtl.0', 'Alumni', 'Teknik Jaringan Tenaga Listrik', 0),
('A.titl.0', 'Alumni', 'Teknik Instalasi Tenaga Listrik', 0),
('A.tkj.0', 'Alumni', 'Teknik Komputer dan Jaringan', 0),
('A.tkro.0', 'Alumni', 'Teknik Kendaraan Ringan Otomotif', 0),
('A.tpg.0', 'Alumni', 'Teknik Pengelasan', 0),
('A.tpm.0', 'Alumni', 'Teknik Pemesinan', 0),
('A.tptu.0', 'Alumni', 'Teknik Pendingin dan Tata Udara', 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `lok_book`
--

CREATE TABLE `lok_book` (
  `id_rak` varchar(11) NOT NULL,
  `lokasi` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `lok_book`
--

INSERT INTO `lok_book` (`id_rak`, `lokasi`) VALUES
('a1', 'rak a tingkat 1'),
('a2', 'rak a tingkat 2'),
('a3', 'rak a tingkat 3'),
('b2', 'rak b tingkat 2'),
('b3', 'rak b tingkat 3'),
('c1', 'rak c tingkat 1'),
('c2', 'rak c tingkat 2');

-- --------------------------------------------------------

--
-- Struktur dari tabel `petugas`
--

CREATE TABLE `petugas` (
  `id_petugas` int(11) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `nama` varchar(11) DEFAULT NULL,
  `alamat` text,
  `no_telp` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `petugas`
--

INSERT INTO `petugas` (`id_petugas`, `username`, `password`, `nama`, `alamat`, `no_telp`) VALUES
(1, 'bayhaqi', '1', 'bayhaqi', NULL, NULL),
(2, 'rafid', '2', 'rafid', 'lala', '666'),
(3, 'usokun', '123123', 'Ali Hidayat', 'Jl. Pertahanan', '083122112211'),
(4, 'nopal', '123', 'Nopal', 'Jl. Bumi', '081212343434'),
(5, 'bambang', '12345', 'bambang', 'Jl. Langit', '085242445533');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pihak_pinjam`
--

CREATE TABLE `pihak_pinjam` (
  `id_transaksi` int(11) NOT NULL,
  `nis` int(11) NOT NULL,
  `id_petugas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pihak_pinjam`
--

INSERT INTO `pihak_pinjam` (`id_transaksi`, `nis`, `id_petugas`) VALUES
(1, 999101, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pinjam_book`
--

CREATE TABLE `pinjam_book` (
  `id_transaksi` int(11) NOT NULL,
  `ISBN` varchar(32) NOT NULL,
  `t_pinjam` date DEFAULT NULL,
  `t_deadline` date NOT NULL,
  `t_kembali` date DEFAULT NULL,
  `denda` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pinjam_book`
--

INSERT INTO `pinjam_book` (`id_transaksi`, `ISBN`, `t_pinjam`, `t_deadline`, `t_kembali`, `denda`) VALUES
(1, '1', '2019-05-06', '0000-00-00', '0000-00-00', NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `siswa`
--

CREATE TABLE `siswa` (
  `nis` int(11) NOT NULL,
  `nama` varchar(11) NOT NULL,
  `id_kelas` varchar(11) NOT NULL,
  `alamat` text,
  `no_telp` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `siswa`
--

INSERT INTO `siswa` (`nis`, `nama`, `id_kelas`, `alamat`, `no_telp`) VALUES
(999101, 'rafid', '10.tkj.1', 'Jalan Sei Padang', '0852100331221'),
(999102, 'ali', '10.tkj.1', 'Jl. Pertahanan', '083199229922'),
(999103, 'bayhaqi', '11.rpl.3', 'Jl. Kasih', '081212345667'),
(999105, 'nopal', '11.rpl.3', 'Jl. Bumi', '081322345678');

-- --------------------------------------------------------

--
-- Stand-in structure for view `siswa_view`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `siswa_view` (
`nis` int(11)
,`nama` varchar(11)
,`tingkat` varchar(11)
,`jurusan` text
,`kelas` int(11)
,`alamat` text
,`no_telp` text
);

-- --------------------------------------------------------

--
-- Struktur untuk view `buku`
--
DROP TABLE IF EXISTS `buku`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `buku`  AS  select `a`.`ISBN` AS `isbn`,`b`.`lokasi` AS `lokasi`,`a`.`Penerbit` AS `penerbit`,`a`.`Pengarang` AS `pengarang`,`a`.`thn_buku` AS `thn_buku`,`a`.`jmlh` AS `jmlh`,`a`.`tgl_pengadaan` AS `tgl_pengadaan`,`a`.`Judul` AS `judul`,`a`.`jenis_buku` AS `jenis_buku`,`a`.`kategori` AS `kategori` from (`book` `a` join `lok_book` `b` on((`a`.`id_rak` = `b`.`id_rak`))) ;

-- --------------------------------------------------------

--
-- Struktur untuk view `siswa_view`
--
DROP TABLE IF EXISTS `siswa_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `siswa_view`  AS  select `a`.`nis` AS `nis`,`a`.`nama` AS `nama`,`b`.`tingkat` AS `tingkat`,`b`.`jurusan` AS `jurusan`,`b`.`kelas` AS `kelas`,`a`.`alamat` AS `alamat`,`a`.`no_telp` AS `no_telp` from (`siswa` `a` join `kelas` `b` on((`a`.`id_kelas` = `b`.`id_kelas`))) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`ISBN`),
  ADD UNIQUE KEY `ISBN` (`ISBN`),
  ADD KEY `id_rak` (`id_rak`);

--
-- Indexes for table `kelas`
--
ALTER TABLE `kelas`
  ADD PRIMARY KEY (`id_kelas`),
  ADD UNIQUE KEY `id_kelas` (`id_kelas`);

--
-- Indexes for table `lok_book`
--
ALTER TABLE `lok_book`
  ADD PRIMARY KEY (`id_rak`),
  ADD UNIQUE KEY `id_rak` (`id_rak`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`id_petugas`),
  ADD UNIQUE KEY `id_petugas` (`id_petugas`);

--
-- Indexes for table `pihak_pinjam`
--
ALTER TABLE `pihak_pinjam`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `nis` (`nis`),
  ADD KEY `id_petugas` (`id_petugas`);

--
-- Indexes for table `pinjam_book`
--
ALTER TABLE `pinjam_book`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `ISBN` (`ISBN`);

--
-- Indexes for table `siswa`
--
ALTER TABLE `siswa`
  ADD PRIMARY KEY (`nis`),
  ADD UNIQUE KEY `nis` (`nis`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pihak_pinjam`
--
ALTER TABLE `pihak_pinjam`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
