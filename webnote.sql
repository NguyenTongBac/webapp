-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 27, 2021 lúc 06:48 PM
-- Phiên bản máy phục vụ: 10.4.19-MariaDB
-- Phiên bản PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `webnote`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `account` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password2` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`account`, `password`, `name`, `password2`) VALUES
('kin@gmail.com', '123456', 'kin', '654321'),
('nguyentongbac@gmail.com', '1', 'nguyentongbac', '20010506'),
('nguyentongkiet@gmail.com', '123', 'tongkiet', '20012223'),
('nguyentongnam@gmail.com', '05062001', 'nguyentongbac', '20010605'),
('tongbac2001@gmail.com', '123', 'tongbac', '123'),
('tongbac65@gmail.com', '123', 'tongbac', '123');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `note`
--

CREATE TABLE `note` (
  `Note_id` int(11) NOT NULL,
  `account` varchar(50) NOT NULL,
  `titleNote` varchar(1000) DEFAULT NULL,
  `note` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `note`
--

INSERT INTO `note` (`Note_id`, `account`, `titleNote`, `note`) VALUES
(61, 'nguyentongbac@gmail.com', 'Hẹn một mai', 'Có con đường nào bước qua Ta đến mang em món quà Hẹn hò yêu thương Ta say đến già'),
(62, 'nguyentongbac@gmail.com', 'Hẹn một mai', 'Có con đường nào bước qua Ta đến mang em món quà Hẹn hò yêu thương Ta say đến già'),
(63, 'nguyentongbac@gmail.com', 'hello world', 'concac'),
(64, 'nguyentongbac@gmail.com', 'hello world', 'concac'),
(65, 'nguyentongbac@gmail.com', 'hello world', 'here is the note'),
(66, 'nguyentongbac@gmail.com', 'hello world', 'here is the note'),
(67, 'nguyentongbac@gmail.com', 'Háº¹n má»t mai con cáº·c', 'here is the note Äá»t máº¹ mÃ y'),
(68, 'nguyentongbac@gmail.com', 'Hẹn một mai con cặc', 'dit me may');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`account`);

--
-- Chỉ mục cho bảng `note`
--
ALTER TABLE `note`
  ADD PRIMARY KEY (`Note_id`),
  ADD KEY `account` (`account`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `note`
--
ALTER TABLE `note`
  MODIFY `Note_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `note_ibfk_1` FOREIGN KEY (`account`) REFERENCES `customer` (`account`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
