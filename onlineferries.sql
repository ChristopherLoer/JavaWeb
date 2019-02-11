-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 11. Feb 2019 um 09:27
-- Server-Version: 10.1.31-MariaDB
-- PHP-Version: 5.6.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `onlineferries`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `cabintype`
--

CREATE TABLE `cabintype` (
  `cabintype_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `passengers` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `cabintype`
--

INSERT INTO `cabintype` (`cabintype_id`, `description`, `passengers`) VALUES
(6001, 'A1', 4),
(6002, 'B1', 6),
(6003, 'A2', 6),
(6004, 'B2', 8),
(6005, 'C1', 6),
(6006, 'C2', 8);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `account_nr` int(11) DEFAULT NULL,
  `bank_id` int(11) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `customer`
--

INSERT INTO `customer` (`id`, `account_nr`, `bank_id`, `city`, `email`, `firstname`, `name`, `password`, `street`, `zipcode`) VALUES
(1, 111111111, 11111111, 'Paderborn', 'test@test', 'test', 'test', 'test', 'test', '33106'),
(2, 111111111, 11111111, 'Paderborn', 'test@test', 'test', 'test', 'test', 'test', '33106');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `reservation`
--

CREATE TABLE `reservation` (
  `reservation_id` int(11) NOT NULL,
  `cars` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `trip_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `reservation_cabin`
--

CREATE TABLE `reservation_cabin` (
  `cabintype_id` int(11) NOT NULL,
  `reservation_id` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  `cabin_index` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `route`
--

CREATE TABLE `route` (
  `route_id` int(11) NOT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `start` varchar(255) DEFAULT NULL,
  `ship_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `route`
--

INSERT INTO `route` (`route_id`, `destination`, `start`, `ship_id`) VALUES
(1001, 'Genua', 'Olbia', 5001),
(1002, 'Olbia', 'Genua', 5001),
(1011, 'Genua', 'Bastia', 5002),
(1012, 'Bastia', 'Genua', 5002),
(1021, 'Piombino', 'Portoferraio', 5003),
(1022, 'Portoferraio', 'Piombino', 5003);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `ship`
--

CREATE TABLE `ship` (
  `ship_id` int(11) NOT NULL,
  `cars` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `passengers` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `ship`
--

INSERT INTO `ship` (`ship_id`, `cars`, `description`, `passengers`) VALUES
(5001, 0, '2000', 500),
(5002, 0, '1800', 400),
(5003, 0, '800', 250);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `ship_cabin`
--

CREATE TABLE `ship_cabin` (
  `cabintype_id` int(11) NOT NULL,
  `ship_id` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  `price` double NOT NULL,
  `cabin_index` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `ship_cabin`
--

INSERT INTO `ship_cabin` (`cabintype_id`, `ship_id`, `count`, `price`, `cabin_index`) VALUES
(6001, 5001, 60, 25, 0),
(6001, 5002, 50, 20, 0),
(6001, 5003, 30, 20, 0),
(6002, 5001, 60, 30, 1),
(6002, 5002, 50, 25, 1),
(6002, 5003, 30, 25, 1),
(6003, 5001, 40, 35, 2),
(6003, 5002, 35, 30, 2),
(6003, 5003, 15, 25, 2),
(6004, 5001, 40, 40, 3),
(6004, 5002, 35, 35, 3),
(6004, 5003, 15, 30, 3),
(6005, 5001, 20, 40, 4),
(6005, 5002, 20, 40, 4),
(6005, 5003, 10, 35, 4),
(6006, 5001, 20, 45, 5),
(6006, 5002, 20, 45, 5),
(6006, 5003, 10, 40, 5);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `travellers`
--

CREATE TABLE `travellers` (
  `travellers_id` int(11) NOT NULL,
  `fullName` varchar(255) DEFAULT NULL,
  `reservation_id` int(11) DEFAULT NULL,
  `travellers_index` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `trip`
--

CREATE TABLE `trip` (
  `trip_id` int(11) NOT NULL,
  `arrival` time DEFAULT NULL,
  `date` date DEFAULT NULL,
  `departure` time DEFAULT NULL,
  `price_car` double NOT NULL,
  `price_passenger` double NOT NULL,
  `route_id` int(11) DEFAULT NULL,
  `trip_index` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `trip`
--

INSERT INTO `trip` (`trip_id`, `arrival`, `date`, `departure`, `price_car`, `price_passenger`, `route_id`, `trip_index`) VALUES
(2001, '16:00:00', '2015-01-05', '07:00:00', 50, 200, 1001, 0),
(2002, '16:00:00', '2015-01-12', '07:00:00', 50, 200, 1001, 1),
(2003, '16:00:00', '2015-01-19', '07:00:00', 50, 200, 1001, 2),
(2011, '05:00:00', '2015-01-05', '20:00:00', 70, 250, 1002, 0),
(2012, '05:00:00', '2015-01-12', '20:00:00', 70, 250, 1002, 1),
(2013, '05:00:00', '2015-01-19', '20:00:00', 70, 250, 1002, 2),
(2021, '14:00:00', '2015-01-06', '08:00:00', 40, 100, 1011, 0),
(2022, '14:00:00', '2015-01-10', '08:00:00', 40, 100, 1011, 1),
(2023, '14:00:00', '2015-01-14', '08:00:00', 40, 100, 1011, 2),
(2031, '24:00:00', '2015-01-06', '18:00:00', 60, 100, 1012, 0),
(2032, '24:00:00', '2015-01-10', '18:00:00', 60, 100, 1012, 1),
(2033, '24:00:00', '2015-01-14', '18:00:00', 60, 100, 1012, 2),
(2041, '09:30:00', '2015-01-06', '08:00:00', 30, 80, 1021, 0),
(2042, '13:30:00', '2015-01-06', '12:00:00', 30, 80, 1021, 1),
(2043, '09:30:00', '2015-01-10', '08:00:00', 30, 80, 1021, 2),
(2051, '17:30:00', '2015-01-06', '16:00:00', 30, 80, 1022, 0),
(2052, '21:30:00', '2015-01-06', '20:00:00', 30, 80, 1022, 1),
(2053, '17:30:00', '2015-01-10', '16:00:00', 30, 80, 1022, 2);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `cabintype`
--
ALTER TABLE `cabintype`
  ADD PRIMARY KEY (`cabintype_id`);

--
-- Indizes für die Tabelle `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`reservation_id`),
  ADD KEY `FK_7yej2c8cslyb8r4okfwlassa3` (`customer_id`),
  ADD KEY `FK_ketteu8uj8e50ls6ocde9mhi9` (`trip_id`);

--
-- Indizes für die Tabelle `reservation_cabin`
--
ALTER TABLE `reservation_cabin`
  ADD PRIMARY KEY (`cabintype_id`,`reservation_id`),
  ADD KEY `FK_94ojnx00xkk14nkcisnwtb25p` (`cabintype_id`),
  ADD KEY `FK_oyh0a3r8sik3nk2ak282bbx6h` (`reservation_id`);

--
-- Indizes für die Tabelle `route`
--
ALTER TABLE `route`
  ADD PRIMARY KEY (`route_id`),
  ADD KEY `FK_5eo11xvknik08acd9yf00tk3m` (`ship_id`);

--
-- Indizes für die Tabelle `ship`
--
ALTER TABLE `ship`
  ADD PRIMARY KEY (`ship_id`);

--
-- Indizes für die Tabelle `ship_cabin`
--
ALTER TABLE `ship_cabin`
  ADD PRIMARY KEY (`cabintype_id`,`ship_id`),
  ADD KEY `FK_gxage9ims9dwhbkqil0yf2lo3` (`cabintype_id`),
  ADD KEY `FK_jjyak37by0el0rp11y50x43bg` (`ship_id`);

--
-- Indizes für die Tabelle `travellers`
--
ALTER TABLE `travellers`
  ADD PRIMARY KEY (`travellers_id`),
  ADD KEY `FK_crs72dgt06b77cgp66selnslk` (`reservation_id`);

--
-- Indizes für die Tabelle `trip`
--
ALTER TABLE `trip`
  ADD PRIMARY KEY (`trip_id`),
  ADD KEY `FK_s4ko1vtxs899mjxg184p9t2aa` (`route_id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT für Tabelle `reservation`
--
ALTER TABLE `reservation`
  MODIFY `reservation_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `travellers`
--
ALTER TABLE `travellers`
  MODIFY `travellers_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `FK_7yej2c8cslyb8r4okfwlassa3` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `FK_ketteu8uj8e50ls6ocde9mhi9` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`trip_id`);

--
-- Constraints der Tabelle `reservation_cabin`
--
ALTER TABLE `reservation_cabin`
  ADD CONSTRAINT `FK_94ojnx00xkk14nkcisnwtb25p` FOREIGN KEY (`cabintype_id`) REFERENCES `cabintype` (`cabintype_id`),
  ADD CONSTRAINT `FK_oyh0a3r8sik3nk2ak282bbx6h` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`reservation_id`);

--
-- Constraints der Tabelle `route`
--
ALTER TABLE `route`
  ADD CONSTRAINT `FK_5eo11xvknik08acd9yf00tk3m` FOREIGN KEY (`ship_id`) REFERENCES `ship` (`ship_id`);

--
-- Constraints der Tabelle `ship_cabin`
--
ALTER TABLE `ship_cabin`
  ADD CONSTRAINT `FK_gxage9ims9dwhbkqil0yf2lo3` FOREIGN KEY (`cabintype_id`) REFERENCES `cabintype` (`cabintype_id`),
  ADD CONSTRAINT `FK_jjyak37by0el0rp11y50x43bg` FOREIGN KEY (`ship_id`) REFERENCES `ship` (`ship_id`);

--
-- Constraints der Tabelle `travellers`
--
ALTER TABLE `travellers`
  ADD CONSTRAINT `FK_crs72dgt06b77cgp66selnslk` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`reservation_id`);

--
-- Constraints der Tabelle `trip`
--
ALTER TABLE `trip`
  ADD CONSTRAINT `FK_s4ko1vtxs899mjxg184p9t2aa` FOREIGN KEY (`route_id`) REFERENCES `route` (`route_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
