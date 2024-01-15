package es.consumo.gescom.modules.phase.repository;

import es.consumo.gescom.modules.phase.model.entity.PhaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.consumo.gescom.commons.db.repository.JJAARepository;

@Repository
public interface PhaseRepository extends JJAARepository<PhaseEntity, Long>  {

    @Query(value = "SELECT h FROM PhaseEntity h where h.id = :id ")
    Page<PhaseEntity.SimpleProjection> findAllPhaseById(Pageable pageable, @Param("id") Long id);

}
