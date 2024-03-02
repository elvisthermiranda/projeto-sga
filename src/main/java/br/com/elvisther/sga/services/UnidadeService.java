package br.com.elvisther.sga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elvisther.sga.models.Unidade;
import br.com.elvisther.sga.repositories.UnidadeRepository;

@Service
public class UnidadeService {

	@Autowired
	private UnidadeRepository unidadeRepository;
	
	public List<Unidade> findAll()
	{
		return this.unidadeRepository.findAll();
	}
}
