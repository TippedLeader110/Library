-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 02, 2019 at 06:02 PM
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
-- Database: `perpus`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `naik_kelas` ()  begin
update siswa set id_kelas = '11.tpg.1' where id_kelas = '10.tpg.1';
update siswa set id_kelas = '11.tpg.2' where id_kelas = '10.tpg.2';
update siswa set id_kelas = '11.tpg.3' where id_kelas = '10.tpg.3';
update siswa set id_kelas = '12.tpg.1' where id_kelas = '11.tpg.1';
update siswa set id_kelas = '12.tpg.2' where id_kelas = '11.tpg.2';
update siswa set id_kelas = '12.tpg.3' where id_kelas = '11.tpg.3';
update siswa set id_kelas = 'A.tpg.0' where id_kelas = '12.tpg.1';
update siswa set id_kelas = 'A.tpg.0' where id_kelas = '12.tpg.2';
update siswa set id_kelas = 'A.tpg.0' where id_kelas = '12.tpg.3';
update siswa set id_kelas = '11.tptu.1' where id_kelas = '10.tptu.1';
update siswa set id_kelas = '11.tptu.2' where id_kelas = '10.tptu.2';
update siswa set id_kelas = '11.tptu.3' where id_kelas = '10.tptu.3';
update siswa set id_kelas = '12.tptu.1' where id_kelas = '11.tptu.1';
update siswa set id_kelas = '12.tptu.2' where id_kelas = '11.tptu.2';
update siswa set id_kelas = '12.tptu.3' where id_kelas = '11.tptu.3';
update siswa set id_kelas = 'A.tptu.0' where id_kelas = '12.tptu.1';
update siswa set id_kelas = 'A.tptu.0' where id_kelas = '12.tptu.2';
update siswa set id_kelas = 'A.tptu.0' where id_kelas = '12.tptu.3';
update siswa set id_kelas = '11.tpm.1' where id_kelas = '10.tpm.1';
update siswa set id_kelas = '11.tpm.2' where id_kelas = '10.tpm.2';
update siswa set id_kelas = '11.tpm.3' where id_kelas = '10.tpm.3';
update siswa set id_kelas = '12.tpm.1' where id_kelas = '11.tpm.1';
update siswa set id_kelas = '12.tpm.2' where id_kelas = '11.tpm.2';
update siswa set id_kelas = '12.tpm.3' where id_kelas = '11.tpm.3';
update siswa set id_kelas = 'A.tpm.0' where id_kelas = '12.tpm.1';
update siswa set id_kelas = 'A.tpm.0' where id_kelas = '12.tpm.2';
update siswa set id_kelas = 'A.tpm.0' where id_kelas = '12.tpm.3';
update siswa set id_kelas = '11.tkj.1' where id_kelas = '10.tkj.1';
update siswa set id_kelas = '11.tkj.2' where id_kelas = '10.tkj.2';
update siswa set id_kelas = '11.tkj.3' where id_kelas = '10.tkj.3';
update siswa set id_kelas = '12.tkj.1' where id_kelas = '11.tkj.1';
update siswa set id_kelas = '12.tkj.2' where id_kelas = '11.tkj.2';
update siswa set id_kelas = '12.tkj.3' where id_kelas = '11.tkj.3';
update siswa set id_kelas = 'A.tkj.0' where id_kelas = '12.tkj.1';
update siswa set id_kelas = 'A.tkj.0' where id_kelas = '12.tkj.2';
update siswa set id_kelas = 'A.tkj.0' where id_kelas = '12.tkj.3';
update siswa set id_kelas = '11.tkro.1' where id_kelas = '10.tkro.1';
update siswa set id_kelas = '11.tkro.2' where id_kelas = '10.tkro.2';
update siswa set id_kelas = '11.tkro.3' where id_kelas = '10.tkro.3';
update siswa set id_kelas = '12.tkro.1' where id_kelas = '11.tkro.1';
update siswa set id_kelas = '12.tkro.2' where id_kelas = '11.tkro.2';
update siswa set id_kelas = '12.tkro.3' where id_kelas = '11.tkro.3';
update siswa set id_kelas = 'A.tkro.0' where id_kelas = '12.tkro.1';
update siswa set id_kelas = 'A.tkro.0' where id_kelas = '12.tkro.1';
update siswa set id_kelas = 'A.tkro.0' where id_kelas = '12.tkro.1';
update siswa set id_kelas = '11.tgtl.1' where id_kelas = '10.tgtl.1';
update siswa set id_kelas = '11.tgtl.2' where id_kelas = '10.tgtl.2';
update siswa set id_kelas = '11.tgtl.3' where id_kelas = '10.tgtl.3';
update siswa set id_kelas = '12.tgtl.1' where id_kelas = '11.tgtl.1';
update siswa set id_kelas = '12.tgtl.2' where id_kelas = '11.tgtl.2';
update siswa set id_kelas = '12.tgtl.3' where id_kelas = '11.tgtl.3';
update siswa set id_kelas = 'A.tgtl.0' where id_kelas = '12.tgtl.1';
update siswa set id_kelas = 'A.tgtl.0' where id_kelas = '12.tgtl.2';
update siswa set id_kelas = 'A.tgtl.0' where id_kelas = '12.tgtl.3';
update siswa set id_kelas = '11.titl.1' where id_kelas = '10.titl.1';
update siswa set id_kelas = '11.titl.2' where id_kelas = '10.titl.2';
update siswa set id_kelas = '11.titl.3' where id_kelas = '10.titl.3';
update siswa set id_kelas = '12.titl.1' where id_kelas = '11.titl.1';
update siswa set id_kelas = '12.titl.2' where id_kelas = '11.titl.2';
update siswa set id_kelas = '12.titl.3' where id_kelas = '11.titl.3';
update siswa set id_kelas = 'A.titl.0' where id_kelas = '12.titl.1';
update siswa set id_kelas = 'A.titl.0' where id_kelas = '12.titl.2';
update siswa set id_kelas = 'A.titl.0' where id_kelas = '12.titl.3';
update siswa set id_kelas = '11.tg.1' where id_kelas = '10.tg.1';
update siswa set id_kelas = '11.tg.2' where id_kelas = '10.tg.2';
update siswa set id_kelas = '11.tg.3' where id_kelas = '10.tg.3';
update siswa set id_kelas = '12.tg.1' where id_kelas = '11.tg.1';
update siswa set id_kelas = '12.tg.2' where id_kelas = '11.tg.2';
update siswa set id_kelas = '12.tg.3' where id_kelas = '11.tg.3';
update siswa set id_kelas = 'A.tg.0' where id_kelas = '12.tg.1';
update siswa set id_kelas = 'A.tg.0' where id_kelas = '12.tg.2';
update siswa set id_kelas = 'A.tg.0' where id_kelas = '12.tg.3';
update siswa set id_kelas = '11.tbsm.1' where id_kelas = '10.tbsm.1';
update siswa set id_kelas = '11.tbsm.2' where id_kelas = '10.tbsm.2';
update siswa set id_kelas = '11.tbsm.3' where id_kelas = '10.tbsm.3';
update siswa set id_kelas = '12.tbsm.1' where id_kelas = '11.tbsm.1';
update siswa set id_kelas = '12.tbsm.2' where id_kelas = '11.tbsm.2';
update siswa set id_kelas = '12.tbsm.3' where id_kelas = '11.tbsm.3';
update siswa set id_kelas = 'A.tbsm.0' where id_kelas = '12.tbsm.1';
update siswa set id_kelas = 'A.tbsm.0' where id_kelas = '12.tbsm.2';
update siswa set id_kelas = 'A.tbsm.0' where id_kelas = '12.tbsm.3';
update siswa set id_kelas = '11.tav.1' where id_kelas = '10.tav.1';
update siswa set id_kelas = '11.tav.2' where id_kelas = '10.tav.2';
update siswa set id_kelas = '11.tav.3' where id_kelas = '10.tav.3';
update siswa set id_kelas = '12.tav.1' where id_kelas = '11.tav.1';
update siswa set id_kelas = '12.tav.1' where id_kelas = '11.tav.2';
update siswa set id_kelas = '12.tav.1' where id_kelas = '11.tav.3';
update siswa set id_kelas = 'A.tav.0' where id_kelas = '12.tav.1';
update siswa set id_kelas = 'A.tav.0' where id_kelas = '12.tav.2';
update siswa set id_kelas = 'A.tav.0' where id_kelas = '12.tav.3';
update siswa set id_kelas = '11.rpl.1' where id_kelas = '10.rpl.1';
update siswa set id_kelas = '11.rpl.2' where id_kelas = '10.rpl.2';
update siswa set id_kelas = '11.rpl.3' where id_kelas = '10.rpl.3';
update siswa set id_kelas = '12.rpl.1' where id_kelas = '11.rpl.1';
update siswa set id_kelas = '12.rpl.2' where id_kelas = '11.rpl.2';
update siswa set id_kelas = '12.rpl.3' where id_kelas = '11.rpl.3';
update siswa set id_kelas = 'A.rpl.0' where id_kelas = '12.rpl.1';
update siswa set id_kelas = 'A.rpl.0' where id_kelas = '12.rpl.2';
update siswa set id_kelas = 'A.rpl.0' where id_kelas = '12.rpl.3';
update siswa set id_kelas = '11.pst.1' where id_kelas = '10.pst.1';
update siswa set id_kelas = '11.pst.2' where id_kelas = '10.pst.2';
update siswa set id_kelas = '11.pst.3' where id_kelas = '10.pst.3';
update siswa set id_kelas = '12.pst.1' where id_kelas = '11.pst.1';
update siswa set id_kelas = '12.pst.2' where id_kelas = '11.pst.2';
update siswa set id_kelas = '12.pst.3' where id_kelas = '11.pst.3';
update siswa set id_kelas = 'A.pst.0' where id_kelas = '12.pst.1';
update siswa set id_kelas = 'A.pst.0' where id_kelas = '12.pst.2';
update siswa set id_kelas = 'A.pst.0' where id_kelas = '12.pst.3';
update siswa set id_kelas = '11.dpib.1' where id_kelas = '10.dpib.1';
update siswa set id_kelas = '11.dpib.2' where id_kelas = '10.dpib.2';
update siswa set id_kelas = '11.dpib.3' where id_kelas = '10.dpib.3';
update siswa set id_kelas = '12.dpib.1' where id_kelas = '11.dpib.1';
update siswa set id_kelas = '12.dpib.2' where id_kelas = '11.dpib.2';
update siswa set id_kelas = '12.dpib.3' where id_kelas = '11.dpib.3';
update siswa set id_kelas = 'A.dpib.0' where id_kelas = '12.dpib.1';
update siswa set id_kelas = 'A.dpib.0' where id_kelas = '12.dpib.2';
update siswa set id_kelas = 'A.dpib.0' where id_kelas = '12.dpib.3';
update siswa set id_kelas = '11.bkp.1' where id_kelas = '10.bkp.1';
update siswa set id_kelas = '11.bkp.2' where id_kelas = '10.bkp.2';
update siswa set id_kelas = '11.bkp.3' where id_kelas = '10.bkp.3';
update siswa set id_kelas = '12.bkp.1' where id_kelas = '11.bkp.1';
update siswa set id_kelas = '12.bkp.2' where id_kelas = '11.bkp.2';
update siswa set id_kelas = '12.bkp.3' where id_kelas = '11.bkp.3';
update siswa set id_kelas = 'A.bkp.0' where id_kelas = '12.bkp.1';
update siswa set id_kelas = 'A.bkp.0' where id_kelas = '12.bkp.2';
update siswa set id_kelas = 'A.bkp.0' where id_kelas = '12.bkp.3';
end$$

--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `ambil_kategori_fakultas` (`tgkt` INT(11), `jrsn` TEXT, `kls` INT(11)) RETURNS TEXT CHARSET latin1 begin
declare id varchar(15);
declare kategori text;
select id_kelas from kelas where tingkat = tgkt and jurusan = jrsn and kelas = kls into id;
if id = '10.tpg.1' || id = '10.tpg.2' || id = '10.tpg.3' || id = '10.tpm.1' || id = '10.tpm.2' || id = '10.tpm.3' then
set kategori  = 'TPG 10';
end if;
if id = '11.tpg.1' || id = '11.tpg.2' || id = '11.tpg.3' || id = '11.tpm.1' || id = '11.tpm.2' || id = '11.tpm.3' then
set kategori = 'TPG 11';
end if;
if id = '12.tpg.1' || id = '12.tpg.2' || id = '12.tpg.3' || id = '12.tpm.1' || id = '12.tpm.2' || id = '12.tpm.3' then
set kategori = 'TPG 12';
end if;
if id = '10.tptu.1' || id = '10.tptu.2' || id = '10.tptu.3' || id = '10.tjtl.1' || id = '10.tjtl.2' || id = '10.tjtl.3' || '10.titl.1' || id = '10.titl.2' || id = '10.titl.3' then
set kategori = 'TK 10';
end if;
if id = '11.tptu.1' || id = '11.tptu.2' || id = '11.tptu.3' || id = '11.tjtl.1' || id = '11.tjtl.2' || id = '11.tjtl.3' || id = '11.titl.1' || id = '11.titl.2' || id = '11.titl.3' then
set kategori = 'TK 11';
end if;
if id = '12.tptu.1' || id = '12.tptu.2' || id = '12.tptu.3' || id = '12.tjtl.1' || id = '12.tjtl.2' || id = '12.tjtl.3' || id = '12.titl.1' || id = '12.titl.2' || id = '12.titl.3' then
set kategori = 'TK 12';
end if;
if id = '10.tkj.1' || id = '10.tkj.2' || id = '10.tkj.3' || id = '10.rpl.1' || id = '10.rpl.2' || id = '10.rpl.3' then
set kategori = 'TIK 10';
end if;
if id = '11.tkj.1' || id = '11.tkj.2' || id = '11.tkj.3' || id = '11.rpl.1' || id = '11.rpl.2' || id = '11.rpl.3' then
set kategori = 'TIK 11';
end if;
if id = '12.tkj.1' || id = '12.tkj.2' || id = '12.tkj.3' || id = '12.rpl.1' || id = '12.rpl.2' || id = '12.rpl.3' then
set kategori = 'TIK 12';
end if;
if id = '10.tkro.1' || id = '10.tkro.2' || id = '10.tkro.3' || id = '10.tbsm.1' || id = '10.tbsm.2' || id = '10.tbsm.3' then
set kategori = 'TO 10';
end if;
if id = '11.tkro.1' || id = '11.tkro.2' || id = '11.tkro.3' || id = '11.tbsm.1' || id = '11.tbsm.2' || id = '11.tbsm.3' then
set kategori = 'TO 11';
end if;
if id = '12.tkro.1' || id = '12.tkro.2' || id = '12.tkro.3' || id = '12.tbsm.1' || id = '12.tbsm.2' || id = '12.tbsm.3' then
set kategori = 'TO 12';
end if;
if id = '10.tg.1' || id = '10.tg.2' || id = '10.tg.3' then
set kategori = 'TGG 10';
end if;
if id = '12.tg.1' || id = '12.tg.2' || id = '12.tg.3' then
set kategori = 'TGG 12';
end if;
if id = '11.tg.1' || id = '11.tg.2' || id = '11.tg.3' then
set kategori = 'TGG 11';
end if;
if id = '10.tav.1' || id = '10.tav.2' || id = '10.tav.3' then
set kategori = 'TE 10';
end if;
if id = '11.tav.1' || id = '11.tav.2' || id = '11.tav.3' then
set kategori = 'TE 11';
end if;
if id = '12.tav.1' || id = '12.tav.2' || id = '12.tav.3' then
set kategori = 'TE 12';
end if;
if id = '10.pst.1' || id = '10.pst.2' || id = '10.pst.3' then
set kategori = 'SBF 10';
end if;
if id = '11.pst.1' || id = '11.pst.2' || id = '11.pst.3' then
set kategori = 'SBF 11';
end if;
if id = '12.pst.1' || id = '12.pst.2' || id = '12.pst.3' then
set kategori = 'SBF 12';
end if;
if id = '10.dpib.1' || id = '10.dpib.2' || id = '10.dpib.3' || id = '10.bkp.1' || id = '10.bkp.2' || id = '10.bkp.3' then
set kategori = 'TKP 10';
end if;
if id = '11.dpib.1' || id = '11.dpib.2' || id = '11.dpib.3' || id = '11.bkp.1' || id = '11.bkp.2' || id = '11.bkp.3' then
set kategori = 'TKP 11';
end if;
if id = '12.dpib.1' || id = '12.dpib.2' || id = '12.dpib.3' || id = '12.bkp.1' || id = '12.bkp.2' || id = '12.bkp.3' then
set kategori = 'DPIB 12';
end if;
return kategori;
end$$

CREATE DEFINER=`root`@`localhost` FUNCTION `ambil_kategori_jurusan` (`tgkt` INT(11), `jrsn` TEXT, `kls` INT(11)) RETURNS TEXT CHARSET latin1 begin
declare id varchar(15);
declare kategori text;
select id_kelas from kelas where tingkat = tgkt and jurusan = jrsn and kelas = kls into id;
if id = '10.tpg.1' || id = '10.tpg.2' || id = '10.tpg.3' then
set kategori  = 'TPG 10';
end if;
if id = '11.tpg.1' || id = '11.tpg.2' || id = '11.tpg.3' then
set kategori = 'TPG 11';
end if;
if id = '12.tpg.1' || id = '12.tpg.2' || id = '12.tpg.3' then
set kategori = 'TPG 12';
end if;
if id = '10.tptu.1' || id = '10.tptu.2' || id = '10.tptu.3' then
set kategori = 'TPTU 10';
end if;
if id = '11.tptu.1' || id = '11.tptu.2' || id = '11.tptu.3' then
set kategori = 'TPTU 11';
end if;
if id = '12.tptu.1' || id = '12.tptu.2' || id = '12.tptu.3' then
set kategori = 'TPTU 12';
end if;
if id = '10.tpm.1' || id = '10.tpm.2' || id = '10.tpm.3' then
set kategori = 'TPM 10';
end if;
if id = '11.tpm.1' || id = '11.tpm.2' || id = '11.tpm.3' then
set kategori = 'TPM 11';
end if;
if id = '12.tpm.1' || id = '12.tpm.2' || id = '12.tpm.3' then
set kategori = 'TPM 12';
end if;
if id = '10.tkj.1' || id = '10.tkj.2' || id = '10.tkj.3' then
set kategori = 'TKJ 10';
end if;
if id = '11.tkj.1' || id = '11.tkj.2' || id = '11.tkj.3' then
set kategori = 'TKJ 11';
end if;
if id = '12.tkj.1' || id = '12.tkj.2' || id = '12.tkj.3' then
set kategori = 'TKJ 12';
end if;
if id = '10.tkro.1' || id = '10.tkro.2' || id = '10.tkro.3' then
set kategori = 'TKRO 10';
end if;
if id = '11.tkro.1' || id = '11.tkro.2' || id = '11.tkro.3' then
set kategori = 'TKRO 11';
end if;
if id = '12.tkro.1' || id = '12.tkro.2' || id = '12.tkro.3' then
set kategori = 'TKRO 12';
end if;
if id = '10.tgtl.1' || id = '10.tgtl.2' || id = '10.tgtl.3' then
set kategori = 'TGTL 10';
end if;
if id = '11.tgtl.1' || id = '11.tgtl.2' || id = '11.tgtl.3' then
set kategori = 'TGTL 11';
end if;
if id = '12.tgtl.1' || id = '12.tgtl.2' || id = '12.tgtl.3' then
set kategori = 'TGTL 12';
end if;
if id = '10.titl.1' || id = '10.titl.2' || id = '10.titl.3' then
set kategori = 'TITL 10';
end if;
if id = '11.titl.1' || id = '11.titl.2' || id = '11.titl.3' then
set kategori = 'TITL 11';
end if;
if id = '12.titl.1' || id = '12.titl.2' || id = '12.titl.3' then
set kategori = 'TITL 12';
end if;
if id = '10.tg.1' || id = '10.tg.2' || id = '10.tg.3' then
set kategori = 'TG 10';
end if;
if id = '12.tg.1' || id = '12.tg.2' || id = '12.tg.3' then
set kategori = 'TG 12';
end if;
if id = '11.tg.1' || id = '11.tg.2' || id = '11.tg.3' then
set kategori = 'TG 11';
end if;
if id = '10.tbsm.1' || id = '10.tbsm.2' || id = '10.tbsm.3' then
set kategori = 'TBSM 10';
end if;
if id = '11.tbsm.1' || id = '11.tbsm.2' || id = '11.tbsm.3' then
set kategori = 'TBSM 11';
end if;
if id = '12.tbsm.1' || id = '12.tbsm.2' || id = '12.tbsm.3' then
set kategori = 'TBSM 12';
end if;
if id = '10.tav.1' || id = '10.tav.2' || id = '10.tav.3' then
set kategori = 'TAV 10';
end if;
if id = '11.tav.1' || id = '11.tav.2' || id = '11.tav.3' then
set kategori = 'TAV 11';
end if;
if id = '12.tav.1' || id = '12.tav.2' || id = '12.tav.3' then
set kategori = 'TAV 12';
end if;
if id = '10.rpl.1' || id = '10.rpl.2' || id = '10.rpl.3' then
set kategori = 'RPL 10';
end if;
if id = '11.rpl.1' || id = '11.rpl.2' || id = '11.rpl.3' then
set kategori = 'RPL 11';
end if;
if id = '12.rpl.1' || id = '12.rpl.2' || id = '12.rpl.3' then
set kategori = 'RPL 12';
end if;
if id = '10.pst.1' || id = '10.pst.2' || id = '10.pst.3' then
set kategori = 'PST 10';
end if;
if id = '11.pst.1' || id = '11.pst.2' || id = '11.pst.3' then
set kategori = 'PST 11';
end if;
if id = '12.pst.1' || id = '12.pst.2' || id = '12.pst.3' then
set kategori = 'PST 12';
end if;
if id = '10.dpib.1' || id = '10.dpib.2' || id = '10.dpib.3' then
set kategori = 'DPIB 10';
end if;
if id = '11.dpib.1' || id = '11.dpib.2' || id = '11.dpib.3' then
set kategori = 'DPIB 11';
end if;
if id = '12.dpib.1' || id = '12.dpib.2' || id = '12.dpib.3' then
set kategori = 'DPIB 12';
end if;
if id = '10.bkp.1' || id = '10.bkp.2' || id = '10.bkp.3' then
set kategori = 'BKP 10';
end if;
if id = '11.bkp.1' || id = '11.bkp.2' || id = '11.bkp.3' then
set kategori = 'BKP 11';
end if;
if id = '12.bkp.1' || id = '12.bkp.2' || id = '12.bkp.3' then
set kategori = 'BKP 12';
end if;
return kategori;
end$$

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

CREATE DEFINER=`root`@`localhost` FUNCTION `login` (`a` VARCHAR(32), `b` VARCHAR(32)) RETURNS INT(11) begin
    declare cou int;

SELECT COUNT(*) 
into cou 
from petugas
where username = A 
AND password = B;RETURN cou;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `book`
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
-- Dumping data for table `book`
--

INSERT INTO `book` (`ISBN`, `id_rak`, `Penerbit`, `Pengarang`, `thn_buku`, `jmlh`, `tgl_pengadaan`, `Judul`, `jenis_buku`, `kategori`) VALUES
(' 978-602-374-278-1', 'a1', 'Yrama Widya ', 'MH Sapto Widodo', 2018, 100, '2019-06-17', 'Sistem Kelistrikan Refrigerasi Dan Tata Udara Untuk SMK Kelas X', 'Mapel', 'TPTU 10'),
(' 978-602-374-278-2', 'a2', 'Yrama Widya ', 'MH Sapto Widodo', 2018, 100, '2019-06-17', 'Sistem Kelistrikan Refrigerasi Dan Tata Udara Untuk SMK Kelas XI', 'Mapel', 'TPTU 11'),
(' 978-602-374-333-9', 'b2', 'Yrama Widya', 'Drs.Daryanto', 2017, 100, '2019-06-17', 'TEKNIK PENDINGIN AC, FREEZER, KULKAS – SERI BUKU TERAMPIL', 'Mapel', 'TPTU 10'),
(' 978-602-374-334-1', 'b3', 'Yrama Widya', 'Drs.Daryanto', 2017, 100, '2019-06-17', 'TEKNIK PENDINGIN AC, FREEZER, KULKAS – SERI BUKU KREATIF', 'Mapel', 'TPTU 11'),
(' 978-602-374-334-2', 'c1', 'Yrama Widya', 'Drs.Daryanto', 2018, 100, '2019-06-17', 'TEKNIK PENDINGIN AC, FREEZER, KULKAS – SERI BUKU INOVATIF', 'Mapel', 'TPTU 12'),
('972-223-273-11-1', 'a3', 'Grasindo', 'Anton Mabruri', 2016, 100, '2019-06-17', 'Manajemen Produksi Program Acara Jilid 1', 'Mapel', 'PST 10'),
('972-223-273-11-2', 'b2', 'Grasindo', 'Anton Mabruri', 2017, 100, '2019-06-17', 'Manajemen Produksi Program Acara Jilid 2', 'Mapel', 'PST 11'),
('972-223-273-11-3', 'b3', 'Grasindo', 'Anton Mabruri', 2017, 100, '2019-06-17', 'Manajemen Produksi Program Acara Jilid 3', 'Mapel', 'PST 12'),
('972-223-300-1-1', 'b3', 'Simbiosa Rekatama Media', 'Askurifai Baksin', 2013, 100, '2019-06-17', 'Jurnalistik Televisi - Teori dan Praktik', 'Mapel', 'PST 10'),
('972-223-300-1-2', 'c1', 'Simbiosa Rekatama Media', 'Askurifai Baksin', 2014, 100, '2019-06-17', 'Jurnalistik Televisi - Teori dan Praktik Edisi 2', 'Mapel', 'PST 11'),
('972-223-300-1-3', 'c1', 'Simbiosa Rekatama Media', 'Askurifai Baksin', 2015, 100, '2019-06-17', 'Jurnalistik Televisi - Teori dan Praktik Edisi 3', 'Mapel', 'PST 12'),
('974-233-563-138-2', 'a1', 'Prenada Media Group', 'Rusman Latief, Yustiatie Utud ', 2017, 100, '2019-06-18', 'Menjadi Produser Televisi, Profesional Mendesain Program Televisi', 'Mapel', 'SBF 10'),
('974-233-563-138-3', 'a2', 'Prenada Media Group', 'Rusman Latief, Yustiatie Utud ', 2017, 100, '2019-06-18', 'Menjadi Produser Televisi, Profesional Mendesain Program Televisi Edisi Kedua', 'Mapel', 'SBF 11'),
('974-233-563-138-4', 'a3', 'Prenada Media Group', 'Rusman Latief, Yustiatie Utud ', 2017, 100, '2019-06-18', 'Menjadi Produser Televisi, Profesional Mendesain Program Televisi Edisi Kedua', 'Mapel', 'SBF 12'),
('974-293-922-019-2', 'b2', 'Erlangga', 'Cekmas Cekdin', 2017, 100, '2019-06-18', 'Penerapan Geomatika Dasar Jilid 1', 'Mapel', 'TG 10'),
('974-293-922-019-3', 'b2', 'Erlangga', 'Cekmas Cekdin', 2017, 100, '2019-06-18', 'Penerapan Geomatika Dasar Jilid 2', 'Mapel', 'TG 11'),
('974-293-922-019-6', 'b3', 'Erlangga', 'Cekmas Cekdin', 2017, 100, '2019-06-18', 'Penerapan Geomatika Dasar Jilid 3', 'Mapel', 'TG 13'),
('974-423-501-122-7', 'b2', 'Pinus', 'Fred Wibowo', 2007, 100, '2019-06-18', 'Teknik Produksi Program Televisi Edisi A1', 'Mapel', 'SBF 10'),
('974-423-501-122-7-6', 'b3', 'Pinus', 'Fred Wibowo', 2007, 100, '2019-06-18', 'Teknik Produksi Program Televisi Edisi A2', 'Mapel', 'SBF 11'),
('974-423-501-122-7-9', 'c1', 'Pinus', 'Fred Wibowo', 2007, 100, '2019-06-18', 'Teknik Produksi Program Televisi Edisi Akhir', 'Mapel', 'SBF 12'),
('975-228-383-11-4', 'b2', 'Mediatama', 'NOVIANA IRNAWATI', 2013, 100, '2019-06-18', 'PEMELIHARAAN KELISTRIKAN KENDARAAN RINGAN SMK KELAS X REVISI', 'Mapel', 'TITL 10'),
('975-228-383-11-6', 'b3', 'Mediatama', 'NOVIANA IRNAWATI', 2013, 100, '2019-06-18', 'PEMELIHARAAN KELISTRIKAN KENDARAAN RINGAN SMK KELAS XI', 'Mapel', 'TITL 11'),
('975-228-383-11-7', 'c1', 'Mediatama', 'NOVIANA IRNAWATI', 2013, 100, '2019-06-18', 'PEMELIHARAAN KELISTRIKAN KENDARAAN RINGAN SMK KELAS XII', 'Mapel', 'TITL 12'),
('975-83-1276-33-21-1', 'a1', 'Yudistira', 'Sastro Wijoyo', 2017, 100, '2019-06-18', 'Desain Pemodelan dan Informasi Bangunan Kelas X', 'Mapel', 'DPIB 10'),
('975-83-1276-33-21-4', 'a2', 'Yudistira', 'Sastro Wijoyo', 2017, 100, '2019-06-18', 'Desain Pemodelan dan Informasi Bangunan Kelas XI', 'Mapel', 'DPIB 11'),
('975-83-1276-33-21-6', 'a3', 'Yudistira', 'Sastro Wijoyo', 2017, 100, '2019-06-18', 'Desain Pemodelan dan Informasi Bangunan Kelas XII', 'Mapel', 'DPIB 12'),
('976-224-873-044-3', 'a1', 'BSE', 'RIna Mariana', 2017, 100, '2019-06-18', 'Dasar Pemetaan dan Geomatika Jilid 1', 'Mapel', 'TG 10'),
('976-224-873-044-6', 'a2', 'BSE', 'RIna Mariana', 2017, 100, '2019-06-18', 'Dasar Pemetaan dan Geomatika Jilid 2', 'Mapel', 'TG 11'),
('976-224-873-044-7', 'a3', 'BSE', 'RIna Mariana', 2017, 100, '2019-06-18', 'Dasar Pemetaan dan Geomatika Jilid 3', 'Mapel', 'TG 12'),
('976-287-446-0-22-5', 'a1', 'Yudhistira	', 'Bambang Jatmika	', 2010, 100, '2019-06-18', 'RPL 1 Rekayasa Perangkat Lunak SMK Kelas X', 'Mapel', 'RPL 10'),
('976-287-446-0-22-6', 'a2', 'Yudhistira	', 'Bambang Jatmika	', 2010, 100, '2019-06-18', 'RPL 2 Rekayasa Perangkat Lunak SMK Kelas XI', 'Mapel', 'RPL 11'),
('976-287-446-0-22-7', 'a3', 'Yudhistira	', 'Bambang Jatmika	', 2010, 100, '2019-06-18', 'RPL 3 Rekayasa Perangkat Lunak SMK Kelas XII', 'Mapel', 'RPL 12'),
('977-209-383-60-1', 'a3', 'INFORMATIKA', 'Eddy Prahasta', 2015, 100, '2019-06-18', 'Teori Dasar Teknik Tenaga Listrik ', 'Mapel', 'TGG 10'),
('977-209-383-60-2', 'b2', 'INFORMATIKA', 'Eddy Prahasta', 2016, 100, '2019-06-18', 'Teori Dasar Teknik Tenaga Listrik  Edisi 2', 'Mapel', 'TGG 11'),
('977-209-383-60-3', 'b3', 'INFORMATIKA', 'Eddy Prahasta', 2016, 100, '2019-06-18', 'Teori Dasar Teknik Tenaga Listrik  Edisi 3', 'Mapel', 'TGG 12'),
('977-209-383-78-1', 'a1', 'INFORMATIKA', 'Eddy Prahasta', 2015, 100, '2019-06-18', 'SIC: Tutorial ArcGIS Desktop Untuk Bidang Geodesi & Geomatika', 'Mapel', 'TGG 10'),
('977-209-383-78-2', 'a2', 'INFORMATIKA', 'Eddy Prahasta', 2015, 100, '2019-06-18', 'SIC: Tutorial ArcGIS Desktop Untuk Bidang Geodesi & Geomatika Jilid 2', 'Mapel', 'TGG 11'),
('977-209-383-78-3', 'a3', 'INFORMATIKA', 'Eddy Prahasta', 2015, 100, '2019-06-18', 'SIC: Tutorial ArcGIS Desktop Untuk Bidang Geodesi & Geomatika Jilid 3', 'Mapel', 'TGG 12'),
('977-341-120-11-2', 'a2', 'Skripta', 'Muhkamad Wakid, M.Eng.', 2011, 100, '2019-06-17', 'Sistem Transmisi Kendaraan Ringan', 'Mapel', 'TKRO 10'),
('977-341-120-11-3', 'a3', 'Skripta', 'Muhkamad Wakid, M.Eng.', 2012, 100, '2019-06-17', 'Sistem Transmisi Kendaraan Ringan Kelas XI', 'Mapel', 'TKRO 11'),
('977-341-120-11-5', 'b3', 'Skripta', 'Muhkamad Wakid, M.Eng.', 2013, 100, '2019-06-17', 'Sistem Transmisi Kendaraan Ringan Kelas XII', 'Mapel', 'TKRO 12'),
('977-341-230-12-1', 'a2', 'PT. Citra Aji Parama', 'Sutiman, M.T.', 2011, 100, '2019-06-17', 'Sistem Pengapian Elektronik Kelas X', 'Mapel', 'TKRO 10'),
('977-341-230-12-2', 'a1', 'PT. Citra Aji Parama', 'Sutiman, M.T.', 2012, 100, '2019-06-17', 'Sistem Pengapian Elektronik Kelas XI', 'Mapel', 'TKRO 11'),
('977-341-230-12-4', 'a2', 'PT. Citra Aji Parama', 'Sutiman, M.T.', 2012, 100, '2019-06-17', 'Sistem Pengapian Elektronik Kelas XII', 'Mapel', 'TKRO 12'),
('978-223-673-11-5', 'a1', 'Mediatama', 'Wahyu Eko Widiyatmoko', 2013, 100, '2019-06-18', 'PEMELIHARAAN MESIN SEPEDA MOTOR edisi revisi', 'Mapel', 'TBSM 10'),
('978-223-673-11-6', 'a2', 'Mediatama', 'Wahyu Eko Widiyatmoko', 2013, 100, '2019-06-18', 'PEMELIHARAAN MESIN SEPEDA MOTOR edisi 1', 'Mapel', 'TBSM 11'),
('978-223-673-11-7', 'a3', 'Mediatama', 'Wahyu Eko Widiyatmoko', 2013, 100, '2019-06-18', 'PEMELIHARAAN MESIN SEPEDA MOTOR edisi 2', 'Mapel', 'TBSM 12'),
('978-229-109-22-3', 'a3', 'Yrama Widya ', 'MH Sapto Widodo', 2018, 100, '2019-06-17', 'Sistem Kelistrikan Refrigerasi Dan Tata Udara Untuk SMK Kelas XII', 'Mapel', 'TPTU 12'),
('978-344-104-089-4', 'c2', 'Alex Media Komputindo', 'Ian Chandra K ', 2003, 100, '2019-06-18', 'Utility Audio Video ', 'Mapel', 'TAV 10'),
('978-344-104-089-5', 'c1', 'Alex Media Komputindo', 'Ian Chandra K ', 2003, 100, '2019-06-18', 'Utility Audio Video Edisi 1', 'Mapel', 'TAV 11'),
('978-344-104-089-6', 'b3', 'Alex Media Komputindo', 'Ian Chandra K ', 2003, 100, '2019-06-18', 'Utility Audio Video Edisi 2', 'Mapel', 'TAV 12'),
('978-5621-745-443-5', 'a1', ' Graha Ilmu', 'Ir. Markoni, S.H., M.T.', 2018, 100, '2019-06-18', 'Teori Dasar Teknik Tenaga Listrik Edisi 1', 'Mapel', 'TJTL 10'),
('978-5621-745-443-7', 'a2', ' Graha Ilmu', 'Ir. Markoni, S.H., M.T.', 2018, 100, '2019-06-18', 'Teori Dasar Teknik Tenaga Listrik Edisi 2', 'Mapel', 'TJTL 11'),
('978-5621-745-443-8', 'a3', ' Graha Ilmu', 'Ir. Markoni, S.H., M.T.', 2018, 100, '2019-06-18', 'Teori Dasar Teknik Tenaga Listrik Edisi 3', 'Mapel', 'TJTL 12'),
('978-602-250-149-7', 'a2', 'Gema Insani', 'Fikri Habibullah M', 2013, 8, '2019-06-16', 'Tuhan, Izinkan Aku Pacaran', 'Khusus', 'Romansa'),
('978-602-250-235-7', 'a1', 'Gema Insani', 'Uwais Ramadhan', 2015, 3, '2019-06-16', 'Kisah 7 Bayi Bisa Bicara', 'Umum', 'IPA'),
('978-602-250-262-3', 'a1', 'Gema Insani', 'Toni Raharjo', 2015, 17, '2019-06-16', 'Jejak-jejak Cinta', 'Umum', 'Novel'),
('978-602-260-233-3', 'a3', 'Gema Insani', 'Salma', 2014, 3, '2019-06-16', 'Tetap Sehat setelah Usia 40 Tahun', 'Umum', 'IPA'),
('978-602-277-035-0', 'a2', 'Yrama Widya', 'Drs. Daryanto', 2018, 100, '2019-06-17', 'Teknik Sepeda Motor Seri Buku Terampil', 'Mapel', 'TBSM 10'),
('978-602-277-035-1', 'a3', 'Yrama Widya', 'Drs. Daryanto', 2018, 100, '2019-06-17', 'Teknik Sepeda Motor Seri Buku Kreatif', 'Mapel', 'TBSM 11'),
('978-602-277-035-2', 'b2', 'Yrama Widya', 'Drs. Daryanto', 2018, 100, '2019-06-17', 'Teknik Sepeda Motor Seri Buku Inovatif', 'Mapel', 'TBSM 12'),
('978-602-277-035-5', 'b2', 'Yrama Widya', 'Drs. Daryanto', 2015, 100, '2019-06-18', 'TEKNIK SEPEDA MOTOR SERI BUKU TERAMPIL EDISI PERTAMA', 'Mapel', 'TO 10'),
('978-602-277-035-6', 'b3', 'Yrama Widya', 'Drs. Daryanto', 2015, 100, '2019-06-18', 'TEKNIK SEPEDA MOTOR SERI BUKU TERAMPIL EDISI kEDUA', 'Mapel', 'TO 11'),
('978-602-277-035-7', 'c1', 'Yrama Widya', 'Drs. Daryanto', 2015, 100, '2019-06-18', 'TEKNIK SEPEDA MOTOR SERI BUKU TERAMPIL EDISI KETIGA', 'Mapel', 'TO 12'),
('978-602-277-184-5', 'a1', 'Yrama Widya', 'WAHYU A & ADE M', 2016, 100, '2019-06-18', 'TEKNOLOGI INFORMASI DAN KOMUNIKASI BERBASIS KARAKTER UNTUK SMA/MA KELAS X', 'Mapel', 'TIK 10'),
('978-602-277-184-6', 'a2', 'Yrama Widya', 'WAHYU A & ADE M', 2016, 100, '2019-06-18', 'TEKNOLOGI INFORMASI DAN KOMUNIKASI BERBASIS KARAKTER UNTUK SMA/MA KELAS XI', 'Mapel', 'TIK 11'),
('978-602-277-184-7', 'a3', 'Yrama Widya', 'WAHYU A & ADE M', 2016, 100, '2019-06-18', 'TEKNOLOGI INFORMASI DAN KOMUNIKASI BERBASIS KARAKTER UNTUK SMA/MA KELAS XII', 'Mapel', 'TIK 12'),
('978-602-289-123-94', 'a1', 'Alfabeta, cv', 'Jacobus Ranjabar', 2015, 18, '2019-06-16', 'Perubahan Sosial', 'Umum', 'Sosial'),
('978-602-374-442-6', 'a1', 'Yrama Widya', 'SUPRIYADI', 2015, 100, '2019-06-18', 'EKSIS MEMPERBAIKI TRANSMISI MANUAL DAN OTOMATIS SEPEDA MOTOR UNTUK SMK/MAK KELAS X', 'Mapel', 'TO 10'),
('978-602-374-442-7', 'a2', 'Yrama Widya', 'SUPRIYADI', 2015, 100, '2019-06-18', 'EKSIS MEMPERBAIKI TRANSMISI MANUAL DAN OTOMATIS SEPEDA MOTOR UNTUK SMK/MAK KELAS XI', 'Mapel', 'TO 11'),
('978-602-374-442-8', 'a3', 'Yrama Widya', 'SUPRIYADI', 2015, 100, '2019-06-18', 'EKSIS MEMPERBAIKI TRANSMISI MANUAL DAN OTOMATIS SEPEDA MOTOR UNTUK SMK/MAK KELAS XII', 'Mapel', 'TO 12'),
('978-602-425-003-3', 'a2', 'Rajawali Pers', 'Sofjan Assauri', 2016, 100, '2019-06-18', 'MANAJEMEN OPERASI PRODUKSI - Edisi 2', 'Mapel', 'PST 11'),
('978-602-425-003-4', 'a1', 'Rajawali Pers', 'Sofjan Assauri', 2016, 100, '2019-06-18', 'MANAJEMEN OPERASI PRODUKSI - Edisi 3', 'Mapel', 'PST 12'),
('978-602-425-003-6', 'b3', 'Rajawali Pers', 'Sofjan Assauri', 2016, 100, '2019-06-18', 'MANAJEMEN OPERASI PRODUKSI', 'Mapel', 'PST 10'),
('978-602-444-284-2', 'c1', 'Bumi Aksara', 'Sumari Agus Prasetyo, S.Pd', 2013, 100, '2019-06-17', 'Komputer dan Jaringan Dasar SMK/MAK Kelas X Revisi 2013', 'Mapel', 'TKJ 10'),
('978-602-444-284-3', 'c1', 'Bumi Aksara', 'Sumari Agus Prasetyo, S.Pd', 2013, 100, '2019-06-17', 'Komputer dan Jaringan Dasar SMK/MAK Kelas XI Revisi 2013', 'Mapel', 'TKJ 11'),
('978-602-444-284-4', 'a3', 'Bumi Aksara', 'Sumari Agus Prasetyo, S.Pd', 2014, 100, '2019-06-17', 'Komputer dan Jaringan Dasar SMK/MAK Kelas XII Revisi 2013', 'Mapel', 'TKJ 12'),
('978-602-444-326-11', 'a2', 'Bumi Aksara', 'Sri Wahyuni', 2013, 100, '2019-06-17', 'Simulasi dan Komunikasi Digital : Program Keahlian Teknologi dan Komunikasi SMK/MAK Kelas XII Kurikulum 2013 Revisi', 'Mapel', 'TKJ 12'),
('978-602-444-326-9', 'a2', 'Bumi Aksara', 'Sri Wahyuni', 2013, 100, '2019-06-17', 'Simulasi dan Komunikasi Digital : Program Keahlian Teknologi dan Komunikasi SMK/MAK Kelas XI Kurikulum 2013 Revisi', 'Mapel', 'TKJ 11'),
('978-602-444-522-5', 'a1', 'Kompetensi Keahlian Multimedia', 'Siwi Widi Asmoro', 2019, 100, '2019-06-17', 'Teknik Pengolahan Audio dan Video  Kurikulum 2013 revisi 2017 Edisi 1', 'Mapel', 'TAV 10'),
('978-602-444-522-6', 'a2', 'Kompetensi Keahlian Multimedia', 'Siwi Widi Asmoro', 2019, 100, '2019-06-17', 'Teknik Pengolahan Audio dan Video  Kurikulum 2013 revisi 2017 Edisi 2', 'Mapel', 'TAV 11'),
('978-602-444-522-7', 'a3', 'Kompetensi Keahlian Multimedia', 'Siwi Widi Asmoro', 2019, 100, '2019-06-17', 'Teknik Pengolahan Audio dan Video  Kurikulum 2013 revisi 2017 Edisi 3', 'Mapel', 'TAV 12'),
('978-602-454-016-6', 'a1', 'ARMICO', 'Eka Yogaswara ', 2018, 100, '2019-06-17', 'TEKINIK PENGELASAN GAS METAL (MIG-MAG) Untuk SMK/MAK Kelas X', 'Mapel', 'TPG 10'),
('978-602-454-016-7', 'a2', 'ARMICO', 'Eka Yogaswara ', 2018, 100, '2019-06-17', 'TEKINIK PENGELASAN GAS METAL (MIG-MAG) Untuk SMK/MAK Kelas XI', 'Mapel', 'TPG 11'),
('978-602-454-016-8', 'a3', 'ARMICO', 'Eka Yogaswara ', 2019, 100, '2019-06-17', 'TEKINIK PENGELASAN GAS METAL (MIG-MAG) Untuk SMK/MAK Kelas XII', 'Mapel', 'TPG 12'),
('978-602-6321-55-8', 'a1', 'Sinergi Prima Magna', 'Sarjan Ramdhani', 2017, 100, '2019-06-17', 'Teknik Pemesinan Bubut Kelas X', 'Mapel', 'TPM 10'),
('978-602-6321-55-9', 'a2', 'Sinergi Prima Magna', 'Sarjan Ramdhani', 2017, 100, '2019-06-17', 'Teknik Pemesinan Bubut Kelas XI', 'Mapel', 'TPM 11'),
('978-602-6321-56-1', 'a3', 'Sinergi Prima Magna', 'Sarjan Ramdhani', 2017, 100, '2019-06-17', 'Teknik Pemesinan Bubut Kelas XII', 'Mapel', 'TPM 12'),
('978-602-702-60-0-1', 'a2', 'Dimar Intermedia - Kediri', 'Bayu Pramutoko', 2014, 5, '2019-06-16', 'Manajemen Pemasaran', 'Umum', 'Keuangan'),
('978-602-760-511-4', 'a2', 'Wedatama Widya Sastra', 'Maman Mahayana', 2015, 21, '2019-06-16', 'Bahasa Indonesia Kreatif Edisi Revisi', 'Umum', 'Bahasa'),
('978-602-8545-28-1', 'a1', 'Gava media', 'Lantip Diat Prasojo & Riyanto', 2016, 100, '2019-06-18', 'Teknologi Informasi Pendidikan Jilid 1', 'Mapel', 'TIK 10'),
('978-602-8545-28-2', 'a3', 'Gava media', 'Lantip Diat Prasojo & Riyanto', 2016, 100, '2019-06-18', 'Teknologi Informasi Pendidikan Jilid 1', 'Mapel', 'TIK 11'),
('978-602-8545-28-3', 'b2', 'Gava media', 'Lantip Diat Prasojo & Riyanto', 2016, 100, '2019-06-18', 'Teknologi Informasi Pendidikan Jilid 1', 'Mapel', 'TIK 12'),
('978-623-244-12-2', 'b3', 'GRAMEDIA JAKARTA', 'Zuhal', 2016, 100, '2019-06-18', 'DASAR TEKNIK TENAGA LISTRIK DAN ELEKTRONIKA DAYA Kelas X', 'Mapel', 'TJTL 10'),
('978-623-244-12-3', 'c1', 'GRAMEDIA JAKARTA', 'Zuhal', 2016, 100, '2019-06-18', 'DASAR TEKNIK TENAGA LISTRIK DAN ELEKTRONIKA DAYA Kelas XI', 'Mapel', 'TJTL 11'),
('978-623-244-12-6', 'c2', 'GRAMEDIA JAKARTA', 'Zuhal', 2016, 100, '2019-06-18', 'DASAR TEKNIK TENAGA LISTRIK DAN ELEKTRONIKA DAYA Kelas XII', 'Mapel', 'TJTL 12'),
('978-733-212-102-3', 'a1', 'Gramedia', 'Amir Hamzah', 2013, 100, '2019-06-18', 'Perekayasaan Sistem Radio dan Televisi', 'Mapel', 'TE 10'),
('978-733-212-102-5', 'b2', 'Gramedia', 'Amir Hamzah', 2013, 100, '2019-06-18', 'Perekayasaan Sistem Radio dan Televisi Edisi 1', 'Mapel', 'TE 11'),
('978-733-212-102-6', 'b3', 'Gramedia', 'Amir Hamzah', 2013, 100, '2019-06-18', 'Perekayasaan Sistem Radio dan Televisi Edisi 3', 'Mapel', 'TE 12'),
('978-733-212-43-1', 'a1', 'Gramedia', 'Amir Hamzah', 1988, 100, '2019-06-18', 'Media Audio-Visual', 'Mapel', 'TE 10'),
('978-733-212-43-2', 'a2', 'Gramedia', 'Amir Hamzah', 1988, 100, '2019-06-18', 'Media Audio-Visual Jilid 2', 'Mapel', 'TE 11'),
('978-733-212-43-3', 'a3', 'Gramedia', 'Amir Hamzah', 1988, 100, '2019-06-18', 'Media Audio-Visual Jilid 3', 'Mapel', 'TE 12'),
('978-979-060-085-0 ', 'a1', 'Buku Sekolah Elektronik', 'Sunyoto', 2008, 100, '2019-06-18', 'Teknik Mesin Industri Edisi 2', 'Mapel', 'TM 10'),
('978-979-060-085-2', 'a2', 'Buku Sekolah Elektronik', 'Sunyoto', 2008, 100, '2019-06-18', 'Teknik Mesin Industri Edisi 3', 'Mapel', 'TM 11'),
('978-979-060-085-3', 'a3', 'Buku Sekolah Elektronik', 'Sunyoto', 2008, 100, '2019-06-18', 'Teknik Mesin Industri Edisi Akhir', 'Mapel', 'TM 12'),
('978-979-060-097-3 ', 'a1', 'Buku Sekolah Elektronik', 'Supari Muslim', 2008, 100, '2019-06-18', 'Teknik Pembangkit Tenaga Listrik Jilid 1', 'Mapel', 'TK 10'),
('978-979-060-097-4', 'a2', 'Buku Sekolah Elektronik', 'Supari Muslim', 2008, 100, '2019-06-18', 'Teknik Pembangkit Tenaga Listrik Jilid 2', 'Mapel', 'TK 11'),
('978-979-060-097-5', 'a3', 'Buku Sekolah Elektronik', 'Supari Muslim', 2008, 100, '2019-06-18', 'Teknik Pembangkit Tenaga Listrik Jilid 3', 'Mapel', 'TK 12'),
('978-979-060-103-1', 'b2', 'Erlangga', 'Brian Scaddan', 2004, 100, '2019-06-18', 'Instalasi Listrik Rumah Tangga Jilid 1', 'Mapel', 'TK 10'),
('978-979-060-103-2', 'b3', 'Erlangga', 'Brian Scaddan', 2004, 100, '2019-06-18', 'Instalasi Listrik Rumah Tangga Jilid 2', 'Mapel', 'TK 11'),
('978-979-060-103-3', 'b3', 'Erlangga', 'Brian Scaddan', 2004, 100, '2019-06-18', 'Instalasi Listrik Rumah Tangga Jilid 3', 'Mapel', 'TK 12'),
('978-979-060-115-4 ', 'b3', 'Buku Sekolah Elektronik', 'Widarto', 2008, 100, '2019-06-17', 'Teknik Pemesinan Jilid 1', 'Mapel', 'TPM 10'),
('978-979-060-115-5', 'c1', 'Buku Sekolah Elektronik', 'Widarto', 2008, 100, '2019-06-17', 'Teknik Pemesinan Jilid 2', 'Mapel', 'TPM 11'),
('978-979-060-115-6', 'c2', 'Buku Sekolah Elektronik', 'Widarto', 2008, 100, '2019-06-17', 'Teknik Pemesinan Jilid 3', 'Mapel', 'TPM 12'),
('978-979-060-762-3', 'b2', 'Skripta', 'Muhkamad Wakid, M.Eng.', 2011, 100, '2019-06-18', ' Sistem Transmisi Kendaraan Ringan', 'Mapel', 'TM 10'),
('978-979-060-762-4', 'b3', 'Skripta', 'Muhkamad Wakid, M.Eng.', 2011, 100, '2019-06-18', ' Sistem Transmisi Kendaraan Ringan Jilid 2', 'Mapel', 'TM 11'),
('978-979-060-762-5', 'c1', 'Skripta', 'Muhkamad Wakid, M.Eng.', 2011, 100, '2019-06-18', ' Sistem Transmisi Kendaraan Ringan Jilid 3', 'Mapel', 'TM 12'),
('978-979-29-1347-7', 'b3', 'Erlangga', 'Janner Simarmata', 2015, 100, '2019-06-18', 'Rekayasa Perangkat Lunak I', 'Mapel', 'RPL 10'),
('978-979-29-1347-8', 'c1', 'Erlangga', 'Janner Simarmata', 2015, 100, '2019-06-18', 'Rekayasa Perangkat Lunak II', 'Mapel', 'RPL 11'),
('978-979-29-1347-9', 'c2', 'Erlangga', 'Janner Simarmata', 2015, 100, '2019-06-18', 'Rekayasa Perangkat Lunak III', 'Mapel', 'RPL 13'),
('978-979-29-6540-7', 'b3', 'Andi Publisher', 'Ridlho Erfan Nugroho, S.T., Suryaningrum, S.T.', 2018, 100, '2019-06-18', 'Sistem Utilitas Bangunan Gedung - Program Keahlian: Teknik Konstruksi dan Properti - SMK/MAK Kelas X', 'Mapel', 'BKP 10'),
('978-979-29-6540-8', 'c1', 'Andi Publisher', 'Ridlho Erfan Nugroho, S.T., Suryaningrum, S.T.', 2018, 100, '2019-06-18', 'Sistem Utilitas Bangunan Gedung - Program Keahlian: Teknik Konstruksi dan Properti - SMK/MAK Kelas XI', 'Mapel', 'BKP 11'),
('978-979-29-6540-9', 'c2', 'Andi Publisher', 'Ridlho Erfan Nugroho, S.T., Suryaningrum, S.T.', 2018, 100, '2019-06-18', 'Sistem Utilitas Bangunan Gedung - Program Keahlian: Teknik Konstruksi dan Properti - SMK/MAK Kelas XII', 'Mapel', 'BKP 12'),
('978-979-29-6859-1', 'a1', 'Andi Publisher', 'Ridlho Erfan Nugroho, S.T., Suryaningrum, ', 2018, 100, '2019-06-18', 'Produk Kreatif dan Kewirausahaan I', 'Mapel', 'BKP 10'),
('978-979-29-6859-5', 'a2', 'Andi Publisher', 'Ridlho Erfan Nugroho, S.T., Suryaningrum, ', 2018, 100, '2019-06-18', 'Produk Kreatif dan Kewirausahaan II', 'Mapel', 'BKP 11'),
('978-979-29-6859-7', 'a3', 'Andi Publisher', 'Ridlho Erfan Nugroho, S.T., Suryaningrum, ', 2018, 100, '2019-06-18', 'Produk Kreatif dan Kewirausahaan III', 'Mapel', 'BKP 13'),
('978-979-727-991-2', 'a1', 'Arfino Raya', 'Eka Yogaswara', 2017, 100, '2019-06-17', 'EKNIK PENGELASAN LAS BUSUR MANUAL (SMAW) Untuk SMK/MAK Kelas X', 'Mapel', 'TPG 10'),
('978-979-727-991-3', 'a2', 'Arfino Raya', 'Eka Yogaswara', 2017, 100, '2019-06-17', 'EKNIK PENGELASAN LAS BUSUR MANUAL (SMAW) Untuk SMK/MAK Kelas XI', 'Mapel', 'TPG 11'),
('978-979-727-991-4', 'a3', 'Arfino Raya', 'Eka Yogaswara', 2017, 100, '2019-06-17', 'EKNIK PENGELASAN LAS BUSUR MANUAL (SMAW) Untuk SMK/MAK Kelas XII', 'Mapel', 'TPG 12'),
('978-979-756-78-11', 'b2', 'Graha Ilmu', 'Hamzah Berahim', 2011, 100, '2019-06-17', 'Teknik Tenaga Listrik Dasar', 'Mapel', 'TITL 10'),
('978-979-756-78-12', 'b3', 'Graha Ilmu', 'Hamzah Berahim', 2012, 100, '2019-06-17', 'Teknik Tenaga Listrik Dasar Jilid 2', 'Mapel', 'TITL 11'),
('978-979-756-78-13', 'c2', 'Graha Ilmu', 'Hamzah Berahim', 2014, 100, '2019-06-17', 'Teknik Tenaga Listrik Dasar Edisi Akhir', 'Mapel', 'TITL 12'),
('978-979-778-321-1', 'a1', 'roduk Kreatif dan Kewirausahaan SMK/MAK untuk Kelas XI KURIKULUM 2013', 'Iman Firmansyah, S.Pd', 2018, 100, '2019-06-17', 'Produk Kreatif Dan Kewirausahaan - Teknik Konstruksi dan Properti', 'Mapel', 'TKP 10'),
('978-979-778-321-2', 'a2', 'roduk Kreatif dan Kewirausahaan SMK/MAK untuk Kelas XI KURIKULUM 2013', 'Iman Firmansyah, S.Pd', 2018, 100, '2019-06-17', 'Produk Kreatif Dan Kewirausahaan - Teknik Konstruksi dan Properti Jilid 2', 'Mapel', 'TKP 11'),
('978-979-778-321-3', 'a3', 'roduk Kreatif dan Kewirausahaan SMK/MAK untuk Kelas XI KURIKULUM 2013', 'Iman Firmansyah, S.Pd', 2018, 100, '2019-06-17', 'Produk Kreatif Dan Kewirausahaan - Teknik Konstruksi dan Properti Jilid 3', 'Mapel', 'TKP 12'),
('979-044-886-5', 'b2', 'EGC', 'Abdur Rahman & Dandik Widayat', 2018, 100, '2019-06-17', 'Produk Kreatif dan Kewirausahaan untuk SMK Jilid 1', 'Mapel', 'TKP 10'),
('979-044-886-6', 'b3', 'EGC', 'Abdur Rahman & Dandik Widayat', 2018, 100, '2019-06-17', 'Produk Kreatif dan Kewirausahaan untuk SMK Jilid 2', 'Mapel', 'TKP 11'),
('979-044-886-7', 'c1', 'EGC', 'Abdur Rahman & Dandik Widayat', 2018, 100, '2019-06-17', 'Produk Kreatif dan Kewirausahaan untuk SMK Jilid 3', 'Mapel', 'TKP 12'),
('979-334-743-334-2', 'b2', 'Yudistira', 'Suryaningrum, S.T.', 2018, 100, '2019-06-18', 'Desain Pemodelan Dasar Bangunan Kelas X', 'Mapel', 'DPIB 10'),
('979-334-743-334-6', 'b3', 'Yudistira', 'Suryaningrum, S.T.', 2018, 100, '2019-06-18', 'Desain Pemodelan Dasar Bangunan Kelas XI', 'Mapel', 'DPIB 11'),
('979-334-743-334-7', 'c1', 'Yudistira', 'Suryaningrum, S.T.', 2018, 100, '2019-06-18', 'Desain Pemodelan Dasar Bangunan Kelas XI', 'Mapel', 'DPIB 12'),
('979-97312-11-6', 'a1', 'Lentera Dipantera', 'Pramoedya Ananta Toer', 2010, 12, '2019-06-16', 'Panggil Aku Kartini Saja', 'Umum', 'Biografi');

--
-- Triggers `book`
--
DELIMITER $$
CREATE TRIGGER `insert_lokasi` AFTER INSERT ON `book` FOR EACH ROW BEGIN
declare lks text;
select concat('rak ',left(new.id_rak,1),' tingkat ',right(new.id_rak,1)) into lks;
if not exists (select id_rak from lok_book where id_rak = new.id_rak) then
insert into lok_book (id_rak, rak, tingkat, lokasi) 
values (new.id_rak, left(new.id_rak,1), right(new.id_rak,1), lks);
end if;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `insert_lokasi2` AFTER UPDATE ON `book` FOR EACH ROW BEGIN
declare lks text;
select concat('rak ',left(new.id_rak,1),' tingkat ',right(new.id_rak,1)) into lks;
if not exists (select id_rak from lok_book where id_rak = new.id_rak) then
insert into lok_book (id_rak, rak, tingkat, lokasi) 
values (new.id_rak, left(new.id_rak,1), right(new.id_rak,1), lks);
end if;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `buku`
-- (See below for the actual view)
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
-- Table structure for table `cashflow`
--

CREATE TABLE `cashflow` (
  `no_cashflow` int(11) NOT NULL,
  `id_petugas` int(255) NOT NULL,
  `tipe` enum('Pemasukan','Pengeluaran','','') NOT NULL,
  `tanggal` int(11) NOT NULL,
  `nominal` int(255) NOT NULL,
  `keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cashflow`
--

INSERT INTO `cashflow` (`no_cashflow`, `id_petugas`, `tipe`, `tanggal`, `nominal`, `keterangan`) VALUES
(1, 3, 'Pemasukan', 20190702, 100000, 'Pemasukan Bulan Juni 2019');

-- --------------------------------------------------------

--
-- Table structure for table `kelas`
--

CREATE TABLE `kelas` (
  `id_kelas` varchar(11) NOT NULL,
  `tingkat` varchar(11) NOT NULL,
  `jurusan` text NOT NULL,
  `kelas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kelas`
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
('11.titl.1', '11', 'Teknik Instalasi Tenaga Listrik', 1),
('11.titl.2', '11', 'Teknik Instalasi Tenaga Listrik', 2),
('11.titl.3', '11', 'Teknik Instalasi Tenaga Listrik', 3),
('11.tjtl.1', '11', 'Teknik Jaringan Tenaga Listrik', 1),
('11.tjtl.2', '11', 'Teknik Jaringan Tenaga Listrik', 2),
('11.tjtl.3', '11', 'Teknik Jaringan Tenaga Listrik', 3),
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
('12.titl.1', '12', 'Teknik Instalasi Tenaga Listrik', 1),
('12.titl.2', '12', 'Teknik Instalasi Tenaga Listrik', 2),
('12.titl.3', '12', 'Teknik Instalasi Tenaga Listrik', 3),
('12.tjtl.1', '12', 'Teknik Jaringan Tenaga Listrik', 1),
('12.tjtl.2', '12', 'Teknik Jaringan Tenaga Listrik', 2),
('12.tjtl.3', '12', 'Teknik Jaringan Tenaga Listrik', 3),
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
('A.titl.0', 'Alumni', 'Teknik Instalasi Tenaga Listrik', 0),
('A.tjtl.0', 'Alumni', 'Teknik Jaringan Tenaga Listrik', 0),
('A.tkj.0', 'Alumni', 'Teknik Komputer dan Jaringan', 0),
('A.tkro.0', 'Alumni', 'Teknik Kendaraan Ringan Otomotif', 0),
('A.tpg.0', 'Alumni', 'Teknik Pengelasan', 0),
('A.tpm.0', 'Alumni', 'Teknik Pemesinan', 0),
('A.tptu.0', 'Alumni', 'Teknik Pendingin dan Tata Udara', 0);

-- --------------------------------------------------------

--
-- Stand-in structure for view `kembali`
-- (See below for the actual view)
--
CREATE TABLE `kembali` (
`id_transaksi` int(11)
,`isbn` varchar(32)
,`judul` varchar(150)
,`nis` int(11)
,`nama` varchar(100)
,`t_pinjam` date
,`t_kembali` date
,`t_deadline` date
);

-- --------------------------------------------------------

--
-- Table structure for table `log_siswa`
--

CREATE TABLE `log_siswa` (
  `nis` int(11) NOT NULL,
  `nama` varchar(32) NOT NULL,
  `id_kelas` varchar(11) NOT NULL,
  `alamat` text NOT NULL,
  `no_telp` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `lok_book`
--

CREATE TABLE `lok_book` (
  `id_rak` varchar(11) NOT NULL,
  `rak` varchar(2) NOT NULL,
  `tingkat` int(2) NOT NULL,
  `lokasi` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lok_book`
--

INSERT INTO `lok_book` (`id_rak`, `rak`, `tingkat`, `lokasi`) VALUES
('a1', 'a', 1, 'rak a tingkat 1'),
('a2', 'a', 2, 'rak a tingkat 2'),
('a3', 'a', 3, 'rak a tingkat 3'),
('b2', 'b', 2, 'rak b tingkat 2'),
('b3', 'b', 3, 'rak b tingkat 3'),
('c1', 'c', 1, 'rak c tingkat 1'),
('c2', 'c', 2, 'rak c tingkat 2');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `id_petugas` int(11) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `nama` varchar(11) DEFAULT NULL,
  `alamat` text,
  `no_telp` text,
  `level` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`id_petugas`, `username`, `password`, `nama`, `alamat`, `no_telp`, `level`) VALUES
(1, 'bayhaqi', '1', 'bayhaqi', 'Jl. Karya karya kasih', '083199332211', 1),
(3, 'usokun', '123123', 'Ali Hidayat', 'Jl. Pertahanan', '083122112211', 1),
(4, 'nopal', '123', 'Nopal', 'Jl. Bumi', '081212343434', 2),
(5, 'bambang', '12345', 'bambang', 'Jl. Langit', '085242445533', 2);

-- --------------------------------------------------------

--
-- Stand-in structure for view `pinjam`
-- (See below for the actual view)
--
CREATE TABLE `pinjam` (
`id_transaksi` int(11)
,`isbn` varchar(32)
,`judul` varchar(150)
,`nis` int(11)
,`siswa` varchar(100)
,`tingkat` varchar(11)
,`jurusan` text
,`kelas` int(11)
,`id_petugas` int(11)
,`petugas` varchar(11)
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
  `nis` varchar(50) NOT NULL,
  `id_petugas` varchar(35) NOT NULL,
  `ISBN` varchar(32) NOT NULL,
  `t_pinjam` date DEFAULT NULL,
  `t_deadline` date NOT NULL,
  `t_kembali` date DEFAULT NULL,
  `denda` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pinjam_book`
--

INSERT INTO `pinjam_book` (`id_transaksi`, `nis`, `id_petugas`, `ISBN`, `t_pinjam`, `t_deadline`, `t_kembali`, `denda`) VALUES
(1, '1', '1', '1', '2019-05-06', '0000-00-00', '0000-00-00', NULL);

--
-- Triggers `pinjam_book`
--
DELIMITER $$
CREATE TRIGGER `peminjaman` AFTER INSERT ON `pinjam_book` FOR EACH ROW BEGIN
if exists(select t_pinjam from pinjam_book where id_transaksi = new.id_transaksi and t_pinjam is not null) then
UPDATE book
SET jmlh = jmlh - 1
WHERE
isbn = NEW.isbn;
end if;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `pengembalian_kas` AFTER UPDATE ON `pinjam_book` FOR EACH ROW BEGIN
if exists (select t_kembali from pinjam_book where id_transaksi = new.id_transaksi and t_kembali is not null) then
UPDATE book
SET jmlh = jumlh + 1
WHERE
isbn = NEW.isbn;
end if;
if exists (select t_kembali from pinjam_book where id_transaksi = new.id_transaksi and t_kembali is not null and not denda = 0) then
insert into cashflow(id_petugas, tipe, tanggal, nominal, keterangan) 
value(new.id_petugas, 'pemasukan', curdate(), new.denda, 'Denda peminjaman buku');
end if;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `presensi`
--

CREATE TABLE `presensi` (
  `no_presensi` int(11) NOT NULL,
  `nis` int(255) NOT NULL,
  `tanggal` date NOT NULL,
  `kegiatan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `presensi`
--

INSERT INTO `presensi` (`no_presensi`, `nis`, `tanggal`, `kegiatan`) VALUES
(1, 6617, '2019-07-02', 'Meminjam Buku'),
(2, 6617, '2019-07-02', 'meminjam buku'),
(3, 9317, '2019-07-02', 'Membaca buku di perpus');

-- --------------------------------------------------------

--
-- Stand-in structure for view `presensi_view`
-- (See below for the actual view)
--
CREATE TABLE `presensi_view` (
`no_presensi` int(11)
,`nis` int(255)
,`nama` varchar(100)
,`tingkat` varchar(11)
,`jurusan` text
,`kelas` int(11)
,`tanggal` date
,`kegiatan` text
);

-- --------------------------------------------------------

--
-- Table structure for table `siswa`
--

CREATE TABLE `siswa` (
  `nis` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `id_kelas` varchar(11) NOT NULL,
  `alamat` text,
  `no_telp` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `siswa`
--

INSERT INTO `siswa` (`nis`, `nama`, `id_kelas`, `alamat`, `no_telp`) VALUES
(6617, 'ANDREAN IRGI AFFANDY', '11.dpib.1', 'Jl. Krakatau no.102', '085372839918'),
(7017, 'DIMAS PRAYOGA', '11.dpib.1', 'Jl. Seksama no.3', '08520022933'),
(7117, 'ANJELO PUTRI SILALAHI', '11.dpib.2', 'Jl. Seksama no.99', '08528726222'),
(7417, 'GUSTI FRANS COKKY', '11.dpib.2', 'Jl. Medan Baru no.17', '085722833122'),
(7717, 'M.RIZVAN', '11.dpib.3', 'Jl. Besar Tembung no.87', '085299237362'),
(7917, 'NADILA TIFANI', '11.dpib.3', 'Jl. Besar Tembung no.7', '08128829221'),
(9317, 'AHMAD SAYYID FADHIL', '11.dpib.1', 'Jl. Karya Jaya no.102', '081233119232'),
(9417, 'AZIZAH SIREGAR', '11.dpib.1', 'Jl. Karya Kasih no.2', '081238723232'),
(9517, 'DAME RONA LUBIS', '11.dpib.2', 'Jl. A.H Nasution', '081288331275'),
(9617, 'DEVITA HALISA FITRI', '11.dpib.2', 'Jl. A.H Nasution no.11', '08221133121'),
(9717, 'DIAH AYU PRATIWI', '11.dpib.3', 'Jl. Jaya Wijaya no.112', '08212229332'),
(9817, 'DWI REKSA PRIAMITRA', '11.dpib.3', 'Jl. Pattimura no.1', '082100912211'),
(22017, 'ADI SAPUTRA', '11.titl.1', 'Jl. Raflesia no.4', '0831338221'),
(22117, 'AHMAD ZEIN B.MANALU', '11.titl.1', 'Jl. Sakura no.29', '08220928211'),
(22317, 'BAGUS ARIA', '11.titl.2', 'Jl. Kejora no.111', '08129922012'),
(23317, 'JULIANDI', '11.titl.2', 'Jl. Patumbak no.11', '085233821128'),
(24617, 'JULIANDI', '11.titl.3', 'Jl. Brigib no.113', '081348581233'),
(25017, 'YOPI ARDIANSYAH', '11.titl.3', 'Jl. Angkasa Pura no.11', '081203391122'),
(48717, 'ADITIA SYAHPUTRA', '11.tkro.1', 'Jl. Seksama no.12', '081273556722'),
(48817, 'AHADI ANUAR', '11.tkro.1', 'Jl. Seksama no.1', '081300292331'),
(48917, 'ALDO RIZKY YULDI', '11.tkro.2', 'Jl. Bersama I no.11', '08526663373'),
(49017, 'ALFAUZAN', '11.tkro.2', 'Jl. Bersama I no.12', '081299383731'),
(49117, 'ARISANDI PRATAMA', '11.tkro.3', 'Jl.Seksama Ujung no.8', '081311827721'),
(49217, 'DEDI YUSUF', '11.tkro.3', 'Jl. Lantasan Lama no.13', '08319928333'),
(52217, 'ABDULLAH MARYUGUNA NASUTION', '11.tbsm.1', 'Jl. Timbang Deli no.11', '085261721122'),
(52317, 'AHMAD ANGGA PRASETIA HSB', '11.tbsm.1', 'Jl. Deli Tua no.4', '085288123311'),
(52417, 'AHMAD RIPAI LUBIS', '11.tbsm.2', 'Jl. Deli Tua no.108', '085277112822'),
(52517, 'ALFIANSYAH NAJID', '11.tbsm.2', 'Jl. Patumbak no.1', '081200918221'),
(52617, 'ANORE PRATAMA', '11.tbsm.3', 'Jl. Sekata no.11', '081300876767'),
(52717, 'ARIS SAHPUTRA NASUTION', '11.tbsm.3', 'Jl. Abadi no.12', '081200824232'),
(58717, 'ANNISA WULAN DARI', '11.tav.1', 'Jl. Petisah no.9', '085273140221'),
(58817, 'AYU RISKA', '11.tav.1', 'Jl. Petisah no.102', '08572283312'),
(58917, 'CHINTIA CAHYANI', '11.tav.2', 'Jl. Petisah Ujung no.2', '085200273383'),
(59017, 'DESRI NURSAKINAH SAFITRI HARAHAP', '11.tav.2', 'Jl. Petisah Ujung no.2', '08537221822'),
(59117, 'EMILIA VITALOKA', '11.tav.3', 'Jl. Karya Bakti no.1', '08310022933'),
(59217, 'FERRY IRAWAN', '11.tav.3', 'Jl. Karya Bakti no.99', '08221029211'),
(72217, 'ADELLA SILVIA', '11.tkj.1', 'Jl. Kliwon no.11', '08319924412'),
(72317, 'AFRIANDISYAH DAMANIK', '11.tkj.1', 'Jl. Eka Surya no.4', '081233942321'),
(72417, 'AHMAD NAZRY', '11.tkj.2', 'Jl. Eka Surya no.110', '081399228122'),
(72517, 'ALI MARWANSYAH PANJAITAN', '11.tkj.2', 'Jl. Eka Tani no.1', '081388222155'),
(72617, 'ANDIKA', '11.tkj.3', 'Jl. Sumber no.3', '08129922822'),
(72717, 'ANNISA PUTRI AYU DIA', '11.tkj.3', 'Jl. Sulawesi no.2', '08121122322');

--
-- Triggers `siswa`
--
DELIMITER $$
CREATE TRIGGER `siswa_delete` BEFORE DELETE ON `siswa` FOR EACH ROW begin
insert into log_siswa select * from siswa where nis = old.nis;
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `siswa_all`
-- (See below for the actual view)
--
CREATE TABLE `siswa_all` (
`nis` int(11)
,`nama` varchar(100)
,`id_kelas` varchar(11)
,`alamat` text
,`no_telp` text
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `siswa_view`
-- (See below for the actual view)
--
CREATE TABLE `siswa_view` (
`nis` int(11)
,`nama` varchar(100)
,`tingkat` varchar(11)
,`jurusan` text
,`kelas` int(11)
,`alamat` text
,`no_telp` text
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `siswa_view_all`
-- (See below for the actual view)
--
CREATE TABLE `siswa_view_all` (
`nis` int(11)
,`nama` varchar(100)
,`tingkat` varchar(11)
,`jurusan` text
,`kelas` int(11)
,`alamat` text
,`no_telp` text
);

-- --------------------------------------------------------

--
-- Structure for view `buku`
--
DROP TABLE IF EXISTS `buku`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `buku`  AS  select `a`.`ISBN` AS `isbn`,`b`.`lokasi` AS `lokasi`,`a`.`Penerbit` AS `penerbit`,`a`.`Pengarang` AS `pengarang`,`a`.`thn_buku` AS `thn_buku`,`a`.`jmlh` AS `jmlh`,`a`.`tgl_pengadaan` AS `tgl_pengadaan`,`a`.`Judul` AS `judul`,`a`.`jenis_buku` AS `jenis_buku`,`a`.`kategori` AS `kategori` from (`book` `a` join `lok_book` `b` on((`a`.`id_rak` = `b`.`id_rak`))) ;

-- --------------------------------------------------------

--
-- Structure for view `kembali`
--
DROP TABLE IF EXISTS `kembali`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `kembali`  AS  select `d`.`id_transaksi` AS `id_transaksi`,`c`.`ISBN` AS `isbn`,`c`.`Judul` AS `judul`,`a`.`nis` AS `nis`,`a`.`nama` AS `nama`,`d`.`t_pinjam` AS `t_pinjam`,`d`.`t_kembali` AS `t_kembali`,`d`.`t_deadline` AS `t_deadline` from ((`pinjam_book` `d` join `siswa_all` `a` on((`a`.`nis` = `d`.`nis`))) join `book` `c` on((`c`.`ISBN` = `d`.`ISBN`))) ;

-- --------------------------------------------------------

--
-- Structure for view `pinjam`
--
DROP TABLE IF EXISTS `pinjam`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `pinjam`  AS  select `d`.`id_transaksi` AS `id_transaksi`,`c`.`ISBN` AS `isbn`,`c`.`Judul` AS `judul`,`a`.`nis` AS `nis`,`a`.`nama` AS `siswa`,`a`.`tingkat` AS `tingkat`,`a`.`jurusan` AS `jurusan`,`a`.`kelas` AS `kelas`,`b`.`id_petugas` AS `id_petugas`,`b`.`nama` AS `petugas`,`d`.`t_pinjam` AS `t_pinjam`,`d`.`t_kembali` AS `t_kembali`,`d`.`denda` AS `denda` from (((`pinjam_book` `d` join `siswa_view_all` `a` on((`a`.`nis` = `d`.`nis`))) join `petugas` `b` on((`b`.`id_petugas` = `d`.`id_petugas`))) join `book` `c` on((`c`.`ISBN` = `d`.`ISBN`))) ;

-- --------------------------------------------------------

--
-- Structure for view `presensi_view`
--
DROP TABLE IF EXISTS `presensi_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `presensi_view`  AS  select `a`.`no_presensi` AS `no_presensi`,`a`.`nis` AS `nis`,`b`.`nama` AS `nama`,`c`.`tingkat` AS `tingkat`,`c`.`jurusan` AS `jurusan`,`c`.`kelas` AS `kelas`,`a`.`tanggal` AS `tanggal`,`a`.`kegiatan` AS `kegiatan` from ((`presensi` `a` join `siswa` `b` on((`a`.`nis` = `b`.`nis`))) join `kelas` `c` on((`b`.`id_kelas` = `c`.`id_kelas`))) ;

-- --------------------------------------------------------

--
-- Structure for view `siswa_all`
--
DROP TABLE IF EXISTS `siswa_all`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `siswa_all`  AS  select `siswa`.`nis` AS `nis`,`siswa`.`nama` AS `nama`,`siswa`.`id_kelas` AS `id_kelas`,`siswa`.`alamat` AS `alamat`,`siswa`.`no_telp` AS `no_telp` from `siswa` union select `log_siswa`.`nis` AS `nis`,`log_siswa`.`nama` AS `nama`,`log_siswa`.`id_kelas` AS `id_kelas`,`log_siswa`.`alamat` AS `alamat`,`log_siswa`.`no_telp` AS `no_telp` from `log_siswa` ;

-- --------------------------------------------------------

--
-- Structure for view `siswa_view`
--
DROP TABLE IF EXISTS `siswa_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `siswa_view`  AS  select `a`.`nis` AS `nis`,`a`.`nama` AS `nama`,`b`.`tingkat` AS `tingkat`,`b`.`jurusan` AS `jurusan`,`b`.`kelas` AS `kelas`,`a`.`alamat` AS `alamat`,`a`.`no_telp` AS `no_telp` from (`siswa` `a` join `kelas` `b` on((`a`.`id_kelas` = `b`.`id_kelas`))) ;

-- --------------------------------------------------------

--
-- Structure for view `siswa_view_all`
--
DROP TABLE IF EXISTS `siswa_view_all`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `siswa_view_all`  AS  select `a`.`nis` AS `nis`,`a`.`nama` AS `nama`,`b`.`tingkat` AS `tingkat`,`b`.`jurusan` AS `jurusan`,`b`.`kelas` AS `kelas`,`a`.`alamat` AS `alamat`,`a`.`no_telp` AS `no_telp` from (`siswa_all` `a` join `kelas` `b` on((`a`.`id_kelas` = `b`.`id_kelas`))) ;

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
-- Indexes for table `cashflow`
--
ALTER TABLE `cashflow`
  ADD PRIMARY KEY (`no_cashflow`),
  ADD UNIQUE KEY `no_cashflow` (`no_cashflow`);

--
-- Indexes for table `kelas`
--
ALTER TABLE `kelas`
  ADD PRIMARY KEY (`id_kelas`),
  ADD UNIQUE KEY `id_kelas` (`id_kelas`);

--
-- Indexes for table `log_siswa`
--
ALTER TABLE `log_siswa`
  ADD PRIMARY KEY (`nis`),
  ADD UNIQUE KEY `nis` (`nis`),
  ADD KEY `id_kelas` (`id_kelas`);

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
-- Indexes for table `pinjam_book`
--
ALTER TABLE `pinjam_book`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD UNIQUE KEY `id_transaksi` (`id_transaksi`),
  ADD KEY `ISBN` (`ISBN`);

--
-- Indexes for table `presensi`
--
ALTER TABLE `presensi`
  ADD PRIMARY KEY (`no_presensi`),
  ADD UNIQUE KEY `no_presensi` (`no_presensi`);

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
-- AUTO_INCREMENT for table `cashflow`
--
ALTER TABLE `cashflow`
  MODIFY `no_cashflow` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `presensi`
--
ALTER TABLE `presensi`
  MODIFY `no_presensi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `siswa`
--
ALTER TABLE `siswa`
  MODIFY `nis` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72718;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
