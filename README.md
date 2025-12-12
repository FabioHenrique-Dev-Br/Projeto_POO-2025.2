# Projeto_POO-2025.2
Biblioteca

📚 Sistema de Biblioteca – SimpleLibrary

Este é um projeto simples de banco de dados para gerenciamento de uma biblioteca.
O objetivo é demonstrar a criação do banco, suas entidades, relacionamentos e alguns dados iniciais.

✔ Funcionalidades do Sistema

O sistema permite:

1. Cadastro de autores
Nome
Nacionalidade

2. Cadastro de livros
Título
Ano de publicação
Gênero
Associação com autor

3. Cadastro de usuários
Nome
E-mail

4. Registro de empréstimos
Qual usuário pegou o livro
Qual livro foi emprestado
Data do empréstimo
Data da devolução (opcional)
Status (EMPRESTADO / DEVOLVIDO)

🗂 Modelo Entidade-Relacionamento (DER)
A estrutura do banco é composta por quatro tabelas:

autores (1) → (N) livros
usuarios (1) → (N) emprestimos
livros (1) → (N) emprestimos


![Diagrama do Banco](diagrama.png)
