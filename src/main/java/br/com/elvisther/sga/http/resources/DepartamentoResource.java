package br.com.elvisther.sga.http.resources;

import java.time.LocalDateTime;

import br.com.elvisther.sga.models.Departamento;
import lombok.Data;

@Data
public class DepartamentoResource
{
    private Long id;
    private String nome;
    private String descricao;
    private String ativo;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public DepartamentoResource(Departamento departamento)
    {
        this.id = departamento.getId();
        this.nome = departamento.getNome();
        this.descricao = departamento.getDescricao();
        this.ativo = departamento.getAtivo() == 'S' ? "Sim": "Não";
        this.created_at = departamento.getCreatedAt();
        this.updated_at = departamento.getUpdatedAt();
    }
}
