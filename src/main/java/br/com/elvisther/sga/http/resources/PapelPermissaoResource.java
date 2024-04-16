package br.com.elvisther.sga.http.resources;

import java.util.List;
import java.util.stream.Collectors;

import br.com.elvisther.sga.models.Papel;
import br.com.elvisther.sga.models.PapelPermissao;
import lombok.Data;

@Data
public class PapelPermissaoResource
{
    private PapelResource papel;
    private List<PermissaoResource> permissoes;

    public PapelPermissaoResource(Papel papel)
    {
        this.papel = new PapelResource(papel);
        this.permissoes = papel.getPapelPermissoes()
                                .stream()
                                .map(PapelPermissao::getPermissao)
                                .map(PermissaoResource::new)
                                .collect(Collectors.toList());
    }
}
