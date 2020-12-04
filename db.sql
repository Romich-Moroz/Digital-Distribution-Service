-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema InternetShop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema InternetShop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `InternetShop` DEFAULT CHARACTER SET utf8 ;
USE `InternetShop` ;

-- -----------------------------------------------------
-- Table `InternetShop`.`AccessRights`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `InternetShop`.`AccessRights` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `AccessType` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idAccessRights_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InternetShop`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `InternetShop`.`Users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idAccessRights` INT UNSIGNED NOT NULL DEFAULT 2,
  `Login` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(255) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idUser_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `Username_UNIQUE` (`Login` ASC) VISIBLE,
  INDEX `idAccessRights_idx` (`idAccessRights` ASC) VISIBLE,
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) VISIBLE,
  CONSTRAINT `idAccessRights`
    FOREIGN KEY (`idAccessRights`)
    REFERENCES `InternetShop`.`AccessRights` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InternetShop`.`Blacklist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `InternetShop`.`Blacklist` (
  `idUser` INT NOT NULL,
  `Reason` VARCHAR(255) NOT NULL,
  UNIQUE INDEX `idUser_UNIQUE` (`idUser` ASC),
  CONSTRAINT `idUser`
    FOREIGN KEY (`idUser`)
    REFERENCES `InternetShop`.`Users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InternetShop`.`Developers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `InternetShop`.`Developers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Developer` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idDeveloper_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InternetShop`.`Genres`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `InternetShop`.`Genres` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Genre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `Genre_UNIQUE` (`Genre` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InternetShop`.`Games`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `InternetShop`.`Games` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idGenre` INT NOT NULL,
  `idDeveloper` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Description` TEXT NOT NULL,
  `Price` FLOAT NOT NULL,
  `IsSelling` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idGame_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `idDeveloper_idx` (`idDeveloper` ASC) VISIBLE,
  INDEX `idGenre_idx` (`idGenre` ASC) VISIBLE,
  CONSTRAINT `idDeveloper`
    FOREIGN KEY (`idDeveloper`)
    REFERENCES `InternetShop`.`Developers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idGenre`
    FOREIGN KEY (`idGenre`)
    REFERENCES `InternetShop`.`Genres` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InternetShop`.`GameCopy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `InternetShop`.`GameCopy` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idGame` INT NOT NULL,
  `GameKey` VARCHAR(30) NOT NULL,
  INDEX `idGame_idx` (`idGame` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `idGame`
    FOREIGN KEY (`idGame`)
    REFERENCES `InternetShop`.`Games` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InternetShop`.`Ownership`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `InternetShop`.`Ownership` (
  `idUser` INT NOT NULL,
  `idGameCopy` INT NOT NULL,
  `date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  INDEX `idUser_idx` (`idUser` ASC) VISIBLE,
  INDEX `idOwnedCopy_idx` (`idGameCopy` ASC) VISIBLE,
  CONSTRAINT `idExistingUser`
    FOREIGN KEY (`idUser`)
    REFERENCES `InternetShop`.`Users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idOwnedCopy`
    FOREIGN KEY (`idGameCopy`)
    REFERENCES `InternetShop`.`GameCopy` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `InternetShop`.`AccessRights`
-- -----------------------------------------------------
START TRANSACTION;
USE `InternetShop`;
INSERT INTO `InternetShop`.`AccessRights` (`id`, `AccessType`) VALUES (1, 'admin');
INSERT INTO `InternetShop`.`AccessRights` (`id`, `AccessType`) VALUES (2, 'user');

COMMIT;


-- -----------------------------------------------------
-- Data for table `InternetShop`.`Users`
-- -----------------------------------------------------
START TRANSACTION;
USE `InternetShop`;
INSERT INTO `InternetShop`.`Users` (`id`, `idAccessRights`, `Login`, `Password`, `Email`) VALUES (1, 1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin@podval.com');
INSERT INTO `InternetShop`.`Users` (`id`, `idAccessRights`, `Login`, `Password`, `Email`) VALUES (2, 2, 'test', '098f6bcd4621d373cade4e832627b4f6', 'test@gmail.com');
INSERT INTO `InternetShop`.`Users` (`id`, `idAccessRights`, `Login`, `Password`, `Email`) VALUES (3, 2, 'banned', '0dd544ca4ccb44f6ed5cf12555859eb7', 'banned@gmail.com');

COMMIT;


-- -----------------------------------------------------
-- Data for table `InternetShop`.`Blacklist`
-- -----------------------------------------------------
START TRANSACTION;
USE `InternetShop`;
INSERT INTO `InternetShop`.`Blacklist` (`idUser`, `Reason`) VALUES (3, 'Banned for test purposes');

COMMIT;


-- -----------------------------------------------------
-- Data for table `InternetShop`.`Developers`
-- -----------------------------------------------------
START TRANSACTION;
USE `InternetShop`;
INSERT INTO `InternetShop`.`Developers` (`id`, `Developer`) VALUES (1, 'Bethesda');
INSERT INTO `InternetShop`.`Developers` (`id`, `Developer`) VALUES (2, 'Activision');
INSERT INTO `InternetShop`.`Developers` (`id`, `Developer`) VALUES (3, 'Blizzard');
INSERT INTO `InternetShop`.`Developers` (`id`, `Developer`) VALUES (4, 'Valve');
INSERT INTO `InternetShop`.`Developers` (`id`, `Developer`) VALUES (5, 'Electronic Arts');
INSERT INTO `InternetShop`.`Developers` (`id`, `Developer`) VALUES (6, 'CD Projekt RED');
INSERT INTO `InternetShop`.`Developers` (`id`, `Developer`) VALUES (7, 'From Software');
INSERT INTO `InternetShop`.`Developers` (`id`, `Developer`) VALUES (8, 'TaleWorlds Entertainment');
INSERT INTO `InternetShop`.`Developers` (`id`, `Developer`) VALUES (9, 'id Software');

COMMIT;


-- -----------------------------------------------------
-- Data for table `InternetShop`.`Genres`
-- -----------------------------------------------------
START TRANSACTION;
USE `InternetShop`;
INSERT INTO `InternetShop`.`Genres` (`id`, `Genre`) VALUES (1, 'Action');
INSERT INTO `InternetShop`.`Genres` (`id`, `Genre`) VALUES (2, 'Strategy');
INSERT INTO `InternetShop`.`Genres` (`id`, `Genre`) VALUES (3, 'RPG');
INSERT INTO `InternetShop`.`Genres` (`id`, `Genre`) VALUES (4, 'Simulation');
INSERT INTO `InternetShop`.`Genres` (`id`, `Genre`) VALUES (5, 'Racing');
INSERT INTO `InternetShop`.`Genres` (`id`, `Genre`) VALUES (6, 'Casual');
INSERT INTO `InternetShop`.`Genres` (`id`, `Genre`) VALUES (7, 'Indie');
INSERT INTO `InternetShop`.`Genres` (`id`, `Genre`) VALUES (8, 'MMO');
INSERT INTO `InternetShop`.`Genres` (`id`, `Genre`) VALUES (9, 'Adventure');
INSERT INTO `InternetShop`.`Genres` (`id`, `Genre`) VALUES (10, 'Horror');

COMMIT;


-- -----------------------------------------------------
-- Data for table `InternetShop`.`Games`
-- -----------------------------------------------------
START TRANSACTION;
USE `InternetShop`;
INSERT INTO `InternetShop`.`Games` (`id`, `idGenre`, `idDeveloper`, `Name`, `Description`, `Price`, `IsSelling`) VALUES (1, 1, 6, 'Cyberpunk 2077', 'Игра года 12/10', 59.99, DEFAULT);
INSERT INTO `InternetShop`.`Games` (`id`, `idGenre`, `idDeveloper`, `Name`, `Description`, `Price`, `IsSelling`) VALUES (2, 1, 9, 'DOOM Eternal', 'Лучшая христианская игра десятилетия', 59.99, DEFAULT);
INSERT INTO `InternetShop`.`Games` (`id`, `idGenre`, `idDeveloper`, `Name`, `Description`, `Price`, `IsSelling`) VALUES (3, 3, 6, 'Ведьмак 3: Дикая Охота', '120/10 купи сейчас же', 29.99, DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `InternetShop`.`GameCopy`
-- -----------------------------------------------------
START TRANSACTION;
USE `InternetShop`;
INSERT INTO `InternetShop`.`GameCopy` (`id`, `idGame`, `GameKey`) VALUES (1, 1, 'AK48D-WN2JD-VMZK1-EKDLS-BNVJE');
INSERT INTO `InternetShop`.`GameCopy` (`id`, `idGame`, `GameKey`) VALUES (2, 2, 'DOOM-ETER-NALL-2020');
INSERT INTO `InternetShop`.`GameCopy` (`id`, `idGame`, `GameKey`) VALUES (3, 1, 'SMDKW-ZXC-WE-CVBCVB-ADAWD');
INSERT INTO `InternetShop`.`GameCopy` (`id`, `idGame`, `GameKey`) VALUES (4, 2, 'EMKWE-ASDWQZ-XCBCVB-DFGDFGA');
INSERT INTO `InternetShop`.`GameCopy` (`id`, `idGame`, `GameKey`) VALUES (5, 3, 'QWE-ASDZ-XCZBVC-CVBCVBSD-QW');
INSERT INTO `InternetShop`.`GameCopy` (`id`, `idGame`, `GameKey`) VALUES (6, 3, 'AMKF-WQE-ASDAD-ZXCZB-FBFGB');
INSERT INTO `InternetShop`.`GameCopy` (`id`, `idGame`, `GameKey`) VALUES (7, 3, 'QWE-ASDASD-FGHFGH-CVBCBF-DF');
INSERT INTO `InternetShop`.`GameCopy` (`id`, `idGame`, `GameKey`) VALUES (8, 3, 'BNMB-FGHFGH-RTYRTH-ASDQWE');

COMMIT;


-- -----------------------------------------------------
-- Data for table `InternetShop`.`Ownership`
-- -----------------------------------------------------
START TRANSACTION;
USE `InternetShop`;
INSERT INTO `InternetShop`.`Ownership` (`idUser`, `idGameCopy`, `date`) VALUES (2, 2, DEFAULT);

COMMIT;

