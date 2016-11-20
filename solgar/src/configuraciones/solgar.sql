-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-11-2016 a las 20:12:13
-- Versión del servidor: 5.6.24
-- Versión de PHP: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `solgar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `abonos`
--

CREATE TABLE IF NOT EXISTS `abonos` (
  `id` int(11) NOT NULL,
  `recepcion_id` int(11) NOT NULL,
  `abono` float NOT NULL,
  `fecha` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aparatos`
--

CREATE TABLE IF NOT EXISTS `aparatos` (
  `id` int(11) NOT NULL,
  `tipo_aparato_id` int(11) NOT NULL,
  `cliente_id` int(11) NOT NULL,
  `descripcion` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `id` int(11) NOT NULL,
  `doc_identida` varchar(11) NOT NULL,
  `cliente` varchar(30) NOT NULL,
  `telefono1` varchar(16) NOT NULL,
  `telefono2` varchar(16) DEFAULT NULL,
  `direccion` varchar(250) NOT NULL,
  `correo` varchar(60) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `doc_identida`, `cliente`, `telefono1`, `telefono2`, `direccion`, `correo`) VALUES
(1, 'V-19725538', 'Isaac', '04243466689', '04124907297', 'por alli', 'isaacseijas7@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entregas`
--

CREATE TABLE IF NOT EXISTS `entregas` (
  `id` int(11) NOT NULL,
  `recepcion_id` int(11) NOT NULL,
  `fecha_entrega` date NOT NULL,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(1, 'admin'),
(2, 'user');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recepciones`
--

CREATE TABLE IF NOT EXISTS `recepciones` (
  `id` int(11) NOT NULL,
  `cliente_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `fecha_recepcion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reparaciones`
--

CREATE TABLE IF NOT EXISTS `reparaciones` (
  `id` int(11) NOT NULL,
  `recepcion_id` int(11) NOT NULL,
  `aparato_id` int(11) NOT NULL,
  `observacion` varchar(150) NOT NULL,
  `precio_repustos` float NOT NULL,
  `precio_mano_obra` float NOT NULL,
  `reparacion` varchar(150) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `repuestos`
--

CREATE TABLE IF NOT EXISTS `repuestos` (
  `id` int(11) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `repuesto` varchar(60) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio_venta` double NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `tipo_aparato_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `repuestos_usados`
--

CREATE TABLE IF NOT EXISTS `repuestos_usados` (
  `id` int(11) NOT NULL,
  `repuesto_id` int(11) NOT NULL,
  `reparacion_id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipos_aparato`
--

CREATE TABLE IF NOT EXISTS `tipos_aparato` (
  `id` int(11) NOT NULL,
  `tipo` varchar(60) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipos_aparato`
--

INSERT INTO `tipos_aparato` (`id`, `tipo`) VALUES
(1, 'Ventilador'),
(2, 'Licuadora');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL,
  `cedula` int(8) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `telefono` int(11) NOT NULL,
  `email` varchar(35) NOT NULL,
  `direccion` varchar(60) NOT NULL,
  `login` varchar(10) NOT NULL,
  `clave` varchar(10) NOT NULL,
  `nivele_usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `abonos`
--
ALTER TABLE `abonos`
  ADD PRIMARY KEY (`id`), ADD KEY `recepcion_id` (`recepcion_id`);

--
-- Indices de la tabla `aparatos`
--
ALTER TABLE `aparatos`
  ADD PRIMARY KEY (`id`), ADD KEY `tipo_aparato_id` (`tipo_aparato_id`), ADD KEY `cliente_id` (`cliente_id`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `cedula` (`doc_identida`);

--
-- Indices de la tabla `entregas`
--
ALTER TABLE `entregas`
  ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `recepcion_id` (`recepcion_id`), ADD KEY `usuario_id` (`usuario_id`);

--
-- Indices de la tabla `niveles_usuario`
--
ALTER TABLE `niveles_usuario`
  ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `nivel` (`nivel`);

--
-- Indices de la tabla `recepciones`
--
ALTER TABLE `recepciones`
  ADD PRIMARY KEY (`id`), ADD KEY `cliente_id` (`cliente_id`,`usuario_id`), ADD KEY `usuario_id` (`usuario_id`);

--
-- Indices de la tabla `reparaciones`
--
ALTER TABLE `reparaciones`
  ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `recepcion` (`aparato_id`), ADD KEY `recepcion_id` (`recepcion_id`), ADD KEY `equipo_id` (`aparato_id`);

--
-- Indices de la tabla `repuestos`
--
ALTER TABLE `repuestos`
  ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `codigo` (`codigo`), ADD KEY `tipo_aparato_id` (`tipo_aparato_id`);

--
-- Indices de la tabla `repuestos_usados`
--
ALTER TABLE `repuestos_usados`
  ADD PRIMARY KEY (`id`), ADD KEY `reparacion_id` (`reparacion_id`), ADD KEY `repuesto_id` (`repuesto_id`);

--
-- Indices de la tabla `tipos_aparato`
--
ALTER TABLE `tipos_aparato`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `login` (`login`), ADD KEY `nivele_usuario_id` (`nivele_usuario_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `abonos`
--
ALTER TABLE `abonos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `aparatos`
--
ALTER TABLE `aparatos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `entregas`
--
ALTER TABLE `entregas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `niveles_usuario`
--
ALTER TABLE `niveles_usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `recepciones`
--
ALTER TABLE `recepciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `reparaciones`
--
ALTER TABLE `reparaciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `repuestos`
--
ALTER TABLE `repuestos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `repuestos_usados`
--
ALTER TABLE `repuestos_usados`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `tipos_aparato`
--
ALTER TABLE `tipos_aparato`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `abonos`
--
ALTER TABLE `abonos`
ADD CONSTRAINT `abonos_ibfk_1` FOREIGN KEY (`recepcion_id`) REFERENCES `reparaciones` (`id`);

--
-- Filtros para la tabla `aparatos`
--
ALTER TABLE `aparatos`
ADD CONSTRAINT `aparatos_ibfk_1` FOREIGN KEY (`tipo_aparato_id`) REFERENCES `tipos_aparato` (`id`),
ADD CONSTRAINT `aparatos_ibfk_2` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`);

--
-- Filtros para la tabla `entregas`
--
ALTER TABLE `entregas`
ADD CONSTRAINT `entregas_ibfk_1` FOREIGN KEY (`recepcion_id`) REFERENCES `reparaciones` (`id`),
ADD CONSTRAINT `entregas_ibfk_2` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `recepciones`
--
ALTER TABLE `recepciones`
ADD CONSTRAINT `recepciones_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`),
ADD CONSTRAINT `recepciones_ibfk_2` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `reparaciones`
--
ALTER TABLE `reparaciones`
ADD CONSTRAINT `reparaciones_ibfk_1` FOREIGN KEY (`recepcion_id`) REFERENCES `recepciones` (`id`),
ADD CONSTRAINT `reparaciones_ibfk_2` FOREIGN KEY (`aparato_id`) REFERENCES `aparatos` (`id`);

--
-- Filtros para la tabla `repuestos`
--
ALTER TABLE `repuestos`
ADD CONSTRAINT `repuestos_ibfk_1` FOREIGN KEY (`tipo_aparato_id`) REFERENCES `tipos_aparato` (`id`);

--
-- Filtros para la tabla `repuestos_usados`
--
ALTER TABLE `repuestos_usados`
ADD CONSTRAINT `repuestos_usados_ibfk_1` FOREIGN KEY (`reparacion_id`) REFERENCES `reparaciones` (`id`),
ADD CONSTRAINT `repuestos_usados_ibfk_2` FOREIGN KEY (`repuesto_id`) REFERENCES `repuestos` (`id`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`nivele_usuario_id`) REFERENCES `niveles_usuario` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
