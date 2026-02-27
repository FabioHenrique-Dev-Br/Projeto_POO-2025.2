CREATE DATABASE IF NOT EXISTS simplelibrary;
USE simplelibrary;

-- Se for recriar do zero sem erro:
DROP TABLE IF EXISTS emprestimos;
DROP TABLE IF EXISTS livros;
DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS autores;

-- AUTORES
CREATE TABLE autores (
    id_autor INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    nacionalidade VARCHAR(50)
);

-- LIVROS
CREATE TABLE livros (
    id_livro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    ano_publicacao INT,
    genero VARCHAR(50),
    status VARCHAR(20) DEFAULT 'DISPONIVEL',
    id_autor INT,
    FOREIGN KEY (id_autor) REFERENCES autores(id_autor)
);

-- USUARIOS
CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    status VARCHAR(20) DEFAULT 'ATIVO'
);

-- EMPRESTIMOS
CREATE TABLE emprestimos (
    id_emprestimo INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_livro INT NOT NULL,
    data_emprestimo DATE NOT NULL DEFAULT (CURRENT_DATE),
    data_prevista_devolucao DATE NOT NULL,
    data_devolucao DATE,
    status VARCHAR(20) DEFAULT 'EMPRESTADO',
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_livro) REFERENCES livros(id_livro)
);