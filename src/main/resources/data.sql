-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.11.13-MariaDB-0ubuntu0.24.04.1 - Ubuntu 24.04
-- Server OS:                    debian-linux-gnu
-- HeidiSQL Version:             12.14.1.1
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping data for table marcel_mini_wallet.bank: ~37 rows (approximately)
INSERT IGNORE INTO `bank` (`bank_id`, `bank_name`, `bank_code`) VALUES
	('bnk-00b459x6-5z4y-7y5b-2a5x-4v1z6y7c8x44', 'PT. BANK SYARIAH BRI - (BRI SYARIAH)', '422'),
	('bnk-00h459d6-5f4e-7e5h-2g5d-4b1f6e7i8d44', 'PT. BANK BCA SYARIAH', '536'),
	('bnk-00l459h6-5j4i-7i5l-2k5h-4f1j6i7m8h44', 'PT. BANK CAPITAL INDONESIA', '054'),
	('bnk-00r459n6-5p4o-7o5r-2q5n-4l1p6o7s8n44', 'PT. BANK MAYORA', '553'),
	('bnk-11c560y7-6a5z-8z6c-3b6y-5w2a7z8d9y55', 'PT. BANK SYARIAH BUKOPIN', '521'),
	('bnk-11i560e7-6g5f-8f6i-3h6e-5c2g7f8j9e55', 'PT. BANK BUKOPIN', '441'),
	('bnk-11m560i7-6k5j-8j6m-3l6i-5g2k7j8n9i55', 'PT. BANK DKI UNIT USAHA SYARIAH', '724'),
	('bnk-11s560o7-6q5p-8p6s-3r6o-5m2q7p8t9o55', 'PT. BANK MEGA, TBK', '426'),
	('bnk-22d671z8-7b6a-9a7d-4c7z-6x3b8a9e0z66', 'PT. BANK SYARIAH MANDIRI', '451'),
	('bnk-22j671f8-7h6g-9g7j-4i7f-6d3h8g9k0f66', 'PT. BANK CENTRAL ASIA, TBK - (BCA)', '014'),
	('bnk-22n671j8-7l6k-9k7n-4m7j-6h3l8k9o0j66', 'PT. BANK ICBC INDONESIA', '164'),
	('bnk-22t671p8-7r6q-9q7t-4s7p-6n3r8q9u0p66', 'PT. BANK MUAMALAT INDONESIA, TBK', '147'),
	('bnk-33e782a9-8c7b-0b8e-5d8a-7y4c9b0f1a77', 'PT. BANK TABUNGAN NEGARA (PERSERO), TBK (BTN)', '200'),
	('bnk-33k782g9-8i7h-0h8k-5j8g-7e4i9h0l1g77', 'PT. BANK DANAMON INDONESIA', '011'),
	('bnk-33o782k9-8m7l-0l8o-5n8k-7i4m9l0p1k77', 'PT. BANK JTRUST INDONESIA, TBK', '095'),
	('bnk-33u782q9-8s7r-0r8u-5t8q-7o4s9r0v1q77', 'PT. BANK NEGARA INDONESIA (PERSERO), TBK (BNI)', '009'),
	('bnk-44f893b0-9d8c-1c9f-6e9b-8z5d0c1g2b88', 'PT. BANK TABUNGAN NEGARA (PERSERO), TBK UNIT USAHA SYARIAH', '723'),
	('bnk-44l893h0-9j8i-1i9l-6k9h-8f5j0i1m2h88', 'PT. BANK DKI', '111'),
	('bnk-44v893r0-9t8s-1s9v-6u9r-8p5t0s1w2r88', 'PT. BANK OCBC NISP, TBK', '028'),
	('bnk-55g904c1-0e9d-2d0g-7f0c-9a6e1d2h3c99', 'PT. BANK TABUNGAN PENSIUNAN NASIONAL - (BTPN)', '213'),
	('bnk-55m904i1-0k9j-2j0m-7l0i-9g6k1j2n3i99', 'PT. BANK DBS INDONESIA', '046'),
	('bnk-55w904s1-0u9t-2t0w-7v0s-9q6u1t2x3s99', 'PT. BANK OCBC NISP, TBK UNIT USAHA SYARIAH', '731'),
	('bnk-66h015d2-1f0e-3e1h-8g1d-0b7f2e3i4d00', 'PT. BANK TABUNGAN PENSIUNAN NASIONAL SYARIAH - (BTPN Syariah)', '547'),
	('bnk-66n015j2-1l0k-3k1n-8m1j-0h7l2k3o4j00', 'PT. BANK HSBC INDONESIA', '087'),
	('bnk-66x015t2-1v0u-3u1x-8w1t-0r7v2u3y4t00', 'PT. BANK PERMATA, TBK', '013'),
	('bnk-77e126a3-2c1b-4b2e-9d2a-1e8c3b4f5a11', 'PT. BANK CIMB NIAGA - (CIMB)', '022'),
	('bnk-77i126e3-2g1f-4f2i-9h2e-1c8g3f4j5e11', 'PT. BANK WOORI SAUDARA INDONESIA 1906, TBK (BWS)', '212'),
	('bnk-77o126k3-2m1l-4l2o-9n2k-1i8m3l4p5k11', 'PT. BANK MANDIRI (PERSERO), TBK', '008'),
	('bnk-77y126u3-2w1v-4v2y-9x2u-1s8w3v4z5u11', 'PT. BANK PERMATA, TBK UNIT USAHA SYARIAH', '721'),
	('bnk-88f237b4-3d2c-5c3f-0e3b-2f9d4c5g6b22', 'PT. BANK CIMB NIAGA UNIT USAHA SYARIAH - (CIMB SYARIAH)', '730'),
	('bnk-88j237f4-3h2g-5g3j-0i3f-2d9h4g5k6f22', 'PT. BANK JABAR BANTEN SYARIAH', '425'),
	('bnk-88p237l4-3n2m-5m3p-0o3l-2j9n4m5q6l22', 'PT. BANK MANDIRI TASPEN POS', '564'),
	('bnk-88z237v4-3x2w-5w3z-0y3v-2t9x4w5a6v22', 'PT. BANK RAKYAT INDONESIA (PERSERO), TBK (BRI)', '002'),
	('bnk-99a348w5-4y3x-6x4a-1z4w-3u0y5x6b7w33', 'PT. BANK RAKYAT INDONESIA AGRONIAGA, TBK', '494'),
	('bnk-99g348c5-4e3d-6d4g-1f4c-3a0e5d6h7c33', 'PT. BNI SYARIAH', '427'),
	('bnk-99k348g5-4i3h-6h4k-1j4g-3e0i5h6l7g33', 'PT. BANK PEMBANGUNAN DAERAH BANTEN', '137'),
	('bnk-99q348m5-4o3n-6n4q-1p4m-3k0o5n6r7m33', 'PT. BANK MAYBANK INDONESIA, TBK', '016');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
