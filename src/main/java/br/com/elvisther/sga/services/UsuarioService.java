package br.com.elvisther.sga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elvisther.sga.models.Usuario;
import br.com.elvisther.sga.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll()
	{
		return this.usuarioRepository.findAll();
	}
	
	public Usuario findById(Long id) throws Exception
	{
		return this.usuarioRepository.findById(id)
					.orElseThrow(() -> new Exception("Usuário não encontrado."));
	}
}
