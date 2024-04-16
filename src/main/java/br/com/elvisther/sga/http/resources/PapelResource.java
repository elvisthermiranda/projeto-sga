package br.com.elvisther.sga.http.resources;

import br.com.elvisther.sga.models.Papel;
import lombok.Data;

@Data
public class PapelResource
{
    private Long id;
    private String nome;
    private String descricao;

    public PapelResource(Papel papel)
    {
        this.id = papel.getId();
        this.nome = papel.getNome();
        this.descricao = papel.getDescricao();
    }
}
