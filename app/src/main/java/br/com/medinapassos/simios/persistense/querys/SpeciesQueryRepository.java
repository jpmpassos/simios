package br.com.medinapassos.simios.persistense.querys;

import br.com.medinapassos.simios.persistense.dto.StatsDto;

import java.util.Optional;

public interface SpeciesQueryRepository {
    Optional<StatsDto> statsQuery();
}
