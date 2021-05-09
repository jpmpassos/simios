package br.com.medinapassos.simios.persistense.repository;

import br.com.medinapassos.simios.persistense.entity.SpeciesEntity;
import br.com.medinapassos.simios.persistense.querys.SpeciesQueryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<SpeciesEntity, Integer>, SpeciesQueryRepository {
}
