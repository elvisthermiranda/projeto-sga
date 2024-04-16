package br.com.elvisther.sga.http.resources;

import java.sql.Date;
import java.time.LocalDateTime;

import br.com.elvisther.sga.models.Agenda;
import br.com.elvisther.sga.models.Servico;
import br.com.elvisther.sga.models.Unidade;
import lombok.Data;

@Data
public class AgendaResource
{
    private Date mes_ano;
    private UnidadeResource unidade;
    private ServicoResource servico;
    private String ativo;
    private LocalDateTime criado_em;
    private LocalDateTime ultima_atualizacao;

    public AgendaResource(Agenda agenda)
    {
        this.mes_ano = agenda.getMesAno();
        this.ativo = agenda.getAtivo() == "S" ? "Sim": "Não";
        this.criado_em = agenda.getCreatedAt();
        this.ultima_atualizacao = agenda.getUpdatedAt();
    }

    public AgendaResource(Agenda agenda, Unidade unidade, Servico servico)
    {
        this(agenda);
        this.unidade = new UnidadeResource(agenda.getUnidade());
        this.servico = new ServicoResource(agenda.getServico());
    }
}
