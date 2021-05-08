package br.com.medinapassos.simios.service.impl;

import br.com.medinapassos.simios.commons.dto.ResponseDto;
import br.com.medinapassos.simios.commons.dto.SpeciesDto;
import br.com.medinapassos.simios.commons.dto.enums.TypeSpeciesEnum;
import br.com.medinapassos.simios.core.SimianProcess;
import br.com.medinapassos.simios.service.SimiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.medinapassos.simios.service.commons.SimiosHashCommon.hashGenerator;

@Service
public class SimiosServiceImpl implements SimiosService {

    @Autowired
    private SimianProcess simianProcess;

    @Override
    public ResponseDto save(final SpeciesDto speciesDto) {
        speciesDto.setTypeSpecies(simianProcess.process(speciesDto.getDna()));
        speciesDto.setId(hashGenerator(speciesDto.getDna()));
        return ResponseDto
                .builder()
                .isSimian(speciesDto.getTypeSpecies().equals(TypeSpeciesEnum.SIMIAN))
                .build();
    }
}
