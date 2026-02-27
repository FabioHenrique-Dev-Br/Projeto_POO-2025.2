📚 Projeto_POO-2025.2
Sistema de Biblioteca – SimpleLibrary

Sistema simples de gerenciamento de biblioteca desenvolvido em Java (Swing + JDBC) com MySQL.

Projeto acadêmico da disciplina de Programação Orientada a Objetos.

🚀 Funcionalidades

Cadastro de usuários

Listagem de usuários

Cadastro de livros

Listagem de livros

Registro de empréstimos

Devolução de livros

Controle de status (DISPONIVEL / EMPRESTADO)

🛠 Tecnologias Utilizadas

Java

Swing (Interface gráfica)

JDBC

MySQL

DBeaver (modelagem e gerenciamento do banco)

Git & GitHub

🗄 Estrutura do Banco de Dados

O banco utilizado é:

simplelibrary

Tabelas:

autores

livros

usuarios

emprestimos

O script completo de criação do banco está em:

sql/criacao_banco.sql
⚙️ Como Executar o Projeto
1️⃣ Criar o Banco

No MySQL:

Abrir o DBeaver (ou outro cliente SQL)

Executar o arquivo:

sql/criacao_banco.sql

Isso criará todas as tabelas automaticamente.

2️⃣ Configurar Conexão

No arquivo Conexao.java, verifique:

String url = "jdbc:mysql://localhost:3306/simplelibrary";
String user = "root";
String password = "sua_senha";

Altere a senha se necessário.

3️⃣ Executar

Abrir o projeto no NetBeans e executar a classe principal.

📂 Estrutura do Projeto
simplelibrary.poo
 ├── model
 ├── dao
 ├── db
 ├── TelaPrincipal.java

model → Entidades

dao → Acesso ao banco

db → Conexão

TelaPrincipal → Interface gráfica

👨‍💻 Autor

Fabio Henrique
Projeto acadêmico – 2025.2

📌 Observações

Projeto com fins educacionais.

Banco configurado para MySQL.

Não utilizar credenciais sensíveis em produção.
