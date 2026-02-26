package simplelibrary.poo.dao;

import simplelibrary.poo.db.Conexao;
import simplelibrary.poo.model.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class LivroDAO {

    public void cadastrar(Livro livro) throws SQLException {
        String sql = "INSERT INTO livros (titulo, ano_publicacao, genero, id_autor, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setInt(2, livro.getAnoPublicacao());
            stmt.setString(3, livro.getGenero());
            stmt.setInt(4, livro.getIdAutor());
            stmt.setString(5, livro.getStatus());

            stmt.executeUpdate();
        }
    }
        public java.util.List<simplelibrary.poo.model.Livro> listar() throws java.sql.SQLException {

        String sql = "SELECT id_livro, titulo, genero, ano_publicacao, id_autor, status FROM livros ORDER BY id_livro";

        java.util.List<simplelibrary.poo.model.Livro> lista = new java.util.ArrayList<>();

        try (java.sql.Connection conn = simplelibrary.poo.db.Conexao.conectar();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
             java.sql.ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                int id = rs.getInt("id_livro");
                String titulo = rs.getString("titulo");
                String genero = rs.getString("genero");
                int ano = rs.getInt("ano_publicacao");
                int idAutor = rs.getInt("id_autor");
                String status = rs.getString("status");

                simplelibrary.poo.model.Livro livro =
                        new simplelibrary.poo.model.Livro(titulo, ano, genero, idAutor, status);

                // Se sua classe Livro tiver setIdLivro:
                // livro.setIdLivro(id);

                lista.add(livro);
            }
        }

        return lista;
    }
        
}


