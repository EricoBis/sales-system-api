DROP TABLE tb_product IF EXISTS;
DROP TABLE tb_storage_item IF EXISTS;

CREATE TABLE tb_product (
                            price float(53) not null,
                            id bigint not null,
                            description varchar(255),
                            image varchar(255),
                            primary key (id)
);
CREATE TABLE tb_storage_item (
                                 current_quantity integer,
                                 max_quantity integer,
                                 min_quantity integer,
                                 id bigint not null,
                                 product_id bigint,
                                 primary key (id)
);

INSERT INTO tb_product (id, description, price, image) VALUES
                                                           (1, 'A Culpa é das Estrelas', 15.99, 'https://m.media-amazon.com/images/I/51M9IbBqxCL._AC_UF1000,1000_QL80_.jpg'),
                                                           (2, 'O Senhor dos Anéis', 19.99, 'https://m.media-amazon.com/images/I/514M+qMYWSL.jpg'),
                                                           (3, '1984', 12.99, 'https://m.media-amazon.com/images/I/819js3EQwbL._AC_UF1000,1000_QL80_.jpg'),
                                                           (4, 'A Maldição do Tigre', 14.99, 'https://m.media-amazon.com/images/I/91DtQRLD4KL._AC_UF1000,1000_QL80_.jpg'),
                                                           (5, 'Dom Quixote', 10.99, 'https://m.media-amazon.com/images/I/51XULadddlL.jpg'),
                                                           (6, 'Os Pilares da Terra', 18.99, 'https://m.media-amazon.com/images/I/51vZQqJpILL.jpg'),
                                                           (7, 'Percy Jackson e o Ladrão de Raios', 9.99, 'https://m.media-amazon.com/images/I/A1UjcPz4gZL._AC_UF1000,1000_QL80_.jpg'),
                                                           (8, 'O Hobbit', 8.99, 'https://m.media-amazon.com/images/I/91M9xPIf10L._AC_UF1000,1000_QL80_FMwebp_.jpg'),
                                                           (9, 'O Homem de Giz', 7.99, 'https://m.media-amazon.com/images/I/91o6FMAy8UL._AC_UF1000,1000_QL80_FMwebp_.jpg'),
                                                           (10, 'Tomie - volume 1', 11.99, 'https://m.media-amazon.com/images/I/91rIZ7DoKpL._AC_UF1000,1000_QL80_FMwebp_.jpg'),
                                                           (11, 'Boa Noite Punpun - 1', 9.99, 'https://m.media-amazon.com/images/I/51EQ5jMPsHL._AC_UF1000,1000_QL80_FMwebp_.jpg'),
                                                           (12, 'Os Sete Maridos de Evelyn Hugo', 14.99, 'https://m.media-amazon.com/images/I/91yEPgRcELL._AC_UF1000,1000_QL80_FMwebp_.jpg'),
                                                           (13, 'A Garota do Lago', 10.99, 'https://m.media-amazon.com/images/I/81LRk6+p1HL._AC_UF1000,1000_QL80_FMwebp_.jpg'),
                                                           (14, 'O Conto da Aia', 12.99, 'https://m.media-amazon.com/images/I/91AHNAr638L._AC_UF1000,1000_QL80_FMwebp_.jpg'),
                                                           (15, 'O Código da Vinci', 13.99, ''),
                                                           (16, 'Orgulho e Preconceito', 16.99, ''),
                                                           (17, 'A Guerra dos Tronos', 22.99, '');



INSERT INTO tb_storage_item (id, product_id, current_quantity, min_quantity, max_quantity)
VALUES
    (1, 1, 0, 10, 100), -- A Culpa é das Estrelas (Livro 1)
    (2, 2, 60, 12, 120), -- O Senhor dos Anéis (Livro 2)
    (3, 3, 45, 9, 90),   -- 1984 (Livro 3)
    (4, 4, 55, 11, 110), -- A Maldição do Tigre (Livro 4)
    (5, 5, 75, 15, 150), -- Dom Quixote (Livro 5)
    (6, 6, 35, 7, 70),   -- Os Pilares da Terra (Livro 6)
    (7, 7, 40, 8, 80),   -- Percy Jackson e o Ladrão de Raios (Livro 7)
    (8, 8, 30, 6, 60),   -- O Hobbit (Livro 8)
    (9, 9, 25, 5, 50),   -- O Homem de Giz (Livro 9)
    (10, 10, 65, 13, 130), -- Tomie - volume 1 (Livro 10)
    (11, 11, 55, 11, 110), -- Boa Noite Punpun - 1 (Livro 11)
    (12, 12, 70, 14, 140), -- Os Sete Maridos de Evelyn Hugo (Livro 12)
    (13, 13, 60, 12, 120), -- A Garota do Lago (Livro 13)
    (14, 14, 70, 14, 140), -- O Conto da Aia (Livro 14)
    (15, 15, 80, 16, 160), -- O Código da Vinci (Livro 15)
    (16, 16, 90, 18, 180), -- Orgulho e Preconceito (Livro 16)
    (17, 17, 100, 20, 200); -- A Guerra dos Tronos (Livro 17)

