-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 19, 2023 at 09:11 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlthuvien`
--

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `country` varchar(255) NOT NULL,
  `status_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`id`, `name`, `country`, `status_id`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'Nguyễn Nhật Ánh', 'Việt Nam', 6, '2023-06-19 17:50:30', '2023-06-19 17:50:30', NULL),
(2, 'Hector Malot', 'Pháp', 7, '2023-06-19 17:50:30', '2023-06-19 17:50:30', NULL),
(3, 'Minh Nhật', 'Việt Nam', 6, '2023-06-19 17:50:30', '2023-06-19 17:50:30', NULL),
(4, 'Paulo Coelho', 'Brasil', 6, '2023-06-19 17:50:30', '2023-06-19 17:50:30', NULL),
(5, 'John Berger', 'Anh', 7, '2023-06-19 17:50:30', '2023-06-19 17:50:30', NULL),
(6, 'Stephen R. Covey', 'Salt Lake City, Utah', 7, '2023-06-19 17:50:30', '2023-06-19 17:50:30', NULL),
(7, 'Dale Carnegie', 'Hoa Kỳ', 7, '2023-06-19 17:50:30', '2023-06-19 17:50:30', NULL),
(8, 'Tô Hoài', 'Việt Nam', 7, '2023-06-19 17:50:30', '2023-06-19 17:50:30', NULL),
(9, 'Charles Darwin', 'Anh', 7, '2023-06-19 17:50:30', '2023-06-19 17:50:30', NULL),
(10, 'Napoleon Hill', 'Anh', 8, '2023-06-19 17:50:30', '2023-06-19 17:50:30', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `storage_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `publisher_id` int(11) NOT NULL,
  `publishDate` date NOT NULL,
  `descrition` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `language_id` int(11) DEFAULT NULL,
  `author_id` int(11) DEFAULT NULL,
  `bookType_id` int(11) DEFAULT NULL,
  `dateIn` date NOT NULL,
  `price` float NOT NULL,
  `status_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `name`, `storage_id`, `amount`, `category_id`, `publisher_id`, `publishDate`, `descrition`, `image`, `language_id`, `author_id`, `bookType_id`, `dateIn`, `price`, `status_id`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'Con Chim Xanh Biếc Bay Về', 1, 15, 1, 1, '2020-11-02', 'Lấy bối cảnh vùng quê miền Trung đầy ắp những hoài niệm tuổi thơ dung dị, trong trẻo với các nhân vật ở độ tuổi dậy thì, trong quyển sách mới lần này nhà văn Nguyễn Nhật Ánh lấy bối cảnh chính là Sài Gòn – Thành phố Hồ Chí Minh nơi tác giả sinh sống (như ', 'image1', 1, 1, 1, '2023-06-13', 300, 4, '2023-06-19 17:50:43', '2023-06-19 17:53:28', NULL),
(2, 'Không gia đình', 2, 15, 2, 2, '2019-01-01', 'kể về cuộc đời của cậu bé Rémi. Từ nhỏ, Rémi đã bị bắt cóc, rồi bị bố nuôi bán cho một đoàn xiếc thú. Em đã theo đoàn xiếc ấy đi lưu lạc khắp nước Pháp. Rémi đã lớn lên trong gian khổ và lao động để sống. Lúc đầu em được sự dạy bảo của cụ Vitalis, về sau ', 'image2', 1, 2, 1, '2023-06-13', 200, 4, '2023-06-19 17:50:43', '2023-06-19 17:55:30', NULL),
(3, 'Chỉ Về Nhà Để Ngủ', 1, 10, 1, 3, '2021-06-01', '“Chỉ về nhà để ngủ” của Minh Nhật như một trạm cấp “vé du hành” miễn phí, để mỗi người đều có cơ hội khám phá sâu vào vũ trụ bản thân.', 'image3', 1, 3, 2, '2023-06-13', 200, 4, '2023-06-19 17:50:43', '2023-06-19 17:56:48', NULL),
(4, 'Nhà Giả Kim', 1, 20, 3, 3, '2013-01-01', 'Nhân vật chính trong truyện là Santiago. Cha mẹ Santiago mong muốn cậu trở thành linh mục để mang lại niềm tự hào cho gia đình, nhưng vì ước mơ từ nhỏ của chính mình là đi đây đi đó khắp thế giới, Santigo đã thuyết phục được cha cậu và trở thành một người', 'image4', 1, 4, 4, '2023-06-13', 200, 4, '2023-06-19 17:50:43', '2023-06-19 17:56:48', NULL),
(5, 'Ways of Seeing', 3, 15, 4, 5, '1972-01-01', 'đề xuất quan điểm truyền thống về hệ quy chuẩn của nghệ thuật và văn hóa phương Tây, và series cùng với sách phê bình văn hóa thẩm mỹ truyền thống phương Tây - của Kenneth Clark', 'image5', 2, 5, 6, '2023-06-13', 100, 4, '2023-06-19 17:50:43', '2023-06-19 17:56:48', NULL),
(6, 'The 7 Habits of Highly Effective People', 1, 10, 8, 6, '1989-01-01', 'Cuốn sách này cung cấp cho độc giả những bài học về cách quản lý thời gian, tư duy sáng tạo, giải quyết xung đột và xây dựng mối quan hệ tốt đẹp hơn.', 'image6', 2, 6, 8, '2023-06-13', 150, 4, '2023-06-19 17:50:43', '2023-06-19 17:56:48', NULL),
(7, 'Đắc nhân tâm', 1, 25, 7, 7, '1936-01-01', 'Cuốn sách này là một trong những tác phẩm kinh điển về phát triển cá nhân và kỹ năng giao tiếp. Đây là một cuốn sách hướng dẫn cho người đọc về cách tương tác với những người xung quanh, cải thiện khả năng giao tiếp và tạo ra mối quan hệ tốt đẹp hơn.', 'image7', 2, 7, 8, '2023-06-13', 150, 4, '2023-06-19 17:50:43', '2023-06-19 17:56:48', NULL),
(8, 'Dế Mèn phiêu lưu ký ', 2, 25, 10, 8, '1941-01-01', 'Câu chuyện về cuộc phiêu lưu của chú Dế Mèn, một chú dế nhỏ bé, thông minh và tinh nghịch.', 'image8', 1, 8, 10, '2023-06-13', 50, 4, '2023-06-19 17:50:43', '2023-06-19 17:56:48', NULL),
(9, 'Nguồn gốc các loài', 1, 20, 9, 9, '1859-11-24', 'có thể được coi là một trong các ấn phẩm khoa học tiêu biểu và là tác phẩm nòng cốt của ngành sinh học tiến hóa', 'image9', 2, 9, 9, '2023-06-13', 0, 4, '2023-06-19 17:50:43', '2023-06-19 17:56:48', NULL),
(10, 'Think and Grow Rich', 2, 15, 7, 10, '1937-01-01', 'Cuốn sách được viết bởi Napoleon Hill vào năm 1937 và được quảng bá là một cuốn sách giúp phát triển cá nhân và tự lực bán chạy nhất thế giới', 'image10', 2, 10, 7, '2023-06-13', 100, 4, '2023-06-19 17:50:43', '2023-06-19 17:56:48', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `booktype`
--

CREATE TABLE `booktype` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `status_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booktype`
--

INSERT INTO `booktype` (`id`, `name`, `status_id`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'Tiểu thuyết', 10, '2023-06-19 16:26:16', '2023-06-19 16:26:16', NULL),
(2, 'Truyện ngắn', 10, '2023-06-19 16:26:16', '2023-06-19 16:26:16', NULL),
(3, 'Quản lý', 10, '2023-06-19 16:26:16', '2023-06-19 16:26:16', NULL),
(4, 'Kinh doanh', 10, '2023-06-19 16:26:16', '2023-06-19 16:26:16', NULL),
(5, 'Sách nấu ăn và công thức', 10, '2023-06-19 16:26:16', '2023-06-19 16:26:16', NULL),
(6, 'Sách nghệ thuật', 10, '2023-06-19 16:26:16', '2023-06-19 17:00:34', NULL),
(7, 'Sách tự giúp bản thân', 10, '2023-06-19 16:26:16', '2023-06-19 16:26:16', NULL),
(8, 'Sách truyền cảm hứng và kinh nghiệm', 10, '2023-06-19 16:26:16', '2023-06-19 16:26:16', NULL),
(9, 'Khoa học ứng dụng', 10, '2023-06-19 16:26:16', '2023-06-19 16:26:16', NULL),
(10, 'Lịch sử', 10, '2023-06-19 16:26:16', '2023-06-19 16:26:16', NULL),
(11, 'Giả tưởng & Khoa học viễn tưởng', 10, '2023-06-19 16:26:16', '2023-06-19 16:26:16', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `borrowticket`
--

CREATE TABLE `borrowticket` (
  `id` int(11) NOT NULL,
  `reader_id` int(11) DEFAULT NULL,
  `employ_id` int(11) DEFAULT NULL,
  `borrowDate` datetime NOT NULL,
  `appointDate` datetime NOT NULL,
  `phoneNumber` varchar(12) NOT NULL,
  `notes` text DEFAULT NULL,
  `status_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `borrowticket`
--

INSERT INTO `borrowticket` (`id`, `reader_id`, `employ_id`, `borrowDate`, `appointDate`, `phoneNumber`, `notes`, `status_id`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 7, 4, '2023-06-05 00:00:00', '2023-06-18 00:00:00', '0723456789', NULL, 20, '2023-06-19 19:09:27', '2023-06-19 19:09:27', NULL),
(2, 5, 2, '2023-06-10 00:00:00', '2023-06-25 00:00:00', '0887654321', NULL, 17, '2023-06-19 19:09:27', '2023-06-19 19:09:27', NULL),
(3, 6, 2, '2023-06-10 00:00:00', '2023-06-19 00:00:00', '0512345678', NULL, 18, '2023-06-19 19:09:27', '2023-06-19 19:09:27', NULL),
(4, 9, 3, '2023-06-12 00:00:00', '2023-06-18 00:00:00', '0914345678', NULL, 20, '2023-06-19 19:09:27', '2023-06-19 19:09:27', NULL),
(5, 10, 3, '2023-06-12 00:00:00', '2023-06-18 00:00:00', '0983456789', NULL, 18, '2023-06-19 19:09:27', '2023-06-19 19:09:27', NULL),
(6, 15, 3, '2023-06-12 00:00:00', '2023-06-19 00:00:00', '0911125678', NULL, 20, '2023-06-19 19:09:27', '2023-06-19 19:09:27', NULL),
(7, 11, 3, '2023-06-12 00:00:00', '2023-06-19 00:00:00', '0986664321', NULL, 20, '2023-06-19 19:09:27', '2023-06-19 19:09:27', NULL),
(8, 12, 2, '2023-06-13 00:00:00', '2023-06-19 00:00:00', '0946345678', NULL, 20, '2023-06-19 19:09:27', '2023-06-19 19:09:27', NULL),
(9, 13, 3, '2023-06-14 00:00:00', '2023-06-20 00:00:00', '0913456789', NULL, 18, '2023-06-19 19:09:27', '2023-06-19 19:09:27', NULL),
(10, 14, 4, '2023-06-15 00:00:00', '2023-06-25 00:00:00', '0988854321', NULL, 17, '2023-06-19 19:09:27', '2023-06-19 19:09:27', NULL),
(11, 8, 4, '2023-06-20 00:00:00', '2023-06-25 00:00:00', '0986654321', NULL, 19, '2023-06-19 19:09:27', '2023-06-19 19:09:27', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `descrition` text DEFAULT NULL,
  `status_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`, `descrition`, `status_id`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'Văn học trong nước', 'Các tác phẩm văn học thường có tính chất sáng tạo, tưởng tượng và thể hiện những giá trị nhân văn, tâm lý con người, xã hội, lịch sử, văn hóa, đạo đức, triết lý và những khía cạnh khác của cuộc sống', 12, '2023-06-19 16:26:13', '2023-06-19 16:26:13', NULL),
(2, 'Văn học nước ngoài', 'Các tác phẩm văn học thường có tính chất sáng tạo, tưởng tượng và thể hiện những giá trị nhân văn, tâm lý con người, xã hội, lịch sử, văn hóa, đạo đức, triết lý và những khía cạnh khác của cuộc sống', 12, '2023-06-19 16:26:13', '2023-06-19 16:26:13', NULL),
(3, 'Sách kinh tế', 'Liên quan đến lĩnh vực kinh tế, nghiên cứu và phân tích các hiện tượng kinh tế, cũng như cung cấp các kiến thức và kỹ năng để quản lý tài chính cá nhân hoặc doanh nghiệp.', 12, '2023-06-19 16:26:13', '2023-06-19 16:26:13', NULL),
(4, 'Sách âm nhạc và nghệ thuật', 'Liên quan đến lĩnh vực âm nhạc và nghệ thuật, bao gồm các cuốn sách về âm nhạc, phim ảnh, hội họa, văn học và các lĩnh vực nghệ thuật khác.', 12, '2023-06-19 16:26:13', '2023-06-19 16:26:13', NULL),
(5, 'Sách nấu ăn và ẩm thực', 'Liên quan đến nghệ thuật, âm nhạc, hội họa, điêu khắc, phim ảnh, và các loại hình nghệ thuật khác. ', 12, '2023-06-19 16:26:13', '2023-06-19 16:26:13', NULL),
(6, 'Sách tham khảo', 'Tài liệu được sử dụng để tìm kiếm thông tin và tham khảo trong các lĩnh vực khác nhau.', 12, '2023-06-19 16:26:13', '2023-06-19 16:26:13', NULL),
(7, 'Sách truyền cảm hứng và phát triển cá nhân', 'Tài liệu văn học được thiết kế để giúp độc giả phát triển kỹ năng cá nhân, tăng cường khả năng tự tin, khám phá khả năng tiềm ẩn và tìm hiểu về bản thân mình.', 12, '2023-06-19 16:26:13', '2023-06-19 16:26:13', NULL),
(8, 'Sách kỹ năng sống', 'Phát triển các kỹ năng quan trọng trong cuộc sống, bao gồm kỹ năng giao tiếp, tư duy sáng tạo, quản lý thời gian, giải quyết xung đột, và tự trị.', 12, '2023-06-19 16:26:13', '2023-06-19 16:26:13', NULL),
(9, 'Sách khoa học', 'Tài liệu văn học về các lĩnh vực khoa học, bao gồm cả khoa học tự nhiên và khoa học xã hội', 12, '2023-06-19 16:26:13', '2023-06-19 16:26:13', NULL),
(10, 'Sách lịch sử và văn hóa', 'Tài liệu văn học về các sự kiện, nhân vật, nền văn hóa và các tác phẩm nghệ thuật của các quốc gia và vùng lãnh thổ trên thế giới.', 12, '2023-06-19 16:26:13', '2023-06-19 16:26:13', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `detailborrowticket`
--

CREATE TABLE `detailborrowticket` (
  `id` int(11) NOT NULL,
  `borrowTicket_id` int(11) DEFAULT NULL,
  `book_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detailborrowticket`
--

INSERT INTO `detailborrowticket` (`id`, `borrowTicket_id`, `book_id`, `amount`, `image`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 1, 1, 1, 'image1', '2023-06-19 19:09:31', '2023-06-19 19:09:31', NULL),
(2, 2, 2, 1, 'image2', '2023-06-19 19:09:31', '2023-06-19 19:09:31', NULL),
(3, 2, 5, 1, 'image5', '2023-06-19 19:09:31', '2023-06-19 19:09:31', NULL),
(4, 3, 3, 2, 'image3', '2023-06-19 19:09:31', '2023-06-19 19:09:31', NULL),
(5, 4, 10, 1, 'image10', '2023-06-19 19:09:31', '2023-06-19 19:09:31', NULL),
(6, 5, 4, 1, 'image4', '2023-06-19 19:09:31', '2023-06-19 19:09:31', NULL),
(7, 6, 6, 2, 'image6', '2023-06-19 19:09:31', '2023-06-19 19:09:31', NULL),
(8, 7, 9, 1, 'image9', '2023-06-19 19:09:31', '2023-06-19 19:09:31', NULL),
(9, 8, 9, 2, 'image9', '2023-06-19 19:09:31', '2023-06-19 19:09:31', NULL),
(10, 9, 7, 1, 'image7', '2023-06-19 19:09:31', '2023-06-19 19:09:31', NULL),
(11, 10, 10, 1, 'image10', '2023-06-19 19:09:31', '2023-06-19 19:09:31', NULL),
(12, 10, 1, 1, 'image1', '2023-06-19 19:09:31', '2023-06-19 19:09:31', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `detailreturnticket`
--

CREATE TABLE `detailreturnticket` (
  `id` int(11) NOT NULL,
  `returnTicket_id` int(11) DEFAULT NULL,
  `book_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detailreturnticket`
--

INSERT INTO `detailreturnticket` (`id`, `returnTicket_id`, `book_id`, `amount`, `image`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 1, 3, 2, 'image3', '2023-06-19 19:09:38', '2023-06-19 19:09:38', NULL),
(2, 2, 4, 1, 'image4', '2023-06-19 19:09:38', '2023-06-19 19:09:38', NULL),
(3, 3, 10, 1, 'image10', '2023-06-19 19:09:38', '2023-06-19 19:09:38', NULL),
(4, 4, 6, 2, 'image6', '2023-06-19 19:09:38', '2023-06-19 19:09:38', NULL),
(5, 5, 9, 1, 'image9', '2023-06-19 19:09:38', '2023-06-19 19:09:38', NULL),
(6, 6, 9, 0, 'image9', '2023-06-19 19:09:38', '2023-06-19 19:09:38', NULL),
(7, 7, 7, 1, 'image7', '2023-06-19 19:09:38', '2023-06-19 19:09:38', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `languages`
--

CREATE TABLE `languages` (
  `id` int(11) NOT NULL,
  `languages` varchar(50) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `languages`
--

INSERT INTO `languages` (`id`, `languages`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'Tiếng Việt', '2023-06-19 14:52:18', '2023-06-19 14:52:18', NULL),
(2, 'Tiếng Anh', '2023-06-19 14:52:18', '2023-06-19 14:52:18', NULL),
(3, 'Tiếng Trung', '2023-06-19 14:52:18', '2023-06-19 14:52:18', NULL),
(4, 'Tiếng Pháp', '2023-06-19 14:52:18', '2023-06-19 14:52:18', NULL),
(5, 'Tiếng Hàn', '2023-06-19 14:52:18', '2023-06-19 14:52:18', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `publisher`
--

CREATE TABLE `publisher` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(255) NOT NULL,
  `status_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `publisher`
--

INSERT INTO `publisher` (`id`, `name`, `address`, `status_id`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'NXB Trẻ', 'TP.HCM', 8, '2023-06-19 17:50:39', '2023-06-19 17:50:39', NULL),
(2, 'NXB Văn học', 'HN', 8, '2023-06-19 17:50:39', '2023-06-19 17:50:39', NULL),
(3, 'Skybooks', 'HN', 8, '2023-06-19 17:50:39', '2023-06-19 17:50:39', NULL),
(4, 'Nhà xuất bản Hội nhà văn', 'HN', 8, '2023-06-19 17:50:39', '2023-06-19 17:50:39', NULL),
(5, 'Penguin Books', 'London-Anh', 8, '2023-06-19 17:50:39', '2023-06-19 17:50:39', NULL),
(6, 'Free Press', 'Mỹ', 8, '2023-06-19 17:50:39', '2023-06-19 17:50:39', NULL),
(7, 'Simon and Schuster', 'Mỹ', 8, '2023-06-19 17:50:39', '2023-06-19 17:50:39', NULL),
(8, 'Nhà xuất bản Báo Tân Dân', 'HN', 8, '2023-06-19 17:50:39', '2023-06-19 17:50:39', NULL),
(9, 'John Murray', 'Anh', 8, '2023-06-19 17:50:39', '2023-06-19 17:50:39', NULL),
(10, 'The Ralston Society', 'Mỹ', 8, '2023-06-19 17:50:39', '2023-06-19 17:50:39', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `punnish`
--

CREATE TABLE `punnish` (
  `id` int(11) NOT NULL,
  `returnTicket_id` int(11) DEFAULT NULL,
  `fine` float NOT NULL,
  `status_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `punnish`
--

INSERT INTO `punnish` (`id`, `returnTicket_id`, `fine`, `status_id`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 3, 10, 25, '2023-06-19 19:09:40', '2023-06-19 19:09:40', NULL),
(2, 4, 10, 24, '2023-06-19 19:09:40', '2023-06-19 19:09:40', NULL),
(3, 5, 10, 25, '2023-06-19 19:09:40', '2023-06-19 19:09:40', NULL),
(4, 6, 200, 25, '2023-06-19 19:09:40', '2023-06-19 19:09:40', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `returnticket`
--

CREATE TABLE `returnticket` (
  `id` int(11) NOT NULL,
  `borrowTicket_id` int(11) DEFAULT NULL,
  `reader_id` int(11) DEFAULT NULL,
  `employ_id` int(11) DEFAULT NULL,
  `returnDate` datetime NOT NULL,
  `status_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `returnticket`
--

INSERT INTO `returnticket` (`id`, `borrowTicket_id`, `reader_id`, `employ_id`, `returnDate`, `status_id`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 1, 7, 2, '2023-06-19 00:00:00', 23, '2023-06-19 19:09:35', '2023-06-19 19:09:35', NULL),
(2, 3, 6, 2, '2023-06-19 00:00:00', 21, '2023-06-19 19:09:35', '2023-06-19 19:09:35', NULL),
(3, 5, 10, 3, '2023-06-18 00:00:00', 21, '2023-06-19 19:09:35', '2023-06-19 19:09:35', NULL),
(4, 4, 9, 4, '2023-06-20 00:00:00', 23, '2023-06-19 19:09:35', '2023-06-19 19:09:35', NULL),
(5, 6, 15, 4, '2023-06-20 00:00:00', 23, '2023-06-19 19:09:35', '2023-06-19 19:09:35', NULL),
(6, 7, 11, 4, '2023-06-20 00:00:00', 23, '2023-06-19 19:09:35', '2023-06-19 19:09:35', NULL),
(7, 8, 12, 4, '2023-06-20 00:00:00', 26, '2023-06-19 19:09:35', '2023-06-19 19:09:35', NULL),
(8, 9, 13, 4, '2023-06-20 00:00:00', 22, '2023-06-19 19:09:35', '2023-06-19 19:09:35', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `key1` varchar(20) NOT NULL,
  `role` varchar(50) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `key1`, `role`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'users', 'reader', '2023-06-19 13:59:59', '2023-06-19 13:59:59', NULL),
(2, 'user', 'admin', '2023-06-19 13:59:59', '2023-06-19 13:59:59', NULL),
(3, 'users', 'employee', '2023-06-19 13:59:59', '2023-06-19 13:59:59', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `status1`
--

CREATE TABLE `status1` (
  `id` int(11) NOT NULL,
  `key1` varchar(20) NOT NULL,
  `value1` varchar(50) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `status1`
--

INSERT INTO `status1` (`id`, `key1`, `value1`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'users', 'active', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(2, 'users', 'ban', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(3, 'users', 'block', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(4, 'book', 'available', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(5, 'book', 'unavailable', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(6, 'author', 'active', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(7, 'author', 'non-active', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(8, 'publisher', 'active', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(9, 'publisher', 'non_active', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(10, 'booktype', 'active', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(11, 'booktype', 'non-active', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(12, 'category', 'active', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(13, 'category', 'non-active', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(14, 'storage', 'full', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(15, 'storage', 'empty', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(16, 'storage', 'available seats', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(17, 'borrowticket', 'borrowed', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(18, 'borrowticket', 'done', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(19, 'borrowticket', 'wait confirm', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(20, 'borrowticket', 'overdue', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(21, 'returnticket', 'done', '2023-06-19 14:07:49', '2023-06-19 18:32:21', NULL),
(22, 'returnticket', 'wait confirm', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(23, 'returnticket', 'overdue', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(24, 'punnish', 'unpaid', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(25, 'punnish', 'paided', '2023-06-19 14:07:49', '2023-06-19 14:07:49', NULL),
(26, 'returnticket', 'lost', '2023-06-19 18:58:40', '2023-06-19 18:58:40', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `storages`
--

CREATE TABLE `storages` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `status_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `storages`
--

INSERT INTO `storages` (`id`, `name`, `address`, `status_id`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'Kho 1', 'Tầng 1', 14, '2023-06-19 14:55:07', '2023-06-19 14:55:07', NULL),
(2, 'Kho 2', 'Tầng 2', 15, '2023-06-19 14:55:07', '2023-06-19 14:55:07', NULL),
(3, 'Kho 3', 'Tầng 3', 16, '2023-06-19 14:55:07', '2023-06-19 14:55:07', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phoneNumber` varchar(12) NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  `ciid` varchar(12) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `passwords` varchar(50) NOT NULL,
  `joinDate` date NOT NULL,
  `role_id` int(11) NOT NULL DEFAULT 1,
  `status_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `phoneNumber`, `address`, `email`, `ciid`, `userName`, `passwords`, `joinDate`, `role_id`, `status_id`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'Nguyễn Văn A', '0987654321', '123 Đường A, Quận Đống Đa, HN', 'nguyenvana@gmail.com', '123456789012', 'nguyenvana', 'password1', '2021-01-01', 2, 1, '2023-06-19 14:14:52', '2023-06-19 14:14:52', NULL),
(2, 'Trần Thị B', '0123456789', '456 Đường B, Quận Thanh Xuân, HN', 'tranthib@gmail.com', '098765432109', 'tranthib', 'password2', '2021-02-02', 3, 1, '2023-06-19 14:44:02', '2023-06-19 14:44:55', NULL),
(3, 'Lê Văn C', '0912345678', '789 Đường C, Hải Dương', 'levanc@gmail.com', '555555555512', 'levanc', 'password3', '2021-02-03', 3, 1, '2023-06-19 14:44:02', '2023-06-19 14:45:03', NULL),
(4, 'Phạm Thị D', '0923456789', '987 Đường D, Quận 4, TP.HCM', 'phamthid@gmail.com', '111111111112', 'phamthid', 'password4', '2021-02-04', 3, 1, '2023-06-19 14:44:02', '2023-06-19 14:45:10', NULL),
(5, 'Nguyễn Văn E', '0887654321', '654 Đường E, Hải Phòng', 'nguyenvane@gmail.com', '222222222212', 'nguyenvane', 'password5', '2022-01-05', 1, 1, '2023-06-19 14:44:02', '2023-06-19 14:45:18', NULL),
(6, 'Trần Thị F', '0512345678', '321 Đường F, Quận Hoàng Mai, HN', 'tranthif@gmail.com', '333333333312', 'tranthif', 'password6', '2021-05-06', 1, 1, '2023-06-19 14:44:02', '2023-06-19 14:45:25', NULL),
(7, 'Lê Văn G', '0723456789', '987 Đường G, Quận Cầu Giấy, HN', 'levang@gmail.com', '444444444412', 'levang', 'password7', '2021-09-07', 1, 1, '2023-06-19 14:44:02', '2023-06-19 14:45:36', NULL),
(8, 'Phạm Thị H', '0986654321', '654 Đường H, Bắc Ninh', 'phamthih@gmail.com', '555555555000', 'phamthih', 'password8', '2023-01-08', 1, 1, '2023-06-19 14:44:02', '2023-06-19 14:45:45', NULL),
(9, 'Nguyễn Văn I', '0914345678', '321 Đường I, Quận 9, TP.HCM', 'nguyenvani@gmail.com', '666666666612', 'nguyenvani', 'password9', '2022-02-09', 1, 1, '2023-06-19 14:44:02', '2023-06-19 14:45:52', NULL),
(10, 'Trần Thị K', '0983456789', '987 Đường K, Quận Long Biên, HN', 'tranthik@gmail.com', '777777777712', 'tranthik', 'password10', '2022-05-10', 1, 1, '2023-06-19 14:44:02', '2023-06-19 14:46:01', NULL),
(11, 'Lê Văn L', '0986664321', '654 Đường L, Quận 11, TP.HCM', 'levanl@gmail.com', '888888888812', 'levanl', 'password11', '2021-09-11', 1, 1, '2023-06-19 14:44:02', '2023-06-19 14:46:08', NULL),
(12, 'Phạm Thị M', '0946345678', '321 Đường M, Quận 12, TP.HCM', 'phamthim@gmail.com', '999999999912', 'phamthim', 'password12', '2022-03-12', 1, 1, '2023-06-19 14:44:02', '2023-06-19 14:46:54', NULL),
(13, 'Nguyễn Văn N', '0913456789', '987 Đường N, Hải Dương', 'nguyenvann@gmail.com', '121212121212', 'nguyenvann', 'password13', '2021-04-13', 1, 1, '2023-06-19 14:44:02', '2023-06-19 14:46:54', NULL),
(14, 'Trần Thị O', '0988854321', '654 Đường O, Nghệ An', 'tranthio@gmail.com', '131313131312', 'tranthio', 'password14', '2023-02-14', 1, 1, '2023-06-19 14:44:02', '2023-06-19 14:46:54', NULL),
(15, 'Lê Văn P', '0911125678', '321 Đường P, HN', 'levanp@gmail.com', '141414141412', 'levanp', 'password15', '2023-04-15', 1, 1, '2023-06-19 14:44:02', '2023-06-19 14:46:54', NULL),
(16, 'Lê Nhân B', '0922125678', '321 Đường Q, Quận Cầu Giấy, HN', 'lenhanb@gmail.com', '142414141444', 'lenhanb', 'password16', '2023-04-15', 1, 2, '2023-06-19 14:44:02', '2023-06-19 14:46:54', NULL),
(17, 'Trần Văn P', '0524125678', '476 Đường L, Quận Hoàn Kiếm, HN', 'tranvanp@gmail.com', '145414141666', 'tranvanp', 'password17', '2023-04-15', 1, 3, '2023-06-19 14:44:02', '2023-06-19 14:46:54', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_author_status1` (`status_id`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_book_storages` (`storage_id`),
  ADD KEY `fk_book_category` (`category_id`),
  ADD KEY `fk_book_publisher` (`publisher_id`),
  ADD KEY `fk_book_languages` (`language_id`),
  ADD KEY `fk_book_author` (`author_id`),
  ADD KEY `fk_book_booktype` (`bookType_id`),
  ADD KEY `fk_book_status1` (`status_id`);

--
-- Indexes for table `booktype`
--
ALTER TABLE `booktype`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_booktype_status1` (`status_id`);

--
-- Indexes for table `borrowticket`
--
ALTER TABLE `borrowticket`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_borrowticket_reader` (`reader_id`),
  ADD KEY `fk_borrowticket_employ` (`employ_id`),
  ADD KEY `fk_borrowticket_status1` (`status_id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_category_status1` (`status_id`);

--
-- Indexes for table `detailborrowticket`
--
ALTER TABLE `detailborrowticket`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_detailborrowticket_borrowticket` (`borrowTicket_id`),
  ADD KEY `fk_detailborrowticket_book` (`book_id`);

--
-- Indexes for table `detailreturnticket`
--
ALTER TABLE `detailreturnticket`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_detailreturnticket_returnticket` (`returnTicket_id`),
  ADD KEY `fk_detailreturnticket_book` (`book_id`);

--
-- Indexes for table `languages`
--
ALTER TABLE `languages`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `publisher`
--
ALTER TABLE `publisher`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_publisher_status1` (`status_id`);

--
-- Indexes for table `punnish`
--
ALTER TABLE `punnish`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_punnish_returnticket` (`returnTicket_id`),
  ADD KEY `fk_punnish_status1` (`status_id`);

--
-- Indexes for table `returnticket`
--
ALTER TABLE `returnticket`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_returnticket_borrowticket` (`borrowTicket_id`),
  ADD KEY `fk_returnticket_reader` (`reader_id`),
  ADD KEY `fk_returnticket_employ` (`employ_id`),
  ADD KEY `fk_returnticket_status1` (`status_id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `status1`
--
ALTER TABLE `status1`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `storages`
--
ALTER TABLE `storages`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_storages_status1` (`status_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `phoneNumber` (`phoneNumber`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `ciid` (`ciid`),
  ADD UNIQUE KEY `userName` (`userName`),
  ADD KEY `fk_users_roles` (`role_id`),
  ADD KEY `fk_users_status1` (`status_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `booktype`
--
ALTER TABLE `booktype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `borrowticket`
--
ALTER TABLE `borrowticket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `detailborrowticket`
--
ALTER TABLE `detailborrowticket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `detailreturnticket`
--
ALTER TABLE `detailreturnticket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `languages`
--
ALTER TABLE `languages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `publisher`
--
ALTER TABLE `publisher`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `punnish`
--
ALTER TABLE `punnish`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `returnticket`
--
ALTER TABLE `returnticket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `status1`
--
ALTER TABLE `status1`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `storages`
--
ALTER TABLE `storages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `author`
--
ALTER TABLE `author`
  ADD CONSTRAINT `fk_author_status1` FOREIGN KEY (`status_id`) REFERENCES `status1` (`id`);

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `fk_book_author` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
  ADD CONSTRAINT `fk_book_booktype` FOREIGN KEY (`bookType_id`) REFERENCES `booktype` (`id`),
  ADD CONSTRAINT `fk_book_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  ADD CONSTRAINT `fk_book_languages` FOREIGN KEY (`language_id`) REFERENCES `languages` (`id`),
  ADD CONSTRAINT `fk_book_publisher` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`),
  ADD CONSTRAINT `fk_book_status1` FOREIGN KEY (`status_id`) REFERENCES `status1` (`id`),
  ADD CONSTRAINT `fk_book_storages` FOREIGN KEY (`storage_id`) REFERENCES `storages` (`id`);

--
-- Constraints for table `booktype`
--
ALTER TABLE `booktype`
  ADD CONSTRAINT `fk_booktype_status1` FOREIGN KEY (`status_id`) REFERENCES `status1` (`id`);

--
-- Constraints for table `borrowticket`
--
ALTER TABLE `borrowticket`
  ADD CONSTRAINT `fk_borrowticket_employ` FOREIGN KEY (`employ_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `fk_borrowticket_reader` FOREIGN KEY (`reader_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `fk_borrowticket_status1` FOREIGN KEY (`status_id`) REFERENCES `status1` (`id`);

--
-- Constraints for table `category`
--
ALTER TABLE `category`
  ADD CONSTRAINT `fk_category_status1` FOREIGN KEY (`status_id`) REFERENCES `status1` (`id`);

--
-- Constraints for table `detailborrowticket`
--
ALTER TABLE `detailborrowticket`
  ADD CONSTRAINT `fk_detailborrowticket_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `fk_detailborrowticket_borrowticket` FOREIGN KEY (`borrowTicket_id`) REFERENCES `borrowticket` (`id`);

--
-- Constraints for table `detailreturnticket`
--
ALTER TABLE `detailreturnticket`
  ADD CONSTRAINT `fk_detailreturnticket_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `fk_detailreturnticket_returnticket` FOREIGN KEY (`returnTicket_id`) REFERENCES `returnticket` (`id`);

--
-- Constraints for table `publisher`
--
ALTER TABLE `publisher`
  ADD CONSTRAINT `fk_publisher_status1` FOREIGN KEY (`status_id`) REFERENCES `status1` (`id`);

--
-- Constraints for table `punnish`
--
ALTER TABLE `punnish`
  ADD CONSTRAINT `fk_punnish_returnticket` FOREIGN KEY (`returnTicket_id`) REFERENCES `returnticket` (`id`),
  ADD CONSTRAINT `fk_punnish_status1` FOREIGN KEY (`status_id`) REFERENCES `status1` (`id`);

--
-- Constraints for table `returnticket`
--
ALTER TABLE `returnticket`
  ADD CONSTRAINT `fk_returnticket_borrowticket` FOREIGN KEY (`borrowTicket_id`) REFERENCES `borrowticket` (`id`),
  ADD CONSTRAINT `fk_returnticket_employ` FOREIGN KEY (`employ_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `fk_returnticket_reader` FOREIGN KEY (`reader_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `fk_returnticket_status1` FOREIGN KEY (`status_id`) REFERENCES `status1` (`id`);

--
-- Constraints for table `storages`
--
ALTER TABLE `storages`
  ADD CONSTRAINT `fk_storages_status1` FOREIGN KEY (`status_id`) REFERENCES `status1` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_users_roles` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `fk_users_status1` FOREIGN KEY (`status_id`) REFERENCES `status1` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
