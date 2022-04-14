-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 14, 2022 at 04:18 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_jav4`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `description` text NOT NULL,
  `image` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`, `description`, `image`) VALUES
(167, 'Clothes', '  none', 'https://product.hstatic.net/1000096703/product/2_221c781cf6cc46af870e90935bbc98c2_master.jpg'),
(170, 'Fashion', 'None', 'https://product.hstatic.net/1000096703/product/2_221c781cf6cc46af870e90935bbc98c2_master.jpg'),
(171, 'Books', 'no', 'https://product.hstatic.net/1000096703/product/2_221c781cf6cc46af870e90935bbc98c2_master.jpg'),
(175, 'Phone', 'Khong', 'https://product.hstatic.net/1000096703/product/2_221c781cf6cc46af870e90935bbc98c2_master.jpg'),
(176, 'Other', ' no', 'https://product.hstatic.net/1000096703/product/2_221c781cf6cc46af870e90935bbc98c2_master.jpg'),
(178, 'abc', '123', 'https://product.hstatic.net/1000096703/product/2_221c781cf6cc46af870e90935bbc98c2_master.jpg'),
(179, 'Shortt22222222', '123', '2131');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `customerName` varchar(60) NOT NULL,
  `addressShip` varchar(200) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `total` float NOT NULL,
  `status` varchar(20) NOT NULL,
  `createAT` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `orderdetail`
--

CREATE TABLE `orderdetail` (
  `orderId` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  `price` float NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orderdetail`
--

INSERT INTO `orderdetail` (`orderId`, `productId`, `price`, `quantity`) VALUES
(1, 1, 3000000, 1),
(2, 1, 3000000, 1),
(3, 23, 30000000, 2),
(4, 1, 3000000, 1),
(5, 1, 3000000, 1),
(6, 1, 3000000, 2);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `customerName` varchar(60) NOT NULL,
  `addressShip` varchar(200) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `total` float NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  `createAT` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `userId`, `customerName`, `addressShip`, `phone`, `total`, `status`, `createAT`) VALUES
(1, 0, '12313', '123123', '123', 3000000, 'PENDING', '2022-04-14'),
(2, 0, 'xuanquy', 'dak lak', '091231231', 3000000, 'PENDING', '2022-04-14'),
(3, 0, 'Thi Be', 'BMT City', '012312325', 60000000, 'PENDING', '2022-04-14'),
(4, 0, '1231 ', '123', '123', 3000000, 'PENDING', '2022-04-14'),
(5, 0, '123 ', '123', '123', 3000000, 'PENDING', '2022-04-14'),
(6, 0, 'abc ', 'dak lak', '123123123', 6000000, 'PENDING', '2022-04-14');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `image` text NOT NULL,
  `price` int(111) NOT NULL,
  `description` text NOT NULL,
  `categoryId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `image`, `price`, `description`, `categoryId`) VALUES
(1, 'Jacket', 'http://localhost:8080/ASM-JAVA4/images/product-1.jpg', 3000000, '  [none]', 167),
(12, 'White Dress', 'http://localhost:8080/ASM-JAVA4/images/product-3.jpg', 1200000, '     [none]', 167),
(17, 'Dress', 'http://localhost:8080/ASM-JAVA4/images/product-2.jpg', 20000000, '  123', 167),
(22, 'Red Dress', 'http://localhost:8080/ASM-JAVA4/images/product-5.jpg', 12000000, 'không', 167),
(23, 'Jacket Man', 'http://localhost:8080/ASM-JAVA4/images/product-8.jpg', 30000000, 'acv', 167),
(26, 'Xiaomi Black Shark', 'https://cf.shopee.vn/file/241813fdb6fb120c0ac5a80b9865b146', 15000000, 'None', 175),
(30, 'Shortt', 'https://product.hstatic.net/1000096703/product/2_221c781cf6cc46af870e90935bbc98c2_master.jpg', 123, '123', 169),
(31, 'Tokyo Ghoul', 'https://upload.wikimedia.org/wikipedia/vi/3/3a/Tokyo_Ghoul_Anime.png', 200000, 'None', 171),
(32, 'Dr.stone', 'https://cdn-amz.fadoglobal.io/images/I/81rMtGhIz7L.jpg', 90000, 'None', 171),
(33, 'Attack on titan', 'https://images-na.ssl-images-amazon.com/images/I/91HfjIdXvrL.jpg', 120000, 'None', 171),
(35, 'Your Name', 'https://images-na.ssl-images-amazon.com/images/I/91AZYjY7y4L.jpg', 250000, 'Không', 171),
(37, 'vest123567ac', 'https://product.hstatic.net/1000096703/product/2_221c781cf6cc46af870e90935bbc98c2_master.jpg', 123000, 'khong', 169),
(41, 'Shortt123', 'https://product.hstatic.net/1000096703/product/2_221c781cf6cc46af870e90935bbc98c2_master.jpg', 123123, '123', 178),
(42, 'quy123', 'https://product.hstatic.net/1000096703/product/2_221c781cf6cc46af870e90935bbc98c2_master.jpg', 123123, 'none', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `userName` varchar(60) NOT NULL,
  `password` varchar(200) NOT NULL,
  `email` varchar(30) NOT NULL,
  `role` text NOT NULL,
  `name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `userName`, `password`, `email`, `role`, `name`) VALUES
(7, 'xuanquy', 'oJO6MBhn8lAm+G/yWvEfVQ==', 'quy@gmail.com', 'admin', 'Xuân Quý'),
(8, 'admin', 'oJO6MBhn8lAm+G/yWvEfVQ==', 'vip@gmail.com', 'admin', 'Sad'),
(9, 'dtb', '9vJKJoRsxf9FkWD6UFMBVA==', 'dtb@gmail.com', 'admin', 'DTB'),
(12, 'lxq', 'YUusPptmhlRTchtm2hehyw==', 'lxq@gmail.com', 'user', 'Xuân Quý'),
(21, 'user3', 'YUusPptmhlRTchtm2hehyw==', 'truongvan6322@gmail.com', 'user', '  Thị Bé'),
(24, 'long123', 'YUusPptmhlRTchtm2hehyw==', 'longptpk01964@fpt.edu.vn', 'user', '     long'),
(25, 'adminb', 'YUusPptmhlRTchtm2hehyw==', 'truongvan6322@gmail.com', 'user', '123'),
(27, 'admin12321', 'YUusPptmhlRTchtm2hehyw==', 'truongvan6322@gmail.com', 'user', '123'),
(28, 'ybn123', 'Hh3wadSSzlDo5agAN0KHGEto3QDfdRNIk7yTmaodblk=', 'truongvan6322@gmail.com', 'user', '    Love you'),
(30, 'duc123', 'YUusPptmhlRTchtm2hehyw==', 'ksorduc.28032003@gmail.com', 'user', '     Đức'),
(31, 'testbe', 'YUusPptmhlRTchtm2hehyw==', 'truongvan6322@gmail.com', 'user', 'Bé'),
(45, 'adminnew', 'oJO6MBhn8lAm+G/yWvEfVQ==', 'truongvan6322@gmail.com', 'admin', 'Nguyệt Nga'),
(47, 'test', 'YUusPptmhlRTchtm2hehyw==', 'truongvan6322@gmail.com', 'user', 'Hoàng'),
(50, 'asd123', 'YUusPptmhlRTchtm2hehyw==', 'truongvan6322@gmail.com', 'user', ' DTB'),
(51, 'asdokokoko ga the', 'Hh3wadSSzlDo5agAN0KHGEto3QDfdRNIk7yTmaodblk=', 'truongvan6322@gmail.com', 'user', ' DTB'),
(52, 'adddddddd', 'YUusPptmhlRTchtm2hehyw==', 'truongvan6322@gmail.com', 'user', '123'),
(53, '123', 'M6gwX9sYTHq4PjwM01UJYm1bswFWZpAAv2P9xu6s4ys=', '1', 'user', ' 1'),
(57, 'admin123123', 'YUusPptmhlRTchtm2hehyw==', 'truongvan6322@gmail.com', 'user', 'DTB'),
(58, 'adminabc', 'YUusPptmhlRTchtm2hehyw==', 'truongvan6322@gmail.com', 'user', 'xuan'),
(59, 'final', 'YUusPptmhlRTchtm2hehyw==', 'truongvan6322@gmail.com', 'user', 'Văn');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD PRIMARY KEY (`orderId`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=180;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `orderdetail`
--
ALTER TABLE `orderdetail`
  MODIFY `orderId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
