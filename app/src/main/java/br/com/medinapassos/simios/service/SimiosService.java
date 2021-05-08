package br.com.medinapassos.simios.service;

import br.com.medinapassos.simios.commons.dto.ResponseDto;
import br.com.medinapassos.simios.commons.dto.SpeciesDto;

public interface SimiosService {
    ResponseDto save(SpeciesDto speciesDto);
}
