package br.com.elvisther.sga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.elvisther.sga.models.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
