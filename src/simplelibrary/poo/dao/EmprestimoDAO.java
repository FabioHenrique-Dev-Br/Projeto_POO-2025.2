package simplelibrary.poo.dao;

import simplelibrary.poo.db.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;


public class EmprestimoDAO {

    public void emprestar(int idUsuario, int idLivro) throws SQLException {

        String sqlEmprestimo = "INSERT INTO emprestimos (id_usuario, id_livro, data_emprestimo, data_prevista_devolucao, status) VALUES (?, ?, ?, ?, ?)";

        String sqlAtualizarLivro = "UPDATE livros SET status = 'EMPRESTADO' WHERE id_livro = ?";

        try (Connection conn = Conexao.conectar()) {

            // Inserir empréstimo
            try (PreparedStatement stmt = conn.prepareStatement(sqlEmprestimo)) {

                LocalDate hoje = LocalDate.now();
                LocalDate devolucaoPrevista = hoje.plusDays(7);

                stmt.setInt(1, idUsuario);
                stmt.setInt(2, idLivro);
                stmt.setDate(3, java.sql.Date.valueOf(hoje));
                stmt.setDate(4, java.sql.Date.valueOf(devolucaoPrevista));
                stmt.setString(5, "EMPRESTADO");

                stmt.executeUpdate();
            }

            // Atualizar status do livro
            try (PreparedStatement stmt2 = conn.prepareStatement(sqlAtualizarLivro)) {
                stmt2.setInt(1, idLivro);
                stmt2.executeUpdate();
            }
        }
    }
    
    public void devolver(int idEmprestimo, int idLivro) throws SQLException {

        String sqlAtualizarEmprestimo = 
            "UPDATE emprestimos SET status = 'DEVOLVIDO', data_devolucao = ? WHERE id_emprestimo = ?";

        String sqlAtualizarLivro = 
            "UPDATE livros SET status = 'DISPONIVEL' WHERE id_livro = ?";

        try (Connection conn = Conexao.conectar()) {

            // Atualizar empréstimo
            try (PreparedStatement stmt = conn.prepareStatement(sqlAtualizarEmprestimo)) {
                stmt.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
                stmt.setInt(2, idEmprestimo);
                stmt.executeUpdate();
            }

            // Atualizar livro
            try (PreparedStatement stmt2 = conn.prepareStatement(sqlAtualizarLivro)) {
                stmt2.setInt(1, idLivro);
                stmt2.executeUpdate();
            }
        }
   }

    public void devolverPorLivro(int idLivro) throws SQLException {

    String sqlAtualizarEmprestimo =
            "UPDATE emprestimos " +
            "SET status = 'DEVOLVIDO', data_devolucao = ? " +
            "WHERE id_livro = ? AND status = 'EMPRESTADO' " +
            "ORDER BY id_emprestimo DESC " +
            "LIMIT 1";

    String sqlAtualizarLivro =
            "UPDATE livros SET status = 'DISPONIVEL' WHERE id_livro = ?";

    try (Connection conn = Conexao.conectar()) {

        // Atualiza o empréstimo
        try (PreparedStatement stmt = conn.prepareStatement(sqlAtualizarEmprestimo)) {
            stmt.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
            stmt.setInt(2, idLivro);
            stmt.executeUpdate();
        }

        // Atualiza o livro
        try (PreparedStatement stmt2 = conn.prepareStatement(sqlAtualizarLivro)) {
            stmt2.setInt(1, idLivro);
            stmt2.executeUpdate();
        }
    }
}
    
}
