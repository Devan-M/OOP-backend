-- Criação do banco de dados, se ainda não existir
CREATE DATABASE IF NOT EXISTS estoque_veiculo
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_general_ci;

USE estoque_veiculo;

-- Tabela de tipos de veículos (carro, moto, etc.)
CREATE TABLE IF NOT EXISTS tipo_veiculo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL UNIQUE,
    descricao TEXT
);

-- Tabela principal de veículos
CREATE TABLE IF NOT EXISTS veiculo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_id INT NOT NULL,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    ano_fabricacao INT NOT NULL,
    cor VARCHAR(30),
    quilometragem INT,
    preco DECIMAL(10,2) NOT NULL,
    status ENUM('disponível', 'vendido', 'reservado') DEFAULT 'disponível',
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (tipo_id) REFERENCES tipo_veiculo(id)
);

-- Tabela de histórico de alterações nos veículos
-- Se desejar ativar rastreabilidade no futuro, descomente a tabela abaixo
/*
CREATE TABLE IF NOT EXISTS usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha_hash VARCHAR(255) NOT NULL,
    perfil ENUM('admin', 'operador') DEFAULT 'operador'
);

CREATE TABLE IF NOT EXISTS historico_veiculo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    veiculo_id INT NOT NULL,
    usuario_id INT NOT NULL,
    campo_alterado VARCHAR(50),
    valor_antigo TEXT,
    valor_novo TEXT,
    data_alteracao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (veiculo_id) REFERENCES veiculo(id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
*/