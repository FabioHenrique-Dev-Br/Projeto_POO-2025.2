package simplelibrary.poo.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import simplelibrary.poo.db.Conexao;
import simplelibrary.poo.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    public void cadastrar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, email, status) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getStatus());

            stmt.executeUpdate();
        }
    }
    public List<Usuario> listar() throws SQLException {
    String sql = "SELECT id_usuario, nome, email, status FROM usuarios ORDER BY id_usuario";

    List<Usuario> lista = new ArrayList<>();

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getInt("id_usuario"));
            u.setNome(rs.getString("nome"));
            u.setEmail(rs.getString("email"));
            u.setStatus(rs.getString("status"));
            lista.add(u);
        }
    }

    return lista;
}
        
}