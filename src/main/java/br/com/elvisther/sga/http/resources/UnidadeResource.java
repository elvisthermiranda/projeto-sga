package br.com.elvisther.sga.http.resources;

import java.time.LocalDateTime;

import br.com.elvisther.sga.models.Unidade;
import lombok.Data;

@Data
public class UnidadeResource
{
    private Long id;
    private String nome;
    private String descricao;
    private String ativo;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public UnidadeResource(Unidade unidade)
    {
        this.id = unidade.getId();
        this.nome = unidade.getNome();
        this.descricao = unidade.getDescricao();
        this.ativo = unidade.getAtivo() == 'S' ? "Sim": "Não";
        this.created_at = unidade.getCreatedAt();
        this.updated_at = unidade.getUpdatedAt();
    }
}
