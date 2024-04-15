package br.com.elvisther.sga.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.elvisther.sga.models.Servico;
import br.com.elvisther.sga.repositories.ServicoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServicoService
{
	private final ServicoRepository servicoRepository;
	
	public List<Servico> findAll()
	{
		return this.servicoRepository.findAll();
	}
}
