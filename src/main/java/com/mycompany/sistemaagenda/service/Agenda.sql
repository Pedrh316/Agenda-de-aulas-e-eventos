-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `us_email` VARCHAR(100) NOT NULL,
  `us_nome` VARCHAR(100) NOT NULL,
  `us_senha` VARCHAR(45) NOT NULL,
  `us_admin` TINYINT NOT NULL,
  PRIMARY KEY (`us_email`),
  UNIQUE INDEX `us_senha_UNIQUE` (`us_senha` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`evento` (
  `ev_data_hora` DATETIME NOT NULL,
  `ev_sala` INT NOT NULL,
  `ev_nome` VARCHAR(45) NOT NULL,
  `ev_palestrante` VARCHAR(45) NOT NULL,
  `ev_inscricao` INT NULL,
  PRIMARY KEY (`ev_data_hora`, `ev_sala`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usuario_evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuario_evento` (
  `us_email` VARCHAR(100) NOT NULL,
  `ev_data_hora` DATETIME NOT NULL,
  `ev_sala` INT NOT NULL,
  `us_ev_inscricao_paga` TINYINT NULL,
  PRIMARY KEY (`us_email`, `ev_data_hora`, `ev_sala`),
  INDEX `fk_usuario_has_evento_evento1_idx` (`ev_data_hora` ASC, `ev_sala` ASC) VISIBLE,
  INDEX `fk_usuario_has_evento_usuario_idx` (`us_email` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_has_evento_usuario`
    FOREIGN KEY (`us_email`)
    REFERENCES `mydb`.`usuario` (`us_email`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_usuario_has_evento_evento1`
    FOREIGN KEY (`ev_data_hora` , `ev_sala`)
    REFERENCES `mydb`.`evento` (`ev_data_hora` , `ev_sala`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
