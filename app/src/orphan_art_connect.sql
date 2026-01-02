-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 31, 2025 at 04:52 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `orphan_art_connect`
--

-- --------------------------------------------------------

--
-- Table structure for table `artworks`
--

CREATE TABLE `artworks` (
  `id` int(11) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `artworks`
--

INSERT INTO `artworks` (`id`, `title`, `price`, `status`, `description`, `category`, `image`, `created_at`) VALUES
(1, 'Thread Art', 2200.00, 'pending', NULL, 'Wall Art', NULL, '2025-12-15 17:37:32'),
(3, 'Updated Thread Painting', 2200.00, 'approved', NULL, 'Wall Art', 'thread_art.jpg', '2025-12-16 07:13:33'),
(4, 'Paper Craft', 900.00, 'pending', NULL, 'Handmade', 'paper.jpg', '2025-12-16 07:13:33');

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `id` int(11) NOT NULL,
  `event_name` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `event_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`id`, `event_name`, `location`, `event_date`) VALUES
(1, 'Orphan Art Expo', 'Hyderabad', '2025-03-01'),
(2, 'Orphan Art Expo', 'Hyderabad', '2025-03-01');

-- --------------------------------------------------------

--
-- Table structure for table `event_artworks`
--

CREATE TABLE `event_artworks` (
  `mapping_id` int(11) NOT NULL,
  `event_id` int(11) DEFAULT NULL,
  `artwork_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `event_artworks`
--

INSERT INTO `event_artworks` (`mapping_id`, `event_id`, `artwork_id`) VALUES
(1, 1, 1),
(2, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `event_visitors`
--

CREATE TABLE `event_visitors` (
  `visitor_id` int(11) NOT NULL,
  `event_id` int(11) DEFAULT NULL,
  `visitor_name` varchar(100) DEFAULT NULL,
  `visitor_email` varchar(100) DEFAULT NULL,
  `registration_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `event_visitors`
--

INSERT INTO `event_visitors` (`visitor_id`, `event_id`, `visitor_name`, `visitor_email`, `registration_date`) VALUES
(1, 1, 'John Doe', 'john@gmail.com', '2025-12-16 08:49:22'),
(2, 2, 'Alice Smith', 'alice@gmail.com', '2025-12-16 08:51:23');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `payment_status` varchar(50) DEFAULT NULL,
  `total_amount` decimal(10,2) DEFAULT NULL,
  `status` varchar(20) DEFAULT 'PENDING'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `user_id`, `amount`, `payment_status`, `total_amount`, `status`) VALUES
(1, 1, 1200, 'paid', NULL, 'DELIVERED'),
(2, 1, NULL, NULL, 500.00, 'PENDING'),
(3, 1, 500, NULL, NULL, 'PENDING'),
(4, 1, NULL, NULL, 500.00, 'PENDING');

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `id` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `payment_mode` varchar(50) DEFAULT NULL,
  `transaction_id` varchar(100) DEFAULT NULL,
  `payment_status` enum('success','failed') DEFAULT 'success',
  `paid_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`id`, `order_id`, `payment_mode`, `transaction_id`, `payment_status`, `paid_at`) VALUES
(1, 1, 'UPI', 'TXN12345', 'success', '2025-12-16 07:29:23'),
(2, 1, 'UPI', 'TXN12345', 'success', '2025-12-16 07:30:39'),
(3, 1, 'UPI', 'TXN12345', 'success', '2025-12-16 07:30:45'),
(4, 1, 'UPI', 'TXN12345', 'success', '2025-12-16 07:34:42'),
(5, 1, 'UPI', 'TXN12345', 'success', '2025-12-16 07:38:18'),
(6, 1, 'UPI', 'TXN12345', 'success', '2025-12-16 07:48:48');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` enum('admin','child_artist','buyer','event_manager') DEFAULT NULL,
  `is_verified` tinyint(4) DEFAULT 0,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `role`, `is_verified`, `created_at`) VALUES
(1, 'Updated Artist Name', 'admin@gmail.com', '$2y$10$CrFWFkBsmYhd9PFBh3RqG.SatLTlXYFiVdbxpetQXuqbKGQJbAZ0C', 'buyer', 0, '2025-12-15 16:19:39'),
(2, 'Updated Artist', 'child@gmail.com', '32c0dde2bdb8ef39947256fca8b4a0fc', 'child_artist', 0, '2025-12-15 16:19:39'),
(3, 'Buyer User', 'buyer@gmail.com', '40e868c2d8064888a2a3365a63a84d58', 'buyer', 1, '2025-12-15 16:19:39'),
(4, 'Event Manager', 'event@gmail.com', 'b85097de3c651e46c10067bb7ce45c6a', 'event_manager', 0, '2025-12-15 16:19:39'),
(7, '', '', '$2y$10$.c6XonxB0IZFTOGu3Ak8jerRMd2lGHH/Ksr31tfI3EXbwdihubRoy', '', 0, '2025-12-15 16:22:47'),
(9, 'Event Manager', 'eventm@gmail.com', '$2y$10$JCnYPqfEuOafhaXpQuTUGuT9XXJnok.HoBqr.pTvvKiE7ipIK7RWG', 'event_manager', 1, '2025-12-15 16:24:47'),
(11, 'Admin', 'admin1@gmail.com', NULL, 'admin', 0, '2025-12-15 16:42:04'),
(12, 'Child Artist', 'artist@gmail.com', '$2y$10$9Yxuf9pCexiCSplKpmsF.Oxizz9D9rxAVM/rFsJybEBEbUDjPid3i', 'child_artist', 0, '2025-12-15 17:12:28');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artworks`
--
ALTER TABLE `artworks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `event_artworks`
--
ALTER TABLE `event_artworks`
  ADD PRIMARY KEY (`mapping_id`);

--
-- Indexes for table `event_visitors`
--
ALTER TABLE `event_visitors`
  ADD PRIMARY KEY (`visitor_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_order` (`order_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artworks`
--
ALTER TABLE `artworks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `event_artworks`
--
ALTER TABLE `event_artworks`
  MODIFY `mapping_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `event_visitors`
--
ALTER TABLE `event_visitors`
  MODIFY `visitor_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `fk_order` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
