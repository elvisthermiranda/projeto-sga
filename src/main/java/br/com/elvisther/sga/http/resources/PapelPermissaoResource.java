package br.com.elvisther.sga.http.resources;

import java.util.List;

import br.com.elvisther.sga.models.Papel;
import br.com.elvisther.sga.models.Permissao;
import lombok.Data;

@Data
public class PapelPermissaoResource
{
    private PapelResource papel;
    private List<PermissaoResource> permissao;

    public PapelPermissaoResource(Papel papel)
    {
        this.papel = new PapelResource(papel);
        papel.getPapelPermissoes().forEach((permissao) -> permissao);
    }
}
