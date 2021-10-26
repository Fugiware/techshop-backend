DROP DATABASE IF EXISTS techshop; 
CREATE DATABASE techshop;
USE techshop;

CREATE TABLE estado (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(255) NOT NULL,
	sigla CHAR(2) NOT NULL
);

CREATE TABLE cidade (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(255) NOT NULL,
	estado_ID INT NOT NULL,
	FOREIGN KEY (estado_ID) REFERENCES estado(id)
);

CREATE TABLE usuario (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	senha VARCHAR(255) NOT NULL,
	tipo ENUM('CLIENTE', 'VENDEDOR', 'ADMINISTRADOR') NOT NULL,
	cpf VARCHAR(20) NOT NULL,
	rg VARCHAR(20) NOT NULL
);

CREATE TABLE endereco (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	cep VARCHAR(255) NOT NULL,
	bairro VARCHAR(255) NOT NULL,
	logradouro VARCHAR(255) NOT NULL,
	numero_residencia INT NOT NULL,
	complemento VARCHAR(255) NOT NULL,
	cidade_ID INT NOT NULL,
	usuario_ID INT NOT NULL,
	FOREIGN KEY (cidade_ID) REFERENCES cidade(id),
	FOREIGN KEY (usuario_ID) REFERENCES usuario(id)
);

CREATE TABLE venda (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	data_venda DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    valor_total DECIMAL(12,2) NOT NULL,
    valor_desconto DECIMAL(12,2) NOT NULL,
	usuario_ID INT NOT NULL,
	FOREIGN KEY (usuario_ID) REFERENCES usuario(id)
);

CREATE TABLE pagamento (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	data_pagamento DATETIME NOT NULL,
	tipo_pagamento ENUM('BOLETO', 'CARTAO', 'PIX')  NOT NULL,
    valor DECIMAL(12,2) NOT NULL,
    estado_pagamento ENUM('EM_ESPERA','RECUSADO','APROVADO') NOT NULL,
	venda_ID INT NOT NULL,
	FOREIGN KEY (venda_ID) REFERENCES venda(id)
);

CREATE TABLE categoria (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(255) NOT NULL
);

CREATE TABLE produto (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(255) NOT NULL,
	descricao VARCHAR(5000) NOT NULL,
    valor DECIMAL(12,2) NOT NULL,
	estoque INT NOT NULL,
	categoria_ID INT NOT NULL,
	usuario_ID INT NOT NULL,
	FOREIGN KEY (categoria_ID) REFERENCES categoria(id),
	FOREIGN KEY (usuario_ID) REFERENCES usuario(id)
);

CREATE TABLE imagem (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	url VARCHAR(5000) NOT NULL,
    produto_ID INT NOT NULL,
	FOREIGN KEY (produto_ID) REFERENCES produto(id)
);

CREATE TABLE promocao (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	data_inicio DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	data_fim DATETIME NOT NULL,
    valor_desconto DECIMAL(12,2) NOT NULL,
	produto_ID INT NOT NULL,
	FOREIGN KEY (produto_ID) REFERENCES produto(id)
);

CREATE TABLE produto_venda (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,  
    quantidade INT NOT NULL,
    valor DECIMAL(12,2) NOT NULL,
	valor_desconto DECIMAL(12,2) NOT NULL,
	venda_ID INT NOT NULL,
	produto_ID INT NOT NULL,
	promocao_ID INT,
	FOREIGN KEY (venda_ID) REFERENCES venda(id),
	FOREIGN KEY (produto_ID) REFERENCES produto(id),
	FOREIGN KEY (promocao_ID) REFERENCES promocao(id)
);

CREATE TABLE avaliacao (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	pontuacao INT NOT NULL,
	comentario VARCHAR(5000) NOT NULL,
	produto_ID INT NOT NULL,
	usuario_ID INT NOT NULL,
	FOREIGN KEY (produto_ID) REFERENCES produto(id),
	FOREIGN KEY (usuario_ID) REFERENCES usuario(id)
);
