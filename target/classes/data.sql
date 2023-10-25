DROP TABLE tb_product IF EXISTS;
DROP TABLE tb_storage_item IF EXISTS;

CREATE TABLE tb_product (
                            price float(53) not null,
                            id bigint not null,
                            description varchar(255),
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

INSERT INTO tb_product (id, description, price) VALUES
                                                    (1, 'A Culpa é das Estrelas', 15.99),
                                                    (2, 'O Senhor dos Anéis', 19.99),
                                                    (3, '1984', 12.99),
                                                    (4, 'A Maldição do Tigre', 14.99),
                                                    (5, 'Dom Quixote', 10.99),
                                                    (6, 'Os Pilares da Terra', 18.99),
                                                    (7, 'Percy Jackson e o Ladrão de Raios', 9.99),
                                                    (8, 'O Código da Vinci', 13.99),
                                                    (9, 'Orgulho e Preconceito', 16.99),
                                                    (10, 'A Guerra dos Tronos', 22.99);

INSERT INTO tb_storage_item (id, product_id, current_quantity, min_quantity, max_quantity)
VALUES
    (1, 1, 100, 20, 200), -- A Culpa é das Estrelas (Livro 1)
    (2, 2, 75, 15, 150),  -- O Senhor dos Anéis (Livro 2)
    (3, 3, 50, 10, 100),  -- 1984 (Livro 3)
    (4, 4, 60, 12, 120),  -- A Maldição do Tigre (Livro 4)
    (5, 5, 90, 18, 180),  -- Dom Quixote (Livro 5)
    (6, 6, 40, 8, 80),    -- Os Pilares da Terra (Livro 6)
    (7, 7, 55, 11, 110),  -- Percy Jackson e o Ladrão de Raios (Livro 7)
    (8, 8, 30, 6, 60),    -- O Código da Vinci (Livro 8)
    (9, 9, 70, 14, 140),  -- Orgulho e Preconceito (Livro 9)
    (10, 10, 85, 17, 170); -- A Guerra dos Tronos (Livro 10)
