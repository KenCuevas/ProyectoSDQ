SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_BuscarInformacio` ()  BEGIN 
	   SELECT IdPersonas,Nombre,Apellido FROM persona;
End$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_BuscarInformacion` ()  begin
		Select IdPersonas,Nombre,Apellido from persona;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_BuscarInformaciones` ()  BEGIN 
	   SELECT IdPersonas,Nombre,Apellido FROM persona;
End$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_SearchInfo` ()  begin
		Select IdPersonas,Nombre,Apellido from persona;
end$$

DELIMITER ;

CREATE TABLE `persona` (
  `IdPersonas` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellido` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `persona` VALUES(1, 'Kenny', 'Cuevas');
INSERT INTO `persona` VALUES(7, 'kenny', 'alberto');
INSERT INTO `persona` VALUES(12, 'Jean', 'Blue');


ALTER TABLE `persona`
  ADD PRIMARY KEY (`IdPersonas`);


ALTER TABLE `persona`
  MODIFY `IdPersonas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
