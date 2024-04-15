package br.com.elvisther.sga.http.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.elvisther.sga.models.Usuario;
import br.com.elvisther.sga.services.UsuarioService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/usuario")
public class UsuarioController
{
	private final UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> all()
	{
		return ResponseEntity.ok().body(this.usuarioService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id)
	{
		return ResponseEntity.ok().body(this.usuarioService.findById(id));
	}
}
