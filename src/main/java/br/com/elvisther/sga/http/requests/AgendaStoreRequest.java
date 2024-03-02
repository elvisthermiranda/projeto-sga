package br.com.elvisther.sga.http.requests;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AgendaStoreRequest {
	@NotBlank(message = "É obrigatório informar o mês e ano da agenda.")
	private Date mesAno;
	
	@NotBlank(message = "É obrigatório informar o serviço da agenda.")
	private Long servicoId;
	
	@NotBlank(message = "É obrigatório informar a unidade da agenda.")
	private Long unidadeId;
	
	@NotNull(message = "O status não pode ser nulo")
	@Pattern(regexp = "SIM|NAO", message = "Valor inválido para status")
	private Character ativo;
}
