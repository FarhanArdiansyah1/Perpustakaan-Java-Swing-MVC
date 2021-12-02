/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 10.4.19-MariaDB : Database - perpus
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`perpus` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `perpus`;

/*Table structure for table `anggota` */

DROP TABLE IF EXISTS `anggota`;

CREATE TABLE `anggota` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) DEFAULT NULL,
  `pekerjaan` varchar(255) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `no_telp` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

/*Data for the table `anggota` */

insert  into `anggota`(`id`,`nama`,`pekerjaan`,`alamat`,`no_telp`) values 
(1,'Dimas','Pelajar','Jalan Cibaduyut','089485291209'),
(2,'Agung','Pelajar','Jalan Klingingan','085212347283'),
(3,'Dian','Pelajar','Jalan Klingingan','088174773212'),
(4,'Hafizh','Pelajar','Jalan Klingingan','088514283212'),
(5,'Fadhlan','Pelajar','Jalan Klingingan','089527164723'),
(6,'Arif','Pelajar','Jalan Klingingan','098165728365'),
(7,'Daffa','Pelajar','Jalan Klingingan','085247172451'),
(8,'Rifki','Pelajar','Jalan Klingingan','088421341252'),
(9,'Asep','Pelajar','Jalan Klingingan','088512432151'),
(10,'Rafi','Pelajar','Jalan Klingingan','085123125153'),
(11,'Farhan Ardiansyah','pelajar','Jalan Caringin','0812393847281');

/*Table structure for table `buku` */

DROP TABLE IF EXISTS `buku`;

CREATE TABLE `buku` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `judul_buku` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;

/*Data for the table `buku` */

insert  into `buku`(`id`,`judul_buku`) values 
(1,'Kelas 10 SMK Sistem Operasi'),
(2,'Kelas 10 SMK Prakarya dan Kewirausahaan'),
(3,'Kelas 10 SMK Harmoni'),
(4,'Kelas 10 SMK Perakitan Komputer'),
(5,'Kelas 10 SMK Pendidikan Agama Islam'),
(6,'Kelas 10 SMK Bahasa Inggris'),
(7,'Kelas 10 SMK Bahasa Indonesia'),
(8,'Tiwo Likes to Wake Up Early, Tiwo Likes Vegetables'),
(9,'I am a Ninja'),
(10,'Tiwo\'s Piggy Bank'),
(11,'Insomnia'),
(12,'Tita dan Ksatria Busa Sabun'),
(13,'Lihat! Lihat!'),
(14,'Scandalius Siblings'),
(15,'180 Recipes of Indonesian Menus'),
(16,'My First Lie'),
(17,'My Bad Bad Day'),
(18,'Hurry Quickly Me'),
(19,'Kanuku Leon'),
(20,'Hau Kamelin dan Tuan Kamiasi'),
(21,'The Notebook'),
(22,'My First Bestfriend');

/*Table structure for table `peminjaman` */

DROP TABLE IF EXISTS `peminjaman`;

CREATE TABLE `peminjaman` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tanggal_pinjam` date NOT NULL,
  `tanggal_kembali` date NOT NULL,
  `id_buku` int(11) NOT NULL,
  `id_anggota` int(11) NOT NULL,
  `id_petugas` int(11) NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_petugas` (`id_petugas`),
  KEY `id_buku` (`id_buku`),
  KEY `id_anggota` (`id_anggota`),
  CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id`),
  CONSTRAINT `peminjaman_ibfk_2` FOREIGN KEY (`id_buku`) REFERENCES `buku` (`id`),
  CONSTRAINT `peminjaman_ibfk_3` FOREIGN KEY (`id_anggota`) REFERENCES `anggota` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

/*Data for the table `peminjaman` */

insert  into `peminjaman`(`id`,`tanggal_pinjam`,`tanggal_kembali`,`id_buku`,`id_anggota`,`id_petugas`,`status`) values 
(1,'2021-07-01','2021-07-08',1,4,1,'Sudah Dikembalikan'),
(2,'2021-07-01','2021-07-08',1,1,1,'Sudah Dikembalikan'),
(3,'2021-07-02','2021-07-09',2,2,2,'Sudah Dikembalikan'),
(4,'2021-07-02','2021-07-09',3,3,2,NULL),
(5,'2021-07-03','2021-07-10',17,7,3,NULL),
(6,'2021-07-03','2021-07-10',3,6,3,NULL),
(7,'2021-07-03','2021-07-10',13,8,3,NULL),
(8,'2021-07-03','2021-07-10',14,9,3,NULL),
(16,'2021-12-01','2021-12-30',1,11,3,'Sudah Dikembalikan'),
(17,'2021-12-01','2021-12-07',4,7,1,'Sudah Dikembalikan');

/*Table structure for table `pengembalian` */

DROP TABLE IF EXISTS `pengembalian`;

CREATE TABLE `pengembalian` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tanggal_pengembalian` date NOT NULL,
  `denda` int(11) DEFAULT NULL,
  `id_peminjaman` int(11) NOT NULL,
  `id_petugas` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_peminjaman` (`id_peminjaman`),
  KEY `id_petugas` (`id_petugas`),
  CONSTRAINT `pengembalian_ibfk_1` FOREIGN KEY (`id_peminjaman`) REFERENCES `peminjaman` (`id`),
  CONSTRAINT `pengembalian_ibfk_2` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

/*Data for the table `pengembalian` */

insert  into `pengembalian`(`id`,`tanggal_pengembalian`,`denda`,`id_peminjaman`,`id_petugas`) values 
(1,'2021-07-05',NULL,1,3),
(2,'2021-07-07',NULL,2,3),
(3,'2021-07-09',NULL,3,3),
(14,'2021-12-03',NULL,16,2),
(15,'2021-12-02',NULL,17,2);

/*Table structure for table `petugas` */

DROP TABLE IF EXISTS `petugas`;

CREATE TABLE `petugas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama_petugas` varchar(50) NOT NULL,
  `telp_petugas` varchar(13) DEFAULT NULL,
  `alamat_petugas` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

/*Data for the table `petugas` */

insert  into `petugas`(`id`,`nama_petugas`,`telp_petugas`,`alamat_petugas`) values 
(1,'Asep','085211318483','JL. Caringin'),
(2,'Suparman','088321340934','JL. Leuwi Panjang'),
(3,'Santi','089309423435','JL. Holis'),
(4,'Andini','085678795523','JL. Buahbatu'),
(5,'Pedro','089423241198','JL. Klontongan'),
(6,'Andri','089568790342','JL. Kliningan'),
(7,'Rifal','085567432234','JL. Holis'),
(8,'Fajar','088432138576','JL. BKR'),
(9,'Rifki','089578451209','JL. Kopo'),
(10,'Rizal','089490942233','JL. BKR');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
