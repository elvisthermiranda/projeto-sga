package br.com.elvisther.sga.http.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.elvisther.sga.http.resources.PapelPermissaoResource;
import br.com.elvisther.sga.services.PapelService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/papel")
public class PapelController
{
    private final PapelService papelService;

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Long id)
    {
        PapelPermissaoResource papelResource = new PapelPermissaoResource(this.papelService.find(id));
        return ResponseEntity.ok().body(papelResource);
    }
}
