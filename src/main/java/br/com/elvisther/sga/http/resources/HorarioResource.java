package br.com.elvisther.sga.http.resources;

import java.time.LocalDateTime;

import br.com.elvisther.sga.models.Horario;
import lombok.Data;

@Data
public class HorarioResource
{
    private Long id;
    private AgendaResource agenda;
    private LocalDateTime agendado_para;

    public HorarioResource(Horario horario)
    {
        this.id = horario.getId();
        this.agenda = new AgendaResource(horario.getAgenda());
        this.agendado_para = horario.getDatahora();
    }
}
