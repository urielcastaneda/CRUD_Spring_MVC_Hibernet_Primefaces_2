SET time_zone = "-05:00";

-- Creación de la base de datos AGENDA  incorporando el juego 
-- Juego de de caracteres   utf8_spanish_ci
-- NOTA: En caso de ya tener creada la Base de datos o las tablas,
-- marcar como comentario la(s) linea(s) que incluye el comando para 
-- borrado y creación, según la necesidad

--
-- Base de datos: agenda
--

CREATE DATABASE agenda CHARACTER SET utf8 COLLATE utf8_spanish_ci;

-- Seleccionamos la Nueva Base de datos
-- se posiciona el control sobre dicha base
USE agenda;

-- Creación de la tabla Contacto
-- Primero borramos la tabla anterior en caso que 
-- esta exista y requiera ser borrada.
--
-- DROP TABLE IF EXISTS contacto;

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla contacto
--

CREATE TABLE IF NOT EXISTS contacto (
  id int(11) NOT NULL AUTO_INCREMENT,
  nombre varchar(100) NOT NULL,
  descripcion text NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY nombre (nombre)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `contacto`
--

INSERT INTO contacto (id, nombre, descripcion) VALUES
(1, 'uriel', 'Quien ha estado programando este ejercicio'),
(2, 'carlos', 'es el hermano mayor y vive en utica'),
(3, 'bertilda', 'es nuestra mamá, ella es el eje de toda la familia'),
(4, 'matias', 'vive en guaduas, es un niño muy pilo'),
(5, 'esperanza', 'es mi hermanita más linda, desde el cielo nos acompaña');

