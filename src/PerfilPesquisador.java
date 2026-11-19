
public class PerfilPesquisador {

    private int idPerfil;
    private Usuario usuario;

    public PerfilPesquisador(int idPerfil, Usuario usuario) {

        if(usuario == null){
            throw new IllegalArgumentException(
                "O perfil precisa de um usuario."
            );
        }
        
        this.idPerfil = idPerfil;
        this.usuario = usuario;
    }

    public String getNomeUsuario() {
        if (usuario != null) {
            return usuario.getNome();
        }

        return "Nenhum usuário associado";
    }

}
