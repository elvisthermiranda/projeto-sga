package br.com.elvisther.sga.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.elvisther.sga.models.Unidade;
import br.com.elvisther.sga.repositories.UnidadeRepository;
import br.com.elvisther.sga.services.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UnidadeService
{
	private final UnidadeRepository unidadeRepository;

	public void destroy(Long id) throws ResourceNotFoundException
	{
		Unidade unidade = this.find(id);

		this.unidadeRepository.delete(unidade);
	}

	public Unidade find(Long id) throws ResourceNotFoundException
	{
		return this.unidadeRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Unidade não encontrada."));
	}

	public List<Unidade> findAll()
	{
		return this.unidadeRepository.findAll();
	}

	public Unidade store()
	{
		Unidade unidade = new Unidade();

		this.unidadeRepository.save(unidade);

		return unidade;
	}

	public Unidade update(Long id) throws ResourceNotFoundException
	{
		Unidade unidade = this.unidadeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));

		this.unidadeRepository.save(unidade);

		return unidade;
	}
}
