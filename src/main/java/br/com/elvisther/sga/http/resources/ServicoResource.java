package br.com.elvisther.sga.http.resources;

import java.time.LocalDateTime;

import br.com.elvisther.sga.models.Servico;
import lombok.Data;

@Data
public class ServicoResource
{
    private Long id;
    private String nome;
    private String descricao;
    private Character ativo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ServicoResource(Servico servico)
    {
        this.id = servico.getId();
        this.nome = servico.getNome();
        this.descricao = servico.getDescricao();
        this.ativo = servico.getAtivo();
        this.createdAt = servico.getCreatedAt();
        this.updatedAt = servico.getUpdatedAt();
    }
}
