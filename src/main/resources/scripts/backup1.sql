-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Apr 19, 2020 at 06:00 PM
-- Server version: 8.0.19
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jeweNaBobo`
--

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(12),
(12);

-- --------------------------------------------------------

--
-- Table structure for table `payed_debt`
--

CREATE TABLE `payed_debt` (
  `id` bigint NOT NULL,
  `amount` double NOT NULL,
  `payment_date` datetime DEFAULT NULL,
  `user_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `payed_debt`
--

INSERT INTO `payed_debt` (`id`, `amount`, `payment_date`, `user_id`) VALUES
(2, 5000, '2020-04-14 00:00:00', NULL),
(3, 5000, '2020-04-14 00:00:00', NULL),
(4, 10000, '2020-04-14 00:00:00', NULL),
(5, 2000, '2020-04-14 00:00:00', NULL),
(8, 5000, '2020-04-14 00:00:00', NULL),
(9, 5000, '2020-04-14 00:00:00', NULL),
(10, 10000, '2020-04-14 00:00:00', NULL),
(11, 2000, '2020-04-14 00:00:00', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `debt` double NOT NULL,
  `interest` double NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `payed_debts_amount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `debt`, `interest`, `name`, `password`, `payed_debts_amount`) VALUES
(1, 1980000, 0, 'Butoyi', '123', 22000),
(6, 120000, 0, 'Japhar', '123', 0),
(7, 120000, 0, 'test', '123', 22000);

-- --------------------------------------------------------

--
-- Table structure for table `user_payed_debt_history`
--

CREATE TABLE `user_payed_debt_history` (
  `user_id` bigint NOT NULL,
  `payed_debt_history_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `user_payed_debt_history`
--

INSERT INTO `user_payed_debt_history` (`user_id`, `payed_debt_history_id`) VALUES
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(7, 8),
(7, 9),
(7, 10),
(7, 11);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `payed_debt`
--
ALTER TABLE `payed_debt`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKn56j0r4yf0orpj8veoconhmeh` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_payed_debt_history`
--
ALTER TABLE `user_payed_debt_history`
  ADD UNIQUE KEY `UK_89opngp49ksqlvbmhd0w1og1b` (`payed_debt_history_id`),
  ADD KEY `FKl5sbe66uui8ukbk9xi7shkpkr` (`user_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `payed_debt`
--
ALTER TABLE `payed_debt`
  ADD CONSTRAINT `FKn56j0r4yf0orpj8veoconhmeh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `user_payed_debt_history`
--
ALTER TABLE `user_payed_debt_history`
  ADD CONSTRAINT `FKl5sbe66uui8ukbk9xi7shkpkr` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKpqfqibxvju89v0yqdw3p23uhp` FOREIGN KEY (`payed_debt_history_id`) REFERENCES `payed_debt` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
