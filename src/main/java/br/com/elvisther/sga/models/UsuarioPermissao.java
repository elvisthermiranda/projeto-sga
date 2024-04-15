package br.com.elvisther.sga.models;

import java.io.Serializable;

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
@Table(name = "usuario_permissoes")
@Getter @Setter
public class UsuarioPermissao implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Usuario.class)
	@JsonManagedReference
	private Usuario usuario;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Permissao.class)
	@JsonManagedReference
	private Permissao permissao;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Unidade.class)
	@JsonManagedReference
	private Unidade unidade;
}
