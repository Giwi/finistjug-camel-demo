SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `FinistJug` ;
CREATE SCHEMA IF NOT EXISTS `FinistJug` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `FinistJug` ;

-- -----------------------------------------------------
-- Table `FinistJug`.`JugPresentation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FinistJug`.`JugPresentation` ;

CREATE  TABLE IF NOT EXISTS `FinistJug`.`JugPresentation` (
  `id` INT NOT NULL ,
  `title` VARCHAR(254) NOT NULL ,
  `description` TEXT NULL ,
  `url` VARCHAR(254) NULL ,
  `presentationDate` DATETIME NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FinistJug`.`Participant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FinistJug`.`Participant` ;

CREATE  TABLE IF NOT EXISTS `FinistJug`.`Participant` (
  `id` INT NOT NULL ,
  `name` VARCHAR(45) NULL ,
  `forname` VARCHAR(45) NULL ,
  `email` VARCHAR(45) NULL ,
  `pres_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Participant_JugPresentation` (`pres_id` ASC) ,
  CONSTRAINT `fk_Participant_JugPresentation`
    FOREIGN KEY (`pres_id` )
    REFERENCES `FinistJug`.`JugPresentation` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
