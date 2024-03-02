package br.com.elvisther.sga.models;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "papeis")
public class Papel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String descricao;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "papel")
	@JsonBackReference
	private List<PapelPermissao> papelPermissoes;
	
	public List<Permissao> getPermissoes()
	{
		return this.papelPermissoes.stream()
					.map(PapelPermissao::getPermissao)
					.collect(Collectors.toList());
	}
	
	public Boolean temPermissao(String nome)
	{
		return this.getPermissoes().stream()
			.anyMatch(permissao -> permissao.getNome().equals(nome));
	}
}
