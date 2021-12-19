-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-12-2021 a las 11:46:01
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `libros`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `id` int(3) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `autor` varchar(100) NOT NULL,
  `anyoNacimiento` varchar(10) NOT NULL,
  `anyoPublicacion` varchar(10) NOT NULL,
  `editorial` varchar(100) NOT NULL,
  `numPaginas` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`id`, `titulo`, `autor`, `anyoNacimiento`, `anyoPublicacion`, `editorial`, `numPaginas`) VALUES
(253, 'El señor de los anillos', 'J.R.R. Tolkien', '1890', '1950', 'Minotauro', '1392'),
(254, 'El juego de Ender', 'Orson Scott Card', '1951', '1977', 'Ediciones B', '509'),
(255, 'Lazarillo de Tormes', 'Anónimo', '', '1554', 'Clásicos Populares', '150'),
(256, 'Las uvas de la ira', 'John Steinbeck', '1902', '1939', 'Alianza', '619'),
(257, 'Watchmen', 'Alan Moore', '1953', '1980', 'ECC', '416'),
(258, 'La hoguera de las vanidades', 'Tom Wolfe', '1930', '1980', 'Anagrama', '636'),
(259, 'La familia de Pascual Duarte', 'Camilo José Cela', '1916', '1942', 'Destino', '165'),
(260, 'El señor de las moscas', 'William Golding', '1911', '1972', 'Alianza', '236'),
(261, 'La ciudad de los prodigios', 'Eduardo Mendoza', '1943', '1986', 'Seix Barral', '541'),
(262, 'Ensayo sobre la ceguera', 'José Saramago', '1922', '1995', 'Santillana', '439'),
(263, 'Los surcos del azar', 'Paco Roca', '1969', '2013', 'Astiberri', '349'),
(264, 'Ghosts of Spain', 'Giles Tremlett', '1962', '2006', 'Faber & Faber', '468'),
(265, 'Sidi', 'Arturo Pérez Reverte', '1951', '2019', 'Penguin', '369'),
(266, 'Dune', 'Frank Herbert', '1920', '1965', 'Acervo', '741'),
(267, 'Cancion de hielo y fuego', 'Leonardo', '1993', '2010', 'Santillana', '890'),
(268, 'Manual de supervivencia', 'Carlos Alberto', '1695', '2009', 'Castillo', '780'),
(269, 'Cancion de hielo y fuego', 'Leonardo', '1993', '2010', 'Santillana', '890'),
(270, 'Manual de supervivencia', 'Carlos Alberto', '1695', '2009', 'Castillo', '780');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `libros`
--
ALTER TABLE `libros`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=271;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
