CREATE TABLE tb_usuario (
      id BIGINT NOT NULL DEFAULT nextval('usuario_seq'),
      nome VARCHAR(255) NOT NULL,
      cpf VARCHAR(11) NOT NULL,
      login VARCHAR(255) NOT NULL,
      senha VARCHAR(255) NOT NULL
);

CREATE TABLE tb_livro (
     id BIGINT NOT NULL DEFAULT nextval('livro_seq'),
     titulo VARCHAR(255) NOT NULL,
     autor VARCHAR(255) NOT NULL,
     data_publicacao DATE,
     editora VARCHAR(255) NOT NULL
);

CREATE SEQUENCE livro_seq
    START WITH 1

CREATE SEQUENCE usuario_seq
    START WITH 1
    