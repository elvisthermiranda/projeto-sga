package br.com.elvisther.sga.http.resources;

import br.com.elvisther.sga.models.Cliente;
import lombok.Data;

@Data
public class ClienteResource
{
    private Long id;
    private String nome;
    private String cpf;
    private String celular;
    private String email;

    public ClienteResource(Cliente cliente)
    {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.celular = cliente.getCelular();
        this.email = cliente.getEmail();
    }
}
