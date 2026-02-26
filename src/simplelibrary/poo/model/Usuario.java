package simplelibrary.poo.model;

public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String status;

    public Usuario() {
    }

    public Usuario(String nome, String email, String status) {
        this.nome = nome;
        this.email = email;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   public void setIdUsuario(int idUsuario) {
    this.id = idUsuario;
}

    public Object getIdUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}