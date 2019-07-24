--
-- Скрипт сгенерирован Devart dbForge Studio for MySQL, Версия 8.0.80.0
-- Домашняя страница продукта: http://www.devart.com/ru/dbforge/mysql/studio
-- Дата скрипта: 14.07.2019 22:56:30
-- Версия сервера: 5.7.25-log
-- Версия клиента: 4.1
--

-- 
-- Отключение внешних ключей
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Установить режим SQL (SQL mode)
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 
-- Установка кодировки, с использованием которой клиент будет посылать запросы на сервер
--
SET NAMES 'utf8';

DROP DATABASE IF EXISTS info;

CREATE DATABASE IF NOT EXISTS info
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Установка базы данных по умолчанию
--
USE info;

--
-- Создать таблицу `employee`
--
CREATE TABLE IF NOT EXISTS employee (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  email varchar(50) DEFAULT NULL,
  date_of_birth date NOT NULL
)
ENGINE = INNODB,
AUTO_INCREMENT = 4,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

-- 
-- Вывод данных для таблицы employee
--
INSERT INTO employee VALUES
(1, 'Alex', 'Strukov', 'asrtukov@.mail.ru', '2000-07-12'),
(2, 'Olga', 'Simakova', 'osimakova@mail.ru', '1995-03-04'),
(3, 'Rita', 'Nikolaeva', 'rnicol@mail.ru', '1990-11-01');

-- 
-- Восстановить предыдущий режим SQL (SQL mode)
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Включение внешних ключей
-- 
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;