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
    private Date mesAno;
    private UnidadeResource unidade;
    private ServicoResource servico;
    private String ativo;
    private LocalDateTime criadoEm;
    private LocalDateTime ultimaAtualizacao;

    public AgendaResource(Agenda agenda)
    {
        this.mesAno = agenda.getMesAno();
        this.ativo = agenda.getAtivo();
        this.criadoEm = agenda.getCreatedAt();
        this.ultimaAtualizacao = agenda.getUpdatedAt();
    }

    public AgendaResource(Agenda agenda, Unidade unidade, Servico servico)
    {
        this(agenda);
        this.unidade = new UnidadeResource(agenda.getUnidade());
        this.servico = new ServicoResource(agenda.getServico());
    }
}
