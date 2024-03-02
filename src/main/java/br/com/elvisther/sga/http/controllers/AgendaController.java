package br.com.elvisther.sga.http.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.elvisther.sga.http.resources.ResponseMessage;
import br.com.elvisther.sga.models.Agenda;
import br.com.elvisther.sga.services.AgendaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/agenda")
public class AgendaController {
	
	@Autowired
	private AgendaService agendaService;
	
	@GetMapping
	public ResponseEntity<List<Agenda>> all()
	{
		List<Agenda> agendas = this.agendaService.findAll();
		
		return ResponseEntity.ok().body(agendas);
	}
	
	@PostMapping
	public ResponseEntity<?> store(@Valid @RequestBody AgendaStoreRequest request) throws Exception
	{
		try {
			Agenda agenda = this.agendaService.create(request);
			return ResponseEntity.status(HttpStatus.CREATED).body(agenda);
		} catch (IllegalArgumentException error) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ResponseMessage(error.getMessage()));
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> show(@PathVariable Long id)
	{
		try {
			return ResponseEntity.ok().body(this.agendaService.findById(id));
		} catch (Exception error) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(error.getMessage()));
		}
	}
	
	@PutMapping("/{id}/update-status")
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody AgendaUpdateRequest request) throws Exception
	{
		try {
			this.agendaService.updateStatus(id, request);
			
			return ResponseEntity.ok().body(new ResponseMessage("Status da agenda alterada com sucesso!"));
		} catch (Exception error) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ResponseMessage(error.getMessage()));
		}
	}
}
