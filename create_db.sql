CREATE SCHEMA `hotel_db`;

USE `hotel_db`;

CREATE TABLE tipoquarto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(200),
    preco DOUBLE
);

CREATE TABLE quarto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero INT,
    id_tipo INT,
    FOREIGN KEY (id_tipo) REFERENCES tipo_quarto(id)
);

CREATE TABLE hospede (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200),
    cpf CHAR(11),
    telefone CHAR(12)
);

CREATE TABLE reserva (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data_check_in TIMESTAMP,
    data_check_out TIMESTAMP NULL,
    id_hospede INT,
    id_quarto INT,
    FOREIGN KEY (id_hospede) REFERENCES hospedes(id),
    FOREIGN KEY (id_quarto) REFERENCES quarto(id),
    CONSTRAINT unique_active_reservation UNIQUE (id_quarto, data_check_out)
);

INSERT INTO hospede (nome, cpf, telefone) VALUES
('João Silva', '12345678901', '11987654321'),
('Maria Oliveira', '23456789012', '11976543210'),
('Carlos Souza', '34567890123', '11965432109'),
('Ana Costa', '45678901234', '11954321098'),
('Pedro Santos', '56789012345', '11943210987'),
('Laura Lima', '67890123456', '11932109876'),
('Lucas Pereira', '78901234567', '11921098765'),
('Fernanda Almeida', '89012345678', '11910987654'),
('Ricardo Rocha', '90123456789', '11909876543'),
('Juliana Martins', '01234567890', '11998765432');

INSERT INTO tipoquarto (descricao, preco) VALUES
('Quarto para 1 pessoa', 120.00),
('Quarto para 2 pessoas solteiras', 150.00),
('Quarto para casal', 180.00),
('Quarto para casal e até 2 filhos', 210.00);

INSERT INTO quarto (numero, id_tipo) VALUES
(1, 1), (2, 1), (3, 1), (4, 1), (5, 1), (6, 1), (7, 1), (8, 1), (9, 1), (10, 1), -- Quarto para 1 pessoa
(11, 2), (12, 2), (13, 2), (14, 2), (15, 2), (16, 2), (17, 2), (18, 2), (19, 2), (20, 2), -- Quarto para 2 pessoas solteiras
(21, 3), (22, 3), (23, 3), (24, 3), (25, 3), (26, 3), (27, 3), (28, 3), (29, 3), (30, 3), -- Quarto para casal
(31, 4), (32, 4), (33, 4), (34, 4), (35, 4), (36, 4), (37, 4), (38, 4), (39, 4), (40, 4); -- Quarto para casal e até 2 filhos


