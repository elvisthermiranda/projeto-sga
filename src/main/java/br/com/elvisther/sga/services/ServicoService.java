package br.com.elvisther.sga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elvisther.sga.models.Servico;
import br.com.elvisther.sga.repositories.ServicoRepository;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	public List<Servico> findAll()
	{
		return this.servicoRepository.findAll();
	}
}
