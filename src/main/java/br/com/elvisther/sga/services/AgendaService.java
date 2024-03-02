package br.com.elvisther.sga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@Service
public class AgendaService {
	
	@Autowired
	private AgendaRepository agendaRepository;
	
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	public Agenda findById(Long id) throws Exception
	{
		return this.agendaRepository.findById(id)
				.orElseThrow(() -> new Exception("Agenda não encontrada."));
	}
	
	public List<Agenda> findAll()
	{
		return this.agendaRepository.findAll();
	}
	
	public Agenda create(AgendaStoreRequest request) throws Exception
	{
		Unidade unidade = this.unidadeRepository.findById(request.getUnidadeId())
				.orElseThrow(() -> new Exception("A unidade informada não existe!"));
		
		Servico servico = this.servicoRepository.findById(request.getServicoId())
				.orElseThrow(() -> new Exception("O Serviço informado não existe!"));
		
		if (this.agendaRepository.existsByUnidadeIdAndServicoIdAndMesAno(unidade.getId(), servico.getId(), request.getMesAno())) {
			throw new Exception("Já existe uma agenda para esta unidade, serviço, mês e ano.");
		}
		
		Agenda agenda = new Agenda();
		agenda.setMesAno(request.getMesAno());
		agenda.setUnidade(unidade);
		agenda.setServico(servico);
		agenda.setAtivo(Ativo.NAO.getValor());
		
		return this.agendaRepository.save(agenda);
	}
	
	public void updateStatus(Long id, AgendaUpdateRequest request) throws Exception
	{
		Agenda agenda = this.findById(id);
		
		agenda.setAtivo(Ativo.valueOf(request.getAtivo()).getValor());
		
		this.agendaRepository.save(agenda);
	}
}
