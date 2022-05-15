-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 01, 2022 at 08:42 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `electrogrid`
--

-- --------------------------------------------------------

--
-- Table structure for table `billdetails`
--

CREATE TABLE `billdetails` (
  `billID` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `accountNumber` int(10) NOT NULL,
  `serviceAddress` varchar(20) NOT NULL,
  `dueDate` varchar(10) NOT NULL,
  `unitsUse` int(11) NOT NULL,
  `amount` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `billdetails`
--

INSERT INTO `billdetails` (`billID`, `name`, `accountNumber`, `serviceAddress`, `dueDate`, `unitsUse`, `amount`) VALUES
(235, 'Thusil', 78965389, 'Kandy', '12.04.22', 22, 4000);

-- --------------------------------------------------------

--
-- Table structure for table `carddata`
--

CREATE TABLE `carddata` (
  `cardID` int(20) NOT NULL,
  `cardHolderName` varchar(40) NOT NULL,
  `cardNo` varchar(40) NOT NULL,
  `Month` varchar(40) NOT NULL,
  `Year` varchar(40) NOT NULL,
  `ccvNo` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `carddata`
--

INSERT INTO `carddata` (`cardID`, `cardHolderName`, `cardNo`, `Month`, `Year`, `ccvNo`) VALUES
(1, 'Sadisha', '56895', 'April', '2023', '008');

-- --------------------------------------------------------

--
-- Table structure for table `information`
--

CREATE TABLE `information` (
  `informationID` int(5) NOT NULL,
  `category` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `summary` varchar(50) NOT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `information`
--

INSERT INTO `information` (`informationID`, `category`, `name`, `summary`, `status`) VALUES
(5, 'Power Cut', 'Vihanga', 'asghfvafvhjasfvuavfjhvh afsfasvfjv afvsufyvu', 'breakdown');

-- --------------------------------------------------------

--
-- Table structure for table `inquiries`
--

CREATE TABLE `inquiries` (
  `inquiryID` int(5) NOT NULL,
  `name` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `contactNumber` int(10) NOT NULL,
  `address` varchar(20) NOT NULL,
  `inquiryType` varchar(10) NOT NULL,
  `message` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inquiries`
--

INSERT INTO `inquiries` (`inquiryID`, `name`, `email`, `contactNumber`, `address`, `inquiryType`, `message`) VALUES
(1, 'Ishara', 'ishara@abc.com', 785698695, 'Kurunagala', 'Breakdown', 'husabhjsahjcisjkcbkjckzxbjkbcnx..snjjcxcIKcb  bibfisabifbisbci iafuiasbiucbiubi fbsiuabuicbiuabciub afibaiubciasbuicbuib fasbibfiaubfiabfiuyvb');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `pymntID` int(5) NOT NULL,
  `billID` varchar(10) NOT NULL,
  `customerName` varchar(20) NOT NULL,
  `Month` varchar(10) NOT NULL,
  `cardID` varchar(10) NOT NULL,
  `Amount` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`pymntID`, `billID`, `customerName`, `Month`, `cardID`, `Amount`) VALUES
(1, '23569', 'Sadisha', 'April', '458965', '5000');

-- --------------------------------------------------------

--
-- Table structure for table `stations`
--

CREATE TABLE `stations` (
  `stationID` int(5) NOT NULL,
  `stationCode` varchar(20) NOT NULL,
  `stationName` varchar(20) NOT NULL,
  `location` varchar(20) NOT NULL,
  `zone` varchar(20) NOT NULL,
  `province` varchar(10) NOT NULL,
  `capacity` float NOT NULL,
  `status` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stations`
--

INSERT INTO `stations` (`stationID`, `stationCode`, `stationName`, `location`, `zone`, `province`, `capacity`, `status`) VALUES
(1, 'WE3', 'Colombo4', 'Colombo2', 'Col1', 'Western', 12.5, 'active');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userID` int(5) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL,
  `address` varchar(20) NOT NULL,
  `contact_no` int(10) NOT NULL,
  `email` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `billdetails`
--
ALTER TABLE `billdetails`
  ADD PRIMARY KEY (`billID`);

--
-- Indexes for table `carddata`
--
ALTER TABLE `carddata`
  ADD PRIMARY KEY (`cardID`);

--
-- Indexes for table `information`
--
ALTER TABLE `information`
  ADD PRIMARY KEY (`informationID`);

--
-- Indexes for table `inquiries`
--
ALTER TABLE `inquiries`
  ADD PRIMARY KEY (`inquiryID`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`pymntID`);

--
-- Indexes for table `stations`
--
ALTER TABLE `stations`
  ADD PRIMARY KEY (`stationID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `billdetails`
--
ALTER TABLE `billdetails`
  MODIFY `billID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=236;

--
-- AUTO_INCREMENT for table `carddata`
--
ALTER TABLE `carddata`
  MODIFY `cardID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `information`
--
ALTER TABLE `information`
  MODIFY `informationID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `inquiries`
--
ALTER TABLE `inquiries`
  MODIFY `inquiryID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `pymntID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `stations`
--
ALTER TABLE `stations`
  MODIFY `stationID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userID` int(5) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
