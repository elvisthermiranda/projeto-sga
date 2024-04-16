package br.com.elvisther.sga.http.resources;

import br.com.elvisther.sga.models.ServicoUnidade;
import lombok.Data;

@Data
public class ServicoUnidadeResource
{
    private UnidadeResource unidade;
    private DepartamentoResource departamento;
    private ServicoResource servico;
    private String sigla;
    private String ativo;

    public ServicoUnidadeResource(ServicoUnidade servicoUnidade)
    {
        this.unidade = new UnidadeResource(servicoUnidade.getUnidade());
        this.departamento = new DepartamentoResource(servicoUnidade.getDepartamento());
        this.servico = new ServicoResource(servicoUnidade.getServico());
        this.sigla = servicoUnidade.getSigla();
        this.ativo = servicoUnidade.getAtivo() == "S" ? "Sim": "Não";
    }
}
