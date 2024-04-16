package br.com.elvisther.sga.services;

import org.springframework.stereotype.Service;

import br.com.elvisther.sga.models.Papel;
import br.com.elvisther.sga.repositories.PapelRepository;
import br.com.elvisther.sga.services.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PapelService
{
    private final PapelRepository papelRepository;

    public Papel find(Long id)
    {
        return this.papelRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado."));
    }
}
