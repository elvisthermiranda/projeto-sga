package br.com.elvisther.sga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elvisther.sga.models.Agendamento;
import br.com.elvisther.sga.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public List<Agendamento> findAll()
	{
		return this.agendamentoRepository.findAll();
	}
}
