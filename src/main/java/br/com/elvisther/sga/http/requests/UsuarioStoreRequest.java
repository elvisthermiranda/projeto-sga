package br.com.elvisther.sga.http.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class UsuarioStoreRequest {
	
	@NotNull
	@NotBlank
	private String nome;
	
	@Email
	private String email;
	
	@NotBlank
	private String senha;
}
