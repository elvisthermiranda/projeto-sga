package br.com.elvisther.sga.http.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class AgendaUpdateRequest {
	@NotNull(message = "O status não pode ser nulo")
	@Pattern(regexp = "SIM|NAO", message = "Valor inválido para status")
	private Character ativo;
}
