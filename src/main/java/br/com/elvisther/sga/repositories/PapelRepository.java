package br.com.elvisther.sga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.elvisther.sga.models.Papel;

@Repository
public interface PapelRepository extends JpaRepository<Papel, Long>
{
    
}
