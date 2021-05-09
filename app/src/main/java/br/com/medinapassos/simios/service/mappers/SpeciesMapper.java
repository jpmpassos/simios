package br.com.medinapassos.simios.service.mappers;

import br.com.medinapassos.simios.commons.dto.SpeciesDto;
import br.com.medinapassos.simios.commons.dto.StatsResponseDto;
import br.com.medinapassos.simios.persistense.dto.StatsDto;
import br.com.medinapassos.simios.persistense.entity.SpeciesEntity;

public interface SpeciesMapper {
    SpeciesEntity toEntity(SpeciesDto speciesDto);

    StatsResponseDto toStatsResponseDto(StatsDto statsDto);
}
