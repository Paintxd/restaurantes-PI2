
CREATE SEQUENCE unidade_unidade_id_seq;

CREATE TABLE UNIDADE (
                UNIDADE_ID INTEGER NOT NULL DEFAULT nextval('unidade_unidade_id_seq'),
                SEGMENTO VARCHAR(100) NOT NULL,
                ENDERECO VARCHAR(400) NOT NULL,
                NOME VARCHAR(100) NOT NULL,
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

CREATE SEQUENCE estoque_estoque_id_seq;

CREATE TABLE ESTOQUE (
                ESTOQUE_ID INTEGER NOT NULL DEFAULT nextval('estoque_estoque_id_seq'),
                QTDE NUMERIC(5,2) NOT NULL,
                QTDE_MINIMA NUMERIC(5,2),
                DT_ATUALIZACAO TIMESTAMP NOT NULL,
                ITEM_ID INTEGER NOT NULL,
                CONSTRAINT estoque_id_pk PRIMARY KEY (ESTOQUE_ID)
);

CREATE TABLE ESTOQUE_CARDAPIO (
                ESTOQUE_CARDAPIO_ID SERIAL,
                ESTOQUE_ID INTEGER NOT NULL,
                CARDAPIO_ID INTEGER NOT NULL,
                QTDE NUMERIC(5,2) NOT NULL,
                CONSTRAINT estoque_cardapio_id_pk PRIMARY KEY (ESTOQUE_CARDAPIO_ID),
		CONSTRAINT estoque_cardapio_id_uk UNIQUE (ESTOQUE_ID, CARDAPIO_ID ),
                CONSTRAINT estoque_estoque_cardapio_fk FOREIGN KEY (ESTOQUE_ID) REFERENCES ESTOQUE,
                CONSTRAINT cardapio_estoque_cardapio_fk FOREIGN KEY (CARDAPIO_ID) REFERENCES CARDAPIO
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

CREATE TABLE USUARIO (
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
COMMENT ON COLUMN USUARIO.CPF IS 'IR?? GRAVAR A INFORMA????O DE IDENTIFICA????O DA PESSOA, CASO SEJA FISICA O CPF , CASO JURIDICA O CNPJ';


ALTER SEQUENCE pessoa_pessoa_seq OWNED BY USUARIO.USUARIO_ID;

CREATE SEQUENCE comanda_comanda_id_seq;

CREATE TABLE COMANDA (
                COMANDA_ID INTEGER NOT NULL DEFAULT nextval('comanda_comanda_id_seq'),
                DT_INIC TIMESTAMP NOT NULL,
                DT_ENCERRAMENTO TIMESTAMP,
                VLR_TOTAL DOUBLE PRECISION,
                USUARIO_ID INTEGER NOT NULL,
                CONSTRAINT comanda_id_pk PRIMARY KEY (COMANDA_ID)
);


ALTER SEQUENCE comanda_comanda_id_seq OWNED BY COMANDA.COMANDA_ID;

CREATE SEQUENCE pedido_pedido_id_seq;

CREATE TABLE PEDIDO (
                PEDIDO_ID INTEGER NOT NULL DEFAULT nextval('pedido_pedido_id_seq'),
                DT_INIC TIMESTAMP,
                APROVADO INTEGER NOT NULL,
                DT_FIM TIMESTAMP,
                COMANDA_ID INTEGER NOT NULL,
                USUARIO_ID_CLIENTE INTEGER NOT NULL,
                USUARIO_ID_FUNCIONARIO INTEGER NOT NULL,
                CONSTRAINT pedido_id_pk PRIMARY KEY (PEDIDO_ID)
);

CREATE TABLE CARDAPIO_PEDIDO (
                CARDAPIO_PEDIDO_ID SERIAL,
                CARDAPIO_ID INTEGER NOT NULL,
                PEDIDO_ID INTEGER NOT NULL,
                QTDE INTEGER NOT NULL,
                CONSTRAINT cardapio_pedido_id_pk PRIMARY KEY (CARDAPIO_PEDIDO_ID),
		CONSTRAINT cardapio_pedido_id_uk UNIQUE(CARDAPIO_ID, PEDIDO_ID ),
                CONSTRAINT cardapio_cardapio_pedido_fk FOREIGN KEY (CARDAPIO_ID) REFERENCES CARDAPIO,
                CONSTRAINT pedido_cardapio_pedido_fk FOREIGN KEY (PEDIDO_ID) REFERENCES PEDIDO
);


ALTER TABLE CARDAPIO ADD CONSTRAINT unidade_cardapio_fk
FOREIGN KEY (UNIDADE_ID)
REFERENCES UNIDADE (UNIDADE_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE ESTOQUE ADD CONSTRAINT item_estoque_fk
FOREIGN KEY (ITEM_ID)
REFERENCES ITEM (ITEM_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE USUARIO ADD CONSTRAINT tipo_pessoa_pessoa_fk
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
REFERENCES USUARIO (USUARIO_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE PEDIDO ADD CONSTRAINT usuario_pedido_fk1
FOREIGN KEY (USUARIO_ID_FUNCIONARIO)
REFERENCES USUARIO (USUARIO_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE COMANDA ADD CONSTRAINT usuario_comanda_fk
FOREIGN KEY (USUARIO_ID)
REFERENCES USUARIO (USUARIO_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE PEDIDO ADD CONSTRAINT comanda_pedido_fk
FOREIGN KEY (COMANDA_ID)
REFERENCES COMANDA (COMANDA_ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

INSERT INTO unidade (segmento, nome, endereco)
VALUES
    ('Shopping', 'Barzim do shops', 'Shopping da barra, Avenida Beria Rio, Florian??polis SC'),
    ('Tradicional', 'Restaurante do z??', 'Avenida Getulio Dorneles, Chapeco SC');

INSERT INTO cardapio (nome, vlr_preparo, tempo_preparo, unidade_id)
VALUES
    ('Coca cola 350 ml', 0, 0 , 1),
    ('Coca cola 350 ml', 0, 0 , 2);

INSERT INTO cardapio (nome, vlr_preparo, tempo_preparo, unidade_id)
VALUES
    ('Coca cola 600 ml', 0, 0 , 1),
    ('Coca cola 600 ml', 0, 0 , 2);

INSERT INTO cardapio (nome, vlr_preparo, tempo_preparo, unidade_id)
VALUES
    ('Hamburguer da Casa', 5, 15 , 1),
    ('Por????o de petiscos', 10, 20 , 2);

INSERT INTO tipo_pessoa (descricao) VALUES ('USUARIO'), ('FUNCIONARIO');

INSERT INTO usuario (nome, cpf, tppessoa_id, endereco, telefone, email, senha)
VALUES
    ('Jonathan da Cruz', '42720955019', 1, 'Avenida Beria Rio, Florian??polis SC', '049999763242', 'jonathan@jonathan.com.br', '$2a$12$MwYkus57CQgP0tCqHHuscOME1/Bg6axpXmVtmAiUiEu5egekNX6jS'),
    ('Joao Paulo', '64249420094', 2, 'Avenida Getulio Dorneles, Chapeco SC', '049899763242', 'joaopaulo@gmail.com', '$2a$12$uCwp8gfpl7BvPBfoBKqVUucRvjUGvKqWsGVm1LxaEJ1S7bjrwvPg2');

INSERT INTO fornecedor (nome_fantasia, responsavel, cnpj, dt_incl, inscricao_estadual, situacao)
VALUES
    ('Ambev', 'Joao Paulo', '71137756000125', NOW(), '7037800117', 1),
    ('Seara', 'Joao Paulo', '49319580000173', NOW(), '7477434051', 1);

INSERT INTO item (cd, descricao, unidade_medida, vlr, FORNECEDOR_ID)
VALUES
    (8744, 'Hamburguer Artesanal', 'UN', 6.5, 2),
    (8745, 'Coca cola 350 ml', 'UN', 2.5, 1);

INSERT INTO estoque (qtde, qtde_minima, dt_atualizacao, item_id)
VALUES
    (100, 80, now(), 1),
    (200, 150, now(), 2);

INSERT INTO estoque_cardapio (estoque_id, cardapio_id, qtde)  VALUES (2, 1, 1), (2, 2, 1);

INSERT INTO COMANDA (DT_INIC , dt_encerramento, vlr_total, usuario_id) VALUES (NOW() , NULL, NULL, 1);

INSERT INTO pedido (dt_inic, aprovado, dt_fim, comanda_id, usuario_id_cliente, usuario_id_funcionario)
VALUES (now(), 0, NULL, 1, 1, 2);

INSERT INTO cardapio_pedido (cardapio_id, pedido_id, qtde) values  (1, 1, 2);

/* STORED PROCEDURES
Chamar apenas fkg_gera_pedido e fkg_fecha_comanda
*/

CREATE OR REPLACE FUNCTION  fkg_val_estoque (en_unidade_id      int
										   , en_cardapio_id     int
										   , en_qtde_pedidos	int
 										   ) RETURNS int   AS $$
DECLARE
	vn_aux       int;
	vn_teste		int;
	vt_estoque   record;
BEGIN
	FOR i IN 1 .. en_qtde_pedidos loop

		    FOR vt_estoque IN SELECT ec.estoque_id
			     				   , ec.qtde
								  FROM cardapio c
								  JOIN estoque_cardapio ec  ON c.cardapio_id = ec.cardapio_id
								 WHERE c.unidade_id 	= en_unidade_id
								   AND c.cardapio_id 	= en_cardapio_id
			LOOP

			--Loop no estoque
			BEGIN
				SELECT 1
				  INTO vn_aux
				  FROM estoque e
				 WHERE e.estoque_id  = vt_estoque.estoque_id
				 AND e.qtde >= (vt_estoque.qtde ) ;

			EXCEPTION
			   WHEN no_data_found THEN
			      vn_aux := 0;
			  	  RAISE;
		    END;
			if vn_aux is null then
			   vn_aux := 0;
			end if;
		    -- Atualiza estoque
		    IF vn_aux =  1 THEN
		        BEGIN
			       UPDATE estoque SET qtde = qtde  - (vt_estoque.qtde)
			       WHERE estoque_id = vt_estoque.estoque_id ;

			    EXCEPTION
			       WHEN OTHERS THEN
			       RAISE;
			    END;
		    END IF;


		END LOOP;

	END LOOP;

	RETURN vn_aux;

EXCEPTION

   when others then
       raise notice 'The transaction is in an uncommittable state. '
                    'Transaction was rolled back';
       raise notice '% %', SQLERRM, SQLSTATE;
END;
$$ LANGUAGE plpgsql;

---------------
CREATE OR REPLACE FUNCTION  fkg_val_comanda ( en_usuario_id_clie      int ) RETURNS int   AS $$
DECLARE
	vn_comanda_id       int;
BEGIN

		SELECT ca.comanda_id ca
		 INTO vn_comanda_id
		  FROM comanda ca
		  WHERE ca.usuario_id = en_usuario_id_clie
		    AND ca.dt_encerramento  IS NULL ;
     IF NOT FOUND then
         INSERT INTO comanda  (dt_inic, dt_encerramento, vlr_total, usuario_id)
               VALUES ( now(), NULL, NULL, en_usuario_id_clie ) RETURNING comanda_id INTO vn_comanda_id ;
    END IF;

	RETURN vn_comanda_id;

EXCEPTION

   when others then
       raise notice 'The transaction is in an uncommittable state. '
                    'Transaction was rolled back';
       raise notice '% %', SQLERRM, SQLSTATE;
END;
$$ LANGUAGE plpgsql;




CREATE OR REPLACE FUNCTION  fkg_gera_pedido ( en_usuario_id_clie      int
											, en_usuario_id_func	  int
											, en_unidade_id			  int
											, en_cardapio_id		  int
											, en_qtde				  int
 											) RETURNS int   AS $$
DECLARE
	vn_pedido_id       int;
    vn_comanda_id	   int;
    vn_existe_estoque  int;
    vn_cardapio_id	int;
    vn_qtde			int := 0;
     

BEGIN
   --CONSULTA EXISTENCIA DA COMANDA, SE N??O CRIA NOVA
   SELECT FKG_VAL_COMANDA(en_usuario_id_clie) INTO vn_comanda_id;
   --VALIDA SE EXISTE ESTOQUE PARA PRODUZIR O PEDIDO, SE SIM J?? REALIZA UPDATE NO VALOR DO ESTOQUE E DIMINUI A QUANTIDADE
   SELECT FKG_VAL_ESTOQUE(en_unidade_id , en_cardapio_id, en_qtde) INTO vn_existe_estoque;
   --
   IF vn_existe_estoque = 1 THEN
      --CRIA REGISTRO DE PEDIDO
    
     SELECT  p.pedido_id
		INTO vn_pedido_id
        FROM pedido p 
        JOIN comanda c ON p.comanda_id  = c.comanda_id 
       WHERE p.dt_fim  IS NULL 
        AND p.usuario_id_cliente  = en_usuario_id_clie
        AND c.dt_encerramento  IS NULL
        ORDER BY p.pedido_id DESC 
        LIMIT 1;
       
       IF vn_pedido_id is NULL THEN 
       
   	     INSERT INTO pedido (dt_inic, aprovado, dt_fim, comanda_id, usuario_id_cliente, usuario_id_funcionario)
   	     VALUES
   	     (now(), 0, NULL, vn_comanda_id, en_usuario_id_clie, en_usuario_id_func) RETURNING pedido_id INTO vn_pedido_id;
   	     --GRAVA RELACAO DO PEDIDO COM O CARDAPIO E QUANTIDADE
   	  END IF;
   	 
   	  SELECT cp.cardapio_id 
   	       , cp.qtde
   	       INTO vn_cardapio_id
   	        , vn_qtde
   	     FROM cardapio_pedido  cp
   	     WHERE cp.cardapio_id  = en_cardapio_id
   	      AND cp.pedido_id  = vn_pedido_id;
   	     
   	  IF vn_cardapio_id IS NULL THEN 
   	     INSERT INTO cardapio_pedido (cardapio_id, pedido_id, qtde) VALUES (en_cardapio_id, vn_pedido_id, en_qtde);
   	  ELSE
   	     vn_qtde := vn_qtde + en_qtde;
   	     UPDATE cardapio_pedido SET qtde = vn_qtde
   	      WHERE cardapio_id  = vn_cardapio_id
   	      AND pedido_id  = vn_pedido_id;
   	     
   	  END IF;
   	  --
   	  --COMMIT;
   ELSE 
      vn_pedido_id := -2;
   END IF;
	 

   RETURN vn_pedido_id;

EXCEPTION

   when others then
       raise notice 'The transaction is in an uncommittable state. '
                    'Transaction was rolled back';
       raise notice '% %', SQLERRM, SQLSTATE;
END;
$$ LANGUAGE plpgsql;

------------------------------------------------
DROP FUNCTION fkg_fecha_comanda;

CREATE OR REPLACE FUNCTION  fkg_fecha_comanda (en_usuario_id_clie int) RETURNS int   AS $$
DECLARE
	vn_tot_pagar       float;
    vn_comanda_id	   int;
    vn_return	       int;

BEGIN
 SELECT sum( ( (i.vlr * ec.qtde ) + c2.vlr_preparo) *  cp.qtde )
      , c.comanda_id
     INTO vn_tot_pagar
        , vn_comanda_id
     FROM comanda c
     JOIN pedido  p           ON (c.usuario_id  = p.usuario_id_cliente AND c.comanda_id = p.comanda_id )
     JOIN cardapio_pedido cp  ON p.pedido_id    = cp.pedido_id
     JOIN cardapio c2         ON cp.cardapio_id = c2.cardapio_id
     JOIN estoque_cardapio ec ON c2.cardapio_id = ec.cardapio_id
     JOIN estoque e           ON ec.estoque_id  = e.estoque_id
     JOIN item i              ON e.item_id 	    = i.item_id
     WHERE c.usuario_id                         = en_usuario_id_clie
      AND p.aprovado 	                        = 2 --Pedido Aprovado
      AND c.dt_encerramento  IS NULL
    GROUP BY c.comanda_id; 

    IF vn_comanda_id IS NOT NULL THEN
       --
       UPDATE comanda  SET dt_encerramento = now()
                         , vlr_total 	   = vn_tot_pagar
       WHERE comanda_id  = vn_comanda_id;
       --
       vn_return := vn_comanda_id;
    ELSE
       vn_return := -1;-- 'N??o foi selecionada nenhuma comanda aberta para o usu??rio em quest??o!';
    END IF;

   RETURN  vn_return;

EXCEPTION

   when others then
       raise notice 'The transaction is in an uncommittable state. '
                    'Transaction was rolled back';
       raise notice '% %', SQLERRM, SQLSTATE;
END;
$$ LANGUAGE plpgsql;


CREATE INDEX idx_pedido_status ON pedido(comanda_id, aprovado);
CREATE INDEX idx_comanda_usuario ON comanda(usuario_id);
CREATE INDEX idx_usuario_email ON usuario (email);
CREATE INDEX idx_tppessoa_descricao ON tipo_pessoa(descricao);
CREATE INDEX idx_cardapio_unidade ON cardapio(unidade_id);
CREATE INDEX idx_usuario_tppessoa_email ON usuario(tppessoa_id, email);

	
	
