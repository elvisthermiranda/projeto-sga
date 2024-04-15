package br.com.elvisther.sga.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.elvisther.sga.models.Unidade;
import br.com.elvisther.sga.repositories.UnidadeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UnidadeService
{
	private final UnidadeRepository unidadeRepository;
	
	public List<Unidade> findAll()
	{
		return this.unidadeRepository.findAll();
	}
}
