package br.com.elvisther.sga.http.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.elvisther.sga.http.resources.AgendamentoResource;
import br.com.elvisther.sga.models.Agendamento;
import br.com.elvisther.sga.services.AgendamentoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/agendamento")
public class AgendamentoController
{
    private final AgendamentoService agendamentoService;

    @GetMapping
    public ResponseEntity<List<AgendamentoResource>> viewAny()
    {
        List<AgendamentoResource> agendamentoResource = this.agendamentoService.findAll()
            .stream()
            .map(agendamento -> new AgendamentoResource(agendamento))
            .collect(Collectors.toList());

        return ResponseEntity.ok().body(agendamentoResource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResource> show(@PathVariable Long id)
    {
        AgendamentoResource agendamentoResource = new AgendamentoResource(this.agendamentoService.find(id));
        return ResponseEntity.ok().body(agendamentoResource);
    }
    
}
