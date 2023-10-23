DROP TABLE product IF EXISTS;
CREATE TABLE product (
    id FLOAT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

-- Inserir um livro chamado "O Senhor dos Anéis" com preço de R$ 29.99
INSERT INTO product (id, description, price) VALUES (1, 'O Senhor dos Anéis', 29.99);

-- Inserir um livro chamado "Harry Potter e a Pedra Filosofal" com preço de R$ 19.99
INSERT INTO product (id, description, price) VALUES (2, 'Harry Potter e a Pedra Filosofal', 19.99);

-- Inserir um livro chamado "1984" com preço de R$ 15.50
INSERT INTO product (id, description, price) VALUES (3, '1984', 15.50);

-- Inserir um livro chamado "Dom Quixote" com preço de R$ 24.75
INSERT INTO product (id, description, price) VALUES (4, 'Dom Quixote', 24.75);

-- Inserir um livro chamado "Moby Dick" com preço de R$ 22.99
INSERT INTO product (id, description, price) VALUES (5, 'Moby Dick', 22.99);

-- Inserir um e-book "Introdução à Inteligência Artificial" com preço de R$ 14.99
INSERT INTO product (id, description, price) VALUES (6, 'Introdução à Inteligência Artificial (e-book)', 14.99);

-- Inserir um caderno de anotações "Papelaria Bonito" com preço de R$ 7.50
INSERT INTO product (id, description, price) VALUES (7, 'Caderno de Anotações "Papelaria Bonito"', 7.50);

-- Inserir um marcador de página "Estrelas Cintilantes" com preço de R$ 1.99
INSERT INTO product (id, description, price) VALUES (8, 'Marcador de Página "Estrelas Cintilantes"', 1.99);

-- Inserir um conjunto de canetas coloridas com preço de R$ 12.99
INSERT INTO product (id, description, price) VALUES (9, 'Conjunto de Canetas Coloridas', 12.99);

-- Inserir um quebra-cabeça "Paisagem Montanhosa" com preço de R$ 19.99
INSERT INTO product (id, description, price) VALUES (10, 'Quebra-Cabeça "Paisagem Montanhosa"', 19.99);

-- Inserir uma caneca "Leitura Relaxante" com preço de R$ 8.75
INSERT INTO product (id, description, price) VALUES (11, 'Caneca "Leitura Relaxante"', 8.75);

-- Inserir um mapa-múndi decorativo com preço de R$ 34.50
INSERT INTO product (id, description, price) VALUES (12, 'Mapa-Múndi Decorativo', 34.50);

-- Inserir um jogo de xadrez "Elegância Real" com preço de R$ 44.99
INSERT INTO product (id, description, price) VALUES (13, 'Jogo de Xadrez "Elegância Real"', 44.99);

-- Inserir um estojo de lápis "Cores Vibrantes" com preço de R$ 6.25
INSERT INTO product (id, description, price) VALUES (14, 'Estojo de Lápis "Cores Vibrantes"', 6.25);

-- Inserir um conjunto de marcadores "Arte Moderna" com preço de R$ 9.99
INSERT INTO product (id, description, price) VALUES (15, 'Conjunto de Marcadores "Arte Moderna"', 9.99);

-- Inserir um álbum de fotos "Memórias Inesquecíveis" com preço de R$ 16.75
INSERT INTO product (id, description, price) VALUES (16, 'Álbum de Fotos "Memórias Inesquecíveis"', 16.75);

-- Inserir um globo terrestre "Educação Global" com preço de R$ 29.99
INSERT INTO product (id, description, price) VALUES (17, 'Globo Terrestre "Educação Global"', 29.99);

-- Inserir um quebra-cabeça 3D "Modelo de Nave Espacial" com preço de R$ 18.50
INSERT INTO product (id, description, price) VALUES (18, 'Quebra-Cabeça 3D "Modelo de Nave Espacial"', 18.50);

-- Inserir um conjunto de lápis de cor "Arte Criativa" com preço de R$ 11.99
INSERT INTO product (id, description, price) VALUES (19, 'Conjunto de Lápis de Cor "Arte Criativa"', 11.99);

-- Inserir um relógio de parede "Tempo para Ler" com preço de R$ 24.50
INSERT INTO product (id, description, price) VALUES (20, 'Relógio de Parede "Tempo para Ler"', 24.50);
