-- MySQL Script generated by MySQL Workbench
-- Fri Nov  3 17:13:35 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema easybuild
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema easybuild
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `easybuild` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `easybuild` ;

-- -----------------------------------------------------
-- Table `easybuild`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easybuild`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `sobrenome` VARCHAR(255) NULL DEFAULT NULL,
  `idade` INT NULL DEFAULT NULL,
  `endereco` VARCHAR(255) NULL DEFAULT NULL,
  `cpf` VARCHAR(14) NULL DEFAULT NULL,
  `venda_id` INT NULL DEFAULT NULL,
  `sexo` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cpf` (`cpf` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 29
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `easybuild`.`historico_venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easybuild`.`historico_venda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NULL DEFAULT NULL,
  `id_cliente` INT NULL DEFAULT NULL,
  `venda_id` INT NULL DEFAULT NULL,
  `valorTotal` VARCHAR(255) NULL DEFAULT NULL,
  `metodoPagamento` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `easybuild`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easybuild`.`venda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data_criacao` DATE NOT NULL,
  `status` VARCHAR(20) NOT NULL,
  `codigo` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 100
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `easybuild`.`produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easybuild`.`produtos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(200) NULL DEFAULT NULL,
  `marca` VARCHAR(200) NULL DEFAULT NULL,
  `quantidade` INT NULL DEFAULT NULL,
  `validade` VARCHAR(45) NULL DEFAULT NULL,
  `em_estoque` TINYINT NULL DEFAULT NULL,
  `preco` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 26
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `easybuild`.`item_venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easybuild`.`item_venda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `venda_id` INT NULL DEFAULT NULL,
  `produto_id` INT NULL DEFAULT NULL,
  `quantidade` INT NULL DEFAULT NULL,
  `descricao` VARCHAR(200) NULL DEFAULT NULL,
  `marca` VARCHAR(200) NULL DEFAULT NULL,
  `preco` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `venda_id` (`venda_id` ASC) VISIBLE,
  INDEX `produto_id` (`produto_id` ASC) VISIBLE,
  CONSTRAINT `carrinhoitem_ibfk_1`
    FOREIGN KEY (`venda_id`)
    REFERENCES `easybuild`.`venda` (`id`),
  CONSTRAINT `carrinhoitem_ibfk_2`
    FOREIGN KEY (`produto_id`)
    REFERENCES `easybuild`.`produtos` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 134
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;