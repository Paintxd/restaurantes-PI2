
CREATE SEQUENCE unidade_unidade_id_seq;

CREATE TABLE UNIDADE (
                UNIDADE_ID INTEGER NOT NULL DEFAULT nextval('unidade_unidade_id_seq'),
                SEGMENTO VARCHAR(100) NOT NULL,
                CONSTRAINT unidade_id_pk PRIMARY KEY (UNIDADE_ID)
);


ALTER SEQUENCE unidade_unidade_id_seq OWNED BY UNIDADE.UNIDADE_ID;

CREATE SEQUENCE cardapio_cardapio_id_seq;

CREATE TABLE CARDAPIO (
                CARDAPIO_ID INTEGER NOT NULL DEFAULT nextval('cardapio_cardapio_id_seq'),
                NOME VARCHAR(150) NOT NULL,
                VLR_PREPARO DOUBLE PRECISION NOT NULL,
                TEMPO_PREPARO INTEGER NOT NULL,
                UNIDADE_ID INTEGER NOT NULL,
                CONSTRAINT cardapio_id_pk PRIMARY KEY (CARDAPIO_ID)
);


ALTER SEQUENCE cardapio_cardapio_id_seq OWNED BY CARDAPIO.CARDAPIO_ID;

CREATE SEQUENCE item_item_id_seq;

CREATE TABLE ITEM (
                ITEM_ID INTEGER NOT NULL DEFAULT nextval('item_item_id_seq'),
                CD INTEGER NOT NULL,
                DESCRICAO VARCHAR(100) NOT NULL,
                UNIDADE_MEDIDA VARCHAR(5) NOT NULL,
                VLR DOUBLE PRECISION NOT NULL,
                FORNECEDOR_ID INTEGER NOT NULL,
                CONSTRAINT item_id_pk PRIMARY KEY (ITEM_ID)
);


ALTER SEQUENCE item_item_id_seq OWNED BY ITEM.ITEM_ID;

CREATE SEQUENCE item_cardapio_itemcardapio_id_seq;

CREATE SEQUENCE item_cardapio_cardapio_id_seq;

CREATE TABLE ITEM_CARDAPIO (
                ITEMCARDAPIO_ID INTEGER NOT NULL DEFAULT nextval('item_cardapio_itemcardapio_id_seq'),
                QTDE INTEGER NOT NULL,
                CARDAPIO_ID INTEGER NOT NULL DEFAULT nextval('item_cardapio_cardapio_id_seq'),
                CONSTRAINT item_cardapio_id_pk PRIMARY KEY (ITEMCARDAPIO_ID)
);


ALTER SEQUENCE item_cardapio_itemcardapio_id_seq OWNED BY ITEM_CARDAPIO.ITEMCARDAPIO_ID;

ALTER SEQUENCE item_cardapio_cardapio_id_seq OWNED BY ITEM_CARDAPIO.CARDAPIO_ID;

CREATE SEQUENCE estoque_estoque_id_seq;

CREATE TABLE ESTOQUE (
                ESTOQUE_ID INTEGER NOT NULL DEFAULT nextval('estoque_estoque_id_seq'),
                QTDE INTEGER NOT NULL,
                QTDE_MINIMA INTEGER,
                DT_ENTRADA DATE NOT NULL,
                DT_TERMINO DATE,
                ITEM_ID INTEGER NOT NULL,
                CONSTRAINT estoque_id_pk PRIMARY KEY (ESTOQUE_ID)
);


ALTER SEQUENCE estoque_estoque_id_seq OWNED BY ESTOQUE.ESTOQUE_ID;

CREATE TABLE R_ESTOQUE_ITEMCARDAPIO (
                ESTOQUE_ID INTEGER NOT NULL,
                ITEMCARDAPIO_ID INTEGER NOT NULL,
                CONSTRAINT r_estoque_itemcardapio_id_pk PRIMARY KEY (ESTOQUE_ID, ITEMCARDAPIO_ID)
);


CREATE SEQUENCE fornecedor_fornecedor_id_seq;

CREATE TABLE FORNECEDOR (
                FORNECEDOR_ID INTEGER NOT NULL DEFAULT nextval('fornecedor_fornecedor_id_seq'),
                NOME_FANTASIA VARCHAR(300) NOT NULL,
                RESPONSAVEL VARCHAR(200) NOT NULL,
                DT_INCL DATE NOT NULL,
                CNPJ VARCHAR(14) NOT NULL,
                INSCRICAO_ESTADUAL VARCHAR(10),
                SITUACAO INTEGER NOT NULL,
                CONSTRAINT fornecedor_id_pk PRIMARY KEY (FORNECEDOR_ID)
);
COMMENT ON COLUMN FORNECEDOR.SITUACAO IS '1 - ATIVO
0 - INATIVO';


ALTER SEQUENCE fornecedor_fornecedor_id_seq OWNED BY FORNECEDOR.FORNECEDOR_ID;

CREATE SEQUENCE tipopessoa_tppessoa_seq;

CREATE TABLE TIPO_PESSOA (
                TPPESSOA_ID INTEGER NOT NULL DEFAULT nextval('tipopessoa_tppessoa_seq'),
                DESCRICAO VARCHAR(50) NOT NULL,
                CONSTRAINT tppessoa_id_pk PRIMARY KEY (TPPESSOA_ID)
);


ALTER SEQUENCE tipopessoa_tppessoa_seq OWNED BY TIPO_PESSOA.TPPESSOA_ID;

CREATE SEQUENCE pessoa_pessoa_seq;

CREATE TABLE usuario (
                USUARIO_ID INTEGER NOT NULL DEFAULT nextval('pessoa_pessoa_seq'),
                NOME VARCHAR NOT NULL,
                CPF VARCHAR(11) NOT NULL,
                TPPESSOA_ID INTEGER NOT NULL,
                ENDERECO VARCHAR(400) NOT NULL,
                TELEFONE VARCHAR(14),
                EMAIL VARCHAR(50),
                SENHA VARCHAR(150) NOT NULL,
                CONSTRAINT usuario_id_pk PRIMARY KEY (USUARIO_ID)
);
COMMENT ON COLUMN usuario.CPF IS 'IRÁ GRAVAR A INFORMAÇÃO DE IDENTIFICAÇÃO DA PESSOA, CASO SEJA FISICA O CPF , CASO JURIDICA O CNPJ';


ALTER SEQUENCE pessoa_pessoa_seq OWNED BY usuario.USUARIO_ID;

CREATE SEQUENCE comanda_comanda_id_seq;

CREATE TABLE COMANDA (
                COMANDA_ID INTEGER NOT NULL DEFAULT nextval('comanda_comanda_id_seq'),
                DT_INIC DATE NOT NULL,
                DT_ENCERRAMENTO DATE,
                VLR_TOTAL INTEGER,
                USUARIO_ID INTEGER NOT NULL,
                CONSTRAINT comanda_id_pk PRIMARY KEY (COMANDA_ID)
);


ALTER SEQUENCE comanda_comanda_id_seq OWNED BY COMANDA.COMANDA_ID;

CREATE SEQUENCE pedido_pedido_id_seq;

CREATE TABLE PEDIDO (
                PEDIDO_ID INTEGER NOT NULL DEFAULT nextval('pedido_pedido_id_seq'),
                DT_INIC DATE,
                APROVADO INTEGER NOT NULL,
                DT_FIM DATE,
                COMANDA_ID INTEGER NOT NULL,
                USUARIO_ID_CLIENTE INTEGER NOT NULL,
                USUARIO_ID_FUNCIONARIO INTEGER NOT NULL,
                CONSTRAINT pedido_id_pk PRIMARY KEY (PEDIDO_ID)
);


ALTER SEQUENCE pedido_pedido_id_seq OWNED BY PEDIDO.PEDIDO_ID;

CREATE TABLE R_CARDAPIO_PEDIDO (
                PEDIDO_ID INTEGER NOT NULL,
                CARDAPIO_ID INTEGER NOT NULL,
                CONSTRAINT r_cardapio_pedido_id_pk PRIMARY KEY (PEDIDO_ID, CARDAPIO_ID)
);


ALTER TABLE CARDAPIO ADD CONSTRAINT unidade_cardapio_fk
FOREIGN KEY (UNIDADE_ID)
REFERENCES UNIDADE (UNIDADE_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE R_CARDAPIO_PEDIDO ADD CONSTRAINT cardapio_r_cardapio_pedido_fk
FOREIGN KEY (CARDAPIO_ID)
REFERENCES CARDAPIO (CARDAPIO_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE ITEM_CARDAPIO ADD CONSTRAINT cardapio_item_cardapio_fk
FOREIGN KEY (CARDAPIO_ID)
REFERENCES CARDAPIO (CARDAPIO_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE ESTOQUE ADD CONSTRAINT item_estoque_fk
FOREIGN KEY (ITEM_ID)
REFERENCES ITEM (ITEM_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE R_ESTOQUE_ITEMCARDAPIO ADD CONSTRAINT item_cardapio_r_estoque_cardapio_fk
FOREIGN KEY (ITEMCARDAPIO_ID)
REFERENCES ITEM_CARDAPIO (ITEMCARDAPIO_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE R_ESTOQUE_ITEMCARDAPIO ADD CONSTRAINT estoque_r_estoque_cardapio_fk
FOREIGN KEY (ESTOQUE_ID)
REFERENCES ESTOQUE (ESTOQUE_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE usuario ADD CONSTRAINT tipo_pessoa_pessoa_fk
FOREIGN KEY (TPPESSOA_ID)
REFERENCES TIPO_PESSOA (TPPESSOA_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE ITEM ADD CONSTRAINT fornecedor_item_fk
FOREIGN KEY (FORNECEDOR_ID)
REFERENCES FORNECEDOR (FORNECEDOR_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE PEDIDO ADD CONSTRAINT usuario_pedido_fk
FOREIGN KEY (USUARIO_ID_CLIENTE)
REFERENCES usuario (USUARIO_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE PEDIDO ADD CONSTRAINT usuario_pedido_fk1
FOREIGN KEY (USUARIO_ID_FUNCIONARIO)
REFERENCES usuario (USUARIO_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE COMANDA ADD CONSTRAINT usuario_comanda_fk
FOREIGN KEY (USUARIO_ID)
REFERENCES usuario (USUARIO_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE PEDIDO ADD CONSTRAINT comanda_pedido_fk
FOREIGN KEY (COMANDA_ID)
REFERENCES COMANDA (COMANDA_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE R_CARDAPIO_PEDIDO ADD CONSTRAINT pedido_r_cardapio_pedido_fk
FOREIGN KEY (PEDIDO_ID)
REFERENCES PEDIDO (PEDIDO_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

INSERT INTO unidade (segmento) VALUES ('Shopping');
INSERT INTO unidade (segmento) VALUES ('Tradicional');
--
INSERT INTO cardapio (nome, vlr_preparo, tempo_preparo, unidade_id) VALUES
('Coca cola 350 ml', 0, 0 , 1)
,('Coca cola 350 ml', 0, 0 , 2);

INSERT INTO cardapio (nome, vlr_preparo, tempo_preparo, unidade_id) VALUES
('Coca cola 600 ml', 0, 0 , 1)
,('Coca cola 600 ml', 0, 0 , 2);

INSERT INTO cardapio (nome, vlr_preparo, tempo_preparo, unidade_id) VALUES
('Hamburguer da Casa', 5, 15 , 1)
,('Porção de petiscos', 10, 20 , 2);

INSERT INTO tipo_pessoa (descricao) VALUES ('USUARIO'), ('FUNCIONARIO');

INSERT INTO usuario (nome, cpf, tppessoa_id, endereco, telefone, email, senha)
VALUES
('Jonathan da Cruz', '42720955019', 1, 'Avenida Beria Rio, Florianópolis SC', '049999763242', 'jonathan@jonathan.com.br', '$2a$12$MwYkus57CQgP0tCqHHuscOME1/Bg6axpXmVtmAiUiEu5egekNX6jS'),
('Joao Paulo', '64249420094', 2, 'Avenida Getulio Dorneles, Chapeco SC', '049899763242', 'joaopaulo@gmail.com', '$2a$12$uCwp8gfpl7BvPBfoBKqVUucRvjUGvKqWsGVm1LxaEJ1S7bjrwvPg2');

INSERT INTO fornecedor (nome_fantasia, responsavel, cnpj, dt_incl, inscricao_estadual, situacao)
VALUES
    ('Ambev', 'Joao Paulo', '71137756000125', NOW(), '7037800117', 1),
    ('Seara', 'Joao Paulo', '49319580000173', NOW(), '7477434051', 1);

INSERT INTO item (cd, descricao, unidade_medida, vlr, FORNECEDOR_ID)
VALUES
    (8744, 'Hamburguer Artesanal', 'UN', 6.5, 2),
    (8745, 'Coca cola 350 ml', 'UN', 2.5, 1);
