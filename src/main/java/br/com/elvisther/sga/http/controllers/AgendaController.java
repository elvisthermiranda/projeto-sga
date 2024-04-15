package br.com.elvisther.sga.http.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.elvisther.sga.http.requests.AgendaStoreRequest;
import br.com.elvisther.sga.http.requests.AgendaUpdateRequest;
import br.com.elvisther.sga.http.resources.AgendaResource;
import br.com.elvisther.sga.models.Agenda;
import br.com.elvisther.sga.services.AgendaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/agenda")
public class AgendaController
{
	private final AgendaService agendaService;
	
	@GetMapping
	public ResponseEntity<List<Agenda>> all()
	{
		List<Agenda> agendas = this.agendaService.findAll();
		
		return ResponseEntity.ok().body(agendas);
	}
	
	@PostMapping
	public ResponseEntity<?> store(@Valid @RequestBody AgendaStoreRequest request) throws Exception
	{
		AgendaResource resource = new AgendaResource(this.agendaService.create(request));
		return ResponseEntity.status(HttpStatus.CREATED).body(resource);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> show(@PathVariable Long id)
	{
		Agenda agenda = this.agendaService.findById(id);
		AgendaResource agendaResource =  new AgendaResource(agenda, agenda.getUnidade(), agenda.getServico());
		return ResponseEntity.ok().body(agendaResource);
	}
	
	@PutMapping("/{id}/update-status")
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody AgendaUpdateRequest request) throws Exception
	{
		this.agendaService.updateStatus(id, request);
		return ResponseEntity.ok().body("Status da agenda alterada com sucesso!");
	}
}
