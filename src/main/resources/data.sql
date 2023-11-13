DROP TABLE tb_product IF EXISTS;
DROP TABLE tb_storage_item IF EXISTS;
DROP TABLE tb_budget IF EXISTS;
DROP TABLE tb_order_item IF EXISTS;
DROP TABLE tb_client IF EXISTS;

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

CREATE TABLE tb_order_item (
                            id bigint not null,
                            product_id bigint,
                            amount integer,
                            primary key (id)
);

CREATE TABLE tb_budget (
                            id bigint not null,
                            id_client bigint not null,
                            order_cost float(53),
                            tax_cost float(53),
                            discount float(53),
                            total_cost float(53),
                            done boolean,
                            date_time timestamp(6),
                            expiration_date timestamp(6),
                            primary key (id)
);

CREATE TABLE tb_client (
                            id bigint not null,
                            name varchar(100) not null,
                            email varchar(100) not null,
                            password varchar(100) not null,
                            role varchar(20) not null,
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
                                                           (15, 'Relatos de um Gato Viajante', 13.99, 'https://m.media-amazon.com/images/I/81a9krs52mL._AC_UF1000,1000_QL80_.jpg'),
                                                           (16, 'Pessoas Normais', 16.99, 'https://m.media-amazon.com/images/I/41jXtkfq49L.jpg'),
                                                           (17, 'A Guerra dos Tronos', 22.99, 'https://m.media-amazon.com/images/I/91+1SUO3vUL._AC_UF1000,1000_QL80_.jpg'),
                                                           (18, 'Alice no País das Maravilhas', 19.99, 'https://m.media-amazon.com/images/I/91hq-bopcvL._AC_UF1000,1000_QL80_.jpg'),
                                                           (19, 'O Jardim das Borboletas', 26.99, 'https://m.media-amazon.com/images/I/A142ngVX2rL._AC_UF1000,1000_QL80_.jpg');



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
    (17, 17, 100, 20, 200), -- A Guerra dos Tronos (Livro 17)
    (18, 18, 70, 20, 200),
    (19, 19, 70, 20, 200);

INSERT INTO tb_budget (id, id_client, order_cost, tax_cost, discount, total_cost, done, date_time, expiration_date)
VALUES
    (10, 1, 20000, 15, 0, 20015, TRUE, '2023-10-02 15:30:00', '2023-12-23 15:30:00'),
    (20, 1, 20000, 15, 0, 20015, TRUE, '2023-09-05 17:45:05', '2023-12-23 15:30:00'),
    (30, 1, 20000, 15, 0, 20015, TRUE, '2023-11-03 06:05:10', '2023-12-23 15:30:00'),
    (31, 2, 20000, 15, 0, 20015, TRUE, '2023-10-11 08:30:57', '2023-12-23 15:30:00'),
    (32, 2, 20000, 15, 0, 20015, TRUE, '2023-09-30 12:59:55', '2023-12-23 15:30:00'),
    (33, 2, 20000, 15, 0, 20015, TRUE, '2023-08-12 13:34:09', '2023-12-23 15:30:00'),
    (34, 2, 20000, 15, 0, 20015, TRUE, '2023-11-02 07:40:50', '2023-12-23 15:30:00'),
    (35, 2, 20000, 15, 0, 20015, TRUE, '2023-09-07 16:06:38', '2023-12-23 15:30:00'),
    (36, 2, 20000, 15, 0, 20015, TRUE, '2023-07-26 10:40:00', '2023-12-23 15:30:00'),
    (37, 2, 20000, 15, 0, 20015, TRUE, '2023-08-27 11:50:50', '2023-12-23 15:30:00'),
    (38, 2, 20000, 15, 0, 20015, TRUE, '2023-08-18 04:35:08', '2023-12-23 15:30:00'),
    (39, 2, 20000, 15, 0, 20015, TRUE, '2023-09-20 05:05:00', '2023-12-23 15:30:00'),
    (40, 2, 20000, 15, 0, 20015, TRUE, '2023-10-15 18:36:30', '2023-12-23 15:30:00'),
    (41, 2, 20000, 15, 0, 20015, TRUE, '2023-11-17 19:10:06', '2023-12-23 15:30:00'),
    (42, 2, 20000, 15, 0, 20015, TRUE, '2023-11-19 10:33:48', '2023-12-23 15:30:00'),
    (43, 2, 20000, 15, 0, 20015, TRUE, '2023-10-19 23:32:10', '2023-12-23 15:30:00'),
    (44, 3, 50000, 15, 0, 50015, TRUE, '2023-09-13 05:25:09', '2023-12-23 15:30:00'),
    (45, 3, 50000, 15, 0, 50015, TRUE, '2023-08-03 07:55:00', '2023-12-23 15:30:00'),
    (46, 3, 50000, 15, 0, 50015, TRUE, '2023-11-01 19:52:52', '2023-12-23 15:30:00'),
    (47, 3, 50000, 15, 0, 50015, TRUE, '2023-09-01 19:52:52', '2023-10-23 15:30:00');

INSERT INTO tb_client (id, name, email, password, role)
VALUES
    (2, 'Joao Almeida', 'joao.almeida@gmail.com', '$2a$10$7p4Fu/ZqWxz.RRVqHDLv6.yWFI9DZ/J4vUWXuTfiVQu9CK.zW7V82', 'USER'),
    (3, 'Maria Joaquina', 'maria.jo@gmail.com', '$2a$10$7p4Fu/ZqWxz.RRVqHDLv6.yWFI9DZ/J4vUWXuTfiVQu9CK.zW7V82', 'USER'),
    (4, 'Paula Duarte', 'p.duarte@gmail.com', '$2a$10$7p4Fu/ZqWxz.RRVqHDLv6.yWFI9DZ/J4vUWXuTfiVQu9CK.zW7V82', 'USER'),
    (5, 'Eduardo da Silva', 'eduardo.silva@gmail.com', '$2a$10$7p4Fu/ZqWxz.RRVqHDLv6.yWFI9DZ/J4vUWXuTfiVQu9CK.zW7V82', 'USER');