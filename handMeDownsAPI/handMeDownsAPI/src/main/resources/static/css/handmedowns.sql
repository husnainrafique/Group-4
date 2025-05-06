-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 06, 2025 at 01:37 PM
-- Server version: 8.0.39
-- PHP Version: 8.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `handmedowns`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `adminid` int NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `role` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `updated_at` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `bookid` int NOT NULL,
  `isbn` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `book_image_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `book_name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `price` double DEFAULT NULL,
  `publisher` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `summary` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `providers_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`bookid`, `isbn`, `book_image_url`, `book_name`, `price`, `publisher`, `summary`, `providers_id`) VALUES
(1, '22292832010123', 'https://tinyurl.com/y6uh2puu', 'Introduction To Algorithms', 125.33, 'Cengage Learning', 'The introduction into algorithm analysis and design...', 1),
(5, 'ewer', '', 'her', 3, 'qwer', 'qwer', 2),
(8, '2344883726', 'https://tinyurl.com/ymv2pe9u', 'Biology', 132, 'Lightspeed Learning', 'Learn about the biology of the 10 most popular species.', 8);

-- --------------------------------------------------------

--
-- Table structure for table `book_requests`
--

CREATE TABLE `book_requests` (
  `id` bigint NOT NULL,
  `book_title` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `category` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `isbn` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `requested_at` datetime(6) DEFAULT NULL,
  `type` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `providers`
--

CREATE TABLE `providers` (
  `storeid` int NOT NULL,
  `books_viewed` int DEFAULT NULL,
  `city` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `contact_first_name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `contact_last_name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `image_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `reviews_left` int DEFAULT NULL,
  `state` varchar(2) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `store_name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `total_visits` int DEFAULT NULL,
  `updated_at` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `providers`
--

INSERT INTO `providers` (`storeid`, `books_viewed`, `city`, `contact_first_name`, `contact_last_name`, `created_at`, `email`, `image_url`, `password`, `reviews_left`, `state`, `store_name`, `total_visits`, `updated_at`) VALUES
(1, 1, 'Greensboro', 'Tony', 'Lee', '2025-05-06 05:26:15.056000', 'tony@gmail.com', 'https://tinyurl.com/2tnszhz9', 'password123', 0, 'CA', 'GreensboroCentral', 18, '2025-05-06 05:28:13.119000'),
(2, 1, 'Los Angeles', 'Gabby', 'Jimenez', '2025-05-06 05:27:18.489000', 'gabby@hotmail.com', 'https://tinyurl.com/2p8xa5zz', 'password123', 0, 'CA', 'HelloBookWorms', 6, '2025-05-06 06:08:11.855000'),
(5, 0, 'Fayetteville', 'Chip', 'Skylark', '2025-05-06 07:39:39.553000', 'chip@gmail.com', 'https://tinyurl.com/58tta3ta', 'password123', 0, 'NC', 'ShinyBooksAndMe', 1, '2025-05-06 07:39:39.553000'),
(6, 0, 'Irvine', 'Don\'t', 'Worry', '2025-05-06 07:41:13.667000', 'books@hotmail.com', 'https://tinyurl.com/474r3fp7', 'password123', 0, 'CA', 'TestTakers', 2, '2025-05-06 07:50:17.641000'),
(7, 0, 'Alderaan', 'Jango', 'Fett', '2025-05-06 09:09:03.744000', 'jango@starship.com', 'https://tinyurl.com/4za8696j', 'password123', 0, 'MW', 'The Cantina', 2, '2025-05-06 09:09:03.744000'),
(8, 0, 'Tattooine', 'Leia', 'Skywalker', '2025-05-06 09:11:02.123000', 'force@mail.com', 'https://tinyurl.com/bde4svfm', 'password123', 0, 'AL', 'Skywalk', 1, '2025-05-06 09:11:02.123000');

-- --------------------------------------------------------

--
-- Table structure for table `provider_reviews`
--

CREATE TABLE `provider_reviews` (
  `reviewid` int NOT NULL,
  `authorid` int NOT NULL,
  `content` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `rating` int NOT NULL,
  `reply` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `status` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `providers_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `provider_reviews`
--

INSERT INTO `provider_reviews` (`reviewid`, `authorid`, `content`, `created_at`, `rating`, `reply`, `status`, `updated_at`, `providers_id`) VALUES
(2, 56, 'My \"Like New\" book was covered in mold.', '2025-05-06 07:42:47.000000', 1, NULL, 'Pending', '2025-05-06 07:42:47.000000', 2),
(3, 56, 'This was an awesome place!', '2025-05-06 07:51:09.000000', 5, NULL, 'Approved', '2025-05-06 07:51:09.000000', 6),
(4, 45, 'This place smelled like garbage and the host was ugly.', '2025-05-06 08:57:19.000000', 1, NULL, 'pending', '2025-05-06 08:57:19.000000', 5),
(5, 45, 'These guys ripped me off and they stole all my snacks too.', '2025-05-06 08:58:00.000000', 2, NULL, 'pending', '2025-05-06 08:58:00.000000', 1),
(6, 2323, 'There\'s like one book and it\'s ancient. You suck.', '2025-05-06 09:16:23.000000', 1, NULL, 'pending', '2025-05-06 09:16:23.000000', 7),
(7, 66, 'By far the cleanest bookstore in the 9 galaxies!', '2025-05-06 09:16:23.000000', 5, 'Thank you! We try to do our best.', 'pending', '2025-05-06 09:16:23.000000', 8);

-- --------------------------------------------------------

--
-- Table structure for table `provider_visit_stats`
--

CREATE TABLE `provider_visit_stats` (
  `id` int NOT NULL,
  `storeid` int NOT NULL,
  `visit_count` int NOT NULL,
  `visit_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `provider_visit_stats`
--

INSERT INTO `provider_visit_stats` (`id`, `storeid`, `visit_count`, `visit_date`) VALUES
(1, 1, 18, '2025-05-06'),
(2, 2, 6, '2025-05-06'),
(3, 5, 1, '2025-05-06'),
(4, 6, 2, '2025-05-06'),
(5, 8, 1, '2025-05-06'),
(6, 7, 2, '2025-05-06');

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

CREATE TABLE `reports` (
  `reportid` int NOT NULL,
  `author` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `content_details` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `reason` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `status` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `sysadmin_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `stat_logs`
--

CREATE TABLE `stat_logs` (
  `id` int NOT NULL,
  `admin_delete_timestamp` datetime(6) DEFAULT NULL,
  `logged_in_timestamp` datetime(6) DEFAULT NULL,
  `logged_out_timestamp` datetime(6) DEFAULT NULL,
  `total_time_logged_in` bigint DEFAULT NULL,
  `report_id` int DEFAULT NULL,
  `sysadmin_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `id` bigint NOT NULL,
  `amount` double DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `buyer_id` bigint DEFAULT NULL,
  `seller_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user_books`
--

CREATE TABLE `user_books` (
  `id` bigint NOT NULL,
  `author` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `isbn` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `bookid` int NOT NULL,
  `category` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `image_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `providers_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user_reviews`
--

CREATE TABLE `user_reviews` (
  `id` bigint NOT NULL,
  `content` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `rating` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`adminid`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`bookid`),
  ADD KEY `FK9k3wcok55xruepow3xwkk8b9b` (`providers_id`);

--
-- Indexes for table `book_requests`
--
ALTER TABLE `book_requests`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `providers`
--
ALTER TABLE `providers`
  ADD PRIMARY KEY (`storeid`),
  ADD UNIQUE KEY `UK7ant8u8y5lel5bd0d6hdexmde` (`email`);

--
-- Indexes for table `provider_reviews`
--
ALTER TABLE `provider_reviews`
  ADD PRIMARY KEY (`reviewid`),
  ADD KEY `FK81ul2c2pyw8qck0sb9b7110uu` (`providers_id`);

--
-- Indexes for table `provider_visit_stats`
--
ALTER TABLE `provider_visit_stats`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reports`
--
ALTER TABLE `reports`
  ADD PRIMARY KEY (`reportid`),
  ADD KEY `FKsspc8msxa0akiws0p5agfdku6` (`sysadmin_id`);

--
-- Indexes for table `stat_logs`
--
ALTER TABLE `stat_logs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKg2xvqtiel6f4xwd2507hbnkxy` (`report_id`),
  ADD KEY `FKa8uleepbxc8emv3gkc36iln56` (`sysadmin_id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKosd6qqlkyqp8gk4gjisggqev0` (`buyer_id`),
  ADD KEY `FKs37irexq9hyvl7pqyqya2i0dn` (`seller_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_books`
--
ALTER TABLE `user_books`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKspd3q58qsvbvvcuxivr5ays1j` (`providers_id`);

--
-- Indexes for table `user_reviews`
--
ALTER TABLE `user_reviews`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmpa6y70qlh5ktrbf4kgxtlqxt` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `adminid` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `bookid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `book_requests`
--
ALTER TABLE `book_requests`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `providers`
--
ALTER TABLE `providers`
  MODIFY `storeid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `provider_reviews`
--
ALTER TABLE `provider_reviews`
  MODIFY `reviewid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `provider_visit_stats`
--
ALTER TABLE `provider_visit_stats`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `reports`
--
ALTER TABLE `reports`
  MODIFY `reportid` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `stat_logs`
--
ALTER TABLE `stat_logs`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user_books`
--
ALTER TABLE `user_books`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user_reviews`
--
ALTER TABLE `user_reviews`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `books`
--
ALTER TABLE `books`
  ADD CONSTRAINT `FK9k3wcok55xruepow3xwkk8b9b` FOREIGN KEY (`providers_id`) REFERENCES `providers` (`storeid`);

--
-- Constraints for table `provider_reviews`
--
ALTER TABLE `provider_reviews`
  ADD CONSTRAINT `FK81ul2c2pyw8qck0sb9b7110uu` FOREIGN KEY (`providers_id`) REFERENCES `providers` (`storeid`);

--
-- Constraints for table `reports`
--
ALTER TABLE `reports`
  ADD CONSTRAINT `FKsspc8msxa0akiws0p5agfdku6` FOREIGN KEY (`sysadmin_id`) REFERENCES `admins` (`adminid`);

--
-- Constraints for table `stat_logs`
--
ALTER TABLE `stat_logs`
  ADD CONSTRAINT `FKa8uleepbxc8emv3gkc36iln56` FOREIGN KEY (`sysadmin_id`) REFERENCES `admins` (`adminid`),
  ADD CONSTRAINT `FKg2xvqtiel6f4xwd2507hbnkxy` FOREIGN KEY (`report_id`) REFERENCES `reports` (`reportid`);

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `FKosd6qqlkyqp8gk4gjisggqev0` FOREIGN KEY (`buyer_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKs37irexq9hyvl7pqyqya2i0dn` FOREIGN KEY (`seller_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `user_books`
--
ALTER TABLE `user_books`
  ADD CONSTRAINT `FKspd3q58qsvbvvcuxivr5ays1j` FOREIGN KEY (`providers_id`) REFERENCES `providers` (`storeid`);

--
-- Constraints for table `user_reviews`
--
ALTER TABLE `user_reviews`
  ADD CONSTRAINT `FKmpa6y70qlh5ktrbf4kgxtlqxt` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
