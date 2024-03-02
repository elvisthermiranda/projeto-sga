package br.com.elvisther.sga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elvisther.sga.models.Departamento;
import br.com.elvisther.sga.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	public List<Departamento> findAll()
	{
		return this.departamentoRepository.findAll();
	}
}
