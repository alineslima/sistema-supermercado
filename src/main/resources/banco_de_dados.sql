CREATE SCHEMA `mercado` DEFAULT CHARACTER SET utf8 ;

USE mercado;

CREATE TABLE IF NOT EXISTS `mercado`.`Cliente` (
  `cpf` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `data_aniversario` DATE NOT NULL,
  PRIMARY KEY (`cpf`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mercado`.`Produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo_barra` VARCHAR(100) NOT NULL,
  `nome_produto` VARCHAR(100) NOT NULL,
  `descrição_produto` VARCHAR(200) NOT NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `quantidade` DECIMAL(6,3) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mercado`.`Venda` (
  `id_venda` INT NOT NULL AUTO_INCREMENT,
  `Cliente_cpf` INT NULL,
  `data_venda` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id_venda`),
  INDEX `fk_Venda_Cliente_idx` (`Cliente_cpf` ASC) VISIBLE,
  CONSTRAINT `fk_Venda_Cliente`
    FOREIGN KEY (`Cliente_cpf`)
    REFERENCES `mercado`.`Cliente` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mercado`.`Venda_Produto` (
  `Venda_id_venda` INT NOT NULL,
  `Produto_id` INT NOT NULL,
  `quantidade_produto_vendido` DECIMAL(6,3) NOT NULL,
  PRIMARY KEY (`Venda_id_venda`, `Produto_id`),
  INDEX `fk_Venda_has_Produto_Produto1_idx` (`Produto_id` ASC) VISIBLE,
  INDEX `fk_Venda_has_Produto_Venda1_idx` (`Venda_id_venda` ASC) VISIBLE,
  CONSTRAINT `fk_Venda_has_Produto_Venda1`
    FOREIGN KEY (`Venda_id_venda`)
    REFERENCES `mercado`.`Venda` (`id_venda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_has_Produto_Produto1`
    FOREIGN KEY (`Produto_id`)
    REFERENCES `mercado`.`Produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;