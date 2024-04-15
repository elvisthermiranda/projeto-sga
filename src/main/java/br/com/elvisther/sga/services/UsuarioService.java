package br.com.elvisther.sga.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.elvisther.sga.models.Usuario;
import br.com.elvisther.sga.repositories.UsuarioRepository;
import br.com.elvisther.sga.services.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService
{
	private final UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll()
	{
		return this.usuarioRepository.findAll();
	}
	
	public Usuario findById(Long id) throws ResourceNotFoundException
	{
		return this.usuarioRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));
	}
}
