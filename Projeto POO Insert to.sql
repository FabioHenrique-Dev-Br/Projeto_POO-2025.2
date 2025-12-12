USE simplelibrary;
-- AUTORES
INSERT INTO autores (nome, nacionalidade) VALUES
('Machado de Assis', 'Brasileiro'),
('J. K. Rowling', 'Britânica'),
('George Orwell', 'Britânico');

-- LIVROS
INSERT INTO livros (titulo, ano_publicacao, genero, id_autor) VALUES
('Dom Casmurro', 1899, 'Romance', 1),
('Harry Potter e a Pedra Filosofal', 1997, 'Fantasia', 2),
('1984', 1949, 'Distopia', 3);

-- USUARIOS
INSERT INTO usuarios (nome, email) VALUES
('Carlos Mendes', 'carlos@email.com'),
('Ana Paula', 'ana@email.com');

-- EMPRESTIMOS
INSERT INTO emprestimos (id_usuario, id_livro, data_emprestimo, status) VALUES
(1, 1, CURRENT_DATE, 'EMPRESTADO'),
(2, 3, CURRENT_DATE, 'EMPRESTADO');
