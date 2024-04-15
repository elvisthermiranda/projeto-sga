package br.com.elvisther.sga.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.elvisther.sga.models.Agendamento;
import br.com.elvisther.sga.repositories.AgendamentoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AgendamentoService
{
	private final AgendamentoRepository agendamentoRepository;
	
	public List<Agendamento> findAll()
	{
		return this.agendamentoRepository.findAll();
	}
}
