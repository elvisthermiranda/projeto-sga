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
    private String ativo;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public ServicoResource(Servico servico)
    {
        this.id = servico.getId();
        this.nome = servico.getNome();
        this.descricao = servico.getDescricao();
        this.ativo = servico.getAtivo() == "S" ? "Sim": "Não";
        this.created_at = servico.getCreatedAt();
        this.updated_at = servico.getUpdatedAt();
    }
}
