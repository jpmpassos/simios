package br.com.medinapassos.simios.web.validation.impl;

import br.com.medinapassos.simios.commons.dto.SpeciesDto;
import br.com.medinapassos.simios.web.validation.SimiosValidate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static br.com.medinapassos.simios.web.validation.commons.SimiosValidateCommons.validateDNA;
import static br.com.medinapassos.simios.web.validation.commons.SimiosValidateCommons.validateLengthSize;

@Slf4j
@Component
public class SimiosValidateImpl implements SimiosValidate {

    @Override
    public void validete(final SpeciesDto speciesDto) {
        final var start = System.currentTimeMillis();
        try {
            speciesDto.getDna().forEach((dna) -> {
                validateDNA(dna);
                validateLengthSize(speciesDto.getDna().size(), dna);
            });
        } finally {
            log.info("Tempo gasto na validação do DNA = {}ms", System.currentTimeMillis() - start);
        }
    }
}
