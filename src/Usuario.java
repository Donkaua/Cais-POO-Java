public class Usuario {

    private int idUsuario;
    private String nome;
    private String email;
    private boolean verificado;

    public Usuario(int idUsuario, String nome, String email) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.verificado = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

}