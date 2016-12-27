-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-12-2016 a las 03:40:47
-- Versión del servidor: 5.6.26
-- Versión de PHP: 5.5.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_sologar`
--
DROP DATABASE `bd_sologar`;
CREATE DATABASE IF NOT EXISTS `bd_sologar` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bd_sologar`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `id` int(11) NOT NULL,
  `doc_identidad` varchar(11) NOT NULL,
  `cliente` varchar(60) NOT NULL,
  `telefono1` varchar(16) NOT NULL,
  `telefono2` varchar(16) NOT NULL,
  `direccion` varchar(250) NOT NULL,
  `email` varchar(60) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `doc_identidad`, `cliente`, `telefono1`, `telefono2`, `direccion`, `email`) VALUES
(1, '6331034', 'Jairo Molina', '(0416)-942-12-12', '(0246)-433-60-80', 'Sector Nueva Esperanza, calle 2, N°8, Zona Industrial', 'profesor@jairomolina.com.ve');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `niveles_usuario`
--

CREATE TABLE IF NOT EXISTS `niveles_usuario` (
  `id` int(11) NOT NULL,
  `nivel` varchar(12) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `niveles_usuario`
--

INSERT INTO `niveles_usuario` (`id`, `nivel`) VALUES
(1, 'ADMIN'),
(2, 'USER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recepciones`
--

CREATE TABLE IF NOT EXISTS `recepciones` (
  `id` int(11) NOT NULL,
  `cliente_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `fecha_recepcion` date NOT NULL,
  `fecha_entrega` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `recepciones`
--

INSERT INTO `recepciones` (`id`, `cliente_id`, `usuario_id`, `fecha_recepcion`, `fecha_entrega`) VALUES
(1, 1, 1, '2016-12-23', '2016-12-31'),
(3, 1, 7, '2016-12-23', '2016-12-31'),
(4, 1, 7, '2016-12-23', '2016-12-31'),
(5, 1, 7, '2016-12-24', '2016-12-31'),
(6, 1, 7, '2016-12-24', '2016-12-31');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reparaciones`
--

CREATE TABLE IF NOT EXISTS `reparaciones` (
  `id` int(11) NOT NULL,
  `recepcion_id` int(11) NOT NULL,
  `tipo_aparato_id` int(11) NOT NULL,
  `diagnostico_cliente` varchar(150) COLLATE utf8_swedish_ci NOT NULL,
  `detalles_recepcion` varchar(150) COLLATE utf8_swedish_ci NOT NULL,
  `diagnostico_tecnico` varchar(150) COLLATE utf8_swedish_ci NOT NULL,
  `precio_repuestos` double NOT NULL,
  `precio_mano_obra` double NOT NULL,
  `detalles_reparacion` varchar(150) COLLATE utf8_swedish_ci NOT NULL,
  `status` varchar(1) COLLATE utf8_swedish_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;

--
-- Volcado de datos para la tabla `reparaciones`
--

INSERT INTO `reparaciones` (`id`, `recepcion_id`, `tipo_aparato_id`, `diagnostico_cliente`, `detalles_recepcion`, `diagnostico_tecnico`, `precio_repuestos`, `precio_mano_obra`, `detalles_reparacion`, `status`) VALUES
(1, 1, 1, 'es muy lento y se recalienta', 'no tiene el botón encendido', 'cambio bocina', 1, 1, 'null', 'P'),
(2, 1, 2, 'no gira la cuchilla', 'el cable esta despegado', 'cambio de base y cable AC', 1, 1, 'null', 'P'),
(3, 3, 3, 'AAA', 'AAA', 'AAA', 111, 111, 'null', 'P'),
(4, 3, 4, 'DD', 'DD', 'DDD', 44, 44, 'null', 'P'),
(5, 4, 2, '1', '1', '1', 1, 1, 'null', 'P'),
(6, 5, 1, 'NO ENCIENDE', 'SIN ASPA', 'CAMBIO DE BOCINA Y ASPA NUEVA', 10000, 12000, 'null', 'P'),
(7, 1, 3, 'No Calienta', 'sin detalles', 'revisión resistencia', 3000, 5000, '', ''),
(8, 1, 4, 'no prende', 'sin detalles', 'cambiar carbones', 3500, 4000, '', ''),
(9, 6, 1, 'NO ENCIENDE', 'SIN DETALLES', 'CAMBIO DEL MOTOR', 18000, 15000, 'null', 'P'),
(10, 6, 2, 'ECHA HUMO', 'SIN BOTÓN', 'CAMBIO CARBONES Y BOTÓN DE ENCENDIDO', 12000, 5000, 'null', 'P');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipos_aparato`
--

CREATE TABLE IF NOT EXISTS `tipos_aparato` (
  `id` int(11) NOT NULL,
  `tipo` varchar(60) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipos_aparato`
--

INSERT INTO `tipos_aparato` (`id`, `tipo`) VALUES
(1, 'VENTILADOR'),
(2, 'LICUADORA'),
(3, 'PLANCHA'),
(4, 'SECADOR');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL,
  `cedula` varchar(10) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `login` varchar(10) NOT NULL,
  `clave` varchar(10) NOT NULL,
  `nivele_usuario_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `cedula`, `nombre`, `apellido`, `telefono`, `email`, `direccion`, `login`, `clave`, `nivele_usuario_id`) VALUES
(1, '12345678', 'ERICK', 'GUERRA', '(0414)-123-45-78', 'erick.guerra.ing@gmail.com', 'la morera', 'admin', '3dgplq', 1),
(2, '6331034', 'JAIRO', 'MOLINA', '(0416)-942-12-12', 'profesor@jairomolina.com.ve', 'SAN JUAN\n', 'jams', '9sjv|', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `doc_identidad` (`doc_identidad`);

--
-- Indices de la tabla `niveles_usuario`
--
ALTER TABLE `niveles_usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `recepciones`
--
ALTER TABLE `recepciones`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `reparaciones`
--
ALTER TABLE `reparaciones`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipos_aparato`
--
ALTER TABLE `tipos_aparato`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `cedula` (`cedula`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `niveles_usuario`
--
ALTER TABLE `niveles_usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `recepciones`
--
ALTER TABLE `recepciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `reparaciones`
--
ALTER TABLE `reparaciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT de la tabla `tipos_aparato`
--
ALTER TABLE `tipos_aparato`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
