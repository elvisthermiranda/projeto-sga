package br.com.elvisther.sga.http.resources;

import br.com.elvisther.sga.models.Usuario;
import lombok.Data;

@Data
public class UsuarioResource
{
    private Long id;
    private String nome;
    private String email;

    public UsuarioResource(Usuario usuario)
    {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }
}
