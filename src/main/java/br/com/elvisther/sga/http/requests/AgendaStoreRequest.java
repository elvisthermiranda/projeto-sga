package br.com.elvisther.sga.http.requests;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AgendaStoreRequest
{
	@NotNull(message = "É obrigatório informar o mês e ano da agenda.")
	private Date mesAno;
	
	@NotNull(message = "É obrigatório informar o serviço da agenda.")
	private Long servicoId;
	
	@NotNull(message = "É obrigatório informar a unidade da agenda.")
	private Long unidadeId;
	
	@NotNull(message = "O status não pode ser nulo.")
	@Pattern(regexp = "S|N|s|n", message = "Valor inválido para status.")
	private String ativo;
}
