package br.com.elvisther.sga.http.resources;

import java.time.LocalDateTime;

import br.com.elvisther.sga.models.Agendamento;
import lombok.Data;

@Data
public class AgendamentoResource
{
    private Long id;
    private String protocolo;
    private LocalDateTime agendado_em;
    private LocalDateTime agendado_para;

    // Cliente
    private String nome;
    private String cpf;
    private String email;
    private String celular;

    // Unidade
    private String unidade;

    // Servico
    private String servico;

    public AgendamentoResource(Agendamento agendamento)
    {
        this.id = agendamento.getId();
        this.agendado_em = agendamento.getCreatedAt();
        this.protocolo = agendamento.getProtocolo();
        ClienteResource clienteResource = new ClienteResource(agendamento.getCliente());
        HorarioResource horarioResource = new HorarioResource(agendamento.getHorario());

        // Cliente
        this.nome = clienteResource.getNome();
        this.cpf = clienteResource.getCpf();
        this.email = clienteResource.getEmail();
        this.celular = clienteResource.getCelular();
        

        // Horario
        this.agendado_para = horarioResource.getAgendado_para();

        // Unidade
        this.unidade = horarioResource.getAgenda().getUnidade().getNome();

        // Servico
        this.servico = horarioResource.getAgenda().getServico().getNome();
    }
}
