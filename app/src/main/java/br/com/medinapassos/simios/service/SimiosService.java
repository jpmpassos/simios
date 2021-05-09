package br.com.medinapassos.simios.service;

import br.com.medinapassos.simios.commons.dto.ResponseDto;
import br.com.medinapassos.simios.commons.dto.SpeciesDto;
import br.com.medinapassos.simios.commons.dto.StatsResponseDto;

public interface SimiosService {
    ResponseDto save(SpeciesDto speciesDto);

    StatsResponseDto getStats();
}
