package br.com.elvisther.sga.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "servicos_unidades")
@Getter @Setter
public class ServicoUnidade
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Unidade.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Unidade unidade;

    @ManyToOne(targetEntity = Departamento.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Departamento departamento;

    @ManyToOne(targetEntity = Servico.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Servico servico;

    private String sigla;

    private String ativo;
}
