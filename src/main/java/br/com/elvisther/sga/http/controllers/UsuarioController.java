package br.com.elvisther.sga.http.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.elvisther.sga.http.resources.ResponseMessage;
import br.com.elvisther.sga.models.Usuario;
import br.com.elvisther.sga.services.UsuarioService;

@RestController
@RequestMapping(path = "/api/v1/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> all()
	{
		return ResponseEntity.ok().body(this.usuarioService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id)
	{
		try {
			return ResponseEntity.ok().body(this.usuarioService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(e.getMessage()));
		}
	}
}
