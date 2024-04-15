package br.com.elvisther.sga.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.elvisther.sga.enums.Ativo;
import br.com.elvisther.sga.http.requests.AgendaStoreRequest;
import br.com.elvisther.sga.http.requests.AgendaUpdateRequest;
import br.com.elvisther.sga.models.Agenda;
import br.com.elvisther.sga.models.Servico;
import br.com.elvisther.sga.models.Unidade;
import br.com.elvisther.sga.repositories.AgendaRepository;
import br.com.elvisther.sga.repositories.ServicoRepository;
import br.com.elvisther.sga.repositories.UnidadeRepository;
import br.com.elvisther.sga.services.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AgendaService
{
	private final AgendaRepository agendaRepository;
	private final UnidadeRepository unidadeRepository;
	private final ServicoRepository servicoRepository;
	
	public Agenda findById(Long id) throws ResourceNotFoundException
	{
		return this.agendaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Agenda não encontrada."));
	}
	
	public List<Agenda> findAll()
	{
		return this.agendaRepository.findAll();
	}
	
	public Agenda create(AgendaStoreRequest request) throws ResourceNotFoundException
	{
		Unidade unidade = this.unidadeRepository.findById(request.getUnidadeId())
				.orElseThrow(() -> new ResourceNotFoundException("A unidade informada não existe!"));
		
		Servico servico = this.servicoRepository.findById(request.getServicoId())
				.orElseThrow(() -> new ResourceNotFoundException("O Serviço informado não existe!"));
		
		if (this.agendaRepository.existsByUnidadeIdAndServicoIdAndMesAno(unidade.getId(), servico.getId(), request.getMesAno())) {
			throw new ResourceNotFoundException("Já existe uma agenda para esta unidade, serviço, mês e ano.");
		}
		
		Agenda agenda = new Agenda();
		agenda.setMesAno(request.getMesAno());
		agenda.setUnidade(unidade);
		agenda.setServico(servico);
		agenda.setAtivo(Ativo.NAO.getValor());
		
		return this.agendaRepository.save(agenda);
	}
	
	public void updateStatus(Long id, AgendaUpdateRequest request) throws ResourceNotFoundException
	{
		Agenda agenda = this.findById(id);
		
		agenda.setAtivo(Ativo.valueOf(request.getAtivo()).getValor());
		
		this.agendaRepository.save(agenda);
	}
}
