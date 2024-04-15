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

	public Usuario store()
	{
		Usuario usuario = new Usuario();
		this.usuarioRepository.save(usuario);
		return usuario;
	}

	public Usuario update(Long id) throws ResourceNotFoundException
	{
		Usuario usuario = this.findById(id);

		return usuario;
	}

	public void destroy(Long id)
	{
		Usuario usuario = this.findById(id);

		this.usuarioRepository.delete(usuario);
	}
}
