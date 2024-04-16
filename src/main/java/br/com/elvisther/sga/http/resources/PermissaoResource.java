package br.com.elvisther.sga.http.resources;

import br.com.elvisther.sga.models.Permissao;
import lombok.Data;

@Data
public class PermissaoResource
{
    private Long id;
    private String nome;
    private String descricao;

    public PermissaoResource(Permissao permissao)
    {
        this.id = permissao.getId();
        this.nome = permissao.getNome();
        this.descricao = permissao.getDescricao();
    }
}
