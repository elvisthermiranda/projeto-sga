package br.com.elvisther.sga.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.elvisther.sga.models.Departamento;
import br.com.elvisther.sga.repositories.DepartamentoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartamentoService
{
	private final DepartamentoRepository departamentoRepository;
	
	public List<Departamento> findAll()
	{
		return this.departamentoRepository.findAll();
	}
}
