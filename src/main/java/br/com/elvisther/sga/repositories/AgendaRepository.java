package br.com.elvisther.sga.repositories;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.elvisther.sga.models.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
	
	@Query("SELECT COUNT(a) > 0 FROM Agenda a WHERE a.unidade.id = :unidadeId AND a.servico.id = :servicoId AND a.mesAno = :mesAno")
	Boolean existsByUnidadeIdAndServicoIdAndMesAno(
				@Param("unidadeId") Long unidadeId,
				@Param("servicoId") Long servicoId,
				@Param("mesAno") Date mesAno
			);
}
