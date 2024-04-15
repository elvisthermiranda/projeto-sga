package br.com.elvisther.sga.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@Table(name = "agendamentos")
@Getter @Setter
public class Agendamento
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	private String celular;
	private String cpf;
	private String nome;
	private String protocolo;
	
	@Column(name = "data_triagem")
	private LocalDateTime dataTriagem;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Horario.class)
	@JsonManagedReference
	private Horario horario;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Agenda.class)
	@JsonManagedReference
	private Agenda agenda;
}
