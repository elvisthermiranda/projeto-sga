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
    private Character ativo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UnidadeResource(Unidade unidade)
    {
        this.id = unidade.getId();
        this.nome = unidade.getNome();
        this.descricao = unidade.getDescricao();
        this.ativo = unidade.getAtivo();
        this.createdAt = unidade.getCreatedAt();
        this.updatedAt = unidade.getUpdatedAt();
    }
}
