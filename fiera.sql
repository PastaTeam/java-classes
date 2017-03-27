-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 27, 2017 at 09:45 AM
-- Server version: 5.5.54-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `fiera`
--

-- --------------------------------------------------------

--
-- Table structure for table `Aziende`
--

CREATE TABLE IF NOT EXISTS `Aziende` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` char(40) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `Aziende`
--

INSERT INTO `Aziende` (`ID`, `nome`, `email`, `password`) VALUES
(1, 'SchifoCorp Inc.', 'schifo@corp.com', '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8');

-- --------------------------------------------------------

--
-- Table structure for table `Commenti`
--

CREATE TABLE IF NOT EXISTS `Commenti` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `commento` varchar(256) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `prodotto` int(11) NOT NULL,
  `utente` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_commento_prodotto` (`prodotto`),
  KEY `fk_commento_utente` (`utente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `Commenti`
--

INSERT INTO `Commenti` (`ID`, `commento`, `timestamp`, `prodotto`, `utente`) VALUES
(1, 'Mamma mia che schifo!', '2017-03-27 09:25:30', 4, 2),
(2, 'Hai ragione, proprio schifo', '2017-03-27 09:25:41', 5, 1);

-- --------------------------------------------------------

--
-- Table structure for table `Prodotti`
--

CREATE TABLE IF NOT EXISTS `Prodotti` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `descrizione` varchar(256) NOT NULL,
  `azienda` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_prodotto_azienda` (`azienda`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `Prodotti`
--

INSERT INTO `Prodotti` (`ID`, `nome`, `descrizione`, `azienda`) VALUES
(4, 'SchifoProd 7', 'Lo SchifoProd 7 fa 7 volte schifo!', 1),
(5, 'SchifoProd 7 Plus', 'Ancora meglio dello Schifo Prod 7', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Utenti`
--

CREATE TABLE IF NOT EXISTS `Utenti` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cognome` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` char(40) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `Utenti`
--

INSERT INTO `Utenti` (`ID`, `nome`, `cognome`, `email`, `password`) VALUES
(1, 'Looca', 'Mimini', 'luk@gmail.com', '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8'),
(2, 'Alekos', 'Filini', 'alekos@gmail.com', '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Commenti`
--
ALTER TABLE `Commenti`
  ADD CONSTRAINT `fk_commento_utente` FOREIGN KEY (`utente`) REFERENCES `Utenti` (`ID`),
  ADD CONSTRAINT `fk_commento_prodotto` FOREIGN KEY (`prodotto`) REFERENCES `Prodotti` (`ID`);

--
-- Constraints for table `Prodotti`
--
ALTER TABLE `Prodotti`
  ADD CONSTRAINT `fk_prodotto_azienda` FOREIGN KEY (`azienda`) REFERENCES `Aziende` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
