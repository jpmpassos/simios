package br.com.medinapassos.simios.service.mappers.impl;

import br.com.medinapassos.simios.commons.dto.SpeciesDto;
import br.com.medinapassos.simios.commons.dto.StatsResponseDto;
import br.com.medinapassos.simios.persistense.dto.StatsDto;
import br.com.medinapassos.simios.persistense.entity.SpeciesEntity;
import br.com.medinapassos.simios.service.mappers.SpeciesMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.util.Objects.isNull;

@Component
public class SpeciesMapperImpl implements SpeciesMapper {
    @Override
    public SpeciesEntity toEntity(final SpeciesDto speciesDto) {
        if (isNull(speciesDto))
            return null;

        return SpeciesEntity.builder()
                .dna(speciesDto.getDna())
                .build();
    }

    @Override
    public StatsResponseDto toStatsResponseDto(final StatsDto statsDto) {

        final BigDecimal ratio = BigDecimal.valueOf(
                statsDto.getCountSimianDna().intValue())
                .multiply(BigDecimal.valueOf(100))
                .divide(BigDecimal.valueOf(statsDto.getCountHumanDna().intValue()), 2, RoundingMode.HALF_UP);

        return StatsResponseDto.builder()
                .countHumanDna(statsDto.getCountHumanDna())
                .countSimianDna(statsDto.getCountSimianDna())
                .ratio(ratio)
                .build();
    }
}
